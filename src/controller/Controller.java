package controller;

import java.util.Scanner;

import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo */
	private Modelo modelo;

	/* Instancia de la Vista */
	private View view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * 
	 * @param capacidad
	 *            tamaNo inicial del arreglo
	 */
	public Controller() {
		view = new View();
		modelo = new Modelo();
	}

	public void run() {
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";

		while (!fin) {
			view.printMenu();

			int option = lector.nextInt();
			switch (option) {
			case 1:
				view.printMessage("--------- \nCrear Arreglo \nDar capacidad inicial del arreglo: ");
				modelo.copiarComparendos();
				view.printMessage("Arreglo con Comparendos Creado");
				view.printMessage("Numero actual de elementos " + modelo.darTamanoArreglo() + "\n---------");
				break;

			case 2:
				view.printMessage("--------- \nCrear Arreglo \nOrganizar por ShellSort ");
				Comparable copia_Comparendos[] = modelo.copiarComparendos();
				long startTime = System.currentTimeMillis();
				modelo.shellSort(copia_Comparendos);
				long endTime = System.currentTimeMillis();
				long duration = endTime - startTime;
				view.printMessage("Tiempo de ordenamiento: " + duration + " milisegundos");
				view.printMessage("Los primeros 10 comparendos fueron:" + modelo.retornarComparendos(copia_Comparendos)
						+ "\n Los ultimos 10 comparendos fueron" + modelo.retornarComparendos2(copia_Comparendos));
				break;

			case 6:
				view.printMessage("--------- \n Hasta pronto !! \n---------");
				lector.close();
				fin = true;
				break;

			default:
				view.printMessage("--------- \n Opcion Invalida !! \n---------");
				break;
			}
		}

	}
}
