package br.com.ClébsonLuiz.view;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JSplitPane;
import java.awt.CardLayout;
import javax.swing.JRadioButton;

public class TelaFuncionarioLogadoAba2 extends JPanel {

	private CardLayout card;
	private JPanel barra, coluna, pizza, linha;

	private JRadioButton rdbtnBarras, rdbtnColuna, rdbtnPizza, rdbtnLinha;
	private ButtonGroup bg;
	private JPanel panel_1;

	public TelaFuncionarioLogadoAba2(JPanel barra, JPanel coluna, JPanel pizza, JPanel linha) {
		setLayout(new GridLayout(1, 2, 0, 0));
		setBackground(Utils.verdeLimao);
		this.barra = barra;
		this.coluna = coluna;
		this.pizza = pizza;
		this.linha = linha;

		bg = new ButtonGroup();

		JSplitPane splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		splitPane.setBackground(Utils.verdeLimao);
		add(splitPane);

		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(new GridLayout(4, 1, 0, 0));
		panel.setBackground(Utils.verdeLimao);
		rdbtnBarras = new JRadioButton("Barras");
		
		panel.add(rdbtnBarras);
		
		rdbtnColuna = new JRadioButton("Coluna");
		panel.add(rdbtnColuna);

		rdbtnPizza = new JRadioButton("Pizza");
		panel.add(rdbtnPizza);

		rdbtnLinha = new JRadioButton("Linha");
		panel.add(rdbtnLinha);

		bg.add(rdbtnBarras);
		bg.add(rdbtnColuna);
		bg.add(rdbtnPizza);
		bg.add(rdbtnLinha);

		panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		panel_1.setBackground(Utils.verdeLimao);
		card = new CardLayout();

		card.addLayoutComponent(barra, "barra");
		card.addLayoutComponent(coluna, "coluna");
		card.addLayoutComponent(pizza, "pizza");
		card.addLayoutComponent(linha, "linha");
		panel_1.setLayout(card);
		panel_1.add(barra);
		panel_1.add(coluna);
		panel_1.add(pizza);
		panel_1.add(linha);

		rdbtnBarras.setOpaque(false);
		rdbtnColuna.setOpaque(false);
		rdbtnPizza.setOpaque(false);
		rdbtnLinha.setOpaque(false);
		
		
		card.show(panel_1, "barra");
	}

	public JRadioButton getRdbtnBarras() {
		return rdbtnBarras;
	}

	public JRadioButton getRdbtnColuna() {
		return rdbtnColuna;
	}

	public JRadioButton getRdbtnPizza() {
		return rdbtnPizza;
	}

	public JRadioButton getRdbtnLinha() {
		return rdbtnLinha;
	}

	public void exibirBarra() {
		card.show(panel_1, "barra");
	}

	public void exibirColuna() {
		card.show(panel_1, "coluna");
	}

	public void exibirPizza() {
		card.show(panel_1, "pizza");
	}

	public void exibirLinha() {
		card.show(panel_1, "linha");
	}

}
