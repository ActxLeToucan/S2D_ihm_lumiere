package main;

import java.awt.*;
import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class VueGrille extends JPanel implements Observer {

	final static Color COUL_ALLUME = Color.CYAN;
	final static Color COUL_ETEINTE = Color.BLUE;

	private Grille modele;
	// pour chaque case de la liste/tableau de lampe on affiche un rectangle
	// representant la lampe, si elle est allume la couleur est COUL_ALLUME sinon
	// COUL_ETEINTE
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int tailleCarreX = getWidth()/Grille.getTaille();
		int tailleCarreY = getHeight()/Grille.getTaille();
		
		if (modele != null) {
			
			for (int i = 0; i<Grille.getTaille(); i++) {
				for (int j = 0; j<Grille.getTaille(); j++) {
					if (modele.getEtatLampe(j, i)) {
						g.setColor(COUL_ALLUME);
					} else {
						g.setColor(COUL_ETEINTE);
					}
					g.fillRect(j*tailleCarreX, i*tailleCarreY, tailleCarreX, tailleCarreY);
					g.setColor(Color.BLACK);
					g.drawRect(j*tailleCarreX, i*tailleCarreY, tailleCarreX, tailleCarreY);
				}
			}
		}
	}

	public void update(Observable o, Object arg) {
		modele = (Grille) o;
		repaint();
	}
}
