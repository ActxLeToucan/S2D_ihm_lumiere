package main;
import java.util.ArrayList;
import java.util.Observable;

/**
 * represente une grille de lampes
 * @author antoi
 */
public class Grille extends Observable {
	protected static final int TAILLE_DEF = 5;
	private static int taille = TAILLE_DEF;
	private static int alea = 8;
	private static Lampe[][] lampes;

	/**
	 * constructeur de grille
	 */
	public Grille() {
		lampes = new Lampe[taille][taille];
		for (int i = 0; i<taille; i++) {
			for (int j = 0; j<taille; j++) {
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
		for (int i = 0; i<taille; i++) {
			String ligne = "";
			for (int j = 0; j<taille; j++) {
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
		for (int i = 0; i<taille; i++) {
			for (int j = 0; j<taille; j++) {
				if (lampes[i][j].getEtat()) {
					res++;
				}
			}
		}
		return res;
	}
	
	/**
	 * eteint toutes les lampes
	 */
	public void eteindreTout() {
		for (int i = 0; i<taille; i++) {
			for (int j = 0; j<taille; j++) {
				lampes[i][j].eteindre();
			}
		}
		setChanged();
		notifyObservers();
	}

	/**
	 * allume les lampes aleatoirement sur la grille
	 */
	public void allumerAlea() {
		ArrayList<Lampe> liste = new ArrayList<Lampe>();
		for (int i = 0; i<taille; i++) {
			for (int j = 0; j<taille; j++) {
				liste.add(lampes[j][i]);
			}
		}
		eteindreTout();
		for (int i = 0; i<alea; i++) {
			int randomNumber = (int)(Math.random()*taille*taille);
			Lampe l = liste.get(randomNumber);
			if (l.getEtat()) {
				i--;
			} else {
				l.allumer();
			}
		}
		setChanged();
		notifyObservers();
	}

	/**
	 * definit alea
	 * @param aleatoire
	 * 			nombre de cases a allumer aleatoirement
	 */
	public static void setAlea(int aleatoire) {
		if (aleatoire <= taille*taille) {
			alea = aleatoire;
		}
	}
	
	/**
	 * donne alea
	 * @return nombre de cases a allumer aleatoirement
	 */
	public static int getAlea() {
		return alea;
	}
	
	/**
	 * methode secrete
	 */
	public void gg() {
		eteindreTout();
		setTaille(15);
		changerUneLampe(3,4);
		changerUneLampe(4,4);
		changerUneLampe(5,4);
		changerUneLampe(6,4);
		changerUneLampe(2,5);
		changerUneLampe(2,6);
		changerUneLampe(2,7);
		changerUneLampe(2,8);
		changerUneLampe(2,9);
		changerUneLampe(3,10);
		changerUneLampe(4,10);
		changerUneLampe(5,10);
		changerUneLampe(6,10);
		changerUneLampe(6,9);
		changerUneLampe(6,8);
		changerUneLampe(6,7);
		changerUneLampe(5,7);

		changerUneLampe(9,4);
		changerUneLampe(10,4);
		changerUneLampe(11,4);
		changerUneLampe(12,4);
		changerUneLampe(8,5);
		changerUneLampe(8,6);
		changerUneLampe(8,7);
		changerUneLampe(8,8);
		changerUneLampe(8,9);
		changerUneLampe(9,10);
		changerUneLampe(10,10);
		changerUneLampe(11,10);
		changerUneLampe(12,10);
		changerUneLampe(12,9);
		changerUneLampe(12,8);
		changerUneLampe(12,7);
		changerUneLampe(11,7);
		setChanged();
		notifyObservers();
	}
	
	/**
	 * donne la taille de la grille
	 * @return taille de la grille
	 */
	public static int getTaille() {
		return taille;
	}
	
	/**
	 * change la taille de la grille
	 * @param taille
	 * 			taille de la grille
	 */
	public static void setTaille(int taille) {
		if (taille > 0) {
			Grille.taille = taille;
			lampes = new Lampe[taille][taille];
			for (int i = 0; i<taille; i++) {
				for (int j = 0; j<taille; j++) {
					lampes[i][j] = new Lampe();
				}
			}
		}
	}
}
