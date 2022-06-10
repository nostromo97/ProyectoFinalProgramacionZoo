package Excepciones;
/**
 * Clase que modela una excepción cuando un nombre introducido no es válido.
 *
 * @author Agustín Arcos
 */

public class NombreInvalidoException extends Exception{

	public NombreInvalidoException(String msg){
		/**
	     * Constructor que recibe un mensaje de excepción
	     *
	     * @param msg mensaje que se lanza cuando se produce la excepción
	     */
        super(msg);
    }
	
}
