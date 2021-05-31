package main;
import java.util.ArrayList;
import java.util.Observable;

/**
 * represente une grille de lampes
 * @author antoi
 */
public class Grille extends Observable {
	private static final int TAILLE_GRILLE = 5;
	private Lampe[][] lampes;

	/**
	 * constructeur de grille
	 */
	public Grille() {
		lampes = new Lampe[TAILLE_GRILLE][TAILLE_GRILLE];
		for (int i = 0; i<TAILLE_GRILLE; i++) {
			for (int j = 0; j<TAILLE_GRILLE; j++) {
				lampes[i][j] = new Lampe();
			}
		}
	}
	
	/**
	 * inverse l'etat d'une lampe positionne en x, y
	 * @param x
	 * 			position sur l'axe des abscisses
	 * @param y
	 * 			position sur l'axe des ordonnees
	 */
	public void changerUneLampe(int x, int y) {
		try {
			lampes[x][y].inverserEtat();
			setChanged();
		} catch (ArrayIndexOutOfBoundsException e) {
			// on garde ca pour le debugage
			System.out.println("[" + x + ";" + y + "] est en dehors de la grille");
		}
		notifyObservers();
	}
	
	/**
	 * inverse l'etat de la lampe en x, y et des lampes adjacentes
	 * @param x
	 * 			position sur l'axe des abscisses
	 * @param y
	 * 			position sur l'axe des ordonnees
	 */
	public void changer5Lampes(int x, int y) {
		changerUneLampe(x, y);
		changerUneLampe(x+1, y);
		changerUneLampe(x-1, y);
		changerUneLampe(x, y+1);
		changerUneLampe(x, y-1);
	}
	
	/**
	 * donne l'affichage de la grille
	 * @return affichage de la grille
	 */
	public String toString() {
		String res = "";
		for (int i = 0; i<TAILLE_GRILLE; i++) {
			String ligne = "";
			for (int j = 0; j<TAILLE_GRILLE; j++) {
				if (lampes[j][i].getEtat()) {
					ligne += "[X]";
				} else {
					ligne += "[ ]";
				}
			}
			res += "\n" + ligne;
		}
		return res;
	}
	
	/**
	 * donne l'etat de la lampe aux coordonnees x, y
	 * @param x
	 * 			position sur l'axe des abscisses
	 * @param y
	 * 			position sur l'axe des ordonnees
	 * @return etat de la lampe
	 */
	public boolean getEtatLampe(int x, int y) {
		return lampes[x][y].getEtat();
	}
	
	/**
	 * donne le nombre de lampes allumees
	 * @return nombre de lampes allumees
	 */
	public int getNbAllumees() {
		int res = 0;
		for (int i = 0; i<TAILLE_GRILLE; i++) {
			for (int j = 0; j<TAILLE_GRILLE; j++) {
				if (lampes[i][j].getEtat()) {
					res++;
				}
			}
		}
		return res;
	}
}