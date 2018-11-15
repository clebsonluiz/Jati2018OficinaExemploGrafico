package br.edu.JFreeChart.view;

import java.awt.Color;

import javax.swing.JButton;

public class Botao extends JButton {

	public Botao(String msg, Color frente, Color fundo) {
		super(msg);
		setForeground(frente);
		setBackground(fundo);
		setFocusPainted(false);			
	}

}
