package br.com.ClébsonLuiz.controll;

import java.util.Date;

import br.com.ClébsonLuiz.model.vo.FuncionarioVO;
import br.com.ClébsonLuiz.model.vo.VendaVO;
import br.com.ClébsonLuiz.view.JanelaInfoFuncionario;

public class ControladorInfoFuncionario {

	private JanelaInfoFuncionario infoFuncionario;
	private FuncionarioVO funcionario;
	
	public ControladorInfoFuncionario(JanelaInfoFuncionario infoFuncionario, FuncionarioVO funcionario) {
		super();
		this.infoFuncionario = infoFuncionario;
		this.funcionario = funcionario;
		controll();
	}
	
	public void controll() {
		infoFuncionario.setVisible(true);
		infoFuncionario.getInfo().getAba1().getBtnInserirValor()
		.addActionListener((ActionEvent)->{
			
			Date dateAtual = new Date(System.currentTimeMillis());		
			
			String[] data = dateAtual.toString().split(" ");
			String dia = (data[2]);
			String mes  = Data.getMes(data[1]);
			String ano = (data[5]);
			
			String data_Venda = dia+"/"+mes+"/"+ano;
			
			
			double valor_Venda = Double.parseDouble(infoFuncionario.getInfo().getAba1().getTextField().getText());
			
			funcionario.getVendas().add(new VendaVO(valor_Venda, data_Venda));
			
		});
		
		infoFuncionario.getInfo().getAba2().getRdbtnBarras()
		.addItemListener((ItemEvent)->{
			infoFuncionario.getInfo().getAba2().exibirBarra();
		});
		infoFuncionario.getInfo().getAba2().getRdbtnColuna()
		.addItemListener((ItemEvent)->{
			infoFuncionario.getInfo().getAba2().exibirColuna();
		});
		infoFuncionario.getInfo().getAba2().getRdbtnPizza()
		.addItemListener((ItemEvent)->{
			infoFuncionario.getInfo().getAba2().exibirPizza();
		});
		infoFuncionario.getInfo().getAba2().getRdbtnLinha()
		.addItemListener((ItemEvent)->{
			infoFuncionario.getInfo().getAba2().exibirLinha();
		});
		
	}
	
	
}
