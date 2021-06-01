package main;

import java.awt.*;
import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * vue affichant la grille dans la fenetre
 */
public class VueGrille extends JPanel implements Observer {
	/**
	 * lien avec le modele de type Grille
	 */
	private Grille modele;
	
	/* pour chaque case de la liste/tableau de lampe on affiche un rectangle
	   representant la lampe, si elle est allume la couleur est coulAllume sinon
	   coulEteinte */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int tailleCarreX = getWidth()/Grille.getTaille();
		int tailleCarreY = getHeight()/Grille.getTaille();
		
		if (modele != null) {
			Color coulAllume = modele.getColorOn();
			Color coulEteinte = modele.getColorOff();
			for (int i = 0; i<Grille.getTaille(); i++) {
				for (int j = 0; j<Grille.getTaille(); j++) {
					if (modele.getEtatLampe(j, i)) {
						g.setColor(coulAllume);
					} else {
						g.setColor(coulEteinte);
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
