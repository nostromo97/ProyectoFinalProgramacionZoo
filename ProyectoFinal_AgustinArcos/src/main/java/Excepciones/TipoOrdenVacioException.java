package Excepciones;
/**
 * Clase que modela una excepción cuando no se selecciona ningún tipo de orden.
 *
 * @author Agustín Arcos
 */

public class TipoOrdenVacioException extends Exception{
	/**
     * Constructor que recibe un mensaje de excepción
     *
     * @param msg mensaje que se lanza cuando se produce la excepción
     */
	public TipoOrdenVacioException(String msg){
        super(msg);
    }

}
