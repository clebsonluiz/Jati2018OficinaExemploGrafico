package br.edu.JFreeChart.app;

import br.edu.JFreeChart.controll.Controll;
import br.edu.JFreeChart.model.BD;
import br.edu.JFreeChart.model.Dado;
import br.edu.JFreeChart.model.DadoQualitativo;
import br.edu.JFreeChart.model.Tabela;
import br.edu.JFreeChart.view.Janela;

public class App {

	public static void main(String[] args) {
		
		
		
		try {
		    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            javax.swing.UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
		    java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		
		Janela janela = new Janela();	
		
		BD bd = new BD();
		
		
		bd.add(new DadoQualitativo("Período 1", 5.5, "Sony"));
		bd.add(new DadoQualitativo("Período 2", 7.5, "Sony"));
		bd.add(new DadoQualitativo("Período 3", 7.9, "Sony"));
		
		bd.add(new DadoQualitativo("Período 1", 6.0, "Microsoft"));
		bd.add(new DadoQualitativo("Período 2", 7.0, "Microsoft"));
		bd.add(new DadoQualitativo("Período 3", 8.0, "Microsoft"));
		
		bd.add(new DadoQualitativo("Período 1", 7.5, "Apple"));
		bd.add(new DadoQualitativo("Período 2", 8.5, "Apple"));
		bd.add(new DadoQualitativo("Período 3", 8.9, "Apple"));
		
		bd.add(new DadoQualitativo("Período 1", 7.5, "Samsung"));
		bd.add(new DadoQualitativo("Período 2", 8.5, "Samsung"));
		bd.add(new DadoQualitativo("Período 3", 8.9, "Samsung"));
		
		
		double media = 0;
		for(Dado dado: bd.getDados())
			media+=dado.getValor();
		media = (int)(media/(double)bd.getDados().size());
		
		bd.add(new DadoQualitativo("Media Minima", media, ""));
		
		
		Tabela tabela = new Tabela(bd.getDados());
		Controll controll = new Controll(janela, tabela, bd);
		controll.controll();
		controll.add();
	}
	
}
