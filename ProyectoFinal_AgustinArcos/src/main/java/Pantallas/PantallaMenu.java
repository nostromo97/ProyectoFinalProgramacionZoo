package Pantallas;

import javax.swing.JPanel;

import elementosvisuales.BotonConMusica;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
/**
 * Clase que implementa la pantalla del menú principal y extiende de JPanel.
 * @author Agustín Arcos
 *
 */
public class PantallaMenu extends JPanel{
	/**
	 * Ventana en la que se muestra la pantalla actual.
	 */
	private Ventana ventana;
	/**
	 * Constructor que implementa el funcionamiento de la pantalla del menú.
	 * @param v
	 */
	public PantallaMenu(Ventana v) {
		this.ventana=v;
		setLayout(null);
		setSize (800,600);
		
		JButton botonAlimentos = new JButton("ALIMENTOS");
		botonAlimentos.addActionListener(new ActionListener() {
			/**
			 * Función que te devuelve a la pantalla de alimentos.
			 * @param e Variable que activa el evento.
			 */
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarPantalla("alimentos");	
			}
		});
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			/**
			 * Función que cierra el programa.
			 * @param e Variable que activa el evento.
			 */
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		
		JButton btnUsuario = new JButton("Usuario");
		btnUsuario.addActionListener(new ActionListener() {
			/**
			 * Función que te devuelve a la pantalla de info del usuario.
			 * @param e Variable que activa el evento.
			 */
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarPantalla("infoUsuario");
			}
		});
		btnUsuario.setBounds(570, 55, 89, 23);
		add(btnUsuario);
		
		JLabel gifMonoMenu = new JLabel("");
		gifMonoMenu.setIcon(new ImageIcon("./gif/monoMenu.gif"));
		gifMonoMenu.setBounds(594, 178, 159, 151);
		add(gifMonoMenu);
		btnSalir.setBounds(70, 481, 89, 23);
		add(btnSalir);
		botonAlimentos.setBounds(407, 367, 107, 42);
		add(botonAlimentos);
		
		JButton botonRefugio = new JButton("ANIMALES");
		botonRefugio.addActionListener(new ActionListener() {
			/**
			 * 
			 * @param e
			 */
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarPantalla("zoologico");
			}
		});
		botonRefugio.setBounds(234, 368, 108, 40);
		add(botonRefugio);
		
		final JComboBox comboBaja = new JComboBox();
		comboBaja.setModel(new DefaultComboBoxModel(new String[] {"...", "Anfibio", "Primate", "Reptil"}));
		comboBaja.setMaximumRowCount(4);
		comboBaja.setBounds(369, 257, 144, 22);
		add(comboBaja);
		
		final JComboBox comboAlta = new JComboBox();
		comboAlta.setModel(new DefaultComboBoxModel(new String[] {"...", "Anfibio", "Primate", "Reptil"}));
		
		comboAlta.setToolTipText("");
		comboAlta.setMaximumRowCount(4);
		comboAlta.setBounds(369, 178, 145, 22);
		add(comboAlta);
		
		JButton botonConMusica = new BotonConMusica ("♫");
		botonConMusica.setForeground(Color.BLUE);
		botonConMusica.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botonConMusica.setBackground(Color.ORANGE);
		botonConMusica.setBounds(597, 448, 77, 56);
		add(botonConMusica);
		
		
		JButton botonBaja = new JButton("DAR DE BAJA ANIMAL");
		botonBaja.addActionListener(new ActionListener() {
			/**
			 * Función donde el usuario elige que tipo de animal quiere dar de alta y le lleva a la pantalla de alta del animal seleccionado
			 * @param e Variable que activa el evento.
			 */
			public void actionPerformed(ActionEvent e) {
				if(comboBaja.getSelectedItem().equals("Anfibio")) {
					ventana.cambiarPantalla("bajaAnfibio");
				}else if(comboBaja.getSelectedItem().equals("Primate")) {
					ventana.cambiarPantalla("bajaPrimate");
				}else if(comboBaja.getSelectedItem().equals("Reptil")) {
					ventana.cambiarPantalla("bajaReptil");
				}else if(comboBaja.getSelectedItem().equals("...")) {
					JOptionPane.showMessageDialog(ventana, "Selecciona un animal", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		botonBaja.setBackground(Color.RED);
		botonBaja.setBounds(89, 252, 234, 33);
		add(botonBaja); 
		
		JButton botonAlta = new JButton("DAR DE ALTA ANIMAL");
		botonAlta.addActionListener(new ActionListener() {
			/**
			 * Función donde el usuario elige que tipo de animal quiere dar de baja y le lleva a la pantalla de baja del animal seleccionado
			 * @param e Variable que activa el evento.
			 */
			public void actionPerformed(ActionEvent e) {
				if(comboAlta.getSelectedItem().equals("Anfibio")) {
					ventana.cambiarPantalla("altaAnfibio");
				}else if(comboAlta.getSelectedItem().equals("Primate")) {
					ventana.cambiarPantalla("altaPrimate");
				}else if(comboAlta.getSelectedItem().equals("Reptil")) {
					ventana.cambiarPantalla("altaReptil");
				}else if(comboAlta.getSelectedItem().equals("...")) {
					JOptionPane.showMessageDialog(ventana, "Selecciona un animal", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		botonAlta.setBackground(Color.GREEN);
		botonAlta.setForeground(Color.BLACK);
		botonAlta.setBounds(89, 173, 234, 33);
		add(botonAlta);
		
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("./fotos/BACKGROUND.jpg"));
		lblNewLabel.setBounds(0, 0, 800, 600);
		add(lblNewLabel);
	}

	protected void salir() {
		System.exit(0);
		
	}
}
