package Clases;

import java.time.LocalDate;
import java.util.ArrayList;

import Enums.MotivoAlta;
import Enums.MotivoBaja;
import Enums.TipoRaza;
import Excepciones.FechaFormatoException;
import Excepciones.IdInvalidoException;
import Excepciones.IdVacioException;
import Excepciones.NombreInvalidoException;
import Excepciones.NombreVacioException;

public class Primate extends Animal{

	private boolean genero;

	public Primate(short id, LocalDate fechaNacimiento, String nombre, TipoRaza raza, Cuidados cuidados,
			MotivoAlta motivoAlta, MotivoBaja motivoBaja, LocalDate fechaAlta, LocalDate fechaBaja, Dieta dieta,
			boolean genero) throws NombreVacioException, NombreInvalidoException, IdInvalidoException, IdVacioException, FechaFormatoException {
		super(id, fechaNacimiento, nombre, raza, cuidados, motivoAlta, motivoBaja, fechaAlta, fechaBaja, dieta);
		this.genero = genero;
	}
	//alta primate
	public Primate(short id, String nombre, LocalDate fechaNacimiento, Cuidados cuidados,
			MotivoAlta motivoAlta, LocalDate fechaAlta, Dieta dieta)
			throws NombreVacioException, NombreInvalidoException, IdInvalidoException, IdVacioException, FechaFormatoException {
		super(id, nombre, fechaNacimiento, cuidados, motivoAlta, fechaAlta, dieta);
		// TODO Auto-generated constructor stub
	}


	//baja primate
	public Primate(short id, String nombre, LocalDate fechaNacimiento, Cuidados cuidados,
			MotivoBaja motivoBaja, LocalDate fechaBaja, Dieta dieta)
			throws NombreVacioException, NombreInvalidoException, IdInvalidoException, IdVacioException, FechaFormatoException {
		super(id, nombre, fechaNacimiento, cuidados, motivoBaja, fechaBaja, dieta);
		// TODO Auto-generated constructor stub
	}	

	

	public boolean isGenero() {
		return genero;
	}





	public void setGenero(boolean genero) {
		this.genero = genero;
	}
	
	
}
