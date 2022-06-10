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
/**
 * Clase que contiene una dieta del animal. Extiende de la superclase Animal.
 * 
 * @author Agust�n Arcos
 *
 */
public class Dieta extends Animal{
	/**
	 * ArrayList de alimentos, equivalente a los alimentos de la dieta del animal el d�a Lunes de la semana.
	 */
	private ArrayList<Alimento> dietaLunes;
	/**
	 * ArrayList de alimentos, equivalente a los alimentos de la dieta del animal el d�a Martes de la semana.
	 */
	private ArrayList<Alimento> dietaMartes;
	/**
	 * ArrayList de alimentos, equivalente a los alimentos de la dieta del animal el d�a Mi�rcoles de la semana.
	 */
	private ArrayList<Alimento> dietaMi�rcoles;
	/**
	 * ArrayList de alimentos, equivalente a los alimentos de la dieta del animal el d�a Jueves de la semana.
	 */
	private ArrayList<Alimento> dietaJueves;
	/**
	 * ArrayList de alimentos, equivalente a los alimentos de la dieta del animal el d�a Viernes de la semana.
	 */
	private ArrayList<Alimento> dietaViernes;
	/**
	 * ArrayList de alimentos, equivalente a los alimentos de la dieta del animal el d�a S�bado de la semana.
	 */
	private ArrayList<Alimento> dietaS�bado;
	/**
	 * ArrayList de alimentos, equivalente a los alimentos de la dieta del animal el d�a Domingo de la semana.
	 */
	private ArrayList<Alimento> dietaDomingo;
	/**
	 * Constructor de la clase Dieta
	 * @param id Variable num�rica de tipo short que contiene el id del animal.
	 * @param fechaNacimiento Variable de tipo LocalDate que contiene la fecha de nacimiento del animal.
	 * @param nombre Cadena de caracteres que contiene el nombre del animal.
	 * @param raza Proveniente del Enum TipoRaza que contiene el tipo de raza del animal.
	 * @param cuidados Cadena de caracteres que contiene una descripci�n del cuidado 
	 * 				   necesario para el animal, en el caso de que lo necesite.
	 * @param motivoAlta Proviene del Enum MotivoAlta que contiene los motivos de alta del animal.
	 * @param motivoBaja Proviene del Enum MotivoBaja que contiene los motivos de baja del animal.
	 * @param fechaAlta De tipo LocalDate, contiene la fecha de alta del animal en el centro.
	 * @param fechaBaja De tipo LocalDate, contiene la fecha de baja del animal en el centro.
	 * @param dieta De tipo Dieta, contiene ArrayList cada d�a de la semana con los alimentos que come al d�a el animal.
	 * @param dietaLunes ArrayList de alimentos, equivalente a los alimentos de la dieta del animal el d�a Lunes de la semana.
	 * @param dietaMartes ArrayList de alimentos, equivalente a los alimentos de la dieta del animal el d�a Martes de la semana.
	 * @param dietaMi�rcoles ArrayList de alimentos, equivalente a los alimentos de la dieta del animal el d�a Mi�rcoles de la semana.
	 * @param dietaJueves ArrayList de alimentos, equivalente a los alimentos de la dieta del animal el d�a Jueves de la semana.
	 * @param dietaViernes ArrayList de alimentos, equivalente a los alimentos de la dieta del animal el d�a Viernes de la semana.
	 * @param dietaS�bado ArrayList de alimentos, equivalente a los alimentos de la dieta del animal el d�a S�bado  de la semana.
	 * @param dietaDomingo ArrayList de alimentos, equivalente a los alimentos de la dieta del animal el d�a Domingo de la semana.
	 * @throws NombreVacioException Excepci�n que salta cuando el campo nombre est� vac�o.
	 * @throws NombreInvalidoException Excepci�n que salta cuando el nombre introducido no es v�lido.
	 * @throws IdInvalidoException Excepci�n que se lanza cuando el id introducido no es v�lido.
	 * @throws IdVacioException Excepci�n que se lanza cuando el campo id est� vac�o.
	 * @throws FechaFormatoException Excepci�n que salta cuando el formato de fecha introducido no es correcto.
	 */
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
	/**
	 * Funci�n que devuelve la dieta del Lunes
	 * @return Dieta Lunes.
	 */
	public ArrayList<Alimento> getDietaLunes() {
		return dietaLunes;
	}
	/**
	 * Funci�n que establece una dieta para el d�a Lunes
	 * @param dietaLunes Dieta de d�a Lunes.
	 */
	public void setDietaLunes(ArrayList<Alimento> dietaLunes) {
		this.dietaLunes = dietaLunes;
	}
	/**
	 * Funci�n que devuelve la dieta del Martes
	 * @return Dieta Martes.
	 */
	public ArrayList<Alimento> getDietaMartes() {
		return dietaMartes;
	}
	/**
	 * Funci�n que establece una dieta para el d�a Martes
	 * @param dietaLunes Dieta de d�a Martes.
	 */
	public void setDietaMartes(ArrayList<Alimento> dietaMartes) {
		this.dietaMartes = dietaMartes;
	}
	/**
	 * Funci�n que devuelve la dieta del Mi�rcoles
	 * @return Dieta Mi�rcoles.
	 */
	public ArrayList<Alimento> getDietaMi�rcoles() {
		return dietaMi�rcoles;
	}
	/**
	 * Funci�n que establece una dieta para el d�a Mi�rcoles
	 * @param dietaLunes Dieta de d�a Mi�rcoles.
	 */
	public void setDietaMi�rcoles(ArrayList<Alimento> dietaMi�rcoles) {
		this.dietaMi�rcoles = dietaMi�rcoles;
	}
	/**
	 * Funci�n que devuelve la dieta del Jueves
	 * @return Dieta Jueves.
	 */
	public ArrayList<Alimento> getDietaJueves() {
		return dietaJueves;
	}
	/**
	 * Funci�n que establece una dieta para el d�a Jueves.
	 * @param dietaLunes Dieta de d�a Jueves.
	 */
	public void setDietaJueves(ArrayList<Alimento> dietaJueves) {
		this.dietaJueves = dietaJueves;
	}
	/**
	 * Funci�n que devuelve la dieta del Viernes
	 * @return Dieta Viernes
	 */
	public ArrayList<Alimento> getDietaViernes() {
		return dietaViernes;
	}
	/**
	 * Funci�n que establece una dieta para el d�a Viernes
	 * @param dietaLunes Dieta de d�a Viernes.
	 */
	public void setDietaViernes(ArrayList<Alimento> dietaViernes) {
		this.dietaViernes = dietaViernes;
	}
	/**
	 * Funci�n que devuelve la dieta del S�bado
	 * @return Dieta S�bado
	 */
	public ArrayList<Alimento> getDietaS�bado() {
		return dietaS�bado;
	}
	/**
	 * Funci�n que establece una dieta para el d�a S�bado
	 * @param dietaLunes Dieta de d�a S�bado
	 */
	public void setDietaS�bado(ArrayList<Alimento> dietaS�bado) {
		this.dietaS�bado = dietaS�bado;
	}
	/**
	 * Funci�n que devuelve la dieta del Domingo.
	 * @return Dieta Domingo
	 */
	public ArrayList<Alimento> getDietaDomingo() {
		return dietaDomingo;
	}
	/**
	 * Funci�n que establece una dieta para el d�a Domingo
	 * @param dietaLunes Dieta de d�a Domingo.
	 */
	public void setDietaDomingo(ArrayList<Alimento> dietaDomingo) {
		this.dietaDomingo = dietaDomingo;
	}
	
	
	
	
}
