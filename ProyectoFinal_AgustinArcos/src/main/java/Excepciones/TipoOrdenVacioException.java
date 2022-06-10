package Excepciones;
/**
 * Clase que modela una excepci�n cuando no se selecciona ning�n tipo de orden.
 *
 * @author Agust�n Arcos
 */

public class TipoOrdenVacioException extends Exception{
	/**
     * Constructor que recibe un mensaje de excepci�n
     *
     * @param msg mensaje que se lanza cuando se produce la excepci�n
     */
	public TipoOrdenVacioException(String msg){
        super(msg);
    }

}
