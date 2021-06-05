package main;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

public class ControleurGrille extends MouseInputAdapter {
	private Grille modele;
	private VueGrille vue;
	
	public ControleurGrille(Grille g, VueGrille vue) {
		this.modele = g;
		this.vue = vue;
	}
	
	public void mousePressed(MouseEvent e) {
		int tailleCarreX = vue.getWidth()/Grille.getTaille();
		int tailleCarreY = vue.getHeight()/Grille.getTaille();
		int lampeX = (int) Math.ceil(e.getX()/tailleCarreX);
		int lampeY = (int) Math.ceil(e.getY()/tailleCarreY);

		if (Partie.getEtat() == Partie.EN_COURS) {
			modele.changer5Lampes(lampeX, lampeY);
			modele.incrementerDeplacements();
			if (modele.getNbAllumees() == 0) {
				modele.gg();
			}
		} else if (Partie.getEtat() == Partie.CONFIG) {
			modele.changerUneLampe(lampeX, lampeY);
		}
	}
}
