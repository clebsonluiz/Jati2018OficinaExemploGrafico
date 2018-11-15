package br.com.ClébsonLuiz.model.vo;

import java.util.ArrayList;
import java.util.List;

public class GerenteVO extends UsuarioVO{

	private List<String> estabelecimentos = new ArrayList<>();
	private List<FuncionarioVO> funcionarios = new ArrayList<>();

	public List<FuncionarioVO> getFuncionarios() {
		return funcionarios;
	}
	
	public GerenteVO() {}
	
	public GerenteVO(String nome,
					 String rg,
					 String cpf,
					 String login, 
					 String senha,
					 String estado_Civil,
					 String sexo, 
					 String estabelecimento) {
		super(nome, rg, cpf, login, senha, estado_Civil, sexo);
		estabelecimentos.add(estabelecimento);
	}

	public List<String> getEstabelecimentos() {
		return estabelecimentos;
	}

	
	public void setEstabelecimentos(List<String> estabelecimentos) {
		this.estabelecimentos = estabelecimentos;
	}

	public void setFuncionarios(List<FuncionarioVO> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	
}
