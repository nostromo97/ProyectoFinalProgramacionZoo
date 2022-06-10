package Excepciones;
/**
 * Clase que modela una excepci�n cuando id introducido no es correcto.
 *
 * @author Agust�n Arcos
 */

public class IdInvalidoException extends Exception{
	/**
     * Constructor que recibe un mensaje de excepci�n
     *
     * @param msg mensaje que se lanza cuando se produce la excepci�n
     */

	public IdInvalidoException(String msg){
        super(msg);
    }
}
