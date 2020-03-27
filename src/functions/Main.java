package functions;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import connections.XMLInOut;
import console.Console;

public class Main {
	private java.sql.Connection con;
	private java.sql.Statement st;
	private ResultSet rs;
	String dbURL = "jdbc:mysql://localhost:3306/concesionario";
	String username = "root";
	String password = "root";
	
	Main(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbURL, username, password);
			st = con.createStatement();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private  void stockDisplay() {
		
		try {
		String query = "SELECT * FROM serie,vehiculos,coches,camiones";
		rs = st.executeQuery(query);
			
			while (rs.next()) {
				
				String marca = rs.getString("marca");	
				String modelo = rs.getString("modelo");	
				String fabricacion = rs.getString("añoFabricacion");	
				String matricula = rs.getString("matricula");
				String bastidor = rs.getString("numbastidor");
				String color = rs.getString("color");	
				String tipo = rs.getString("tipo");	
				String asientos = rs.getString("numAsientos");
				float precio = rs.getFloat("precio");
				String serie = rs.getString("codigoSerie");	
				String carga = rs.getString("carga");
				String mercancia = rs.getString("tipoMercancia");
				String puertas = rs.getString("numPuertas");
				String capacidad = rs.getString("capacidadMaletero");
				
		;
				
				System.out.println("-----------\nSerie - " + serie  +
								   "\nMarca - " + marca + 
								   "\nModelo - " + modelo +
								   "\nAño Fabricacion - " + fabricacion +
						 		   "\nMatricula: " + matricula + 
								   "\nNumero Bastidor: " + bastidor + 
								   "\nColor - "+color + 
								   "\nTipo - " + tipo + 
								   "\nAsientos - "+asientos+
								   "\nPrecio - " + precio 
								   );
				if (tipo.equals("Camion")) {
					
					System.out.println("Carga - " + carga + 
							   "\nTipo Mercancia - " + mercancia+"\n");
				}
				else {
					System.out.println("puertas - " + puertas + 
									   "\nCapacidad - " + capacidad+"\n");
				}
			}
		}catch(Exception ex){
			ex.getStackTrace();
		}finally {
			try {
				con.close();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	private void menu() {
		int ask= 0;
		System.out.println("Bienvenido\n");
		do {
			System.out.println("1: Ver stock de vehículos\n2: Gestionar pintado\n3: Gestionar venta\n4: Gestionar compra\n5: Obtener datos de vehiculos desde archivo XML\n6: Exportar datos de stock disponible a archivo XML\n7: Salir del programa");
			System.out.println("\nInserta la opción necesitada\n");
			ask= Console.readInt();
			switch (ask) {
			case 1: stockDisplay(); break;
			case 2: pintado(); break;
			case 3: venta(); break;
			case 4: compra(); break;
			case 5: XMLInOut.lectura(); break;
			case 6: XMLInOut.exportar(); break;
			case 7: System.out.println("\nPrograma cerrado"); break;
			default: System.out.println("Número incorrecto introducido, inserta un número asignado a cualquiera de las opciones.");
			}
		} while(ask != 5);
	}
	private static void connect() {
		String dbURL = "jdbc:mysql://localhost:3306/concesionario";
		String username = "root";
		String password = "root";
		try {
		    java.sql.Connection connection = DriverManager.getConnection(dbURL, username, password);
		    if (connection != null) {
		    	System.out.println("Conexion establecida, bienvenido.");        
		    }
		}
		catch (SQLException ex) {
			System.out.println("Error en la conexion");
		    ex.printStackTrace();
		}
	}

	
	private  void pintado() {
		stockDisplay();
		System.out.println("Serie del coche a pintar ");
		
		
		
	}
	
	private  void venta() {
		
	}

	private  void compra() {
		System.out.println("Que tipo de mercancia quiere comprar?");
		String respuesta = Console.readString();
		System.out.println("Matricula: ");
		String matricula = Console.readString();
		System.out.println("Numero de puertas: ");
		int numPuertas = Console.readInt();
		System.out.println("Capacidad maletero: ");
		int capacidadMaletero = Console.readInt();
		System.out.println("Numero de serie - ");
		int serie = Console.readInt();
		
		if (respuesta.equalsIgnoreCase("coche")) {
			String query = "insert into coches (matricula, numAsientos, capacidadmaletero) VALUES (1,2,3)";
		}
		
	}
	
	public static void main(String[] args) {
		
		Main hola = new Main();
		hola.menu();
	}
}