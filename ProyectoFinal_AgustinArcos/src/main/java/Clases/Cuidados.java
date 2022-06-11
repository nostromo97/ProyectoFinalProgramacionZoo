package Clases;

import Superclases.EntidadConNombre;
/**
 * Clase que contiene un cuidado que extiende de la superclase EntidadConNombre.
 * 
 * @author Agust�n Arcos
 *
 */
public class Cuidados extends EntidadConNombre{
	/**
	 * Variable de tipo String que contiene la descripci�n del tratamiento para el animal.
	 */
	private String descripcionTratamiento;
	/**
	 * Variable num�rica de tipo short que muestra la duraci�n del tratamiento.
	 */
	private short duracionTratamiento;
	
	/**
	 * Constructor de la clase Cuidado.
	 * 
	 * @param nombre Variable de tipo String que contiene el nombre del cuidado.
	 * @param descripcionTratamiento Variable de tipo String que contiene la descripci�n del tratamiento para el animal.
	 * @param duracionTratamiento Variable num�rica de tipo short que muestra la duraci�n del tratamiento.
	 */
	public Cuidados(String nombre, String descripcionTratamiento, short duracionTratamiento) {
		super(nombre);
		this.descripcionTratamiento = descripcionTratamiento;
		this.duracionTratamiento = duracionTratamiento;
	}
	/**
	 * Funci�n que devuelve la descripci�n del tratamiento.
	 * @return La descripci�n del tratamiento.
	 */
	public String getDescripcionTratamiento() {
		return descripcionTratamiento;
	}
	/**
	 * Funci�n que devuelve la descripci�n del tratamiento.
	 * @param descripcionTratamiento Nueva descripci�n del tratamiento.
	 */
	public void setDescripcionTratamiento(String descripcionTratamiento) {
		this.descripcionTratamiento = descripcionTratamiento;
	}
	/**
	 * Funci�n que devuelve la duraci�n del tratamiento.
	 * @return La duraci�n del tratamiento.
	 */ short getDuracionTratamiento() {
		return duracionTratamiento;
	}
		/**
		 * Funci�n que devuelve la duraci�n del tratamiento.
		 * @param setDuracionTratamiento Nuevo par�metro que estblace una nueva duraci�n del tratamiento.
		 */
	public void setDuracionTratamiento(short duracionTratamiento) {
		this.duracionTratamiento = duracionTratamiento;
	}
	

	
	
}
