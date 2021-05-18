package co.com.empleados.app.services;

import java.util.List;

import co.com.empleados.app.models.entity.Empleado;

public interface IEmpleadoService {
	public List<Empleado> findAll();
	public Empleado save(Empleado empleado);
	public Empleado findById(Long id);
	public void delete(Long id);
	public Double calcularSalarioEmpleado(Long id, int mes, int anio, Double salario);
	public List<Empleado>listar();

}
