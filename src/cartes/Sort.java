package cartes;

import java.util.List;

/**
 * Représente un sort dans le jeu.
 * Un sort possède un effet et une valeur associée à cet effet.
 */
public class Sort extends Carte  {
	private static final long serialVersionUID = 1L;
	/** Effet du sort */
	private String effet ; 
	/** Valeur associée à l'effet du sort */
	private int valeur ;

	/**
	 * Constructeur de la classe Sort.
	 * @param nom le nom du sort
	 * @param coutMana le coût en mana du sort
	 * @param effet l'effet du sort
	 * @param valeur la valeur de l'effet
	 */
	public Sort(String nom, int coutMana, String effet, int valeur) {
		super(nom, coutMana);
		this.effet = effet; 
		this.valeur = valeur ;
	}

	/**
	 * Retourne l'effet du sort.
	 * @return l'effet
	 */
	public String getEffet () {
		return effet ;
	}

	/**
	 * Retourne la valeur de l'effet du sort.
	 * @return la valeur de l'effet
	 */
	public int getValeur () {
		return valeur; 
	}

	/**
	 * Joue le sort.
	 */
	@Override
	public void jouer() {
		
	}

	/**
	 * Affiche les caractéristiques du sort.
	 */
	@Override
	public void afficher() {
		
	}

	/**
	 * Utilise le sort (affiche l'effet).
	 */
	@Override
	public void utiliser() {
	    // Cette méthode devra recevoir la cible en paramètre pour être vraiment utile
	    // Exemple d'utilisation générique (à adapter selon l'appel)
	    System.out.println("Le sort " + getNom() + " est utilisé. Effet : " + effet);
	    // Ici, il faudrait appliquer l'effet à la cible (serviteur ou héros)
	}

	/**
	 * Retourne la liste des serviteurs associés à ce sort (non implémenté).
	 * @return liste de serviteurs
	 */
	@Override
	public List<Carte> getServiteurs() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getServiteurs'");
	}
}
