/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Ingeniero Alexander Gonzalez
 */
public class Conexion {
    /** Metodo que realiza la conexion a la Base de datos return Connection. */

	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/bd_gestionman";
	private final String JDBC_USER = "root";
	private final String JDBC_PASS = "";
	private Driver driver = null;

        /** Metodo que realiza la conexion a la Base de datos return Connection */
	public synchronized Connection conexionBd() throws SQLException {
		
		if (driver == null) {
			try {
				Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
				driver = (Driver) jdbcDriverClass.newInstance();
				DriverManager.registerDriver(driver);
			} catch (Exception e) {
				System.out.println("Fallo en cargar el driver JDBC");
				e.printStackTrace();
			}
		}

		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
	}

	// Cierre del ResultSet
	public static void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception sqle) {
			sqle.printStackTrace();
		}
	}

	// Cierre del prepareStatement
	public static void close(PreparedStatement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (Exception sqle) {
			sqle.printStackTrace();
		}
	}

	// Cierre de la Connexion
	public static void close(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception sqle) {
			sqle.printStackTrace();
		}
	}
}
