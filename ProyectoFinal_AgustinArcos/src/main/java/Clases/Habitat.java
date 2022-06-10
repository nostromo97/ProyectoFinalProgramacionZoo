package Clases;

import Superclases.EntidadConNombre;
/**
 * Clase que contiene un objeto de tipo Habitat que extiende de la superclase EntidadConNombre.
 * @author Agustín Arcos
 *
 */
public class Habitat extends EntidadConNombre{
	/**
	 * Cadena de caracteres que contiene el nombre del habitat.
	 */
	private String tipo;
/**
 * Constructor de la clase Habitat.
 * @param nombre Cadena de caracteres que contiene el nombre del habitat.
 * @param tipo Cadena de caracteres que contiene el tipo de habitat.
 */
	public Habitat(String nombre, String tipo) {
		super(nombre);
		this.tipo = tipo;
	}
	/**
	 * Función que devuelve el tipo de habitat
	 * @return tipo de habitat del objeto
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * Función que establece un tipo de habitat al objeto.
	 * @param tipo Tipo de habitat.
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}
