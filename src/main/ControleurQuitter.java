public class ControleurQuitter extends JButton {

    private Grille grille;

    // contructeur
    public ControleurQuitter(Grille g){
        super();
        // lien avec le modele qui est passe en paramametre
        modele = g;

        setText("Quitter");

        this.addActionListener(new ChangeListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
    }

}
