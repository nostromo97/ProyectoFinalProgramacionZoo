package Clases;

import Superclases.EntidadConNombre;

public class Habitat extends EntidadConNombre{

	private String tipo;

	public Habitat(String nombre, String tipo) {
		super(nombre);
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}
