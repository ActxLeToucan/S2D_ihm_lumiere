package main;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ControleurQuitter extends JButton {

    private Grille modele;

    // contructeur
    public ControleurQuitter(Grille g){
        super();
        // lien avec le modele qui est passe en paramametre
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
