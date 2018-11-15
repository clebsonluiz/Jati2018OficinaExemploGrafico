package br.com.ClébsonLuiz.model.bo;

import java.util.ArrayList;
import java.util.List;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import br.com.ClébsonLuiz.model.vo.FuncionarioVO;

public class GerenteBO {

	private static final List<FuncionarioVO> f = new ArrayList<>();
	
	
public static XYSeriesCollection xySereiesCollectionDataSet(List<FuncionarioVO> funcionarios,
		String estabelecimento) {
		
		List<FuncionarioVO> f = mesma_Empresa(funcionarios, estabelecimento);
		
		double tamanhoDataSet = f.size();
		double grausCirgulo = 360;
		double salto = grausCirgulo/tamanhoDataSet;
	
		XYSeriesCollection series = new XYSeriesCollection();
		
		for(int i = 0; i<f.size(); i++) {
				
			XYSeries categoria = new XYSeries(f.get(i).getNome());
			categoria.add(i*salto, f.get(i).getMedia());
			series.addSeries(categoria);
		}
					
		return series;
		
	}
	
	public static List<FuncionarioVO> mesma_Empresa(List<FuncionarioVO> funcionarios,
			String estabelecimento){
		
		f.clear();
		
		for(FuncionarioVO funcionario: funcionarios) 
			if(funcionario.getEstabelecimento().equals(estabelecimento))
				f.add(funcionario);
		
		return f;
	}
	
}

