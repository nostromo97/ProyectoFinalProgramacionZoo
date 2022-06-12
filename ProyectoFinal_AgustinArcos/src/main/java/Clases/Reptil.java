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
 * @author Agust�n Arcos
 *
 */
public class Reptil extends Animal {
	/**
	 * Variable de tipo boolean que indica el tipo de piel del reptil, escamas o
	 * caparaza�n, siendo los valores true o false.
	 */
	private boolean tipoPiel;

	/**
	 * Constructor de Reptil.
	 * 
	 * @param id              Variable num�rica de tipo short que contiene el id del
	 *                        animal.
	 * @param fechaNacimiento Variable de tipo LocalDate que contiene la fecha de
	 *                        nacimiento del animal.
	 * @param nombre          Cadena de caracteres que contiene el nombre del
	 *                        animal.
	 * @param raza            Proveniente del Enum TipoRaza que contiene el tipo de
	 *                        raza del animal.
	 * @param cuidados        Cadena de caracteres que contiene una descripci�n del
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
	 * @param dieta           De tipo Dieta, contiene ArrayList cada d�a de la
	 *                        semana con los alimentos que come al d�a el animal.
	 * @param tipoPiel        Variable de tipo boolean que indica el tipo de piel
	 *                        del reptil, escamas o caparaza�n, siendo los valores
	 *                        true o false.
	 * @throws NombreVacioException    Excepci�n que se lanza cuando el nombre est�
	 *                                 vac�o.
	 * @throws NombreInvalidoException Excepci�n que se lanza cuando el nombre no es
	 *                                 v�lido.
	 * @throws IdInvalidoException     Excepci�n quqe se lanza cuando la id no es
	 *                                 v�lida.
	 * @throws IdVacioException        Excepci�n que se lanza cuando el id est�
	 *                                 vac�o.
	 * @throws FechaFormatoException   Excepci�n que se lanza cuando la fecha se
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
	 * @param cuidados        Cadena de caracteres que contiene una descripci�n del
	 *                        cuidado necesario para el animal, en el caso de que lo
	 *                        necesite.
	 * @param tipoPiel        Variable de tipo boolean que indica el tipo de piel
	 *                        del reptil, escamas o caparaza�n, siendo los valores
	 *                        true o false.
	 * @throws NombreVacioException       Excepci�n que se lanza cuando el nombre
	 *                                    est� vac�o.
	 * @throws NombreInvalidoException    Excepci�n que se lanza cuando el nombre no
	 *                                    es v�lido.
	 * @throws IdInvalidoException        Excepci�n quqe se lanza cuando la id no es
	 *                                    v�lida.
	 * @throws IdVacioException           Excepci�n que se lanza cuando el id est�
	 *                                    vac�o.
	 * @throws FechaFormatoException      Excepci�n que se lanza cuando la fecha se
	 *                                    introduce en un formato incorrecto.
	 * @throws SQLException               Excepci�n que se lanza cuando hay errores
	 *                                    relacionados con la base de datos.
	 * @throws MotivoVacioException       Excepci�n que se lanza cuando no se
	 *                                    selecciona ning�n motivo.
	 * @throws DescripcionVaciaExceptioon Excepci�n que se lanza cuando no se
	 *                                    introduce una descripci�n en los cuidados
	 *                                    del animal.
	 * @throws CampoVacioException        Excepci�n que se lanza cuando hay un campo
	 *                                    vac�o.
	 * @throws GeneroVacioException       Excepci�n que se lanza cuando no se
	 *                                    selecciona ning�n g�nero.
	 * @throws DescripcionVaciaException  Excepci�n que se lanza cuando no se
	 *                                    introduce ninguna descripci�n en los
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
	 * @param id              Variable num�rica de tipo short que contiene el id del
	 *                        animal.
	 * @param nombre          Cadena de caracteres que contiene el nombre del
	 *                        animal.
	 * @param fechaNacimiento Variable de tipo LocalDate que contiene la fecha de
	 *                        nacimiento del animal.
	 * @param motivoBaja      Proviene del Enum MotivoBaja que contiene los motivos
	 *                        de baja del animal.
	 * @param fechaBaja       De tipo LocalDate, contiene la fecha de baja del
	 *                        animal en el centro.
	 * @param cuidados        Cadena de caracteres que contiene una descripci�n del
	 *                        cuidado necesario para el animal, en el caso de que lo
	 *                        necesite.
	 * @param tipoPiel        Variable de tipo boolean que indica el tipo de piel
	 *                        del reptil, escamas o caparaza�n, siendo los valores
	 *                        true o false.
	 * @param cuidados        Cadena de caracteres que contiene una descripci�n del
	 *                        cuidado necesario para el animal, en el caso de que lo
	 *                        necesite.
	 * @throws NombreVacioException    Excepci�n que se lanza cuando el nombre est�
	 *                                 vac�o.
	 * @throws NombreInvalidoException Excepci�n que se lanza cuando el nombre no es
	 *                                 v�lido.
	 * @throws FechaFormatoException   Excepci�n que se lanza cuando la fecha se
	 *                                 introduce en un formato incorrecto.
	 * @throws SQLException            Excepci�n que se lanza cuando hay errores
	 *                                 relacionados con la base de datos.
	 * @throws MotivoVacioException    Excepci�n que se lanza cuando no se
	 *                                 selecciona ning�n motivo.
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
	 * @param id       Variable num�rica de tipo short que contiene el id del
	 *                 animal.
	 * @param nombre   Cadena de caracteres que contiene el nombre del animal.
	 * @param raza     Proveniente del Enum TipoRaza que contiene el tipo de raza
	 *                 del animal.
	 * @param tipoPiel Variable de tipo boolean que indica el tipo de piel del
	 *                 reptil, escamas o caparaza�n, siendo los valores true o
	 *                 false.
	 * @throws NombreVacioException    Excepci�n que se lanza cuando el nombre est�
	 *                                 vac�o.
	 * @throws NombreInvalidoException Excepci�n que se lanza cuando el nombre no es
	 *                                 v�lido.
	 */
	public Reptil(short id, String nombre, TipoRaza raza, boolean tipoPiel)
			throws NombreVacioException, NombreInvalidoException {
		super(id, nombre, raza);
		this.tipoPiel = tipoPiel;
	}

	/**
	 * Funci�n que devuelve el tipo de piel del reptil.
	 * 
	 * @return Tipo de piel del reptil.
	 */
	public boolean getTipoPiel() {
		return tipoPiel;
	}

	/**
	 * Funci�n que establece un tipo de piel en el objeto.
	 * 
	 * @param tipoPiel Tipo de piel.
	 */
	public void setTipoPiel(boolean tipoPiel) {
		this.tipoPiel = tipoPiel;
	}

	/**
	 * Funci�n que devuelve una cadena de caracteres con todos los atributos del
	 * objeto de la Clase.
	 */

	@Override
	public String toString() {
		return super.toString() + "Tipo de Piel: " + (tipoPiel == true ? "Escamas" : "Caparaz�n");
	}

}
