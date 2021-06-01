package main;

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
			}
		});
    }

    }
}
