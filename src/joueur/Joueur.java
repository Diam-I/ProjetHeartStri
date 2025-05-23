package joueur;

import java.io.Serializable;
import java.util.List;

// Importation des classes nécessaires
import cartes.*; // Importation de la classe Serviteur      
import java.util.ArrayList; // Importation pour la liste des serviteurs
public class Joueur implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nom; // Nom du joueur
    private int mana; // Points de mana du joueur           
    private int vie; // Points de vie du joueur
    private List<Serviteur> serviteurs; // Liste des serviteurs du joueur
    public static final int MANA_MAX = 10; // Valeur maximale de mana
    public static final int VIE_MAX = 30; // Valeur maximale de vie
    public static final int VIE_MIN = 0; // Valeur minimale de vie
	private Heros heros; // Attribut pour stocker le héros du joueur
	private List<Carte> main ; // Liste de carte que le joueur a dans sa main 
	private int manaMax; // Le maximum de mana disponible ce tour

    // Constructeur de la classe Joueur
    public Joueur(String nom) {
        this.nom = nom; // Initialisation du nom du joueur
        this.manaMax = 1; // Commence à 1 mana max
        this.mana = 1;    // Commence à 1 mana disponible
        this.vie = VIE_MAX; // Initialisation de la vie à la valeur maximale
        this.serviteurs = new ArrayList<>(); // Initialisation du serviteur à null
        this.main = new ArrayList<>(); // Initialisation des cartes dans la main à null
        
    }
    // Méthode pour obtenir le nom du joueur
    public String getNom() {
        return nom; // Retourne le nom du joueur
    }
    public int getMana() {
        return mana; // Retourne le mana du joueur
    }
    public int getVie() {
        return vie; // Retourne la vie du joueur
    }
    public List<Serviteur> getServiteurs() {
        return serviteurs; // Retourne le serviteur du joueur
    }
	public void setHeros (Heros heros){
		this.heros = heros; // Définit le héros du joueur
	}
	public List<Carte> getMain () {
		return main ; // Retourne les cartes dans la main du joueur
	}
	public int getManaMax() {
        return manaMax;
    }
    public void setManaMax(int manaMax) {
        this.manaMax = manaMax;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }

     
    public void jouerTour() {
		System.out.println("C'est le tour de " + nom + ".");
		System.out.println("Mana disponible: " + mana);
		System.out.println("Vie restante: " + vie);
	
		if (!serviteurs.isEmpty()) {
			Serviteur serviteur = serviteurs.get(0); // Sélectionne le premier serviteur
			System.out.println("Serviteur en jeu : " + serviteur.getNom());
		} else {
			System.out.println("Aucun serviteur en jeu.");
		}
	}
    public void ajouteServiteur(Serviteur serviteur,int indice ) {
        // Méthode pour ajouter un serviteur à la liste des serviteurs
        if (serviteurs.size() < 7) { // Vérifie si le nombre de serviteurs est inférieur à 7
            serviteurs.add(serviteur); // Ajoute le serviteur à la liste
            System.out.println("Le serviteur " + serviteur.getNom() + " a été ajouté à la liste des serviteurs de " + nom + "."); // Affiche un message de confirmation
            main.remove(indice);
        } else {
            System.out.println("Le joueur " + nom + " ne peut pas avoir plus de 7 serviteurs."); // Indique que le joueur ne peut pas avoir plus de 7 serviteurs
        }
    }
    public void retirerServiteur(Serviteur serviteur) {
        // Méthode pour retirer un serviteur de la liste des serviteurs
        if (serviteurs.contains(serviteur)) { // Vérifie si le serviteur est dans la liste
            serviteurs.remove(serviteur); // Retire le serviteur de la liste
            System.out.println("Le serviteur " + serviteur.getNom() + " a été retiré de la liste des serviteurs de " + nom + "."); // Affiche un message de confirmation
        } else {
            System.out.println("Le serviteur " + serviteur.getNom() + " n'est pas dans la liste des serviteurs de " + nom + "."); // Indique que le serviteur n'est pas dans la liste
        }
    }
    public void recevoirDegat(int degat) {
        // Méthode pour recevoir des dégâts
        vie -= degat; // Soustrait les dégâts à la vie du joueur
        if (vie <= VIE_MIN) {
            // Si la vie est inférieure ou égale à 0, le joueur est détruit
            System.out.println("Le joueur " + nom + " est détruit.");
        } else {
            // Sinon, affiche la vie restante du joueur
            System.out.println("Le joueur " + nom + " a " + vie + " points de vie restants.");
        }
    }
    
    public boolean utiliseMana(int coutMana) {
        // Méthode pour utiliser du mana
        if (mana >= coutMana) { // Vérifie si le mana est suffisant
            mana -= coutMana; // Soustrait le coût du mana
            return true; // Retourne vrai si le mana a été utilisé avec succès
        } else {
            System.out.println("Pas assez de mana pour jouer cette carte."); // Indique que le mana est insuffisant
            return false; // Retourne faux si le mana n'est pas suffisant
        }
    }
    public void piocherCarte(Deck deck) {
        // Méthode pour piocher une carte
		if (deck.getCartes().isEmpty()) { // Vérifie si le deck est vide
			System.out.println("Le deck est vide. " + nom + " ne peut pas piocher de carte."); // Indique que le deck est vide
			return; // Sort de la méthode
		}
		// Sinon, pioche une carte
		Carte carte = deck.getCartes().get(0); // Prend la première carte du deck
        deck.retirerCarte(carte);
        System.out.println("Le " +  nom + " pioche une carte : " + carte.getNom()); // Affiche le nom de la carte piochée
        main.add(carte); // Ajouter la carte piocher dans la main du serviteur 
    }
	public Heros getHeros() {
		// Retourne le héros du joueur
		return heros;
	}

    public void ajouterServiteur(cartes.Serviteur serviteur) {
        this.serviteurs.add(serviteur);
    }

    public void retirerCarteMain(cartes.Carte carte) {
        this.main.remove(carte);
    }
}
