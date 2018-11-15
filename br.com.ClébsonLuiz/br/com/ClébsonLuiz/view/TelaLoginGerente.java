package br.com.ClébsonLuiz.view;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class TelaLoginGerente extends JPanel {
	private JTextField loginField;
	private JTextField senhaField;
	private Botao btnEntrar, btnCadastrarGerente;

	/**
	 * Create the panel.
	 */
	public TelaLoginGerente() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(69, 25, 330, 247);
		add(panel);
		panel.setLayout(null);
		panel.setBackground(Utils.verdeLimao);
		setBackground(Utils.verdeLimao);
		
		loginField = new JTextField();
		loginField.setBounds(117, 56, 122, 20);
		panel.add(loginField);
		loginField.setColumns(10);
		
		senhaField = new JTextField();
		senhaField.setBounds(117, 104, 122, 20);
		panel.add(senhaField);
		senhaField.setColumns(10);
		
		btnEntrar = new Botao("Entrar");
		btnEntrar.setBounds(40, 153, 89, 23);
		panel.add(btnEntrar);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(61, 107, 46, 14);
		panel.add(lblSenha);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(61, 59, 46, 14);
		panel.add(lblLogin);
		
		btnCadastrarGerente = new Botao("Cadastrar Gerente");
		btnCadastrarGerente.setBounds(139, 153, 160, 23);
		panel.add(btnCadastrarGerente);

	}

	public JTextField getLoginField() {
		return loginField;
	}

	public JTextField getSenhaField() {
		return senhaField;
	}

	public Botao getBtnEntrar() {
		return btnEntrar;
	}

	public Botao getBtnCadastrarGerente() {
		return btnCadastrarGerente;
	}
	
	
}
