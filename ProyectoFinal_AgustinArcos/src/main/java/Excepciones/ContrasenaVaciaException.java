package Excepciones;
/**
 * Clase que modela una excepci�n cuando una contrase�a est� vac�a.
 *
 * @author Agust�n Arcos
 */
public class ContrasenaVaciaException extends Exception{
	/**
     * Constructor que recibe un mensaje de excepci�n
     *
     * @param msg mensaje que se lanza cuando se produce la excepci�n
     */
	public ContrasenaVaciaException(String msg){
        super(msg);
    }
}
