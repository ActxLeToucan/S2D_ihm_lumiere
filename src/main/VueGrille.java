package main;

import java.awt.*;
import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class VueGrille extends JPanel implements Observer {

	final static Color COUL_ALLUME = Color.BLUE;
	final static Color COUL_ETEINTE = Color.CYAN;

	private Grille modele;
	// pour chaque case de la liste/tableau de lampe on affiche un rectangle
	// representant la lampe, si elle est allume la couleur est COUL_ALLUME sinon
	// COUL_ETEINTE
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int tailleCarreX = getWidth()/Grille.TAILLE_GRILLE;
		int tailleCarreY = getHeight()/Grille.TAILLE_GRILLE;
		
		if (modele != null) {
			for (int i = 0; i<Grille.TAILLE_GRILLE; i++) {
				for (int j = 0; j<Grille.TAILLE_GRILLE; j++) {
					if (modele.getEtatLampe(j, i)) {
						g.setColor(COUL_ALLUME);
					} else {
						g.setColor(COUL_ETEINTE);
					}
					g.fillRect(j*tailleCarreX, i*tailleCarreY, tailleCarreX, tailleCarreY);
				}
			}
		}
	}

	public void update(Observable o, Object arg) {
		modele = (Grille) o;
		repaint();
	}
}
