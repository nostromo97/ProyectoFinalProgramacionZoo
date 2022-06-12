package Clases;

import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import Enums.MotivoAlta;
import Enums.MotivoBaja;
import Enums.TipoOrden;
import Enums.TipoRaza;
import Excepciones.CampoVacioException;
import Excepciones.DescripcionVaciaException;
import Excepciones.FechaFormatoException;
import Excepciones.IdInvalidoException;
import Excepciones.IdVacioException;
import Excepciones.MotivoVacioException;
import Excepciones.NombreInvalidoException;
import Excepciones.NombreVacioException;
import Excepciones.TipoAmbienteVacioException;
import Excepciones.TipoOrdenVacioException;
import Utils.UtilsDB;
/**
 * Clase que contiene un Anfibio que extiende de la clase Animal
 * @author Agustín Arcos
 *
 */
public class Anfibio extends Animal{
	
	/**
	 * Variable interna de clase Anfibio que contiene un tipo de orden de anfibio.
	 */
	private TipoOrden tipoOrden;
	/**
	 * Variable interna de la clase Anfibio de tipo boolean que indica 0 cuando es ambiente
	 * de tipo acuático y 1 cuando es de tipo seco.
	 */
	private boolean tipoAmbiente;
	
	/**
	 * 	Constructor de la clase Anfibio que extiende de la clase Animal.
	 * 
	 * @param id Variable numérica de tipo short que contiene el id del animal.
	 * @param nombre Cadena de caracteres que contiene el nombre del animal.                         
	 * @param fechaNacimiento Variable de tipo LocalDate que contiene la fecha de nacimiento del animal.
	 * @param raza Proveniente del Enum TipoRaza que contiene el tipo de raza del animal.
	 * @param cuidados Cadena de caracteres que contiene una descripción del cuidado 
	 * 				   necesario para el animal, en el caso de que lo necesite.
	 * @param motivoAlta Proviene del Enum MotivoAlta que contiene los motivos de alta del animal.
	 * @param motivoBaja Proviene del Enum MotivoBaja que contiene los motivos de baja del animal.
	 * @param fechaAlta De tipo LocalDate, contiene la fecha de alta del animal en el centro.
	 * @param fechaBaja De tipo LocalDate, contiene la fecha de baja del animal en el centro.
	 * @param dieta De tipo Dieta, contiene ArrayList cada día de la semana con los alimentos que come al día el animal.
	 * @param tipoOrden De tipo TipoOrden, proviene del Enum TipoOrden que contiene los tipos de ordenes del animal.
	 * @param tipoAmbiente Variable de tipo boolean que contiene los 2 tipos de ambiente, acuático o seco, 
	 *                     indicado con true y false respectivamente.
	 * @throws NombreVacioException Excepción que se lanza cuando el nombre está vacío. 
	 * @throws NombreInvalidoException Excepción que se lanza cuando el nombre no es válido.
	 * @throws IdInvalidoException Excepción quqe se lanza cuando la id no es válida.
	 * @throws IdVacioException Excepción que se lanza cuando el id está vacío.
	 * @throws FechaFormatoException Excepción que se lanza cuando la fecha se introduce en un formato incorrecto.
	 * @throws MotivoVacioException Excepción que se lanza cuando no se selecciona ningún motivo.
	 * @throws TipoOrdenVacioException Excepción que se lanza cuando no se selecciona ningún tipo de orden.
	 * @throws TipoAmbienteVacioException Excepción que se lanza cuando no se selecciona ningún tipo de ambiente.
	 */
	public Anfibio(short id,String nombre, LocalDate fechaNacimiento,  TipoRaza raza, String cuidados,
			MotivoAlta motivoAlta, MotivoBaja motivoBaja, LocalDate fechaAlta, LocalDate fechaBaja, Dieta dieta,
			TipoOrden tipoOrden, boolean tipoAmbiente) throws NombreVacioException, NombreInvalidoException, IdInvalidoException, IdVacioException, FechaFormatoException, MotivoVacioException, TipoOrdenVacioException, TipoAmbienteVacioException {
		super(id, fechaNacimiento, nombre, raza, cuidados, motivoAlta, motivoBaja, fechaAlta, fechaBaja, dieta);
		this.setTipoOrden(tipoOrden);
		this.setTipoAmbiente(tipoAmbiente);
	}	
	/**
	 * 	Constructor de la clase Anfibio que extiende de Animal, utilizado para dar de alta a un anfibio.
	 * Hace conexión con la base de datos e inserta un anfibio.
	 * 
	 * @param nombre Cadena de caracteres que contiene el nombre del animal.                         
	 * @param fechaNacimiento Variable de tipo LocalDate que contiene la fecha de nacimiento del animal.
	 * @param motivoAlta Proviene del Enum MotivoAlta que contiene los motivos de alta del animal.
	 * @param fechaAlta De tipo LocalDate, contiene la fecha de alta del animal en el centro.
	 * @param tipoOrden De tipo TipoOrden, proviene del Enum TipoOrden que contiene los tipos de ordenes del animal.
	 * @param tipoAmbiente Variable de tipo boolean que contiene los 2 tipos de ambiente, acuático o seco, 
	 *                     indicado con true y false respectivamente.
	 * @param cuidados Cadena de caracteres que contiene una descripción del cuidado 
	 * 				   necesario para el animal, en el caso de que lo necesite.                    
	 * @throws NombreVacioException Excepción que se lanza cuando el nombre está vacío. 
	 * @throws NombreInvalidoException Excepción que se lanza cuando el nombre no es válido.
	 * @throws IdInvalidoException Excepción quqe se lanza cuando la id no es válida.
	 * @throws IdVacioException Excepción que se lanza cuando el id está vacío.
	 * @throws FechaFormatoException Excepción que se lanza cuando la fecha se introduce en un formato incorrecto.
	 * @throws SQLException Excepción que se lanza cuando hay errores relacionados con la base de datos.
	 * @throws MotivoVacioException Excepción que se lanza cuando no se selecciona ningún motivo.
	 * @throws TipoOrdenVacioException Excepción que se lanza cuando no se selecciona ningún tipo de orden.
	 * @throws TipoAmbienteVacioException Excepción que se lanza cuando no se selecciona ningún tipo de ambiente.
	 * @throws DescripcionVaciaExceptioon Excepción que se lanza cuando no se introduce una descripción en los cuidados del animal.
	 */
	public Anfibio (String nombre, LocalDate fechaNacimiento, MotivoAlta motivoAlta, LocalDate fechaAlta, TipoOrden tipoOrden,boolean tipoAmbiente,
			String cuidados) throws NombreVacioException, NombreInvalidoException, FechaFormatoException, SQLException, MotivoVacioException, CampoVacioException, TipoOrdenVacioException, TipoAmbienteVacioException, DescripcionVaciaException {
		super(nombre, fechaNacimiento, motivoAlta, fechaAlta, cuidados);
		
		Statement query = UtilsDB.conectarBD();

		if(query.executeUpdate("insert into altaAnfibio values(null,'"+nombre+"','"+fechaNacimiento+"','"+motivoAlta+"','"+fechaAlta+"','"+tipoOrden+"',"+tipoAmbiente+",'"+cuidados+"')")>0)
		{
			this.setTipoOrden(tipoOrden);
			this.setTipoAmbiente(tipoAmbiente);
		} else {
			throw new SQLException("No se ha podido insertar el anfibio");
		}
		UtilsDB.desconectarBD();
		
	}
	
