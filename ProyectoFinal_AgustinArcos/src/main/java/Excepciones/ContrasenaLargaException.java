package Excepciones;

/**
 * Clase que modela una excepci�n cuando una contrase�a es demasiado larga, mayor a 15 caracteres.
 *
 * @author Agust�n Arcos
 */
public class ContrasenaLargaException extends Exception{
	/**
     * Constructor que recibe un mensaje de excepci�n
     *
     * @param msg mensaje que se lanza cuando se produce la excepci�n
     */
	public ContrasenaLargaException(String msg){
        super(msg);
    }
}
