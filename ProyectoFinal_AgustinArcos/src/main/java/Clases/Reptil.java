package Clases;

import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import Enums.MotivoAlta;
import Enums.MotivoBaja;
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
import Utils.UtilsDB;

/**
 * Clase que contiene un objeto de tipo Reptil que extiende de la clase Animal.
 * 
 * @author Agustín Arcos
 *
 */
public class Reptil extends Animal {
	/**
	 * Variable de tipo boolean que indica el tipo de piel del reptil, escamas o
	 * caparazaón, siendo los valores true o false.
	 */
	private boolean tipoPiel;

	/**
	 * Constructor de Reptil.
	 * 
	 * @param id              Variable numérica de tipo short que contiene el id del
	 *                        animal.
	 * @param fechaNacimiento Variable de tipo LocalDate que contiene la fecha de
	 *                        nacimiento del animal.
	 * @param nombre          Cadena de caracteres que contiene el nombre del
	 *                        animal.
	 * @param raza            Proveniente del Enum TipoRaza que contiene el tipo de
	 *                        raza del animal.
	 * @param cuidados        Cadena de caracteres que contiene una descripción del
	 *                        cuidado necesario para el animal, en el caso de que lo
	 *                        necesite.
	 * @param motivoAlta      Proviene del Enum MotivoAlta que contiene los motivos
	 *                        de alta del animal.
	 * @param motivoBaja      Proviene del Enum MotivoBaja que contiene los motivos
	 *                        de baja del animal.
	 * @param fechaAlta       De tipo LocalDate, contiene la fecha de alta del
	 *                        animal en el centro.
	 * @param fechaBaja       De tipo LocalDate, contiene la fecha de baja del
	 *                        animal en el centro.
	 * @param dieta           De tipo Dieta, contiene ArrayList cada día de la
	 *                        semana con los alimentos que come al día el animal.
	 * @param tipoPiel        Variable de tipo boolean que indica el tipo de piel
	 *                        del reptil, escamas o caparazaón, siendo los valores
	 *                        true o false.
	 * @throws NombreVacioException    Excepción que se lanza cuando el nombre está
	 *                                 vacío.
	 * @throws NombreInvalidoException Excepción que se lanza cuando el nombre no es
	 *                                 válido.
	 * @throws IdInvalidoException     Excepción quqe se lanza cuando la id no es
	 *                                 válida.
	 * @throws IdVacioException        Excepción que se lanza cuando el id está
	 *                                 vacío.
	 * @throws FechaFormatoException   Excepción que se lanza cuando la fecha se
	 *                                 introduce en un formato incorrecto.
	 */
	public Reptil(short id, LocalDate fechaNacimiento, String nombre, TipoRaza raza, String cuidados,
			MotivoAlta motivoAlta, MotivoBaja motivoBaja, LocalDate fechaAlta, LocalDate fechaBaja, Dieta dieta,
			boolean tipoPiel) throws NombreVacioException, NombreInvalidoException, IdInvalidoException,
			IdVacioException, FechaFormatoException {
		super(id, fechaNacimiento, nombre, raza, cuidados, motivoAlta, motivoBaja, fechaAlta, fechaBaja, dieta);
		this.tipoPiel = tipoPiel;
	}

	/**
	 * Constructor de la clase Reptil que extiende de Animal, utilizado para dar de
	 * alta a un Reptil.
	 * 
	 * @param nombre          Cadena de caracteres que contiene el nombre del
	 *                        animal.
	 * @param fechaNacimiento Variable de tipo LocalDate que contiene la fecha de
	 *                        nacimiento del animal.
	 * @param motivoAlta      Proviene del Enum MotivoAlta que contiene los motivos
	 *                        de alta del animal.
	 * @param fechaAlta       De tipo LocalDate, contiene la fecha de alta del
	 *                        animal en el centro.
	 * @param cuidados        Cadena de caracteres que contiene una descripción del
	 *                        cuidado necesario para el animal, en el caso de que lo
	 *                        necesite.
	 * @param tipoPiel        Variable de tipo boolean que indica el tipo de piel
	 *                        del reptil, escamas o caparazaón, siendo los valores
	 *                        true o false.
	 * @throws NombreVacioException       Excepción que se lanza cuando el nombre
	 *                                    está vacío.
	 * @throws NombreInvalidoException    Excepción que se lanza cuando el nombre no
	 *                                    es válido.
	 * @throws IdInvalidoException        Excepción quqe se lanza cuando la id no es
	 *                                    válida.
	 * @throws IdVacioException           Excepción que se lanza cuando el id está
	 *                                    vacío.
	 * @throws FechaFormatoException      Excepción que se lanza cuando la fecha se
	 *                                    introduce en un formato incorrecto.
	 * @throws SQLException               Excepción que se lanza cuando hay errores
	 *                                    relacionados con la base de datos.
	 * @throws MotivoVacioException       Excepción que se lanza cuando no se
	 *                                    selecciona ningún motivo.
	 * @throws DescripcionVaciaExceptioon Excepción que se lanza cuando no se
	 *                                    introduce una descripción en los cuidados
	 *                                    del animal.
	 * @throws CampoVacioException        Excepción que se lanza cuando hay un campo
	 *                                    vacío.
	 * @throws GeneroVacioException       Excepción que se lanza cuando no se
	 *                                    selecciona ningún género.
	 * @throws DescripcionVaciaException  Excepción que se lanza cuando no se
	 *                                    introduce ninguna descripción en los
	 *                                    tratados del animal.
	 */
	public Reptil(String nombre, LocalDate fechaNacimiento, MotivoAlta motivoAlta, LocalDate fechaAlta,
			boolean tipoPiel, String cuidados) throws NombreVacioException, NombreInvalidoException,
			FechaFormatoException, SQLException, MotivoVacioException, DescripcionVaciaException {
		super(nombre, fechaNacimiento, motivoAlta, fechaAlta, cuidados);

		Statement query = UtilsDB.conectarBD();

		if (query.executeUpdate("insert into altaReptil values(null,'" + nombre + "','" + fechaNacimiento + "','"
				+ motivoAlta + "','" + fechaAlta + "'," + tipoPiel + ",'" + cuidados + "')") > 0)

		{
			this.tipoPiel = tipoPiel;
		} else {
			throw new SQLException("No se ha podido insertar el usuario");
		}
		UtilsDB.desconectarBD();

	}

