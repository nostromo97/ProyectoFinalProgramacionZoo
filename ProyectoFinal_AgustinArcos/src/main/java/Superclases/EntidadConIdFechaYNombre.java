package Superclases;

import java.time.LocalDate;


import Excepciones.IdInvalidoException;
import Excepciones.IdVacioException;
import Excepciones.NombreInvalidoException;
import Excepciones.NombreVacioException;

public class  EntidadConIdFechaYNombre  {
	
	private String id;
	private LocalDate fechaNacimiento;
	private String nombre;
	
	public EntidadConIdFechaYNombre(String id, LocalDate fechaNacimiento, String nombre) 
			throws NombreVacioException,NombreInvalidoException, IdInvalidoException, IdVacioException{
		super();
		this.setId(id);
		this.fechaNacimiento = fechaNacimiento;
		this.setNombre(nombre);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) throws IdVacioException, IdInvalidoException{
		if(id == "") {
			throw new IdVacioException ("Error. ID no puede estar vacío.");
		}else {
			this.id = id;
		}
		if(id != id) {
			throw new IdInvalidoException ("Error. ID incorrecto.");
		}else {
			this.id=id;
		}
		
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
	public void setNombre (String nombre) throws NombreVacioException,NombreInvalidoException{
		
		if(nombre == "") {
			throw new NombreVacioException("Error. El Nombre no puede estar vacío.");
		}else {
			this.nombre=nombre;
		}
		if(nombre.matches("[0-9]+")) {
			throw new NombreInvalidoException ("Error. El nombre no puede contener números.");
		}
		this.nombre = nombre;
	}
	
	
	
	
}
