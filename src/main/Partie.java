package main;

public class Partie {
	/**
	 * Indique que la partie est en cours, on ne peut pas modifier la partie. On peut jouer ou arreter la partie. 
	 */
	public final static int EN_COURS = 0;
	/**
	 * Indique que la partie est finie, on ne peut pas jouer ou arreter, mais on peut configurer la partie.
	 */
	public final static int FIN = 1;
	/**
	 * Indique que la partie est en train d'etre modifiee manuellement. On ne peut pas arreter, ni configurer, cependant, on peut jouer ou modifier la partie aleatoirement.
	 */
	public final static int CONFIG = 2;
	/**
	 * Indique que la partie vient d'etre modifie aleatoirement. On ne peut pas arreter, cependant, on peut jouer, configurer ou modifier la partie aleatoirement.
	 */
	public final static int ALEA = 3;
	/**
	 * Indique que la partie est gagnee. On ne peut que arreter.
	 */
	public final static int GAGNE = 4;
	/**
	 * Indique que le jeu vient d'etre lance. Similaire a FIN, on ne peut pas jouer ou arreter, mais on peut configurer la partie.
	 */
	public final static int INIT = -1;
	
	/**
	 * etat actuel de la partie
	 * un des etats EN_COURS, FIN, ...
	 */
	private static int etat = INIT;
	
	/**
	 * donne l'etat actuel de la partie
	 * @return etat actuel de la partie
	 */
	public static int getEtat() {
		return etat;
	}
	
	/**
	 * change l'etat actuel de la partie
	 * @param e
	 * 			nouvel etat (utiliser les constantes)
	 */
	public static void setEtat(int e) {
		if (e==EN_COURS || e==FIN || e==CONFIG || e==INIT || e==ALEA || e==GAGNE) {
			etat = e;
		}
		Principale.repaintMenu();
	}
}
