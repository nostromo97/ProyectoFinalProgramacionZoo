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

import Clases.Anfibio;
import Clases.Primate;
import Enums.MotivoAlta;
import Enums.TipoOrden;
import Excepciones.CampoVacioException;
import Excepciones.DescripcionVaciaException;
import Excepciones.FechaFormatoException;
import Excepciones.MotivoVacioException;
import Excepciones.NombreInvalidoException;
import Excepciones.NombreVacioException;
import Excepciones.TipoAmbienteVacioException;
import Excepciones.TipoOrdenVacioException;

import javax.swing.JRadioButton;

public class PantallaAltaAnfibio extends JPanel{
	
	private Ventana ventana;
	private JTextField campoNombre;
	private JTextField campoFechaNacimiento;
	private JTextField campoFechaAlta;
	private JTextField campoDescripcion;
	
	public PantallaAltaAnfibio(Ventana v) {
		this.ventana=v;
		setLayout(null);
		setSize (800,600);
		
		
		
		JButton btnAtras = new JButton("Volver");
		btnAtras.setBackground(Color.ORANGE);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarPantalla("menu");
			}
		});
		
		JLabel gifAnfibio_1_1 = new JLabel("");
		
		gifAnfibio_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		gifAnfibio_1_1.setIcon(new ImageIcon("./gif/anfibio.gif"));
		gifAnfibio_1_1.setBounds(457, 230, 253, 231);
		add(gifAnfibio_1_1);
		
		final JComboBox comboOrden = new JComboBox();
		comboOrden.setModel(new DefaultComboBoxModel(new String[] {"...", "Anura", "Caudata", "Gymnophiona"}));
		comboOrden.setMaximumRowCount(4);
		comboOrden.setBounds(60, 359, 121, 22);
		add(comboOrden);

		
		
		final JRadioButton rdbtnAmbiente2 = new JRadioButton("Seco");
		rdbtnAmbiente2.setBounds(78, 468, 102, 23);
		add(rdbtnAmbiente2);
		
		final JRadioButton rdbtnAmbiente1 = new JRadioButton("Acu\u00E1tico");
		rdbtnAmbiente1.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnAmbiente1.setBounds(78, 442, 102, 23);
		add(rdbtnAmbiente1);
		btnAtras.setForeground(Color.BLACK);
		btnAtras.setBounds(629, 53, 89, 77);
		add(btnAtras);
			
		final ButtonGroup grupoAmbiente = new ButtonGroup();
		grupoAmbiente.add(rdbtnAmbiente1);
		grupoAmbiente.add(rdbtnAmbiente2);
		
		
		
		campoDescripcion = new JTextField();
		campoDescripcion.setBounds(272, 385, 175, 86);
		add(campoDescripcion);
		campoDescripcion.setColumns(10);
		
		JLabel lblDescripción = new JLabel("Descripci\u00F3n:");
		lblDescripción.setForeground(Color.WHITE);
		lblDescripción.setBounds(210, 388, 67, 14);
		add(lblDescripción);
		
		JLabel lblCuidados = new JLabel("CUIDADOS:");
		lblCuidados.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCuidados.setForeground(Color.WHITE);
		lblCuidados.setBounds(232, 362, 67, 14);
		add(lblCuidados);
		
		JLabel txtAmbiente = new JLabel("AMBIENTE:");
		txtAmbiente.setFont(new Font("Arial", Font.BOLD, 12));
		txtAmbiente.setForeground(Color.WHITE);
		txtAmbiente.setBounds(78, 421, 67, 14);
		add(txtAmbiente);
		
		JLabel txtOrden = new JLabel("ORDEN:");
		txtOrden.setForeground(Color.WHITE);
		txtOrden.setFont(new Font("Arial", Font.BOLD, 12));
		txtOrden.setBounds(81, 343, 46, 14);
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
		
		JLabel txtAnfibio = new JLabel("ANFIBIO");
		txtAnfibio.setForeground(Color.WHITE);
		txtAnfibio.setFont(new Font("Arial Black", Font.BOLD, 20));
		txtAnfibio.setBounds(604, 245, 127, 42);
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
		
		JButton botonDarAlta = new JButton("DAR DE ALTA ANFIBIO");
		
		botonDarAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nombreAnfibio = campoNombre.getText();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					LocalDate fechaNacimiento = LocalDate.parse(campoFechaNacimiento.getText(),formatter);
					LocalDate fechaAlta = LocalDate.parse(campoFechaAlta.getText(),formatter);
					String tratamientoDescripcion = campoDescripcion.getText();
					TipoOrden tipoOrden=null;
					MotivoAlta motivoAlta=null;			
					
					
							if(comboAlta.getSelectedItem().equals("Nacimiento")) {
								motivoAlta=MotivoAlta.NACIMIENTO;
							}else if (comboAlta.getSelectedItem().equals("Llegada")) {
								motivoAlta=MotivoAlta.LLEGADA;
							}else if (comboAlta.getSelectedItem().equals("...")){
								JOptionPane.showMessageDialog(null, "HAS DEJADO EL MOTIVO DE ALTA VACÍO", "AVISO", JOptionPane.INFORMATION_MESSAGE);
							}
							
							if(comboOrden.getSelectedItem().equals("Anura")) {
								tipoOrden = TipoOrden.ANURA;
							}else if (comboOrden.getSelectedItem().equals("Caudata")) {
								tipoOrden = TipoOrden.CAUDATA;
							}else if (comboOrden.getSelectedItem().equals("Gymnophiona")) {
								tipoOrden = TipoOrden.GYMNOPHIONA;
							}else if(comboOrden.getSelectedItem().equals("...")){
								tipoOrden = TipoOrden.___;
							}
							
							
					
					boolean tipoAmbiente=true;
					if(rdbtnAmbiente1.isSelected()) {
						tipoAmbiente=true;
					}else if(rdbtnAmbiente2.isSelected()) {
						tipoAmbiente=false;
					}if(!rdbtnAmbiente1.isSelected() && (!rdbtnAmbiente2.isSelected())) {

						JOptionPane.showMessageDialog(null, "Error. El tipo de ambiente no puede estar vacío.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}else {
						
					
					
				
						Anfibio anfibio1 = new Anfibio(nombreAnfibio, fechaNacimiento, motivoAlta, fechaAlta, tipoOrden,tipoAmbiente, tratamientoDescripcion);
						//JOPTION PANE QUE DIGA REGISTRO EXITOSO DE TIPO OK_MESSAGE
						JOptionPane.showMessageDialog(ventana, "Registro exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
						//IR A PANTALLA METER ANIMALES
						ventana.cambiarPantalla("menu");
					}
					} catch (NombreVacioException e1) {
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
						JOptionPane.showMessageDialog(null, "Has dejado el motivo de baja vacío", "ERROR", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					} catch (CampoVacioException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					} catch (TipoOrdenVacioException e1) {
						JOptionPane.showMessageDialog(null, "Error. El tipo de orden no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					} catch (TipoAmbienteVacioException e1) {
						JOptionPane.showMessageDialog(null, "Error. El tipo de ambiente no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					} catch (DescripcionVaciaException e1) {
						JOptionPane.showMessageDialog(null, "AVISO. Has dejado la descripción vacía.", "AVISO",JOptionPane.WARNING_MESSAGE);
						e1.printStackTrace();
					}
				
				
				
				
				
			}
		});
		
		JLabel txtNombre = new JLabel("NOMBRE:");
		txtNombre.setForeground(Color.WHITE);
		txtNombre.setFont(new Font("Arial", Font.BOLD, 14));
		txtNombre.setBounds(158, 177, 67, 14);
		add(txtNombre);
		
		campoNombre = new JTextField();
		campoNombre.setBounds(230, 174, 217, 20);
		add(campoNombre);
		campoNombre.setColumns(10);
		botonDarAlta.setBackground(Color.GREEN);
		botonDarAlta.setForeground(Color.BLACK);
		botonDarAlta.setBounds(559, 500, 202, 60);
		add(botonDarAlta);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("./fotos/BACKGROUND.jpg"));
		background.setBounds(0, 0, 800, 600);
		add(background);
	}
}
