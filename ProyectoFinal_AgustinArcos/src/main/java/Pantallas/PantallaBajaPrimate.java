package Pantallas;

import javax.swing.JPanel;
import javax.swing.JLabel;
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
import javax.swing.SwingConstants;

import Clases.Primate;
import Enums.MotivoAlta;
import Enums.MotivoBaja;
import Excepciones.FechaFormatoException;
import Excepciones.MotivoVacioException;
import Excepciones.NombreInvalidoException;
import Excepciones.NombreVacioException;
import Utils.UtilsDB;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextPane;

public class PantallaBajaPrimate extends JPanel{
	
	private Ventana ventana;
	private JTextField campoIdBaja;
	private JTextPane textPrimateAlta;
	private JTextPane textPrimateBaja;
	
	public PantallaBajaPrimate(Ventana v) {
		this.ventana=v;
		setLayout(null);
		setSize (800,600);
		
		
			
			JButton btnVolver = new JButton("Volver");
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ventana.cambiarPantalla("menu");				
				}
			});
			
			JLabel lblMotivoBaja = new JLabel("Motivo baja:");
			lblMotivoBaja.setForeground(Color.WHITE);
			lblMotivoBaja.setFont(new Font("Arial", Font.BOLD, 14));
			lblMotivoBaja.setBounds(337, 271, 119, 14);
			add(lblMotivoBaja);
			
			final JComboBox comboBaja = new JComboBox();
			comboBaja.setModel(new DefaultComboBoxModel(new String[] {"...", "Muerte", "Traspaso"}));
			comboBaja.setMaximumRowCount(3);
			comboBaja.setBounds(337, 291, 155, 22);
			add(comboBaja);
			btnVolver.setBackground(Color.ORANGE);
			btnVolver.setBounds(629, 18, 89, 37);
			add(btnVolver);
			
		
			textPrimateBaja = new JTextPane();
			textPrimateBaja.setBackground(Color.LIGHT_GRAY);
			textPrimateBaja.setFont(new Font("Tahoma", Font.BOLD, 12));
			textPrimateBaja.setEditable(false);
			//textPrimateBaja.setColumns(10);
			textPrimateBaja.setBounds(76, 360, 573, 186);
			add(textPrimateBaja);
			
			
			
			JLabel lblListaBaja = new JLabel("LISTA DE BAJAS DE PRIMATES");
			lblListaBaja.setForeground(Color.WHITE);
			lblListaBaja.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblListaBaja.setBounds(257, 334, 231, 28);
			add(lblListaBaja);
			
			
			textPrimateAlta = new JTextPane();
			textPrimateAlta.setBackground(Color.ORANGE);
			textPrimateAlta.setFont(new Font("Tahoma", Font.BOLD, 12));
			textPrimateAlta.setEditable(false);
			textPrimateAlta.setBounds(76, 74, 573, 175);
			add(textPrimateAlta);
			//textPrimateAlta.setColumns(10);
			
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
			campoIdBaja.setBounds(268, 292, 46, 20);
			add(campoIdBaja);
			campoIdBaja.setColumns(10);
			
			JLabel lblIdBaja = new JLabel("ID de animal a dar de baja:");
			lblIdBaja.setBackground(Color.GREEN);
			lblIdBaja.setForeground(Color.WHITE);
			lblIdBaja.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			lblIdBaja.setBounds(76, 286, 195, 28);
			add(lblIdBaja);
			
			
			
			JButton botonDarBaja = new JButton("Dar de baja");
			botonDarBaja.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//hacer select y si encuentra constructor baja
					
					Statement query = UtilsDB.conectarBD();
					
					short id = Short.parseShort(campoIdBaja.getText());
					
					try {
						ResultSet cursor = query.executeQuery("select id, nombre, date_format(fechaNacimiento,'%d-%m-%Y') "
								+ "as fechaNacimiento,motivoAlta,fechaAlta,genero,cuidados from altaPrimate where id="+id+";");
						if(cursor.next()) {
							
							//public Primate (short id,String nombre, LocalDate fechaNacimiento, MotivoBaja motivoBaja, LocalDate fechaBaja, boolean genero,
									//String cuidados)	
							String nombre = cursor.getString("nombre");
							DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
							LocalDate fechaNacimiento = LocalDate.parse(cursor.getString("fechaNacimiento"),formatter);		
							LocalDate fechaBaja = LocalDate.now();
							boolean genero = cursor.getBoolean("genero");
							String cuidados = cursor.getString("cuidados");
							MotivoBaja motivoBaja = null;
							
							if(comboBaja.getSelectedItem().equals("Muerte")) {
								motivoBaja=MotivoBaja.MUERTE;
							}else if (comboBaja.getSelectedItem().equals("Traspaso")) {
								motivoBaja=MotivoBaja.TRASPASO;
							}else if(comboBaja.getSelectedItem().equals("...")){
								motivoBaja = MotivoBaja.___;
							}
							
							
							
							Primate p = new Primate(id,nombre,fechaNacimiento,motivoBaja,fechaBaja,genero,cuidados);
							mostrarPrimatesAlta();
							mostrarPrimatesBaja();
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
						JOptionPane.showMessageDialog(null, "HAS DEJADO EL MOTIVO DE ALTA VACÍO", "ERROR", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
						
					
					
					UtilsDB.desconectarBD();
					
					
				}
			});
			botonDarBaja.setBackground(Color.RED);
			botonDarBaja.setForeground(Color.BLACK);
			botonDarBaja.setBounds(549, 271, 119, 54);
			add(botonDarBaja);
			
			JLabel background = new JLabel("");
			background.setIcon(new ImageIcon("C:\\Users\\carol\\Documents\\Eclipse-WORKSPACE\\ProyectoFinalProgramacionZoo\\ProyectoFinal_AgustinArcos\\fotos\\BACKGROUND_sinlogo.jpg"));
			background.setBounds(0, 0, 800, 600);
			add(background);
			
			JLabel txtFechaBaja = new JLabel("New label");
			txtFechaBaja.setFont(new Font("Arial", Font.BOLD, 14));
			txtFechaBaja.setBounds(0, 0, 46, 14);
			add(txtFechaBaja);
			
			mostrarPrimatesAlta();
			mostrarPrimatesBaja();
		
	}
	
	private void mostrarPrimatesAlta() {
		Statement query = UtilsDB.conectarBD();
		
		String listaPrimates = "";
		
		ResultSet cursor;
		try {
			cursor = query.executeQuery("select * from altaPrimate");
			
			while(cursor.next()) {
				String id = cursor.getString("id");
				String nombre = cursor.getString("nombre");
				listaPrimates +="●ID: "+ id +"     ●Nombre: "+ nombre + "\n";
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		textPrimateAlta.setText(listaPrimates);
	}
	
	private void mostrarPrimatesBaja() {
		Statement query = UtilsDB.conectarBD();
		
		String listaPrimates = "";
		
		ResultSet cursor;
		try {
			cursor = query.executeQuery("select * from bajaPrimate");
			
			while(cursor.next()) {
				String id = cursor.getString("id");
				String nombre = cursor.getString("nombre");
				String motivoBaja = cursor.getString("motivoBaja");
				listaPrimates +="●ID: "+ id +"     ●Nombre: "+ nombre + "\n";
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		textPrimateBaja.setText(listaPrimates);
	}
}
