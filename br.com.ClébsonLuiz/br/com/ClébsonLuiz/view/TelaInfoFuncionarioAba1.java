package br.com.ClébsonLuiz.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Component;

import javax.swing.JCheckBox;

public class TelaInfoFuncionarioAba1 extends JPanel {
	private JTextField nomeField;
	private JTextField rgField;
	private JTextField cpfField;
	private JTextField loginField;
	private JTextField senhaField;
	private JTextField estadoCivilField;
	private JTextField sexoField;
	private JTextField cargoField;
	private JTextField estabelecimentoField;
	private JTextField regDesempenhoField;

	/**
	 * Create the panel.
	 */
	public TelaInfoFuncionarioAba1(String[] valores) {
		setLayout(null);
		setBackground(Utils.verdeLimao);
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 21, 46, 14);
		add(lblNome);
		
		nomeField = new JTextField(valores[0]);
		nomeField.setBounds(66, 18, 331, 20);
		
		add(nomeField);
		nomeField.setColumns(10);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(10, 46, 46, 14);
		add(lblRg);
		
		rgField = new JTextField(valores[1]);
		rgField.setBounds(66, 43, 124, 20);
		add(rgField);
		rgField.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 71, 46, 14);
		add(lblCpf);
		
		cpfField = new JTextField(valores[2]);
		cpfField.setBounds(66, 68, 124, 20);
		add(cpfField);
		cpfField.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(210, 46, 46, 14);
		add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(210, 71, 46, 14);
		add(lblSenha);
		
		loginField = new JTextField(valores[3]);
		loginField.setBounds(266, 43, 131, 20);
		add(loginField);
		loginField.setColumns(10);
		
		senhaField = new JTextField(valores[4]);
		senhaField.setBounds(266, 68, 131, 20);
		add(senhaField);
		senhaField.setColumns(10);
		
		JLabel lblEstadoCivil = new JLabel("Estado Civil:");
		lblEstadoCivil.setBounds(10, 127, 82, 14);
		add(lblEstadoCivil);
		
		estadoCivilField = new JTextField(valores[5]);
		estadoCivilField.setBounds(88, 124, 100, 20);
		add(estadoCivilField);
		estadoCivilField.setColumns(10);
		
		sexoField = new JTextField(valores[6]);
		sexoField.setBounds(66, 96, 124, 20);
		add(sexoField);
		sexoField.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(10, 99, 46, 14);
		add(lblSexo);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(10, 152, 46, 14);
		add(lblCargo);
		
		cargoField = new JTextField(valores[7]);
		cargoField.setBounds(66, 149, 124, 20);
		add(cargoField);
		cargoField.setColumns(10);
		
		estabelecimentoField = new JTextField(valores[8]);
		estabelecimentoField.setBounds(10, 181, 180, 20);
		add(estabelecimentoField);
		estabelecimentoField.setColumns(10);
		
		JLabel lblRegistraDesempenhoPor = new JLabel("Registra Desempenho por Vendas: ");
		lblRegistraDesempenhoPor.setBounds(10, 212, 233, 14);
		add(lblRegistraDesempenhoPor);
		
		regDesempenhoField = new JTextField(valores[9]);
		regDesempenhoField.setBounds(210, 209, 46, 20);
		add(regDesempenhoField);
		regDesempenhoField.setColumns(10);

		for(Component c: getComponents())
			if(c instanceof JTextField) ((JTextField)c).setEditable(false);
	}
}
