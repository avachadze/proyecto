package connections;

import java.io.*;
import java.util.*;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;

import data.*;

public class XMLInOut {
	
	private static File archivo= new File("/Users/charli/Desktop/carpetos y exes/eclipse/provisional/resources/DatosVehiculos.xml");
	
	/**
	 * Método usado para modular la creación de coches y camiones, creando un objeto de tipo vehiculo con los datos que coinciden entre ambos tipos.
	 * @param elemento NodeList con los datos del xml a leer 
	 * @return Vehiculo con los datos que coinciden entre coches y camiones
	 */
	private static Vehiculo datosGenerales(Element elemento) {
		String matricula, numBastidor, color, modelo, marca;
		int numAsientos, añoFabricacion;
		double precio;
		
		matricula= elemento.getChild("matricula").getText();
		numBastidor= elemento.getChild("numBastidor").getText();
		color= elemento.getChild("color").getText();
		numAsientos= Integer.parseInt(elemento.getChild("numAsientos").getText());
		precio= Double.parseDouble(elemento.getChild("precio").getText());
		añoFabricacion= Integer.parseInt(elemento.getChild("añoFabricacion").getText());
		marca= elemento.getChild("marca").getText();
		modelo= elemento.getChild("modelo").getText();
		
		Vehiculo vehiculo= new Vehiculo(matricula, numBastidor, color, numAsientos, precio, añoFabricacion, marca, modelo);
		return vehiculo;
	}
	
	
	/**
	 * Método dedicado a leer datos de un archivo xml
	 */
	public static void lectura() {
		Coche coche= null;
		Camion camion= null;
		try {
			SAXBuilder db= new SAXBuilder();
			Document documento= db.build(archivo);

			Element root= documento.getRootElement();
			List<Element> listaVehiculos= root.getChildren();
			int index= 0;
			while (index < listaVehiculos.size()) {
				Element vehiculoActual= listaVehiculos.get(index);
		
				Vehiculo v= datosGenerales(vehiculoActual);
				
				if (vehiculoActual.getChild("tipo").getText().equals("camion")) {
					
				//Datos especificos de Camion
				float carga;
				String tipoMercancia;
				
				carga= Float.parseFloat(vehiculoActual.getChild("carga").getText());
				tipoMercancia= vehiculoActual.getChild("tipoMercarcia").getValue();
				
				camion= new Camion(v.getMatricula(), v.getNumBastidor(), v.getColor(), v.getNumAsientos(), v.getPrecio(), carga, tipoMercancia.charAt(0), v.getAñoFabricacion(), v.getMarca(), v.getModelo());
				
				camion.mostrarDatos();
				
				} else {
					
				//Datos especificos de Coche
				int numPuertas, capacidadMaletero;
				
				numPuertas= Integer.parseInt(vehiculoActual.getChild("numPuertas").getText());
				capacidadMaletero= Integer.parseInt(vehiculoActual.getChild("capacidadMaletero").getText());
				
				coche= new Coche(v.getMatricula(), v.getNumBastidor(), v.getColor(), v.getNumAsientos(), v.getPrecio(), numPuertas, capacidadMaletero, v.getAñoFabricacion(), v.getMarca(), v.getModelo());
				
				coche.mostrarDatos();
				}
				
				index++;
			}
		} catch (FileNotFoundException e) {
			System.err.println("La conexión con el archivo xml ha fallado.\nEl sistema no puede encontrar la ruta especificada");
		} catch (Exception e) {
			System.out.println("Fallo en el proceso de lectura");
			e.printStackTrace();
		}
	}
	
	public static void exportar() {
		try {
			FileInputStream fis = new FileInputStream(archivo);
		} catch (IOException e) {
			System.out.println("Fallo al exportar a xml");
		}
	}
}