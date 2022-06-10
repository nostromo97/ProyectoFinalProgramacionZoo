package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

import Excepciones.ContrasenaInvalidaException;
import Excepciones.ContrasenaLargaException;
import Excepciones.ContrasenaVaciaException;
import Excepciones.FechaFormatoException;
import Excepciones.IdInvalidoException;
import Excepciones.IdVacioException;
import Excepciones.MotivoVacioException;
import Excepciones.NombreInvalidoException;
import Excepciones.NombreVacioException;
import Superclases.EntidadConIdFechaYNombre;
import Utils.UtilsDB;
/**
 * Clase que contiene un objeto de tipo Usuario que extiende de la superclase EntidadConIdFechaYNombre.
 * @author Agustín Arcos
 *
 */
public class Usuario extends EntidadConIdFechaYNombre {
	/**
	 * Variable de tipo String que indica el apellido del usuario.
	 */
	private String apellidos;
	/**
	 * Variable de tipo String que indica la contraseña del usuario.
	 */
	private String contrasena;
/**
 * Constructor de la clase Usuario.
 * 
 * @param nombre Cadena de caracteres que contiene el nombre del usuario.
 * @param apellidos Variable de tipo String que indica la contraseña del usuario.
 * @param id Variable numérica de tipo short que contiene la id del usuario. 
 * @param contrasena Variable de tipo String que indica la contraseña del usuario.
 * @param fechaNacimiento Variable de tipo LocalDate que contiene la fecha de nacimiento del animal.
 * @throws ContrasenaVaciaException Excepción que se lanza cuando el campo contraseña está vacío.
 * @throws ContrasenaLargaException Excepción que se lanza cuando la contraseña es más larga a lo establecido.
 * @throws ContrasenaInvalidaException Excepción que se lanza cuando la contrasñea introducida no es válida.
 * @throws NombreInvalidoException Excepción que se lanza cuando el nombre introducido no es válido.
 * @throws NombreVacioException Excepción que se lanza cuando el campo del nombre está vacío.
 * @throws FechaFormatoException Excepción que se lanza cuando el formato de fecha introducido no es correcto.
 */
	public Usuario(String nombre, String apellidos, short id, String contrasena, LocalDate fechaNacimiento)
			throws ContrasenaVaciaException, ContrasenaLargaException, ContrasenaInvalidaException,
			NombreInvalidoException, NombreVacioException, FechaFormatoException {
		super(id, fechaNacimiento, nombre);
		this.apellidos = apellidos;
		this.setContrasena(contrasena);
	}

