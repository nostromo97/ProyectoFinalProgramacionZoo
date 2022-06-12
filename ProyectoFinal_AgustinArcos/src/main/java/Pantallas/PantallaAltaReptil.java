package Pantallas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Clases.Primate;
import Clases.Reptil;
import Enums.MotivoAlta;
import Excepciones.DescripcionVaciaException;
import Excepciones.FechaFormatoException;
import Excepciones.MotivoVacioException;
import Excepciones.NombreInvalidoException;
import Excepciones.NombreVacioException;

import javax.swing.JRadioButton;
/**
 * Clase que implementa la pantalla de alta de los primates y extiende de JPanel.
 * @author Agustín Arcos
 *
 */
public class PantallaAltaReptil extends JPanel{
	/**
	 * Ventana en la que se muestra la pantalla actual.
	 */
	private Ventana ventana;
	/**
	 * Campo donde el usuario introduce el nombre del animal.
	 */
	private JTextField campoNombre;
	/**
	 * Campo donde el usuario introduce la fecha de nacimiento del animal.
	 */
	private JTextField campoFechaNacimiento;
	/**
	 * Campo donde el usuario introduce la fecha de alta del animal.
	 */
	private JTextField campoFechaAlta;
	/**
	 * Campo donde el usuario introduce la descripción de los cuidados del animal.
	 */
	private JTextField campoDescripcionCuidados;
	/**
	 * Constructor que implementa el funcionamiento de la pantalla de alta de los reptiles.
	 * @param v
	 */
	public PantallaAltaReptil(Ventana v) {
		this.ventana=v;
		setLayout(null);
		setSize (800,600);
		
		JLabel lblGifTortuga = new JLabel("");
		lblGifTortuga.setIcon(new ImageIcon("./gif/tortuga.gif"));
		lblGifTortuga.setBounds(556, 249, 202, 201);
		add(lblGifTortuga);
				
		final JRadioButton rdbtnPiel2 = new JRadioButton("Caparaz\u00F3n");
		rdbtnPiel2.setBounds(58, 414, 89, 23);
		add(rdbtnPiel2);
		
		final JRadioButton rdbtnPiel1 = new JRadioButton("Escamas");
		rdbtnPiel1.setBounds(58, 385, 89, 23);
		add(rdbtnPiel1);
		
		final ButtonGroup grupoPiel = new ButtonGroup();
		grupoPiel.add(rdbtnPiel1);
		grupoPiel.add(rdbtnPiel2);
		
		
		JButton btnAtras = new JButton("Volver");
		btnAtras.setBackground(Color.ORANGE);
		btnAtras.addActionListener(new ActionListener() {
			/**
			 * Función que te devuelve a la pantalla menú.
			 * @param e Variable que activa el evento.
			 */
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarPantalla("menu");
			}
		});
		btnAtras.setForeground(Color.BLACK);
		btnAtras.setBounds(629, 53, 89, 77);
		add(btnAtras);
		
		campoDescripcionCuidados = new JTextField();
		campoDescripcionCuidados.setBounds(276, 404, 171, 78);
		add(campoDescripcionCuidados);
		campoDescripcionCuidados.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n:");
		lblDescripcion.setForeground(Color.WHITE);
		lblDescripcion.setBounds(216, 407, 67, 14);
		add(lblDescripcion);
		
		JLabel lblCuidados = new JLabel("CUIDADOS:");
		lblCuidados.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCuidados.setForeground(Color.WHITE);
		lblCuidados.setBounds(226, 388, 75, 14);
		add(lblCuidados);
		
		JLabel txtOrden = new JLabel("PIEL:");
		txtOrden.setForeground(Color.WHITE);
		txtOrden.setFont(new Font("Arial", Font.BOLD, 12));
		txtOrden.setBounds(88, 368, 46, 14);
		add(txtOrden);
		
		campoFechaAlta = new JTextField();
		campoFechaAlta.setBounds(232, 309, 215, 20);
		add(campoFechaAlta);
		campoFechaAlta.setColumns(10);
		
		final JComboBox comboAlta = new JComboBox();
		comboAlta.setModel(new DefaultComboBoxModel(new String[] {"...", "Nacimiento", "Llegada"}));
		comboAlta.setMaximumRowCount(3);
		comboAlta.setBounds(232, 259, 215, 22);
		add(comboAlta);
		
		JLabel txFechaAlta = new JLabel("FECHA ALTA:");
		txFechaAlta.setHorizontalAlignment(SwingConstants.RIGHT);
		txFechaAlta.setFont(new Font("Arial", Font.BOLD, 14));
		txFechaAlta.setForeground(Color.WHITE);
		txFechaAlta.setBounds(119, 313, 110, 14);
		add(txFechaAlta);
		
		JLabel txtAlta = new JLabel("MOTIVO ALTA:");
		txtAlta.setHorizontalAlignment(SwingConstants.RIGHT);
		txtAlta.setForeground(Color.WHITE);
		txtAlta.setFont(new Font("Arial", Font.BOLD, 14));
		txtAlta.setBounds(81, 262, 148, 14);
		add(txtAlta);
		
