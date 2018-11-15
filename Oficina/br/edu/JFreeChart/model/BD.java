package br.edu.JFreeChart.model;

import java.util.ArrayList;
import java.util.List;

public class BD {

	private List<Dado> dados = new ArrayList<>();
	
	public List<Dado> getDados(){ return dados;}
	

	public boolean add(DadoQualitativo dado) {
		return dados.add(dado);
	}
	
	public boolean remover(DadoQualitativo dado) {
		for(Dado d: dados)
			if(d.nome.equals(dado.nome)) return dados.remove(d);
		return false;
	}
	
	private List<Dado> getDadosFamilia(boolean bool){
		
		List<Dado> dados = new ArrayList<>();
		for(Dado d: this.dados) {
			if(((DadoQualitativo)d).superFamilia.equals("")==bool)
				dados.add(d);
		}
		return dados;
	}
	
	public List<Dado> getDadosFamilia(){
		return getDadosFamilia(false);
	}
	public List<Dado> getDadosNoFamilia(){
		return getDadosFamilia(true);
	}
}
