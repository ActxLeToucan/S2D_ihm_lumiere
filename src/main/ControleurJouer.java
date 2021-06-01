package main;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class ControleurJouer extends JButton {
    private Grille modele;
    // contructeur
    public ControleurJouer(Grille g){
        super();
        // lien avec le modele qui est passe en paramametre
        modele = g;

        setText("Jouer");

        this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                    
                
			}
		});
    }
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (Partie.getEtat() == Partie.INIT || Partie.getEtat() == Partie.FIN || Partie.getEtat() == Partie.EN_COURS) {
			this.setEnabled(false);
		} else {
			this.setEnabled(true);
		}
	}
}
