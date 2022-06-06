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

public class PantallaAlimentos extends JPanel{
	
	private Ventana ventana;
	private JTextField textCantidadAlimentos;
	
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
		btnAtras.setBounds(42, 397, 124, 60);
		add(btnAtras);
		
		textCantidadAlimentos = new JTextField();
		textCantidadAlimentos.setBounds(347, 332, 86, 20);
		add(textCantidadAlimentos);
		textCantidadAlimentos.setColumns(10);
		
		JLabel lblCantidadAlimentos = new JLabel("CANTIDAD ALIMENTOS (kg):");
		lblCantidadAlimentos.setForeground(Color.WHITE);
		lblCantidadAlimentos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCantidadAlimentos.setBounds(294, 302, 214, 24);
		add(lblCantidadAlimentos);
		
		JComboBox comboTipoAlimento = new JComboBox();
		comboTipoAlimento.setModel(new DefaultComboBoxModel(new String[] {"...", "FRUTO", "VEGETAL", "CARNE", "PROCESADO"}));
		comboTipoAlimento.setMaximumRowCount(5);
		comboTipoAlimento.setBounds(323, 185, 141, 22);
		add(comboTipoAlimento);
		
		JLabel lblTipoAlimento = new JLabel("TIPO ALIMENTO:");
		lblTipoAlimento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTipoAlimento.setForeground(Color.WHITE);
		lblTipoAlimento.setBounds(332, 159, 136, 17);
		add(lblTipoAlimento);
		
		JButton botonAlimentos = new JButton("GUARDAR ALIMENTO");
		botonAlimentos.setBounds(283, 486, 225, 42);
		add(botonAlimentos);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\carol\\Documents\\Eclipse-WORKSPACE\\ProyectoFinalProgramacionZoo\\ProyectoFinal_AgustinArcos\\fotos\\BACKGROUND.jpg"));
		lblNewLabel.setBounds(0, 0, 800, 600);
		add(lblNewLabel);
	}
}
