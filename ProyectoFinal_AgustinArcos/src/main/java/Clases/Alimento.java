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
 * Clase que contiene un alimento que extiende de la clase EntidadConIdFechaYNombre
 * @author Agust�n Arcos
 *
 */
public class Alimento extends EntidadConIdFechaYNombre{
	
	/**
	 * Variable interna de clase alimento que contiene un tipoAlimento
	 */
	private TipoAlimento tipoAlimento;
	/**
	 * Variable num�rica que contiene la cantidad de Kg del alimento
	 */
	private float cantidadAlimento;
	
	/**
	 * Constructor de la clase alimento.
	 * @param nombre Cadena de caracteres que contiene el nombre del alimento.
	 * @param tipoAlimento Enum que contiene el nombre del tipo de alimento.
	 * @param cantidadAlimento Cantidad de Kg del alimento.
	 * @throws NombreVacioException Excepci�n que se lanza cuando el nombre est� vac�o.
	 * @throws NombreInvalidoException Excepci�n que se lanza cuando el nombre no es v�lido.
	 * @throws SQLException Excepci�n que se lanza cuando hay fallos relacionados con la base de datos en SQL.
	 */
	public Alimento(String nombre, TipoAlimento tipoAlimento, float cantidadAlimento) throws NombreVacioException, NombreInvalidoException, SQLException {
		super(nombre);
		Scanner sc = new Scanner(System.in);
		Statement query = UtilsDB.conectarBD();
				
		if(query.executeUpdate("insert into alimento values(null,'"+nombre+"','"+tipoAlimento+"','"+cantidadAlimento+"')")>0)
		this.tipoAlimento = tipoAlimento;
		this.cantidadAlimento = cantidadAlimento;
		
		UtilsDB.desconectarBD();	
	}
	
	
	

	public TipoAlimento getTipoAlimento() {
		return tipoAlimento;
	}

	public void setTipoAlimento(TipoAlimento tipoAlimento) {
		this.tipoAlimento = tipoAlimento;
	}

	public float getCantidadAlimento() {
		return cantidadAlimento;
	}

	public void setCantidadAlimento(float cantidadAlimento) {
		this.cantidadAlimento = cantidadAlimento;
	}
	
	
	
	
}
