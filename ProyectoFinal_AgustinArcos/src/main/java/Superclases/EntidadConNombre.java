package Superclases;

import Excepciones.FechaFormatoException;
import Excepciones.NombreInvalidoException;
import Excepciones.NombreVacioException;
/**
 * Clase que modela una entidad con nombre.
 * @author Agustín Arcos
 *
 */
public class EntidadConNombre {
	/**
	 * Cadena de caracteres que contiene un nombre.  
	 */
	private String nombre;
	/**
	 * Constructor de la superclase EntidadConNombre
	 * @param nombre Cadena de caracteres que contiene un nombre.  
	 */
	public EntidadConNombre(String nombre) {
		super();
		this.nombre = nombre;
	}
	/**
	 * Función que devuelve el nombre.
	 * @return El nombre.
	 */		
	public String getNombre() {
		return nombre;
	}
	/**
	 * Función que establece una nuevo nombre.
	 * @param nombre Nuevo valor para el nombre.
	 * @throws NombreVacioException Excepción que se lanza cuando el campo del nombre está vacío..
	 */
	public void setNombre(String nombre) throws NombreVacioException {
		if(nombre.isBlank()) {
			throw new NombreVacioException("Error. El Nombre no puede estar vacío.");
		}else {
			this.nombre=nombre;
		}
	}
	
	
}
