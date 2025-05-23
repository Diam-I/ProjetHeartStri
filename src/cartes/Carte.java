package cartes;

import java.io.Serializable;
import java.util.List;

/**
 * Classe abstraite qui représente une carte du jeu.
 * Cette carte peut être une arme, un serviteur ou un sort.
 */
public abstract class Carte implements Serializable {
	/*  
	 * Classe abstraite qui représente une carte du jeu 
	 * Cette carte peut être une arme, un serviteur ou un sort
	 */
	
	/** Nom de la carte */
	protected String nom ; 
	/** Coût en mana de la carte */
	private int coutMana ; 
	
	/**
	 * Constructeur de la classe Carte.
	 * @param nom le nom de la carte
	 * @param coutMana le coût en mana de la carte
	 */
	public Carte (String nom, int coutMana) {

		
		this.nom = nom ; 
		this.coutMana = coutMana ; 
	}
	
	/**
	 * Retourne le coût en mana de la carte.
	 * @return le coût en mana
	 */
	public int getCoutMana () {

		return coutMana ;
	}
	
	/**
	 * Retourne le nom de la carte.
	 * @return le nom de la carte
	 */
	public String getNom (){

		return nom ;
	}

	/**
	 * Méthode abstraite qui permet de jouer la carte.
	 * Doit être redéfinie dans les classes filles (Serviteur, Sort, Arme).
	 */
	public abstract void jouer ();

	/**
	 * Méthode abstraite qui permet d'afficher la carte.
	 * Doit être redéfinie dans les classes filles (Serviteur, Sort, Arme).
	 */
	public abstract void afficher();

	/**
	 * Méthode abstraite qui permet d'utiliser la carte.
	 * Doit être redéfinie dans les classes filles (Serviteur, Sort, Arme).
	 */
	public abstract void utiliser();

	private static final long serialVersionUID = 1L;

	/**
	 * Retourne la liste des serviteurs associés à la carte.
	 * @return liste de serviteurs (peut être vide ou null selon le type de carte)
	 */
    public abstract List<Carte> getServiteurs();
}
