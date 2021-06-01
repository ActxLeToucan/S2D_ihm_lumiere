package main;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * controleur pour le bouton "Jouer" permettant de passer en mode EN_COURS (voir documentation de Partie.EN_COURS)
 */
public class ControleurJouer extends JButton {
	/**
	 * lien avec le modele de type Grille
	 */
    private Grille modele;
    
    /**
	 * constructeur du controleur
	 * @param g
	 * 			modele grille
	 */
    public ControleurJouer(Grille g){
        super();
        modele = g;

        setText("Jouer");

        this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                // on lance la partie en changeant son etat a EN_COURS
                Partie.setEtat(Partie.EN_COURS);
			}
		});
    }
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (Partie.getEtat() == Partie.INIT || Partie.getEtat() == Partie.FIN || Partie.getEtat() == Partie.EN_COURS || Partie.getEtat() == Partie.GAGNE) {
			this.setEnabled(false);
		} else {
			this.setEnabled(true);
		}
	}
}
