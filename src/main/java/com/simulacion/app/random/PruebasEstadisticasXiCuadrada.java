package com.simulacion.app.random;

import java.util.ArrayList;
import java.util.Arrays;

public class PruebasEstadisticasXiCuadrada {

	private Object[] listaNumerosAleatorios;
	private int totalIntervalos;
	private int totalElementos;
	private float amplitud;

	public PruebasEstadisticasXiCuadrada() {

	}

	/**
	 * <p>
	 * <strong>recibe la lista de los numeros aleatorios generados con anterioridad
	 * por cualquiera de los metodos</strong>
	 * </p>
	 *
	 * ->cuadrados medios <br>
	 * ->productos medios <br>
	 * ->multiplicador constante <br>
	 * 
	 * <p>
	 * el método ordena el array para posteriormente ser analizado.
	 * 
	 * @param lista lista de numeros aleatorios.
	 */
	public void setListaNumerosAleatorios(Object[] lista) {

		Arrays.sort(lista);

		this.listaNumerosAleatorios = lista;

		for (Object f : listaNumerosAleatorios) {
			System.out.println(f);
		}

	}

	/**
	 * <p>
	 * <strong> retorna la lista ordenada de numeros aleatorios generados
	 * anteiormente </strong>
	 * </p>
	 * 
	 * @return un array ordenado que contiene los números psudoaleatorios ordenados
	 */
	public Object[] getListaNumerosAleatorios() {
		return this.listaNumerosAleatorios;
	}

	/**
	 * cuenta el numero de elemtnos contenidos en la lista de números aleatorios
	 */
	public void setTotalElementos() {
		this.totalElementos = this.listaNumerosAleatorios.length;
	}

	/**
	 * 
	 * @return numero de elemtnos contenidos en la lista de numeros pseudoaleatorios
	 */
	public int getTotalElementos() {
		return this.totalElementos;
	}

	/**
	 * <p>
	 * <h1>calcula el numero de intervalos necesarios para poder realizar la tabla
	 * de frecuencias para la prueba de la Xi-Cuadrada.</h1>
	 * </p>
	 * 
	 * el calculo se hace mediante la regla de Sturges la cual consiste en: <br>
	 * -> n^½, donde n = {@code this.totalElementos} <br>
	 * -> 1 + Log2(n)<br>
	 * 
	 * cualquiera de las dos formas nos retorna el numero total de clases o
	 * intervalos
	 */
	public void setTotalIntervalos() {
		this.totalIntervalos = (int) Math.round(Math.sqrt(this.totalElementos)); 
	}

	public int getTotalIntervalos() {
		return this.totalIntervalos;
	}

	public void setAmplitud() {
		this.amplitud = 1f / this.totalIntervalos;
		//System.out.println(amplitud);
	}

	public float getAmplitud() {
		return this.amplitud;
	}

	/**
	 * 
	 * @return ArrayList<Object[]> con los valores de la tabla de frecuencias
	 */
	public ArrayList<Object[]> tablaFrecuencia() {
		ArrayList<Object[]> ar = new ArrayList<Object[]>();
		
		this.setTotalElementos();
		this.setTotalIntervalos();
		this.setAmplitud();
		
		System.out.println("Amplitud = " + this.getAmplitud());
		
		
		float min = Float.valueOf(this.listaNumerosAleatorios[0].toString());
		float max = min + this.getAmplitud();
		int fe = this.totalElementos / this.totalIntervalos;

		for (int i = 0; i < this.totalIntervalos; i++) {

			int fo = this.frecuenciaObservada(min, min + this.amplitud);

			ar.add(new Object[] { i + 1, // se almacena el numero de intervalo
					min, // se almacena limite inferior de la clase
					max, // se almacena el limite superior de la clase
					fe, // se almacena la frecuencia esperada
					fo, // se almacena la frecuencia observada
					this.pruebaEstadistica(fe, fo) // se almacena el valor de la prueba estadistica
			});

			min = max;
			max = min + this.getAmplitud();
		}
		return ar;
	}

	/**
	 * <p>
	 * cuenta el numero de elementos de la lista total de numeros pseusoaleatorios
	 * que esten dentro del rango o amplitud del intervalo dado dentro de la tabla
	 * de frecuencia
	 * </p>
	 * 
	 * 
	 * @param min -> el limite inferior del intervalo de la clase
	 * @param max -> limite superior del intervalo
	 * @return Numero total de elementos dentro del intervalo
	 */
	private int frecuenciaObservada(float min, float max) {
		int contador = 0;

		for (int i = 0; i < this.listaNumerosAleatorios.length; i++) {
			
			if (Float.parseFloat(this.listaNumerosAleatorios[i].toString()) >= min
					&& Float.parseFloat(this.listaNumerosAleatorios[i].toString()) < max) {
				contador++;
			}
			
		}

		return contador;
	}

	private float pruebaEstadistica(int fe, int fo) {
		return (float) Math.pow(fe - fo, 2) / fe;
	}

}
