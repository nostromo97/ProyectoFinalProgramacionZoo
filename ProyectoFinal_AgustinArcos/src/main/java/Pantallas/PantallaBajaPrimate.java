package Pantallas;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
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
import javax.swing.SwingConstants;

import Clases.Primate;
import Enums.MotivoAlta;
import Enums.MotivoBaja;
import Excepciones.DescripcionVaciaException;
import Excepciones.FechaFormatoException;
import Excepciones.IdInvalidoException;
import Excepciones.IdVacioException;
import Excepciones.MotivoVacioException;
import Excepciones.NombreInvalidoException;
import Excepciones.NombreVacioException;
import Utils.UtilsDB;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
/**
 * Clase que implementa la pantalla de baja de los primates y extiende de JPanel.
 * @author Agustín Arcos
 *
 */
public class PantallaBajaPrimate extends JPanel{
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
	private JTextPane textPrimateAlta;
	/**
	 * Panel donde aparecen los animales dados de baja.
	 */
	private JTextPane textPrimateBaja;
	/**
	 * String que muestra todos los primates dados de alta y de baja.
	 */
	private String listaTotalPrimates;
	/**
	 * Constructor que implementa el funcionamiento de la pantalla de baja de los primates.
	 * @param v
	 */
	public PantallaBajaPrimate(Ventana v) {
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
			
			JLabel lblMotivoBaja = new JLabel("Motivo baja:");
			lblMotivoBaja.setForeground(Color.WHITE);
			lblMotivoBaja.setFont(new Font("Arial", Font.BOLD, 14));
			lblMotivoBaja.setBounds(312, 271, 119, 14);
			add(lblMotivoBaja);
			
			JButton btnExportarAnimales = new JButton("Exportar \r\nLista animales");
			btnExportarAnimales.addActionListener(new ActionListener() {
				/**
				 * Función que exporta un archivo de texto con la lista de animales dados de alta y de baja.
				 * @param e Variable que activa el evento.
				 */
				public void actionPerformed(ActionEvent e) {
					try {
						FileWriter escritor = new FileWriter("./archivosTxt/altaBajasPrimates - "+LocalDate.now()+".txt");
						escritor.write(listaTotalPrimates);
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
			comboBaja.setBounds(312, 291, 155, 22);
			add(comboBaja);
			btnVolver.setBackground(Color.ORANGE);
			btnVolver.setBounds(629, 18, 89, 37);
			add(btnVolver);
			
		
			textPrimateBaja = new JTextPane();
			textPrimateBaja.setBackground(Color.LIGHT_GRAY);
			textPrimateBaja.setFont(new Font("Tahoma", Font.BOLD, 12));
			textPrimateBaja.setEditable(false);
			 
			JScrollPane scrBaja = new JScrollPane(textPrimateBaja);
			scrBaja.setBounds(76, 360, 573, 186);
			add(scrBaja); 
			
			
			JLabel lblListaBaja = new JLabel("LISTA DE BAJAS DE PRIMATES");
			lblListaBaja.setForeground(Color.WHITE);
			lblListaBaja.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblListaBaja.setBounds(257, 334, 231, 28);
			add(lblListaBaja);
			
			
			textPrimateAlta = new JTextPane();
			textPrimateAlta.setBackground(Color.ORANGE);
			textPrimateAlta.setFont(new Font("Tahoma", Font.BOLD, 12));
			textPrimateAlta.setEditable(false);
			
			JScrollPane scrAlta = new JScrollPane(textPrimateAlta);
			scrAlta.setBounds(76, 74, 573, 175);
			add(scrAlta); 
		
			
			
			
			
			JLabel lblListaAlta = new JLabel("LISTA DE ALTAS DE PRIMATES");
			lblListaAlta.setForeground(Color.WHITE);
			lblListaAlta.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblListaAlta.setBounds(245, 49, 250, 28);
			add(lblListaAlta);
			
			JLabel txtPrimate = new JLabel("PRIMATE");
			txtPrimate.setForeground(Color.WHITE);
			txtPrimate.setFont(new Font("Arial Black", Font.BOLD, 20));
			txtPrimate.setBounds(76, 11, 127, 42);
			add(txtPrimate);
			
			campoIdBaja = new JTextField();
			campoIdBaja.setBounds(245, 292, 46, 20);
			add(campoIdBaja);
			campoIdBaja.setColumns(10);
			
			JLabel lblIdBaja = new JLabel("ID de animal a dar de baja:");
			lblIdBaja.setBackground(Color.GREEN);
			lblIdBaja.setForeground(Color.WHITE);
			lblIdBaja.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			lblIdBaja.setBounds(49, 286, 195, 28);
			add(lblIdBaja);
			
			
			
			JButton botonDarBaja = new JButton("DAR DE BAJA");
			botonDarBaja.setIcon(new ImageIcon("./gif/muerte.gif"));
			botonDarBaja.addActionListener(new ActionListener() {
				/**
				 * Función que registra y guarda los campos de baja del primate cuando el usuario hace click. 
				 * @param e Variable que activa el evento.
				 */
				public void actionPerformed(ActionEvent e) {
					
					
					Statement query = UtilsDB.conectarBD();
					
					short id = Short.parseShort(campoIdBaja.getText());
					
					try {
						ResultSet cursor = query.executeQuery("select id, nombre, date_format(fechaNacimiento,'%d-%m-%Y') "
								+ "as fechaNacimiento,motivoAlta,fechaAlta,genero,cuidados from altaPrimate where id="+id+";");
						if(cursor.next()) {
							

							String nombre = cursor.getString("nombre");
							DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
							LocalDate fechaNacimiento = LocalDate.parse(cursor.getString("fechaNacimiento"),formatter);		
							LocalDate fechaBaja = LocalDate.now();
							boolean genero = cursor.getBoolean("genero");
							String cuidados = cursor.getString("cuidados");
							MotivoBaja motivoBaja = null;
							
							if(comboBaja.getSelectedItem().equals("Muerte")) {
								motivoBaja=MotivoBaja.MUERTE;
							}else if (comboBaja.getSelectedItem().equals("Traspaso")) {
								motivoBaja=MotivoBaja.TRASPASO;
							}else if(comboBaja.getSelectedItem().equals("...")){
								motivoBaja = MotivoBaja.___;
							}
							
							
							
							Primate p = new Primate(id,nombre,fechaNacimiento,motivoBaja,fechaBaja,genero,cuidados);
							listaTotalPrimates ="";
							mostrarPrimatesAlta();
							mostrarPrimatesBaja();
							JOptionPane.showMessageDialog(ventana, "Registro exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
							
						}
						else {
							JOptionPane.showMessageDialog(null, "NO SE ENCUENTRA LA ID", "ERROR", JOptionPane.ERROR_MESSAGE);
						}
						
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Error en la base de datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					} catch (NombreVacioException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NombreInvalidoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (FechaFormatoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (MotivoVacioException e1) {
						JOptionPane.showMessageDialog(null, "Motivo de baja vacío", "ERROR", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					} catch (IdVacioException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					} catch (IdInvalidoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
						
					
					
					UtilsDB.desconectarBD();
					
					
				}
			});
			botonDarBaja.setBackground(Color.RED);
			botonDarBaja.setForeground(Color.BLACK);
			botonDarBaja.setBounds(503, 260, 195, 74);
			add(botonDarBaja);
			
			JLabel background = new JLabel("");
			background.setIcon(new ImageIcon("./fotos/BACKGROUND_sinlogo.jpg"));
			background.setBounds(0, 0, 800, 600);
			add(background);
			
			listaTotalPrimates="";
			mostrarPrimatesAlta();
			mostrarPrimatesBaja();
		
	}
	/**
	 * Función que muestra los primates dados de alta en la base de datos.
	 */
	private void mostrarPrimatesAlta() {
		Statement query = UtilsDB.conectarBD();
		
		String listaPrimates = "";
		
		ResultSet cursor;
		try {
			cursor = query.executeQuery("select * from altaPrimate");
			
			while(cursor.next()) {
				String id = cursor.getString("id");
				String nombre = cursor.getString("nombre");
				listaPrimates +="●ID: "+ id +"     ●Nombre: "+ nombre + "\n";
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		listaTotalPrimates += "Primates dados de Alta: \n" + listaPrimates + "\n----------------\n";
		textPrimateAlta.setText(listaPrimates);
	}
	/**
	 * Función que muestra los primates dados de baja en la base de datos.
	 */	
	private void mostrarPrimatesBaja() {
		Statement query = UtilsDB.conectarBD();
		
		String listaPrimates = "";
		
		ResultSet cursor;
		try {
			cursor = query.executeQuery("select * from bajaPrimate");
			
			while(cursor.next()) {
				String id = cursor.getString("id");
				String nombre = cursor.getString("nombre");
				String motivoBaja = cursor.getString("motivoBaja");
				listaPrimates +="●ID: "+ id +"||     ●Nombre: "+ nombre + "\n";
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listaTotalPrimates += "Primates dados de Baja: \n" + listaPrimates + "\n----------------\n";
		textPrimateBaja.setText(listaPrimates);
	}
}
