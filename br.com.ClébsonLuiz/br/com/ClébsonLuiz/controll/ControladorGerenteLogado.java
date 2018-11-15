package br.com.ClébsonLuiz.controll;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import br.com.ClébsonLuiz.model.bo.FuncionarioBO;
import br.com.ClébsonLuiz.model.bo.GerenteBO;
import br.com.ClébsonLuiz.model.bo.UsuarioBO;
import br.com.ClébsonLuiz.model.vo.FuncionarioVO;
import br.com.ClébsonLuiz.model.vo.GerenteVO;
import br.com.ClébsonLuiz.view.Graficos;
import br.com.ClébsonLuiz.view.JanelaCadastroEstabelecimento;
import br.com.ClébsonLuiz.view.JanelaCadastroFuncionario;
import br.com.ClébsonLuiz.view.JanelaGerenteLogado;
import br.com.ClébsonLuiz.view.JanelaInfoFuncionario;

public class ControladorGerenteLogado extends KeyAdapter{

	private JanelaGerenteLogado gerenteLogado;
	private GerenteVO gerente;
	private UsuarioBO addUsuario;
	private JanelaCadastroEstabelecimento cadastroEstabelecimento;

	public ControladorGerenteLogado(JanelaGerenteLogado gerenteLogado, GerenteVO gerente, 
			UsuarioBO bo) {
		super();
		this.gerenteLogado = gerenteLogado;
		this.gerente = gerente;
		this.addUsuario = bo;
		cadastroEstabelecimento = new JanelaCadastroEstabelecimento();
		controll();
	}

	public void controll() {
		
		cadastroEstabelecimento.getTela().getBtnAdd().addActionListener((ActionEvent)->{
			
			gerente.getEstabelecimentos().add(cadastroEstabelecimento.getTela().getTextField().getText());
			cadastroEstabelecimento.setVisible(false);
		});
		
		gerenteLogado.getTela().getTable().addKeyListener(this);
		
		
		gerenteLogado.getTela().getBtnCadastrarEstabelecimento().addActionListener((ActionEvent)->{
		
			cadastroEstabelecimento.setVisible(true);

		});
		
		gerenteLogado.getTela().getBtnCadastrarFuncionario().addActionListener((ActionEvent)->{
			
			String[] s = new String[gerente.getEstabelecimentos().size()];	
			
			for(int i=0; i<gerente.getEstabelecimentos().size(); i++)
				s[i] = gerente.getEstabelecimentos().get(i);
			
			new ControladorCadastroFuncionario(new JanelaCadastroFuncionario(s), addUsuario, gerente);
		});
		
		
		
		
		
		gerenteLogado.getTela().getComboBox().addItemListener((ItemEvent)->{
		
//		gerenteLogado.getTela().getComboBox().addActionListener((ActionEvent)->{
			
			
			
			
			String estabelecimento = (String)gerenteLogado.getTela().getComboBox().getSelectedItem();
			
			List<Object> obj = new ArrayList<>();
			
			for(FuncionarioVO func: gerente.getFuncionarios())				
				if(func.getEstabelecimento().equals(estabelecimento))
					obj.add(func);
			
			
			double tamanhoDataSet = obj.size();
			double grausCirgulo = 360;
			double salto = grausCirgulo/tamanhoDataSet;
			
			XYSeriesCollection series = gerenteLogado.getTela().getSeries();
			series.removeAllSeries();
			for(int i=0; i< tamanhoDataSet; i++) {
				XYSeries categoria = new XYSeries(((FuncionarioVO)obj.get(i)).getNome());
				categoria.add(i*salto, ((FuncionarioVO)obj.get(i)).getMedia());
				series.addSeries(categoria);
			}
			
			
			List<FuncionarioVO> f = GerenteBO.mesma_Empresa(
					gerente.getFuncionarios(), estabelecimento);
			
			String[][] linhas = new String[f.size()][2];
			
			for(int i = 0; i<f.size(); i++) {
				linhas[i][0] = f.get(i).getNome();
				linhas[i][1] = f.get(i).getCargo();
			}
			
			
			gerenteLogado.getTela().atualizar_TABELA(linhas);
			gerenteLogado.getTela().getPlot().setSeries(series);
			gerenteLogado.getTela().repaint();
		});
	}

	public void keyPressed(KeyEvent k) {
		
		if(k.getKeyCode() == KeyEvent.VK_ENTER) {
			
			int indice = gerenteLogado.getTela().getTable().getSelectedRow();	
			if(indice==-1) {
				System.out.println("ControladorGerenteLogado.java");
			}else {
			
					
			String nome = (String)gerenteLogado.getTela().getTable().getValueAt(indice, 0);
			
			FuncionarioVO funcionario = (FuncionarioVO)UsuarioBO.getUsuario(nome);
			
			
			String nome_Funcionario = funcionario.getNome();
			String rg_Funcionario = funcionario.getRg();
			String cpf_Funcionario = funcionario.getCpf();
			String login_Funcionario = funcionario.getLogin();
			String senha_Funcionario = funcionario.getSenha();
			String estadoCivil_Funcionario = funcionario.getEstado_Civil();
			String sexo_Funcionario = funcionario.getSexo();
			String cargo_Funcionario = funcionario.getCargo();
			String estabelecimento_Funcionario = funcionario.getEstabelecimento();
			String desempenho_Funcionario = (funcionario.isRegistra_Desempenho())? "Sim": "Nâo";
			
			String[] valores = {
				nome_Funcionario, rg_Funcionario, cpf_Funcionario,
				login_Funcionario, senha_Funcionario, estadoCivil_Funcionario,
				sexo_Funcionario, cargo_Funcionario, estabelecimento_Funcionario,
				desempenho_Funcionario
			};
			
			
			
		JanelaInfoFuncionario infoFuncionario =	new JanelaInfoFuncionario(valores,
					funcionario.linhasTabela(),
					Graficos.graficoBarra(FuncionarioBO.categoryDataSet1(funcionario)),
					Graficos.graficoBarra(FuncionarioBO.categoryDataSet1(funcionario)),
					Graficos.graficoPizza(FuncionarioBO.pieDataSet(funcionario)),
					Graficos.graficoLinha(FuncionarioBO.categoryDataSetLinha(funcionario)));

			new ControladorInfoFuncionario(infoFuncionario, funcionario);
		}
		
		
		}
		
		
	}

}
