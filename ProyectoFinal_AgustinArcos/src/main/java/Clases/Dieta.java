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
	private ArrayList<Alimento> dietaMiércoles;
	private ArrayList<Alimento> dietaJueves;
	private ArrayList<Alimento> dietaViernes;
	private ArrayList<Alimento> dietaSábado;
	private ArrayList<Alimento> dietaDomingo;
	
	public Dieta(short id, LocalDate fechaNacimiento, String nombre, TipoRaza raza, String cuidados,
			MotivoAlta motivoAlta, MotivoBaja motivoBaja, LocalDate fechaAlta, LocalDate fechaBaja, Dieta dieta,
			ArrayList<Alimento> dietaLunes, ArrayList<Alimento> dietaMartes, ArrayList<Alimento> dietaMiércoles,
			ArrayList<Alimento> dietaJueves, ArrayList<Alimento> dietaViernes, ArrayList<Alimento> dietaSábado,
			ArrayList<Alimento> dietaDomingo) throws NombreVacioException, NombreInvalidoException, IdInvalidoException, IdVacioException, FechaFormatoException {
		super(id, fechaNacimiento, nombre, raza, cuidados, motivoAlta, motivoBaja, fechaAlta, fechaBaja, dieta);
		this.dietaLunes = dietaLunes;
		this.dietaMartes = dietaMartes;
		this.dietaMiércoles = dietaMiércoles;
		this.dietaJueves = dietaJueves;
		this.dietaViernes = dietaViernes;
		this.dietaSábado = dietaSábado;
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

	public ArrayList<Alimento> getDietaMiércoles() {
		return dietaMiércoles;
	}

	public void setDietaMiércoles(ArrayList<Alimento> dietaMiércoles) {
		this.dietaMiércoles = dietaMiércoles;
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

	public ArrayList<Alimento> getDietaSábado() {
		return dietaSábado;
	}

	public void setDietaSábado(ArrayList<Alimento> dietaSábado) {
		this.dietaSábado = dietaSábado;
	}

	public ArrayList<Alimento> getDietaDomingo() {
		return dietaDomingo;
	}

	public void setDietaDomingo(ArrayList<Alimento> dietaDomingo) {
		this.dietaDomingo = dietaDomingo;
	}
	
	
	
	
}
