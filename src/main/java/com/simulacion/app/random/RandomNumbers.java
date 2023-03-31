package com.simulacion.app.random;

import java.util.ArrayList;

/**
 * 
 * <strong>
 * <h1>clase para el calculo de numeros psudoaleatorios</h1></strong><br>
 * 
 * clase contenedora de métodos para el calculo de numero psudoaleatorios
 * 
 * Para realizar una simulación se requieren números aleatorios en el intervalo
 * (0,1), a los cuales se hará referencia como r es decir, una secuencia r¡ = {
 * f ,,r2lr3 l...,rn} que contiene "n" números, todos ellos diferentes. El valor
 * "n" recibe el nombre de periodo o ciclo d e vida del generador que creó la
 * secuencia r¡.
 * 
 * en terminos computacionales la aleatoriedad es imposible por lo que cada
 * algoritmo precisa de parametros iniciales para desencadenar el proceso
 * generativo
 * 
 * @author PABLO
 *
 */
public class RandomNumbers {

	private int primSeed;
	private int secondSeed;
	private int multConstant;
	private int totalNumbers;
	private int centerDigits;
	private float generatedRandomNumber;

	/**
	 * constructor vacío, asignar valores mediate getters()
	 */
	public RandomNumbers() {

	}

	/**
	 * @return the primSeed
	 */
	public int getPrimSeed() {
		return primSeed;
	}

	/**
	 * @return the secondSeed
	 */
	public int getSecondSeed() {
		return secondSeed;
	}

	/**
	 * @return the multConstant
	 */
	public int getMultConstant() {
		return multConstant;
	}

	/**
	 * @return the totalNumbers
	 */
	public int getTotalNumbers() {
		return totalNumbers;
	}

	/**
	 * @return the centerDigits
	 */
	public int getCenterDigits() {
		return centerDigits;
	}

	/**
	 * @return the generatedRandomNumber
	 */
	public float getGeneratedRandomNumber() {
		return generatedRandomNumber;
	}

	/**
	 * si el parámetro asignado como semilla principal es menor a 4 digitos asignará
	 * un 0
	 * 
	 * @param primSeed the primSeed to set
	 * @return
	 */
	public void setPrimSeed(int primSeed) {
		if (String.valueOf(primSeed).length() >= 4) {
			this.primSeed = primSeed;
		} else {
			this.primSeed = 0;
		}
	}

	/**
	 * si el parametro asignado como semilla secundaria es menor a cuatro digitos
	 * asignará un 0
	 * 
	 * @param secondSeed the secondSeed to set
	 */
	public void setSecondSeed(int secondSeed) {
		if (String.valueOf(secondSeed).length() >= 4) {
			this.secondSeed = secondSeed;
		} else {
			this.secondSeed = 0;
		}
	}

	/**
	 * si el parametro asignado como multiplicador constante es menor a cuatro
	 * digitos se le asignará un 0 por defecto
	 * 
	 * @param multConstant the multConstant to set
	 */
	public void setMultConstant(int multConstant) {
		if (String.valueOf(multConstant).length() >= 4) {
			this.multConstant = multConstant;
		} else {
			this.multConstant = 0;
		}
	}

	/**
	 * @param totalNumbers the totalNumbers to set
	 */
	public void setTotalNumbers(int totalNumbers) {
		this.totalNumbers = totalNumbers;
	}

	/**
	 * obtenemos los dígitos centrales de un número asignado
	 * 
	 * @param centerDigits the centerDigits to set
	 */
	public void setCenterDigits(int centerDigits) {
		// se transforma el numeor en un String
		String digitos = Integer.toString(centerDigits);

		// mientras no se pueda obtener los digitos centrales del numero se agregan 0's
		while (digitos.length() < 8) {
			digitos = "0" + digitos;
		}

		/*
		 * se ubica al cursor en el punto medio de la longitud del String y se resta
		 * uno, ese es nuestro punto de inicio, y para el punto final se ubica al cursor
		 * nuevamente en el punto medio y se suma dos, de esa forma se obtiene los 4
		 * digitos centrales del número pasdo como parámetro.
		 */
		this.centerDigits = Integer.parseInt(digitos.substring((digitos.length() / 2) - 2, (digitos.length() / 2) + 2));

	}

	/**
	 * <p>
	 * <strong>se asigna el valor del numero aleatorio generado, obtenido de extraer
	 * los valores centrales de un número previamente recorrido.</strong>
	 * </p>
	 * 
	 * un numero aleatorio es una variable aleatoria, por lo tanto tiene un valor en
	 * intervalo de (0,1), por lo que al recibir los digitos centrales como
	 * parámetro de cualquiera de los métodos generadores de los numeros aleatorios
	 * utilizados, se le concatena con 0. -----
	 * 
	 * @param generatedRandomNumber the generatedRandomNumber to set
	 */
	public void setGeneratedRandomNumber(float generatedRandomNumber) {
		// se convierte el numero en un String, y el valor obtenido de los digitos
		// centrales
		// se le concatena con 0. -----
		StringBuilder sb = new StringBuilder();
		sb.append(0).append(".");
		sb.append(this.centerDigits);

		this.generatedRandomNumber = Float.parseFloat(sb.toString());

	}

