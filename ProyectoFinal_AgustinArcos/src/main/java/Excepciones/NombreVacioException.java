package Excepciones;
/**
 * Clase que modela una excepci�n cuando no hay ning�n nombre introducido.
 *
 * @author Agust�n Arcos
 */

public class NombreVacioException extends Exception{
	/**
     * Constructor que recibe un mensaje de excepci�n
     *
     * @param msg mensaje que se lanza cuando se produce la excepci�n
     */
	public NombreVacioException(String msg){
        super(msg);
    }

}
