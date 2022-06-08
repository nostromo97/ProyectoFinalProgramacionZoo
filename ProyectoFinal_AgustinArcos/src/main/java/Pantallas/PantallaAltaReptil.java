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
import Enums.TipoPiel;
import Excepciones.FechaFormatoException;
import Excepciones.NombreInvalidoException;
import Excepciones.NombreVacioException;

import javax.swing.JRadioButton;

public class PantallaAltaReptil extends JPanel{
	
	private Ventana ventana;
	private JTextField campoNombre;
	private JTextField campoFechaNacimiento;
	private JTextField campoFechaAlta;
	private JTextField campoDescripcionCuidados;
	
	public PantallaAltaReptil(Ventana v) {
		this.ventana=v;
		setLayout(null);
		setSize (800,600);
				
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
		txtAnfibio.setBounds(559, 245, 127, 42);
		add(txtAnfibio);
		
		JButton botonDieta = new JButton("DIETA");
		botonDieta.setBounds(500, 403, 89, 23);
		add(botonDieta);
		
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
							}else {
								JOptionPane.showMessageDialog(null, "Motivo de alta vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
							}
					
					boolean tipoPiel=true;
					if(rdbtnPiel1.isSelected()) {
						tipoPiel=true;
					}else if(rdbtnPiel2.isSelected()) {
						tipoPiel=false;
					}
					
				
						Reptil reptil1 = new Reptil(nombreReptil, fechaNacimiento, motivoAlta, fechaAlta, tipoPiel, tratamientoDescripcion);
						//JOPTION PANE QUE DIGA REGISTRO EXITOSO DE TIPO OK_MESSAGE
						JOptionPane.showMessageDialog(ventana, "Registro exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
						//IR A PANTALLA METER ANIMALES
						ventana.cambiarPantalla("menu");
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
		background.setIcon(new ImageIcon("C:\\Users\\carol\\Documents\\Eclipse-WORKSPACE\\ProyectoFinalProgramacionZoo\\ProyectoFinal_AgustinArcos\\fotos\\BACKGROUND.jpg"));
		background.setBounds(0, 0, 800, 600);
		add(background);
	}
}
