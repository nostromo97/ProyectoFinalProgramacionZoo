package Excepciones;

/**
 * Clase que modela una excepci�n cuando una contrase�a no es v�lida.
 *
 * @author Agust�n Arcos
 */


public class ContrasenaInvalidaException extends Exception{
	/**
     * Constructor que recibe un mensaje de excepci�n
     *
     * @param msg mensaje que se lanza cuando se produce la excepci�n
     */
	
	public ContrasenaInvalidaException(String msg){
        super(msg);
    }

}
