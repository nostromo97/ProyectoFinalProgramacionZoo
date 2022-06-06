package Clases;

import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import Excepciones.ContrasenaInvalidaException;
import Excepciones.ContrasenaLargaException;
import Excepciones.ContrasenaVaciaException;
import Excepciones.IdInvalidoException;
import Excepciones.IdVacioException;
import Excepciones.NombreInvalidoException;
import Excepciones.NombreVacioException;
import Superclases.EntidadConIdFechaYNombre;
import Utils.UtilsDB;


public class Usuario extends EntidadConIdFechaYNombre{
	
	private String apellidos;
	private String contrasena;
	
	public Usuario(String nombre, String apellidos, short id, String contrasena,LocalDate fechaNacimiento) throws ContrasenaVaciaException, ContrasenaLargaException,
	ContrasenaInvalidaException, NombreInvalidoException, IdInvalidoException, NombreVacioException, IdVacioException{
		super(id, fechaNacimiento, nombre);
		this.apellidos = apellidos;
		this.setContrasena(contrasena);
	}
	

	



	public Usuario(LocalDate fechaNacimiento, String nombre, String apellidos, String contrasena)
			throws NombreVacioException, NombreInvalidoException, IdInvalidoException, IdVacioException, SQLException {
		super(fechaNacimiento, nombre);
		
		Statement query = UtilsDB.conectarBD();
		
		if(query.executeUpdate("insert into usuarios values('"+nombre+"','"+apellidos+"','"+fechaNacimiento+"','"+contrasena+"'"+")")>0)
		//"insert into mascota values('"+numeroChip+"','"+raza+"','"+nombre+"','"+humano.getNombre()+"'"+")")>0
			{
			this.apellidos = apellidos;
			this.contrasena = contrasena;		
		}else {
			throw new SQLException("No se ha podido insertar la mascota.");
		}
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

	public void setContrasena(String contrasena) throws ContrasenaInvalidaException, NombreVacioException, ContrasenaLargaException{
		if (this.contrasena == "") {
			throw new NombreVacioException ("Error. El campo contraseña no puede estar vacío.");
		}else {
			this.contrasena = contrasena;
		}
		
		if(this.contrasena.length() > 20 ) {
			throw new ContrasenaLargaException ("Error. Contraseña muy larga. Máximo 20 caracteres.");
		}else {
			this.contrasena=contrasena;
			
		}if(this.contrasena != contrasena) {
			throw new ContrasenaInvalidaException ("Error. Las contraseñas no coinciden");
		}else {
			this.contrasena=contrasena;
		}		
	}
	
		
}
