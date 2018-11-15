package br.com.ClébsonLuiz.model.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.ClébsonLuiz.model.dao.UsuarioDAO;
import br.com.ClébsonLuiz.model.vo.FuncionarioVO;
import br.com.ClébsonLuiz.model.vo.UsuarioVO;

public class UsuarioBO {

	
	public boolean add(UsuarioVO usuario) {
		if(buscar(usuario))
			return false;
		return  UsuarioDAO.getInstance().addUsuario(usuario);
	}
	
	public boolean buscar_2(UsuarioVO usuario) {
		for(UsuarioVO user: UsuarioDAO.getInstance().getUsuarios()) 
			if(user.getCpf().equals(usuario.getCpf())
					||user.getRg().equals(usuario.getRg())) return true;
		return false;			
	}
	
	
	public UsuarioVO buscar_Usuario(String login, String senha) {
		for(UsuarioVO user: UsuarioDAO.getInstance().getUsuarios()) 
			if(user.getLogin().equals(login)
					||user.getSenha().equals(senha)) return user;
		return null;			
	}
	
	
	
	public boolean buscar(UsuarioVO usuario) {
		for(UsuarioVO user: UsuarioDAO.getInstance().getUsuarios()) 
			if(user.getLogin().equals(usuario.getLogin())) return true;
		return false;			
	}
	
	public boolean remover(UsuarioVO usuario) {
		for(UsuarioVO user: UsuarioDAO.getInstance().getUsuarios()) 
			if(user.getLogin().equals(usuario.getLogin())) 
				return  UsuarioDAO.getInstance().getUsuarios().remove(user);
		return false;	
	}
	
	public static UsuarioVO getUsuario(String nome) {
		for(UsuarioVO user: UsuarioDAO.getInstance().getUsuarios()) 
			if(user.getNome().equals(nome)) 
				return user;
		return null;	
	}
	
	public static List<FuncionarioVO> getFuncionarios(){
		List<FuncionarioVO> funcionarios = new ArrayList<>();
		for(UsuarioVO user: UsuarioDAO.getInstance().getUsuarios()) 
			if(user instanceof FuncionarioVO)
				funcionarios.add((FuncionarioVO)user);
		
		return funcionarios;
	}
	
	public static List<FuncionarioVO> getFuncionariosRegistrados(){
		List<FuncionarioVO> funcionarios = new ArrayList<>();
		for(UsuarioVO user: UsuarioDAO.getInstance().getUsuarios()) 
			if(user instanceof FuncionarioVO)
				if(((FuncionarioVO)user).isRegistra_Desempenho())
					funcionarios.add((FuncionarioVO)user);
		return funcionarios;
	}
}
