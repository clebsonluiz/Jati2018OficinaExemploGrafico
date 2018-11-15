package br.com.ClébsonLuiz.view;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Paint;
import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTick;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PolarAxisLocation;
import org.jfree.chart.plot.PolarPlot;
import org.jfree.chart.renderer.DefaultPolarItemRenderer;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public abstract class Graficos {

	
	
	
	public static ChartPanel graficoBarra(CategoryDataset dataSet) {
		
		JFreeChart chart = ChartFactory.
				createBarChart("Vendas Mensais do Funcionário", "Mes", "Valor de Vendas", dataSet);
		chart.setBackgroundPaint(Color.white); //Cor do Fundo do Panel
		
		CategoryPlot plot = (CategoryPlot) chart.getCategoryPlot();
		plot.setBackgroundPaint(Color.white); // Cor do fundo do Grafico
		plot.setDomainGridlinePaint(Color.BLACK); // Cor das linhas de dominio
		plot.setRangeGridlinePaint(Color.gray); // Cor das linhas de indicação numerica
		plot.setOutlineVisible(false); // linha da borda do grafico 
		plot.setOrientation(PlotOrientation.VERTICAL); // Orientação do Grafico de categoria
		
		BarRenderer renderer = (BarRenderer) plot.getRenderer(); 
		
		renderer.setBarPainter(new StandardBarPainter()); //Retira o efeito de luz nas barras
		renderer.setDrawBarOutline(true); // desenha uma linha escura envolta das barras.
		
		
		Paint[] colors = {
				
				Color.blue,      // azul
				Color.RED,      // vermolho
			    Color.GREEN,       // verde
			    Color.CYAN, // Ciano
			    Color.DARK_GRAY,       // cinza escuro
			    Color.ORANGE,       // laranja
			    Color.yellow,       // amarelo
			    Color.pink,       // rosa
				Color.MAGENTA,    // Praticamente um Roza escuro
				Color.LIGHT_GRAY // Cinza claro
		};
		
		for(int i = 0; i< colors.length; i++)
			renderer.setSeriesPaint(i, colors[i]); // define as cores das barras
		return new ChartPanel(chart);
	}
	
	
	
	public static ChartPanel graficoPizza(PieDataset pieDataSet) {
		
		JFreeChart chart = ChartFactory.
				createPieChart("Vendas Mensais do Funcionário",
						pieDataSet,
						true, //Legendas
						false, //quando passar o mouse por cima da seção do grafico
						false //Urls
						);
		
		chart.setBackgroundPaint(Color.white); // Cor de Fundo do Panel
		PiePlot plot = (PiePlot) chart.getPlot(); 
		plot.setBackgroundPaint(Color.white); // Cor do Fundo do grafico
		
		/*Defino o formato dos Labels para mostrar o valor e a porcentagem
		 * a partir do indice detro do couchetes {}, o 0 indica o meu elemento comparativo
		 * 1 indica o valor do elemento e 2 a porcentagem desse elemento
		 * correspondente a fatia do grafico*/
		PieSectionLabelGenerator labelGenerator = 
		new StandardPieSectionLabelGenerator("{0} : {1} : ({2})"); 
		
		
		
		plot.setLabelGenerator(labelGenerator); // defino o formato
		plot.setOutlineVisible(false); // Tirar a borda que recobre o grafico
		plot.setShadowPaint(Color.white);// Para deixar a sombra da mesma cor do fundo
		
		Paint[] colors = {
				
				Color.blue,      // azul
				Color.RED,      // vermolho
			    Color.GREEN,       // verde
			    Color.CYAN, // Ciano
			    Color.DARK_GRAY,       // cinza escuro
			    Color.ORANGE,       // laranja
			    Color.yellow,       // amarelo
			    Color.pink,       // rosa
				Color.MAGENTA,    // Praticamente um Roza escuro
				Color.LIGHT_GRAY // Cinza claro
		};
		
		/*1: Pego o numero de elementos no dataset
		 *2: Pego o elemento a partir do indicie 
		 *Mudo a cor que representa o elemento de comparacao*/
		for(int i = 0; i< plot.getDataset().getItemCount(); i++) // 1
			plot.setSectionPaint(
					plot.getDataset().getKey(i), // 2 
					colors[i]); 
		
		return new ChartPanel(chart);
	}
	
	
	
	public static ChartPanel graficoLinha(CategoryDataset dataSet) {
		JFreeChart chart = ChartFactory.
				createLineChart("Vendas Mensais do Funcionário", "Periodo Mensal", "Quantidade", dataSet);
		
		
		
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
	
	
	
	
	public static ChartPanel graficoPolar(XYSeriesCollection series) {
		
		
		NumberAxis axis = new NumberAxis();
		
		axis.setTickLabelsVisible(true);
		
		DefaultPolarItemRenderer renderer = new DefaultPolarItemRenderer();
		renderer.setFillComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
		
		
		Polar polar = new Polar(series, axis, renderer);
		polar.setBackgroundPaint(Color.white);
		polar.setAngleGridlinePaint(Color.BLACK);
		polar.setRadiusMinorGridlinesVisible(false);
		polar.setRadiusGridlinePaint(Color.LIGHT_GRAY);
		polar.setAxisLocation(PolarAxisLocation.NORTH_LEFT);
		
		
		JFreeChart chart = new JFreeChart("Media dos Funcionários", JFreeChart.DEFAULT_TITLE_FONT, polar, false);
		chart.setBackgroundPaint(Color.white);
		
		return new ChartPanel(chart);
	}
	
	

	
}
