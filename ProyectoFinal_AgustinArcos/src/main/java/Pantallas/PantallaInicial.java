package Pantallas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaInicial extends JPanel{
	
	private Ventana ventana;
	
	public PantallaInicial(Ventana v) {
		this.ventana=v;
		setLayout(null);
		setSize (800,600);
		
		JButton botonLogin = new JButton("LOGIN");
		botonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarPantalla("login");
			}
		});
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		btnSalir.setBounds(356, 294, 89, 23);
		add(btnSalir);
		botonLogin.setBounds(314, 382, 173, 40);
		add(botonLogin);
		
		JButton botonRegistrarse = new JButton("REGISTRARSE");
		botonRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarPantalla("registro");
			}
		});
		botonRegistrarse.setBounds(314, 450, 173, 40);

		add(botonRegistrarse);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("./fotos/login_pantalla.jpg"));
		background.setBounds(0, 0, 800, 600);
		add(background);
	}

	protected void salir() {
		System.exit(0);
		
	}
}
