package br.com.ClébsonLuiz.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.data.xy.XYSeriesCollection;

public class JanelaGerenteLogado extends Janela{

	private TelaGerenteLogado tela;
	
	public JanelaGerenteLogado(String[] estabelecimentos, JPanel grafico, 
			XYSeriesCollection series,
			String[][] linhas) {
		super("Logado", 800, 400);
		tela = new TelaGerenteLogado(estabelecimentos, grafico, series, linhas);
		
		add(tela);
		setResizable(false);
		setVisible(true);
		
	}

	public TelaGerenteLogado getTela() {
		return tela;
	}
	
	
	
}
