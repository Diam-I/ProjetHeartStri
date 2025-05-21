package cartes;

import joueur.Heros;

public class Sort extends Carte{
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
		// TODO Auto-generated method stub
		
	}
	
	
	    
}
