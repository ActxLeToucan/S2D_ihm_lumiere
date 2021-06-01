package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Principale {
	/**
	 * partie menu contenant les boutons, spinners, ...
	 */
	private static JPanel menu;
	
	/**
	 * programme principal
	 * @param args
	 * 			arguments ligne de commande
	 */
	public static void main(String[] args) {
		//creer une grille (modele)
		Grille grille = new Grille();

		//creer des vues
		VueGrille vueGrille = new VueGrille();
		VueTexte vueTxt = new VueTexte();
		VueDeplacements vueDep = new VueDeplacements();
		//attacher les vues au modele
		grille.addObserver(vueGrille);
		grille.addObserver(vueTxt);
		grille.addObserver(vueDep);
		vueGrille.setPreferredSize(new Dimension(400,400));
		
		//creer les controleurs
		ControleurConfig ctrlConfig = new ControleurConfig(grille);
		ControleurAlea ctrlAlea = new ControleurAlea(grille);
		ControleurJouer ctrlJouer = new ControleurJouer(grille);
		ControleurQuitter ctrlQuitter = new ControleurQuitter(grille);
		ControleurNbAlea ctrlNbAlea = new ControleurNbAlea(grille);
		ControleurCouleurOn ctrlCoulOn = new ControleurCouleurOn(grille);
		ControleurCouleurOff ctrlCoulOff = new ControleurCouleurOff(grille);
		//ControleurGrille ctrlGrille = new ControleurGrille(grille);

		JPanel options = new JPanel();
		options.add(new JLabel("Cases aléatoires"));
		options.add(ctrlNbAlea);
		options.add(ctrlCoulOn);
		options.add(ctrlCoulOff);
		
		menu = new JPanel(new GridLayout(6, 1));
		menu.add(ctrlConfig);
		menu.add(ctrlAlea);
		menu.add(ctrlJouer);
		menu.add(vueDep);
		menu.add(ctrlQuitter);
		menu.add(options);
		
		//ranger tout dans une frame
		JFrame frame=new JFrame();
		
		frame.add(vueGrille, BorderLayout.EAST);
		frame.add(menu, BorderLayout.CENTER);
		frame.setSize(new Dimension(600,400));
		frame.setVisible(true);
		
		// init
		grille.changerUneLampe(0, 0);
		grille.changerUneLampe(0, 0);
	}
	
	/**
	 * actualise les boutons du menu
	 */
	public static void repaintMenu() {
		menu.repaint();
	}
}
