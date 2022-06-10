package Excepciones;
/**
 * Clase que modela una excepci�n cuando no se selecciona un motivo.
 *
 * @author Agust�n Arcos
 */

public class MotivoVacioException extends Exception{
	/**
     * Constructor que recibe un mensaje de excepci�n
     *
     * @param msg mensaje que se lanza cuando se produce la excepci�n
     */
	public MotivoVacioException(String msg){
        super(msg);
	}
}
