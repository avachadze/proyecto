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
		String query = "SELECT v.*, s.codigoSerie,s.marca,s.modelo,s.añofabricacion,ca.*,c.*\r\n" + 
				"FROM vehiculos v, camiones ca,coches c, serie s\r\n" + 
				"WHERE v.matricula=ca.matricula && v.codigoSerie=s.codigoSerie";
		
		rs = st.executeQuery(query);
			
			while (rs.next()) {
				System.out.println("hola");
				String marca = rs.getString("s.marca");	
				String modelo = rs.getString("modelo");	
				String fabricacion = rs.getString("añoFabricacion");	
				String matricula = rs.getString("matricula");
				String bastidor = rs.getString("numbastidor");
				String color = rs.getString("color");	
				String tipo = rs.getString("tipo");	
				String asientos = rs.getString("numAsientos");
				String precio = rs.getString("precio");
				String serie = rs.getString("s.codigoSerie");	
				String carga = rs.getString("carga");
				String mercancia = rs.getString("tipoMercancia");
				String puertas = rs.getString("numPuertas");
				String capacidad = rs.getString("capacidadMaletero");
							
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
		}
		catch(Exception ex){
			ex.printStackTrace();
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


	
	private  void pintado() {
		stockDisplay();
		System.out.println("Serie del coche a pintar ");
	}
	
	private  void venta() {
		
	}

	private  void compra() {
		System.out.println("Que tipo de mercancia quiere comprar?");
		String respuesta = Console.readString();
		
		//marca
		System.out.println("Marca:");
		String marca = Console.readString();
		//modelo
		System.out.println("Modelo:");
		String modelo = Console.readString();
		//añoFabricacion
		System.out.println("Año Fabricacion:");
		String fabric = Console.readString();
		//matricula
		System.out.println("Matricula: ");
		String matricula = Console.readString();
		//numBastidor
		System.out.println("Numero Bastidor: ");
		String bastidor = Console.readString();
		//color
		System.out.println("Color: ");
		String color = Console.readString();
		//numAsientos
		System.out.println("Numero de asientos:");
		String asientos = Console.readString();
		//precio
		System.out.println("Precio:");
		String precio = Console.readString();

		
		
		if (respuesta.equalsIgnoreCase("coche")) {
			
			//numPuertas
			System.out.println("Numero de puertas:");
			String puertas = Console.readString();
			//capacidadMaletero
			System.out.println("Capacidad Maletero:");
			String maletero = Console.readString();
	
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", "root");
					st = con.createStatement();
					String query = "INSERT INTO coches (matricula,numPuertas,maletero) VALUES ('"+matricula+"','"+puertas+"','"+maletero+"')";
					String query2 = "INSERT INTO serie(marca,modelo,añoFabricacion) VALUES ('"+marca+"','"+modelo+"','"+fabric+"')";
					String query3 = "INSERT INTO Vehiculos (matricula,numBastidor,color,tipo,numAsientos,precio,codigoSerie) VALUES ('"+matricula+"''"+bastidor+"','"+color+"', '"+asientos+"','"+ precio+"')";
					
					st.executeUpdate(query);
					st.executeUpdate(query2);
					st.executeUpdate(query3);
					System.out.println("Un nuevo coche insertado");
				} catch (Exception e) {
					System.out.println("Error!");
				}

		}
		else {
			//carga
			System.out.println("Carga: ");
			String carga = Console.readString();
			//tipoMercancia
			
			System.out.println("Tipo de mercancia: ");
			String mercancia = Console.readString();
			String query2 = "insert into serie(marca,modelo,añoFabricacion) VALUES (?,?,?)";
			String query3 = "insert into Vehiculos (matricula,numBastidor,color,tipo,numAsientos,precio,codigoSerie) VALUES (?,?,?,?,?,?,?)";
			String query = "insert into camiones (matricula,numPuertas,maletero) VALUES (?,?,?)";
			
			
			System.out.println("Un nuevo vehiculo insertado");
			System.out.println("Un nuevo camion insertado");
		}
		
	}
	public static void main(String[] args) {
		Main test = new Main();
		test.menu();
		
	}
}