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

public class PantallaMenu extends JPanel{
	
	private Ventana ventana;
	
	public PantallaMenu(Ventana v) {
		this.ventana=v;
		setLayout(null);
		setSize (800,600);
		
		JComboBox comboBaja = new JComboBox();
		comboBaja.setModel(new DefaultComboBoxModel(new String[] {"Anfibio", "Primate", "Reptil"}));
		comboBaja.setMaximumRowCount(3);
		comboBaja.setBounds(217, 257, 144, 22);
		add(comboBaja);
		
		JComboBox comboAlta = new JComboBox();
		comboAlta.setModel(new DefaultComboBoxModel(new String[] {"Anfibio", "Primate", "Reptil"}));
		comboAlta.setToolTipText("");
		comboAlta.setMaximumRowCount(3);
		comboAlta.setBounds(213, 178, 145, 22);
		add(comboAlta);
		
		JButton bakcground = new JButton("DAR DE BAJA ANIMAL");
		bakcground.setBackground(Color.RED);
		bakcground.setBounds(45, 252, 139, 33);
		add(bakcground);
		
		JButton btnNewButton = new JButton("DAR DE ALTA ANIAML");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(45, 173, 139, 33);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\carol\\Documents\\Eclipse-WORKSPACE\\ProyectoFinalProgramacionZoo\\ProyectoFinal_AgustinArcos\\fotos\\BACKGROUND.jpg"));
		lblNewLabel.setBounds(0, 0, 800, 600);
		add(lblNewLabel);
	}
}
