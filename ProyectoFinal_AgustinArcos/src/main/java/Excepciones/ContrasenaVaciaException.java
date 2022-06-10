package Excepciones;
/**
 * Clase que modela una excepción cuando una contraseña está vacía.
 *
 * @author Agustín Arcos
 */
public class ContrasenaVaciaException extends Exception{
	/**
     * Constructor que recibe un mensaje de excepción
     *
     * @param msg mensaje que se lanza cuando se produce la excepción
     */
	public ContrasenaVaciaException(String msg){
        super(msg);
    }
}
