package Pantallas;

import javax.swing.JPanel;
import javax.swing.JTextPane;

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
import java.awt.event.ActionEvent;

public class PantallaInfoUsuario extends JPanel{
	
	private Ventana ventana;
	private JTextPane textInfoUsuario;
	
	public PantallaInfoUsuario(Ventana v) {
		this.ventana = v;
		setLayout(null);
		setSize(800, 600);
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.addActionListener(new ActionListener() {
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
		
		JTextPane textInfoUsuario= new JTextPane();
		textInfoUsuario.setBounds(214, 252, 372, 133);
		add(textInfoUsuario);
		
		JLabel lblNewLabel = new JLabel("Info Usuario:");
		lblNewLabel.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(338, 225, 122, 25);
		add(lblNewLabel);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("./fotos/BACKGROUND_sinlogo.jpg"));
		background.setBounds(0, 0, 800, 600);
		add(background);
		
		mostrarInfoUsuario();
				
	}
	
	private void mostrarInfoUsuario() {
		Statement query = UtilsDB.conectarBD();
		
		String infoUsuario = "";
		
		ResultSet cursor;
		try {
			cursor = query.executeQuery("select * from usuarios");
			
			while(cursor.next()) {
				String id = cursor.getString("id");
				String nombre = cursor.getString("nombre");
				String apellidos = cursor.getString("apellidos");
				infoUsuario +="●ID: "+ id +"||\n     ●NOMBRE: "+ nombre + "||\n     ●APELLIDOS: "+apellidos+"\n";
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		textInfoUsuario.setText(infoUsuario);
	}
	
	
	
	
}
