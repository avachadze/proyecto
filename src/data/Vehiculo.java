package data;

abstract class Vehiculo {
	
	String matricula;
	String numBastidor;
	String color;
	int numAsientos;
	double precio;
	int serie;
	int añoFabricación;
	String marca;
	String modelo;
	
	
	Vehiculo(String matricula, String numBastidor, String color, int numAsientos, double precio, int serie, int añoFabricacion, String marca, String modelo) {
		this.matricula= matricula;
		this.numBastidor= numBastidor;
		this.color= color;
		this.numAsientos= numAsientos;
		this.precio= precio;
		this.serie= serie;
		this.añoFabricación= añoFabricacion;
		this.marca= marca;
		this.modelo= modelo;
	}
}