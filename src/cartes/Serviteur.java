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

}