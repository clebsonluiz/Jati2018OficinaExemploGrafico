package br.com.ClébsonLuiz.model.vo;

public class VendaVO {

	private double valor_Venda;
	private String data_Venda;
	
	
	
	public VendaVO() {}
	
	public VendaVO(double valor_Venda, String data_Venda) {
		super();
		this.valor_Venda = valor_Venda;
		this.data_Venda = data_Venda;
	}
	
	public double getValor_Venda() {
		return valor_Venda;
	}
	public void setValor_Venda(double valor_Venda) {
		this.valor_Venda = valor_Venda;
	}
	public String getData_Venda() {
		return data_Venda;
	}
	public void setData_Venda(String data_Venda) {
		this.data_Venda = data_Venda;
	}
	
}
