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
			e.printStackTrace();
			System.out.println("en dehors de la grille");
		}
		notifyObservers();
	}
	
	/**
	 * inverse l'etat de la lampe en x, y et des lampes adjacentes
	 * @param x
	 * 			position sur l'axe des abscisses
	 * @param y
	 * 			position sur l'axe des ordonnees
	 * @throws Exception
	 */
	public void changer5Lampes(int x, int y) throws Exception {
		// TODO
		throw new Exception("TODO");
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
	
}