	/**
	 * Constructor de la clase Usuario, para insertar un usuario en la base de datos.
	 * 
	 * @param nombre Cadena de caracteres que contiene el nombre del usuario.
	 * @param apellidos Variable de tipo String que indica la contraseña del usuario.
	 * @param contrasena Variable de tipo String que indica la contraseña del usuario.
	 * @param fechaNacimiento Variable de tipo LocalDate que contiene la fecha de nacimiento del animal.
	 * @throws ContrasenaVaciaException Excepción que se lanza cuando el campo contraseña está vacío.
	 * @throws ContrasenaLargaException Excepción que se lanza cuando la contraseña es más larga a lo establecido.
	 * @throws ContrasenaInvalidaException Excepción que se lanza cuando la contrasñea introducida no es válida.
	 * @throws NombreInvalidoException Excepción que se lanza cuando el nombre introducido no es válido.
	 * @throws NombreVacioException Excepción que se lanza cuando el campo del nombre está vacío.
	 * @throws FechaFormatoException Excepción que se lanza cuando el formato de fecha introducido no es correcto.
	 * @throws SQLException Excepción que se lanza cuando hay algún problema relacionado con la base de datos.
	 */
	public Usuario(String nombre, String apellidos, String contrasena, LocalDate fechaNacimiento)
			throws NombreVacioException, NombreInvalidoException, SQLException, FechaFormatoException, ContrasenaVaciaException, ContrasenaInvalidaException, ContrasenaLargaException {
		super(fechaNacimiento, nombre);
		//Conexión a la base de datos.
		Statement query = UtilsDB.conectarBD();

		
		
		//Inserción de los datos del usuario en la base de datos.
		if (query.executeUpdate("insert into usuarios values(null,'" + nombre + "','" + apellidos + "','"
				+ fechaNacimiento + "','" + contrasena + "'" + ")") > 0)

		{
			this.setContrasena(contrasena);
			this.apellidos = apellidos;
			
		} else {
			throw new SQLException("No se ha podido insertar el usuario");
		}
		//Desconexión de la base de datos.
		UtilsDB.desconectarBD();
	}
	/**
	 * Constructor de la clase Usuario, para hacer login del usuario.
	 * 
	 * @param nombre Cadena de caracteres que contiene el nombre del usuario.
	 * @param contrasena Variable de tipo String que indica la contraseña del usuario.
	 * @throws ContrasenaVaciaException Excepción que se lanza cuando el campo contraseña está vacío.
	 * @throws ContrasenaLargaException Excepción que se lanza cuando la contraseña es más larga a lo establecido.
	 * @throws ContrasenaInvalidaException Excepción que se lanza cuando la contrasñea introducida no es válida.
	 * @throws NombreInvalidoException Excepción que se lanza cuando el nombre introducido no es válido.
	 * @throws NombreVacioException Excepción que se lanza cuando el campo del nombre está vacío.
	 * @throws FechaFormatoException Excepción que se lanza cuando el formato de fecha introducido no es correcto.
	 * @throws SQLException Exceptión que se lanza cuando hay algún problema relacionado con la base de datos.
	 */
	public Usuario(String nombre, String contrasena)
			throws NombreVacioException, NombreInvalidoException, SQLException, ContrasenaInvalidaException, ContrasenaVaciaException, ContrasenaLargaException {
		super(nombre);
		Scanner sc = new Scanner(System.in);
		Statement smt = UtilsDB.conectarBD();
		ResultSet cursor = smt.executeQuery("select * from usuarios where nombre='" + nombre + "'");

		if (cursor.next()) {
			this.contrasena = contrasena;
			if (!this.contrasena.equals(cursor.getString("contrasena"))) {
				UtilsDB.desconectarBD();
				throw new ContrasenaInvalidaException("La contraseña introducida no es válida");
			}

			this.setNombre(cursor.getString("nombre"));
			this.setContrasena(cursor.getString("contrasena"));

		} else {
			UtilsDB.desconectarBD();
			throw new NombreInvalidoException("El nombre de usuario no es válido");
		}
		UtilsDB.desconectarBD();
	}
	/**
	 * Función que devuelve los apellidos del usuario.
	 * @return Apellidos del usuario.
	 */
	public String getApellidos() {
		return apellidos;
	}
	/**
	 * Función que establece apellidos al objeto.
	 * @param apellidos Los apellidos del usuario.
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	/**
	 * Función que devuelve la contraseña.
	 * @return Contraseña.
	 */
	public String getContrasena() {
		return contrasena;
	}
	/**
	 * Función que establece una contraseña en el objeto.
	 * @param contraseña La contraseña del usuario.
	 * @throws ContrasenaInavalidaException Excepción que se lanza cuando la contraseña introducida no es válida.
	 * @throws ContrasenaLargaException Excepción que se lanza cuando el tamaño de la contrasela es más larga de lo establecido.
	 * @throws ContrasenaVaciaExceptiopn Excepción que se lanza cuando el campo de la contraseña está vacío.
	 */
	public void setContrasena(String contrasena)
			throws ContrasenaInvalidaException, ContrasenaLargaException, ContrasenaVaciaException {
		if(contrasena.isEmpty() ) {
			throw new ContrasenaVaciaException("Error. El campo contraseña no puede estar vacío.");
		} 

		else if (contrasena.length() > 15) {
			throw new ContrasenaLargaException("Error. Contraseña muy larga. Máximo 20 caracteres.");
		} 
		else if (contrasena != contrasena) {
			throw new ContrasenaInvalidaException("Error. Las contraseñas no coinciden");
		} else {
			this.contrasena = contrasena;
		}
	}


}
