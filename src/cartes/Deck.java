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
	
	/**
	 * Methode qui permet de generer un deck avec des cartes legendaires
	 * @return le deck genere
	 */
	public static Deck genererDeckAvecLegendaires(Deck deck) {
		// Cartes emblématiques
		deck.ajouterCarte(new Serviteur("Ragnaros", 8, 8, 8, "Aucun"));
		deck.ajouterCarte(new Serviteur("Sylvanas Coursevent", 6, 5, 5, "Vol de vie"));
		deck.ajouterCarte(new Serviteur("Tirion Fordring", 8, 6, 6, "Provocation"));
		deck.ajouterCarte(new Serviteur("Ysera", 9, 12, 4, "Rêve"));
		deck.ajouterCarte(new Serviteur("Le Champion Envahi", 5, 6, 6, "Charge"));
	
		// Le reste du deck
		for (int i = 5; i < 30; i++) {
			deck.ajouterCarte(new Serviteur("Serviteur " + (i + 1), 5, 5, 5, "Aucun"));
		}
	
		return deck;
	}

}
