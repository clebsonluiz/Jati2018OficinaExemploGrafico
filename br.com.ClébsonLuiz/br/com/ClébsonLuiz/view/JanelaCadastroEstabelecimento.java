package br.com.ClébsonLuiz.view;

import java.awt.BorderLayout;

public class JanelaCadastroEstabelecimento extends Janela {

	private TelaCadastroEstabelecimento tela;
	
	public JanelaCadastroEstabelecimento() {
		super("Cadastrar Estabelecimento", 300, 120);
		
		tela = new TelaCadastroEstabelecimento();
		
		add(tela, BorderLayout.CENTER);
	}

	public TelaCadastroEstabelecimento getTela() {
		return tela;
	}

	
}
