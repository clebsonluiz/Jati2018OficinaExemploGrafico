package br.com.ClébsonLuiz.view;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public abstract class Janela extends JFrame {

	public Janela(String titulo, int x, int y) {
		super(titulo);
		setSize(x, y);
	}
	
	
}