	/**
	 * 	Constructor de la clase Anfibio que extiende de Animal, utilizado para dar de baja a un anfibio.
	 * @param nombre Cadena de caracteres que contiene el nombre del animal.                         
	 * @param fechaNacimiento Variable de tipo LocalDate que contiene la fecha de nacimiento del animal.
	 * @param motivoBaja Proviene del Enum MotivoBaja que contiene los motivos por el que se da de baja el animal.
	 * @param fechaBaja De tipo LocalDate, contiene la fecha de baja del animal en el centro.
	 * @param tipoOrden De tipo TipoOrden, proviene del Enum TipoOrden que contiene los tipos de ordenes del animal.
	 * @param tipoAmbiente Variable de tipo boolean que contiene los 2 tipos de ambiente, acuático o seco, 
	 *                     indicado con true y false respectivamente.
	 * @param cuidados Cadena de caracteres que contiene una descripción del cuidado 
	 * 				   necesario para el animal, en el caso de que lo necesite.                    
	 * @throws NombreVacioException Excepción que se lanza cuando el nombre está vacío. 
	 * @throws NombreInvalidoException Excepción que se lanza cuando el nombre no es válido.
	 * @throws IdInvalidoException Excepción quqe se lanza cuando la id no es válida.
	 * @throws IdVacioException Excepción que se lanza cuando el id está vacío.
	 * @throws FechaFormatoException Excepción que se lanza cuando la fecha se introduce en un formato incorrecto.
	 * @throws SQLException Excepción que se lanza cuando hay errores relacionados con la base de datos.
	 * @throws MotivoVacioException Excepción que se lanza cuando no se selecciona ningún motivo.
	 */
	public Anfibio (short id,String nombre, LocalDate fechaNacimiento, MotivoBaja motivoBaja, LocalDate fechaBaja, TipoOrden tipoOrden, boolean tipoAmbiente,
			String cuidados) throws NombreVacioException, NombreInvalidoException, FechaFormatoException, SQLException, MotivoVacioException{
		super(id, nombre, fechaNacimiento, motivoBaja, fechaBaja, cuidados);
		Scanner sc = new Scanner(System.in);
		Statement query = UtilsDB.conectarBD();

		if(query.executeUpdate("insert into bajaAnfibio values(null,'"+nombre+"','"+fechaNacimiento+"','"+motivoBaja+"','"+fechaBaja+"','"+tipoOrden+"',"+tipoAmbiente+",'"+cuidados+"')")>0) 
		{
			this.tipoOrden= tipoOrden;
			this.tipoAmbiente=tipoAmbiente;
			query.executeUpdate("delete from altaAnfibio where id ="+id);
		} else {
			throw new SQLException("No se ha podido insertar el anfibio.");
		}
		UtilsDB.desconectarBD();		
	}

	
	
	
	public Anfibio(short id, String nombre, TipoRaza raza, TipoOrden tipoOrden, boolean tipoAmbiente)
			throws NombreVacioException, NombreInvalidoException {
		super(id, nombre, raza);
		this.tipoOrden = tipoOrden;
		this.tipoAmbiente = tipoAmbiente;
	}
	/**
	 * Función que devuelve el tipo de orden
	 * @return tipo de orden del objeto
	 */
	public TipoOrden getTipoOrden() {
		return tipoOrden;
	}
	
