package co.com.empleados.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.empleados.app.exception.BadRequestExceptions;
import co.com.empleados.app.models.dao.IEmpleadoDao;
import co.com.empleados.app.models.entity.Empleado;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{
	@Autowired
	public IEmpleadoDao iEmpleadoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Empleado> findAll() {
		return (List<Empleado>) iEmpleadoDao.listar();
	}

	@Override
	public Empleado save(Empleado empleado) {
		validarCampos(empleado);
		return iEmpleadoDao.save(empleado);
	}

	@Override
	@Transactional(readOnly = true)
	public Empleado findById(Long id) {
		if(id==null || id<=0 ) {
			throw new BadRequestExceptions("El id no es válido");
		}
		return iEmpleadoDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		if(id==null || id<=0 ) {
			throw new BadRequestExceptions("El id no es válido");
		}
		iEmpleadoDao.deleteById(id);
		
	}

	@Override
	public Double calcularSalarioEmpleado(Long id, int mes, int anio) {
		
		if(id==null || mes<=0 || anio<=0) {
			throw new BadRequestExceptions("El id, mes y anio son requeridos para el consumo del servicio");
		}
		return iEmpleadoDao.calcularSalarioEmpleado(id, mes, anio);
	}

	public void validarCampos(Empleado empleado) {
		if(empleado.getNombres()== null || empleado.getNombres().isEmpty()) {
			throw new BadRequestExceptions("El nombre es requerido");
			
		}if(empleado.getApellidos()== null || empleado.getApellidos().isEmpty()) {
			throw new BadRequestExceptions("El apellido es requerido");
			
		}if(empleado.getSalarioBase()==null || empleado.getSalarioBase()<=0) {
			throw new BadRequestExceptions("El salario no es valido");
		}
		if(empleado.getFechaIngrso()==null ) {
			throw new BadRequestExceptions("La fecha no es valida debe ser este formato 2021-05-13");
		}
	}

	@Override
	public List<Empleado> listar() {
		// TODO Auto-generated method stub
		return null;
	}
}
