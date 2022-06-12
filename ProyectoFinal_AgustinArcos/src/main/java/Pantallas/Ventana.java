package Pantallas;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Clases.Usuario;
/**
 * Clase Ventana que extiende de JFrame y hace que se muestre el programa por pantalla a través de la interfaz gráfica.
 * @author Agustín Arcos
 *
 */
public class Ventana extends JFrame{
	/**
	 * Pantalla que contiene la ventana en el momento de mostrarse.
	 */
	private JPanel pantallaActual;
	/**
	 * Constructor que implementa el funcionamiento de la clase ventana
	 */
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
	/**
	 * Función a la que le pasas por argumentos el nombre de la pantalla y cambia de pantalla, mediante el uso del switch para cada
	 * pantalla.
	 * @param nombrePantalla Nombre de la pantalla a la que se quiere cambiar.
	 */
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
		case "listaAlimentos":
			this.pantallaActual = new PantallaListaAlimentos(this);
			break;
		case "infoUsuario":
			this.pantallaActual = new PantallaInfoUsuario(this);
			break;
		case "zoologico":
			this.pantallaActual = new PantallaZoo(this);
			break;
		}
		this.pantallaActual.setVisible(true);
		this.setContentPane(pantallaActual);
	}

}
