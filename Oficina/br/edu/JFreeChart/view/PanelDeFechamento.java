package br.edu.JFreeChart.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelDeFechamento extends JPanel{
	
	
	private class Fechamento extends JPanel{
		
		private Botao sair_Button, min_Button, max_Button;
		
		public Fechamento() {
		
			sair_Button = new Botao("[X]", Color.WHITE, Color.RED);
			min_Button = new Botao("__", Color.WHITE, Color.GRAY);
			max_Button = new Botao("[⁯⁯ ]", Color.WHITE, Color.GRAY);
			
			add(min_Button);
			add(max_Button);
			add(sair_Button);
			setBackground(Color.DARK_GRAY);
//			setSize(50,50);
		}
		
	}
	
	
	private Fechamento fech;
	private JLabel titulo;
	
	
	public PanelDeFechamento() {
		setBackground(Color.DARK_GRAY);
		setLayout(new BorderLayout(20, 20));
		
		fech = new Fechamento();
		
		titulo = new JLabel("  Janela");
		titulo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		titulo.setForeground(Color.white);

		
		add(titulo, BorderLayout.WEST);
		add(fech, BorderLayout.EAST);
	}

	

	
	public JButton getMin_Button() {return fech.min_Button;}
	public JButton getMax_Button() {return fech.max_Button;}
	public JButton getSair_Button() {return fech.sair_Button;}
	
	
}
