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
 * @author Agust�n Arcos
 *
 */
public class Usuario extends EntidadConIdFechaYNombre {
	/**
	 * Variable de tipo String que indica el apellido del usuario.
	 */
	private String apellidos;
	/**
	 * Variable de tipo String que indica la contrase�a del usuario.
	 */
	private String contrasena;
/**
 * Constructor de la clase Usuario.
 * 
 * @param nombre Cadena de caracteres que contiene el nombre del usuario.
 * @param apellidos Variable de tipo String que indica la contrase�a del usuario.
 * @param id Variable num�rica de tipo short que contiene la id del usuario. 
 * @param contrasena Variable de tipo String que indica la contrase�a del usuario.
 * @param fechaNacimiento Variable de tipo LocalDate que contiene la fecha de nacimiento del animal.
 * @throws ContrasenaVaciaException Excepci�n que se lanza cuando el campo contrase�a est� vac�o.
 * @throws ContrasenaLargaException Excepci�n que se lanza cuando la contrase�a es m�s larga a lo establecido.
 * @throws ContrasenaInvalidaException Excepci�n que se lanza cuando la contras�ea introducida no es v�lida.
 * @throws NombreInvalidoException Excepci�n que se lanza cuando el nombre introducido no es v�lido.
 * @throws NombreVacioException Excepci�n que se lanza cuando el campo del nombre est� vac�o.
 * @throws FechaFormatoException Excepci�n que se lanza cuando el formato de fecha introducido no es correcto.
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
	 * @param apellidos Variable de tipo String que indica la contrase�a del usuario.
	 * @param contrasena Variable de tipo String que indica la contrase�a del usuario.
	 * @param fechaNacimiento Variable de tipo LocalDate que contiene la fecha de nacimiento del animal.
	 * @throws ContrasenaVaciaException Excepci�n que se lanza cuando el campo contrase�a est� vac�o.
	 * @throws ContrasenaLargaException Excepci�n que se lanza cuando la contrase�a es m�s larga a lo establecido.
	 * @throws ContrasenaInvalidaException Excepci�n que se lanza cuando la contras�ea introducida no es v�lida.
	 * @throws NombreInvalidoException Excepci�n que se lanza cuando el nombre introducido no es v�lido.
	 * @throws NombreVacioException Excepci�n que se lanza cuando el campo del nombre est� vac�o.
	 * @throws FechaFormatoException Excepci�n que se lanza cuando el formato de fecha introducido no es correcto.
	 * @throws SQLException Excepci�n que se lanza cuando hay alg�n problema relacionado con la base de datos.
	 */
	public Usuario(String nombre, String apellidos, String contrasena, LocalDate fechaNacimiento)
			throws NombreVacioException, NombreInvalidoException, SQLException, FechaFormatoException, ContrasenaVaciaException, ContrasenaInvalidaException, ContrasenaLargaException {
		super(fechaNacimiento, nombre);
		//Conexi�n a la base de datos.
		Statement query = UtilsDB.conectarBD();

		
		
		//Inserci�n de los datos del usuario en la base de datos.
		if (query.executeUpdate("insert into usuarios values(null,'" + nombre + "','" + apellidos + "','"
				+ fechaNacimiento + "','" + contrasena + "'" + ")") > 0)

		{
			this.setContrasena(contrasena);
			this.apellidos = apellidos;
			
		} else {
			throw new SQLException("No se ha podido insertar el usuario");
		}
		//Desconexi�n de la base de datos.
		UtilsDB.desconectarBD();
	}
	/**
	 * Constructor de la clase Usuario, para hacer login del usuario.
	 * 
	 * @param nombre Cadena de caracteres que contiene el nombre del usuario.
	 * @param contrasena Variable de tipo String que indica la contrase�a del usuario.
	 * @throws ContrasenaVaciaException Excepci�n que se lanza cuando el campo contrase�a est� vac�o.
	 * @throws ContrasenaLargaException Excepci�n que se lanza cuando la contrase�a es m�s larga a lo establecido.
	 * @throws ContrasenaInvalidaException Excepci�n que se lanza cuando la contras�ea introducida no es v�lida.
	 * @throws NombreInvalidoException Excepci�n que se lanza cuando el nombre introducido no es v�lido.
	 * @throws NombreVacioException Excepci�n que se lanza cuando el campo del nombre est� vac�o.
	 * @throws FechaFormatoException Excepci�n que se lanza cuando el formato de fecha introducido no es correcto.
	 * @throws SQLException Excepti�n que se lanza cuando hay alg�n problema relacionado con la base de datos.
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
				throw new ContrasenaInvalidaException("La contrase�a introducida no es v�lida");
			}

			this.setNombre(cursor.getString("nombre"));
			this.setContrasena(cursor.getString("contrasena"));

		} else {
			UtilsDB.desconectarBD();
			throw new NombreInvalidoException("El nombre de usuario no es v�lido");
		}
		UtilsDB.desconectarBD();
	}
	/**
	 * Funci�n que devuelve los apellidos del usuario.
	 * @return Apellidos del usuario.
	 */
	public String getApellidos() {
		return apellidos;
	}
	/**
	 * Funci�n que establece apellidos al objeto.
	 * @param apellidos Los apellidos del usuario.
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	/**
	 * Funci�n que devuelve la contrase�a.
	 * @return Contrase�a.
	 */
	public String getContrasena() {
		return contrasena;
	}
	/**
	 * Funci�n que establece una contrase�a en el objeto.
	 * @param contrase�a La contrase�a del usuario.
	 * @throws ContrasenaInavalidaException Excepci�n que se lanza cuando la contrase�a introducida no es v�lida.
	 * @throws ContrasenaLargaException Excepci�n que se lanza cuando el tama�o de la contrasela es m�s larga de lo establecido.
	 * @throws ContrasenaVaciaExceptiopn Excepci�n que se lanza cuando el campo de la contrase�a est� vac�o.
	 */
	public void setContrasena(String contrasena)
			throws ContrasenaInvalidaException, ContrasenaLargaException, ContrasenaVaciaException {
		if(contrasena.isEmpty() ) {
			throw new ContrasenaVaciaException("Error. El campo contrase�a no puede estar vac�o.");
		} 

		else if (contrasena.length() > 15) {
			throw new ContrasenaLargaException("Error. Contrase�a muy larga. M�ximo 20 caracteres.");
		} 
		else if (contrasena != contrasena) {
			throw new ContrasenaInvalidaException("Error. Las contrase�as no coinciden");
		} else {
			this.contrasena = contrasena;
		}
	}


}
