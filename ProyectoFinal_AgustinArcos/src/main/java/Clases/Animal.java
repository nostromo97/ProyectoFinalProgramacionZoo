package Clases;

import java.time.LocalDate;
import java.util.ArrayList;

import Enums.MotivoAlta;
import Enums.MotivoBaja;
import Enums.TipoRaza;
import Excepciones.FechaFormatoException;
import Excepciones.IdInvalidoException;
import Excepciones.IdVacioException;
import Excepciones.MotivoVacioException;
import Excepciones.NombreInvalidoException;
import Excepciones.NombreVacioException;
import Excepciones.TipoAmbienteVacioException;
import Excepciones.TipoOrdenVacioException;
import Superclases.EntidadConIdFechaYNombre;
/**
 * Clase que contiene un objeto de tipo Animal que extiende de la superclase EntidadConIdFechaYNombre.
 * @author Agust�n Arcos
 *
 */
public class Animal extends EntidadConIdFechaYNombre{

	/**
	 * Variable interna de clase Animal que contiene un tipo de raza de Animal, del Enum TipoRaza.
	 * */
	private TipoRaza raza;
	//private Cuidados cuidados;
	/**
	 * Cadena de caracteres que contiene una descripci�n del cuidado necesario para el animal, en el caso de que lo necesite.
	 */
	private String cuidados;
	/**
	 * Del tipo MotivoAlta, viene del Enum MotivoAlta que contiene los motivos de alta del animal.
	 */
	private MotivoAlta motivoAlta;
	/**
	 * Del tipo MotivoBaja, viene del Enum MotivoBaja que contiene los motivos de la baja del animal.
	 */
	private MotivoBaja motivoBaja;
	/**
	 * De tipo LocalDate, contiene la fecha de alta del animal en el centro.
	 */
	private LocalDate fechaAlta;
	/**
	 * De tipo LocalDate, contiene la fecha de baja del animal en el centro.
	 */
	private LocalDate fechaBaja;
	/**
	 * De tipo Dieta, contiene un ArrayList de alimentos para cada d�a de la semana, seg�n la alimentaci�n del animal.
	 */
	private Dieta dieta;
	/**
	 * De tipo boolean, indica el g�nero del animal, Masculino o Femenino, tomando los valores true y false.
	 */
	private boolean genero;
	
	/**
	 * 	Constructor de la clase Animal que extiende de la superclase EntidadConIdFechaYNombre.
	 * 
	 * @param id Variable num�rica de tipo short que contiene el id del animal.                         
	 * @param fechaNacimiento Variable de tipo LocalDate que contiene la fecha de nacimiento del animal.
	 * @param nombre Cadena de caracteres que contiene el nombre del animal.
	 * @param raza Proveniente del Enum TipoRaza que contiene el tipo de raza del animal.
	 * @param cuidados Cadena de caracteres que contiene una descripci�n del cuidado 
	 * 				   necesario para el animal, en el caso de que lo necesite.
	 * @param motivoAlta Proviene del Enum MotivoAlta que contiene los motivos de alta del animal.
	 * @param motivoBaja Proviene del Enum MotivoBaja que contiene los motivos de baja del animal.
	 * @param fechaAlta De tipo LocalDate, contiene la fecha de alta del animal en el centro.
	 * @param fechaBaja De tipo LocalDate, contiene la fecha de baja del animal en el centro.
	 * @param dieta De tipo Dieta, contiene ArrayList cada d�a de la semana con los alimentos que come al d�a el animal.
	 * @throws NombreVacioException Excepci�n que se lanza cuando el nombre est� vac�o. 
	 * @throws NombreInvalidoException Excepci�n que se lanza cuando el nombre no es v�lido.
	 * @throws IdInvalidoException Excepci�n quqe se lanza cuando la id no es v�lida.
	 * @throws IdVacioException Excepci�n que se lanza cuando el id est� vac�o.
	 * @throws FechaFormatoException Excepci�n que se lanza cuando la fecha se introduce en un formato incorrecto.
	 */
	public Animal(short id, LocalDate fechaNacimiento, String nombre, TipoRaza raza, String cuidados,
			MotivoAlta motivoAlta, MotivoBaja motivoBaja, LocalDate fechaAlta, LocalDate fechaBaja, Dieta dieta) 
					throws NombreVacioException, NombreInvalidoException, IdInvalidoException, IdVacioException, FechaFormatoException {
		super(id, fechaNacimiento, nombre);
		this.raza = raza;
		this.cuidados = cuidados;
		this.motivoAlta = motivoAlta;
		this.motivoBaja = motivoBaja;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.dieta = dieta;
	}
	
