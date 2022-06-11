package Pantallas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.EnumSet;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Clases.Primate;
import Clases.Usuario;
import Enums.MotivoAlta;
import Excepciones.CampoVacioException;
import Excepciones.DescripcionVaciaException;
import Excepciones.FechaFormatoException;
import Excepciones.GeneroVacioException;
import Excepciones.MotivoVacioException;
import Excepciones.NombreInvalidoException;
import Excepciones.NombreVacioException;

import javax.swing.JRadioButton;
/**
 * Clase que implementa la pantalla de alta de los primates y extiende de JPanel.
 * @author Agustín Arcos
 *
 */
public class PantallaAltaPrimate extends JPanel {
	/**
	 * Ventana en la que se muestra la pantalla actual.
	 */
	private Ventana ventana;
	/**
	 * Campo donde el usuario introduce el nombre del animal.
	 */
	private JTextField campoNombre;
	/**
	 * Campo donde el usuario introduce la fecha de nacimiento del animal.
	 */
	private JTextField campoFechaNacimiento;
	/**
	 * Campo donde el usuario introduce la fecha de alta del animal.
	 */
	private JTextField campoFechaAlta;
	/**
	 * Campo donde el usuario introduce la descripción de los cuidados del animal.
	 */
	private JTextField campoDescripcion;
	/**
	 * Constructor que implementa el funcionamiento de la pantalla de alta de los anfibios.
	 * @param v
	 */
	public PantallaAltaPrimate(Ventana v) {
		this.ventana = v;
		setLayout(null);
		setSize(800, 600);

		JButton btnAtras = new JButton("Volver");
		btnAtras.setBackground(Color.ORANGE);
		btnAtras.addActionListener(new ActionListener() {
			/**
			 * Función que te devuelve a la pantalla menú.
			 * @param e Variable que activa el evento.
			 */
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarPantalla("menu");
			}
		});

