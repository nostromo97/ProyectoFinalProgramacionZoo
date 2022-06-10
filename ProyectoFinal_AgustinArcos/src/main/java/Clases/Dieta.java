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
 * @author Agustín Arcos
 *
 */
public class Dieta extends Animal{
	/**
	 * ArrayList de alimentos, equivalente a los alimentos de la dieta del animal el día Lunes de la semana.
	 */
	private ArrayList<Alimento> dietaLunes;
	/**
	 * ArrayList de alimentos, equivalente a los alimentos de la dieta del animal el día Martes de la semana.
	 */
	private ArrayList<Alimento> dietaMartes;
	/**
	 * ArrayList de alimentos, equivalente a los alimentos de la dieta del animal el día Miércoles de la semana.
	 */
	private ArrayList<Alimento> dietaMiércoles;
	/**
	 * ArrayList de alimentos, equivalente a los alimentos de la dieta del animal el día Jueves de la semana.
	 */
	private ArrayList<Alimento> dietaJueves;
	/**
	 * ArrayList de alimentos, equivalente a los alimentos de la dieta del animal el día Viernes de la semana.
	 */
	private ArrayList<Alimento> dietaViernes;
	/**
	 * ArrayList de alimentos, equivalente a los alimentos de la dieta del animal el día Sábado de la semana.
	 */
	private ArrayList<Alimento> dietaSábado;
	/**
	 * ArrayList de alimentos, equivalente a los alimentos de la dieta del animal el día Domingo de la semana.
	 */
	private ArrayList<Alimento> dietaDomingo;
	/**
	 * Constructor de la clase Dieta
	 * @param id Variable numérica de tipo short que contiene el id del animal.
	 * @param fechaNacimiento Variable de tipo LocalDate que contiene la fecha de nacimiento del animal.
	 * @param nombre Cadena de caracteres que contiene el nombre del animal.
	 * @param raza Proveniente del Enum TipoRaza que contiene el tipo de raza del animal.
	 * @param cuidados Cadena de caracteres que contiene una descripción del cuidado 
	 * 				   necesario para el animal, en el caso de que lo necesite.
	 * @param motivoAlta Proviene del Enum MotivoAlta que contiene los motivos de alta del animal.
	 * @param motivoBaja Proviene del Enum MotivoBaja que contiene los motivos de baja del animal.
	 * @param fechaAlta De tipo LocalDate, contiene la fecha de alta del animal en el centro.
	 * @param fechaBaja De tipo LocalDate, contiene la fecha de baja del animal en el centro.
	 * @param dieta De tipo Dieta, contiene ArrayList cada día de la semana con los alimentos que come al día el animal.
	 * @param dietaLunes ArrayList de alimentos, equivalente a los alimentos de la dieta del animal el día Lunes de la semana.
	 * @param dietaMartes ArrayList de alimentos, equivalente a los alimentos de la dieta del animal el día Martes de la semana.
	 * @param dietaMiércoles ArrayList de alimentos, equivalente a los alimentos de la dieta del animal el día Miércoles de la semana.
	 * @param dietaJueves ArrayList de alimentos, equivalente a los alimentos de la dieta del animal el día Jueves de la semana.
	 * @param dietaViernes ArrayList de alimentos, equivalente a los alimentos de la dieta del animal el día Viernes de la semana.
	 * @param dietaSábado ArrayList de alimentos, equivalente a los alimentos de la dieta del animal el día Sábado  de la semana.
	 * @param dietaDomingo ArrayList de alimentos, equivalente a los alimentos de la dieta del animal el día Domingo de la semana.
	 * @throws NombreVacioException Excepción que salta cuando el campo nombre está vacío.
	 * @throws NombreInvalidoException Excepción que salta cuando el nombre introducido no es válido.
	 * @throws IdInvalidoException Excepción que se lanza cuando el id introducido no es válido.
	 * @throws IdVacioException Excepción que se lanza cuando el campo id está vacío.
	 * @throws FechaFormatoException Excepción que salta cuando el formato de fecha introducido no es correcto.
	 */
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
	/**
	 * Función que devuelve la dieta del Lunes
	 * @return Dieta Lunes.
	 */
	public ArrayList<Alimento> getDietaLunes() {
		return dietaLunes;
	}
	/**
	 * Función que establece una dieta para el día Lunes
	 * @param dietaLunes Dieta de día Lunes.
	 */
	public void setDietaLunes(ArrayList<Alimento> dietaLunes) {
		this.dietaLunes = dietaLunes;
	}
	/**
	 * Función que devuelve la dieta del Martes
	 * @return Dieta Martes.
	 */
	public ArrayList<Alimento> getDietaMartes() {
		return dietaMartes;
	}
	/**
	 * Función que establece una dieta para el día Martes
	 * @param dietaLunes Dieta de día Martes.
	 */
	public void setDietaMartes(ArrayList<Alimento> dietaMartes) {
		this.dietaMartes = dietaMartes;
	}
	/**
	 * Función que devuelve la dieta del Miércoles
	 * @return Dieta Miércoles.
	 */
	public ArrayList<Alimento> getDietaMiércoles() {
		return dietaMiércoles;
	}
	/**
	 * Función que establece una dieta para el día Miércoles
	 * @param dietaLunes Dieta de día Miércoles.
	 */
	public void setDietaMiércoles(ArrayList<Alimento> dietaMiércoles) {
		this.dietaMiércoles = dietaMiércoles;
	}
	/**
	 * Función que devuelve la dieta del Jueves
	 * @return Dieta Jueves.
	 */
	public ArrayList<Alimento> getDietaJueves() {
		return dietaJueves;
	}
	/**
	 * Función que establece una dieta para el día Jueves.
	 * @param dietaLunes Dieta de día Jueves.
	 */
	public void setDietaJueves(ArrayList<Alimento> dietaJueves) {
		this.dietaJueves = dietaJueves;
	}
	/**
	 * Función que devuelve la dieta del Viernes
	 * @return Dieta Viernes
	 */
	public ArrayList<Alimento> getDietaViernes() {
		return dietaViernes;
	}
	/**
	 * Función que establece una dieta para el día Viernes
	 * @param dietaLunes Dieta de día Viernes.
	 */
	public void setDietaViernes(ArrayList<Alimento> dietaViernes) {
		this.dietaViernes = dietaViernes;
	}
	/**
	 * Función que devuelve la dieta del Sábado
	 * @return Dieta Sábado
	 */
	public ArrayList<Alimento> getDietaSábado() {
		return dietaSábado;
	}
	/**
	 * Función que establece una dieta para el día Sábado
	 * @param dietaLunes Dieta de día Sábado
	 */
	public void setDietaSábado(ArrayList<Alimento> dietaSábado) {
		this.dietaSábado = dietaSábado;
	}
	/**
	 * Función que devuelve la dieta del Domingo.
	 * @return Dieta Domingo
	 */
	public ArrayList<Alimento> getDietaDomingo() {
		return dietaDomingo;
	}
	/**
	 * Función que establece una dieta para el día Domingo
	 * @param dietaLunes Dieta de día Domingo.
	 */
	public void setDietaDomingo(ArrayList<Alimento> dietaDomingo) {
		this.dietaDomingo = dietaDomingo;
	}
	
	
	
	
}