	/**
	 * Constructor de la clase Reptil que extiende de Animal, utilizado para dar de
	 * baja a un Reptil.
	 * 
	 * @param id              Variable numérica de tipo short que contiene el id del
	 *                        animal.
	 * @param nombre          Cadena de caracteres que contiene el nombre del
	 *                        animal.
	 * @param fechaNacimiento Variable de tipo LocalDate que contiene la fecha de
	 *                        nacimiento del animal.
	 * @param motivoBaja      Proviene del Enum MotivoBaja que contiene los motivos
	 *                        de baja del animal.
	 * @param fechaBaja       De tipo LocalDate, contiene la fecha de baja del
	 *                        animal en el centro.
	 * @param cuidados        Cadena de caracteres que contiene una descripción del
	 *                        cuidado necesario para el animal, en el caso de que lo
	 *                        necesite.
	 * @param tipoPiel        Variable de tipo boolean que indica el tipo de piel
	 *                        del reptil, escamas o caparazaón, siendo los valores
	 *                        true o false.
	 * @param cuidados        Cadena de caracteres que contiene una descripción del
	 *                        cuidado necesario para el animal, en el caso de que lo
	 *                        necesite.
	 * @throws NombreVacioException    Excepción que se lanza cuando el nombre está
	 *                                 vacío.
	 * @throws NombreInvalidoException Excepción que se lanza cuando el nombre no es
	 *                                 válido.
	 * @throws FechaFormatoException   Excepción que se lanza cuando la fecha se
	 *                                 introduce en un formato incorrecto.
	 * @throws SQLException            Excepción que se lanza cuando hay errores
	 *                                 relacionados con la base de datos.
	 * @throws MotivoVacioException    Excepción que se lanza cuando no se
	 *                                 selecciona ningún motivo.
	 * 
	 */
	public Reptil(short id, String nombre, LocalDate fechaNacimiento, MotivoBaja motivoBaja, LocalDate fechaBaja,
			boolean tipoPiel, String cuidados) throws NombreVacioException, NombreInvalidoException,
			FechaFormatoException, SQLException, MotivoVacioException {
		super(id, nombre, fechaNacimiento, motivoBaja, fechaBaja, cuidados);
		Scanner sc = new Scanner(System.in);
		Statement query = UtilsDB.conectarBD();

		if (query.executeUpdate("insert into bajaReptil values(null,'" + nombre + "','" + fechaNacimiento + "','"
				+ motivoBaja + "','" + fechaBaja + "'," + tipoPiel + ",'" + cuidados + "')") > 0) {
			this.tipoPiel = tipoPiel;
			query.executeUpdate("delete from altaReptil where id =" + id);
		} else {
			throw new SQLException("No se ha podido insertar el reptil.");
		}
		UtilsDB.desconectarBD();
	}

	/**
	 * Constructor de la clase Reptil que extiende de Animal.
	 * 
	 * @param id       Variable numérica de tipo short que contiene el id del
	 *                 animal.
	 * @param nombre   Cadena de caracteres que contiene el nombre del animal.
	 * @param raza     Proveniente del Enum TipoRaza que contiene el tipo de raza
	 *                 del animal.
	 * @param tipoPiel Variable de tipo boolean que indica el tipo de piel del
	 *                 reptil, escamas o caparazaón, siendo los valores true o
	 *                 false.
	 * @throws NombreVacioException    Excepción que se lanza cuando el nombre está
	 *                                 vacío.
	 * @throws NombreInvalidoException Excepción que se lanza cuando el nombre no es
	 *                                 válido.
	 */
	public Reptil(short id, String nombre, TipoRaza raza, boolean tipoPiel)
			throws NombreVacioException, NombreInvalidoException {
		super(id, nombre, raza);
		this.tipoPiel = tipoPiel;
	}

	/**
	 * Función que devuelve el tipo de piel del reptil.
	 * 
	 * @return Tipo de piel del reptil.
	 */
	public boolean getTipoPiel() {
		return tipoPiel;
	}

	/**
	 * Función que establece un tipo de piel en el objeto.
	 * 
	 * @param tipoPiel Tipo de piel.
	 */
	public void setTipoPiel(boolean tipoPiel) {
		this.tipoPiel = tipoPiel;
	}

	/**
	 * Función que devuelve una cadena de caracteres con todos los atributos del
	 * objeto de la Clase.
	 */

	@Override
	public String toString() {
		return super.toString() + "Tipo de Piel: " + (tipoPiel == true ? "Escamas" : "Caparazón");
	}

}
