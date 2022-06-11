package Pantallas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Clase que implementa la pantalla inicio del programa y extiende de JPanel.
 * @author Agustín Arcos
 *
 */
public class PantallaInicial extends JPanel{
	/**
	 * Ventana en la que se muestra la pantalla actual.
	 */
	private Ventana ventana;
	/**
	 * Constructor que implementa el funcionamiento de la pantalla de inicio.
	 * @param v
	 */
	public PantallaInicial(Ventana v) {
		this.ventana=v;
		setLayout(null);
		setSize (800,600);
		
		JButton botonLogin = new JButton("LOGIN");
		botonLogin.addActionListener(new ActionListener() {
			/**
			 * Función que te lleva a la pantalla de login.
			 * @param e Variable que activa el evento.
			 */
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarPantalla("login");
			}
		});
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			/**
			 * Función que cierra el programa.
			 * @param e Variable que activa el evento.
			 */
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		
		JLabel gifMonoPortatil = new JLabel("");
		gifMonoPortatil.setIcon(new ImageIcon("./gif/monoPortatil.gif"));
		gifMonoPortatil.setBounds(10, -34, 350, 321);
		add(gifMonoPortatil);
		
		
		btnSalir.setBounds(356, 294, 89, 23);
		add(btnSalir);
		botonLogin.setBounds(314, 382, 173, 40);
		add(botonLogin);
		
		JButton botonRegistrarse = new JButton("REGISTRARSE");
		botonRegistrarse.addActionListener(new ActionListener() {
			/**
			 * Función que lleva al usuario a la pantalla de registro
			 * @param e Variable que activa el evento.
			 */
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarPantalla("registro");
			}
		});
		botonRegistrarse.setBounds(314, 450, 173, 40);

		add(botonRegistrarse);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("./fotos/login_pantalla.jpg"));
		background.setBounds(0, 0, 800, 600);
		add(background);
	}

	protected void salir() {
		System.exit(0);
		
	}
}
