package functions;

import connections.XMLInOut;
import console.Console;

public class Main {
	
	private static void menu() {
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
	private static void stockDisplay() {
		
	}
	
	private static void pintado() {
		
	}
	
	private static void venta() {
		
	}

	private static void compra() {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		connect();
	}
}