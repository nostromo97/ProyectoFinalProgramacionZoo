package Clases;

import java.time.LocalDate;
import java.util.ArrayList;

import Enums.MotivoAlta;
import Enums.MotivoBaja;
import Enums.TipoPiel;
import Enums.TipoRaza;

public class Reptil extends Animal{

	private TipoPiel tipoPiel;

	public Reptil(String id, LocalDate fechaNacimiento, String nombre, TipoRaza raza, ArrayList<Cuidados> cuidados,
			MotivoAlta motivoAlta, MotivoBaja motivoBaja, LocalDate fechaAlta, LocalDate fechaBaja, Dieta dieta,
			TipoPiel tipoPiel) {
		super(id, fechaNacimiento, nombre, raza, cuidados, motivoAlta, motivoBaja, fechaAlta, fechaBaja, dieta);
		this.tipoPiel = tipoPiel;
	}

	public TipoPiel getTipoPiel() {
		return tipoPiel;
	}

	public void setTipoPiel(TipoPiel tipoPiel) {
		this.tipoPiel = tipoPiel;
	}
	
	
	
	
	
}
