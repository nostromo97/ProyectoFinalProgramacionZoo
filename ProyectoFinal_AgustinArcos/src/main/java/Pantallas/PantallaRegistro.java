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

public class PantallaRegistro extends JPanel{

	
	private Ventana ventana;
	private JTextField textUsuario;
	private JTextField textContrasena;
	
	
	public PantallaRegistro(Ventana v) {
		this.ventana=v;
		setLayout(null);
		setSize (800,600);
		
		JButton botonAtras = new JButton("ATR\u00C1S");
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarPantalla("atras");
			}
		});
		botonAtras.setBounds(48, 415, 113, 53);
		add(botonAtras);
		
		JLabel textoRegistro = new JLabel("REGISTRO");
		textoRegistro.setForeground(Color.WHITE);
		textoRegistro.setFont(new Font("Arial", Font.BOLD, 20));
		textoRegistro.setBounds(335, 298, 121, 24);
		add(textoRegistro);
		
		textUsuario = new JTextField();
		textUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		textUsuario.setBounds(285, 380, 212, 20);
		add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel usuario = new JLabel("Usuario:");
		usuario.setVerticalAlignment(SwingConstants.TOP);
		usuario.setForeground(Color.WHITE);
		usuario.setFont(new Font("Arial", Font.BOLD, 14));
		usuario.setHorizontalAlignment(SwingConstants.CENTER);
		usuario.setBounds(349, 355, 80, 14);
		add(usuario);
		
		JLabel contraseña = new JLabel("Contrase\u00F1a:");
		contraseña.setHorizontalAlignment(SwingConstants.CENTER);
		contraseña.setForeground(Color.WHITE);
		contraseña.setFont(new Font("Arial", Font.BOLD, 14));
		contraseña.setBounds(337, 454, 103, 14);
		add(contraseña);
		
		textContrasena = new JTextField();
		textContrasena.setHorizontalAlignment(SwingConstants.LEFT);
		textContrasena.setBounds(322, 475, 134, 20);
		add(textContrasena);
		textContrasena.setColumns(10);
		
		JLabel background = new JLabel("");
		background.setHorizontalAlignment(SwingConstants.CENTER);
		background.setIcon(new ImageIcon("C:\\Users\\carol\\Documents\\Eclipse-WORKSPACE\\ProyectoFinalProgramacionZoo\\ProyectoFinal_AgustinArcos\\fotos\\login_pantalla.jpg"));
		background.setBounds(0, 0, 800, 589);
		add(background);
	}
}
