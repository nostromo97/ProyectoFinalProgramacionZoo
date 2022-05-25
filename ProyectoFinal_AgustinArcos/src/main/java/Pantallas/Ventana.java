package Pantallas;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Ventana extends JFrame{
	
	public Ventana() {
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setSize(600, 400);
		this.setTitle("Zoológico Mundo Natural");
		this.setIconImage(new ImageIcon("./fotos/icono.png").getImage());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(new PantallaLogin(this));
		this.setResizable(false);
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//this.setUndecorated(true); 
		
	}

}
