package cartes;
import joueur.Heros;


public class Serviteur extends Carte  { 
    private static final long serialVersionUID = 1L; 
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
        return super.getNom() ; 
    }
    public void afficher() {
        //  methode qui affiche les caracteristiques du serviteur
        System.out.println("Nom: " + getNom());
        System.out.println("Cout de mana: " + getCoutMana());
        System.out.println("Vie: " + vie);
        System.out.println("Attaque: " + attaque);
        System.out.println("Pouvoir spécial: " + pouvoirSpecial);
    }

    public void setAttaque(int attaque) {
    	this.attaque = attaque ;
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

    public void attaquer(Heros heros) {
    heros.recevoirDegat(this.attaque);
    }

    public void attaquer(Serviteur serviteur) {
        serviteur.recevoirDegat(this.attaque);
        this.recevoirDegat(serviteur.attaque);
    }

    /**
	 * Methode qui permet de soigner le serviteur
	 * @param soin
	 */
	public void soigner(int soin) {
		this.vie += soin ;
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
    @Override
    public void jouer(){
        //  methode qui permet de jouer le serviteur
        System.out.println("Le serviteur " + this.getNom() + " est joué.");
        // 
    }

	@Override
	public void utiliser() {
		// TODO Auto-generated method stub
		
	}
    
    

}