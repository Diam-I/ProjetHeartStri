package cartes;

import java.util.ArrayList;
import java.util.List;

public class Deck  {

	/**
	 * Classe qui contient le deck d'un joueur
	 */
	
	private List<Carte> cartes ;
	
	/**
	 * Le constructeur de la classe Deck
	 */
	public Deck() {
		this.cartes = new ArrayList<Carte>();		
	}
	 
	public void ajouterCarte(Carte carte) {
		/* 
		 * Methode qui permet d'ajouter une carte au deck
		 * @param carte : la carte à ajouter au deck
		 */
		this.cartes.add(carte); // Ajoute la carte à la liste des cartes du deck
	}
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

	

}
