package Excepciones;

/**
 * Clase que modela una excepci�n cuando no se selecciona ning�n g�nero.
 *
 * @author Agust�n Arcos
 */
public class GeneroVacioException extends Exception{
	/**
     * Constructor que recibe un mensaje de excepci�n
     *
     * @param msg mensaje que se lanza cuando se produce la excepci�n
     */
	public GeneroVacioException(String msg){
        super(msg);
    }
	
}
