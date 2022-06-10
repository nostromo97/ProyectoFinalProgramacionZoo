package Pantallas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import Clases.Anfibio;
import Clases.Primate;
import Enums.MotivoBaja;
import Enums.TipoAmbiente;
import Enums.TipoOrden;
import Excepciones.CampoVacioException;
import Excepciones.FechaFormatoException;
import Excepciones.MotivoVacioException;
import Excepciones.NombreInvalidoException;
import Excepciones.NombreVacioException;
import Utils.UtilsDB;

public class PantallaBajaAnfibio extends JPanel{
	
	private Ventana ventana;
	private JTextField campoIdBaja;
	private JTextPane textAnfibioAlta;
	private JTextPane textAnfibioBaja;
	
	public PantallaBajaAnfibio(Ventana v) {
		this.ventana=v;
		setLayout(null);
		setSize (800,600);
		

		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarPantalla("menu");				
			}
		});
		btnVolver.setBackground(Color.ORANGE);
		btnVolver.setBounds(629, 18, 89, 37);
		add(btnVolver);
		
		final JComboBox comboBaja = new JComboBox();
		comboBaja.setModel(new DefaultComboBoxModel(new String[] {"...", "Muerte", "Traspaso"}));
		comboBaja.setMaximumRowCount(3);
		comboBaja.setBounds(545, 291, 114, 22);
		add(comboBaja);
		
		JLabel lblMotivoBaja = new JLabel("Motivo baja:");
		lblMotivoBaja.setForeground(Color.WHITE);
		lblMotivoBaja.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMotivoBaja.setBounds(549, 270, 100, 14);
		add(lblMotivoBaja);
		
		textAnfibioBaja = new JTextPane();
		textAnfibioBaja.setBackground(Color.LIGHT_GRAY);
		textAnfibioBaja.setFont(new Font("Tahoma", Font.BOLD, 12));
		textAnfibioBaja.setEditable(false);
		textAnfibioBaja.setBounds(76, 360, 573, 186);
		add(textAnfibioBaja);
		
		JLabel lblListaBaja = new JLabel("LISTA DE BAJAS DE ANFIBIO");
		lblListaBaja.setForeground(Color.WHITE);
		lblListaBaja.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblListaBaja.setBounds(257, 334, 231, 28);
		add(lblListaBaja);
		
		textAnfibioAlta = new JTextPane();
		textAnfibioAlta.setBackground(Color.ORANGE);
		textAnfibioAlta.setFont(new Font("Tahoma", Font.BOLD, 12));
		textAnfibioAlta.setEditable(false);
		textAnfibioAlta.setBounds(76, 74, 573, 175);
		add(textAnfibioAlta);
		
		JLabel lblListaAlta = new JLabel("LISTA DE ALTAS DE ANFIBIOS");
		lblListaAlta.setForeground(Color.WHITE);
		lblListaAlta.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblListaAlta.setBounds(245, 49, 250, 28);
		add(lblListaAlta);
		
		JLabel txtAnfibio = new JLabel("ANFIBIO");
		txtAnfibio.setForeground(Color.WHITE);
		txtAnfibio.setFont(new Font("Arial Black", Font.BOLD, 20));
		txtAnfibio.setBounds(76, 11, 127, 42);
		add(txtAnfibio);
		
		campoIdBaja = new JTextField();
		campoIdBaja.setBounds(282, 292, 46, 20);
		add(campoIdBaja);
		campoIdBaja.setColumns(10);
		
		JButton botonDarBaja = new JButton("Introducir ID");
		botonDarBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				Statement query = UtilsDB.conectarBD();
				
				short id = Short.parseShort(campoIdBaja.getText());
				 
				try {
					ResultSet cursor = query.executeQuery("select id, nombre, date_format(fechaNacimiento,'%d-%m-%Y') "
							+ "as fechaNacimiento,motivoAlta,fechaAlta,tipoOrden,tipoAmbiente,cuidados from altaAnfibio where id="+id+";");
					if(cursor.next()) {
						
						String nombre = cursor.getString("nombre");
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
						LocalDate fechaNacimiento = LocalDate.parse(cursor.getString("fechaNacimiento"),formatter);		
						LocalDate fechaBaja = LocalDate.now();
						String cuidados = cursor.getString("cuidados");
						MotivoBaja motivoBaja = null;
						TipoOrden tipoOrden = null;
						boolean tipoAmbiente = true;
						
						
						if(comboBaja.getSelectedItem().equals("Muerte")) {
							motivoBaja=MotivoBaja.MUERTE;
						}else if (comboBaja.getSelectedItem().equals("Traspaso")) {
							motivoBaja=MotivoBaja.TRASPASO;
						}else if(comboBaja.getSelectedItem().equals("...")){
							motivoBaja = MotivoBaja.___;
						}
						
						
						Anfibio an = new Anfibio(id, nombre, fechaNacimiento, motivoBaja, fechaBaja, tipoOrden,tipoAmbiente, cuidados);
						mostrarAnfibiosAlta();
						mostrarAnfibiosBaja();
						JOptionPane.showMessageDialog(ventana, "Registro exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
						
					}
					else {
						JOptionPane.showMessageDialog(null, "NO SE ENCUENTRA LA ID", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Error SQL", "ERROR", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (NombreVacioException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NombreInvalidoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (FechaFormatoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (MotivoVacioException e1) {
					JOptionPane.showMessageDialog(null, "Has dejado el motivo vacío.", "ERROR", JOptionPane.ERROR_MESSAGE);
					
				}
								
				
				UtilsDB.desconectarBD();
								
			}
		});
		
		JLabel lblIdBaja = new JLabel("ID de animal a dar de baja:");
		lblIdBaja.setBackground(Color.GREEN);
		lblIdBaja.setForeground(Color.WHITE);
		lblIdBaja.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblIdBaja.setBounds(89, 286, 195, 28);
		add(lblIdBaja);
		botonDarBaja.setBackground(Color.RED);
		botonDarBaja.setForeground(Color.BLACK);
		botonDarBaja.setBounds(348, 288, 106, 28);
		add(botonDarBaja);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("./fotos/BACKGROUND_sinlogo.jpg"));
		background.setBounds(0, 0, 800, 600);
		add(background);
		
		JLabel txtFechaBaja = new JLabel("New label");
		txtFechaBaja.setFont(new Font("Arial", Font.BOLD, 14));
		txtFechaBaja.setBounds(0, 0, 46, 14);
		add(txtFechaBaja);
		
		mostrarAnfibiosAlta();
		mostrarAnfibiosBaja();
		
	}
	private void mostrarAnfibiosAlta() {
		Statement query = UtilsDB.conectarBD();
		
		String listaAnfibios = "";
		
		ResultSet cursor;
		try {
			cursor = query.executeQuery("select * from altaAnfibio");
			
			while(cursor.next()) {
				String id = cursor.getString("id");
				String nombre = cursor.getString("nombre");
				listaAnfibios +="●ID: "+ id +"     ●Nombre: "+ nombre + "\n";
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		textAnfibioAlta.setText(listaAnfibios);
	}
	
	private void mostrarAnfibiosBaja() {
		Statement query = UtilsDB.conectarBD();
		
		String listaAnfibios = "";
		
		ResultSet cursor;
		try {
			cursor = query.executeQuery("select * from bajaAnfibio");
			
			while(cursor.next()) {
				String id = cursor.getString("id");
				String nombre = cursor.getString("nombre");
				String motivoBaja = cursor.getString("motivoBaja");
				listaAnfibios +="●ID: "+ id +"     ●Nombre: "+ nombre + "\n";
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		textAnfibioBaja.setText(listaAnfibios);
	}
	
}
