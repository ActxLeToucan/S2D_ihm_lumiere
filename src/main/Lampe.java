package main;
/**
 * classe representant une lampe, correspondant a une case de la grille
 */
public class Lampe {
    /**
     * attribut informant de l etat d une lampe, true si allume 
     */
    private boolean estAllumee; 

    /**
     * constructeur de lampe, elle est eteinte a l initialisation
     */
    public Lampe(){
        this.estAllumee = false;
    }
    
    /**
     * methode inversant l etat de la lampe appellante
     */
    public void inverserEtat(){
        if (this.estAllumee){
            this.estAllumee = false;
        } else {
            this.estAllumee = true;
        }
    }
    
    /**
     * methode allumant la lampe en appel 
     */
    public void allumer(){
        this.estAllumee = true;
    }
    
    /**
     * methode eteignant la lampe en appel 
     */
    public void eteindre(){
        this.estAllumee = false;
    }
    
    /**
     * renvoie l etat de la lampe
     * @return true si la lampe est allumee, false si eteinte
     */
    public boolean getEtat(){
        return this.estAllumee;
    }
}
