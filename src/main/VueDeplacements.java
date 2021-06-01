package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * vue indiquant le nombre de deplacements durant la partie
 */
public class VueDeplacements extends JPanel implements Observer {
	/**
	 * lien avec le modele de type Grille
	 */
	private Grille grille;
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (grille != null) {
			JPanel haut = new JPanel();
			JPanel centre = new JPanel();
			JLabel texte = new JLabel("Nb Deplacements");
			JLabel nombre = new JLabel("" + Partie.getDeplacements());
			haut.add(texte);
			centre.add(nombre, new FlowLayout());
			nombre.setFont(new Font(nombre.getFont().getFontName(), nombre.getFont().getStyle(), 20));
			this.setLayout(new BorderLayout());
			this.add(haut, BorderLayout.NORTH);
			this.add(centre, BorderLayout.CENTER);
		}
	}
	
	public void update(Observable o, Object arg) {
		grille = (Grille) o;
		repaint();
	}
}
