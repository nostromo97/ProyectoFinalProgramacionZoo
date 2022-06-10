package Clases;

import Superclases.EntidadConNombre;
/**
 * Clase que contiene un cuidado que extiende de la superclase EntidadConNombre.
 * 
 * @author Agustín Arcos
 *
 */
public class Cuidados extends EntidadConNombre{
	/**
	 * Variable de tipo String que contiene la descripción del tratamiento para el animal.
	 */
	private String descripcionTratamiento;
	/**
	 * Variable numérica de tipo short que muestra la duración del tratamiento.
	 */
	private short duracionTratamiento;
	
	/**
	 * Constructor de la clase Cuidado.
	 * 
	 * @param nombre Variable de tipo String que contiene el nombre del cuidado.
	 * @param descripcionTratamiento Variable de tipo String que contiene la descripción del tratamiento para el animal.
	 * @param duracionTratamiento Variable numérica de tipo short que muestra la duración del tratamiento.
	 */
	public Cuidados(String nombre, String descripcionTratamiento, short duracionTratamiento) {
		super(nombre);
		this.descripcionTratamiento = descripcionTratamiento;
		this.duracionTratamiento = duracionTratamiento;
	}
	/**
	 * Función que devuelve la descripción del tratamiento.
	 * @return La descripción del tratamiento.
	 */
	public String getDescripcionTratamiento() {
		return descripcionTratamiento;
	}
	/**
	 * Función que devuelve la descripción del tratamiento.
	 * @return descripción de tratamiento del objeto.
	 */
	public void setDescripcionTratamiento(String descripcionTratamiento) {
		this.descripcionTratamiento = descripcionTratamiento;
	}
	/**
	 * Función que devuelve la duración del tratamiento.
	 * @return La duración del tratamiento.
	 */ short getDuracionTratamiento() {
		return duracionTratamiento;
	}
		/**
		 * Función que devuelve la duración del tratamiento.
		 * @return duración de tratamiento del objeto.
		 */
	public void setDuracionTratamiento(short duracionTratamiento) {
		this.duracionTratamiento = duracionTratamiento;
	}
	

	
	
}
