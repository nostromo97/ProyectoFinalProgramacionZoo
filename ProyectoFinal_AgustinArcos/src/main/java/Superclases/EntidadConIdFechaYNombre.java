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
 * @author Agust�n Arcos
 *
 */
public class  EntidadConIdFechaYNombre  {
	
	/**
	 * Variable num�rica de tipo short que contiene un id.
	 */
	private short id;
	/**
	 * Variable de tipo LocalDate que contiene una fecha de nacimiento.
	 */
	private LocalDate fechaNacimiento;
	/**
	 * Cadena de caracteres que contiene un nombre.  
	 */
	private String nombre;
	/**
	 * Constructor de la superclase EntidadConIdFechaYNombre
	 * @param id Variable num�rica de tipo short que contiene un id.
	 * @param fechaNacimiento Variable de tipo LocalDate que contiene una fecha de nacimiento.
	 * @param nombre Cadena de caracteres que contiene un nombre.  
	 * @throws NombreVacioException Excepci�n que se lanza cuando el campo del nombre est� vac�o.
	 * @throws NombreInvalidoException Excepci�n que se lanza cuando el nombre introducie no es v�lido.
	 * @throws FechaFormatoException Excepci�n que se lanza cuando el formato de la fecha que se introduce no es el correcto.
	 */
	public EntidadConIdFechaYNombre(short id, LocalDate fechaNacimiento, String nombre) 
			throws NombreVacioException,NombreInvalidoException, FechaFormatoException{
		super();
		this.setId(id);
		this.setFechaNacimiento(fechaNacimiento);
		this.setNombre(nombre);
	}
	
	
	/**
	 * Constructor de la superclase EntidadConIdFechaYNombre
	 * @param fechaNacimiento Variable de tipo LocalDate que contiene una fecha de nacimiento.
	 * @param nombre Cadena de caracteres que contiene un nombre.  
	 * @throws NombreVacioException Excepci�n que se lanza cuando el campo del nombre est� vac�o.
	 * @throws NombreInvalidoException Excepci�n que se lanza cuando el nombre introducie no es v�lido.
	 * @throws FechaFormatoException Excepci�n que se lanza cuando el formato de la fecha que se introduce no es el correcto.
	 */	
	public EntidadConIdFechaYNombre(LocalDate fechaNacimiento, String nombre) throws NombreVacioException, NombreInvalidoException, FechaFormatoException {
		super();
		this.setFechaNacimiento(fechaNacimiento);
		this.setNombre(nombre);
	}
	/**
	 * Constructor de la superclase EntidadConIdFechaYNombre
	 * @param id Variable num�rica de tipo short que contiene un id.
	 * @param nombre Cadena de caracteres que contiene un nombre.  
	 * @throws NombreVacioException Excepci�n que se lanza cuando el campo del nombre est� vac�o.
	 * @throws NombreInvalidoException Excepci�n que se lanza cuando el nombre introducie no es v�lido.
	 * @throws FechaFormatoException Excepci�n que se lanza cuando el formato de la fecha que se introduce no es el correcto.
	 */
	public EntidadConIdFechaYNombre (short id,String nombre) throws NombreVacioException, NombreInvalidoException {
		this.setNombre(nombre);
		this.setId(id);
	}
	/**
	 * Constructor de la superclase EntidadConIdFechaYNombre
	 * @param nombre Cadena de caracteres que contiene un nombre.  
	 * @throws NombreVacioException Excepci�n que se lanza cuando el campo del nombre est� vac�o.
	 * @throws NombreInvalidoException Excepci�n que se lanza cuando el nombre introducie no es v�lido.
	 */
	public EntidadConIdFechaYNombre(String nombre) throws NombreVacioException, NombreInvalidoException {
		super();
		setNombre(nombre);
	}
	


	/**
	 * Funci�n que devuelve el valor de la id.
	 * @return La id del objeto.
	 */	
	public short getId() {
		return id;
	}
	/**
	 * Funci�n que establece nuevo id.
	 * @param id Nuevo valor para la id.
	 */
	public void setId(short id){
		
			this.id=id;
		}
	/**
	 * Funci�n que devuelve la fecha de nacimiento.
	 * @return La fecha de nacimiento.
	 */		
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	/**
	 * Funci�n que establece una nueva fecha de nacimiento.
	 * @param fechaNacimiento Nuevo valor fecha de nacimiento
	 * @throws FechaFormatoException Excepci�n que se lanza cundo no se introduce correctamente el formato de la fecha.
	 */
	public void setFechaNacimiento(LocalDate fechaNacimiento) throws FechaFormatoException{
		Pattern pattern = Pattern.compile("dd-MM-YYYY");
		Matcher matcher = pattern.matcher(fechaNacimiento.toString());
		if(matcher.matches()) {
			throw new FechaFormatoException ("Error. Introduce la fecha en un formato: dd-MM-YYYY (d�a, mes, a�o)");
		}
		
		this.fechaNacimiento = fechaNacimiento;
		
	}
	/**
	 * Funci�n que devuelve el nombre.
	 * @return El nombre.
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Funci�n que establece un nuevo nombre.
	 * @param nombre Nuevo valor para el nombre.
	 * @throws NombreVacioException Excepci�n que se lanza cuando el campo nombre est� vac�o.
	 * @throws NombreInvalidoException Excepci�n que se lanza cuando el nombre introducido no es v�lido.
	 */
	public void setNombre (String nombre) throws NombreVacioException,NombreInvalidoException{
		
		if(nombre.isBlank()) {
			throw new NombreVacioException("Error. El Nombre no puede estar vac�o.");
		}else {
			this.nombre=nombre;
		}
		
		Pattern pattern = Pattern.compile("[a-zA-Z ]*\\d+.*");
		Matcher matcher = pattern.matcher(nombre);
		if(matcher.matches()) {
			throw new NombreInvalidoException ("Error. El nombre no puede contener n�meros.");
		}
		this.nombre = nombre;
	}
	
	
	
	
}
