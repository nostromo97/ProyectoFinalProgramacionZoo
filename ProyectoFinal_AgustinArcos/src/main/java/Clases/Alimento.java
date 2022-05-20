package Clases;

import Enums.TipoAlimento;

public class Alimento extends EntidadConNombre{
	
	private TipoAlimento tipoAlimento;
	private float cantidadAlimentosKilos;
	
	public Alimento(String nombre, TipoAlimento tipoAlimento, float cantidadAlimentosKilos) {
		super(nombre);
		this.tipoAlimento = tipoAlimento;
		this.cantidadAlimentosKilos = cantidadAlimentosKilos;
	}

	public TipoAlimento getTipoAlimento() {
		return tipoAlimento;
	}

	public void setTipoAlimento(TipoAlimento tipoAlimento) {
		this.tipoAlimento = tipoAlimento;
	}

	public float getCantidadAlimentosKilos() {
		return cantidadAlimentosKilos;
	}

	public void setCantidadAlimentosKilos(float cantidadAlimentosKilos) {
		this.cantidadAlimentosKilos = cantidadAlimentosKilos;
	}
	
	
	
	
}
