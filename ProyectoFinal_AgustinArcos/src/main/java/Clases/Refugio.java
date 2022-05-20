package Clases;

import java.util.ArrayList;

public class Refugio {

	private String nombreRefugio;
	private ArrayList<Animal> animales;
	private ArrayList<Habitat> habitats;
	
	
	public Refugio(String nombreRefugio, ArrayList<Animal> animales, ArrayList<Habitat> habitats) {
		super();
		this.nombreRefugio = nombreRefugio;
		this.animales = animales;
		this.habitats = habitats;
	}


	public String getNombreRefugio() {
		return nombreRefugio;
	}


	public void setNombreRefugio(String nombreRefugio) {
		this.nombreRefugio = nombreRefugio;
	}


	public ArrayList<Animal> getAnimales() {
		return animales;
	}


	public void setAnimales(ArrayList<Animal> animales) {
		this.animales = animales;
	}


	public ArrayList<Habitat> getHabitats() {
		return habitats;
	}


	public void setHabitats(ArrayList<Habitat> habitats) {
		this.habitats = habitats;
	}
	
	
}
