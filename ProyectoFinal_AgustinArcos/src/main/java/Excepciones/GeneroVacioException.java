package Excepciones;

/**
 * Clase que modela una excepción cuando no se selecciona ningún género.
 *
 * @author Agustín Arcos
 */
public class GeneroVacioException extends Exception{
	/**
     * Constructor que recibe un mensaje de excepción
     *
     * @param msg mensaje que se lanza cuando se produce la excepción
     */
	public GeneroVacioException(String msg){
        super(msg);
    }
	
}