	/**
	 * Función que establece un nuevo tipo de orden en el objeto.
	 * @param tipoOrden Nuevo valor del tipo de orden del anfibio.
	 * @throws TipoOrdenVacioException Excepción que se lanza cuando no se selecciona un tipo de orden.
	 */	
	public void setTipoOrden(TipoOrden tipoOrden) throws TipoOrdenVacioException{		
		if(tipoOrden == TipoOrden.___) {
			throw new TipoOrdenVacioException ("Error. El tipo orden no puede estar vacío");
		}else {
			this.tipoOrden = tipoOrden;
		}
	}
	
	/**
	 * Función que devuelve el tipo de ambiente.
	 * @return tipo de ambiente del objeto.
	 */	
	public boolean getTipoAmbiente() {
		return tipoAmbiente;
	}
	
	/**
	 * Función que establece un nuevo tipo de ambiente en el objeto.
	 * @param tipoAmbiente Nuevo valor del tipo de ambiente del anfibio.
	 */		
	public void setTipoAmbiente(boolean tipoAmbiente) {
		this.tipoAmbiente = tipoAmbiente;
	}
	@Override
	public String toString() {
		return super.toString() + "Tipo de Orden: " + tipoOrden + " Tipo de Ambiente: " + (tipoAmbiente==true?"Acuático":"Seco");
	}
	
	
}
