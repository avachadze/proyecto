package data;

public class Camion extends Vehiculo{

	float carga;
	char tipoMercancia;
	
	Camion(String matricula, String numBastidor, String color, int numAsientos, double precio, int serie, float carga, char tipoMercancia, int a�oFabricacion, String marca, String modelo) {
		super(matricula, numBastidor, color, numAsientos, precio, serie, a�oFabricacion, marca, modelo);
		this.carga= carga;
		this.tipoMercancia= tipoMercancia;
	}
}
