package Clases;



public class HabitatAnfibio extends Habitat{

	private short metrosCubicosAgua;

	public HabitatAnfibio(String nombre, String tipo, short metrosCubicosAgua) {
		super(nombre, tipo);
		this.metrosCubicosAgua = metrosCubicosAgua;
	}

	public short getMetrosCubicosAgua() {
		return metrosCubicosAgua;
	}

	public void setMetrosCubicosAgua(short metrosCubicosAgua) {
		this.metrosCubicosAgua = metrosCubicosAgua;
	}
	
	
}
