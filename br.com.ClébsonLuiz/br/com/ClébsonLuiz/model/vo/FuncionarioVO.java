package br.com.ClébsonLuiz.model.vo;

import java.util.ArrayList;
import java.util.List;


public class FuncionarioVO extends UsuarioVO{

	private String estabelecimento;
	private String cargo;
	private boolean registra_Desempenho;
	private List<VendaVO> vendas;
	private double media;
	
	
	public FuncionarioVO() {}
	
	public FuncionarioVO(String estabelecimento,
						String nome,
						String rg,
						String cpf,
						String login_Funcionario,
						String senha_Funcionario,
						String estado_Civil,
						String sexo, 
						String cargo,
						boolean registra_Desempenho) {
		
		super(nome, rg, cpf, login_Funcionario, senha_Funcionario, estado_Civil, sexo);
		this.estabelecimento = estabelecimento;
		this.cargo = cargo;
		this.registra_Desempenho = registra_Desempenho;
		vendas = new ArrayList<>();
	}

	public String getCargo() {return cargo;}
	public boolean isRegistra_Desempenho() {return registra_Desempenho;}

	public String getEstabelecimento() {return estabelecimento;}
	public void setEstabelecimento(String estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public List<VendaVO> getVendas() {
		return vendas;
	}
	
	public ArrayList<VendaVO> OrdenarValores(){
		ArrayList<VendaVO> vendaTemp = null;
		vendaTemp = new ArrayList<VendaVO>();
		
		for(VendaVO dado: vendas) { // para cada dado em dados
			boolean achou = false; // sempre começa com false
			
			for(VendaVO temp: vendaTemp) { // para cada temp em dadosTemp
				
				String[] data = dado.getData_Venda().split("/");
				String mes = data[1];
				String ano = data[2];
				
				String[] data_Temp = temp.getData_Venda().split("/");
				String mes_Temp = data_Temp[1];
				String ano_Temp = data_Temp[2];
				
				if(ano_Temp.equals(ano))
					if(mes_Temp.equals(mes)) {
						double temp1 = 0, temp2 = 0;
						
						temp1 = temp.getValor_Venda();
						temp2 = dado.getValor_Venda();
						temp.setValor_Venda(temp1+temp2);
						achou = true;
					    break;
					}
				
			}
			if (!achou)  // se achou for false ele entra aqui e adiciona um novo elemento
			      vendaTemp.add(new VendaVO(dado.getValor_Venda(), dado.getData_Venda()));  
		}
		
		for(VendaVO venda: vendaTemp) {
			String[] data = venda.getData_Venda().split("/");
			venda.setData_Venda(data[1]+"/"+data[2]);
		}
		return vendaTemp;
	}

	public double getMedia() {
		double total = 0;
		for(VendaVO venda: vendas) {
			total+=venda.getValor_Venda();
		}
		media = (double)(total/(double)vendas.size());
		
		return media;
	}
	
	public String[][] linhasTabela(){
		
		String[][] linhas = new String[vendas.size()][2];
		
		for(int i = 0; i<vendas.size(); i++) {
			linhas[i][0] = vendas.get(i).getData_Venda();
			linhas[i][1] = Double.toString(vendas.get(i).getValor_Venda());
		}
		
		return linhas;
	}
		
}
