package Pantallas;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Pantallas.Ventana;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;

public class PantallaLogin extends JPanel{

	
	private Ventana ventana;
	private JTextField textUsuario;
	private JTextField textContrasena;
	
	
	public PantallaLogin(Ventana v) {
		this.ventana=v;
		setLayout(null);
		setSize (800,600);
		
		JButton botonIngresar = new JButton("INGRESAR");
		botonIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarPantalla("menu");
			}
		});
		botonIngresar.setBounds(247, 474, 308, 32);
		add(botonIngresar);
		
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
		
		textUsuario = new JTextField();
		textUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		textUsuario.setBounds(287, 376, 217, 20);
		add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel usuario = new JLabel("Usuario");
		usuario.setForeground(Color.WHITE);
		usuario.setFont(new Font("Arial", Font.BOLD, 14));
		usuario.setHorizontalAlignment(SwingConstants.CENTER);
		usuario.setBounds(356, 355, 80, 14);
		add(usuario);
		
		JLabel contraseņa = new JLabel("Contrase\u00F1a");
		contraseņa.setForeground(Color.WHITE);
		contraseņa.setFont(new Font("Arial", Font.BOLD, 14));
		contraseņa.setBounds(356, 419, 103, 14);
		add(contraseņa);
		
		textContrasena = new JTextField();
		textContrasena.setHorizontalAlignment(SwingConstants.LEFT);
		textContrasena.setBounds(315, 444, 158, 20);
		add(textContrasena);
		textContrasena.setColumns(10);
		
		JLabel background = new JLabel("");
		background.setHorizontalAlignment(SwingConstants.CENTER);
		background.setIcon(new ImageIcon("C:\\Users\\carol\\Documents\\Eclipse-WORKSPACE\\ProyectoFinalProgramacionZoo\\ProyectoFinal_AgustinArcos\\fotos\\login_pantalla.jpg"));
		background.setBounds(0, 0, 800, 589);
		add(background);
	}
}
