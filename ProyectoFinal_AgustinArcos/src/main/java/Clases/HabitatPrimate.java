package Clases;
/**
 * Clase que contiene un objeto de tipo HabitatPrimate que extiende de la clase Habitat.
 * @author Agustín Arcos
 *
 */
public class HabitatPrimate extends Habitat{
	/**
	 * Variable numérica de tipo short que indica la cantidad de árboles en el habitat.
	 */
	private short cantidadArboles;
/**
 * Constructor de la clase HabitatPrimate
 * @param nombre Cadena de caracteres que contiene el nombre del animal.
 * @param tipo Indica el tipo de habitat.
 * @param cantidadArboles Variable numérica de tipo short que indica la cantidad de árboles en el habitat.
 */
	public HabitatPrimate(String nombre, String tipo, short cantidadArboles) {
		super(nombre, tipo);
		this.cantidadArboles = cantidadArboles;
	}
	/**
	 * Función que devuelve la cantidad de árboles
	 * @return Cantidad de árboles del objeto.
	 */
	public short getCantidadArboles() {
		return cantidadArboles;
	}
	/**
	 * Función que establece una cantidad de árboles.
	 * @param cantidadArboles Nuevo parámetro que estblace nuevo valor de cantidad de árboles.
	 */
	public void setCantidadArboles(short cantidadArboles) {
		this.cantidadArboles = cantidadArboles;
	}
	
	
}
