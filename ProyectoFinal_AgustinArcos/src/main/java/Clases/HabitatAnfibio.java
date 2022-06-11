package Clases;


/**
 * Clase que contiene un objeto de tipo HabitatAnfibio que extiende de la clase Habitat.
 * @author Agustín Arcos
 *
 */
public class HabitatAnfibio extends Habitat{
	/**
	 * Variable numérica de tipo short que indica los metros cubicos de agua en el habitat.
	 */
	private short metrosCubicosAgua;
/**
 * Constructor de HabitatAnfibio
 * @param nombre Cadena de caracteres que contiene el nombre del habitat.
 * @param tipo Cadena de caracteres que indica el tipo de habitat.
 * @param metrosCubicosAgua Variable numérica de tipo short que indica los metros cubicos de agua en el habitat.
 */
	public HabitatAnfibio(String nombre, String tipo, short metrosCubicosAgua) {
		super(nombre, tipo);
		this.metrosCubicosAgua = metrosCubicosAgua;
	}
	/**
	 * Función que devuelve los metro cubicos de agua del habitat.
	 * @return Metros cúbicos de agua del habitat.
	 */
	public short getMetrosCubicosAgua() {
		return metrosCubicosAgua;
	}
	/**
	 * Función que establece los metros cubicos de agua del habitat
	 * @param metrosCubicosAgua Nuevo parámetro que estblace nuevo valor de metros cubicos de agua.
	 */
	public void setMetrosCubicosAgua(short metrosCubicosAgua) {
		this.metrosCubicosAgua = metrosCubicosAgua;
	}
	
	
}
