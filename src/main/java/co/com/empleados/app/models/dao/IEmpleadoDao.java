package co.com.empleados.app.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import co.com.empleados.app.models.entity.Empleado;
@Repository
public interface IEmpleadoDao extends PagingAndSortingRepository<Empleado, Long> {
	//@Query("select salario_base from empresa.empleados where    year(fecha_ingreso) >='2019' and month(fecha_ingreso)=5 and salario_base >0")
	@Query(value = "select salario_base from empleados where id=?1 e.salario_base>?2 ", nativeQuery = true)
	public Double calcularSalarioEmpleado(Long id, int mes, int anio);

}
