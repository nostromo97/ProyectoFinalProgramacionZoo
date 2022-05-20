package Clases;

public class HabitatPrimate extends Habitat{

	private short cantidadArboles;

	public HabitatPrimate(String nombre, String tipo, short cantidadArboles) {
		super(nombre, tipo);
		this.cantidadArboles = cantidadArboles;
	}

	public short getCantidadArboles() {
		return cantidadArboles;
	}

	public void setCantidadArboles(short cantidadArboles) {
		this.cantidadArboles = cantidadArboles;
	}
	
	
}
