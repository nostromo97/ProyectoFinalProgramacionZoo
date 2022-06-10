package Clases;

import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import Enums.MotivoAlta;
import Enums.MotivoBaja;
import Enums.TipoAmbiente;
import Enums.TipoRaza;
import Excepciones.CampoVacioException;
import Excepciones.DescripcionVaciaException;
import Excepciones.FechaFormatoException;
import Excepciones.GeneroVacioException;
import Excepciones.IdInvalidoException;
import Excepciones.IdVacioException;
import Excepciones.MotivoVacioException;
import Excepciones.NombreInvalidoException;
import Excepciones.NombreVacioException;
import Excepciones.TipoAmbienteVacioException;
import Excepciones.TipoOrdenVacioException;
import Utils.UtilsDB;
/**
 * Clase que contiene un objeto de tipo Primate que extiende de la clase Animal.
 * @author Agustín Arcos
 *
 */
public class Primate extends Animal{
	/**
	 * Variable de tipo boolean que indica el género del primate, masculino o femenino como los valores true o false.
	 */
	private boolean genero;
	/**
	 * 	Constructor de la clase Primate que extiende de la clase Animal.
	 * 
	 * @param id Variable numérica de tipo short que contiene el id del animal.                         
	 * @param fechaNacimiento Variable de tipo LocalDate que contiene la fecha de nacimiento del animal.
	 * @param nombre Cadena de caracteres que contiene el nombre del animal.
	 * @param raza Proveniente del Enum TipoRaza que contiene el tipo de raza del animal.
	 * @param cuidados Cadena de caracteres que contiene una descripción del cuidado 
	 * 				   necesario para el animal, en el caso de que lo necesite.
	 * @param motivoAlta Proviene del Enum MotivoAlta que contiene los motivos de alta del animal.
	 * @param motivoBaja Proviene del Enum MotivoBaja que contiene los motivos de baja del animal.
	 * @param fechaAlta De tipo LocalDate, contiene la fecha de alta del animal en el centro.
	 * @param fechaBaja De tipo LocalDate, contiene la fecha de baja del animal en el centro.
	 * @param dieta De tipo Dieta, contiene ArrayList cada día de la semana con los alimentos que come al día el animal.
	 * @param genero Variable de tipo boolean que indica el género del primate, masculino o femenino como los valores true o false.
	 * @throws NombreVacioException Excepción que se lanza cuando el nombre está vacío. 
	 * @throws NombreInvalidoException Excepción que se lanza cuando el nombre no es válido.
	 * @throws IdInvalidoException Excepción quqe se lanza cuando la id no es válida.
	 * @throws IdVacioException Excepción que se lanza cuando el id está vacío.
	 * @throws FechaFormatoException Excepción que se lanza cuando la fecha se introduce en un formato incorrecto.
	 */
	public Primate(short id, LocalDate fechaNacimiento, String nombre, TipoRaza raza, String cuidados,
			MotivoAlta motivoAlta, MotivoBaja motivoBaja, LocalDate fechaAlta, LocalDate fechaBaja, Dieta dieta,
			boolean genero) throws NombreVacioException, NombreInvalidoException, IdInvalidoException, IdVacioException, FechaFormatoException,
			CampoVacioException,MotivoVacioException {
		super(id, fechaNacimiento, nombre, raza, cuidados, motivoAlta, motivoBaja, fechaAlta, fechaBaja, dieta);
		this.genero = genero;
	}

	
	/**
	 * 	Constructor de la clase Primate que extiende de Animal, utilizado para dar de alta a un Primate.
	 * Hace conexión con la base de datos e inserta un primate.
	 * 
	 * @param nombre Cadena de caracteres que contiene el nombre del animal.                         
	 * @param fechaNacimiento Variable de tipo LocalDate que contiene la fecha de nacimiento del animal.
	 * @param motivoAlta Proviene del Enum MotivoAlta que contiene los motivos de alta del animal.
	 * @param fechaAlta De tipo LocalDate, contiene la fecha de alta del animal en el centro.
	 * @param cuidados Cadena de caracteres que contiene una descripción del cuidado 
	 * 				   necesario para el animal, en el caso de que lo necesite.
	 * @param genero Variable de tipo boolean que indica el género del primate, masculino o femenino como los valores true o false.                  
	 * @throws NombreVacioException Excepción que se lanza cuando el nombre está vacío. 
	 * @throws NombreInvalidoException Excepción que se lanza cuando el nombre no es válido.
	 * @throws IdInvalidoException Excepción quqe se lanza cuando la id no es válida.
	 * @throws IdVacioException Excepción que se lanza cuando el id está vacío.
	 * @throws FechaFormatoException Excepción que se lanza cuando la fecha se introduce en un formato incorrecto.
	 * @throws SQLException Excepción que se lanza cuando hay errores relacionados con la base de datos.
	 * @throws MotivoVacioException Excepción que se lanza cuando no se selecciona ningún motivo.
	 * @throws DescripcionVaciaExceptioon Excepción que se lanza cuando no se introduce una descripción en los cuidados del animal.
	 * @throws CampoVacioException Excepción que se lanza cuando hay un campo vacío.
	 * @throws GeneroVacioException Excepción que se lanza cuando no se selecciona ningún género.
	 * @throws DescripcionVaciaException Excepción que se lanza cuando no se introduce ninguna descripción en los tratados del animal.
	 */
	public Primate (String nombre, LocalDate fechaNacimiento, MotivoAlta motivoAlta, LocalDate fechaAlta, boolean genero,
			String cuidados) throws NombreVacioException, NombreInvalidoException, FechaFormatoException, SQLException,CampoVacioException,MotivoVacioException, GeneroVacioException, DescripcionVaciaException {
		super(nombre, fechaNacimiento, motivoAlta, fechaAlta, cuidados);
		Scanner sc = new Scanner(System.in);
		Statement query = UtilsDB.conectarBD();

		if(query.executeUpdate("insert into altaPrimate values(null,'"+nombre+"','"+fechaNacimiento+"','"+motivoAlta+"','"+fechaAlta+"',"+genero+",'"+cuidados+"')")>0)
		{
			this.genero = genero;
		} else {
			throw new SQLException("No se ha podido insertar el primate.");
		}
		UtilsDB.desconectarBD();		
	}

