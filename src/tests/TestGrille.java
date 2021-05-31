package tests;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import main.Grille;

public class TestGrille {
	@Test
	/**
	 * test du changement d'etat d'une lampe
	 * cas normal
	 */
	public void testGrilleChangerUneLampeNormal() {
		// preparation des donnees
		Grille g = new Grille();
		// methode teste
		g.changerUneLampe(1, 0);
		// validation du resultat
		assertEquals("Une unique lampe devrait etre allumee", 1, g.getNbAllumees());
		assertEquals("La lampe en (1;0) devrait etre allumee", true, g.getEtatLampe(1, 0));
		assertEquals("La lampe en (0;1) devrait etre eteinte", false, g.getEtatLampe(0, 1));
	}
	
	@Test
	/**
	 * test du changement d'etat d'une lampe
	 * cas pas dans la grille
	 */
	public void testGrilleChangerUneLampeDehors() {
		// preparation des donnees
		Grille g = new Grille();
		// methode teste
		g.changerUneLampe(-1, 0);
		// validation du resultat
		assertEquals("Aucune lampe ne devrait etre allummee", 0, g.getNbAllumees());
	}
	
	@Test
	/**
	 * test du changement d'etat d'une lampe
	 * cas lampe deja allumee
	 */
	public void testGrilleChangerUneLampeDejaAllumee() {
		// preparation des donnees
		Grille g = new Grille();
		// methode teste
		g.changerUneLampe(1, 0);
		g.changerUneLampe(1, 0);
		// validation du resultat
		assertEquals("Aucune lampe ne devrait etre allummee", 0, g.getNbAllumees());
	}
	
	@Test
	/**
	 * test du changement d'etat de 5 lampes
	 * cas normal
	 */
	public void testGrilleChanger5LampesNormal() {
		// preparation des donnees
		Grille g = new Grille();
		// methode teste
		g.changer5Lampes(2, 2);
		// validation du resultat
		assertEquals("5 lampes devraient etre allumees", 5, g.getNbAllumees());
		assertEquals("La lampe en (2;2) devrait etre allumee", true, g.getEtatLampe(2, 2));
		assertEquals("La lampe en (2;3) devrait etre allumee", true, g.getEtatLampe(2, 3));
	}
	
	@Test
	/**
	 * test du changement d'etat de 5 lampes
	 * cas en partie en dehors de la grille
	 */
	public void testGrilleChanger5LampesDehors() {
		// preparation des donnees
		Grille g = new Grille();
		// methode teste
		g.changer5Lampes(0, 2);
		// validation du resultat
		assertEquals("4 lampes devraient etre allumees", 4, g.getNbAllumees());
		assertEquals("La lampe en (0;2) devrait etre allumee", true, g.getEtatLampe(0, 2));
		assertEquals("La lampe en (1;2) devrait etre allumee", true, g.getEtatLampe(1, 2));
	}
	
	@Test
	/**
	 * test du changement d'etat de 5 lampes
	 * cas normal
	 */
	public void testGrilleChanger5LampesDejaAllumee() {
		// preparation des donnees
		Grille g = new Grille();
		// methode teste
		g.changer5Lampes(3, 3);
		g.changer5Lampes(3, 2);
		// validation du resultat
		assertEquals("6 lampes devraient etre allumees", 6, g.getNbAllumees());
		assertEquals("La lampe en (3;3) devrait etre eteinte", false, g.getEtatLampe(3, 3));
		assertEquals("La lampe en (3;2) devrait etre eteinte", false, g.getEtatLampe(3, 2));
	}
}
