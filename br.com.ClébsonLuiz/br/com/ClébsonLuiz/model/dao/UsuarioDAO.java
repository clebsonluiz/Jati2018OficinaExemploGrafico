package br.com.ClébsonLuiz.model.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

import br.com.ClébsonLuiz.model.vo.FuncionarioVO;
import br.com.ClébsonLuiz.model.vo.GerenteVO;
import br.com.ClébsonLuiz.model.vo.UsuarioVO;
import br.com.ClébsonLuiz.model.vo.VendaVO;

public class UsuarioDAO {

	
	Class<?>[] types = new Class[]{List.class, UsuarioVO.class,
			GerenteVO.class, FuncionarioVO.class, VendaVO.class, ArrayList.class};
	
	
//	private XStream xstream = new XStream(new Dom4JDriver());
	
	private List<UsuarioVO> usuarios;
	
	public List<UsuarioVO> getUsuarios() {return usuarios;}
	
	public boolean addUsuario(UsuarioVO usuarioVO) {
		return usuarios.add(usuarioVO);
	}
	
	public boolean deletarUsuario(UsuarioVO usuarioVO) {
		return usuarios.remove(usuarioVO);
	}	
	
	public void salvar() throws Exception{
		
		try {
			
			XStream xstream = new XStream(new Dom4JDriver());
			xstream.alias("List", List.class);
			xstream.alias("Usuario", UsuarioVO.class);
			xstream.alias("Gerente", GerenteVO.class);
			xstream.alias("Funcionario", FuncionarioVO.class);
			xstream.alias("Venda", VendaVO.class);
			xstream.alias("Array", ArrayList.class);
			
			
			
			xstream.allowTypes(types);
			xstream.processAnnotations(types);
			
			
			BufferedWriter bw = new BufferedWriter(new FileWriter("xml/usuarios.xml"));
			
			
			
			bw.write(xstream.toXML(usuarios));
			bw.flush();
			bw.close();		
		} catch (IOException e) { 
			System.out.println("Falha");
		}
	
	}
	
	private static UsuarioDAO instancia;
	private UsuarioDAO() {
		usuarios = ler();
	}
	
	public static UsuarioDAO getInstance() {
		if(instancia == null) instancia = new UsuarioDAO();
		return instancia;
	}
	
	@SuppressWarnings("unchecked")
	private ArrayList<UsuarioVO> ler(){
		ArrayList<UsuarioVO> usuarios;
		try {
			
			XStream xstream = new XStream(new Dom4JDriver());
			xstream.alias("List", List.class);
			xstream.alias("Usuario", UsuarioVO.class);
			xstream.alias("Gerente", GerenteVO.class);
			xstream.alias("Funcionario", FuncionarioVO.class);
			xstream.alias("Venda", VendaVO.class);
			xstream.alias("Array", ArrayList.class);
			
			
			
			xstream.allowTypes(types);
			XStream.setupDefaultSecurity(xstream);
			
			InputStream is = getClass().
					getClassLoader().getResourceAsStream("usuarios.xml");
			
			xstream.allowTypes(types);
			BufferedReader ler = new BufferedReader(new InputStreamReader(is));
			usuarios = ((ArrayList<UsuarioVO>)xstream.fromXML(ler));
			ler.close();
			return usuarios;
		} catch (Exception e) {
			return new ArrayList<>();
		}		
	}
	
	
}
