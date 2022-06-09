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
import Excepciones.FechaFormatoException;
import Excepciones.IdInvalidoException;
import Excepciones.IdVacioException;
import Excepciones.MotivoVacioException;
import Excepciones.NombreInvalidoException;
import Excepciones.NombreVacioException;
import Utils.UtilsDB;

public class Primate extends Animal{

	private boolean genero;

	public Primate(short id, LocalDate fechaNacimiento, String nombre, TipoRaza raza, String cuidados,
			MotivoAlta motivoAlta, MotivoBaja motivoBaja, LocalDate fechaAlta, LocalDate fechaBaja, Dieta dieta,
			boolean genero) throws NombreVacioException, NombreInvalidoException, IdInvalidoException, IdVacioException, FechaFormatoException,
			CampoVacioException,MotivoVacioException {
		super(id, fechaNacimiento, nombre, raza, cuidados, motivoAlta, motivoBaja, fechaAlta, fechaBaja, dieta);
		this.genero = genero;
	}

	
	//alta PRIMATE
	public Primate (String nombre, LocalDate fechaNacimiento, MotivoAlta motivoAlta, LocalDate fechaAlta, boolean genero,
			String cuidados) throws NombreVacioException, NombreInvalidoException, FechaFormatoException, SQLException,CampoVacioException,MotivoVacioException {
		super(nombre, fechaNacimiento, motivoAlta, fechaAlta, cuidados);
		Scanner sc = new Scanner(System.in);
		Statement query = UtilsDB.conectarBD();

		//if (query.executeUpdate("insert into altaPrimate values(null,'" + nombre + "','" + fechaNacimiento + "','"
				//+ motivoAlta.toString() + "','" + fechaAlta + "'" + "'," + genero +"','" + cuidados + "'" +")") > 0)
		if(query.executeUpdate("insert into altaPrimate values(null,'"+nombre+"','"+fechaNacimiento+"','"+motivoAlta+"','"+fechaAlta+"',"+genero+",'"+cuidados+"')")>0)
		{
			this.genero = genero;
		} else {
			throw new SQLException("No se ha podido insertar el primate.");
		}
		UtilsDB.desconectarBD();		
	}

	//CONSTRUCTOR BAJA
	public Primate (short id,String nombre, LocalDate fechaNacimiento, MotivoBaja motivoBaja, LocalDate fechaBaja, boolean genero,
			String cuidados) throws NombreVacioException, NombreInvalidoException, FechaFormatoException, SQLException, MotivoVacioException {
		super(id, nombre, fechaNacimiento, motivoBaja, fechaBaja, cuidados);
		Scanner sc = new Scanner(System.in);
		Statement query = UtilsDB.conectarBD();

		//if (query.executeUpdate("insert into altaPrimate values(null,'" + nombre + "','" + fechaNacimiento + "','"
				//+ motivoAlta.toString() + "','" + fechaAlta + "'" + "'," + genero +"','" + cuidados + "'" +")") > 0)
		if(query.executeUpdate("insert into bajaPrimate values(null,'"+nombre+"','"+fechaNacimiento+"','"+motivoBaja+"','"+fechaBaja+"',"+genero+",'"+cuidados+"')")>0) //insert en baja
		{
			this.genero=genero;
			query.executeUpdate("delete from altaPrimate where id ="+id);
		} else {
			throw new SQLException("No se ha podido insertar el primate.");
		}
		UtilsDB.desconectarBD();		
	}


	

	public boolean isGenero() {
		return genero;
	}





	public void setGenero(boolean genero) {
		this.genero = genero;
	}
	
	
}