		final JRadioButton campoFemenino = new JRadioButton("Femenino");
		campoFemenino.setBounds(57, 420, 89, 23);
		add(campoFemenino);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			/**
			 * Función que te devuelve a la pantalla menú.
			 * @param e Variable que activa el evento.
			 */
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarPantalla("menu");
			}
		});
		
		JLabel lblGifPrimate = new JLabel("");
		lblGifPrimate.setIcon(new ImageIcon("./gif/mono.gif"));
		lblGifPrimate.setBounds(539, 245, 236, 184);
		add(lblGifPrimate);
		btnVolver.setBackground(Color.ORANGE);
		btnVolver.setBounds(583, 36, 89, 60);
		add(btnVolver);

		final JRadioButton campoMasculino = new JRadioButton("Masculino");
		campoMasculino.setBounds(57, 392, 90, 23);
		add(campoMasculino);

		final ButtonGroup grupoGenero = new ButtonGroup();
		grupoGenero.add(campoMasculino);
		grupoGenero.add(campoFemenino);

		campoDescripcion = new JTextField();
		campoDescripcion.setBounds(292, 372, 172, 94);
		add(campoDescripcion);
		campoDescripcion.setColumns(10);

		JLabel lblDescripcion = new JLabel("Descripci\u00F3n:");
		lblDescripcion.setForeground(Color.WHITE);
		lblDescripcion.setBounds(232, 375, 67, 14);
		add(lblDescripcion);

		JLabel lblCuidados = new JLabel("CUIDADOS:");
		lblCuidados.setForeground(Color.WHITE);
		lblCuidados.setFont(new Font("Arial", Font.BOLD, 12));
		lblCuidados.setBounds(220, 360, 78, 14);
		add(lblCuidados);

		JLabel txtGenero = new JLabel("G\u00C9NERO:");
		txtGenero.setHorizontalAlignment(SwingConstants.CENTER);
		txtGenero.setForeground(Color.WHITE);
		txtGenero.setFont(new Font("Arial", Font.BOLD, 13));
		txtGenero.setBounds(57, 360, 78, 26);
		add(txtGenero);

		campoFechaAlta = new JTextField();
		campoFechaAlta.setBounds(232, 309, 215, 20);
		add(campoFechaAlta);
		campoFechaAlta.setColumns(10);

		final JComboBox comboAlta = new JComboBox();
		comboAlta.setModel(new DefaultComboBoxModel(new String[] { "...", "Nacimiento", "Llegada" }));
		comboAlta.setMaximumRowCount(3);
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

		JLabel txtPrimate = new JLabel("PRIMATE");
		txtPrimate.setForeground(Color.WHITE);
		txtPrimate.setFont(new Font("Arial Black", Font.BOLD, 20));
		txtPrimate.setBounds(583, 234, 127, 42);
		add(txtPrimate);

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

		// DATOS PRIMATE
		JButton botonDarAlta = new JButton("DAR DE ALTA PRIMATE");
		botonDarAlta.addActionListener(new ActionListener() {
			/**
			 * Función que registra y guarda los campos de alta del primate cuando el usuario hace click. 
			 * @param e Variable que activa el evento.
			 */
			public void actionPerformed(ActionEvent e) {
				try {
					String nombrePrimate = campoNombre.getText();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					LocalDate fechaNacimiento = LocalDate.parse(campoFechaNacimiento.getText(), formatter);
					LocalDate fechaAlta = LocalDate.parse(campoFechaAlta.getText(), formatter);
					String tratamientoDescripcion = campoDescripcion.getText();
					MotivoAlta motivoAlta = null;

					if (comboAlta.getSelectedItem().equals("Nacimiento")) {
						motivoAlta = MotivoAlta.NACIMIENTO;
					} else if (comboAlta.getSelectedItem().equals("Llegada")) {

						motivoAlta = MotivoAlta.LLEGADA;
					} else if (comboAlta.getSelectedItem().equals("...")) {
						motivoAlta = MotivoAlta.___;
					}

					boolean genero = true;
					if (campoMasculino.isSelected()) {
						genero = true;
					} else if (campoFemenino.isSelected()) {
						genero = false;
					}
					if (!campoMasculino.isSelected() && (!campoMasculino.isSelected())) {

						JOptionPane.showMessageDialog(null, "Error. El género no puede estar vacío.", "Error",
								JOptionPane.ERROR_MESSAGE);

					}else {
						
					

					Primate primate1 = new Primate(nombrePrimate, fechaNacimiento, motivoAlta, fechaAlta, genero,
							tratamientoDescripcion);
					// JOPTION PANE QUE DIGA REGISTRO EXITOSO DE TIPO INFORMATION_MESSAGE.
					JOptionPane.showMessageDialog(ventana, "Registro exitoso", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);
					// IR A PANTALLA METER ANIMALES
					ventana.cambiarPantalla("menu");
					}
				} catch (NombreVacioException e1) {
					JOptionPane.showMessageDialog(null, "Nombre Vacio", "Error", JOptionPane.WARNING_MESSAGE);
				} catch (NombreInvalidoException e1) {
					JOptionPane.showMessageDialog(null, "El nombre no puede contener números.", "Error",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Error SQL", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (FechaFormatoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (DateTimeParseException e1) {
					JOptionPane.showMessageDialog(null,
							"Error. Introduce la fecha en un formato: dd-MM-YYYY (día, mes, año)", "Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (CampoVacioException e1) {

					e1.printStackTrace();
				} catch (MotivoVacioException e1) {
					JOptionPane.showMessageDialog(null, "Error. Motivo de alta vacío", "Error",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (GeneroVacioException e1) {
					JOptionPane.showMessageDialog(null, "Error. El género no puede estar vacío.", "Error",JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (DescripcionVaciaException e1) {
					JOptionPane.showMessageDialog(null, "AVISO. Has dejado la descripción vacía.", "AVISO",JOptionPane.WARNING_MESSAGE);
					e1.printStackTrace();
				}

			}
		});

		campoNombre = new JTextField();
		campoNombre.setBounds(230, 174, 217, 20);
		add(campoNombre);
		campoNombre.setColumns(10);
		botonDarAlta.setBackground(Color.GREEN);
		botonDarAlta.setForeground(Color.BLACK);
		botonDarAlta.setBounds(526, 499, 202, 60);
		add(botonDarAlta);

		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("./fotos/BACKGROUND.jpg"));
		background.setBounds(0, 0, 800, 600);
		add(background);
	}
}
