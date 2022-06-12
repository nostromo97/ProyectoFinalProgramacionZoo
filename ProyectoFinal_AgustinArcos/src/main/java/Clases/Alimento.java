package Clases;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Enums.TipoAlimento;
import Excepciones.NombreInvalidoException;
import Excepciones.NombreVacioException;
import Superclases.EntidadConIdFechaYNombre;
import Utils.UtilsDB;

/**
 * Clase que contiene un alimento que extiende de la superclase
 * EntidadConIdFechaYNombre
 * 
 * @author Agustín Arcos
 *
 */
public class Alimento extends EntidadConIdFechaYNombre {

	/**
	 * Variable interna de clase alimento que contiene un tipoAlimento
	 */
	private TipoAlimento tipoAlimento;
	/**
	 * Variable numérica que contiene la cantidad de Kg del alimento
	 */
	private float cantidadAlimento;

	/**
	 * Constructor de la clase Alimento.
	 * 
	 * @param nombre           Cadena de caracteres que contiene el nombre del
	 *                         alimento.
	 * @param tipoAlimento     Enum que contiene el nombre del tipo de alimento.
	 * @param cantidadAlimento Cantidad de Kg del alimento.
	 * @throws NombreVacioException    Excepción que se lanza cuando el nombre está
	 *                                 vacío.
	 * @throws NombreInvalidoException Excepción que se lanza cuando el nombre no es
	 *                                 válido.
	 * @throws SQLException            Excepción que se lanza cuando hay fallos
	 *                                 relacionados con la base de datos en SQL.
	 */
	public Alimento(String nombre, TipoAlimento tipoAlimento, float cantidadAlimento)
			throws NombreVacioException, NombreInvalidoException, SQLException {
		super(nombre);
		Scanner sc = new Scanner(System.in);
		Statement query = UtilsDB.conectarBD();

		if (query.executeUpdate("insert into alimento values(null,'" + nombre + "','" + tipoAlimento + "','"
				+ cantidadAlimento + "')") > 0)
			this.tipoAlimento = tipoAlimento;
		this.cantidadAlimento = cantidadAlimento;

		UtilsDB.desconectarBD();
	}

	/**
	 * Función que devuelve el tipo de alimento
	 * 
	 * @return tipo de alimento del objeto
	 */

	public TipoAlimento getTipoAlimento() {
		return tipoAlimento;
	}

	/**
	 * Función que establece un nuevo tipo de alimento en el objeto
	 * 
	 * @param tipoAlimento Nuevo valor del tipo de alimento.
	 */
	public void setTipoAlimento(TipoAlimento tipoAlimento) {
		this.tipoAlimento = tipoAlimento;
	}

	/**
	 * Función que devuelve cantidad de alimento.
	 * 
	 * @return tipo de alimento del objeto
	 */
	public float getCantidadAlimento() {
		return cantidadAlimento;
	}

	/**
	 * Función que establece la cantidad de alimentos en el objeto.
	 * 
	 * @param cantidadAlimento Nuevo valor para la cantidad de alimento.
	 */
	public void setCantidadAlimento(float cantidadAlimento) {
		this.cantidadAlimento = cantidadAlimento;
	}

}
