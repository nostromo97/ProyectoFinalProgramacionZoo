package Clases;
/**
 * Clase que contiene un objeto de tipo HabitatPrimate que extiende de la clase Habitat.
 * @author Agust�n Arcos
 *
 */
public class HabitatPrimate extends Habitat{
	/**
	 * Variable num�rica de tipo short que indica la cantidad de �rboles en el habitat.
	 */
	private short cantidadArboles;
/**
 * Constructor de la clase HabitatPrimate
 * @param nombre Cadena de caracteres que contiene el nombre del animal.
 * @param tipo Indica el tipo de habitat.
 * @param cantidadArboles Variable num�rica de tipo short que indica la cantidad de �rboles en el habitat.
 */
	public HabitatPrimate(String nombre, String tipo, short cantidadArboles) {
		super(nombre, tipo);
		this.cantidadArboles = cantidadArboles;
	}
	/**
	 * Funci�n que devuelve la cantidad de �rboles
	 * @return Cantidad de �rboles del objeto.
	 */
	public short getCantidadArboles() {
		return cantidadArboles;
	}
	/**
	 * Funci�n que establece una cantidad de �rboles.
	 * @param cantidadArboles Nuevo par�metro que estblace nuevo valor de cantidad de �rboles.
	 */
	public void setCantidadArboles(short cantidadArboles) {
		this.cantidadArboles = cantidadArboles;
	}
	
	
}
