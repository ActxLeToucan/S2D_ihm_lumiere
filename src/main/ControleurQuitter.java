public class ControleurQuitter extends JButton {

    private Grille grille;

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
                if( Partie.getEtat == INIT ||Partie.getEtat == CONFIG){
                Partie.setEtat(Partie.FIN);
                Partie.resetDeplacements();
                }
                // mise a jour des boutons
                Partie.repaintMenu()
			}
		});
    }
 // commentaire inutile
}
