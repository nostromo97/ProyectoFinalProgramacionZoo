package Clases;

import java.time.LocalDate;
import java.util.ArrayList;

import Enums.MotivoAlta;
import Enums.MotivoBaja;
import Enums.TipoPiel;
import Enums.TipoRaza;
import Excepciones.IdInvalidoException;
import Excepciones.IdVacioException;
import Excepciones.NombreInvalidoException;
import Excepciones.NombreVacioException;

public class Reptil extends Animal{

	private TipoPiel tipoPiel;

	public Reptil(short id, LocalDate fechaNacimiento, String nombre, TipoRaza raza, Cuidados cuidados,
			MotivoAlta motivoAlta, MotivoBaja motivoBaja, LocalDate fechaAlta, LocalDate fechaBaja, Dieta dieta,
			TipoPiel tipoPiel) throws NombreVacioException, NombreInvalidoException, IdInvalidoException, IdVacioException {
		super(id, fechaNacimiento, nombre, raza, cuidados, motivoAlta, motivoBaja, fechaAlta, fechaBaja, dieta);
		this.tipoPiel = tipoPiel;
	}

	
	
	//alta reptil
	public Reptil(short id, String nombre, LocalDate fechaNacimiento, Cuidados cuidados,
			MotivoAlta motivoAlta, LocalDate fechaAlta, Dieta dieta)
			throws NombreVacioException, NombreInvalidoException, IdInvalidoException, IdVacioException {
		super(id, nombre, fechaNacimiento, cuidados, motivoAlta, fechaAlta, dieta);
		this.tipoPiel = tipoPiel;
	}



	//baja reptil
	public Reptil(short id, String nombre, LocalDate fechaNacimiento, Cuidados cuidados,
			MotivoBaja motivoBaja, LocalDate fechaBaja, Dieta dieta)
			throws NombreVacioException, NombreInvalidoException, IdInvalidoException, IdVacioException {
		super(id, nombre, fechaNacimiento, cuidados, motivoBaja, fechaBaja, dieta);
		this.tipoPiel = tipoPiel;
	}




	public TipoPiel getTipoPiel() {
		return tipoPiel;
	}

	public void setTipoPiel(TipoPiel tipoPiel) {
		this.tipoPiel = tipoPiel;
	}
	
	
	
	
	
}