	/**
	 * 	Constructor para dar de alta a un Animal, que extiende de la superclase EntidadConIdFechaYNombre.
	 *
	 * @param nombre Cadena de caracteres que contiene el nombre del animal.
	 * @param fechaNacimiento Variable de tipo LocalDate que contiene la fecha de nacimiento del animal.
	 * 				   necesario para el animal, en el caso de que lo necesite.
	 * @param motivoAlta Proviene del Enum MotivoAlta que contiene los motivos de alta del animal.
	 * @param fechaAlta De tipo LocalDate, contiene la fecha de alta del animal en el centro.
	 * @param cuidados Cadena de caracteres que contiene una descripci�n del cuidado 
	 * @throws NombreVacioException Excepci�n que se lanza cuando el nombre est� vac�o. 
	 * @throws NombreInvalidoException Excepci�n que se lanza cuando el nombre no es v�lido.
	 * @throws FechaFormatoException Excepci�n que se lanza cuando la fecha se introduce en un formato incorrecto.
	 * @throws MotivoVacioException Excepci�n que se lanza cuando no se selecciona ning�n motivo de alta.
	 */
	
public Animal(String nombre,LocalDate fechaNacimiento,  MotivoAlta motivoAlta, LocalDate fechaAlta, String cuidados
		) throws NombreVacioException, NombreInvalidoException, FechaFormatoException,MotivoVacioException {
	super(fechaNacimiento, nombre);
	this.cuidados = cuidados;
	this.setMotivoAlta(motivoAlta);
	this.fechaAlta = fechaAlta;
}
/**
 * 	Constructor para dar de baja a un Animal, que extiende de la superclase EntidadConIdFechaYNombre.
 *
 * @param nombre Cadena de caracteres que contiene el nombre del animal.
 * @param fechaNacimiento Variable de tipo LocalDate que contiene la fecha de nacimiento del animal.
 * 				   necesario para el animal, en el caso de que lo necesite.
 * @param motivoBaja Proviene del Enum MotivoBaja que contiene los motivos de alta del animal.
 * @param fechaBaja De tipo LocalDate, contiene la fecha de baja del animal en el centro.
 * @param cuidados Cadena de caracteres que contiene una descripci�n del cuidado 
 * @throws NombreVacioException Excepci�n que se lanza cuando el nombre est� vac�o. 
 * @throws NombreInvalidoException Excepci�n que se lanza cuando el nombre no es v�lido.
 * @throws FechaFormatoException Excepci�n que se lanza cuando la fecha se introduce en un formato incorrecto.
 * @throws MotivoVacioException Excepci�n que se lanza cuando no se selecciona ning�n motivo de alta.
 */
public Animal(short id,String nombre,LocalDate fechaNacimiento,  MotivoBaja motivoBaja, LocalDate fechaBaja, String cuidados
		) throws NombreVacioException, NombreInvalidoException, FechaFormatoException,MotivoVacioException {
	super(id,fechaNacimiento, nombre);
	this.cuidados = cuidados;
	this.setMotivoBaja(motivoBaja);
	this.fechaBaja = fechaBaja;
}
/**
 * 	Constructor para dar de baja a un Animal, que extiende de la superclase EntidadConIdFechaYNombre.
 *
 * @param nombre Cadena de caracteres que contiene el nombre del animal.
 * @param fechaNacimiento Variable de tipo LocalDate que contiene la fecha de nacimiento del animal.
 * 				   necesario para el animal, en el caso de que lo necesite.
 * @param motivoAlta Proviene del Enum MotivoAlta que contiene los motivos de alta del animal.
 * @param fechaAlta De tipo LocalDate, contiene la fecha de alta del animal en el centro.
 * @param cuidados Cadena de caracteres que contiene una descripci�n del cuidado 
 * @throws NombreVacioException Excepci�n que se lanza cuando el nombre est� vac�o. 
 * @throws NombreInvalidoException Excepci�n que se lanza cuando el nombre no es v�lido.
 * @throws FechaFormatoException Excepci�n que se lanza cuando la fecha se introduce en un formato incorrecto.

 */
	public Animal(String nombre, LocalDate fechaNacimiento, Cuidados cuidados, MotivoAlta motivoAlta, LocalDate fechaAlta, boolean genero) throws NombreVacioException, NombreInvalidoException, FechaFormatoException {
		super(fechaNacimiento,nombre);
		this.genero=genero;
	}


