package Pantallas;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame{
	private JPanel pantallaActual;
	
	
	public Ventana() {
		
		
		this.setSize(800, 600);
		this.setTitle("Zoológico Mundo Natural");
		this.setIconImage(new ImageIcon("./fotos/icono.png").getImage());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pantallaActual = new PantallaInicial(this);
		this.setContentPane(pantallaActual);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
	}
	
	public void cambiarPantalla (String nombrePantalla) {
		this.pantallaActual.setVisible(false);
		this.pantallaActual=null;
		
		
		switch (nombrePantalla) {
		case "login":
			this.pantallaActual = new PantallaLogin(this);
			break;
		case "registro":
			this.pantallaActual = new PantallaRegistro(this);
			break;
		case "menu":
			this.pantallaActual = new PantallaMenu(this);
			break;
		case "atras":
			this.pantallaActual = new PantallaInicial(this);
			break;
		case "alimentos":
			this.pantallaActual = new PantallaAlimentos(this);
			break;
		case "altaPrimate":
			this.pantallaActual = new PantallaAltaPrimate(this);
			break;
		case "bajaPrimate":
			this.pantallaActual = new PantallaBajaPrimate(this);
			break;
		case "altaAnfibio":
			this.pantallaActual = new PantallaAltaAnfibio(this);
			break;
		case "bajaAnfibio":
			this.pantallaActual = new PantallaBajaAnfibio(this);
			break;
		case "altaReptil":
			this.pantallaActual = new PantallaAltaReptil(this);
			break;
		case "bajaReptil":
			this.pantallaActual = new PantallaBajaReptil(this);
			break;
		}
		this.pantallaActual.setVisible(true);
		this.setContentPane(pantallaActual);
	}

}
