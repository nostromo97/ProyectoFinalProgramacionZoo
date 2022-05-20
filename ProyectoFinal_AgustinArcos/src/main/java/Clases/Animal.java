package Clases;

import java.time.LocalDate;
import java.util.ArrayList;

import Enums.MotivoAlta;
import Enums.MotivoBaja;
import Enums.TipoRaza;

public class Animal extends EntidadConIdFechaYNombre{

	private TipoRaza raza;
	private ArrayList <Cuidados> cuidados;
	private MotivoAlta motivoAlta;
	private MotivoBaja motivoBaja;
	private LocalDate fechaAlta;
	private LocalDate fechaBaja;
	private Dieta dieta;
	
	
	public Animal(int id, LocalDate fechaNacimiento, String nombre, TipoRaza raza, ArrayList<Cuidados> cuidados,
			MotivoAlta motivoAlta, MotivoBaja motivoBaja, LocalDate fechaAlta, LocalDate fechaBaja, Dieta dieta) {
		super(id, fechaNacimiento, nombre);
		this.raza = raza;
		this.cuidados = cuidados;
		this.motivoAlta = motivoAlta;
		this.motivoBaja = motivoBaja;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.dieta = dieta;
	}


	public TipoRaza getRaza() {
		return raza;
	}


	public void setRaza(TipoRaza raza) {
		this.raza = raza;
	}


	public ArrayList<Cuidados> getCuidados() {
		return cuidados;
	}


	public void setCuidados(ArrayList<Cuidados> cuidados) {
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