	/**
	 * Funci�n que devuelve el tipo de raza del animal.
	 * @return tipo de raza del objeto.
	 */
	public TipoRaza getRaza() {
		return raza;
	}

	/**
	 * Funci�n que establece una raza en el objeto.
	 * @param raza Un tipo de raza.
	 */
	public void setRaza(TipoRaza raza) {
		this.raza = raza;
	}

	/**
	 * Funci�n que devuelve la descripci�n de los cuidados del animal.
	 * @return tipo de orden del objeto
	 */
	public String getCuidados() {
		return cuidados;
	}

	/**
	 * Funci�n que establece un cuidado.
	 * @param cuidados Un cuidado.
	 */
	public void setCuidados(String cuidados) {
		this.cuidados = cuidados;
	}

	/**
	 * Funci�n que devuelve motivo del alta.
	 * @return tipo de motivo de alta.
	 */
	public MotivoAlta getMotivoAlta() {
		return motivoAlta;
	}

	/**
	 * Funci�n que establece un motivo de alta en el objeto.
	 * @param motivoAlta Un motivo de alta.
	 * @throws MotivoVacioException Excepci�n que se lanza cuando no se selecciona ning�n motivo de alta.
	 */
	public void setMotivoAlta(MotivoAlta motivoAlta) throws MotivoVacioException{
		if(motivoAlta == MotivoAlta.___) {
			throw new MotivoVacioException ("Error. El motivo de alta no puede estar vac�o");
		}else {
			this.motivoAlta = motivoAlta;
		}
		
	}

	/**
	 * Funci�n que devuelve el motivo de la baja del animal.
	 * @return tipo de baja del animal.
	 */
	public MotivoBaja getMotivoBaja() {
		return motivoBaja;
	}

	/**
	 * Funci�n que establece un motivo de baja en el objeto.
	 * @param motivoBaja Un motivo de baja.
	 * @throws MotivoVacioException Excepci�n que se lanza cuando no se selecciona ning�n motivo de baja.
	 */
	public void setMotivoBaja(MotivoBaja motivoBaja) throws MotivoVacioException{
		
		if(motivoBaja == MotivoBaja.___) {
			throw new MotivoVacioException ("Error. El motivo de baja no puede estar vac�o.");
		}else {
			this.motivoBaja = motivoBaja;
		}
		
	}

	/**
	 * Funci�n que devuelve la fecha de alta del animal
	 * @return la fecha de alta del animal
	 */
	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	/**
	 * Funci�n que establece una nueva fecha de alta en el objeto.
	 * @param fechaAlta Nueva fecha de alta.
	 */
	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	/**
	 * Funci�n que devuelve la fecha de baja del animal.
	 * @return Fecha de baja del animal.
	 */
	public LocalDate getFechaBaja() {
		return fechaBaja;
	}

	/**
	 * Funci�n que establece una nueva fecha de baja en el objeto.
	 * @param fechaBaja Nueva fecha de baja.
	 */
	public void setFechaBaja(LocalDate fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	/**
	 * Funci�n que devuelve la dieta del animal
	 * @return Dieta del animal.
	 */
	public Dieta getDieta() {
		return dieta;
	}

	/**
	 * Funci�n que establece una nueva dieta en el objeto.
	 * @param dieta Nueva dieta del animal.
	 */
	public void setDieta(Dieta dieta) {
		this.dieta = dieta;
	}
	
	
	
	
	
}
