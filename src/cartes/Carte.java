package cartes;

import java.io.Serializable;
import java.util.List;

public abstract class Carte implements Serializable {
	/*  
	 * Classe abstraite qui représente une carte du jeu 
	 * Cette carte peut être une arme, un serviteur ou un sort
	 */
	
	protected String nom ; // Nom de la carte //
	private int coutMana ; // Cout en mana de la carte //
	
	public Carte (String nom, int coutMana) {
		/*
		 * Le constructeur de la classe Carte 
		 * @param nom : nom de la  carte
		 * @param coutMana : le cout du mana sur la carte 
		 */
		
		this.nom = nom ; 
		this.coutMana = coutMana ; 
	}
	
	public int getCoutMana () {
		/*
		 * Methode qui retourne le cout du manna de la carte afin que le cout manna soit accessible dans une autre classe 
		 */
		return coutMana ;
	}
	
	public String getNom (){
		/* 
		 * Fonction qui retourne le nom de la carte afin que le nom de la carte soit accessible depuis une autre classe 
		 */
		return nom ;
	}
	public abstract void jouer (); // Methode abstraite qui sera redéfinie dans les classes filles (Serviteur, Sort, Arme) //
	public abstract void afficher(); // Methode abstraite qui sera redéfinie dans les classes filles (Serviteur, Sort, Arme) //
	
	public abstract void utiliser(); // Methode abstraite qui sera redéfinie dans les classes filles (Serviteur, Sort, Arme) //	

	private static final long serialVersionUID = 1L;

    public abstract List<Carte> getServiteurs();
}
