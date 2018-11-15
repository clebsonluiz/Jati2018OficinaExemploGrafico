package br.com.ClébsonLuiz.view;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaFuncionarioLogadoAba1 extends JPanel {
	private JTable table;
	private String[][] linhas;
	private String[] colunas = {"Data", "Valor"};
	private JTextField textField;
	private Botao btnInserirValor;
	
	/**
	 * Create the panel.
	 */
	public TelaFuncionarioLogadoAba1(String[][] linhas) {
		setLayout(new GridLayout(1, 2, 0, 0));
		setBackground(Utils.verdeLimao);
		this.linhas = linhas;
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(null);
		panel.setBackground(Utils.verdeLimao);
		JLabel lblInserirVendasDo = new JLabel("Inserir Vendas do dia em R$");
		lblInserirVendasDo.setBounds(45, 36, 200, 14);
		panel.add(lblInserirVendasDo);
		
		textField = new JTextField(10);
		textField.setBounds(70, 69, 91, 20);
		panel.add(textField);
		
		btnInserirValor = new Botao("Inserir Valor");
		btnInserirValor.setBounds(60, 100, 110, 23);
		panel.add(btnInserirValor);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 20));
		
		panel_1.setBackground(Utils.verdeLimao);
		
		JLabel lblNewLabel = new JLabel("Lista de Vendas");
		lblNewLabel.setFont( new Font("Arial", Font.BOLD+Font.ITALIC, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel_1.add(lblNewLabel, BorderLayout.NORTH);
		
		table = new JTable(linhas, colunas);
		JScrollPane scrollPane = new JScrollPane(table);
		
		
		panel_1.add(scrollPane, BorderLayout.CENTER);
	}
	
	public String[][] getLinhas() {
		return linhas;
	}
	public void setLinhas(String[][] linhas) {
		this.linhas = linhas;
	}
	public JTable getTable() {
		return table;
	}
	public JTextField getTextField() {
		return textField;
	}

	public Botao getBtnInserirValor() {
		return btnInserirValor;
	}
	
	
	

}
