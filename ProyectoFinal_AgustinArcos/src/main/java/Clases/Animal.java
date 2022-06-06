package Clases;

import java.time.LocalDate;
import java.util.ArrayList;

import Enums.MotivoAlta;
import Enums.MotivoBaja;
import Enums.TipoRaza;
import Excepciones.IdInvalidoException;
import Excepciones.IdVacioException;
import Excepciones.NombreInvalidoException;
import Excepciones.NombreVacioException;
import Superclases.EntidadConIdFechaYNombre;

public class Animal extends EntidadConIdFechaYNombre{

	private TipoRaza raza;
	private Cuidados cuidados;
	private MotivoAlta motivoAlta;
	private MotivoBaja motivoBaja;
	private LocalDate fechaAlta;
	private LocalDate fechaBaja;
	private Dieta dieta;
	
	
	public Animal(short id, LocalDate fechaNacimiento, String nombre, TipoRaza raza, Cuidados cuidados,
			MotivoAlta motivoAlta, MotivoBaja motivoBaja, LocalDate fechaAlta, LocalDate fechaBaja, Dieta dieta) 
					throws NombreVacioException, NombreInvalidoException, IdInvalidoException, IdVacioException {
		super(id, fechaNacimiento, nombre);
		this.raza = raza;
		this.cuidados = cuidados;
		this.motivoAlta = motivoAlta;
		this.motivoBaja = motivoBaja;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.dieta = dieta;
	}
	
	//alta de animal
	public Animal(short id, String nombre, LocalDate fechaNacimiento, Cuidados cuidados,
			MotivoAlta motivoAlta, LocalDate fechaAlta, Dieta dieta) 
					throws NombreVacioException, NombreInvalidoException, IdInvalidoException, IdVacioException {
		super(id, fechaNacimiento, nombre);
		this.cuidados = cuidados;
		this.motivoAlta = motivoAlta;
		this.fechaAlta = fechaAlta;
		this.dieta = dieta;
	}
	
	//BAJA de animal
		public Animal(short id, String nombre, LocalDate fechaNacimiento, Cuidados cuidados,
				MotivoBaja motivoBaja, LocalDate fechaBaja, Dieta dieta) 
						throws NombreVacioException, NombreInvalidoException, IdInvalidoException, IdVacioException {
			super(id, fechaNacimiento, nombre);
			this.cuidados = cuidados;
			this.dieta = dieta;
		}
		
		
		
		
	public TipoRaza getRaza() {
		return raza;
	}


	public void setRaza(TipoRaza raza) {
		this.raza = raza;
	}


	public Cuidados getCuidados() {
		return cuidados;
	}


	public void setCuidados(Cuidados cuidados) {
		this.cuidados = cuidados;
	}


	public MotivoAlta getMotivoAlta() {
		return motivoAlta;
	}


	public void setMotivoAlta(MotivoAlta motivoAlta) {
		this.motivoAlta = motivoAlta;
	}


	public MotivoBaja getMotivoBaja() {
		return motivoBaja;
	}


	public void setMotivoBaja(MotivoBaja motivoBaja) {
		this.motivoBaja = motivoBaja;
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
