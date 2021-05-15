package co.com.empleados.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.com.empleados.app.models.entity.Empleado;
import co.com.empleados.app.services.IEmpleadoService;

@RestController
@RequestMapping("/api")
public class EmpleadoRestController {
	@Autowired
	private IEmpleadoService iEmpleadoService;
	
	@GetMapping("listar")
	public List<Empleado>listarEmpleado(){
		return iEmpleadoService.findAll();
	}
	@GetMapping("/empleado/{id}")
	public Empleado buscarEmpleado(@PathVariable Long id) {
		return iEmpleadoService.findById(id);
	}
	@PostMapping("/empleados")
	@ResponseStatus(HttpStatus.CREATED)
	public Empleado save(@RequestBody Empleado empleado) {
		return iEmpleadoService.save(empleado);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void eliminar(@PathVariable long id) {
		iEmpleadoService.delete(id);
		
	}
	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Empleado editar(@RequestBody Empleado empleado, @PathVariable Long id) {
		Empleado empleadoDb=iEmpleadoService.findById(id);
		empleadoDb.setApellidos(empleado.getApellidos());
		empleadoDb.setNombres(empleado.getNombres());
		empleadoDb.setFechaRetiro(empleado.getFechaRetiro());
		empleadoDb.setSalarioBase(empleado.getSalarioBase());
		return iEmpleadoService.save(empleadoDb);
		
	}
	
	
	@PostMapping("/calcular/{id}/{mes}/{anio}")
	public Double calcularSalario(@PathVariable  Long id, @PathVariable int mes,@PathVariable int anio) {
		return iEmpleadoService.calcularSalarioEmpleado(id, mes, anio);
	}
	

}
