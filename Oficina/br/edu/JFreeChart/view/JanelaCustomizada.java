package br.edu.JFreeChart.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
	
	
	public abstract class JanelaCustomizada extends JFrame{
		private static final int xF = 700, yF = 400;
		
		
		
		private PanelDeFechamento panel;
		private final Toolkit tk = Toolkit.getDefaultToolkit();
	    private Dimension d = tk.getScreenSize();
		
		
		public JanelaCustomizada() {
			
			panel = new PanelDeFechamento();
			
			JPanel panelL = new JPanel();
			panelL.setBackground(Color.DARK_GRAY);
			JPanel panelS = new JPanel();
			panelS.setBackground(Color.DARK_GRAY);
			JPanel panelR = new JPanel();
			panelR.setBackground(Color.DARK_GRAY);
			
			
			
			add(panel, BorderLayout.NORTH);
			add(panelL, BorderLayout.WEST);
			add(panelS, BorderLayout.SOUTH);
			add(panelR, BorderLayout.EAST);
			setSize(xF,yF);
			
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			setUndecorated(true);
			setVisible(true);
			
		}

		public PanelDeFechamento getPanel() {
			return panel;
		}
	}
	
	
	
	
	

