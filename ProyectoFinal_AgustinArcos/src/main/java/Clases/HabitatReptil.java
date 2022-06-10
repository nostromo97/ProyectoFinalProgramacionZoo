package Clases;
/**
 * Clase que contiene un objeto de tipo HabitatReptil que extiende de la clase Habitat.
 * @author Agustín Arcos
 *
 */
public class HabitatReptil extends Habitat{
	
	/**
	 * Variable numérica de tipo short que indica el tamaño del terreno de arena.
	 */
	private short terrenoArena;
	/**
	 * Constructor de la clase HabitatReptil.
	 * @param nombre Cadena de caracteres que contiene el nombre del animal.
	 * @param tipo Cadena de caracteres que contiene el tipo de habitat.
	 * @param terrenoArena Variable numérica de tipo short que indica el tamaño del terreno de arena.
	 */
	public HabitatReptil(String nombre, String tipo, short terrenoArena) {
		super(nombre, tipo);
		this.terrenoArena = terrenoArena;
	}
	/**
	 * Función que devuelve el tamaño del terreno de arena.
	 * @return Tamaño del terreno de arena.
	 */
	public short getTerrenoArena() {
		return terrenoArena;
	}
	/**
	 * Función que establece un tamaño al terreno de arena del objeto.
	 * @param terrenoArena Tamaño del terreno de arena.
	 */
	public void setTerrenoArena(short terrenoArena) {
		this.terrenoArena = terrenoArena;
	}
	
	
}
