package Clases;

import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import Enums.MotivoAlta;
import Enums.MotivoBaja;
import Enums.TipoAmbiente;
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

public class Anfibio extends Animal{
	
	private TipoOrden tipoOrden;
	private boolean tipoAmbiente;
	
	public Anfibio(short id,String nombre, LocalDate fechaNacimiento,  TipoRaza raza, String cuidados,
			MotivoAlta motivoAlta, MotivoBaja motivoBaja, LocalDate fechaAlta, LocalDate fechaBaja, Dieta dieta,
			TipoOrden tipoOrden, boolean tipoAmbiente) throws NombreVacioException, NombreInvalidoException, IdInvalidoException, IdVacioException, FechaFormatoException, MotivoVacioException, TipoOrdenVacioException, TipoAmbienteVacioException {
		super(id, fechaNacimiento, nombre, raza, cuidados, motivoAlta, motivoBaja, fechaAlta, fechaBaja, dieta);
		this.setTipoOrden(tipoOrden);
		this.setTipoAmbiente(tipoAmbiente);
	}	
	//ALTA anfibio
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
	
	//BAJA anfibio
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

	
		
	public TipoOrden getTipoOrden() {
		return tipoOrden;
	}
	public void setTipoOrden(TipoOrden tipoOrden) throws TipoOrdenVacioException{		
		if(tipoOrden == TipoOrden.___) {
			throw new TipoOrdenVacioException ("Error. El tipo orden no puede estar vacío");
		}else {
			this.tipoOrden = tipoOrden;
		}
	}
	public boolean getTipoAmbiente() {
		return tipoAmbiente;
	}
	public void setTipoAmbiente(boolean tipoAmbiente) {
		this.tipoAmbiente = tipoAmbiente;
	}
}
