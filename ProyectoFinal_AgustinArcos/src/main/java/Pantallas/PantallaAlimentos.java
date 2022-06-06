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

public class PantallaAlimentos extends JPanel{
	
	private Ventana ventana;
	
	public PantallaAlimentos(Ventana v) {
		this.ventana=v;
		setLayout(null);
		setSize (800,600);
		
		JButton botonAlimentos = new JButton("GUARDAR ALIMENTO");
		botonAlimentos.setBounds(295, 463, 225, 42);
		add(botonAlimentos);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\carol\\Documents\\Eclipse-WORKSPACE\\ProyectoFinalProgramacionZoo\\ProyectoFinal_AgustinArcos\\fotos\\BACKGROUND.jpg"));
		lblNewLabel.setBounds(0, 0, 800, 600);
		add(lblNewLabel);
	}
}
