package br.com.ClébsonLuiz.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;

import java.awt.Component;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;

public class TelaCadastroFuncionario extends JPanel {
	private JTextField nomeField;
	private JTextField rgField;
	private JTextField loginField;
	private JPasswordField senhaField;
	private JTextField cargoField;
	private JRadioButton rdbtnSim, rdbtnNo;
	private ButtonGroup bg;
	private JComboBox<String> estabelecimentoComboBox,  sexoComboBox, estadoCivilComboBox;
	private JFormattedTextField cpfField; 
	private Botao confirmarButton, cancelarButton;
	
	/**
	 * Create the panel.
	 */
	public TelaCadastroFuncionario(String[] estabelecimentos) {
		setLayout(null);
		
		setBackground(Utils.verdeLimao);
		
		JLabel label = new JLabel("Nome:");
		label.setBounds(10, 14, 46, 14);
		add(label);
		
		nomeField = new JTextField();
		nomeField.setColumns(10);
		nomeField.setBounds(49, 11, 340, 20);
		add(nomeField);
		
		JLabel label_1 = new JLabel("RG:");
		label_1.setBounds(10, 48, 46, 14);
		add(label_1);
		
		rgField = new JTextField();
		rgField.setColumns(10);
		rgField.setBounds(49, 45, 145, 20);
		add(rgField);
		
		sexoComboBox = new JComboBox<String>();
		sexoComboBox.addItem("Sexo");
		sexoComboBox.addItem("Masculino");
		sexoComboBox.addItem("Feminino");
		sexoComboBox.addItem("Outro");
		sexoComboBox.setBounds(201, 104, 104, 20);
		add(sexoComboBox);
		
		JLabel label_2 = new JLabel("CPF:");
		label_2.setBounds(10, 73, 46, 14);
		add(label_2);
		
		estadoCivilComboBox = new JComboBox<String>();
		estadoCivilComboBox.addItem("Estado Civil");
		estadoCivilComboBox.addItem("Solteiro(a)");
		estadoCivilComboBox.addItem("Casado(a)");
		estadoCivilComboBox.addItem("Divorciado(a)");
		estadoCivilComboBox.setBounds(49, 104, 145, 20);
		add(estadoCivilComboBox);
		
		confirmarButton = new Botao("Confirmar Cadastro");
		confirmarButton.setBounds(49, 240, 145, 23);
		add(confirmarButton);
		
		cancelarButton = new Botao("Cancelar");
		cancelarButton.setBounds(216, 240, 89, 23);
		add(cancelarButton);
		
		JLabel label_3 = new JLabel("Login:");
		label_3.setBounds(204, 48, 46, 14);
		add(label_3);
		
		loginField = new JTextField();
		loginField.setColumns(10);
		loginField.setBounds(244, 45, 145, 20);
		add(loginField);
		
		JLabel label_4 = new JLabel("Senha:");
		label_4.setBounds(205, 76, 46, 14);
		add(label_4);
		
		senhaField = new JPasswordField();
		senhaField.setBounds(244, 73, 145, 20);
		add(senhaField);
		
		estabelecimentoComboBox = new JComboBox<String>();
		estabelecimentoComboBox.setBounds(49, 135, 256, 20);
		estabelecimentoComboBox.addItem("Estabelecimento");
		for(String s: estabelecimentos)
			estabelecimentoComboBox.addItem(s);
		add(estabelecimentoComboBox);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(10, 168, 46, 14);
		add(lblCargo);
		
		cargoField = new JTextField();
		cargoField.setBounds(49, 165, 145, 20);
		add(cargoField);
		cargoField.setColumns(10);
		
		JLabel lblRegistraDesempenhoDe = new JLabel("Registra desempenho de vendas:");
		lblRegistraDesempenhoDe.setBounds(10, 204, 216, 14);
		add(lblRegistraDesempenhoDe);
		
		
		bg = new ButtonGroup();
		
		rdbtnSim = new JRadioButton("Sim");
		
		rdbtnSim.setBackground(Utils.verdeLimao);

		bg.add(rdbtnSim);
		rdbtnSim.setBounds(216, 200, 62, 23);
		add(rdbtnSim);
		
		rdbtnNo = new JRadioButton("N\u00E3o");
		
		rdbtnNo.setOpaque(false);
	
		bg.add(rdbtnNo);
		rdbtnNo.setBounds(280, 200, 109, 23);
		add(rdbtnNo);
		
		
		
		cpfField = new JFormattedTextField((Format) null);
		cpfField.setBounds(49, 73, 145, 20);
		
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

	public JTextField getCargoField() {
		return cargoField;
	}

	public JRadioButton getRdbtnSim() {
		return rdbtnSim;
	}

	public JRadioButton getRdbtnNo() {
		return rdbtnNo;
	}

	public JComboBox<String> getEstabelecimentoComboBox() {
		return estabelecimentoComboBox;
	}

	public JComboBox<String> getSexoComboBox() {
		return sexoComboBox;
	}

	public JComboBox<String> getEstadoCivilComboBox() {
		return estadoCivilComboBox;
	}

	public JFormattedTextField getCpfField() {
		return cpfField;
	}

	public Botao getConfirmarButton() {
		return confirmarButton;
	}

	public Botao getCancelarButton() {
		return cancelarButton;
	}
	
	public void limparCampos() {
		for(Component c: getComponents()) {
			if(c instanceof JTextField) ((JTextField)c).setText("");
			if(c instanceof JPasswordField) ((JPasswordField)c).setText("");
			if(c instanceof JFormattedTextField) ((JFormattedTextField)c).setText("");
		}
	}
	
}
