package Pantallas;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
/**
 * Clase que implementa la pantalla de baja de los anfibios y extiende de JPanel.
 * @author Agustín Arcos
 *
 */
public class PantallaBajaAnfibio extends JPanel{
	/**
	 * Ventana en la que se muestra la pantalla actual.
	 */
	private Ventana ventana;
	/**
	 * Campo donde el usuario introduce el id a dar de baja.
	 */
	private JTextField campoIdBaja;
	/**
	 * Panel donde aparecen los animales dados de alta.
	 */
	private JTextPane textAnfibioAlta;
	/**
	 * Panel donde aparecen los animales dados de baja.
	 */
	private JTextPane textAnfibioBaja;
	/**
	 * String que muestra todos los anfibios dados de alta y de baja.
	 */
	private String listaTotalAnfibios;
	
	/**
	 * Constructor que implementa el funcionamiento de la pantalla de baja de los anfibios.
	 * @param v
	 */
	public PantallaBajaAnfibio(Ventana v) {
		this.ventana=v;
		setLayout(null);
		setSize (800,600);
		

		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			/**
			 * Función que te devuelve a la pantalla menú.
			 * @param e Variable que activa el evento.
			 */
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarPantalla("menu");				
			}
		});
		btnVolver.setBackground(Color.ORANGE);
		btnVolver.setBounds(629, 18, 89, 37);
		add(btnVolver);
		
		JButton btnExportarAnimales = new JButton("Exportar \r\nLista animales");
		btnExportarAnimales.addActionListener(new ActionListener() {
			/**
			 * Función que exporta un archivo de texto con la lista de animales dados de alta y de baja.
			 * @param e Variable que activa el evento.
			 */
			public void actionPerformed(ActionEvent e) {
				try {
					FileWriter escritor = new FileWriter("./archivosTxt/altaBajasAnfibios - "+LocalDate.now()+".txt");
					escritor.write(listaTotalAnfibios);
					escritor.flush();
					JOptionPane.showMessageDialog(null, "Lista exportada", "Éxito", JOptionPane.INFORMATION_MESSAGE);
					
				} catch (IOException e1) {
					
					JOptionPane.showMessageDialog(null, "La carpeta no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnExportarAnimales.setBounds(284, 22, 154, 28);
		add(btnExportarAnimales);
		
		final JComboBox comboBaja = new JComboBox();
		comboBaja.setModel(new DefaultComboBoxModel(new String[] {"...", "Muerte", "Traspaso"}));
		comboBaja.setMaximumRowCount(3);
		comboBaja.setBounds(334, 291, 114, 22);
		add(comboBaja);
		
		JLabel lblMotivoBaja = new JLabel("Motivo baja:");
		lblMotivoBaja.setForeground(Color.WHITE);
		lblMotivoBaja.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMotivoBaja.setBounds(336, 275, 100, 14);
		add(lblMotivoBaja);
		
		textAnfibioBaja = new JTextPane();
		textAnfibioBaja.setBackground(Color.LIGHT_GRAY);
		textAnfibioBaja.setFont(new Font("Tahoma", Font.BOLD, 12));
		textAnfibioBaja.setEditable(false);
		
		JScrollPane anfbaj = new JScrollPane(textAnfibioBaja);
		anfbaj.setBounds(76, 360, 573, 186);
		add(anfbaj); 
		
		
		
		
		JLabel lblListaBaja = new JLabel("LISTA DE BAJAS DE ANFIBIO");
		lblListaBaja.setForeground(Color.WHITE);
		lblListaBaja.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblListaBaja.setBounds(257, 334, 231, 28);
		add(lblListaBaja);
		
		textAnfibioAlta = new JTextPane();
		textAnfibioAlta.setBackground(Color.ORANGE);
		textAnfibioAlta.setFont(new Font("Tahoma", Font.BOLD, 12));
		textAnfibioAlta.setEditable(false);
		
		//------//
		JScrollPane anfalt = new JScrollPane(textAnfibioAlta);
		anfalt.setBounds(76, 74, 573, 175);
		add(anfalt);
		
		
		
		
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
		campoIdBaja.setBounds(258, 292, 46, 20);
		add(campoIdBaja);
		campoIdBaja.setColumns(10);
		
		JButton botonDarBaja = new JButton("DAR DE BAJA");
		botonDarBaja.setIcon(new ImageIcon("./gif/muerte.gif"));
		botonDarBaja.addActionListener(new ActionListener() {
			/**
			 * Función que registra y guarda los campos de baja del anfibio cuando el usuario hace click. 
			 * @param e Variable que activa el evento.
			 */
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
						listaTotalAnfibios = "";
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
		lblIdBaja.setBounds(69, 286, 195, 28);
		add(lblIdBaja);
		botonDarBaja.setBackground(Color.RED);
		botonDarBaja.setForeground(Color.BLACK);
		botonDarBaja.setBounds(503, 260, 195, 74);
		add(botonDarBaja);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("./fotos/BACKGROUND_sinlogo.jpg"));
		background.setBounds(0, 0, 800, 600);
		add(background);
		
		JLabel txtFechaBaja = new JLabel("New label");
		txtFechaBaja.setFont(new Font("Arial", Font.BOLD, 14));
		txtFechaBaja.setBounds(0, 0, 46, 14);
		add(txtFechaBaja);
		

		listaTotalAnfibios = ""; 
		mostrarAnfibiosAlta();
		mostrarAnfibiosBaja();
		
	}
	/**
	 * Función que muestra los anfibios dados de alta en la base de datos.
	 */
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
		//
		listaTotalAnfibios += "Anfibios dados de Alta: \n" + listaAnfibios + "\n----------------\n";
		textAnfibioAlta.setText(listaAnfibios);
	}
	/**
	 * Función que muestra los anfibios dados de baja en la base de datos.
	 */
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
		
		listaTotalAnfibios += "Anfibios dados de Baja: \n" + listaAnfibios + "\n----------------\n";
		textAnfibioBaja.setText(listaAnfibios);
	}
}
