package Pantallas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class PantallaAltaReptil extends JPanel{
	
	private Ventana ventana;
	private JTextField campoNombre;
	private JTextField campoFechaNacimiento;
	private JTextField txtFechaAlta;
	private JTextField textDescripcion;
	private JTextField textDuracion;
	
	public PantallaAltaReptil(Ventana v) {
		this.ventana=v;
		setLayout(null);
		setSize (800,600);
		
		JButton botonDarAlta = new JButton("DAR DE ALTA REPTIL");
		botonDarAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	
			
		 
		

		final JRadioButton rdbtnPiel2 = new JRadioButton("Caparaz\u00F3n");
		rdbtnPiel2.setBounds(58, 414, 89, 23);
		add(rdbtnPiel2);
		
		final JRadioButton rdbtnPiel1 = new JRadioButton("Escamas");
		rdbtnPiel1.setBounds(58, 385, 89, 23);
		add(rdbtnPiel1);
		
		final ButtonGroup grupoPiel = new ButtonGroup();
		grupoPiel.add(rdbtnPiel1);
		grupoPiel.add(rdbtnPiel2);
		
		JLabel lblDuracion = new JLabel("Duraci\u00F3n:");
		lblDuracion.setForeground(Color.WHITE);
		lblDuracion.setBounds(219, 489, 55, 14);
		add(lblDuracion);
		
		
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
		
		textDuracion = new JTextField();
		textDuracion.setBounds(278, 486, 86, 20);
		add(textDuracion);
		textDuracion.setColumns(10);
		
		textDescripcion = new JTextField();
		textDescripcion.setBounds(276, 404, 171, 78);
		add(textDescripcion);
		textDescripcion.setColumns(10);
		
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