	/**
	 * 	Constructor de la clase Primate que extiende de Animal, utilizado para dar de baja a un Primate.
	 * 
	 * @param nombre Cadena de caracteres que contiene el nombre del animal.                         
	 * @param fechaNacimiento Variable de tipo LocalDate que contiene la fecha de nacimiento del animal.
	 * @param motivoBaja Proviene del Enum MotivoBaja que contiene los motivos de baja del animal.
	 * @param fechaBaja De tipo LocalDate, contiene la fecha de baja del animal en el centro.
	 * @param cuidados Cadena de caracteres que contiene una descripción del cuidado 
	 * 				   necesario para el animal, en el caso de que lo necesite. 
	 * @param genero Variable de tipo boolean que indica el género del primate, masculino o femenino como los valores true o false.                   
	 * @throws NombreVacioException Excepción que se lanza cuando el nombre está vacío. 
	 * @throws NombreInvalidoException Excepción que se lanza cuando el nombre no es válido.
	 * @throws IdInvalidoException Excepción quqe se lanza cuando la id no es válida.
	 * @throws IdVacioException Excepción que se lanza cuando el id está vacío.
	 * @throws FechaFormatoException Excepción que se lanza cuando la fecha se introduce en un formato incorrecto.
	 * @throws SQLException Excepción que se lanza cuando hay errores relacionados con la base de datos.
	 * @throws MotivoVacioException Excepción que se lanza cuando no se selecciona ningún motivo.
	 */
	public Primate (short id,String nombre, LocalDate fechaNacimiento, MotivoBaja motivoBaja, LocalDate fechaBaja, boolean genero,
			String cuidados) throws NombreVacioException, NombreInvalidoException, FechaFormatoException, SQLException, MotivoVacioException {
		super(id, nombre, fechaNacimiento, motivoBaja, fechaBaja, cuidados);
		Scanner sc = new Scanner(System.in);
		Statement query = UtilsDB.conectarBD();

		if(query.executeUpdate("insert into bajaPrimate values(null,'"+nombre+"','"+fechaNacimiento+"','"+motivoBaja+"','"+fechaBaja+"',"+genero+",'"+cuidados+"')")>0) //insert en baja
		{
			this.genero=genero;
			query.executeUpdate("delete from altaPrimate where id ="+id);
		} else {
			throw new SQLException("No se ha podido insertar el primate.");
		}
		UtilsDB.desconectarBD();		
	}

	/**
	 * Función que devuelve el género del primate.
	 * @return Género del primate.
	 */
	public boolean getGenero() {
		return genero;
	}

	/**
	 * Función que establece un género al primate.
	 * @param genero Género del primate.
	 */
	public void setGenero(boolean genero) {
		this.genero=genero;
		
	}
	
	
}
