package Excepciones;
/**
 * Clase que modela una excepción cuando la descripción de los cuidados está vacía.
 *
 * @author Agustín Arcos
 */
public class DescripcionVaciaException extends Exception{
	
	public DescripcionVaciaException(String msg){
		/**
	     * Constructor que recibe un mensaje de excepción
	     *
	     * @param msg mensaje que se lanza cuando se produce la excepción
	     */
        super(msg);
    }
	
}