		JLabel txtAnfibio = new JLabel("REPTIL");
		txtAnfibio.setForeground(Color.WHITE);
		txtAnfibio.setFont(new Font("Arial Black", Font.BOLD, 20));
		txtAnfibio.setBounds(591, 214, 127, 42);
		add(txtAnfibio);
		
		JLabel txtFechaNacimiento = new JLabel("FECHA NACIMIENTO:");
		txtFechaNacimiento.setFont(new Font("Arial", Font.BOLD, 14));
		txtFechaNacimiento.setForeground(Color.WHITE);
		txtFechaNacimiento.setBounds(81, 217, 148, 14);
		add(txtFechaNacimiento);
		
		campoFechaNacimiento = new JTextField();
		campoFechaNacimiento.setBounds(232, 214, 215, 20);
		add(campoFechaNacimiento);
		campoFechaNacimiento.setColumns(10);
		
		JLabel txtNombre = new JLabel("NOMBRE:");
		txtNombre.setForeground(Color.WHITE);
		txtNombre.setFont(new Font("Arial", Font.BOLD, 14));
		txtNombre.setBounds(158, 177, 67, 14);
		add(txtNombre);
		JButton botonDarAlta = new JButton("DAR DE ALTA REPTIL");
		botonDarAlta.addActionListener(new ActionListener() {
			/**
			 * Función que registra y guarda los campos de alta del reptil cuando el usuario hace click. 
			 * @param e Variable que activa el evento.
			 */
			public void actionPerformed(ActionEvent e) {
				try {
					String nombreReptil = campoNombre.getText();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					LocalDate fechaNacimiento = LocalDate.parse(campoFechaNacimiento.getText(),formatter);
					LocalDate fechaAlta = LocalDate.parse(campoFechaAlta.getText(),formatter);
					String tratamientoDescripcion = campoDescripcionCuidados.getText();
					MotivoAlta motivoAlta=null;
					
							if(comboAlta.getSelectedItem().equals("Nacimiento")) {
								motivoAlta=MotivoAlta.NACIMIENTO;
							}else if (comboAlta.getSelectedItem().equals("Llegada")) {
								motivoAlta=MotivoAlta.LLEGADA;
							}else if(comboAlta.getSelectedItem().equals("...")){
								motivoAlta=MotivoAlta.___;
							}
					
							boolean tipoPiel = true;
							if (rdbtnPiel1.isSelected()) {
								tipoPiel = true;
							} else if (rdbtnPiel2.isSelected()) {
								tipoPiel = false;
							}
							if (!rdbtnPiel1.isSelected() && (!rdbtnPiel2.isSelected())) {

								JOptionPane.showMessageDialog(null, "Error. El campo tipo de piel no puede estar vacío.", "Error",
										JOptionPane.ERROR_MESSAGE);

							}else {
					
				
						Reptil reptil1 = new Reptil(nombreReptil, fechaNacimiento, motivoAlta, fechaAlta, tipoPiel, tratamientoDescripcion);
						//JOPTION PANE QUE DIGA REGISTRO EXITOSO DE TIPO OK_MESSAGE
						JOptionPane.showMessageDialog(ventana, "Registro exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
						//IR A PANTALLA METER ANIMALES
						ventana.cambiarPantalla("menu");
							}} catch (NombreVacioException e1) {
						JOptionPane.showMessageDialog(null, "Nombre Vacio", "Error", JOptionPane.WARNING_MESSAGE);
					} catch (NombreInvalidoException e1) {
						JOptionPane.showMessageDialog(null, "El nombre no puede contener números.", "Error", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Error SQL", "Error", JOptionPane.ERROR_MESSAGE);
					} catch (FechaFormatoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					} catch(DateTimeParseException e1) {
						JOptionPane.showMessageDialog(null, "Error. Introduce la fecha en un formato: dd-MM-YYYY (día, mes, año)", "Error", JOptionPane.ERROR_MESSAGE);
					} catch (MotivoVacioException e1) {
						JOptionPane.showMessageDialog(null, "Motivo de alta vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
						e1.printStackTrace();
					} catch (DescripcionVaciaException e1) {
						JOptionPane.showMessageDialog(null, "AVISO. Has dejado la descripción vacía.", "AVISO",JOptionPane.WARNING_MESSAGE);
						e1.printStackTrace();
					}
				
			}
		});
		
					
		campoNombre = new JTextField();
		campoNombre.setBounds(230, 174, 217, 20);
		add(campoNombre);
		campoNombre.setColumns(10);
		botonDarAlta.setBackground(Color.GREEN);
		botonDarAlta.setForeground(Color.BLACK);
		botonDarAlta.setBounds(556, 509, 202, 60);
		add(botonDarAlta);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("./fotos/BACKGROUND.jpg"));
		background.setBounds(0, 0, 800, 600);
		add(background);
	}
}
