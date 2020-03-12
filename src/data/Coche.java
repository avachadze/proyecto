package data;

public class Coche extends Vehiculo{

	private int numPuertas;
	private int capacidadMaletero;
	
	public Coche(String matricula, String numBastidor, String color, int numAsientos, double precio, int numPuertas, int capacidadMaletero, int añoFabricacion, String marca, String modelo) {
		super(matricula, numBastidor, color, numAsientos, precio, añoFabricacion, marca, modelo);
		this.numPuertas= numPuertas;
		this.capacidadMaletero= capacidadMaletero;
	}

	public int getNumPuertas() {
		return numPuertas;
	}

	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}

	public int getCapacidadMaletero() {
		return capacidadMaletero;
	}

	public void setCapacidadMaletero(int capacidadMaletero) {
		this.capacidadMaletero = capacidadMaletero;
	}
	
	@Override
	public void mostrarDatos() {
		super.mostrarDatos();
		System.out.println("Numero de puertas: " + numPuertas + 
				"\nCapacidad del maletero: " + capacidadMaletero);
	}
}