package Pantallas;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Pantallas.Ventana;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import Clases.Usuario;
import Excepciones.ContrasenaInvalidaException;
import Excepciones.ContrasenaLargaException;
import Excepciones.ContrasenaVaciaException;
import Excepciones.FechaFormatoException;
import Excepciones.NombreInvalidoException;
import Excepciones.NombreVacioException;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPasswordField;
/**
 * Clase que implementa la pantalla de login y extiende de JPanel.
 * @author Agustín Arcos
 *
 */
public class PantallaLogin extends JPanel{

	/**
	 * Ventana en la que se muestra la pantalla actual.
	 */
	private Ventana ventana;
	/**
	 * Campo donde el usuario introduce su nombre.
	 */
	private JTextField campoUsuario;
	/**
	 * Campo donde el usuario introduce su contraseña.
	 */
	private JPasswordField campoContrasena;
	
	/**
	 * Constructor que implementa el funcionamiento de la pantalla de login.
	 * @param v
	 */
	public PantallaLogin(final Ventana v) {
		this.ventana=v;
		setLayout(null);
		setSize (800,600);
		
		
		
		campoContrasena = new JPasswordField();
		campoContrasena.setBounds(326, 444, 141, 20);
		add(campoContrasena);

		JLabel gifMonoPortatil = new JLabel("");
		gifMonoPortatil.setIcon(new ImageIcon("./gif/monoPortatil.gif"));
		gifMonoPortatil.setBounds(10, -34, 350, 321);
		add(gifMonoPortatil);
		
		JLabel textoLogin = new JLabel("LOGIN");
		textoLogin.setFont(new Font("Arial Black", Font.BOLD, 20));
		textoLogin.setForeground(Color.WHITE);
		textoLogin.setHorizontalAlignment(SwingConstants.CENTER);
		textoLogin.setBounds(308, 294, 178, 32);
		add(textoLogin);
		
		JButton botonAtras = new JButton("ATR\u00C1S");
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				ventana.cambiarPantalla("atras");
			}
		});
		botonAtras.setBounds(48, 419, 103, 49);
		add(botonAtras);
		
		campoUsuario = new JTextField();
		campoUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		campoUsuario.setBounds(287, 376, 217, 20);
		add(campoUsuario);
		campoUsuario.setColumns(10);
		
		JLabel usuario = new JLabel("Usuario");
		usuario.setForeground(Color.WHITE);
		usuario.setFont(new Font("Arial", Font.BOLD, 14));
		usuario.setHorizontalAlignment(SwingConstants.CENTER);
		usuario.setBounds(356, 355, 80, 14);
		add(usuario);
		
		JLabel contraseña = new JLabel("Contrase\u00F1a");
		contraseña.setForeground(Color.WHITE);
		contraseña.setFont(new Font("Arial", Font.BOLD, 14));
		contraseña.setBounds(356, 419, 103, 14);
		add(contraseña);
		
		
		JButton botonIngresar = new JButton("INGRESAR");
		botonIngresar.addActionListener(new ActionListener() {
			/**
			 * Función que registra y guarda los campos del login cuando el usuario hace click. 
			 * @param e Variable que activa el evento.
			 */
			public void actionPerformed(ActionEvent e) {
				
				String nombre = campoUsuario.getText();
				String contrasena = new String (campoContrasena.getPassword());
				try {
					Usuario usuario = new Usuario (nombre,contrasena);
					JOptionPane.showMessageDialog(null, "Login correcto", "Éxito", JOptionPane.INFORMATION_MESSAGE);
					ventana.cambiarPantalla("menu");
				} catch (NombreVacioException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (NombreInvalidoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (ContrasenaInvalidaException e1) {
					JOptionPane.showMessageDialog(null, "Contraseña no válida", "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (ContrasenaVaciaException e1) {
					JOptionPane.showMessageDialog(null, "La contraseña no puede estar vacía", "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (ContrasenaLargaException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				
				
			}
		});
		botonIngresar.setBounds(247, 474, 308, 32);
		add(botonIngresar);
		
		JLabel background = new JLabel("");
		background.setHorizontalAlignment(SwingConstants.CENTER);
		background.setIcon(new ImageIcon("./fotos/login_pantalla.jpg"));
		background.setBounds(0, 0, 800, 589);
		add(background);
	}
}
