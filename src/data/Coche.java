package data;

public class Coche extends Vehiculo{

	int numPuertas;
	int capacidadMaletero;
	
	Coche(String matricula, String numBastidor, String color, int numAsientos, double precio, int serie, int numPuertas, int capacidadMaletero, int a�oFabricacion, String marca, String modelo) {
		super(matricula, numBastidor, color, numAsientos, precio, serie, a�oFabricacion, marca, modelo);
		this.numPuertas= numPuertas;
		this.capacidadMaletero= capacidadMaletero;
	}
}