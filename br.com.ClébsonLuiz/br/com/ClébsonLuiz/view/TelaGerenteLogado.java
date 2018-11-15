package br.com.ClébsonLuiz.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PolarPlot;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.JButton;

public class TelaGerenteLogado extends JPanel {
	private JTable table;
	private DefaultTableModel dataModel;
	private String[] estabelecimentos;
	private JComboBox<String> comboBox;
	private static final String[] colunas = { "Funcionario", "Cargo" };
	private Botao btnCadastrarEstabelecimento;

	private Botao btnInfo;

	private Botao btnCadastrarFuncionario;

	private Botao btnDeletarFuncionario;

	private  XYSeriesCollection series;
	
	
	public XYSeriesCollection getSeries() {
		return series;
	}

	private Polar plot;
	
	public Polar getPlot() {
		return plot;
	}
	
	public TelaGerenteLogado(String[] estabelecimentos, JPanel grafico, XYSeriesCollection series, String[][] linhas) {
		this.series = series;
		
		JFreeChart chart =(JFreeChart) ((ChartPanel)grafico).getChart();
		plot = (Polar)chart.getPlot();
		setLayout(new BorderLayout(0, 0));
		setPreferredSize(new Dimension(800, 600));
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBackground(Utils.verdeLimao);
		splitPane.setDividerLocation(400);
		splitPane.setEnabled(false);
		add(splitPane, BorderLayout.CENTER);

		JPanel panel = new JPanel(new BorderLayout(40, 20));
		
		panel.setBackground(Utils.verdeLimao);
		
		panel.add(grafico, BorderLayout.CENTER);
		panel.setPreferredSize(new Dimension(400, 600));
		splitPane.setRightComponent(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Utils.verdeLimao);
		panel_1.setPreferredSize(new Dimension(400, 600));
		panel_1.setLayout(new BorderLayout(40, 20));

		splitPane.setLeftComponent(panel_1);

		comboBox = new JComboBox<String>();

		addEstabelecimentos(estabelecimentos);

		panel_1.add(comboBox, BorderLayout.NORTH);

		

		JPanel panel_2 = new JPanel();
		
		panel_2.setBackground(Utils.verdeLimao);
		
		panel_2.setPreferredSize(new Dimension(100, 70));
		panel_1.add(panel_2, BorderLayout.SOUTH);

		btnCadastrarEstabelecimento = new Botao("Cadastrar Estabelecimento");
		panel_2.add(btnCadastrarEstabelecimento);

		btnInfo = new Botao("Info");
		panel_2.add(btnInfo);

		btnCadastrarFuncionario = new Botao("Cadastrar Funcionario");
		panel_2.add(btnCadastrarFuncionario);

		btnDeletarFuncionario = new Botao("Deletar Funcionario");
		panel_2.add(btnDeletarFuncionario);
		
		
		dataModel = new DefaultTableModel(linhas, colunas);
		table = new JTable(dataModel);
		JScrollPane scroll = new JScrollPane(table);
		panel_1.add(scroll, BorderLayout.CENTER);

	}

	public void addEstabelecimentos(String[] estabelecimentos) {
		this.estabelecimentos = estabelecimentos;
		getComboBox().removeAllItems();
		for (String s : estabelecimentos)
			getComboBox().addItem(s);
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public String[] getEstabelecimentos() {
		return estabelecimentos;
	}

	public void setEstabelecimentos(String[] estabelecimentos) {
		this.estabelecimentos = estabelecimentos;
	}

	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox<String> comboBox) {
		this.comboBox = comboBox;
	}

	public Botao getBtnCadastrarEstabelecimento() {
		return btnCadastrarEstabelecimento;
	}

	public Botao getBtnInfo() {
		return btnInfo;
	}

	public Botao getBtnCadastrarFuncionario() {
		return btnCadastrarFuncionario;
	}

	public Botao getBtnDeletarFuncionario() {
		return btnDeletarFuncionario;
	}

	public void atualizar_TABELA(String[][] novaLinhas) {
//		DefaultTableModel dataModel = (DefaultTableModel) table.getModel();
		
		dataModel = new DefaultTableModel(novaLinhas, colunas);
		
		
		/*for(int i = 0; i< in; i++)
			dataModel.removeRow(i);
		
		for(String[] vetor: novaLinhas) 
			dataModel.addRow(vetor);	*/
		
		table.setModel(dataModel);
	}
	
}
