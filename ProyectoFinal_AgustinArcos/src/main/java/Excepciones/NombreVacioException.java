package Excepciones;
/**
 * Clase que modela una excepción cuando no hay ningún nombre introducido.
 *
 * @author Agustín Arcos
 */

public class NombreVacioException extends Exception{
	/**
     * Constructor que recibe un mensaje de excepción
     *
     * @param msg mensaje que se lanza cuando se produce la excepción
     */
	public NombreVacioException(String msg){
        super(msg);
    }

}
