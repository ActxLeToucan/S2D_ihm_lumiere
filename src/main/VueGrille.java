package main;

import java.awt.*;
import javax.swing.*;
import java.util.Observable;

public class VueGrille extends JPanel{

  final static Color COUL_ALLUME = Color.BLUE;
  final static Color COUL_ETEINTE = Color.CYAN;

  private Grille modele;
  // pour chaque case de la liste/tableau de lampe on affiche un rectangle
  // representant la lampe, si elle est allume la couleur est COUL_ALLUME sinon
  // COUL_ETEINTE
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (modele != null) {
      int x, y = 0;
      for (int i = 0; i<Grille.TAILLE_GRILLE; i++) {
        for (int j = 0; j<Grille.TAILLE_GRILLE; j++) {
          g.setColor(Color.BLACK);
          g.drawRect(getHeight()/Grille.TAILLE_GRILLE, getWidth()/Grille.TAILLE_GRILLE, x, y);
          if (modele[j][i].getEtat()) {
            g.setColor(COOL_ALLUME);
          } else {
            g.setColors(COOL_ETEINTE);
          }
          g.fillRect(getHeight()/Grille.TAILLE_GRILLE, getWidth()/Grille.TAILLE_GRILLE, x, y);
        }
      }
    }
  }

  public void update(Observable o, Object arg) {
    modele = (Grille) o;
    repaint();
  }
}
