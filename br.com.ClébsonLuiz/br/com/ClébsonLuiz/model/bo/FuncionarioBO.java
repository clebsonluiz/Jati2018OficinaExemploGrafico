package br.com.ClébsonLuiz.model.bo;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import br.com.ClébsonLuiz.model.vo.FuncionarioVO;
import br.com.ClébsonLuiz.model.vo.VendaVO;

public class FuncionarioBO {

	
	
	public static CategoryDataset categoryDataSet1(FuncionarioVO funcionario) { 
		DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
		
		for(VendaVO venda: funcionario.OrdenarValores())
			dataSet.addValue(venda.getValor_Venda(), venda.getData_Venda(), "");		
		return dataSet;
	}
	
	public static PieDataset pieDataSet(FuncionarioVO funcionario) {
		DefaultPieDataset dataSet = new DefaultPieDataset();
		
		for(VendaVO venda: funcionario.OrdenarValores())
			dataSet.setValue(venda.getData_Venda(), venda.getValor_Venda());
		return dataSet;
	}
	
	public static CategoryDataset categoryDataSetLinha(FuncionarioVO funcionario) {
		
		DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
		
		for(VendaVO venda: funcionario.OrdenarValores())
			dataSet.addValue(venda.getValor_Venda(),
					funcionario.getNome(),
					venda.getData_Venda());		
		return dataSet;
	}
	
}
