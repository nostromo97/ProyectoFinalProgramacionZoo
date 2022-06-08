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

public class PantallaBajaPrimate extends JPanel{
	
	private Ventana ventana;
	private JTextField campoIdBaja;
	private JTextField textPrimateAlta;
	private JTextField textPrimateBaja;
	
	public PantallaBajaPrimate(Ventana v) {
		this.ventana=v;
		setLayout(null);
		setSize (800,600);
		
		
			
			JButton botonDarAlta = new JButton("Introducir ID");
			botonDarAlta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			
			JButton btnVolver = new JButton("Volver");
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ventana.cambiarPantalla("menu");				
				}
			});
			btnVolver.setBackground(Color.ORANGE);
			btnVolver.setBounds(629, 18, 89, 37);
			add(btnVolver);
			
			textPrimateBaja = new JTextField();
			textPrimateBaja.setEditable(false);
			textPrimateBaja.setColumns(10);
			textPrimateBaja.setBounds(76, 360, 573, 186);
			add(textPrimateBaja);
			
			JLabel lblListaBaja = new JLabel("LISTA DE BAJAS DE PRIMATES");
			lblListaBaja.setForeground(Color.WHITE);
			lblListaBaja.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblListaBaja.setBounds(257, 334, 231, 28);
			add(lblListaBaja);
			
			textPrimateAlta = new JTextField();
			textPrimateAlta.setEditable(false);
			textPrimateAlta.setBounds(76, 74, 573, 175);
			add(textPrimateAlta);
			textPrimateAlta.setColumns(10);
			
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
			campoIdBaja.setBounds(353, 292, 46, 20);
			add(campoIdBaja);
			campoIdBaja.setColumns(10);
			
			JLabel lblIdBaja = new JLabel("ID de animal a dar de baja:");
			lblIdBaja.setBackground(Color.GREEN);
			lblIdBaja.setForeground(Color.WHITE);
			lblIdBaja.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			lblIdBaja.setBounds(162, 286, 195, 28);
			add(lblIdBaja);
			botonDarAlta.setBackground(Color.RED);
			botonDarAlta.setForeground(Color.BLACK);
			botonDarAlta.setBounds(410, 288, 106, 28);
			add(botonDarAlta);
			
			JLabel background = new JLabel("");
			background.setIcon(new ImageIcon("C:\\Users\\carol\\Documents\\Eclipse-WORKSPACE\\ProyectoFinalProgramacionZoo\\ProyectoFinal_AgustinArcos\\fotos\\BACKGROUND_sinlogo.jpg"));
			background.setBounds(0, 0, 800, 600);
			add(background);
			
			JLabel txtFechaBaja = new JLabel("New label");
			txtFechaBaja.setFont(new Font("Arial", Font.BOLD, 14));
			txtFechaBaja.setBounds(0, 0, 46, 14);
			add(txtFechaBaja);
		
	}
}
