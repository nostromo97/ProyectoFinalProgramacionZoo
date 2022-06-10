package Excepciones;
/**
 * Clase que modela una excepci�n cuando el formato de una fecha no es v�lido.
 *
 * @author Agust�n Arcos
 */
public class FechaFormatoException extends Exception{
	/**
     * Constructor que recibe un mensaje de excepci�n
     *
     * @param msg mensaje que se lanza cuando se produce la excepci�n
     */
	public FechaFormatoException(String msg){
        super(msg);
    }

}
