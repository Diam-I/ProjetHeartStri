package cartes;

public abstract class Carte {
	/*  
	 * Classe abstraite qui représente une carte du jeu 
	 * Cette carte peut être une arme, un serviteur ou un sort
	 */
	
	private String nom ; // Nom de la carte //
	private int coutMana ; // Cout en mana de la carte //
	private boolean estSurPlateau ; // Si la carte est en jeu sur le plateau ou pas //
	
	public Carte (String nom, int coutMana) {
		/*
		 * le constructeur de la classe Carte 
		 * @param nom : nom de la  carte
		 * @param coutMana : le cout du mana sur la carte 
		 */
		
		this.nom = nom ; 
		this.coutMana = coutMana ; 
		estSurPlateau = false ; 
	}
	
	
	public int getCoutMana () {
		/*
		 * Methode qui retourne le cout du manna de la carte afin que le cout manna soit accessible dans une autre classe 
		 */
		return coutMana ;
	}
	
	public String getNom (){
		/* 
		 * fonction qui retourne le nom de la carte afin que le nom de la carte soit accessible depuis une autre classe 
		 */
		return nom ;
	}
	
	public boolean estSurPlateau () {
		/*
		 * Fonction qui retourne estSurPlatea, un boolean qui indique si la carte est joué sur le plateau ou pas 
		 */
		return estSurPlateau ;
	}	
}
