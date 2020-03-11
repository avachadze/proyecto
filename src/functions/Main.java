package functions;

import console.Console;

public class Main {
	
	private static void menu() {
		int ask= 0;
		System.out.println("Bienvenido\n");
		do {
			System.out.println("1: Ver stock de vehículos\n2: Gestionar pintado\n3: Gestionar venta\n4: Gestionar compra\n5: Obtener datos de vehiculos desde archivo XML\n6: Exportar datos de stock disponible a archivo XML\n7: Salir del programa");
			System.out.println("\nInserta la opción necesitada");
			ask= Console.readInt();
			switch (ask) {
			case 1: stockDisplay(); break;
			case 2: pintado(); break;
			case 3: venta(); break;
			case 4: compra(); break;
			case 5: lectura(); break;
			case 6: exportar(); break;
			case 7: System.out.println("\nPrograma cerrado"); break;
			default: System.out.println("Número incorrecto introducido, inserta un número asignado a cualquiera de las opciones.");
			}
		} while(ask != 5);
	}
	
	private static void stockDisplay() {
		
	}
	
	private static void pintado() {
		
	}
	
	private static void venta() {
		
	}

	private static void compra() {
		
	}

	private static void lectura() {
		
	}

	private static void exportar() {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menu();
	}
}