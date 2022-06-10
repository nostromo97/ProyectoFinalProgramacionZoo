package Excepciones;
/**
 * Clase que modela una excepci�n cuando no se introduce un id.
 *
 * @author Agust�n Arcos
 */
public class IdVacioException extends Exception{
	
	public IdVacioException(String msg){
		/**
	     * Constructor que recibe un mensaje de excepci�n
	     *
	     * @param msg mensaje que se lanza cuando se produce la excepci�n
	     */
        super(msg);
    }

}
