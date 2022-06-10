package Excepciones;
/**
 * Clase que modela una excepci�n cuando la descripci�n de los cuidados est� vac�a.
 *
 * @author Agust�n Arcos
 */
public class DescripcionVaciaException extends Exception{
	
	public DescripcionVaciaException(String msg){
		/**
	     * Constructor que recibe un mensaje de excepci�n
	     *
	     * @param msg mensaje que se lanza cuando se produce la excepci�n
	     */
        super(msg);
    }
	
}
