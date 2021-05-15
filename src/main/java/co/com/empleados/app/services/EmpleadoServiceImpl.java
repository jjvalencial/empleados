package co.com.empleados.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.empleados.app.models.dao.IEmpleadoDao;
import co.com.empleados.app.models.entity.Empleado;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{
	@Autowired
	public IEmpleadoDao iEmpleadoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Empleado> findAll() {
		return (List<Empleado>) iEmpleadoDao.findAll();
	}

	@Override
	public Empleado save(Empleado empleado) {
		return iEmpleadoDao.save(empleado);
	}

	@Override
	@Transactional(readOnly = true)
	public Empleado findById(Long id) {
		return iEmpleadoDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		iEmpleadoDao.deleteById(id);
		
	}

	@Override
	public Double calcularSalarioEmpleado(Long id, int mes, int anio) {
		return iEmpleadoDao.calcularSalarioEmpleado(id, mes, anio);
	}



}
