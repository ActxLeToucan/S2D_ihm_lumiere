package main;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

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
		if (Partie.getEtat() == Partie.EN_COURS) {
			this.setEnabled(false);
		} else {
			this.setEnabled(true);
		}
	}
}
