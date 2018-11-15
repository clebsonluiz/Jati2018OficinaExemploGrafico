package br.edu.JFreeChart.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class Tabela extends AbstractTableModel {

	private List<Dado> dados;
	private static final String colunas[] = {"Familia","Nome","Valor"};
	
	public Tabela(List<Dado> dados) {
		this.dados = dados;
	}
	
	
	public String getColumnName(int column) {
		return colunas[column];
	}
	
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return dados.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
	
		
		switch (coluna) {
		case 0:
			return ((DadoQualitativo)dados.get(linha)).superFamilia;
		case 1:
			return dados.get(linha).nome;
		case 2:
			return dados.get(linha).valor;
		}
		
		return null;
	}
	
	public void removerLinha(int linhaI) {
		dados.remove(linhaI);
		fireTableRowsDeleted(linhaI, linhaI);
		
		
	}

}
