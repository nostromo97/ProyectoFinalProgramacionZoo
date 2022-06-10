package Excepciones;
/**
 * Clase que modela una excepción cuando no se selecciona un tipo de ambiente.
 *
 * @author Agustín Arcos
 */
public class TipoAmbienteVacioException extends Exception{
	
	public TipoAmbienteVacioException(String msg){
		/**
	     * Constructor que recibe un mensaje de excepción
	     *
	     * @param msg mensaje que se lanza cuando se produce la excepción
	     */
        super(msg);
    }

}
