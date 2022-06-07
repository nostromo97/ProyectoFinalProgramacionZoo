package Pantallas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class PantallaAltaAnfibio extends JPanel{
	
	private Ventana ventana;
	private JTextField campoNombre;
	private JTextField campoFechaNacimiento;
	private JTextField txtFechaAlta;
	private JTextField textField;
	private JTextField textField_1;
	
	public PantallaAltaAnfibio(Ventana v) {
		this.ventana=v;
		setLayout(null);
		setSize (800,600);
		
		JButton botonDarAlta = new JButton("DAR DE ALTA ANFIBIO");
		botonDarAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton btnAtras = new JButton("Volver");
		btnAtras.setBackground(Color.ORANGE);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarPantalla("menu");
			}
		});
		
		JButton btnMotivoAlta = new JButton("Seleccionar");
		btnMotivoAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnMotivoAlta.setBounds(451, 259, 97, 23);
		add(btnMotivoAlta);
		
		JRadioButton rdbtnAmbiente2 = new JRadioButton("Seco");
		rdbtnAmbiente2.setBounds(78, 498, 67, 23);
		add(rdbtnAmbiente2);
		
		JRadioButton rdbtnAmbiente1 = new JRadioButton("Acu\u00E1tico");
		rdbtnAmbiente1.setBounds(78, 472, 67, 23);
		add(rdbtnAmbiente1);
		
		JRadioButton rdbtnOrden1 = new JRadioButton("Anura");
		rdbtnOrden1.setBounds(72, 359, 91, 23);
		add(rdbtnOrden1);
		
		JRadioButton rdbtnOrden2 = new JRadioButton("Caudata");
		rdbtnOrden2.setBounds(72, 385, 91, 23);
		add(rdbtnOrden2);
		btnAtras.setForeground(Color.BLACK);
		btnAtras.setBounds(629, 53, 89, 77);
		add(btnAtras);
		
		textField_1 = new JTextField();
		textField_1.setBounds(273, 486, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDuracion = new JLabel("Duraci\u00F3n:");
		lblDuracion.setForeground(Color.WHITE);
		lblDuracion.setBounds(224, 486, 46, 14);
		add(lblDuracion);
		
		textField = new JTextField();
		textField.setBounds(272, 385, 175, 86);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblDescripción = new JLabel("Descripci\u00F3n:");
		lblDescripción.setForeground(Color.WHITE);
		lblDescripción.setBounds(210, 388, 67, 14);
		add(lblDescripción);
		
		JLabel lblCuidados = new JLabel("CUIDADOS:");
		lblCuidados.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCuidados.setForeground(Color.WHITE);
		lblCuidados.setBounds(232, 362, 67, 14);
		add(lblCuidados);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Gymnophiona");
		rdbtnNewRadioButton.setBounds(72, 411, 91, 23);
		add(rdbtnNewRadioButton);
		
		JLabel txtAmbiente = new JLabel("AMBIENTE:");
		txtAmbiente.setFont(new Font("Arial", Font.BOLD, 12));
		txtAmbiente.setForeground(Color.WHITE);
		txtAmbiente.setBounds(78, 454, 67, 14);
		add(txtAmbiente);
		
		JLabel txtOrden = new JLabel("ORDEN:");
		txtOrden.setForeground(Color.WHITE);
		txtOrden.setFont(new Font("Arial", Font.BOLD, 12));
		txtOrden.setBounds(81, 343, 46, 14);
		add(txtOrden);
		
		txtFechaAlta = new JTextField();
		txtFechaAlta.setBounds(232, 309, 215, 20);
		add(txtFechaAlta);
		txtFechaAlta.setColumns(10);
		
		JComboBox comboAlta = new JComboBox();
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
		
		JButton botonDieta = new JButton("DIETA");
		botonDieta.setBounds(614, 308, 89, 23);
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
		
		campoNombre = new JTextField();
		campoNombre.setBounds(230, 174, 217, 20);
		add(campoNombre);
		campoNombre.setColumns(10);
		botonDarAlta.setBackground(Color.GREEN);
		botonDarAlta.setForeground(Color.BLACK);
		botonDarAlta.setBounds(559, 500, 202, 60);
		add(botonDarAlta);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("C:\\Users\\carol\\Documents\\Eclipse-WORKSPACE\\ProyectoFinalProgramacionZoo\\ProyectoFinal_AgustinArcos\\fotos\\BACKGROUND.jpg"));
		background.setBounds(0, 0, 800, 600);
		add(background);
	}
}
