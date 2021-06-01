package main;

public class Partie {
	public final static int EN_COURS = 0;
	public final static int FIN = 1;
	public final static int CONFIG = 2;
	public final static int ALEA = 3;
	public final static int INIT = -1;
	
	private static int deplacements = 0;
	private static int etat = INIT; 
	
	public static void resetDeplacements() {
		deplacements = 0;
	}
	
	public static void deplacer() {
		deplacements++;
	}
	
	public static void reset() {
		etat = INIT;
		resetDeplacements();
	}
	
	public static int getDeplacements() {
		return deplacements;
	}
	
	public static int getEtat() {
		return etat;
	}
	
	public static void setEtat(int e) {
		if (e==EN_COURS || e==FIN || e==CONFIG || e==INIT || e==ALEA) {
			etat = e;
		}
		Principale.repaintMenu();
	}
}
