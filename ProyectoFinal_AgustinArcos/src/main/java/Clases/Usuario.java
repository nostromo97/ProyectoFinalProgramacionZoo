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
import Excepciones.NombreInvalidoException;
import Excepciones.NombreVacioException;
import Superclases.EntidadConIdFechaYNombre;
import Utils.UtilsDB;

public class Usuario extends EntidadConIdFechaYNombre {

	private String apellidos;
	private String contrasena;

	public Usuario(String nombre, String apellidos, short id, String contrasena, LocalDate fechaNacimiento)
			throws ContrasenaVaciaException, ContrasenaLargaException, ContrasenaInvalidaException,
			NombreInvalidoException, NombreVacioException, FechaFormatoException {
		super(id, fechaNacimiento, nombre);
		this.apellidos = apellidos;
		this.setContrasena(contrasena);
	}

//Insertar usuario en la base de datos.
	public Usuario(String nombre, String apellidos, String contrasena, LocalDate fechaNacimiento)
			throws NombreVacioException, NombreInvalidoException, SQLException, FechaFormatoException {
		super(fechaNacimiento, nombre);

		Statement query = UtilsDB.conectarBD();

		if (query.executeUpdate("insert into usuarios values(null,'" + nombre + "','" + apellidos + "','"
				+ fechaNacimiento + "','" + contrasena + "'" + ")") > 0)

		{
			this.apellidos = apellidos;
			this.contrasena = contrasena;
		} else {
			throw new SQLException("No se ha podido insertar el usuario");
		}
		UtilsDB.desconectarBD();
	}

	public Usuario(String nombre, String contrasena)
			throws NombreVacioException, NombreInvalidoException, SQLException, ContrasenaInvalidaException {
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

		} else {
			UtilsDB.desconectarBD();
			throw new NombreInvalidoException("El nombre de usuario no es válido");
		}
		UtilsDB.desconectarBD();
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena)
			throws ContrasenaInvalidaException, NombreVacioException, ContrasenaLargaException {
		if (this.contrasena == "") {
			throw new NombreVacioException("Error. El campo contraseña no puede estar vacío.");
		} else {
			this.contrasena = contrasena;
		}

		if (this.contrasena.length() > 20) {
			throw new ContrasenaLargaException("Error. Contraseña muy larga. Máximo 20 caracteres.");
		} else {
			this.contrasena = contrasena;

		}
		if (this.contrasena != contrasena) {
			throw new ContrasenaInvalidaException("Error. Las contraseñas no coinciden");
		} else {
			this.contrasena = contrasena;
		}
	}


}
