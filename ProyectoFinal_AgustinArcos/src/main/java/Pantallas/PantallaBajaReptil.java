package Pantallas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import Clases.Primate;
import Clases.Reptil;
import Enums.MotivoBaja;
import Excepciones.FechaFormatoException;
import Excepciones.MotivoVacioException;
import Excepciones.NombreInvalidoException;
import Excepciones.NombreVacioException;
import Utils.UtilsDB;

public class PantallaBajaReptil extends JPanel{
	
	private Ventana ventana;
	private JTextField campoIdBaja;
	private JTextPane textReptilAlta;
	private JTextPane textReptilBaja;
	
	public PantallaBajaReptil(Ventana v) {
		this.ventana=v;
		setLayout(null);
		setSize (800,600);
		
		
			
			
			
			JButton btnVolver = new JButton("Volver");
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ventana.cambiarPantalla("menu");				
				}
			});
			
			final JComboBox comboBaja = new JComboBox();
			comboBaja.setModel(new DefaultComboBoxModel(new String[] {"...", "Muerte", "Traslado"}));
			comboBaja.setMaximumRowCount(3);
			comboBaja.setBounds(341, 291, 132, 22);
			add(comboBaja);
			btnVolver.setBackground(Color.ORANGE);
			btnVolver.setBounds(629, 18, 89, 37);
			add(btnVolver);
			
			JLabel lblBaja = new JLabel("Motivo de baja:");
			lblBaja.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblBaja.setForeground(Color.WHITE);
			lblBaja.setBounds(341, 273, 118, 14);
			add(lblBaja);
			
			textReptilBaja = new JTextPane();
			textReptilBaja.setFont(new Font("Tahoma", Font.BOLD, 12));
			textReptilBaja.setBackground(Color.LIGHT_GRAY);
			textReptilBaja.setEditable(false);
			
			textReptilBaja.setBounds(76, 360, 573, 186);
			add(textReptilBaja);
			
			JLabel lblListaBaja = new JLabel("LISTA DE BAJAS DE REPTILES");
			lblListaBaja.setForeground(Color.WHITE);
			lblListaBaja.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblListaBaja.setBounds(257, 334, 231, 28);
			add(lblListaBaja);
			
			textReptilAlta = new JTextPane();
			textReptilAlta.setFont(new Font("Tahoma", Font.BOLD, 12));
			textReptilAlta.setBackground(Color.ORANGE);
			textReptilAlta.setEditable(false);
			textReptilAlta.setBounds(76, 74, 573, 175);
			add(textReptilAlta);
			
			
			JLabel lblListaAlta = new JLabel("LISTA DE ALTAS DE REPTILES");
			lblListaAlta.setForeground(Color.WHITE);
			lblListaAlta.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblListaAlta.setBounds(245, 49, 250, 28);
			add(lblListaAlta);
			
			JLabel txtPrimate = new JLabel("REPTIL");
			txtPrimate.setForeground(Color.WHITE);
			txtPrimate.setFont(new Font("Arial Black", Font.BOLD, 20));
			txtPrimate.setBounds(76, 11, 127, 42);
			add(txtPrimate);
			
			campoIdBaja = new JTextField();
			campoIdBaja.setBounds(268, 292, 46, 20);
			add(campoIdBaja);
			campoIdBaja.setColumns(10);
			
			JButton botonBaja = new JButton("DAR DE BAJA");
			botonBaja.setBounds(503, 260, 195, 74);
			botonBaja.setIcon(new ImageIcon("./gif/muerte.gif"));
			botonBaja.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					//hacer select y si encuentra constructor baja
					
					Statement query = UtilsDB.conectarBD();
					
					short id = Short.parseShort(campoIdBaja.getText());
					
					try {
						ResultSet cursor = query.executeQuery("select id, nombre, date_format(fechaNacimiento,'%d-%m-%Y') "
								+ "as fechaNacimiento,motivoAlta,fechaAlta,tipoPiel,cuidados from altaReptil where id="+id+";");
						if(cursor.next()) {
							
								
							String nombre = cursor.getString("nombre");
							DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
							LocalDate fechaNacimiento = LocalDate.parse(cursor.getString("fechaNacimiento"),formatter);		
							LocalDate fechaBaja = LocalDate.now();
							boolean tipoPiel = cursor.getBoolean("tipoPiel");
							String cuidados = cursor.getString("cuidados");
							MotivoBaja motivoBaja = null;
							
							if(comboBaja.getSelectedItem().equals("Muerte")) {
								motivoBaja=MotivoBaja.MUERTE;
							}else if (comboBaja.getSelectedItem().equals("Traspaso")) {
								motivoBaja=MotivoBaja.TRASPASO;
							}else if(comboBaja.getSelectedItem().equals("...")){
								motivoBaja=MotivoBaja.___;
							}
							
							
							
							Reptil reptil = new Reptil(id, nombre, fechaNacimiento, motivoBaja, fechaBaja, tipoPiel, cuidados);
							mostrarReptilesAlta();
							mostrarReptilesBaja();
							JOptionPane.showMessageDialog(ventana, "Registro exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
							
						}
						else {
							JOptionPane.showMessageDialog(null, "NO SE ENCUENTRA LA ID", "ERROR", JOptionPane.ERROR_MESSAGE);
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NombreVacioException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NombreInvalidoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (FechaFormatoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (MotivoVacioException e1) {
						JOptionPane.showMessageDialog(null, "Error. Motivo de baja vacío", "Error", JOptionPane.INFORMATION_MESSAGE);
						e1.printStackTrace();
					}
						
					
					
					UtilsDB.desconectarBD();
					
					
					
					
					
					
				}
			});
			
			JLabel lblIdBaja = new JLabel("ID de animal a dar de baja:");
			lblIdBaja.setBackground(Color.GREEN);
			lblIdBaja.setForeground(Color.WHITE);
			lblIdBaja.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			lblIdBaja.setBounds(76, 286, 195, 28);
			add(lblIdBaja);
			botonBaja.setBackground(Color.RED);
			botonBaja.setForeground(Color.BLACK);
			botonBaja.setBounds(503, 260, 195, 74);
			add(botonBaja);
			
			JLabel background = new JLabel("");
			background.setIcon(new ImageIcon("./fotos/BACKGROUND_sinlogo.jpg"));
			background.setBounds(0, 0, 800, 600);
			add(background);
			
			JLabel txtFechaBaja = new JLabel("New label");
			txtFechaBaja.setFont(new Font("Arial", Font.BOLD, 14));
			txtFechaBaja.setBounds(0, 0, 46, 14);
			add(txtFechaBaja);
			
			mostrarReptilesAlta();
			mostrarReptilesBaja();
				
	}
	
	private void mostrarReptilesAlta() {
		Statement query = UtilsDB.conectarBD();
		
		String listaReptiles = "";
		
		ResultSet cursor;
		try {
			cursor = query.executeQuery("select * from altaReptil");
			
			while(cursor.next()) {
				String id = cursor.getString("id");
				String nombre = cursor.getString("nombre");
				listaReptiles +="●ID: "+ id +"     ●Nombre: "+ nombre + "\n";
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		textReptilAlta.setText(listaReptiles);
	}
	
	
	private void mostrarReptilesBaja() {
		Statement query = UtilsDB.conectarBD();
		
		String listaReptiles = "";
		
		ResultSet cursor;
		try {
			cursor = query.executeQuery("select * from bajaReptil");
			
			while(cursor.next()) {
				String id = cursor.getString("id");
				String nombre = cursor.getString("nombre");
				String motivoBaja = cursor.getString("motivoBaja");
				listaReptiles +="●ID: "+ id +"     ●Nombre: "+ nombre + "\n";
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		textReptilBaja.setText(listaReptiles);
	}
	
	
	
}
