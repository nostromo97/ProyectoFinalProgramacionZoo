package Clases;

import java.time.LocalDate;
import java.util.ArrayList;

import Enums.MotivoAlta;
import Enums.MotivoBaja;
import Enums.TipoRaza;
import Excepciones.FechaFormatoException;
import Excepciones.IdInvalidoException;
import Excepciones.IdVacioException;
import Excepciones.MotivoVacioException;
import Excepciones.NombreInvalidoException;
import Excepciones.NombreVacioException;
import Superclases.EntidadConIdFechaYNombre;

public class Animal extends EntidadConIdFechaYNombre{

	private TipoRaza raza;
	//private Cuidados cuidados;
	private String cuidados;
	private MotivoAlta motivoAlta;
	private MotivoBaja motivoBaja;
	private LocalDate fechaAlta;
	private LocalDate fechaBaja;
	private Dieta dieta;
	private boolean genero;
	
	
	public Animal(short id, LocalDate fechaNacimiento, String nombre, TipoRaza raza, String cuidados,
			MotivoAlta motivoAlta, MotivoBaja motivoBaja, LocalDate fechaAlta, LocalDate fechaBaja, Dieta dieta) 
					throws NombreVacioException, NombreInvalidoException, IdInvalidoException, IdVacioException, FechaFormatoException {
		super(id, fechaNacimiento, nombre);
		this.raza = raza;
		this.cuidados = cuidados;
		this.motivoAlta = motivoAlta;
		this.motivoBaja = motivoBaja;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.dieta = dieta;
	}
	
	
	//ALTA animal
public Animal(String nombre,LocalDate fechaNacimiento,  MotivoAlta motivoAlta, LocalDate fechaAlta, String cuidados
		) throws NombreVacioException, NombreInvalidoException, FechaFormatoException,MotivoVacioException {
	super(fechaNacimiento, nombre);
	this.cuidados = cuidados;
	this.setMotivoAlta(motivoAlta);
	this.fechaAlta = fechaAlta;
}

//baja
public Animal(short id,String nombre,LocalDate fechaNacimiento,  MotivoBaja motivoBaja, LocalDate fechaBaja, String cuidados
		) throws NombreVacioException, NombreInvalidoException, FechaFormatoException,MotivoVacioException {
	super(id,fechaNacimiento, nombre);
	this.cuidados = cuidados;
	this.setMotivoBaja(motivoBaja);
	this.fechaBaja = fechaBaja;
}

	public Animal(String nombre, LocalDate fechaNacimiento, Cuidados cuidados, MotivoAlta motivoAlta, LocalDate fechaAlta, boolean genero) throws NombreVacioException, NombreInvalidoException, FechaFormatoException {
		super(fechaNacimiento,nombre);
		this.genero=genero;
	}



	public TipoRaza getRaza() {
		return raza;
	}


	public void setRaza(TipoRaza raza) {
		this.raza = raza;
	}


	public String getCuidados() {
		return cuidados;
	}


	public void setCuidados(String cuidados) {
		this.cuidados = cuidados;
	}


	public MotivoAlta getMotivoAlta() {
		return motivoAlta;
	}


	public void setMotivoAlta(MotivoAlta motivoAlta) throws MotivoVacioException{
		if(motivoAlta == MotivoAlta.___) {
			throw new MotivoVacioException ("Error. El motivo de alta no puede estar vac�o");
		}else {
			this.motivoAlta = motivoAlta;
		}
		
	}


	public MotivoBaja getMotivoBaja() {
		return motivoBaja;
	}


	public void setMotivoBaja(MotivoBaja motivoBaja) throws MotivoVacioException{
		
		if(motivoBaja == MotivoBaja.___) {
			throw new MotivoVacioException ("Error. El motivo de baja no puede estar vac�o.");
		}else {
			this.motivoBaja = motivoBaja;
		}
		
	}


	public LocalDate getFechaAlta() {
		return fechaAlta;
	}


	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}


	public LocalDate getFechaBaja() {
		return fechaBaja;
	}


	public void setFechaBaja(LocalDate fechaBaja) {
		this.fechaBaja = fechaBaja;
	}


	public Dieta getDieta() {
		return dieta;
	}


	public void setDieta(Dieta dieta) {
		this.dieta = dieta;
	}
	
	
	
	
	
}
