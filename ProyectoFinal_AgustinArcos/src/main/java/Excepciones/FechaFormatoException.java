package Excepciones;
/**
 * Clase que modela una excepción cuando el formato de una fecha no es válido.
 *
 * @author Agustín Arcos
 */
public class FechaFormatoException extends Exception{
	/**
     * Constructor que recibe un mensaje de excepción
     *
     * @param msg mensaje que se lanza cuando se produce la excepción
     */
	public FechaFormatoException(String msg){
        super(msg);
    }

}
