package cartes;


import joueur.Heros;

public class Sort extends Carte  {
	private static final long serialVersionUID = 1L;
	private String effet ; 
	private int valeur ;
	public Sort(String nom, int coutMana, String effet, int valeur) {
		super(nom, coutMana);
		this.effet = effet; 
		this.valeur = valeur ;
	}
	public String getEffet () {
		return effet ;
	}
	public int getValeur () {
		return valeur; 
	}
	@Override
	public void jouer() {
		
	}
	@Override
	public void afficher() {
		
	}
	@Override
	public void utiliser() {
	    // Cette méthode devra recevoir la cible en paramètre pour être vraiment utile
	    // Exemple d'utilisation générique (à adapter selon l'appel)
	    System.out.println("Le sort " + getNom() + " est utilisé. Effet : " + effet);
	    // Ici, il faudrait appliquer l'effet à la cible (serviteur ou héros)
	}
	
	
	    
}
