package main;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

public class ControleurGrille extends MouseInputAdapter {
	private Grille modele;
	private VueGrille vue;
	/**
	 * constructeur de controleurGrille
	 * @param g le modele utilise
	 * @param vue la vue observee
	 */
	public ControleurGrille(Grille g, VueGrille vue) {
		this.modele = g;
		this.vue = vue;
	}
	/**
	 * methode permettant de savoir quelle lampe a ete cliquee puis qui
	 * en fonction de l etat du jeu inverse une ou cinq lampes en incrementant deplacement
	 * enfin on verifie si l utilisateur a gagne si la partie est en cours
	 */
	public void mousePressed(MouseEvent e) {
		// on recupere la position de la lampe dans le tableau de lampe 
		// en fonction des coordonnees du clique 
		int tailleCarreX = vue.getWidth()/Grille.getTaille();
		int tailleCarreY = vue.getHeight()/Grille.getTaille();
		int lampeX = (int) Math.ceil(e.getX()/tailleCarreX);
		int lampeY = (int) Math.ceil(e.getY()/tailleCarreY);

		if (Partie.getEtat() == Partie.EN_COURS) {
			// inversion de l etat de la lampe cliquee ainsi que celles adjacentes
			modele.changer5Lampes(lampeX, lampeY);
			// incrementation du nombre de deplacement du joueur
			modele.incrementerDeplacements();
			if (modele.getNbAllumees() == 0) {
				// affichage du message de victoire
				modele.gg();
			}
		} else if (Partie.getEtat() == Partie.CONFIG) {
			// l utilisateur configure les lampes une a une
			modele.changerUneLampe(lampeX, lampeY);
		}
	}
}
