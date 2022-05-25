package Clases;

import Superclases.EntidadConNombre;

public class Cuidados extends EntidadConNombre{

	private String descripcionTratamiento;
	private short duracionTratamiento;
	
	public Cuidados(String nombre, String descripcionTratamiento, short duracionTratamiento) {
		super(nombre);
		this.descripcionTratamiento = descripcionTratamiento;
		this.duracionTratamiento = duracionTratamiento;
	}

	public String getDescripcionTratamiento() {
		return descripcionTratamiento;
	}

	public void setDescripcionTratamiento(String descripcionTratamiento) {
		this.descripcionTratamiento = descripcionTratamiento;
	}

	public short getDuracionTratamiento() {
		return duracionTratamiento;
	}

	public void setDuracionTratamiento(short duracionTratamiento) {
		this.duracionTratamiento = duracionTratamiento;
	}
	

	
	
}
