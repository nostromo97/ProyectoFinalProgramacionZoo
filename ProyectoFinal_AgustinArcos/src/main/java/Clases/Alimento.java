package Clases;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Enums.TipoAlimento;
import Excepciones.NombreInvalidoException;
import Excepciones.NombreVacioException;
import Superclases.EntidadConIdFechaYNombre;
import Utils.UtilsDB;


public class Alimento extends EntidadConIdFechaYNombre{
	
	
	private TipoAlimento tipoAlimento;
	private float cantidadAlimento;
	
	
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
