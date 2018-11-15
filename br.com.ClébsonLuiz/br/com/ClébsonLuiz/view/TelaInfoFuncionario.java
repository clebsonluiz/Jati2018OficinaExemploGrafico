package br.com.ClébsonLuiz.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TelaInfoFuncionario extends JPanel {
	
	private TelaFuncionarioLogadoAba1 aba1;
	private TelaFuncionarioLogadoAba2 aba2;
	private TelaInfoFuncionarioAba1 abaInfo;
	
	public TelaInfoFuncionario(String[] valores, String[][] linhas,
			JPanel barra, JPanel coluna, JPanel pizza, JPanel linha) {
		abaInfo = new TelaInfoFuncionarioAba1(valores);
		aba1 = new TelaFuncionarioLogadoAba1(linhas);
		aba2 = new TelaFuncionarioLogadoAba2(barra, coluna, pizza, linha);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		tabbedPane.add("Info", abaInfo);
		tabbedPane.add("Inserir", aba1);
		tabbedPane.add("Graficos", aba2);
		setLayout(new BorderLayout());
		add(tabbedPane, BorderLayout.CENTER);
	}

	public TelaFuncionarioLogadoAba1 getAba1() {
		return aba1;
	}

	public TelaFuncionarioLogadoAba2 getAba2() {
		return aba2;
	}

	public TelaInfoFuncionarioAba1 getAbaInfo() {
		return abaInfo;
	}

	
}
