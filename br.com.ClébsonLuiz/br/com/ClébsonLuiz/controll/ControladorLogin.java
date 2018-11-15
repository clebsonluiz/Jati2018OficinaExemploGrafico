package br.com.ClébsonLuiz.controll;

import java.util.List;

import org.jfree.data.xy.XYSeriesCollection;

import br.com.ClébsonLuiz.model.bo.FuncionarioBO;
import br.com.ClébsonLuiz.model.bo.GerenteBO;
import br.com.ClébsonLuiz.model.bo.UsuarioBO;
import br.com.ClébsonLuiz.model.vo.FuncionarioVO;
import br.com.ClébsonLuiz.model.vo.GerenteVO;
import br.com.ClébsonLuiz.model.vo.UsuarioVO;
import br.com.ClébsonLuiz.view.Graficos;
import br.com.ClébsonLuiz.view.JanelaCadastroGerente;
import br.com.ClébsonLuiz.view.JanelaGerenteLogado;
import br.com.ClébsonLuiz.view.JanelaInfoFuncionario;
import br.com.ClébsonLuiz.view.JanelaLogin;

public class ControladorLogin {

	private JanelaLogin janelaLogin;
	private UsuarioBO usuariosCadastrados;
	
	public ControladorLogin(JanelaLogin janelaLogin, UsuarioBO usuariosCadastrados) {
		super();
		this.janelaLogin = janelaLogin;
		this.usuariosCadastrados = usuariosCadastrados;
		controll();
	}
	
	
	public void controll() {
		
		janelaLogin.getTelaLogin().getBtnEntrar().addActionListener((ActionEvent)->{
			
			
			
			UsuarioVO usuario = usuariosCadastrados.buscar_Usuario(
					janelaLogin.getTelaLogin().getLoginField().getText(),
					janelaLogin.getTelaLogin().getSenhaField().getText());
			if(usuario == null) {
				System.out.println("Nao Existe");
			}else {
				
				if(usuario instanceof GerenteVO) {
					
					
					GerenteVO gerente = (GerenteVO)usuario;
					
					String[] estabelecimentos = new String[gerente.getEstabelecimentos().size()];
					
					for(int i = 0; i<estabelecimentos.length; i++) {
						estabelecimentos[i] = gerente.getEstabelecimentos().get(i);
					}
					//MySql WorkBench
					
					List<FuncionarioVO> f = GerenteBO.mesma_Empresa(
							gerente.getFuncionarios(), estabelecimentos[0]);
					
					String[][] linhas = new String[f.size()][2];
					
					for(int i = 0; i<f.size(); i++) {
						linhas[i][0] = f.get(i).getNome();
						linhas[i][1] = f.get(i).getCargo();
					}
						
					
							
					XYSeriesCollection series = GerenteBO.xySereiesCollectionDataSet(f, estabelecimentos[0]);
					
					JanelaGerenteLogado gerenteLogado =	new JanelaGerenteLogado(
							estabelecimentos,
							Graficos.graficoPolar(series),
							series,
							linhas);
					
					new ControladorGerenteLogado(gerenteLogado, gerente, usuariosCadastrados);
					
					
				}else if(usuario instanceof FuncionarioVO){
					
					String nome_Funcionario = ((FuncionarioVO)usuario).getNome();
					String rg_Funcionario = ((FuncionarioVO)usuario).getRg();
					String cpf_Funcionario = ((FuncionarioVO)usuario).getCpf();
					String login_Funcionario = ((FuncionarioVO)usuario).getLogin();
					String senha_Funcionario = ((FuncionarioVO)usuario).getSenha();
					String estadoCivil_Funcionario = ((FuncionarioVO)usuario).getEstado_Civil();
					String sexo_Funcionario = ((FuncionarioVO)usuario).getSexo();
					String cargo_Funcionario = ((FuncionarioVO)usuario).getCargo();
					String estabelecimento_Funcionario = ((FuncionarioVO)usuario).getEstabelecimento();
					String desempenho_Funcionario = (((FuncionarioVO)usuario).isRegistra_Desempenho())? "Sim": "Nâo";
					
					String[] valores = {
						nome_Funcionario, rg_Funcionario, cpf_Funcionario,
						login_Funcionario, senha_Funcionario, estadoCivil_Funcionario,
						sexo_Funcionario, cargo_Funcionario, estabelecimento_Funcionario,
						desempenho_Funcionario
					};
					
					
					
				JanelaInfoFuncionario infoFuncionario =	new JanelaInfoFuncionario(valores,
							((FuncionarioVO)usuario).linhasTabela(),
							Graficos.graficoBarra(FuncionarioBO.categoryDataSet1(((FuncionarioVO)usuario))),
							Graficos.graficoBarra(FuncionarioBO.categoryDataSet1(((FuncionarioVO)usuario))),
							Graficos.graficoPizza(FuncionarioBO.pieDataSet(((FuncionarioVO)usuario))),
							Graficos.graficoLinha(FuncionarioBO.categoryDataSetLinha(((FuncionarioVO)usuario))));

					new ControladorInfoFuncionario(infoFuncionario, ((FuncionarioVO)usuario));
				}
				
			}
			
			

		});
		
		janelaLogin.getTelaLogin().getBtnCadastrarGerente().addActionListener((ActionEvent)->{
			
			JanelaCadastroGerente cadastroGerente = new JanelaCadastroGerente();
			
			new ControladorCadastroGerente(cadastroGerente, usuariosCadastrados);
			
		});
	}
	
	
}
