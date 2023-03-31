package com.simulacion.app.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.simulacion.app.random.RandomNumbers;

import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.JTextField;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class FormNumerosAleatorios extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8929706585379172014L;
	/**
	 * 
	 * 
	 * 
	 * 
	 */
	private JPanel panelPrincipal;
	private JPanel panelBarraDeMenu;
	private JMenuBar menuOpciones;
	private JMenu menuMetodos;
	private JMenuItem opcionCuadradosMedios;
	private JMenuItem opcionProductosMedios;
	private JMenuItem opcionConstanteMult;
	private JPanel panelNumerosAleatorios;
	private JPanel panelCuadradosMedios;
	private JPanel panelProductosMedios;
	private JPanel panelConstanteMult;
	private JPanel panelLbCuadradosMedios;
	private JLabel lblNewLabel;
	private JPanel panelOperacionesCuadradosMEdios;
	private Box horizontalBox;
	private JLabel lblNewLabel_1;
	private JTextField txf_Semilla;
	private Component verticalStrut;
	private Box horizontalBox_1;
	private JScrollPane scrollPane;
	// TableModel del panel que trabaja con el método de cuadrados medios
	private DefaultTableModel modelCuadradosMedios = new DefaultTableModel();
	// TableModel del panel que trabaja con el método de productos medios
	private DefaultTableModel modelProductosMedios = new DefaultTableModel();
	// TableModel del panel que trabaja con el método de constante multiplicadora
	private DefaultTableModel modelConstanteMultiplicadora = new DefaultTableModel();
	private JTable tabla_CuadradosMedios;
	private Component horizontalStrut_1;
	private JButton btn_generar_cuadradosMedios;
	private Component horizontalStrut_2;
	private JButton btn_limpiar_tablaCuadradosMedios;
	private JLabel lblNewLabel_2;
	private JTextField txf_cantidadNumeros;
	private Component horizontalStrut_4;
	private JPanel panel_lbProductosMedios;
	private JLabel lblNewLabel_3;
	private JPanel panelOperacionesProductosMedios;
	private Box horizontalBox_2;
	private JLabel lblNewLabel_4;
	private JTextField txf_Semilla1;
	private Component horizontalStrut;
	private JLabel lblNewLabel_5;
	private JTextField txf_Semilla2;
	private Component verticalStrut_1;
	private Box horizontalBox_3;
	private JLabel lblNewLabel_6;
	private JTextField txf_totalNumerosMult;
	private Component horizontalStrut_3;
	private JButton btn_generar_productosMedios;
	private Component horizontalStrut_5;
	private JButton btn_limpiar_tablaProductosMEdios;
	private Component verticalStrut_2;
	private Box horizontalBox_4;
	private JScrollPane scrollPane_1;
	private JTable tabla_ProductosMedios;
	private JPanel panelLbMultConstante;
	private JLabel lblNewLabel_7;
	private JPanel panelOperacionesMultConstante;
	private Box horizontalBox_5;
	private JLabel lblNewLabel_8;
	private JTextField txf_semilla_Constantemult;
	private Component horizontalStrut_6;
	private JLabel lblNewLabel_9;
	private JTextField txf_ConstanteMult;
	private Box horizontalBox_6;
	private Component verticalStrut_3;
	private JLabel lblNewLabel_10;
	private JTextField txf_cantidadNums_ConstanteMult;
	private Component horizontalStrut_7;
	private JButton btn_generar_constanteMult;
	private Component horizontalStrut_8;
	private JButton btn_limpiar_tablaConstanteMult;
	private Box horizontalBox_7;
	private JScrollPane scrollPane_2;
	private JTable tabla_ConstanteMult;
	private Component verticalStrut_4;
	private JPanel panelBotonAnalisisCuadradosMedios;
	private JButton btn_analisarCuadradosMedios;
	private JPanel panelBotonAnalisisProductosMedios;
	private JButton btn_analisisProductosMedios;
	private JPanel panelBotonAnalisisMultiplicador;
	private JButton btn_analisisMultiplicador;

	/**
	 * Create the frame.
	 */
	public FormNumerosAleatorios() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormNumerosAleatorios.class.getResource("/com/simulacion/app/recursos/simulacion-de-empresa-metodologia.png")));
		setTitle("Numeros Pseudo Aleatorios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 460);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(new BorderLayout(0, 0));

		panelBarraDeMenu = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelBarraDeMenu.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelPrincipal.add(panelBarraDeMenu, BorderLayout.NORTH);

		menuOpciones = new JMenuBar();
		panelBarraDeMenu.add(menuOpciones);

		menuMetodos = new JMenu("Numeros aleatorios");
		menuOpciones.add(menuMetodos);

		panelNumerosAleatorios = new JPanel();
		panelPrincipal.add(panelNumerosAleatorios, BorderLayout.CENTER);
		panelNumerosAleatorios.setLayout(new CardLayout(0, 0));

		panelCuadradosMedios = new JPanel();
		panelCuadradosMedios.setBackground(SystemColor.menu);
		panelNumerosAleatorios.add(panelCuadradosMedios, "cuadradosMedios");
		panelCuadradosMedios.setLayout(new BorderLayout(0, 0));

		panelLbCuadradosMedios = new JPanel();
		panelCuadradosMedios.add(panelLbCuadradosMedios, BorderLayout.NORTH);

		lblNewLabel = new JLabel("Numeros aleatorios por el método de cuadrados medios");
		lblNewLabel.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 17));
		panelLbCuadradosMedios.add(lblNewLabel);

		panelOperacionesCuadradosMEdios = new JPanel();
		panelCuadradosMedios.add(panelOperacionesCuadradosMEdios, BorderLayout.CENTER);
		panelOperacionesCuadradosMEdios.setLayout(new BoxLayout(panelOperacionesCuadradosMEdios, BoxLayout.Y_AXIS));

		horizontalBox = Box.createHorizontalBox();
		panelOperacionesCuadradosMEdios.add(horizontalBox);

		lblNewLabel_1 = new JLabel("Semilla de generación");
		horizontalBox.add(lblNewLabel_1);

		txf_Semilla = new JTextField();
		txf_Semilla.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		txf_Semilla.setMaximumSize(new Dimension(2147483647, 20));
		horizontalBox.add(txf_Semilla);
		txf_Semilla.setColumns(10);

		horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalBox.add(horizontalStrut_1);

		btn_generar_cuadradosMedios = new JButton("Generar");
		btn_generar_cuadradosMedios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarNumerosCuadradosMedios(Integer.parseInt(txf_Semilla.getText()),
						Integer.parseInt(txf_cantidadNumeros.getText()));
			}
		});

		lblNewLabel_2 = new JLabel("Cantidad");
		horizontalBox.add(lblNewLabel_2);

		txf_cantidadNumeros = new JTextField();
		txf_cantidadNumeros.setMaximumSize(new Dimension(2147483647, 20));
		horizontalBox.add(txf_cantidadNumeros);
		txf_cantidadNumeros.setColumns(10);

		horizontalStrut_4 = Box.createHorizontalStrut(20);
		horizontalBox.add(horizontalStrut_4);
		horizontalBox.add(btn_generar_cuadradosMedios);

		horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalBox.add(horizontalStrut_2);

		btn_limpiar_tablaCuadradosMedios = new JButton("Limpiar");
		btn_limpiar_tablaCuadradosMedios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarTabla(modelCuadradosMedios, tabla_CuadradosMedios);
			}
		});
		horizontalBox.add(btn_limpiar_tablaCuadradosMedios);

		verticalStrut = Box.createVerticalStrut(20);
		panelOperacionesCuadradosMEdios.add(verticalStrut);

		horizontalBox_1 = Box.createHorizontalBox();
		panelOperacionesCuadradosMEdios.add(horizontalBox_1);

		scrollPane = new JScrollPane();
		horizontalBox_1.add(scrollPane);

		tabla_CuadradosMedios = new JTable();
		tabla_CuadradosMedios.setModel(modelCuadradosMedios);
		scrollPane.setViewportView(tabla_CuadradosMedios);

		panelBotonAnalisisCuadradosMedios = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelBotonAnalisisCuadradosMedios.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panelCuadradosMedios.add(panelBotonAnalisisCuadradosMedios, BorderLayout.SOUTH);

		btn_analisarCuadradosMedios = new JButton("Analizar");
		btn_analisarCuadradosMedios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Object[] obj = new Object[tabla_CuadradosMedios.getRowCount()];

				for (int i = 0; i < obj.length; i++) {
					obj[i] = tabla_CuadradosMedios.getValueAt(i, 2);
				}

				EventQueue.invokeLater(new Runnable() {

					@Override
					public void run() {
						try {
							FormAnalisisEstadistico fr = new FormAnalisisEstadistico(obj);
							fr.setVisible(true);
						} catch (Exception er) {
							er.printStackTrace();
							JOptionPane.showMessageDialog(null, er.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}

					}
				});
			}
		});
		panelBotonAnalisisCuadradosMedios.add(btn_analisarCuadradosMedios);

		modelCuadradosMedios.addColumn("Semilla");
		modelCuadradosMedios.addColumn("D digitos");
		modelCuadradosMedios.addColumn("ri num aleatorio");

		panelProductosMedios = new JPanel();
		panelProductosMedios.setBackground(SystemColor.menu);
		panelNumerosAleatorios.add(panelProductosMedios, "productosMedios");
		panelProductosMedios.setLayout(new BorderLayout(0, 0));

		panel_lbProductosMedios = new JPanel();
		panelProductosMedios.add(panel_lbProductosMedios, BorderLayout.NORTH);

		lblNewLabel_3 = new JLabel("Numeros aleatorios por el metodo de productos medios");
		lblNewLabel_3.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		panel_lbProductosMedios.add(lblNewLabel_3);

		panelOperacionesProductosMedios = new JPanel();
		panelProductosMedios.add(panelOperacionesProductosMedios, BorderLayout.CENTER);
		panelOperacionesProductosMedios.setLayout(new BoxLayout(panelOperacionesProductosMedios, BoxLayout.Y_AXIS));

		horizontalBox_2 = Box.createHorizontalBox();
		panelOperacionesProductosMedios.add(horizontalBox_2);

		lblNewLabel_4 = new JLabel("Semilla 1");
		horizontalBox_2.add(lblNewLabel_4);

		txf_Semilla1 = new JTextField();
		txf_Semilla1.setColumns(10);
		horizontalBox_2.add(txf_Semilla1);

		horizontalStrut = Box.createHorizontalStrut(20);
		horizontalBox_2.add(horizontalStrut);

		lblNewLabel_5 = new JLabel("Semilla 2");
		horizontalBox_2.add(lblNewLabel_5);

		txf_Semilla2 = new JTextField();
		txf_Semilla2.setColumns(10);
		horizontalBox_2.add(txf_Semilla2);

		verticalStrut_1 = Box.createVerticalStrut(5);
		panelOperacionesProductosMedios.add(verticalStrut_1);

		horizontalBox_3 = Box.createHorizontalBox();
		panelOperacionesProductosMedios.add(horizontalBox_3);

		lblNewLabel_6 = new JLabel("Cantidad ");
		horizontalBox_3.add(lblNewLabel_6);

		txf_totalNumerosMult = new JTextField();
		horizontalBox_3.add(txf_totalNumerosMult);
		txf_totalNumerosMult.setColumns(10);

		horizontalStrut_3 = Box.createHorizontalStrut(20);
		horizontalBox_3.add(horizontalStrut_3);

		btn_generar_productosMedios = new JButton("Generar");
		btn_generar_productosMedios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarNumerosProductosMedios(Integer.parseInt(txf_Semilla1.getText()),
						Integer.parseInt(txf_Semilla2.getText()), Integer.parseInt(txf_totalNumerosMult.getText()));
			}
		});
		horizontalBox_3.add(btn_generar_productosMedios);

		horizontalStrut_5 = Box.createHorizontalStrut(20);
		horizontalBox_3.add(horizontalStrut_5);

		btn_limpiar_tablaProductosMEdios = new JButton("Limpiar");
		btn_limpiar_tablaProductosMEdios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarTabla(modelProductosMedios, tabla_ProductosMedios);
			}
		});
		horizontalBox_3.add(btn_limpiar_tablaProductosMEdios);

		verticalStrut_2 = Box.createVerticalStrut(20);
		panelOperacionesProductosMedios.add(verticalStrut_2);

		horizontalBox_4 = Box.createHorizontalBox();
		panelOperacionesProductosMedios.add(horizontalBox_4);

		scrollPane_1 = new JScrollPane();
		horizontalBox_4.add(scrollPane_1);

		tabla_ProductosMedios = new JTable();
		tabla_ProductosMedios.setModel(modelProductosMedios);

		modelProductosMedios.addColumn("Semilla 1");
		modelProductosMedios.addColumn("Semilla 2");
		modelProductosMedios.addColumn("D digitos");
		modelProductosMedios.addColumn("ri Num aleatorio");

		scrollPane_1.setViewportView(tabla_ProductosMedios);

		panelBotonAnalisisProductosMedios = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panelBotonAnalisisProductosMedios.getLayout();
		flowLayout_3.setAlignment(FlowLayout.RIGHT);
		panelProductosMedios.add(panelBotonAnalisisProductosMedios, BorderLayout.SOUTH);

		btn_analisisProductosMedios = new JButton("Analizar");
		btn_analisisProductosMedios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Object[] obj = new Object[tabla_ProductosMedios.getRowCount()];

				for (int i = 0; i < obj.length; i++) {
					obj[i] = tabla_ProductosMedios.getValueAt(i, 3);
				}

				EventQueue.invokeLater(new Runnable() {

					@Override
					public void run() {
						try {
							FormAnalisisEstadistico fr = new FormAnalisisEstadistico(obj);
							fr.setVisible(true);
						} catch (Exception er) {
							er.printStackTrace();
							JOptionPane.showMessageDialog(null, er.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}

					}
				});

			}
		});
		panelBotonAnalisisProductosMedios.add(btn_analisisProductosMedios);

		panelConstanteMult = new JPanel();
		panelConstanteMult.setBackground(new Color(240, 240, 240));
		panelNumerosAleatorios.add(panelConstanteMult, "constanteMult");
		panelConstanteMult.setLayout(new BorderLayout(0, 0));

		panelLbMultConstante = new JPanel();
		panelConstanteMult.add(panelLbMultConstante, BorderLayout.NORTH);

		lblNewLabel_7 = new JLabel("Numeros aleatorios por el método de multiplicador constante");
		lblNewLabel_7.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 17));
		panelLbMultConstante.add(lblNewLabel_7);

		panelOperacionesMultConstante = new JPanel();
		panelConstanteMult.add(panelOperacionesMultConstante, BorderLayout.CENTER);
		panelOperacionesMultConstante.setLayout(new BoxLayout(panelOperacionesMultConstante, BoxLayout.Y_AXIS));

		horizontalBox_5 = Box.createHorizontalBox();
		panelOperacionesMultConstante.add(horizontalBox_5);

		lblNewLabel_8 = new JLabel("Semilla");
		horizontalBox_5.add(lblNewLabel_8);

		txf_semilla_Constantemult = new JTextField();
		horizontalBox_5.add(txf_semilla_Constantemult);
		txf_semilla_Constantemult.setColumns(10);

		horizontalStrut_6 = Box.createHorizontalStrut(20);
		horizontalBox_5.add(horizontalStrut_6);

		lblNewLabel_9 = new JLabel("Constante");
		horizontalBox_5.add(lblNewLabel_9);

		txf_ConstanteMult = new JTextField();
		horizontalBox_5.add(txf_ConstanteMult);
		txf_ConstanteMult.setColumns(10);

		verticalStrut_3 = Box.createVerticalStrut(5);
		panelOperacionesMultConstante.add(verticalStrut_3);

		horizontalBox_6 = Box.createHorizontalBox();
		panelOperacionesMultConstante.add(horizontalBox_6);

		lblNewLabel_10 = new JLabel("Cantidad");
		horizontalBox_6.add(lblNewLabel_10);

		txf_cantidadNums_ConstanteMult = new JTextField();
		horizontalBox_6.add(txf_cantidadNums_ConstanteMult);
		txf_cantidadNums_ConstanteMult.setColumns(10);

		horizontalStrut_7 = Box.createHorizontalStrut(20);
		horizontalBox_6.add(horizontalStrut_7);

		btn_generar_constanteMult = new JButton("Generar");
		btn_generar_constanteMult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarNumerosConstateMult(Integer.parseInt(txf_ConstanteMult.getText()),
						Integer.parseInt(txf_ConstanteMult.getText()),
						Integer.parseInt(txf_cantidadNums_ConstanteMult.getText()));
			}
		});
		horizontalBox_6.add(btn_generar_constanteMult);

		horizontalStrut_8 = Box.createHorizontalStrut(20);
		horizontalBox_6.add(horizontalStrut_8);

		btn_limpiar_tablaConstanteMult = new JButton("Limpiar");
		btn_limpiar_tablaConstanteMult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarTabla(modelConstanteMultiplicadora, tabla_ConstanteMult);
			}
		});
		horizontalBox_6.add(btn_limpiar_tablaConstanteMult);

		verticalStrut_4 = Box.createVerticalStrut(20);
		panelOperacionesMultConstante.add(verticalStrut_4);

		horizontalBox_7 = Box.createHorizontalBox();
		panelOperacionesMultConstante.add(horizontalBox_7);

		scrollPane_2 = new JScrollPane();
		horizontalBox_7.add(scrollPane_2);

		tabla_ConstanteMult = new JTable();
		tabla_ConstanteMult.setModel(modelConstanteMultiplicadora);

		modelConstanteMultiplicadora.addColumn("Semilla");
		modelConstanteMultiplicadora.addColumn("Constante");
		modelConstanteMultiplicadora.addColumn("D digitos");
		modelConstanteMultiplicadora.addColumn("ri num aleatorio");

		scrollPane_2.setViewportView(tabla_ConstanteMult);

		panelBotonAnalisisMultiplicador = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panelBotonAnalisisMultiplicador.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		panelConstanteMult.add(panelBotonAnalisisMultiplicador, BorderLayout.SOUTH);

		btn_analisisMultiplicador = new JButton("Analizar");
		btn_analisisMultiplicador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] obj = new Object[tabla_ConstanteMult.getRowCount()];

				for (int i = 0; i < obj.length; i++) {
					obj[i] = tabla_ConstanteMult.getValueAt(i, 3);
				}

				EventQueue.invokeLater(new Runnable() {

					@Override
					public void run() {
						try {
							FormAnalisisEstadistico fr = new FormAnalisisEstadistico(obj);
							fr.setVisible(true);
						} catch (Exception er) {
							er.printStackTrace();
							JOptionPane.showMessageDialog(null, er.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}

					}
				});
			}
		});
		panelBotonAnalisisMultiplicador.add(btn_analisisMultiplicador);

		opcionCuadradosMedios = new JMenuItem("Cuadrados Medios");
		opcionCuadradosMedios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CardLayout cr = (CardLayout) (panelNumerosAleatorios.getLayout());
				cr.show(panelNumerosAleatorios, "cuadradosMedios");
				panelNumerosAleatorios.updateUI();

			}
		});

		menuMetodos.add(opcionCuadradosMedios);

		opcionProductosMedios = new JMenuItem("Productos Medios");
		opcionProductosMedios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CardLayout cr = (CardLayout) (panelNumerosAleatorios.getLayout());
				cr.show(panelNumerosAleatorios, "productosMedios");
				panelNumerosAleatorios.updateUI();

			}
		});
		menuMetodos.add(opcionProductosMedios);

		opcionConstanteMult = new JMenuItem("Constante Multiplicativa");
		opcionConstanteMult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CardLayout cr = (CardLayout) (panelNumerosAleatorios.getLayout());
				cr.show(panelNumerosAleatorios, "constanteMult");
				panelNumerosAleatorios.updateUI();

			}
		});
		menuMetodos.add(opcionConstanteMult);

		this.pack();
	}

	/**
	 * se generan los numeros psudoaleatorios mediante el método de cuadrados medios
	 * y se llena la tabla con los datos obtenidos
	 * 
	 * @param semilla      semilla inicial para proceso
	 * @param totalNumeros total de numeros a generar
	 */
	private void generarNumerosCuadradosMedios(int semilla, int totalNumeros) {

		if (this.camposVaciosCuadradosMedios() == true) {
			JOptionPane.showMessageDialog(this, "No deje campos vacios", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		} else {

			this.limpiarTabla(modelCuadradosMedios, tabla_CuadradosMedios);
			com.simulacion.app.random.RandomNumbers rnd = new RandomNumbers();
			rnd.setPrimSeed(semilla);
			rnd.setTotalNumbers(totalNumeros);

			ArrayList<Object[]> lista = rnd.cuadradoMedio();

			lista.stream().forEach((Object[] s) -> {
				modelCuadradosMedios.addRow(s);
			});

		}

	}

	/**
	 * se generan los numeros psudoaleatorios mediante el método de productos medios
	 * y se llena la tabla con los datos obtenidos
	 * 
	 * @param semilla1     semilla inicial para proceso
	 * @param semilla2     semilla secundaria para proceso
	 * @param totalNumeros total de numeros a generar
	 */
	private void generarNumerosProductosMedios(int semilla1, int semilla2, int cantidad) {

		if (this.camposVaciosProductosMedios() == true) {
			JOptionPane.showMessageDialog(this, "No deje campos vacios", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			this.limpiarTabla(modelProductosMedios, tabla_ProductosMedios);
			com.simulacion.app.random.RandomNumbers rnd = new RandomNumbers();
			rnd.setPrimSeed(semilla1);
			rnd.setSecondSeed(semilla2);
			rnd.setTotalNumbers(cantidad);

			ArrayList<Object[]> lista = rnd.productosMedios();

			lista.stream().forEach((Object[] s) -> {
				modelProductosMedios.addRow(s);
			});
		}

	}

	/**
	 * se generan los numeros psudoaleatorios mediante el método de multiplicador
	 * constante y se llena la tabla con los datos obtenidos
	 * 
	 * @param semilla   semilla inicial para proceso
	 * @param constante numero constante multiplicador de cada iteración
	 * @param cantidad  cantidad total de numeros a generar;
	 */
	private void generarNumerosConstateMult(int semilla, int constante, int cantidad) {

		this.limpiarTabla(modelConstanteMultiplicadora, tabla_ConstanteMult);
		com.simulacion.app.random.RandomNumbers rnd = new RandomNumbers();

		rnd.setPrimSeed(semilla);
		rnd.setMultConstant(constante);
		rnd.setTotalNumbers(cantidad);

		ArrayList<Object[]> lista = rnd.multiplicadorConstante();

		lista.stream().forEach((Object[] s) -> {
			modelConstanteMultiplicadora.addRow(s);
		});
	}

	/**
	 * borra todos los datos de la tabla
	 */
	private void limpiarTabla(DefaultTableModel modelo, JTable tabla) {
		modelo.getDataVector().removeAllElements();
		tabla.updateUI();
	}

	/**
	 * valida que no existan campos vacios al momento de empezar a trabajar en el
	 * panel de lo numeros aleatorios mediante el método de cuadrados medios
	 * 
	 * @return true, si uno o mas campos están vacios
	 */
	private boolean camposVaciosCuadradosMedios() {
		if (this.txf_Semilla.getText().isEmpty() || this.txf_cantidadNumeros.getText().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * valida que no existan campos vacios al momento de empezar a trabajar en el
	 * panel de los numeros aleatorios mediante el método de cuadrados medios
	 * 
	 * @return true, si uno o mas campos están vacios
	 */
	private boolean camposVaciosProductosMedios() {
		if (this.txf_Semilla1.getText().isEmpty() || this.txf_Semilla2.getText().isEmpty()
				|| this.txf_totalNumerosMult.getText().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
