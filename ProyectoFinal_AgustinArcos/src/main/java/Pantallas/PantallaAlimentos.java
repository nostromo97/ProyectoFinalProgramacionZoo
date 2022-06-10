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
import java.time.format.DateTimeParseException;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JTextField;

import Clases.Alimento;
import Clases.Primate;
import Enums.MotivoAlta;
import Enums.TipoAlimento;
import Excepciones.FechaFormatoException;
import Excepciones.NombreInvalidoException;
import Excepciones.NombreVacioException;
import Utils.UtilsDB;

public class PantallaAlimentos extends JPanel{
	
	private Ventana ventana;
	private JTextField campoCantidadAlimentos;
	private JTextField campoNombreAlimento;
	
	public PantallaAlimentos(Ventana v) {
		this.ventana=v;
		setLayout(null);
		setSize (800,600);
		
		JButton btnAtras = new JButton("VOLVER");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarPantalla("menu");
			}
		});
		
		JButton btnNewButton = new JButton("Lista de alimentos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarPantalla("listaAlimentos");
			}
		});
		btnNewButton.setBounds(567, 397, 124, 60);
		add(btnNewButton);
		
		campoNombreAlimento = new JTextField();
		campoNombreAlimento.setBounds(315, 196, 153, 20);
		add(campoNombreAlimento);
		campoNombreAlimento.setColumns(10);
		
		JLabel lblNombreAlimento = new JLabel("NOMBRE  DEL ALIMENTO:");
		lblNombreAlimento.setForeground(Color.WHITE);
		lblNombreAlimento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreAlimento.setBounds(299, 169, 198, 20);
		add(lblNombreAlimento);
		btnAtras.setBounds(42, 397, 124, 60);
		add(btnAtras);
		
		campoCantidadAlimentos = new JTextField();
		campoCantidadAlimentos.setBounds(347, 399, 86, 20);
		add(campoCantidadAlimentos);
		campoCantidadAlimentos.setColumns(10);
		
		JLabel lblCantidadAlimentos = new JLabel("CANTIDAD ALIMENTOS (kg):");
		lblCantidadAlimentos.setForeground(Color.WHITE);
		lblCantidadAlimentos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCantidadAlimentos.setBounds(283, 364, 214, 24);
		add(lblCantidadAlimentos);
		
		final JComboBox comboTipoAlimento = new JComboBox();
		comboTipoAlimento.setModel(new DefaultComboBoxModel(new String[] {"...", "Fruto", "Vegetal", "Carne", "Procesado"}));
		comboTipoAlimento.setMaximumRowCount(5);
		comboTipoAlimento.setBounds(327, 305, 141, 22);
		add(comboTipoAlimento);
		
		JLabel lblTipoAlimento = new JLabel("TIPO ALIMENTO:");
		lblTipoAlimento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTipoAlimento.setForeground(Color.WHITE);
		lblTipoAlimento.setBounds(332, 277, 136, 17);
		add(lblTipoAlimento);
		
		JButton botonAlimentos = new JButton("GUARDAR ALIMENTO");
		botonAlimentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String nombreAlimento = campoNombreAlimento.getText();
				float cantidadAlimentos = Float.parseFloat(campoCantidadAlimentos.getText());
				TipoAlimento tipoAlimento = null;		
				
						if(comboTipoAlimento.getSelectedItem().equals("Fruto")) {
							tipoAlimento = TipoAlimento.FRUTO;
						}else if(comboTipoAlimento.getSelectedItem().equals("Vegetal")) {
							tipoAlimento = TipoAlimento.VEGETAL;
						}else if(comboTipoAlimento.getSelectedItem().equals("Carne")) {
							tipoAlimento = TipoAlimento.CARNE;
						}else if(comboTipoAlimento.getSelectedItem().equals("Procesado")) {
							tipoAlimento = TipoAlimento.PROCESADO;
						}
						
						Alimento alimento1 = new Alimento(nombreAlimento, tipoAlimento, cantidadAlimentos);
						//JOPTION PANE QUE DIGA REGISTRO EXITOSO DE TIPO INFORMATION_MESSAGE.
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
					}
									
			}
		});
		botonAlimentos.setBounds(283, 486, 225, 42);
		add(botonAlimentos);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("./fotos/BACKGROUND.jpg"));
		lblNewLabel.setBounds(0, 0, 800, 600);
		add(lblNewLabel);
	}
	

}
