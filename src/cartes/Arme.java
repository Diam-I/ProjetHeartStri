package cartes;

import java.util.List;

/**
 * Représente une carte Arme dans le jeu.
 * Une arme possède des dégâts et une durabilité.
 */
public class Arme extends Carte {
    private static final long serialVersionUID = 1L;
    private int degats ; 
    private int durabilite ;

    /**
     * Construit une nouvelle arme.
     * 
     * @param nom        le nom de l'arme
     * @param coutMana   le coût en mana de l'arme
     * @param degats     les dégâts infligés par l'arme
     * @param durabilite la durabilité de l'arme
     */
    public Arme(String nom, int coutMana, int degats , int durabilite) {
        super(nom, coutMana);
        this.degats = degats ; 
        this.durabilite = durabilite;
    }

    /**
     * Retourne les dégâts de l'arme.
     * 
     * @return les dégâts
     */
    public int getDegats() {
        return degats;
    }
    
    /**
     * Retourne la durabilité de l'arme.
     * 
     * @return la durabilité
     */
    public int getDurabilite () {
        return durabilite;
    }
    
    /**
     * Retourne le nom de l'arme.
     * 
     * @return le nom
     */
    public String getNom () {
        return nom ; 
    }

    /**
     * Utilise l'arme, réduisant sa durabilité de 1.
     * Affiche un message si l'arme est détruite.
     */
    public void utiliser() {
        durabilite -- ; 
        if (durabilite <= 0) {
            System.out.println("L'arme " + getNom() + " est détruite.");
        }
    }

    /**
     * Modifie la durabilité de l'arme.
     * 
     * @param durabilite la nouvelle durabilité
     */
    public void setDurabilite (int durabilite) {
        this.durabilite = durabilite ;
    }

    /**
     * Joue la carte arme (implémentation à définir).
     */
    @Override
    public void jouer() {
        
    }

    /**
     * Affiche les informations de l'arme (implémentation à définir).
     */
    @Override
    public void afficher() {
        
    }

    /**
     * Retourne la liste des serviteurs associés à cette carte (toujours null pour une arme).
     * 
     * @return null
     */
    @Override
    public List<Carte> getServiteurs() {
        return null;
    }
}
