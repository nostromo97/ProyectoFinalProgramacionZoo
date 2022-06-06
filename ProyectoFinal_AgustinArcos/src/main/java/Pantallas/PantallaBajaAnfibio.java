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

public class PantallaBajaAnfibio extends JPanel{
	
	private Ventana ventana;
	private JTextField campoNombre;
	private JTextField campoFechaNacimiento;
	private JTextField campoFechaBaja;
	
	public PantallaBajaAnfibio(Ventana v) {
		this.ventana=v;
		setLayout(null);
		setSize (800,600);
		
		JButton botonDarAlta = new JButton("DAR DE BAJA ANFIBIO");
		botonDarAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(232, 259, 215, 22);
		add(comboBox);
		
		campoFechaBaja = new JTextField();
		campoFechaBaja.setBounds(232, 307, 215, 20);
		add(campoFechaBaja);
		campoFechaBaja.setColumns(10);
		
		JLabel lblFechaBaja = new JLabel("FECHA BAJA:");
		lblFechaBaja.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaBaja.setForeground(Color.WHITE);
		lblFechaBaja.setFont(new Font("Arial", Font.BOLD, 14));
		lblFechaBaja.setBounds(117, 312, 106, 14);
		add(lblFechaBaja);
		
		JLabel txtMotivoBaja = new JLabel("MOTIVO BAJA:");
		txtMotivoBaja.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMotivoBaja.setFont(new Font("Arial", Font.BOLD, 14));
		txtMotivoBaja.setForeground(Color.WHITE);
		txtMotivoBaja.setBounds(101, 262, 120, 14);
		add(txtMotivoBaja);
		
		JLabel txtAnfibio = new JLabel("ANFIBIO");
		txtAnfibio.setForeground(Color.WHITE);
		txtAnfibio.setFont(new Font("Arial Black", Font.BOLD, 20));
		txtAnfibio.setBounds(559, 245, 127, 42);
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
		
		campoNombre = new JTextField();
		campoNombre.setBounds(230, 174, 217, 20);
		add(campoNombre);
		campoNombre.setColumns(10);
		botonDarAlta.setBackground(Color.RED);
		botonDarAlta.setForeground(Color.BLACK);
		botonDarAlta.setBounds(290, 496, 202, 60);
		add(botonDarAlta);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("C:\\Users\\carol\\Documents\\Eclipse-WORKSPACE\\ProyectoFinalProgramacionZoo\\ProyectoFinal_AgustinArcos\\fotos\\BACKGROUND.jpg"));
		background.setBounds(0, 0, 800, 600);
		add(background);
		
		JLabel txtFechaBaja = new JLabel("New label");
		txtFechaBaja.setFont(new Font("Arial", Font.BOLD, 14));
		txtFechaBaja.setBounds(0, 0, 46, 14);
		add(txtFechaBaja);
	}
}
