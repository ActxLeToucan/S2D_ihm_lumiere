package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;

public class ControleurCouleurOff extends JButton {
	/**
	 * lien avec le modele de type Grille
	 */
	private Grille modele;
	
	/**
	 * constructeur du controleur
	 * @param g
	 * 			modele grille
	 */
	public ControleurCouleurOff(Grille g) {
		super();
		this.modele = g;
		this.setText("OFF");
		
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        Color color = JColorChooser.showDialog(ControleurCouleurOff.this, "Couleur pour lampe éteinte", modele.getColorOff());
		        modele.setColorOff(color);
		        repaint();
			}
		});
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(modele.getColorOff());
		this.setEnabled(true);
	}
}
