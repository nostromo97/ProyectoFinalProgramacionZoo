package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase que implementa la conexión a la base de datos
 * @author Agustín Arcos
 *
 */
public abstract class UtilsDB {
	/**
	 * Cadena de caracteres que contiene la dirección de la conexión de la BBDD
	 */
	private static final String cadenaConexion = "jdbc:mysql://127.0.0.1:3306/baseDatosZoologico";
	/**
	 * Cadena de caracteres que contiene el nombre del usuario de la BBDD
	 */
	private static final String usuarioBD = "root";
	/**
	 * Cadena de caracteres que contiene la contraseña del usuario de la BBDD
	 */
	private static final String contrasenaBD = "";
	/**
	 * Objeto que contiene la conexión a BBDDD
	 */
	private static Connection conexion;
	
	/**
	 * Función que establece la conexión con la base de datos.
	 * @return statement preparado para poder realizr la conexión
	 */

	public static Statement conectarBD() {
		try {
			if (conexion == null) {
				conexion = DriverManager.getConnection(
						cadenaConexion, usuarioBD, contrasenaBD);
			}
			return conexion.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("No se ha podido conectar, inténtalo más tarde.");
			return null;
		}
	}
	
	/**
	 * Función que desconecta el programa de la base de datos
	 */

	public static void desconectarBD() {
		if (conexion != null) {
			try {
				conexion.close();
				conexion=null;
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println("No se pudo desconectar");
			}
		}
	}
}


