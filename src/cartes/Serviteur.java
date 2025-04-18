package cartes;

public class Serviteur extends Carte {
    private int vie; // Vie du serviteur
    private int attaque; // Attaque du serviteur
    private String pouvoirSpecial; // Pouvoir du serviteur

    public Serviteur(String nom, int coutMana, int vie, int attaque, String pouvoirSpecial) {
        super(nom, coutMana); // Appel du constructeur de la classe mère Carte
        this.vie = vie;
        this.attaque = attaque;
        this.pouvoirSpecial = pouvoirSpecial; // Initialisation du pouvoir spécial
    }

    public int getVie() {
        return vie;
    }


    public int getAttaque() {
        return attaque;
    }

    public String getPouvoirSpecial() {
        return pouvoirSpecial;
    }
    public String getNom(){
        return super.getNom(); // Appel de la méthode getNom() de la classe mère Carte  
    }

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

    public void attaquer(Serviteur cible) {
        //  attaque du serviteur vers une cible
        System.out.println(this.getNom() + " attaque " + cible.getNom() + ".");
        cible.recevoirDegat(this.attaque);  

    }

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
    public void afficher() {
        //  methode qui affiche les caracteristiques du serviteur
        System.out.println("Nom: " + getNom());
        System.out.println("Cout de mana: " + getCoutMana());
        System.out.println("Vie: " + vie);
        System.out.println("Attaque: " + attaque);
        System.out.println("Pouvoir spécial: " + pouvoirSpecial);
    }
    @Override
    public Carte retirerCarte() {
        /* 
        * Methode qui permet de retirer et retourner la première carte du deck
        */
        if (!cartes.isEmpty()) { // Vérifie si le deck n'est pas vide
            Carte cartePiochee = cartes.remove(0); // Retire la première carte
            System.out.println("Carte piochée : " + cartePiochee.getNom()); // Affiche la carte piochée
            return cartePiochee; // Retourne la carte piochée
        } else {
            System.out.println("Le deck est vide, aucune carte à piocher.");
            return null; // Retourne null si le deck est vide
        }
    }
    @Override
    public void jouer() {
        //  methode qui permet de jouer le serviteur
        System.out.println("Le serviteur " + this.getNom() + " est joué.");
    }

}