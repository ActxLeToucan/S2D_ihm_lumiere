package main;
import java.util.Observable;
import java.util.Observer;

/**
 * vue mettant a jour l'affichage dans la console
 */
public class VueTexte implements Observer {
	private Grille grille;
	
	/**
	 * affiche le texte de la grille
	 */
	public void afficher() {
		if (grille != null) {
			System.out.println(grille);
		}
	}
	
	/**
	 * met a jour la vue du texte de la grille
	 */
	public void update(Observable o, Object arg) {
		grille = (Grille) o;
		
		this.afficher();
	}
}
