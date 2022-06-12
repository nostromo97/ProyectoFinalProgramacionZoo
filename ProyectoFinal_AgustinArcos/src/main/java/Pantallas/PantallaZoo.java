package Pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import Clases.Anfibio;
import Clases.Animal;
import Clases.Primate;
import Clases.Reptil;
import Enums.TipoOrden;
import Enums.TipoRaza;
import Excepciones.NombreInvalidoException;
import Excepciones.NombreVacioException;
import Utils.UtilsDB;

/**
 * Clase que implementa la pantalla la info de todos los animales dados de alta
 * en el zoo.
 * 
 * @author Agustín Arcos
 *
 */
public class PantallaZoo extends JPanel {
	/**
	 * Ventana en la que se muestra la pantalla actual.
	 */
	private Ventana ventana;
	/**
	 * Panel donde aparece la información de los animales.
	 */
	private JTextPane textInfoAnimales;

	public PantallaZoo(Ventana v) {
		this.ventana = v;
		setLayout(null);
		setSize(800, 600);

		JButton botonVolver = new JButton("Volver");
		botonVolver.addActionListener(new ActionListener() {
			/**
			 * Función que te devuelve a la pantalla menú.
			 * 
			 * @param e Variable que activa el evento.
			 */
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarPantalla("menu");
			}
		});
		botonVolver.setBounds(307, 456, 181, 44);
		add(botonVolver);

		JLabel fotoMonoPortatil = new JLabel("");
		fotoMonoPortatil.setIcon(new ImageIcon("./gif/monoPortatil.gif"));
		fotoMonoPortatil.setBounds(279, 27, 209, 187);
		add(fotoMonoPortatil);

		textInfoAnimales = new JTextPane();
		textInfoAnimales.setBackground(new Color(153, 204, 204));
		textInfoAnimales.setFont(new Font("Tahoma", Font.BOLD, 11));

		JScrollPane usr = new JScrollPane(textInfoAnimales);
		usr.setBounds(214, 252, 372, 133);
		add(usr);

		JLabel lblNewLabel = new JLabel("Lista de animales:");
		lblNewLabel.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(338, 225, 122, 25);
		add(lblNewLabel);

		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("./fotos/BACKGROUND_sinlogo.jpg"));
		background.setBounds(0, 0, 800, 600);
		add(background);

		ArrayList<Animal> animales = mostrarAnimales();
		String lista = "";
		for (int i = 0; i < animales.size(); i++) {
			if (animales.get(i).getRaza().toString().equals("PRIMATE")) {
				Primate p = (Primate) animales.get(i);
				lista += p.toString() + "\n";
			}
			else if (animales.get(i).getRaza().toString().equals("REPTIL")) {
				Reptil r = (Reptil) animales.get(i);
				lista += r.toString() + "\n";
			}
			else if (animales.get(i).getRaza().toString().equals("ANFIBIO")) {
				Anfibio a = (Anfibio) animales.get(i);
				lista += a.toString() + "\n";
			}

		}

		textInfoAnimales.setText(lista);

	}

	/**
	 * Función que recoge todos los animales de la base de datos y los guarda en un ArrayList.
	 * @return lista con todos los animales de la base de datos
	 */
	private static ArrayList<Animal> mostrarAnimales() {

		ArrayList<Animal> animales = new ArrayList<Animal>();

		Statement query = UtilsDB.conectarBD();

		ResultSet cursor;
		try {
			cursor = query.executeQuery("select * from altaPrimate");

			while (cursor.next()) {
				short id = cursor.getShort("id");
				String nombre = cursor.getString("nombre");
				Boolean genero = cursor.getBoolean("genero");

				Animal a = new Primate(id, nombre, TipoRaza.PRIMATE, genero);
				animales.add(a);

			}

			cursor = query.executeQuery("select * from altaReptil");

			while (cursor.next()) {
				short id = cursor.getShort("id");
				String nombre = cursor.getString("nombre");
				Boolean tipoPiel = cursor.getBoolean("tipoPiel");

				Animal a = new Reptil(id, nombre, TipoRaza.REPTIL, tipoPiel);
				animales.add(a);

			}
			cursor = query.executeQuery("select * from altaAnfibio");

			while (cursor.next()) {
				short id = cursor.getShort("id");
				String nombre = cursor.getString("nombre");
				String ordenBBDD = cursor.getString("tipoOrden");
				TipoOrden tipoOrden = TipoOrden.ANURA;
				
				if(ordenBBDD.equals("CAUDATA")) {
					tipoOrden=TipoOrden.CAUDATA;
					
				}else if(ordenBBDD.equals("GYMNOPHIONA")) {
					tipoOrden = TipoOrden.GYMNOPHIONA;
				}
				Boolean tipoAmbiente = cursor.getBoolean("tipoAmbiente");

				Animal a = new Anfibio(id, nombre, TipoRaza.ANFIBIO, tipoOrden,tipoAmbiente);
				animales.add(a);

			}

		} catch (SQLException | NombreVacioException | NombreInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		UtilsDB.desconectarBD();

		return animales;
	}

}
