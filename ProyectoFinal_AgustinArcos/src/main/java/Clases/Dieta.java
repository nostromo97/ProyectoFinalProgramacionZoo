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

public class Dieta extends Animal{

	private ArrayList<Alimento> dietaLunes;
	private ArrayList<Alimento> dietaMartes;
	private ArrayList<Alimento> dietaMi�rcoles;
	private ArrayList<Alimento> dietaJueves;
	private ArrayList<Alimento> dietaViernes;
	private ArrayList<Alimento> dietaS�bado;
	private ArrayList<Alimento> dietaDomingo;
	
	public Dieta(short id, LocalDate fechaNacimiento, String nombre, TipoRaza raza, String cuidados,
			MotivoAlta motivoAlta, MotivoBaja motivoBaja, LocalDate fechaAlta, LocalDate fechaBaja, Dieta dieta,
			ArrayList<Alimento> dietaLunes, ArrayList<Alimento> dietaMartes, ArrayList<Alimento> dietaMi�rcoles,
			ArrayList<Alimento> dietaJueves, ArrayList<Alimento> dietaViernes, ArrayList<Alimento> dietaS�bado,
			ArrayList<Alimento> dietaDomingo) throws NombreVacioException, NombreInvalidoException, IdInvalidoException, IdVacioException, FechaFormatoException {
		super(id, fechaNacimiento, nombre, raza, cuidados, motivoAlta, motivoBaja, fechaAlta, fechaBaja, dieta);
		this.dietaLunes = dietaLunes;
		this.dietaMartes = dietaMartes;
		this.dietaMi�rcoles = dietaMi�rcoles;
		this.dietaJueves = dietaJueves;
		this.dietaViernes = dietaViernes;
		this.dietaS�bado = dietaS�bado;
		this.dietaDomingo = dietaDomingo;
	}

	public ArrayList<Alimento> getDietaLunes() {
		return dietaLunes;
	}

	public void setDietaLunes(ArrayList<Alimento> dietaLunes) {
		this.dietaLunes = dietaLunes;
	}

	public ArrayList<Alimento> getDietaMartes() {
		return dietaMartes;
	}

	public void setDietaMartes(ArrayList<Alimento> dietaMartes) {
		this.dietaMartes = dietaMartes;
	}

	public ArrayList<Alimento> getDietaMi�rcoles() {
		return dietaMi�rcoles;
	}

	public void setDietaMi�rcoles(ArrayList<Alimento> dietaMi�rcoles) {
		this.dietaMi�rcoles = dietaMi�rcoles;
	}

	public ArrayList<Alimento> getDietaJueves() {
		return dietaJueves;
	}

	public void setDietaJueves(ArrayList<Alimento> dietaJueves) {
		this.dietaJueves = dietaJueves;
	}

	public ArrayList<Alimento> getDietaViernes() {
		return dietaViernes;
	}

	public void setDietaViernes(ArrayList<Alimento> dietaViernes) {
		this.dietaViernes = dietaViernes;
	}

	public ArrayList<Alimento> getDietaS�bado() {
		return dietaS�bado;
	}

	public void setDietaS�bado(ArrayList<Alimento> dietaS�bado) {
		this.dietaS�bado = dietaS�bado;
	}

	public ArrayList<Alimento> getDietaDomingo() {
		return dietaDomingo;
	}

	public void setDietaDomingo(ArrayList<Alimento> dietaDomingo) {
		this.dietaDomingo = dietaDomingo;
	}
	
	
	
	
}
