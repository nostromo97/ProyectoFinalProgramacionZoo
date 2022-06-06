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

public class PantallaAltaPrimate extends JPanel{
	
	private Ventana ventana;
	private JTextField campoNombre;
	private JTextField campoFechaNacimiento;
	private JTextField txtFechaAlta;
	private JTextField textDescripcion;
	private JTextField textDuracion;
	
	public PantallaAltaPrimate(Ventana v) {
		this.ventana=v;
		setLayout(null);
		setSize (800,600);
		
		JButton botonDarAlta = new JButton("DAR DE ALTA PRIMATE");
		botonDarAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JLabel lblDuracion = new JLabel("Duraci\u00F3n:");
		lblDuracion.setForeground(Color.WHITE);
		lblDuracion.setBounds(241, 477, 46, 14);
		add(lblDuracion);
		
		textDuracion = new JTextField();
		textDuracion.setBounds(292, 474, 86, 20);
		add(textDuracion);
		textDuracion.setColumns(10);
		
		textDescripcion = new JTextField();
		textDescripcion.setBounds(292, 372, 172, 94);
		add(textDescripcion);
		textDescripcion.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n:");
		lblDescripcion.setForeground(Color.WHITE);
		lblDescripcion.setBounds(232, 375, 67, 14);
		add(lblDescripcion);
		
		JLabel lblCuidados = new JLabel("CUIDADOS:");
		lblCuidados.setForeground(Color.WHITE);
		lblCuidados.setFont(new Font("Arial", Font.BOLD, 12));
		lblCuidados.setBounds(220, 360, 78, 14);
		add(lblCuidados);
		
		JComboBox comboGenero = new JComboBox();
		comboGenero.setModel(new DefaultComboBoxModel(new String[] {"...", "MASCULINO", "FEMENINO"}));
		comboGenero.setMaximumRowCount(3);
		comboGenero.setBounds(29, 392, 127, 22);
		add(comboGenero);
		
		JLabel txtGenero = new JLabel("G\u00C9NERO:");
		txtGenero.setForeground(Color.WHITE);
		txtGenero.setFont(new Font("Arial", Font.BOLD, 13));
		txtGenero.setBounds(34, 375, 78, 14);
		add(txtGenero);
		
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
		
		JLabel txtPrimate = new JLabel("PRIMATE");
		txtPrimate.setForeground(Color.WHITE);
		txtPrimate.setFont(new Font("Arial Black", Font.BOLD, 20));
		txtPrimate.setBounds(559, 245, 127, 42);
		add(txtPrimate);
		
		JButton botonDieta = new JButton("DIETA");
		botonDieta.setBounds(521, 392, 89, 23);
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
		botonDarAlta.setBounds(526, 499, 202, 60);
		add(botonDarAlta);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("C:\\Users\\carol\\Documents\\Eclipse-WORKSPACE\\ProyectoFinalProgramacionZoo\\ProyectoFinal_AgustinArcos\\fotos\\BACKGROUND.jpg"));
		background.setBounds(0, 0, 800, 600);
		add(background);
	}
}
