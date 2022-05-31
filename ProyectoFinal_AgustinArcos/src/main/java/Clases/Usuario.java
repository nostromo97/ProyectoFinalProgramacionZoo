package Clases;

import java.time.LocalDate;

import Excepciones.ContrasenaInvalidaException;
import Excepciones.ContrasenaLargaException;
import Excepciones.ContrasenaVaciaException;
import Excepciones.IdInvalidoException;
import Excepciones.IdVacioException;
import Excepciones.NombreInvalidoException;
import Excepciones.NombreVacioException;
import Superclases.EntidadConIdFechaYNombre;

public class Usuario extends EntidadConIdFechaYNombre{
	
	private String apellidos;
	private String contrasena;
	
	public Usuario(String nombre, String apellidos, String id, String contrasena,LocalDate fechaNacimiento) throws ContrasenaVaciaException, ContrasenaLargaException,
	ContrasenaInvalidaException, NombreInvalidoException, IdInvalidoException, NombreVacioException, IdVacioException{
		super(id, fechaNacimiento, nombre);
		this.apellidos = apellidos;
		this.setContrasena(contrasena);
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
		if (contrasena == "") {
			throw new NombreVacioException ("Error. El campo contraseña no puede estar vacío.");
		}else {
			this.contrasena = contrasena;
		}
		
		if(contrasena.length() > 20 ) {
			throw new ContrasenaLargaException ("Error. Contraseña muy larga. Máximo 20 caracteres.");
		}else {
			this.contrasena=contrasena;
			
		}if(contrasena != contrasena) {
			throw new ContrasenaInvalidaException ("Error. Las contraseñas no coinciden");
		}else {
			this.contrasena=contrasena;
		}
		
		
	}
	
	
	
	
}
