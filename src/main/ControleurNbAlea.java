package main;

import java.awt.Graphics;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * controleur permettant de modifier le nombre de cases de la grille qui seront allumees en aleatoire
 */
public class ControleurNbAlea extends JSpinner {
	/**
	 * lien avec le modele de type Grille
	 */
	private Grille modele;
	
	/**
	 * modele de spinner a partir de la grille
	 */
	private static SpinnerModel spinnerModel = new SpinnerNumberModel(Grille.getAlea(), 1, Grille.getTaille()*Grille.getTaille(), 1);
	
	/**
	 * constructeur du controleur
	 * @param g
	 * 			modele grille
	 */
	public ControleurNbAlea(Grille g) {
		super(spinnerModel);
		modele = g;
		
		this.addChangeListener(new ChangeListener() {
	         public void stateChanged(ChangeEvent e) {
	             Grille.setAlea(Integer.parseInt(((JSpinner)e.getSource()).getValue().toString()));
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
