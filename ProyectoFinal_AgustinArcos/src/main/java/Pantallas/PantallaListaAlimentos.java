package Pantallas;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;

import Utils.UtilsDB;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
/**
 * Clase que implementa la pantalla con la lista de alimentos y extiende de JPanel.
 * @author Agustín Arcos
 *
 */
public class PantallaListaAlimentos extends JPanel{
	/**
	 * Ventana en la que se muestra la pantalla actual.
	 */
	private Ventana ventana;
	/**
	 * Panel donde aparece la lista de alimentos que se han introducido en la base de datos.
	 */
	private JTextPane textListaAlimentos;
	/**
	 * Constructor que implementa el funcionamiento de la pantalla con la lista de alimentos.
	 * @param v
	 */
	public PantallaListaAlimentos(Ventana v) {
		this.ventana = v;
		setLayout(null);
		setSize(800, 600);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			/**
			 * Función que te devuelve a la pantalla de alimentos.
			 * @param e Variable que activa el evento.
			 */
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarPantalla("alimentos");
			}
		});
		btnVolver.setBounds(350, 457, 89, 23);
		add(btnVolver);
		
		
		
		JLabel lbllistaAlimentos = new JLabel("LISTA DE ALIMENTOS:");
		lbllistaAlimentos.setForeground(Color.WHITE);
		lbllistaAlimentos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbllistaAlimentos.setBounds(320, 59, 319, 38);
		add(lbllistaAlimentos);
		
		textListaAlimentos = new JTextPane();
		textListaAlimentos.setFont(new Font("Tahoma", Font.BOLD, 11));
		textListaAlimentos.setBackground(Color.LIGHT_GRAY);
		
		JScrollPane scrBaja = new JScrollPane(textListaAlimentos);
		scrBaja.setBounds(101, 99, 622, 331);
		add(scrBaja);
		
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("./fotos/BACKGROUND_sinlogo.jpg"));
		lblFondo.setBounds(0, 0, 800, 600);
		add(lblFondo);
			
		
		mostrarAlimentos();
	}
	/**
	 * Función que muestra la lista de alimentos en la base de datos.
	 */
	private void mostrarAlimentos() {
		Statement query = UtilsDB.conectarBD();
		
		String listaAlimentos = "";
		
		ResultSet cursor;
		try {
			cursor = query.executeQuery("select * from alimento");
			
			while(cursor.next()) {
				String id = cursor.getString("id");
				String nombre = cursor.getString("nombre");
				String tipoAlimento = cursor.getString("tipoAlimento");
				float cantidadAlimento = cursor.getFloat("cantidadAlimento");
				listaAlimentos +="●ID: "+ id +"||     ●NOMBRE: "+ nombre + "||     ●TIPO: "+tipoAlimento+
						"||     ●CANTIDAD: "+cantidadAlimento+"Kg \n";
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		textListaAlimentos.setText(listaAlimentos);
	}
	
	
	
	
	
}
