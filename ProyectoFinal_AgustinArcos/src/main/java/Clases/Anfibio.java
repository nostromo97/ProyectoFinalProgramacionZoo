package Clases;

import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import Enums.MotivoAlta;
import Enums.MotivoBaja;
import Enums.TipoAmbiente;
import Enums.TipoOrden;
import Enums.TipoRaza;
import Excepciones.FechaFormatoException;
import Excepciones.IdInvalidoException;
import Excepciones.IdVacioException;
import Excepciones.MotivoVacioException;
import Excepciones.NombreInvalidoException;
import Excepciones.NombreVacioException;
import Utils.UtilsDB;

public class Anfibio extends Animal{
	
	private TipoOrden tipoOrden;
	private boolean tipoAmbiente;
	
	public Anfibio(short id,String nombre, LocalDate fechaNacimiento,  TipoRaza raza, String cuidados,
			MotivoAlta motivoAlta, MotivoBaja motivoBaja, LocalDate fechaAlta, LocalDate fechaBaja, Dieta dieta,
			TipoOrden tipoOrden, boolean tipoAmbiente) throws NombreVacioException, NombreInvalidoException, IdInvalidoException, IdVacioException, FechaFormatoException, MotivoVacioException {
		super(id, fechaNacimiento, nombre, raza, cuidados, motivoAlta, motivoBaja, fechaAlta, fechaBaja, dieta);
		this.setTipoOrden(tipoOrden);
		this.tipoAmbiente = tipoAmbiente;
	}	
	
	public Anfibio (String nombre, LocalDate fechaNacimiento, MotivoAlta motivoAlta, LocalDate fechaAlta, TipoOrden tipoOrden,boolean tipoAmbiente,
			String cuidados) throws NombreVacioException, NombreInvalidoException, FechaFormatoException, SQLException, MotivoVacioException {
		super(nombre, fechaNacimiento, motivoAlta, fechaAlta, cuidados);
		
		Statement query = UtilsDB.conectarBD();

		if(query.executeUpdate("insert into altaAnfibio values(null,'"+nombre+"','"+fechaNacimiento+"','"+motivoAlta+"','"+fechaAlta+"','"+tipoOrden+"',"+tipoAmbiente+",'"+cuidados+"')")>0)
		{
			this.setTipoOrden(tipoOrden);
			this.tipoAmbiente = tipoAmbiente;
		} else {
			throw new SQLException("No se ha podido insertar el usuario");
		}
		UtilsDB.desconectarBD();
		
	}

	public TipoOrden getTipoOrden() {
		return tipoOrden;
	}
	public void setTipoOrden(TipoOrden tipoOrden) throws MotivoVacioException{		
		if(tipoOrden == TipoOrden.___) {
			throw new MotivoVacioException ("Error. El motivo de alta no puede estar vacío");
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
