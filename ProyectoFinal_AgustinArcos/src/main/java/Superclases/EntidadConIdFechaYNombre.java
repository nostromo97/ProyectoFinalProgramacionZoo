package Superclases;

import java.time.LocalDate;

public class  EntidadConIdFechaYNombre  {
	
	private String id;
	private LocalDate fechaNacimiento;
	private String nombre;
	
	public EntidadConIdFechaYNombre(String id, LocalDate fechaNacimiento, String nombre) {
		super();
		this.id = id;
		this.fechaNacimiento = fechaNacimiento;
		this.nombre = nombre;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
}
