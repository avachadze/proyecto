package data;

public class Vehiculo {
	
	private String matricula;
	private String numBastidor;
	private String color;
	private int numAsientos;
	private double precio;
	private int a�oFabricacion;
	private String marca;
	private String modelo;
	
	
	public Vehiculo(String matricula, String numBastidor, String color, int numAsientos, double precio, int a�oFabricacion, String marca, String modelo) {
		this.matricula= matricula;
		this.numBastidor= numBastidor;
		this.color= color;
		this.numAsientos= numAsientos;
		this.precio= precio;
		this.a�oFabricacion= a�oFabricacion;
		this.marca= marca;
		this.modelo= modelo;
	}
	
	public void mostrarDatos() {
		System.out.println("Matricula: " + matricula + 
				"\nNumero de bastidor: " + numBastidor + 
				"\nColor: " + color + 
				"\nNumero de asientos: " + numAsientos + 
				"\nPrecio: " + precio + 
				"\nA�o de fabricaci�n: " + a�oFabricacion + 
				"\nMarca: " + marca + 
				"\nModelo: " + modelo);
	}

	public String getMatricula() {
		return matricula;
	}

	public String getNumBastidor() {
		return numBastidor;
	}

	public String getColor() {
		return color;
	}

	public int getNumAsientos() {
		return numAsientos;
	}

	public double getPrecio() {
		return precio;
	}

	public int getA�oFabricacion() {
		return a�oFabricacion;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void setNumBastidor(String numBastidor) {
		this.numBastidor = numBastidor;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setNumAsientos(int numAsientos) {
		this.numAsientos = numAsientos;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setA�oFabricacion(int a�oFabricacion) {
		this.a�oFabricacion = a�oFabricacion;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
}