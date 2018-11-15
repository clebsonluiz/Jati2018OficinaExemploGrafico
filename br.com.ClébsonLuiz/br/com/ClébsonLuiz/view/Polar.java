package br.com.ClébsonLuiz.view;

import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTick;
import org.jfree.chart.plot.PolarPlot;
import org.jfree.chart.renderer.DefaultPolarItemRenderer;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


@SuppressWarnings("serial")
public class Polar extends PolarPlot{

	private XYSeriesCollection series;
	private static final XYSeries serieSimples = new XYSeries("");
	private XYSeriesCollection seriesSimples = new XYSeriesCollection(serieSimples);
	
	public Polar(XYSeriesCollection series, NumberAxis axis, DefaultPolarItemRenderer renderer) {
		super(series,axis, renderer);
		this.series = series;
		setSeries(series);
	}
		
	public void setSeries(XYSeriesCollection series) {
		this.series = series;
		
		seriesSimples.removeAllSeries();
		
		serieSimples.clear();
		
		for(int i = 0; i< series.getSeriesCount(); i++) {
			
			serieSimples.add(((XYSeries)series.getSeries().get(i)).getDataItem(0));
		}
		seriesSimples.addSeries(serieSimples);
		super.setDataset(seriesSimples);
		refreshAngleTicks();
	}
	
		@Override
		public List<NumberTick> refreshAngleTicks(){
			List<NumberTick> ticks = new ArrayList<>();
							
			for(int i = 0; i<series.getSeriesCount(); i++) {
				XYSeries serie = (XYSeries)series.getSeries().get(i);
				
				
				if(i>=Math.round((series.getSeriesCount()/2)+0.5))
					ticks.add(
							new NumberTick(serie.getX(0).doubleValue(),
							(String)serie.getKey(),
							TextAnchor.BASELINE_RIGHT,
							TextAnchor.TOP_CENTER,
							0.0));
				else
					ticks.add(new NumberTick(serie.getX(0).doubleValue(),
							(String)serie.getKey(),
							TextAnchor.BASELINE_LEFT, TextAnchor.TOP_CENTER,
							0.0));					
				
				((DefaultPolarItemRenderer)getRenderer()).setSeriesFilled(i, true);
			}
			return ticks;
		}
		
	
	
}
