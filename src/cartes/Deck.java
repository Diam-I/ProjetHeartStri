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
	public Carte getCarte(int index) {
		// Methode qui retourne la carte à l'index donné
		return cartes.get(index); // On retourne la carte à l'index donné
	}
	public void ajouterCarte(Carte carte) {
		// Methode qui permet d'ajouter une carte au deck
		this.cartes.add(carte); // On ajoute la carte à la liste des cartes du deck
	}
	public void retirerCarte(Carte carte) {
		// Methode qui permet de retirer une carte du deck
		cartes.remove(carte); // On retire la carte de la liste des cartes du deck

	}
	public List<Carte> getCartes() {
		// Methode qui retourne la liste des cartes du deck
		return cartes; // On retourne la liste des cartes du deck
	}
	

}
