package Excepciones;
/**
 * Clase que modela una excepci�n cuando no se selecciona un tipo de ambiente.
 *
 * @author Agust�n Arcos
 */
public class TipoAmbienteVacioException extends Exception{
	
	public TipoAmbienteVacioException(String msg){
		/**
	     * Constructor que recibe un mensaje de excepci�n
	     *
	     * @param msg mensaje que se lanza cuando se produce la excepci�n
	     */
        super(msg);
    }

}
