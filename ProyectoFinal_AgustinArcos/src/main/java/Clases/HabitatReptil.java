package Clases;
/**
 * Clase que contiene un objeto de tipo HabitatReptil que extiende de la clase Habitat.
 * @author Agust�n Arcos
 *
 */
public class HabitatReptil extends Habitat{
	
	/**
	 * Variable num�rica de tipo short que indica el tama�o del terreno de arena.
	 */
	private short terrenoArena;
	/**
	 * Constructor de la clase HabitatReptil.
	 * @param nombre Cadena de caracteres que contiene el nombre del animal.
	 * @param tipo Cadena de caracteres que contiene el tipo de habitat.
	 * @param terrenoArena Variable num�rica de tipo short que indica el tama�o del terreno de arena.
	 */
	public HabitatReptil(String nombre, String tipo, short terrenoArena) {
		super(nombre, tipo);
		this.terrenoArena = terrenoArena;
	}
	/**
	 * Funci�n que devuelve el tama�o del terreno de arena.
	 * @return Tama�o del terreno de arena.
	 */
	public short getTerrenoArena() {
		return terrenoArena;
	}
	/**
	 * Funci�n que establece un tama�o al terreno de arena del objeto.
	 * @param terrenoArena Tama�o del terreno de arena.
	 */
	public void setTerrenoArena(short terrenoArena) {
		this.terrenoArena = terrenoArena;
	}
	
	
}
