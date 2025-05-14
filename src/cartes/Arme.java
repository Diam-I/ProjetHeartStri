package cartes;

public class Arme extends Carte {
	private int degats ; 
	private int durabilite ;

	public Arme(String nom, int coutMana, int degats , int durabilite) {
		super(nom, coutMana);
		this.degats = degats ; 
		this.durabilite = durabilite;
	}

	
	
	public int getDegats() {
		return degats;
	}
	
	public int getDurabilite () {
		return durabilite;
	}
	
	public void utiliser() {
		durabilite -- ; 
		if (durabilite <= 0) {
			System.out.println("L'arme " + getNom() + " est détruite.");
		}
	}
	@Override
	public void jouer() {
		
	}

	@Override
	public void afficher() {
		
	}
}
