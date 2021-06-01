package main;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ControleurConfig extends JButton {
	/**
	 * lien avec le modele de type Grille
	 */
	private Grille modele;
	
	/**
	 * constructeur du controleur
	 * @param g
	 * 			modele grille
	 */
	public ControleurConfig(Grille g) {
		super();
		this.modele = g;
		this.setText("Configurer");
		
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Partie.setEtat(Partie.CONFIG);
			}
		});
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (Partie.getEtat() == Partie.EN_COURS || Partie.getEtat() == Partie.CONFIG) {
			this.setEnabled(false);
		} else {
			this.setEnabled(true);
		}
	}
}
