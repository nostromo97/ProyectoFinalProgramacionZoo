package Superclases;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Excepciones.FechaFormatoException;
import Excepciones.IdInvalidoException;
import Excepciones.IdVacioException;
import Excepciones.NombreInvalidoException;
import Excepciones.NombreVacioException;
/**
 * Clase que modela una entidad con id, fecha y nombre
 * @author Agustín
 *
 */
public class  EntidadConIdFechaYNombre  {
	
	
	private short id;
	private LocalDate fechaNacimiento;
	private String nombre;
	
	public EntidadConIdFechaYNombre(short id, LocalDate fechaNacimiento, String nombre) 
			throws NombreVacioException,NombreInvalidoException, FechaFormatoException{
		super();
		this.setId(id);
		this.setFechaNacimiento(fechaNacimiento);
		this.setNombre(nombre);
	}
	
	
	
	public EntidadConIdFechaYNombre(LocalDate fechaNacimiento, String nombre) throws NombreVacioException, NombreInvalidoException, FechaFormatoException {
		super();
		this.setFechaNacimiento(fechaNacimiento);
		this.setNombre(nombre);
	}
	
	public EntidadConIdFechaYNombre (short id,String nombre) throws NombreVacioException, NombreInvalidoException {
		this.setNombre(nombre);
		this.setId(id);
	}

	public EntidadConIdFechaYNombre(String nombre) throws NombreVacioException, NombreInvalidoException {
		super();
		setNombre(nombre);
	}
	
	

	public short getId() {
		return id;
	}
	public void setId(short id){
		
			this.id=id;
		}
		
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	/**
	 * Función que establece una nueva fecha de nacimiento.
	 * @param fechaNacimiento Nuevo valor fecha de nacimiento
	 * @throws FechaFormatoException Excepción que se lanza cundo no se introduce correctamente el formato de la fecha.
	 */
	public void setFechaNacimiento(LocalDate fechaNacimiento) throws FechaFormatoException{
		Pattern pattern = Pattern.compile("dd-MM-YYYY");
		Matcher matcher = pattern.matcher(fechaNacimiento.toString());
		if(matcher.matches()) {
			throw new FechaFormatoException ("Error. Introduce la fecha en un formato: dd-MM-YYYY (día, mes, año)");
		}
		
		this.fechaNacimiento = fechaNacimiento;
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre (String nombre) throws NombreVacioException,NombreInvalidoException{
		
		if(nombre.isBlank()) {
			throw new NombreVacioException("Error. El Nombre no puede estar vacío.");
		}else {
			this.nombre=nombre;
		}
		
		Pattern pattern = Pattern.compile("[a-zA-Z ]*\\d+.*");
		Matcher matcher = pattern.matcher(nombre);
		if(matcher.matches()) {
			throw new NombreInvalidoException ("Error. El nombre no puede contener números.");
		}
		this.nombre = nombre;
	}
	
	
	
	
}
