package cartes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.Serializable; 

public class Deck implements Serializable {

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
	
	public boolean estVide() {
	    return cartes.isEmpty();
	}
	
	/**
	 * Methode qui permet de generer un deck avec des cartes legendaires
	 * @return le deck genere
	 */
	public static Deck genererDeck() {
		 Deck deck = new Deck();
		 List<Carte> cartes = new ArrayList<>();
		 Carte nouvelleCarte = null;

		 // Récupèrer les cartes du fichiers qui contient toutes les cartes //
		 try (BufferedReader br = new BufferedReader(new FileReader("src/cartes.csv"))) {
		        String ligne = br.readLine();;
		        while ((ligne = br.readLine()) != null) {
		            String[] parts = ligne.split(",");
		           if (parts.length == 5) {
						// Serviteur
						String nom = parts[0].trim();
						int cout = Integer.parseInt(parts[1].trim());
						int vie = Integer.parseInt(parts[2].trim());
						int attaque = Integer.parseInt(parts[3].trim());
						String pouvoir = parts[4].trim();
						nouvelleCarte = new Serviteur(nom, cout, vie, attaque, pouvoir);
					} else if (parts.length == 4 && !parts[2].matches("\\d+") && parts[3].matches("\\d+")) {
						// Sort
						String nom = parts[0].trim();
						int cout = Integer.parseInt(parts[1].trim());
						String effet = parts[2].trim();
						int valeur = Integer.parseInt(parts[3].trim());
						nouvelleCarte = new Sort(nom, cout, effet, valeur);
					} else if (parts.length == 4 && parts[2].matches("\\d+") && parts[3].matches("\\d+")) {
						// Arme
						String nom = parts[0].trim();
						int cout = Integer.parseInt(parts[1].trim());
						int degats = Integer.parseInt(parts[2].trim());
						int durabilite = Integer.parseInt(parts[3].trim());
						nouvelleCarte = new Arme(nom, cout, degats, durabilite);
					}
					if (nouvelleCarte != null) {
						cartes.add(nouvelleCarte); 
					}
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		 // Tirer au sort 30 cartes parmi les cartes récupéré //
		 Random random = new Random();

	    while (deck.getCartes().size() < 30 && deck.getCartes().size() < cartes.size()) {
	        int index = random.nextInt(cartes.size());
	        Carte carte_tire = cartes.get(index);

	        // Verifier si la carte est deja dans le deck //
	        boolean dejaDansDeck = false;
	        for (Carte c : deck.getCartes()) {
	            if (c.getNom().equals(carte_tire.getNom())) {
	                dejaDansDeck = true;
	                break;
	            }
	        }

	        if (!dejaDansDeck) {
	            
	            deck.ajouterCarte(carte_tire);
	        }
		    }
		return deck;
	}

}
