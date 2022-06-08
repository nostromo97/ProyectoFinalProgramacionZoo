package Clases;

import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import Enums.MotivoAlta;
import Enums.MotivoBaja;
import Enums.TipoPiel;
import Enums.TipoRaza;
import Excepciones.FechaFormatoException;
import Excepciones.IdInvalidoException;
import Excepciones.IdVacioException;
import Excepciones.NombreInvalidoException;
import Excepciones.NombreVacioException;
import Utils.UtilsDB;

public class Reptil extends Animal{

	private boolean tipoPiel;

	public Reptil(short id, LocalDate fechaNacimiento, String nombre, TipoRaza raza, String cuidados,
			MotivoAlta motivoAlta, MotivoBaja motivoBaja, LocalDate fechaAlta, LocalDate fechaBaja, Dieta dieta,
			boolean tipoPiel) throws NombreVacioException, NombreInvalidoException, IdInvalidoException, IdVacioException, FechaFormatoException {
		super(id, fechaNacimiento, nombre, raza, cuidados, motivoAlta, motivoBaja, fechaAlta, fechaBaja, dieta);
		this.tipoPiel = tipoPiel;
	}

	public Reptil (String nombre, LocalDate fechaNacimiento, MotivoAlta motivoAlta, LocalDate fechaAlta, boolean tipoPiel,
			String cuidados) throws NombreVacioException, NombreInvalidoException, FechaFormatoException, SQLException {
		super(nombre, fechaNacimiento, motivoAlta, fechaAlta, cuidados);
		
		Statement query = UtilsDB.conectarBD();

		if(query.executeUpdate("insert into altaReptil values(null,'"+nombre+"','"+fechaNacimiento+"','"+motivoAlta+"','"+fechaAlta+"',"+tipoPiel+",'"+cuidados+"')")>0)

		{
			this.tipoPiel = tipoPiel;
		} else {
			throw new SQLException("No se ha podido insertar el usuario");
		}
		UtilsDB.desconectarBD();
		
		
		
		
	}	





	public boolean getTipoPiel() {
		return tipoPiel;
	}

	public void setTipoPiel(boolean tipoPiel) {
		this.tipoPiel = tipoPiel;
	}
	
	
	
	
	
}
