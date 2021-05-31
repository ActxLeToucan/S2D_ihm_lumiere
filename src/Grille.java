import java.util.ArrayList;
import java.util.Observable;

public class Grille extends Observable {
	private static final int TAILLE_GRILLE;
	private Lampe[][] lampes;

	public Grille() {
		lampes = new Lampe[TAILLE_GRILLE][TAILLE_GRILLE];
		for (int i = 0; i<TAILLE_GRILLE; i++) {
			for (int j = 0; j<TAILLE_GRILLE; j++) {
				lampes[i][j] = new Lampe();
			}
		}
		
		toString();
	}
	
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
	
	public void changer5Lampes(int x, int y) {
		// TODO
		throw new Exception("TODO");
	}
	
	public String toString() {
		for (int i = 0; i<TAILLE_GRILLE; i++) {
			String ligne = "";
			for (int j = 0; j<TAILLE_GRILLE; j++) {
				if (lampes[i][j].getEtat()) {
					ligne += "[X]";
				} else {
					ligne += "[ ]";
				}
			}
			System.out.println(ligne);
		}
	}
	
}
