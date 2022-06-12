package Pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
/**
 * Clase que implementa la pantalla la info de todos los animales dados de alta en el zoo.
 * @author Agustín Arcos
 *
 */
public class PantallaZoo extends JPanel{
	/**
	 * Ventana en la que se muestra la pantalla actual.
	 */
	private Ventana ventana;
	/**
	 * Panel donde aparece la información de los animales.
	 */
	private JTextPane textInfoAnimales;
	
	public PantallaZoo (Ventana v) {
		this.ventana = v;
		setLayout(null);
		setSize(800, 600);
		
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.addActionListener(new ActionListener() {
			/**
			 * Función que te devuelve a la pantalla menú.
			 * @param e Variable que activa el evento.
			 */
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarPantalla("menu");
			}
		});
		botonVolver.setBounds(307, 456, 181, 44);
		add(botonVolver);
		
		JLabel fotoMonoPortatil = new JLabel("");
		fotoMonoPortatil.setIcon(new ImageIcon("./gif/monoPortatil.gif"));
		fotoMonoPortatil.setBounds(279, 27, 209, 187);
		add(fotoMonoPortatil);
		
		textInfoAnimales= new JTextPane();
		textInfoAnimales.setBackground(new Color(153, 204, 204));
		textInfoAnimales.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JScrollPane usr = new JScrollPane(textInfoAnimales);
		usr.setBounds(214, 252, 372, 133);
		add(usr);
		
		JLabel lblNewLabel = new JLabel("Lista de animales:");
		lblNewLabel.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(338, 225, 122, 25);
		add(lblNewLabel);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("./fotos/BACKGROUND_sinlogo.jpg"));
		background.setBounds(0, 0, 800, 600);
		add(background);
		
		
	}
	
}
