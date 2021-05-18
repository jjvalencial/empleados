package co.com.empleados.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.empleados.app.models.entity.Empleado;
@Repository
public interface IEmpleadoDao extends PagingAndSortingRepository<Empleado, Long> {
	
	@Query(value = "{call sp_calcularSalario(:idIn,:mesIn,:anioIn,:salarioOut)}", nativeQuery = true)
	public Double calcularSalarioEmpleado(@Param("idIn") Long id, @Param("mesIn") int mes, @Param("anioIn") int anio, @Param("salarioOut") Double salario );
	
	@Query(value="{call lista_procedure()}", nativeQuery=true)
	public List<Empleado>listar();

}
