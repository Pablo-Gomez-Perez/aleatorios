package com.simulacion.app.principal;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.simulacion.app.gui.FormNumerosAleatorios;
import com.simulacion.app.random.PruebasEstadisticasXiCuadrada;
import com.simulacion.app.random.RandomNumbers;

public class Main {

	public static void main(String[] args) {
		/*
		 * RandomNumbers rnd = new RandomNumbers(); PruebasEstadisticasXiCuadrada pr =
		 * new PruebasEstadisticasXiCuadrada(); ArrayList<Object[]> ar = new
		 * ArrayList<Object[]>(); ArrayList<Object[]> fr = new ArrayList<>(); int i = 0;
		 * 
		 * 
		 * rnd.setPrimSeed(1111); rnd.setTotalNumbers(20); ar = rnd.cuadradoMedio();
		 * 
		 * Object[] lista = new Object[ar.size()];
		 * 
		 * for(Object[] o: ar) { lista[i] = o[2]; i++; }
		 * 
		 * 
		 * pr.setListaNumerosAleatorios(lista);
		 * 
		 * 
		 * 
		 * fr = pr.tablaFrecuencia();
		 * 
		 * i = 0; //int j = 0;
		 * 
		 * for(Object[] o: fr) {
		 * 
		 * for(Object ob: o) {
		 * 
		 * System.out.print(ob + " ");
		 * 
		 * }
		 * 
		 * System.out.println();
		 * 
		 * }
		 */

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {

				try {

					FormNumerosAleatorios fr = new FormNumerosAleatorios();
					fr.setVisible(true);

				} catch (Exception er) {
					JOptionPane.showMessageDialog(null, "ha ocurrido un error " + er.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

	}

}
