package br.com.ClébsonLuiz.view;

public class JanelaCadastroFuncionario extends Janela{

	private TelaCadastroFuncionario tela;

	
	public JanelaCadastroFuncionario(String[] estabelecimentos) {
		super("Cadastro Funcionario", 430, 330);
	
		tela = new TelaCadastroFuncionario(estabelecimentos);
		add(tela);
		
		setVisible(true);
	}


	public TelaCadastroFuncionario getTela() {
		return tela;
	}
	
	
}
