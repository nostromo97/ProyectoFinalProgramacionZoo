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
import java.util.EnumSet;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Clases.Primate;
import Clases.Usuario;
import Enums.MotivoAlta;
import Excepciones.FechaFormatoException;
import Excepciones.NombreInvalidoException;
import Excepciones.NombreVacioException;

import javax.swing.JRadioButton;

public class PantallaAltaPrimate extends JPanel{
	
	private Ventana ventana;
	private JTextField campoNombre;
	private JTextField campoFechaNacimiento;
	private JTextField campoFechaAlta;
	private JTextField campoDescripcion;
	
	public PantallaAltaPrimate(Ventana v) {
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
		
		
		final JRadioButton campoFemenino = new JRadioButton("Femenino");
		campoFemenino.setBounds(57, 420, 89, 23);
		add(campoFemenino);
		
		final JRadioButton campoMasculino = new JRadioButton("Masculino");
		campoMasculino.setBounds(57, 392, 90, 23);
		add(campoMasculino);
		
		
		 final ButtonGroup grupoGenero = new ButtonGroup();
		grupoGenero.add(campoMasculino);
		grupoGenero.add(campoFemenino);
		
		campoDescripcion = new JTextField();
		campoDescripcion.setBounds(292, 372, 172, 94);
		add(campoDescripcion);
		campoDescripcion.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n:");
		lblDescripcion.setForeground(Color.WHITE);
		lblDescripcion.setBounds(232, 375, 67, 14);
		add(lblDescripcion);
		
		JLabel lblCuidados = new JLabel("CUIDADOS:");
		lblCuidados.setForeground(Color.WHITE);
		lblCuidados.setFont(new Font("Arial", Font.BOLD, 12));
		lblCuidados.setBounds(220, 360, 78, 14);
		add(lblCuidados);
		
		JLabel txtGenero = new JLabel("G\u00C9NERO:");
		txtGenero.setHorizontalAlignment(SwingConstants.CENTER);
		txtGenero.setForeground(Color.WHITE);
		txtGenero.setFont(new Font("Arial", Font.BOLD, 13));
		txtGenero.setBounds(57, 360, 78, 26);
		add(txtGenero);
		
		campoFechaAlta = new JTextField();
		campoFechaAlta.setBounds(232, 309, 215, 20);
		add(campoFechaAlta);
		campoFechaAlta.setColumns(10);
		
		final JComboBox comboAlta = new JComboBox();
		comboAlta.setModel(new DefaultComboBoxModel(new String[] {"...", "Nacimiento", "Translado"}));
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
		
		JLabel txtPrimate = new JLabel("PRIMATE");
		txtPrimate.setForeground(Color.WHITE);
		txtPrimate.setFont(new Font("Arial Black", Font.BOLD, 20));
		txtPrimate.setBounds(615, 245, 127, 42);
		add(txtPrimate);
		
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
		
		//DATOS PRIMATE
		JButton botonDarAlta = new JButton("DAR DE ALTA PRIMATE");
		botonDarAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nombrePrimate = campoNombre.getText();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					LocalDate fechaNacimiento = LocalDate.parse(campoFechaNacimiento.getText(),formatter);
					LocalDate fechaAlta = LocalDate.parse(campoFechaAlta.getText(),formatter);
					String tratamientoDescripcion = campoDescripcion.getText();
					MotivoAlta motivoAlta=null;
							
					
							if(comboAlta.getSelectedItem().equals("Nacimiento")) {
								motivoAlta=MotivoAlta.NACIMIENTO;
							}else if (comboAlta.getSelectedItem().equals("Llegada")) {
								motivoAlta=MotivoAlta.LLEGADA;
							}else {
								JOptionPane.showMessageDialog(null, "HAS DEJADO EL MOTIVO DE ALTA VACÍO", "AVISO", JOptionPane.INFORMATION_MESSAGE);
							}
							
							
					
					boolean genero=true;
					if(campoMasculino.isSelected()) {
						genero=true;
					}else if(campoFemenino.isSelected()) {
						genero=false;
					}
					
				
						Primate primate1 = new Primate(nombrePrimate, fechaNacimiento, motivoAlta, fechaAlta, genero, tratamientoDescripcion);
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
		botonDarAlta.setBounds(526, 499, 202, 60);
		add(botonDarAlta);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("C:\\Users\\carol\\Documents\\Eclipse-WORKSPACE\\ProyectoFinalProgramacionZoo\\ProyectoFinal_AgustinArcos\\fotos\\BACKGROUND.jpg"));
		background.setBounds(0, 0, 800, 600);
		add(background);
	}
}
