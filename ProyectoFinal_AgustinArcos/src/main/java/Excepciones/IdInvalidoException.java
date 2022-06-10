package Excepciones;
/**
 * Clase que modela una excepción cuando id introducido no es correcto.
 *
 * @author Agustín Arcos
 */

public class IdInvalidoException extends Exception{
	/**
     * Constructor que recibe un mensaje de excepción
     *
     * @param msg mensaje que se lanza cuando se produce la excepción
     */

	public IdInvalidoException(String msg){
        super(msg);
    }
}
