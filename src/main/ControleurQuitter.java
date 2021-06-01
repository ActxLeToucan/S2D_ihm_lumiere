package main;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * controleur pour le bouton "Quitter" permettant de passer en mode FIN (voir documentation de Partie.FIN)
 */
public class ControleurQuitter extends JButton {
	/**
	 * lien avec le modele de type Grille
	 */
    private Grille modele;

    /**
	 * constructeur du controleur
	 * @param g
	 * 			modele grille
	 */
    public ControleurQuitter(Grille g){
        super();
        modele = g;

        setText("Quitter");
        
        this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                // si l utilisateur n est pas en train de configurer la partie ou n a pas
                // lance de partie on ne fait rien
				Grille.setTaille(Grille.TAILLE_DEF);
                modele.eteindreTout();
                Partie.setEtat(Partie.FIN);
                Partie.resetDeplacements();
			}
		});
    }
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (Partie.getEtat() == Partie.EN_COURS || Partie.getEtat() == Partie.GAGNE) {
			this.setEnabled(true);
		} else {
			this.setEnabled(false);
		}
	}
}
