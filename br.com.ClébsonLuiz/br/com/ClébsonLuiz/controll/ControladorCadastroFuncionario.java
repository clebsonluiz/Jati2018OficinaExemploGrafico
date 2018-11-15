package br.com.ClébsonLuiz.controll;

import br.com.ClébsonLuiz.model.bo.UsuarioBO;
import br.com.ClébsonLuiz.model.vo.FuncionarioVO;
import br.com.ClébsonLuiz.model.vo.GerenteVO;
import br.com.ClébsonLuiz.view.JanelaCadastroFuncionario;
import br.com.ClébsonLuiz.view.JanelaCadastroGerente;

public class ControladorCadastroFuncionario {


	private JanelaCadastroFuncionario cadastroFuncionario;
	private UsuarioBO addUsuario;
	private GerenteVO gerente;
	
	public ControladorCadastroFuncionario(
			JanelaCadastroFuncionario cadastroFuncionario,
			UsuarioBO addUsuario, GerenteVO gerente) {
		super();
		this.cadastroFuncionario = cadastroFuncionario;
		this.addUsuario = addUsuario;
		this.gerente = gerente;
		controll();
	}
	
	public void controll() {
		cadastroFuncionario.setVisible(true);
		
		cadastroFuncionario.getTela().getConfirmarButton().
		addActionListener((ActionEvent)->{
			
			String nome = cadastroFuncionario.getTela().getNomeField().getText();
			String rg = cadastroFuncionario.getTela().getRgField().getText();
			String cpf = cadastroFuncionario.getTela().getCpfField().getText();
			String login = cadastroFuncionario.getTela().getLoginField().getText();
			String senha = "";
			char[] senhaC= cadastroFuncionario.getTela().getSenhaField().getPassword();
			for(char s: senhaC)
				senha+=s;
			String estado_Civil = (String)cadastroFuncionario.getTela().getEstadoCivilComboBox().getSelectedItem();
			String sexo = (String)cadastroFuncionario.getTela().getSexoComboBox().getSelectedItem();
			String estabelecimento = (String)cadastroFuncionario.getTela().getEstabelecimentoComboBox().getSelectedItem();
			String cargo = cadastroFuncionario.getTela().getCargoField().getText();
			
			
			FuncionarioVO funcionario = new FuncionarioVO(estabelecimento, nome, rg, cpf, login, senha, estado_Civil, sexo, cargo, (cadastroFuncionario.getTela().getRdbtnSim().isSelected())? true:false);
					
			
			addUsuario.add(funcionario);
			gerente.getFuncionarios().add(funcionario);
				
			cadastroFuncionario.getTela().limparCampos();
			cadastroFuncionario.setVisible(false);
		});
		
		
		cadastroFuncionario.getTela().getCancelarButton().addActionListener((ActionEvent)->{
			cadastroFuncionario.getTela().limparCampos();
			cadastroFuncionario.setVisible(false);
		});
		
		
	}
	
}
