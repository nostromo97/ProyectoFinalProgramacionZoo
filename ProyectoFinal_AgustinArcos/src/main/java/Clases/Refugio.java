package Clases;

import java.util.ArrayList;
/**
 * Clase que contiene un objeto de tipo Refugio.
 * @author Agustín Arcos
 *
 */
public class Refugio {
	/**
	 * Cadena de caracteres que contiene el nombre del refugio.
	 */
	private String nombreRefugio;
	 //cambiar arraylist en hashset de habitat
	
	/**
	 * ArrayList de Animal de los animales que hay en el refugio.
	 */
	private ArrayList<Animal> animales;
	/**
	 * ArrayList de Animal de los habitats que hay en el refugio.
	 */
	private ArrayList<Habitat> habitats;
	
	/**
	 * Constructor de la clase Refugio
	 * @param nombreRefugio Cadena de caracteres que contiene el nombre del refugio.
	 * @param animales ArrauList de Animal de los habitats que hay en el refugio.
	 * @param habitats ArrayList de Animal de los habitats que hay en el refugio.
	 */
	public Refugio(String nombreRefugio, ArrayList<Animal> animales, ArrayList<Habitat> habitats) {
		super();
		this.nombreRefugio = nombreRefugio;
		this.animales = animales;
		this.habitats = habitats;
	}

	/**
	 * Función que devuelve el nombre del refugio.
	 * @return El nombre del refugio.
	 */
	public String getNombreRefugio() {
		return nombreRefugio;
	}

	/**
	 * Función que establece un nombre para el refugio.
	 * @param nombreRefugio El nombre del refugio.
	 */
	public void setNombreRefugio(String nombreRefugio) {
		this.nombreRefugio = nombreRefugio;
	}

	/**
	 * Función que devuelve los animales que hay en el refugio.
	 * @return Animales del refugio.
	 */
	public ArrayList<Animal> getAnimales() {
		return animales;
	}

	/**
	 * Función que establece los diferentes animales.
	 * @param animales Animales en el refugio.
	 */
	public void setAnimales(ArrayList<Animal> animales) {
		this.animales = animales;
	}

	/**
	 * Función que devuelve las habitats del refugio.
	 * @return Habitats del refugio.
	 */
	public ArrayList<Habitat> getHabitats() {
		return habitats;
	}

	/**
	 * Función que establece los habitats que hay en el refugio.
	 * @param habitats Los habitats del refugio.
	 */
	public void setHabitats(ArrayList<Habitat> habitats) {
		this.habitats = habitats;
	}
	
	
}
