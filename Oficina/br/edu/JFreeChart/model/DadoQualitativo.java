package br.edu.JFreeChart.model;

public class DadoQualitativo extends Dado{

	protected String superFamilia = "";
	
	public DadoQualitativo(String nome, double valor) {
		super(nome, valor);
	}

	public DadoQualitativo(String nome, double valor, String superFamilia) {
		super(nome, valor);
		this.superFamilia = superFamilia;
	}

	public String getSuperFamilia() {
		return superFamilia;
	}

	public void setSuperFamilia(String superFamilia) {
		this.superFamilia = superFamilia;
	}
	
	
	
}
