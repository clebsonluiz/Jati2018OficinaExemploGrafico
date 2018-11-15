package br.com.ClébsonLuiz.model.vo;

public abstract class UsuarioVO {

	private String nome;
	private String rg;
	private String cpf;
	private String login;
	private String senha;
	private String estado_Civil;
	private String sexo;
	
	public UsuarioVO() {}
	
	public UsuarioVO(String nome, String rg, String cpf, String login, String senha, String estado_Civil, String sexo) {
		super();
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.login = login;
		this.senha = senha;
		this.estado_Civil = estado_Civil;
		this.sexo = sexo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEstado_Civil() {
		return estado_Civil;
	}
	public void setEstado_Civil(String estado_Civil) {
		this.estado_Civil = estado_Civil;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	
}
