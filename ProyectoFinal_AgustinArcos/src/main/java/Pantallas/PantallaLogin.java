package Pantallas;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Pantallas.Ventana;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaLogin extends JPanel{

	
	private Ventana ventana;
	private JTextField textField;
	
	
	public PantallaLogin(Ventana v) {
		this.ventana=v;
		setLayout(null);
		textField = new JTextField();
		textField.setBounds(104, 213, 86, 20);
		add(textField);
		textField.setColumns(10);
	}
	
}
