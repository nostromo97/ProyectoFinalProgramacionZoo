package Clases;

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
import Excepciones.NombreInvalidoException;
import Excepciones.NombreVacioException;

public class Anfibio extends Animal{

	private TipoOrden tipoOrden;
	private TipoAmbiente tipoAmbiente;
	
	public Anfibio(short id, LocalDate fechaNacimiento, String nombre, TipoRaza raza, Cuidados cuidados,
			MotivoAlta motivoAlta, MotivoBaja motivoBaja, LocalDate fechaAlta, LocalDate fechaBaja, Dieta dieta,
			TipoOrden tipoOrden, TipoAmbiente tipoAmbiente) throws NombreVacioException, NombreInvalidoException, IdInvalidoException, IdVacioException, FechaFormatoException {
		super(id, fechaNacimiento, nombre, raza, cuidados, motivoAlta, motivoBaja, fechaAlta, fechaBaja, dieta);
		this.tipoOrden = tipoOrden;
		this.tipoAmbiente = tipoAmbiente;
	}
	
	
	
	





	public Anfibio(short id, String nombre, LocalDate fechaNacimiento, Cuidados cuidados,
			MotivoAlta motivoAlta, LocalDate fechaAlta, Dieta dieta, TipoOrden tipoOrden, TipoAmbiente tipoAmbiente)
			throws NombreVacioException, NombreInvalidoException, IdInvalidoException, IdVacioException, FechaFormatoException {
		super(id, nombre, fechaNacimiento, cuidados, motivoAlta, fechaAlta, dieta);
		this.tipoAmbiente = tipoAmbiente;
		this.tipoOrden = tipoOrden;
	}









	public Anfibio(short id, String nombre, LocalDate fechaNacimiento, Cuidados cuidados,
			MotivoBaja motivoBaja, LocalDate fechaBaja, Dieta dieta,TipoOrden tipoOrden, TipoAmbiente tipoAmbiente)
			throws NombreVacioException, NombreInvalidoException, IdInvalidoException, IdVacioException, FechaFormatoException {
		super(id, nombre, fechaNacimiento, cuidados, motivoBaja, fechaBaja, dieta);
		this.tipoAmbiente = tipoAmbiente;
		this.tipoOrden = tipoOrden;
	}









	public TipoOrden getTipoOrden() {
		return tipoOrden;
	}
	public void setTipoOrden(TipoOrden tipoOrden) {
		this.tipoOrden = tipoOrden;
	}
	public TipoAmbiente getTipoAmbiente() {
		return tipoAmbiente;
	}
	public void setTipoAmbiente(TipoAmbiente tipoAmbiente) {
		this.tipoAmbiente = tipoAmbiente;
	}
	
	
	
}