	/**
	 * generación de numeros aleatorios mediante el método de cuadrados medios
	 * 
	 * @return {@code ArrayList<Object[]>} con el proposito de mostrar los elementos
	 *         en un {@code JTable}
	 */
	public ArrayList<Object[]> cuadradoMedio() {

		ArrayList<Object[]> listOfRandomNumber = new ArrayList<Object[]>();
		int i = 0;
		int seed = this.primSeed;

		while (i < this.totalNumbers) {

			setCenterDigits((int) (Math.pow(seed, 2)));
			this.setGeneratedRandomNumber(this.getCenterDigits());

			listOfRandomNumber.add(new String[] { Integer.toString(seed), Integer.toString(this.getCenterDigits()),
					Float.toString(this.getGeneratedRandomNumber()) });

			seed = getCenterDigits();
			i++;

		}

		listOfRandomNumber.stream().forEach((Object[] s) -> {
			for (Object d : s) {
				System.out.print(d + " ");
			}
			;
			System.out.println();
		});

		return listOfRandomNumber;

	}

	/**
	 * <p>
	 * generarión de numeros psudoaleatorios mediante el método de productos medios
	 * </p>
	 * 
	 * <p>
	 * este metodo requiere de dos semillas, ambas con D>4 digitos, las cuales
	 * estaran multiplicandose de manera iterativa hasta que se alcance el ciclo de
	 * vida deseado
	 * </p>
	 * 
	 * @return {@code ArrayList<Object[]} con el proposito de exhibir los elementos
	 *         en un {@code JTable}
	 */
	public ArrayList<Object[]> productosMedios() {

		ArrayList<Object[]> listOfRandomNumbers = new ArrayList<Object[]>();
		int i = 0;

		int seed1 = this.primSeed;
		int seed2 = this.secondSeed;

		while (i < this.totalNumbers) {

			// se obtienen los numeros centrales de la multiplicación de las dos semillas
			this.setCenterDigits((seed1 * seed2));
			// se asigna el numero aleatorio generado
			this.setGeneratedRandomNumber(this.getCenterDigits());

			listOfRandomNumbers.add(new Object[] { Integer.toString(seed1), // se agrega el valor de la semilla 1
					Integer.toString(seed2), // se agrega el valor de la semilla 2
					Integer.toString(this.getCenterDigits()), // se agrega el valor de los digitos centrales
					Float.toString(this.getGeneratedRandomNumber()) // se agrega el valor de el numero aleatorio
																	// generado
			});

			/*
			 * se elimina la primer semilla propuesta y se cambia por la segunda y la
			 * segunda semilla toma el valor del último numero aleatorio generado
			 */
			seed1 = seed2;
			seed2 = this.getCenterDigits();

			i++;
		}

		// se imprime en consola los resultados
		listOfRandomNumbers.stream().forEach((Object[] s) -> {
			for (Object d : s) {
				System.out.print(d + " ");
			}
			System.out.println();
		});

		return listOfRandomNumbers;
	}

	/**
	 * <p>
	 * Generación de numeros psudoaleatorios mediante el método de multiplicador
	 * constante
	 * </p>
	 * 
	 * <p>
	 * al igual que en el metodo de {@code productosMedios()} este requiere de do
	 * valores iniciales la diferencia es que en este método, solo uno de los
	 * valores iniciales es dinámico, mientras que el otro se mantiene constante
	 * </p>
	 * 
	 * @return {@code ArrayList<Object[]} con el proposito de exhibir los elementos
	 *         en un {@code JTable}
	 */
	public ArrayList<Object[]> multiplicadorConstante() {

		ArrayList<Object[]> listOfRandomNumbers = new ArrayList<Object[]>();
		int i = 0;

		int seed1 = this.primSeed;
		int constante = this.multConstant;

		while (i < this.totalNumbers) {

			// se obtienen los digitos centrales de la multiplicación de la semilla por la
			// constante
			this.setCenterDigits((seed1 * constante));
			// se asigna el numero aleatorio generado
			this.setGeneratedRandomNumber(this.getCenterDigits());

			listOfRandomNumbers.add(new Object[] { Integer.toString(seed1), // se almacena el valor de la semilla
					Integer.toString(constante), // se almacena el valor de la constante
					Integer.toString(this.getCenterDigits()), // se almacenan los digitos centrales obtenidos de cad
																// amultiplicacion
					Float.toString(this.getGeneratedRandomNumber()) // se almacena el numero psudoaleatorio generado
			});

			seed1 = this.getCenterDigits();

			i++;
		}

		listOfRandomNumbers.stream().forEach((Object[] s) -> {
			for (Object d : s) {
				System.out.print(d + " ");
			}
			System.out.println();
		});

		return listOfRandomNumbers;
	}
}
