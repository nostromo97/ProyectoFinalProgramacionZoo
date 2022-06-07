package Clases;

import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import Enums.MotivoAlta;
import Enums.MotivoBaja;
import Enums.TipoRaza;
import Excepciones.FechaFormatoException;
import Excepciones.IdInvalidoException;
import Excepciones.IdVacioException;
import Excepciones.NombreInvalidoException;
import Excepciones.NombreVacioException;
import Utils.UtilsDB;

public class Primate extends Animal{

	private boolean genero;

	public Primate(short id, LocalDate fechaNacimiento, String nombre, TipoRaza raza, String cuidados,
			MotivoAlta motivoAlta, MotivoBaja motivoBaja, LocalDate fechaAlta, LocalDate fechaBaja, Dieta dieta,
			boolean genero) throws NombreVacioException, NombreInvalidoException, IdInvalidoException, IdVacioException, FechaFormatoException {
		super(id, fechaNacimiento, nombre, raza, cuidados, motivoAlta, motivoBaja, fechaAlta, fechaBaja, dieta);
		this.genero = genero;
	}

	
	//alta PRIMATE
	public Primate (String nombre, LocalDate fechaNacimiento, MotivoAlta motivoAlta, LocalDate fechaAlta, boolean genero,
			String cuidados) throws NombreVacioException, NombreInvalidoException, FechaFormatoException, SQLException {
		super(nombre, fechaNacimiento, motivoAlta, fechaAlta, cuidados);
		Scanner sc = new Scanner(System.in);
		Statement query = UtilsDB.conectarBD();

		if (query.executeUpdate("insert into altaPrimate values(null,'" + nombre + "','" + fechaNacimiento + "','"
				+ motivoAlta.toString() + "','" + fechaAlta + "'" + "','" + genero + "'"+"','" + cuidados + "'" +")") > 0)

		{
			this.genero = genero;
		} else {
			throw new SQLException("No se ha podido insertar el usuario");
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
