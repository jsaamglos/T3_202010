package model.logic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import com.google.gson.Gson;

import model.data_structures.ListaEncadenada;
import model.data_structures.Node;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */

	private Multa[] arreglo;

	private PrimeraClase prClase;
	private final static String path2 = "./data/comparendos_dei_2018_small.geojson";

	private final static String path = "./data/comparendos_dei_2018.geojson";

	/**
	 * Constructor del modelo del mundo
	 */
	public Modelo() {
		Gson gson = new Gson();
		try {
			FileInputStream inputStream = new FileInputStream(path);
			InputStreamReader ISReader = new InputStreamReader(inputStream);
			BufferedReader bf = new BufferedReader(ISReader);
			PrimeraClase pc = gson.fromJson(bf, PrimeraClase.class);
			prClase = pc;
			System.out.println(pc);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Se crea el arreglo con base en los datos cargados
	 */

	public Comparable[] copiarComparendos() {
		arreglo = prClase.getFeatures().clone();
		return arreglo;
	}

	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo
	 * 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamanoArreglo() {
		return arreglo.length;
	}

	public Comparable[] retornarComparendos(Comparable[] x) {
		Comparable[] resp = new Comparable[10];
		for (int i = 0; i < 11; i++) {
			resp[i] = x[i];
		}
		int y = 10;
		for (int j = x.length - 11; j < x.length; j++) {
			resp[y] = x[j];
			y++;
		}
		return resp;

	}

	public void shellSort(Comparable[] x) {
		int size1 = x.length;
		int h = 1;
		while (h < size1 / 3)
			h = 3 * h + 1;
		while (h >= 1) {
			for (int i = h; i < size1; i++) {
				Comparable temp = x[i];
				int j;
				for (j = i; j >= h && x[j - h].compareTo(temp) > 0; j -= h) {
					x[j] = x[j - h];
				}
				x[j] = temp;
			}
		}

	}

	public Comparable[] retornarComparendos2(Comparable[] x) {
		Comparable[] resp = new Comparable[10];
		int y = 1;
		for (int j = x.length - 11; j < x.length; j++) {
			resp[y] = x[j];
			y++;
		}
		return resp;
	}

}