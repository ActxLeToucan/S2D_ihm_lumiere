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
		ControleurGrille ctrlGrille = new ControleurGrille(grille, vueGrille);
		vueGrille.addMouseListener(ctrlGrille);

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
		menu.setPreferredSize(new Dimension(200, 400));
		
		//ranger tout dans une frame
		JFrame frame = new JFrame("Eteint la lumière !");
		
		frame.add(vueGrille, BorderLayout.CENTER);
		frame.add(menu, BorderLayout.WEST);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
