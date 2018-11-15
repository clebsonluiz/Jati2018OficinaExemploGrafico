package br.com.ClébsonLuiz.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;



public class JanelaLogin extends Janela {

	
	private TelaLoginGerente TelaLogin;

	public JanelaLogin()  {
		
		super("Login", 500, 300);
		this.TelaLogin = new TelaLoginGerente();
		setLayout(new BorderLayout());
		//TelaLogin.setBounds(getWidth()/5, getHeight()/4, 700, 500);
		add(TelaLogin);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public TelaLoginGerente getTelaLogin() {
		return TelaLogin;
	}
	
	
	
	
}
