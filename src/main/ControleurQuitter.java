public class ControleurQuitter extends JButton {

    private Grille grille;

    // contructeur
    public ControleurQuitter(Grille g){
        super();
        // lien avec le modele qui est passe en paramametre
        Grille modele = g;

        setText("Quitter");
        
        this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                // si l utilisateur n est pas en train de configurer la partie ou n a pas
                // lance de partie on ne fait rien
                if( Partie.getEtat() == Partie.INIT ||Partie.getEtat() == Partie.CONFIG){
                modele.eteindreTout();
                Partie.setEtat(Partie.FIN);
                Partie.resetDeplacements();
                }
			}
		});
    }

}
