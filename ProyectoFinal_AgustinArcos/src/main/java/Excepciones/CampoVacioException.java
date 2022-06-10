package Excepciones;
/**
 * Clase que modela una excepción cuando un campo está vacío.
 *
 * @author Agustín Arcos
 */

public class CampoVacioException extends Exception{
	/**
     * Constructor que recibe un mensaje de excepción
     *
     * @param msg mensaje que se lanza cuando se produce la excepción
     */
	public CampoVacioException(String msg){
        super(msg);
	}
}
