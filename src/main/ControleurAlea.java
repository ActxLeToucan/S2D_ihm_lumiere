package main;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * controleur pour le bouton "Aleatoire" permettant d'afficher des cases aleatoirement sur la grille, et passe en mode ALEA (voir documentation de Partie.ALEA)
 */
public class ControleurAlea extends JButton {
	/**
	 * lien avec le modele de type Grille
	 */
	private Grille modele;
	
	/**
	 * constructeur du controleur
	 * @param g
	 * 			modele grille
	 */
	public ControleurAlea(Grille g) {
		super();
		this.modele = g;
		
		this.setText("Aléatoire");
		
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Partie.setEtat(Partie.ALEA);
				modele.allumerAlea();
			}
		});
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (Partie.getEtat() == Partie.EN_COURS || Partie.getEtat() == Partie.GAGNE) {
			this.setEnabled(false);
		} else {
			this.setEnabled(true);
		}
	}
}
