package Excepciones;

/**
 * Clase que modela una excepción cuando una contraseña no es válida.
 *
 * @author Agustín Arcos
 */


public class ContrasenaInvalidaException extends Exception{
	/**
     * Constructor que recibe un mensaje de excepción
     *
     * @param msg mensaje que se lanza cuando se produce la excepción
     */
	
	public ContrasenaInvalidaException(String msg){
        super(msg);
    }

}
