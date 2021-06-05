package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * vue indiquant le nombre de deplacements durant la partie
 */
public class VueDeplacements extends JPanel implements Observer {
	/**
	 * lien avec le modele de type Grille
	 */
	private Grille grille;
	
	/**
	 * affichage du nombre de deplacements
	 */
	private JLabel nombre;
	
	public VueDeplacements() {
		JPanel haut = new JPanel();
		JPanel centre = new JPanel();
		JLabel texte = new JLabel("Nb Deplacements");
		nombre = new JLabel("init");
		haut.add(texte);
		centre.add(nombre, new FlowLayout());
		nombre.setFont(new Font(nombre.getFont().getFontName(), nombre.getFont().getStyle(), 20));
		this.setLayout(new BorderLayout());
		this.add(haut, BorderLayout.NORTH);
		this.add(centre, BorderLayout.CENTER);
	}
	
	public void update(Observable o, Object arg) {
		grille = (Grille) o;
		nombre.setText("" + grille.getDeplacements());
	}
}
