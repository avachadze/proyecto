package connections;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import data.*;

public class XMLInOut {
	
	
	/**
	 * Método usado para modular la creación de coches y camiones, creando un objeto de tipo vehiculo con los datos que coinciden entre ambos tipos.
	 * @param elemento NodeList con los datos del xml a leer 
	 * @return Vehiculo con los datos que coinciden entre coches y camiones
	 */
	private static Vehiculo datosGenerales(Element elemento) {
		String matricula, numBastidor, color, modelo, marca;
		int numAsientos, añoFabricacion;
		double precio;
		
		matricula= elemento.getElementsByTagName("matricula").item(0).getTextContent();
		numBastidor= elemento.getElementsByTagName("numBastidor").item(0).getTextContent();
		color= elemento.getElementsByTagName("color").item(0).getTextContent();
		numAsientos= Integer.parseInt(elemento.getElementsByTagName("numAsientos").item(0).getTextContent());
		precio= Double.parseDouble(elemento.getElementsByTagName("precio").item(0).getTextContent());
		añoFabricacion= Integer.parseInt(elemento.getElementsByTagName("añoFabricacion").item(0).getTextContent());
		marca= elemento.getElementsByTagName("marca").item(0).getTextContent();
		modelo= elemento.getElementsByTagName("modelo").item(0).getTextContent();
		
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
			File archivo= new File("/Users/charli/Desktop/carpetos y exes/eclipse/provisional/resources/DatosVehiculos.xml");
			DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
			DocumentBuilder db= dbf.newDocumentBuilder();
			Document documento= db.parse(archivo);
			
			documento.getDocumentElement().normalize();
			NodeList listaVehiculos= documento.getElementsByTagName("vehiculos");
			NodeList listaCoches= (NodeList)listaVehiculos.item(0);
			NodeList listaCamiones= (NodeList)listaVehiculos.item(1);
			int index= 0;
			ArrayList<Coche> a= new ArrayList<Coche>();
			while (index < listaCoches.getLength()) {
				Node nodo= listaCoches.item(index);
				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element elemento = (Element) nodo;
					
					Vehiculo v1= datosGenerales(elemento);
					
					//Datos especificos de Coche
					int numPuertas, capacidadMaletero;
					
					numPuertas= Integer.parseInt(elemento.getElementsByTagName("numPuertas").item(0).getTextContent());
					capacidadMaletero= Integer.parseInt(elemento.getElementsByTagName("capacidadMaletero").item(0).getTextContent());
					
					coche= new Coche(v1.getMatricula(), v1.getNumBastidor(), v1.getColor(), v1.getNumAsientos(), v1.getPrecio(), numPuertas, capacidadMaletero, v1.getAñoFabricacion(), v1.getMarca(), v1.getModelo());
					
					coche.mostrarDatos();
				}
				index++;
			}
			index= 0;
			ArrayList<Camion> b= new ArrayList<Camion>();
			while (index < listaCamiones.getLength()) {
				Node nodo= listaCamiones.item(index);
				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element elemento = (Element) nodo;
					
					Vehiculo v2= datosGenerales(elemento);
					
					//Datos especificos de Camion
					float carga;
					String tipoMercancia;
					
					carga= Float.parseFloat(elemento.getElementsByTagName("carga").item(0).getTextContent());
					tipoMercancia= elemento.getElementsByTagName("tipoMercancia").item(0).getTextContent();
					
					camion= new Camion(v2.getMatricula(), v2.getNumBastidor(), v2.getColor(), v2.getNumAsientos(), v2.getPrecio(), carga, tipoMercancia.charAt(0), v2.getAñoFabricacion(), v2.getMarca(), v2.getModelo());
					
					camion.mostrarDatos();
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
		
	}
}