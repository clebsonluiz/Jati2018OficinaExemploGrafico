package br.edu.JFreeChart.controll;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import br.edu.JFreeChart.model.BD;
import br.edu.JFreeChart.model.Dado;
import br.edu.JFreeChart.model.DadoQualitativo;
import br.edu.JFreeChart.model.Tabela;
import br.edu.JFreeChart.view.Janela;

public class Controll {

	Janela janela;
	Tabela tabela;
	BD bd;
	
	
	public Controll(Janela janela, Tabela tabela, BD bd) {
		super();
		this.janela = janela;
		this.tabela = tabela;
		this.bd = bd;
	}
	
	public void controll() {
		
		
		
		janela.getTela().setTable(tabela);
		
		
		janela.setVisible(true);
			
		janela.repaint();
		
		
		janela.getTela().getBarraRadio().addItemListener((ItemEvent)->{
			janela.getTela().showBarra();
		});
		janela.getTela().getLinhaRadio().addItemListener((ItemEvent)->{
			janela.getTela().showLinha();
		});
		
		janela.getTela().getChckbxFamilia().addItemListener((ItemEvent)->{
			
			if(janela.getTela().getChckbxFamilia().isSelected())
				janela.getTela().exibir();
			else
				janela.getTela().limpar();
			
		});
		
		janela.getTela().getBtnAdd().addActionListener((ActionEvent)->{
			
			try {
				DadoQualitativo dado = new DadoQualitativo(
						janela.getTela().getNomeField().getText(),
						Double.parseDouble(janela.getTela().getValorField().getText()),
						janela.getTela().getFamiliaField().getText());
				
				bd.add(dado);
				Janela.dataSet.addValue(dado.getValor(), dado.getNome(), dado.getSuperFamilia());
				Janela.dataSet2.addValue(dado.getValor(), dado.getNome(), dado.getSuperFamilia());
				
			}catch(Exception e){
				
			}			
			
			tabela.fireTableDataChanged();
			janela.repaint();
			
		});
		
		janela.getTela().getBtnDeletar().addActionListener((ActionEvent)->{
			int i = janela.getTela().getTable().getSelectedRow();
			if(i>-1) {			
			tabela.removerLinha(i);
			add();
			janela.repaint();
			}
		});
		
		
		
		janela.getPanel().getSair_Button().addActionListener((ActionEvent)->{
			System.exit(0);
		});
		
		janela.getPanel().addMouseMotionListener(new MouseDragged());
		janela.getPanel().addMouseListener(new MousePressed());
		janela.getPanel().getMin_Button().addActionListener((ActionEvent)->{

			janela.setExtendedState(JFrame.ICONIFIED);
		});
		janela.getPanel().getMax_Button().addActionListener((ActionEvent)->{

			if(janela.getExtendedState()==JFrame.MAXIMIZED_BOTH)
				janela.setExtendedState(JFrame.NORMAL);
			else
				janela.setExtendedState(JFrame.MAXIMIZED_BOTH);
		});
		
		janela.getPanel().addAncestorListener(new AncestorListener() {
			
			@Override public void ancestorRemoved(AncestorEvent event) {}
			@Override public void ancestorAdded(AncestorEvent arg0) {}
			@Override public void ancestorMoved(AncestorEvent event) {
				Point p = janela.getLocation();
				if(p.getY()<0) 
					janela.setLocation((int)p.getX(), 0);
			}
		});
	
		
		
	}
	
	
	
	public void add() {
		
		Janela.dataSet.clear();
		Janela.dataSet2.clear();
		
		for(Dado dado: bd.getDados()) {
			Janela.dataSet.addValue(dado.getValor(), dado.getNome(), ((DadoQualitativo)dado).getSuperFamilia());
			Janela.dataSet2.addValue(dado.getValor(), dado.getNome(), ((DadoQualitativo)dado).getSuperFamilia());
		}
	}
	
	
	
	
	
	private int xz, yz;
	private class MouseDragged extends MouseMotionAdapter{
					
		@Override
		public void mouseDragged(MouseEvent e) {
				
			if (e.getX() - xz == 0 || e.getX() - xz == 0) {
				xz = e.getX();
			}
			if (e.getY() - yz == 0 || e.getY() - yz == 0) {
				yz = e.getY();
			}
			
			int x = (int)janela.getLocation().getX();
			int y = (int)janela.getLocation().getY();
			
			janela.setLocation(x+(e.getX() - xz),
						y+(e.getY() - yz));
			
		}
	}
	
	private class MousePressed extends MouseAdapter{
		
		@Override
		public void mousePressed(MouseEvent e) {
			xz = e.getX();
			yz = e.getY();
		}
	}
	
	
	
}
