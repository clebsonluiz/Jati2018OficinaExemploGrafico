package br.com.ClébsonLuiz.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.text.Format;

public class TelaCadastroGerente extends JPanel {
	private JTextField nomeField;
	private JTextField rgField;
	private JTextField loginField;
	private JPasswordField senhaField;
	private JTextField estabelecimentoField;
	private Botao btnConfirmarCadastro, btnCancelar;
	private JFormattedTextField cpfField;
	private JComboBox<String> sexoComboBox;
	private JComboBox<String> estadoCivilComboBox;
	
	public TelaCadastroGerente() {
		setLayout(null);
		setBackground(Utils.verdeLimao);
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(22, 25, 46, 14);
		add(lblNome);
		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(22, 59, 46, 14);
		add(lblRg);
		
		nomeField = new JTextField();
		nomeField.setBounds(61, 22, 340, 20);
		add(nomeField);
		nomeField.setColumns(10);
		
		rgField = new JTextField();
		rgField.setBounds(61, 56, 145, 20);
		add(rgField);
		rgField.setColumns(10);
		
		sexoComboBox = new JComboBox<String>();
		sexoComboBox.setBounds(228, 56, 104, 20);
		sexoComboBox.addItem("Sexo");
		sexoComboBox.addItem("Masculino");
		sexoComboBox.addItem("Feminino");
		sexoComboBox.addItem("Outro");
		add(sexoComboBox);
		
		estadoCivilComboBox = new JComboBox<String>();
		estadoCivilComboBox.setBounds(61, 115, 145, 20);
		estadoCivilComboBox.addItem("Estado Civil");
		estadoCivilComboBox.addItem("Solteiro");
		estadoCivilComboBox.addItem("Casado");
		estadoCivilComboBox.addItem("Outro");
		
		add(estadoCivilComboBox);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(22, 146, 46, 14);
		add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(22, 171, 46, 14);
		add(lblSenha);
		
		loginField = new JTextField();
		loginField.setBounds(61, 143, 145, 20);
		add(loginField);
		loginField.setColumns(10);
		
		senhaField = new JPasswordField();
		senhaField.setBounds(61, 168, 145, 20);
		add(senhaField);
		
		JLabel lblEstabelecimento = new JLabel("Estabelecimento:");
		lblEstabelecimento.setBounds(22, 210, 130, 14);
		add(lblEstabelecimento);
		
		estabelecimentoField = new JTextField();
		estabelecimentoField.setBounds(162, 207, 239, 20);
		add(estabelecimentoField);
		estabelecimentoField.setColumns(10);
		
		btnConfirmarCadastro = new Botao("Confirmar Cadastro");
		btnConfirmarCadastro.setBounds(61, 251, 145, 23);
		add(btnConfirmarCadastro);
		
		btnCancelar = new Botao("Cancelar");
		btnCancelar.setBounds(228, 251, 89, 23);
		add(btnCancelar);
		
		JLabel label = new JLabel("CPF:");
		label.setBounds(22, 84, 36, 14);
		add(label);
		
		cpfField = new JFormattedTextField((Format) null);
		cpfField.setBounds(61, 84, 145, 20);
		add(cpfField);

	}
	public JTextField getNomeField() {
		return nomeField;
	}
	public JTextField getRgField() {
		return rgField;
	}
	public JTextField getLoginField() {
		return loginField;
	}
	public JPasswordField getSenhaField() {
		return senhaField;
	}
	public JTextField getEstabelecimentoField() {
		return estabelecimentoField;
	}
	public Botao getBtnConfirmarCadastro() {
		return btnConfirmarCadastro;
	}
	public Botao getBtnCancelar() {
		return btnCancelar;
	}
	public JFormattedTextField getCpfField() {
		return cpfField;
	}
	public JComboBox<String> getSexoComboBox() {
		return sexoComboBox;
	}
	public JComboBox<String> getEstadoCivilComboBox() {
		return estadoCivilComboBox;
	}
	
	public void limparCampos() {
		for(Component c: getComponents()) {
			if(c instanceof JTextField) ((JTextField)c).setText("");
			if(c instanceof JPasswordField) ((JPasswordField)c).setText("");
			if(c instanceof JFormattedTextField) ((JFormattedTextField)c).setText("");
		}
	}
	
}
