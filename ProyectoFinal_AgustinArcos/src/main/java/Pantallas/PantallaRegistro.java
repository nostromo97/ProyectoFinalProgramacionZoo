package Pantallas;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Pantallas.Ventana;
import Utils.UtilsDB;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
import Excepciones.IdInvalidoException;
import Excepciones.IdVacioException;
import Excepciones.NombreInvalidoException;
import Excepciones.NombreVacioException;

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
				try {
				String nombreUsuario = campoUsuario.getText();
				String apellidosUsuario = campoApellidos.getText();
				String contrasena = new String (campoContrasena.getPassword());
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				LocalDate fechaNacimiento = LocalDate.parse(textFechaNacimiento.getText(),formatter);
				
			
					Usuario user1 = new Usuario(nombreUsuario,apellidosUsuario,contrasena,fechaNacimiento);
					//JOPTION PANE QUE DIGA REGISTRO EXITOSO DE TIPO OK_MESSAGE
					JOptionPane.showMessageDialog(ventana, "Registro exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
					//IR A PANTALLA METER ANIMALES
					ventana.cambiarPantalla("atras");
				} catch (NombreVacioException e1) {
					JOptionPane.showMessageDialog(null, "Nombre Vacio", "Error", JOptionPane.WARNING_MESSAGE);
				} catch (NombreInvalidoException e1) {
					JOptionPane.showMessageDialog(null, "El nombre no puede contener números.", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Error SQL", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (FechaFormatoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch(DateTimeParseException e1) {
					JOptionPane.showMessageDialog(null, "Error. Introduce la fecha en un formato: dd-MM-YYYY (día, mes, año)", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (ContrasenaVaciaException e1) {
					JOptionPane.showMessageDialog(null, "La contraseña no puede estar vacía.","Error",JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (ContrasenaInvalidaException e1) {
					JOptionPane.showMessageDialog(null, "La contraseña no puede estar vacía.","Error",JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (ContrasenaLargaException e1) {
					JOptionPane.showMessageDialog(null, "La contraseña no puede estar vacía.","Error",JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

				 
				
			}
		});
		btnRegistro.setBounds(264, 508, 276, 38);
		add(btnRegistro);
		
		JLabel background = new JLabel("");
		background.setHorizontalAlignment(SwingConstants.CENTER);
		background.setIcon(new ImageIcon("./fotos/login_pantalla.jpg"));
		background.setBounds(0, 0, 800, 589);
		add(background);
		
		
	}
}
