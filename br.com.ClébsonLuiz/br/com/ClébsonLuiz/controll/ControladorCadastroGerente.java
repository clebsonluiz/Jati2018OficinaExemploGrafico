package br.com.ClébsonLuiz.controll;

import java.awt.event.ActionEvent;

import br.com.ClébsonLuiz.model.bo.UsuarioBO;
import br.com.ClébsonLuiz.model.dao.UsuarioDAO;
import br.com.ClébsonLuiz.model.vo.GerenteVO;
import br.com.ClébsonLuiz.view.JanelaCadastroGerente;

public class ControladorCadastroGerente {

	private JanelaCadastroGerente cadastroGerente;
	private UsuarioBO addUsuario;
	

	
	public ControladorCadastroGerente(
			JanelaCadastroGerente cadastroGerente,
			UsuarioBO addUsuario) {
		super();
		this.cadastroGerente = cadastroGerente;
		this.addUsuario = addUsuario;
		controll();
	}



	public void controll() {
		cadastroGerente.setVisible(true);
		
		cadastroGerente.getTela().getBtnConfirmarCadastro().
		addActionListener((ActionEvent)->{
			
			String nome = cadastroGerente.getTela().getNomeField().getText();
			String rg = cadastroGerente.getTela().getRgField().getText();
			String cpf = cadastroGerente.getTela().getCpfField().getText();
			String login = cadastroGerente.getTela().getLoginField().getText();
			String senha = "";
			char[] senhaC= cadastroGerente.getTela().getSenhaField().getPassword();
			for(char s: senhaC)
				senha+=s;
			String estado_Civil = (String)cadastroGerente.getTela().getEstadoCivilComboBox().getSelectedItem();
			String sexo = (String)cadastroGerente.getTela().getSexoComboBox().getSelectedItem();
			String estabelecimento = cadastroGerente.getTela().getEstabelecimentoField().getText();
			
			addUsuario.add(new GerenteVO(nome, rg, cpf, login, senha, estado_Civil, sexo, estabelecimento));
			
			cadastroGerente.getTela().limparCampos();
			cadastroGerente.setVisible(false);
		});
		
		
		cadastroGerente.getTela().getBtnCancelar().addActionListener((ActionEvent)->{
			cadastroGerente.getTela().limparCampos();
			cadastroGerente.setVisible(false);
		});
		
		
	}
	
	
}
