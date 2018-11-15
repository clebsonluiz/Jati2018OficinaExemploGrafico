package br.com.ClébsonLuiz.view;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class TelaCadastroEstabelecimento extends JPanel {
	private JTextField textField;
	private Botao btnAdd;
	/**
	 * Create the panel.
	 */
	public TelaCadastroEstabelecimento() {
		
		JLabel lblEstabelecimento = new JLabel("Nome do Estabelecimento: ");
		add(lblEstabelecimento);
		setBackground(Utils.verdeLimao);
		textField = new JTextField();
		add(textField);
		textField.setColumns(25);
		
		btnAdd = new Botao("Cadastrar");
		add(btnAdd);
		}
	
	public JTextField getTextField() {
		return textField;
	}
	public Botao getBtnAdd() {
		return btnAdd;
	}

	
	
}
