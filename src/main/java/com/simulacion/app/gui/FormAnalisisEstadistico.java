package com.simulacion.app.gui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.simulacion.app.random.PruebasEstadisticasXiCuadrada;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.Window.Type;

import org.apache.commons.math3.stat.inference.ChiSquareTest;

public class FormAnalisisEstadistico extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1002852415698918859L;
	/**
	 * 
	 * 
	 * 
	 */
	private JPanel contentPane;
	private JTable table_ListaDeNumerosRi;
	private JTable table_TablaDeFrecuencia;
	private DefaultTableModel modeloListaNumeros = new DefaultTableModel();
	private DefaultTableModel modeloTablaFrecuencia = new DefaultTableModel();
	
	private Object[] listaDeNumeros;
	private JTextField txf_ValorEstadistico;
	private JTextField txf_valorXiCuadrado;
	
	

	/**
	 * Create the frame.
	 */
	public FormAnalisisEstadistico(Object[] listaDeNumeros) {
		setResizable(false);
		setType(Type.UTILITY);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormAnalisisEstadistico.class.getResource("/com/simulacion/app/recursos/blog-febrero-5-2021.png")));
		setTitle("Pruebas Estadisticas");
		
		this.listaDeNumeros = listaDeNumeros;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 412);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuAnalisis = new JMenu("Analisis Estadistico");
		menuBar.add(menuAnalisis);
		
		JMenuItem opcionXiCuadrada = new JMenuItem("Xi Cuadrada");
		menuAnalisis.add(opcionXiCuadrada);
		
		JMenuItem opcionKS = new JMenuItem("Kolmogorov - Smirnov");
		menuAnalisis.add(opcionKS);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelAnalisisEstadistico = new JPanel();
		contentPane.add(panelAnalisisEstadistico, BorderLayout.CENTER);
		panelAnalisisEstadistico.setLayout(new CardLayout(0, 0));
		
		JPanel panelXiCuadrada = new JPanel();
		panelAnalisisEstadistico.add(panelXiCuadrada, "name_53131384707500");
		panelXiCuadrada.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTablasXiCuadrada = new JPanel();
		panelXiCuadrada.add(panelTablasXiCuadrada, BorderLayout.CENTER);
		panelTablasXiCuadrada.setLayout(new BoxLayout(panelTablasXiCuadrada, BoxLayout.Y_AXIS));
		
		Box horizontalBox = Box.createHorizontalBox();
		panelTablasXiCuadrada.add(horizontalBox);
		
		Box verticalBox = Box.createVerticalBox();
		horizontalBox.add(verticalBox);
		
		JScrollPane scrollPane = new JScrollPane();
		verticalBox.add(scrollPane);
		
		table_ListaDeNumerosRi = new JTable();
		table_ListaDeNumerosRi.setModel(modeloListaNumeros);
		
		//modeloListaNumeros.addColumn("Aleatorios");
		
		scrollPane.setViewportView(table_ListaDeNumerosRi);
		
		Box verticalBox_1 = Box.createVerticalBox();
		horizontalBox.add(verticalBox_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		verticalBox_1.add(scrollPane_1);
		
		table_TablaDeFrecuencia = new JTable();
		table_TablaDeFrecuencia.setModel(modeloTablaFrecuencia);
		
		modeloTablaFrecuencia.addColumn("i");
		modeloTablaFrecuencia.addColumn("Li");
		modeloTablaFrecuencia.addColumn("Lf");
		modeloTablaFrecuencia.addColumn("FE");
		modeloTablaFrecuencia.addColumn("FO");
		modeloTablaFrecuencia.addColumn("Prueba");
		
		scrollPane_1.setViewportView(table_TablaDeFrecuencia);
		
		Component horizontalStrut = Box.createHorizontalStrut(550);
		verticalBox_1.add(horizontalStrut);
		
		Component verticalStrut = Box.createVerticalStrut(10);
		verticalBox_1.add(verticalStrut);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_1);
		
		JPanel panelDatosEstadisticos = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelDatosEstadisticos.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		horizontalBox_1.add(panelDatosEstadisticos);
		
		JLabel lblNewLabel = new JLabel("Valor estadistico");
		panelDatosEstadisticos.add(lblNewLabel);
		
		txf_ValorEstadistico = new JTextField();
		panelDatosEstadisticos.add(txf_ValorEstadistico);
		txf_ValorEstadistico.setColumns(10);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panelDatosEstadisticos.add(horizontalStrut_1);
		
		JLabel lblNewLabel_1 = new JLabel("Valor XI");
		panelDatosEstadisticos.add(lblNewLabel_1);
		
		txf_valorXiCuadrado = new JTextField();
		panelDatosEstadisticos.add(txf_valorXiCuadrado);
		txf_valorXiCuadrado.setColumns(10);
		
		JPanel panelKolmogorov = new JPanel();
		panelAnalisisEstadistico.add(panelKolmogorov, "name_53143425867400");
		
		this.llenarTablas();
		
		this.txf_ValorEstadistico.setText(Float.toString(this.sumarColumna(5)));
		
		this.txf_valorXiCuadrado.setText(Double.toString(new ChiSquareTest().chiSquare(this.convertirColumnaEnArrayD(3), this.convertirColumnaEnArrayL(4))));
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	private void llenarTablas() {
		
		PruebasEstadisticasXiCuadrada pr = new PruebasEstadisticasXiCuadrada();
		ArrayList<Object[]> lista = new ArrayList<>();
		pr.setListaNumerosAleatorios(this.listaDeNumeros);
		lista = pr.tablaFrecuencia();
		
		modeloListaNumeros.addColumn("Aleatorios", this.listaDeNumeros);
		
		for(Object[] obj: lista) {
			modeloTablaFrecuencia.addRow(obj);
		}
		
	}
	
	private float sumarColumna(int indice) {
		float suma = 0;
		
		for(int i = 0; i < this.table_TablaDeFrecuencia.getRowCount(); i++) {
			suma = suma + (float) this.table_TablaDeFrecuencia.getValueAt(i, indice);
		}
		
		return suma;
	}
	
	private double[] convertirColumnaEnArrayD(int indice) {
		double[] lista = new double[this.table_TablaDeFrecuencia.getRowCount()];
		
		for(int i = 0; i < this.table_TablaDeFrecuencia.getRowCount(); i++) {
			lista[i] = Double.valueOf(this.table_TablaDeFrecuencia.getValueAt(i, indice).toString());
		}
		
		return lista;
	}
	
	private long[] convertirColumnaEnArrayL(int indice) {
		long[] lista = new long[this.table_TablaDeFrecuencia.getRowCount()];
		for(int i = 0; i < this.table_TablaDeFrecuencia.getRowCount(); i++) {
			lista[i] =  Long.valueOf(this.table_TablaDeFrecuencia.getValueAt(i,indice).toString());
		}
		return lista;
	}

}
