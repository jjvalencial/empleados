package co.com.empleados.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="empleados")
public class Empleado  implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "El nombre no puede ser vacio")
	private String nombres;
	private String apellidos;
	@NotNull(message="El salario no puede ser nulo")
	@Column(name="salario_base")
	private Double salarioBase;
	@NotNull(message="la fecha de ingreso no puede ser nula")
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ingreso")
	private Date fechaIngrso;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="fecha_retiro")
	private Date fechaRetiro;
	
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4016644552024812460L;




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getNombres() {
		return nombres;
	}




	public void setNombres(String nombres) {
		this.nombres = nombres;
	}




	public String getApellidos() {
		return apellidos;
	}




	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}




	public Date getFechaIngrso() {
		return fechaIngrso;
	}




	public void setFechaIngrso(Date fechaIngrso) {
		this.fechaIngrso = fechaIngrso;
	}




	public Date getFechaRetiro() {
		return fechaRetiro;
	}




	public void setFechaRetiro(Date fechaRetiro) {
		this.fechaRetiro = fechaRetiro;
	}




	public Double getSalarioBase() {
		return salarioBase;
	}




	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}
	
	
}
