package cartes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	public static Deck genererDeckAvecLegendaires() {
		 Deck deck = new Deck();
		 List<Serviteur> cartes = new ArrayList<>();
		 // Récupèrer les cartes du fichiers qui contient toutes les cartes //
		 try (BufferedReader br = new BufferedReader(new FileReader("src/cartes.csv"))) {
		        String ligne = br.readLine();;
		        while ((ligne = br.readLine()) != null) {
		            String[] parts = ligne.split(",");
		            if (parts.length == 5) {
		                String nom = parts[0].trim();
		                int cout = Integer.parseInt(parts[1].trim());
		                int vie = Integer.parseInt(parts[2].trim());
		                int attaque = Integer.parseInt(parts[3].trim());
		                String pouvoir = parts[4].trim();
		                cartes.add(new Serviteur(nom, cout, vie, attaque, pouvoir));
		            }
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		 // Tirer au sort 30 cartes parmi les cartes récupéré //
		 Random random = new Random();

	    while (deck.getCartes().size() < 30 && deck.getCartes().size() < cartes.size()) {
	        int index = random.nextInt(cartes.size());
	        Serviteur carte_tire = cartes.get(index);

	        // Verifier si la carte est deja dans le deck //
	        boolean dejaDansDeck = false;
	        for (Carte c : deck.getCartes()) {
	            if (c.getNom().equals(carte_tire.getNom())) {
	                dejaDansDeck = true;
	                break;
	            }
	        }

	        if (!dejaDansDeck) {
	            Serviteur copie = new Serviteur(
	                carte_tire.getNom(),
	                carte_tire.getCoutMana(),
	                carte_tire.getVie(),
	                carte_tire.getAttaque(),
	                carte_tire.getPouvoirSpecial()
	            );
	            deck.ajouterCarte(copie);
	        }
		    }
		return deck;
	}

}
