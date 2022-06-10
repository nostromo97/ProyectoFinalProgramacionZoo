package Excepciones;
/**
 * Clase que modela una excepción cuando no se introduce un id.
 *
 * @author Agustín Arcos
 */
public class IdVacioException extends Exception{
	
	public IdVacioException(String msg){
		/**
	     * Constructor que recibe un mensaje de excepción
	     *
	     * @param msg mensaje que se lanza cuando se produce la excepción
	     */
        super(msg);
    }

}
