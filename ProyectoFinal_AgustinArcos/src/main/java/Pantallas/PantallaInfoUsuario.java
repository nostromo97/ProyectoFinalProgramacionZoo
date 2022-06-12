package Pantallas;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import Clases.Usuario;
import Excepciones.NombreInvalidoException;
import Excepciones.NombreVacioException;
import Utils.UtilsDB;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
/**
 * Clase que implementa la pantalla la información del usuario y extiende de JPanel.
 * @author Agustín Arcos
 *
 */
public class PantallaInfoUsuario extends JPanel{
	/**
	 * Ventana en la que se muestra la pantalla actual.
	 */
	private Ventana ventana;
	/**
	 * Panel donde aparece la información del usuario.
	 */
	private JTextPane textInfoUsuario;
	/**
	 * Constructor que implementa el funcionamiento de la pantalla de info del usuario.
	 * @param v
	 */
	public PantallaInfoUsuario(Ventana v) {
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
		
		textInfoUsuario= new JTextPane();
		textInfoUsuario.setBackground(new Color(153, 204, 204));
		textInfoUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JScrollPane usr = new JScrollPane(textInfoUsuario);
		usr.setBounds(214, 252, 372, 133);
		add(usr);
		
		JLabel lblNewLabel = new JLabel("Info Usuario:");
		lblNewLabel.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(338, 225, 122, 25);
		add(lblNewLabel);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("./fotos/BACKGROUND_sinlogo.jpg"));
		background.setBounds(0, 0, 800, 600);
		add(background);
		
		try {
			ArrayList<Usuario> usuarios = Usuario.mostrarInfoUsuario();
			String infoUsuario = "";
			
			for (int i = 0; i < usuarios.size(); i++) {
				String id = String.valueOf(usuarios.get(i).getId());
				String nombre = usuarios.get(i).getNombre();
				String apellidos = usuarios.get(i).getApellidos();
				infoUsuario +="●ID: "+ id +"||\n     ●NOMBRE: "+ nombre + "||\n     ●APELLIDOS: "+apellidos+"\n";
			}
			textInfoUsuario.setText(infoUsuario);
			
		} catch (NombreVacioException | NombreInvalidoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
	}
	
}
