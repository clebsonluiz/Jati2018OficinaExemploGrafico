package br.com.ClébsonLuiz.view;

public class JanelaCadastroGerente extends Janela{

	private TelaCadastroGerente tela;
	
	public JanelaCadastroGerente() {
		super("Cadastro Gerente", 430, 330);
		
		tela = new TelaCadastroGerente();
		
		add(tela);
		
		setVisible(true);
				
	}

	public TelaCadastroGerente getTela() {
		return tela;
	}
	
	
	
}
