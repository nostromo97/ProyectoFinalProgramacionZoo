package Clases;

import java.time.LocalDate;

public class Usuario extends EntidadConIdFechaYNombre{
	
	private String apellidos;
	private String contrasena;
	
	public Usuario(int id, LocalDate fechaNacimiento, String nombre, String apellidos, String contrasena) {
		super(id, fechaNacimiento, nombre);
		this.apellidos = apellidos;
		this.contrasena = contrasena;
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

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
	
	
}
