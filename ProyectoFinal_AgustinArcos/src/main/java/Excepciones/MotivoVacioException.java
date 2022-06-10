package Excepciones;
/**
 * Clase que modela una excepción cuando no se selecciona un motivo.
 *
 * @author Agustín Arcos
 */

public class MotivoVacioException extends Exception{
	/**
     * Constructor que recibe un mensaje de excepción
     *
     * @param msg mensaje que se lanza cuando se produce la excepción
     */
	public MotivoVacioException(String msg){
        super(msg);
	}
}
