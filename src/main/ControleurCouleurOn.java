package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;

/**
 * controleur permettant de changer la couleur des lampes qui sont allumees
 */
public class ControleurCouleurOn extends JButton {
	/**
	 * lien avec le modele de type Grille
	 */
	private Grille modele;
	
	/**
	 * constructeur du controleur
	 * @param g
	 * 			modele grille
	 */
	public ControleurCouleurOn(Grille g) {
		super();
		this.modele = g;
		
		this.setText("ON");
		
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        Color color = JColorChooser.showDialog(ControleurCouleurOn.this, "Couleur pour lampe allumée", modele.getColorOn());
		        modele.setColorOn(color);
		        repaint();
			}
		});
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(modele.getColorOn());
		this.setEnabled(true);
	}
}
