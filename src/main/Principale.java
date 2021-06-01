package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Principale {
	private static JPanel menu;
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
		ControleurConfig ctrlConfig = new ControleurConfig(c);
		ControleurAlea ctrlAlea = new ControleurAlea(c);
		ControleurJouer ctrlJouer = new ControleurJouer(c);
		ControleurQuitter ctrlQuitter = new ControleurQuitter(c);
		ControleurGrille ctrlGrille = new ControleurGrille(c);

		menu = new JPanel(new GridLayout());
		menu.add(ctrlConfig);
		menu.add(ctrlAlea);
		menu.add(ctrlJouer);
		menu.add(vueDep);
		menu.add(ctrlQuitter);
		
		//ranger tout dans une frame
		JFrame frame=new JFrame();
		
		frame.add(vueGrille, BorderLayout.CENTER);
		frame.add(menu, BorderLayout.WEST);
		frame.setSize(new Dimension(600,400));
		frame.setVisible(true);
		
		// init
		grille.changerUneLampe(0, 0);
		grille.changerUneLampe(0, 0);
	}
	public static void repaintMenu() {
		menu.repaint();
	}
}
