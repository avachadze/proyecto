package data;

public class Camion extends Vehiculo{

	private float carga;
	private char tipoMercancia;
	
	public Camion(String matricula, String numBastidor, String color, int numAsientos, double precio, float carga, char tipoMercancia, int añoFabricacion, String marca, String modelo) {
		super(matricula, numBastidor, color, numAsientos, precio, añoFabricacion, marca, modelo);
		this.carga= carga;
		this.tipoMercancia= tipoMercancia;
	}

	public float getCarga() {
		return carga;
	}

	public void setCarga(float carga) {
		this.carga = carga;
	}

	public char getTipoMercancia() {
		return tipoMercancia;
	}

	public void setTipoMercancia(char tipoMercancia) {
		this.tipoMercancia = tipoMercancia;
	}
	
	@Override
	public void mostrarDatos() {
		super.mostrarDatos();
		System.out.println("Carga: " + carga + 
				"\nTipo de mercancía: " + tipoMercancia);
	}
}
