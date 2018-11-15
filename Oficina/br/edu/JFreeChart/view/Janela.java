package br.edu.JFreeChart.view;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Paint;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class Janela extends JanelaCustomizada{

	public static DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
	public static DefaultCategoryDataset dataSet2 = new DefaultCategoryDataset();
	
	public static ChartPanel graficoBarra(CategoryDataset dataSet) {

		JFreeChart chart = ChartFactory.createBarChart("Exemplo do JFreeChart", "Categoria", "Valor", dataSet);
		chart.setBackgroundPaint(Color.white); // Cor do Fundo do Panel

		CategoryPlot plot = (CategoryPlot) chart.getCategoryPlot();
		plot.setBackgroundPaint(Color.white); // Cor do fundo do Grafico
		plot.setDomainGridlinePaint(Color.BLACK); // Cor das linhas de dominio
		plot.setRangeGridlinePaint(Color.gray); // Cor das linhas de indicação numerica
		plot.setOutlineVisible(false); // linha da borda do grafico
		plot.setOrientation(PlotOrientation.VERTICAL); // Orientação do Grafico de categoria

		BarRenderer renderer = (BarRenderer) plot.getRenderer();

		renderer.setBarPainter(new StandardBarPainter()); // Retira o efeito de luz nas barras
		renderer.setDrawBarOutline(true); // desenha uma linha escura envolta das barras.

		Paint[] colors = {

				Color.blue, // azul
				Color.RED, // vermolho
				Color.GREEN, // verde
				Color.CYAN, // Ciano
				Color.DARK_GRAY, // cinza escuro
				Color.ORANGE, // laranja
				Color.yellow, // amarelo
				Color.pink, // rosa
				Color.MAGENTA, // Praticamente um Roza escuro
				Color.LIGHT_GRAY // Cinza claro
		};

		for (int i = 0; i < colors.length; i++)
			renderer.setSeriesPaint(i, colors[i]); // define as cores das barras
		return new ChartPanel(chart);
	}
	
	public static ChartPanel graficoLinha(CategoryDataset dataSet) {
		JFreeChart chart = ChartFactory.
				createLineChart("Titulo", "Label do Eixo X", "Label do eixo Y", dataSet);
		
		
		
		chart.setBackgroundPaint(Color.WHITE);
		CategoryPlot plot = (CategoryPlot) chart.getCategoryPlot();
		plot.setBackgroundPaint(Color.white);
		plot.setRangeGridlinePaint(Color.GRAY);
		plot.setOutlineVisible(false);
		
		LineAndShapeRenderer renderer =  
				(LineAndShapeRenderer)plot.getRenderer();
		
		renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setDefaultItemLabelsVisible(true);
		renderer.setDefaultShapesVisible(true);
		
		for(int i = 0; i< plot.getDataset().getRowCount(); i++)
			renderer.setSeriesStroke(i, new BasicStroke(3.0f)); //Grossura da linha

		return new ChartPanel(chart);
	}
	
	private JSplitPane splitPane;
	
	public class Tela extends JPanel {
		private JTable table;
		private JTextField nomeField;
		private JTextField valorField;
		private JTextField familiaField;
		private JCheckBox chckbxFamilia;
		private JButton btnAdd, btnDeletar;
		private CardLayout card;
		private JRadioButton barraRadio, linhaRadio;
		private ButtonGroup bg;
		private ChartPanel linhaChart, barraChart;
		private JPanel panelCard;
		/**
		 * Create the panel.
		 */
		public Tela() {
			
			setLayout(new BorderLayout(0, 0));
			
			
			JPanel panel = new JPanel();
			add(panel, BorderLayout.NORTH);
			
			JLabel lblDado = new JLabel("Nome:");
			panel.add(lblDado);
			
			nomeField = new JTextField();
			panel.add(nomeField);
			nomeField.setColumns(10);
			
			JLabel lblValor = new JLabel("Valor:");
			panel.add(lblValor);
			
			valorField = new JTextField();
			panel.add(valorField);
			valorField.setColumns(5);
			
			chckbxFamilia = new JCheckBox("Familia");
			panel.add(chckbxFamilia);
			
			
			
			
			familiaField = new JTextField(10);
			familiaField.setEnabled(false);
			panel.add(familiaField);
			familiaField.setColumns(10);
			
			btnAdd = new JButton("Add");
			
			
			panel.add(btnAdd);
			
			btnDeletar = new JButton("Deletar");
			panel.add(btnDeletar);
			splitPane = new JSplitPane();
			splitPane.setOneTouchExpandable(false);
			splitPane.setEnabled(false);
			splitPane.setDividerLocation(250);
			add(splitPane, BorderLayout.CENTER);
			
			
			card = new CardLayout();
			JPanel panelDireito = new JPanel(new BorderLayout());
			
			barraRadio = new JRadioButton("Barra");
			barraRadio.setSelected(true);
			linhaRadio = new JRadioButton("Linha");
			bg = new ButtonGroup();
			bg.add(barraRadio);
			bg.add(linhaRadio);
			
			JPanel superiorDireito = new JPanel();
			superiorDireito.add(barraRadio);
			superiorDireito.add(linhaRadio);
			panelDireito.add(superiorDireito, BorderLayout.NORTH);
			
			barraChart = graficoBarra(dataSet);
			linhaChart = graficoLinha(dataSet2);
			
			panelCard = new JPanel(card);
			panelDireito.add(panelCard, BorderLayout.CENTER);
			panelCard.add(barraChart);
			panelCard.add(linhaChart);
			
			
			card.addLayoutComponent(barraChart, "barra");
			card.addLayoutComponent(linhaChart, "linha");
			card.show(panelCard, "barra");
			
			splitPane.setRightComponent(panelDireito);
			
			table = new JTable();
			
			splitPane.setLeftComponent(table);
			
		}
		
		
		
		public JTable getTable() {
			return table;
		}
		
		public void showLinha() {
			card.show(panelCard, "linha");
		}
		public void showBarra() {
			card.show(panelCard, "barra");
		}
		
		
		public JRadioButton getBarraRadio() {
			return barraRadio;
		}



		public JRadioButton getLinhaRadio() {
			return linhaRadio;
		}


		public ChartPanel getLinhaChart() {
			return linhaChart;
		}



		public ChartPanel getBarraChart() {
			return barraChart;
		}



		public JPanel getPanelCard() {
			return panelCard;
		}



		public void setTable(AbstractTableModel table) {
			
			splitPane.remove(this.table);
			this.table = new JTable(table);
			
			JScrollPane scroll = new JScrollPane(this.table);
			splitPane.setLeftComponent(scroll);
			
		}
		
		public JTextField getNomeField() {
			return nomeField;
		}
		
		public JTextField getValorField() {
			return valorField;
		}
		
		public JTextField getFamiliaField() {
			return familiaField;
		}
		
		public JCheckBox getChckbxFamilia() {
			return chckbxFamilia;
		}
		
		public JButton getBtnAdd() {
			return btnAdd;
		}
		
		public JButton getBtnDeletar() {
			return btnDeletar;
		}
		
		public void exibir() {
			familiaField.setEnabled(true);
			familiaField.setText("");
		}
		
		public void limpar() {
			familiaField.setEnabled(false);
			familiaField.setText("");
		}
	}
	
	
	private Tela tela;
	
	public Janela() {
		
		setSize(700,400);
		
		tela = new Tela();
		
		
		
		add(BorderLayout.CENTER, tela);
		
		
	}

	public Tela getTela() {
		return tela;
	}
	


}
