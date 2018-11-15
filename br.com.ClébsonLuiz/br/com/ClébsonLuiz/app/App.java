package br.com.ClébsonLuiz.app;

import br.com.ClébsonLuiz.controll.ControladorLogin;
import br.com.ClébsonLuiz.model.bo.UsuarioBO;
import br.com.ClébsonLuiz.model.dao.UsuarioDAO;
import br.com.ClébsonLuiz.view.Janela;
import br.com.ClébsonLuiz.view.JanelaLogin;

public class App extends Thread{

	public static void main(String[] args) {
		
		try {
		    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            javax.swing.UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
		    java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		
		}
		
		
		new App().start();	
		UsuarioBO usuarioBO = new UsuarioBO();
		
		
		new ControladorLogin(new JanelaLogin(), usuarioBO);
		
	}
	
	public void run() {
		while(true) {
			
			try {
				
				UsuarioDAO.getInstance().salvar();
				Thread.sleep(2000);
			} catch (Exception e) {
				
			}
			
			
		}
	}
}
