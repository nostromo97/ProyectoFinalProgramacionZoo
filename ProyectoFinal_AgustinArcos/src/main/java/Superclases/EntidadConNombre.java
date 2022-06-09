package Superclases;

import Excepciones.NombreVacioException;

public class EntidadConNombre {

	private String nombre;

	public EntidadConNombre(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws NombreVacioException {
		if(nombre.isBlank()) {
			throw new NombreVacioException("Error. El Nombre no puede estar vacío.");
		}else {
			this.nombre=nombre;
		}
	}
	
	
}
