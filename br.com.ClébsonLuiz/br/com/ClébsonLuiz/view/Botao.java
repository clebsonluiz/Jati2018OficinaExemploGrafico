package br.com.ClébsonLuiz.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

public class Botao extends JButton{

	private static class RoundedBorder implements Border {

	    private int radius;


	    RoundedBorder(int radius) {
	        this.radius = radius;
	    }


	    public Insets getBorderInsets(Component c) {
	        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
	    }


	    public boolean isBorderOpaque() {
	        return true;
	    }


	    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
	        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
	    }
	    
	}
	
	public Botao(String nome) {
		super(nome);
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.GRAY,2, true));
//		setBorder(new RoundedBorder(20));
		
	}
	
}
