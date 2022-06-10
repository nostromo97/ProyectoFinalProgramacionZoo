package Excepciones;
/**
 * Clase que modela una excepci�n cuando un campo est� vac�o.
 *
 * @author Agust�n Arcos
 */

public class CampoVacioException extends Exception{
	/**
     * Constructor que recibe un mensaje de excepci�n
     *
     * @param msg mensaje que se lanza cuando se produce la excepci�n
     */
	public CampoVacioException(String msg){
        super(msg);
	}
}
