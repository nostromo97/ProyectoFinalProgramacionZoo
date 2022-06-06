package Superclases;

import java.time.LocalDate;


import Excepciones.IdInvalidoException;
import Excepciones.IdVacioException;
import Excepciones.NombreInvalidoException;
import Excepciones.NombreVacioException;

public class  EntidadConIdFechaYNombre  {
	
	private short id;
	private LocalDate fechaNacimiento;
	private String nombre;
	
	public EntidadConIdFechaYNombre(short id, LocalDate fechaNacimiento, String nombre) 
			throws NombreVacioException,NombreInvalidoException, IdInvalidoException, IdVacioException{
		super();
		this.setId(id);
		this.fechaNacimiento = fechaNacimiento;
		this.setNombre(nombre);
	}
	
	
	
	public EntidadConIdFechaYNombre(LocalDate fechaNacimiento, String nombre) {
		super();
		this.fechaNacimiento = fechaNacimiento;
		this.nombre = nombre;
	}



	public short getId() {
		return id;
	}
	public void setId(short id) throws IdVacioException, IdInvalidoException{
		
			this.id=id;
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
