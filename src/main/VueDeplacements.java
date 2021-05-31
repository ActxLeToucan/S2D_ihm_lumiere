package main;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VueDeplacements extends JPanel implements Observer {
	private Grille grille;
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (grille != null) {
			JLabel texte = new JLabel("Nb Deplacements");
			JLabel nombre = new JLabel("" + grille.getNbAllumees());
			nombre.setFont(new Font(nombre.getFont().getFontName(), nombre.getFont().getStyle(), 20));
			this.setLayout(new BorderLayout());
			this.add(texte, BorderLayout.NORTH);
			this.add(nombre, BorderLayout.CENTER);
		}
	}
	
	public void update(Observable o, Object arg) {
		grille = (Grille) o;
		repaint();
	}
}