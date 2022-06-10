package Excepciones;

/**
 * Clase que modela una excepción cuando una contraseña es demasiado larga, mayor a 15 caracteres.
 *
 * @author Agustín Arcos
 */
public class ContrasenaLargaException extends Exception{
	/**
     * Constructor que recibe un mensaje de excepción
     *
     * @param msg mensaje que se lanza cuando se produce la excepción
     */
	public ContrasenaLargaException(String msg){
        super(msg);
    }
}
