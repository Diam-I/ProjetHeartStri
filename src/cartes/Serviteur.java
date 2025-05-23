package cartes;
import java.util.List;

import joueur.Heros;

/**
 * Représente un serviteur dans le jeu.
 * Un serviteur possède des points de vie, une attaque et un pouvoir spécial.
 */
public class Serviteur extends Carte  { 
    private static final long serialVersionUID = 1L; 
    /** Points de vie du serviteur */
    private int vie; 
    /** Valeur d'attaque du serviteur */
    private int attaque; 
    /** Pouvoir spécial du serviteur */
    private String pouvoirSpecial; 

    /**
     * Constructeur de la classe Serviteur.
     * @param nom le nom du serviteur
     * @param coutMana le coût en mana du serviteur
     * @param vie les points de vie du serviteur
     * @param attaque la valeur d'attaque du serviteur
     * @param pouvoirSpecial le pouvoir spécial du serviteur
     */
    public Serviteur(String nom, int coutMana, int vie, int attaque, String pouvoirSpecial) {
        super(nom, coutMana); // Appel du constructeur de la classe mère Carte
        this.vie = vie;
        this.attaque = attaque;
        this.pouvoirSpecial = pouvoirSpecial; // Initialisation du pouvoir spécial
    }

    /**
     * Retourne les points de vie du serviteur.
     * @return les points de vie
     */
    public int getVie() {
        return vie;
    }

    /**
     * Retourne la valeur d'attaque du serviteur.
     * @return la valeur d'attaque
     */
    public int getAttaque() {
        return attaque;
    }

    /**
     * Retourne le pouvoir spécial du serviteur.
     * @return le pouvoir spécial
     */
    public String getPouvoirSpecial() {
        return pouvoirSpecial;
    }

    /**
     * Retourne le nom du serviteur.
     * @return le nom
     */
    public String getNom(){
        return super.getNom() ; 
    }

    /**
     * Affiche les caractéristiques du serviteur.
     */
    public void afficher() {
        //  methode qui affiche les caracteristiques du serviteur
        System.out.println("Nom: " + getNom());
        System.out.println("Cout de mana: " + getCoutMana());
        System.out.println("Vie: " + vie);
        System.out.println("Attaque: " + attaque);
        System.out.println("Pouvoir spécial: " + pouvoirSpecial);
    }

    /**
     * Modifie la valeur d'attaque du serviteur.
     * @param attaque la nouvelle valeur d'attaque
     */
    public void setAttaque(int attaque) {
    	this.attaque = attaque ;
    }

    /**
     * Permet au serviteur de recevoir des dégâts.
     * @param degat le nombre de points de dégâts reçus
     */
    public void recevoirDegat(int degat) {
        //  methode qui permet de recevoir des degats
        this.vie -= degat; // On soustrait les degats à la vie du serviteur
        if (this.vie <= 0) {
            // Si la vie est inférieure ou égale à 0, le serviteur est détruit
            System.out.println("Le serviteur " + this.getNom() + " est détruit.");
        } else {
            // Sinon, on affiche la vie restante du serviteur
            System.out.println("Le serviteur " + this.getNom() + " a " + this.vie + " points de vie restants.");
        }
    }

    /**
     * Permet au serviteur d'attaquer un héros.
     * @param heros le héros attaqué
     */
    public void attaquer(Heros heros) {
    heros.recevoirDegat(this.attaque);
    }

    /**
     * Permet au serviteur d'attaquer un autre serviteur.
     * @param serviteur le serviteur attaqué
     */
    public void attaquer(Serviteur serviteur) {
        serviteur.recevoirDegat(this.attaque);
        this.recevoirDegat(serviteur.attaque);
    }

    /**
     * Permet de soigner le serviteur.
     * @param soin le nombre de points de vie à ajouter
     */
	public void soigner(int soin) {
		this.vie += soin ;
	}

    /**
     * Retourne une représentation textuelle du serviteur.
     * @return une chaîne de caractères décrivant le serviteur
     */
    @Override
    public String toString() {
        //  methode qui retourne une chaine de caractere qui contient le nom, le cout de mana, la vie et l'attaque du serviteur
        return "Serviteur{" +
                "nom='" + getNom() + '\'' +
                ", coutMana=" + getCoutMana() +
                ", vie=" + vie +
                ", attaque=" + attaque +
                '}';
    }

    /**
     * Joue le serviteur.
     */
    @Override
    public void jouer(){
        //  methode qui permet de jouer le serviteur
        System.out.println("Le serviteur " + this.getNom() + " est joué.");
        // 
    }

    /**
     * Utilise le serviteur (méthode à implémenter).
     */
    @Override
	public void utiliser() {
		// TODO Auto-generated method stub
		
	}

    /**
     * Retourne les points de vie du serviteur (non implémenté).
     * @return les points de vie
     */
    public String getPointDeVie() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPointDeVie'");
    }

    /**
     * Retourne la liste des serviteurs associés à cette carte (non implémenté).
     * @return liste de serviteurs
     */
    @Override
    public List<Carte> getServiteurs() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getServiteurs'");
    }
}