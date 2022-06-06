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
import Excepciones.FechaFormatoException;
import Excepciones.NombreInvalidoException;
import Excepciones.NombreVacioException;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPasswordField;

public class PantallaLogin extends JPanel{

	
	private Ventana ventana;
	private JTextField campoUsuario;
	private JPasswordField campoContrasena;
	
	
	public PantallaLogin(Ventana v) {
		this.ventana=v;
		setLayout(null);
		setSize (800,600);
		
		
		
		campoContrasena = new JPasswordField();
		campoContrasena.setBounds(326, 444, 141, 20);
		add(campoContrasena);

		
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
			public void actionPerformed(ActionEvent e) {
				
				String nombre = campoUsuario.getText();
				String contrasena = new String (campoContrasena.getPassword());
				try {
					Usuario user1 = new Usuario (nombre,contrasena);
					JOptionPane.showMessageDialog(null, "Login correcto", "Éxito", JOptionPane.OK_OPTION);
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
				}
			}
		});
		botonIngresar.setBounds(247, 474, 308, 32);
		add(botonIngresar);
		
		JLabel background = new JLabel("");
		background.setHorizontalAlignment(SwingConstants.CENTER);
		background.setIcon(new ImageIcon("C:\\Users\\carol\\Documents\\Eclipse-WORKSPACE\\ProyectoFinalProgramacionZoo\\ProyectoFinal_AgustinArcos\\fotos\\login_pantalla.jpg"));
		background.setBounds(0, 0, 800, 589);
		add(background);
	}
}
