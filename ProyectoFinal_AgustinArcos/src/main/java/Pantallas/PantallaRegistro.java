package Pantallas;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Pantallas.Ventana;
import Utils.UtilsDB;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPasswordField;

public class PantallaRegistro extends JPanel{

	
	private Ventana ventana;
	private JTextField campoUsuario;
	private JPasswordField campoContrasena;
	private JTextField campoApellidos;
	private JTextField textFechaNacimiento;
	
	
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
		
		textFechaNacimiento = new JTextField();
		textFechaNacimiento.setBounds(370, 431, 207, 20);
		add(textFechaNacimiento);
		textFechaNacimiento.setColumns(10);
		
		JLabel lbFechaNacimiento = new JLabel("Fecha Nacimiento:");
		lbFechaNacimiento.setFont(new Font("Arial", Font.BOLD, 14));
		lbFechaNacimiento.setForeground(Color.WHITE);
		lbFechaNacimiento.setBounds(223, 433, 141, 14);
		add(lbFechaNacimiento);
		
		
		
		JLabel lblNewLabel = new JLabel("Apellidos:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(271, 394, 80, 14);
		add(lblNewLabel);
		
		campoApellidos = new JTextField();
		campoApellidos.setBounds(370, 392, 207, 20);
		add(campoApellidos);
		campoApellidos.setColumns(10);
		
		campoContrasena = new JPasswordField();
		campoContrasena.setBounds(370, 467, 205, 20);
		add(campoContrasena);
		botonAtras.setBounds(48, 415, 113, 53);
		add(botonAtras);
		
		JLabel textoRegistro = new JLabel("REGISTRO");
		textoRegistro.setForeground(Color.WHITE);
		textoRegistro.setFont(new Font("Arial", Font.BOLD, 20));
		textoRegistro.setBounds(335, 298, 121, 24);
		add(textoRegistro);
		
		campoUsuario = new JTextField();
		campoUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		campoUsuario.setBounds(370, 350, 205, 20);
		add(campoUsuario);
		campoUsuario.setColumns(10);
		
		
		JLabel usuario = new JLabel("Nombre:");
		usuario.setVerticalAlignment(SwingConstants.TOP);
		usuario.setForeground(Color.WHITE);
		usuario.setFont(new Font("Arial", Font.BOLD, 14));
		usuario.setHorizontalAlignment(SwingConstants.CENTER);
		usuario.setBounds(282, 351, 80, 14);
		add(usuario);
		
		JLabel contraseña = new JLabel("Contrase\u00F1a:");
		contraseña.setHorizontalAlignment(SwingConstants.CENTER);
		contraseña.setForeground(Color.WHITE);
		contraseña.setFont(new Font("Arial", Font.BOLD, 14));
		contraseña.setBounds(259, 469, 103, 14);
		add(contraseña);
		
		JButton btnRegistro = new JButton("REGISTRAR");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreUsuario = campoUsuario.getText();
				String apelllidosUsuario = campoApellidos.getText();
				String contrasena = campoContrasena.getPassword().toString();

				
				
			}
		});
		btnRegistro.setBounds(259, 508, 276, 38);
		add(btnRegistro);
		
		JLabel background = new JLabel("");
		background.setHorizontalAlignment(SwingConstants.CENTER);
		background.setIcon(new ImageIcon("C:\\Users\\carol\\Documents\\Eclipse-WORKSPACE\\ProyectoFinalProgramacionZoo\\ProyectoFinal_AgustinArcos\\fotos\\login_pantalla.jpg"));
		background.setBounds(0, 0, 800, 589);
		add(background);
		
		
	}
}
