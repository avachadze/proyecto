package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {

	public static void conexion() {
		String dbURL = "jdbc:mysql://localhost:3306/concesionario";
		String username = "root";
		String password = "root";
		try {
		    Connection connection = DriverManager.getConnection(dbURL, username, password);
		    if (connection != null) {
		    	System.out.println("Conexion establecida, bienvenido.");        
		    }
		}
		catch (SQLException ex) {
			System.out.println("Error en la conexion");
		    ex.printStackTrace();
		}
	}
	
}