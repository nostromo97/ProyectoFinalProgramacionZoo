package Excepciones;
/**
 * Clase que modela una excepci�n cuando un nombre introducido no es v�lido.
 *
 * @author Agust�n Arcos
 */

public class NombreInvalidoException extends Exception{

	public NombreInvalidoException(String msg){
		/**
	     * Constructor que recibe un mensaje de excepci�n
	     *
	     * @param msg mensaje que se lanza cuando se produce la excepci�n
	     */
        super(msg);
    }
	
}
