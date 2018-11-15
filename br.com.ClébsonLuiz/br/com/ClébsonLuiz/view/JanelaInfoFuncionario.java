package br.com.ClébsonLuiz.view;

import javax.swing.JPanel;

public class JanelaInfoFuncionario extends Janela{

	private TelaInfoFuncionario info;
	
	public JanelaInfoFuncionario(
			
			String[] valores, String[][] linhas,
			JPanel barra, JPanel coluna, JPanel pizza, JPanel linha
			
			) {
		super("Funcionario", 800, 600);
		
		info = new TelaInfoFuncionario(valores, linhas, barra, coluna, pizza, linha);
		
		add(info);
		setVisible(true);
		
	}

	public TelaInfoFuncionario getInfo() {
		return info;
	}
	
	
	
}
