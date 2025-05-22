package jeu;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

import cartes.Carte;
import cartes.Deck;
import joueur.Heros;
import joueur.Joueur;

public class Partie implements Serializable {
	/**
	 * Classe qui represente une partie du jeu de HeartStone
	 */
	private static final long serialVersionUID = 1L;
	private Joueur joueur1 ; /* Le premier joueur de la partie du jeu */
	private Joueur joueur2 ; /* Le deuxieme joueur de la partie du jeu */
	private int numeroTour ; /* Le numéro du tour actuel */
	private Joueur joueurActuel ; /* Le joueur qui joue au tour actuel */
	private Plateau plateau ; /* Le plateau du jeu de la partie */
	
	
	/**
	 * Le constructeur de la classe Partie
	 * @param joueur1
	 * @param joueur2
	 * @param numeroTour
	 * @param joueurActuel
	 * @param plateau
	 */
	public Partie (Joueur joueur1, Joueur joueur2, int numeroTour , Joueur joueurActuel, Plateau plateau) {
		this.joueur1 = joueur1 ; 
		this.joueur2 = joueur2 ; 
		this.numeroTour = numeroTour ;
		this.joueurActuel = joueurActuel ; 
		this.plateau = plateau ;
	}
	
	/**
	 *  Methode qui determine si la partie est fini ou pas en fonction des points de vie des deux heros 
	 * @return true si la partie est fini, et false sinon
	 */
	public boolean finPartie () {
		Heros heros1 = joueur1.getHeros();
		Heros heros2 = joueur2.getHeros();
		
		/* Si un des heros a des points de vie <= 0, la partie est fini */
		return  ((heros1.getPointDeVie() <= 0)||(heros2.getPointDeVie())<=0) ;
	}

	

	/**
	 * Methode qui permet de demmarer la partie et de laisser chacun des deux joueurs choisir leur deck et heros 
	 */
	public void demarrer() {
        System.out.println("Début de la partie !");
        System.out.println("Joueur 1 c'est à vous !! ");
        Heros herosJoueur1 = Heros.choisirHeros();
        joueur1.setHeros(herosJoueur1);

        System.out.println("Joueur 2 c'est à vous !! ");	
        Heros herosJoueur2 = Heros.choisirHeros();
        joueur2.setHeros(herosJoueur2);
        System.out.println("Joueur 1 : " + joueur1.getNom() + " a choisi le héros " + herosJoueur1.getNom());
        System.out.println("Joueur 2 : " + joueur2.getNom() + " a choisi le héros " + herosJoueur2.getNom());
        
        Deck deck1 = Deck.genererDeck();
        Deck deck2 = Deck.genererDeck();
        
        for (int i=0 ; i<3 ; i++) {
            joueur1.piocherCarte(deck1);
        }		
        for (int i=0 ; i<4 ; i++) {
            joueur2.piocherCarte(deck2);
        }
        
        joueurActuel = joueur1 ;
        bouclePartie(deck1, deck2);
    }

	/**
	 * Reprend une partie sauvegardée (pas de re-choix, on continue)
	 */
	public void reprendrePartie() {
        System.out.println("Reprise de la partie !");
        // Les decks doivent être ceux déjà utilisés, à adapter si tu les sauvegardes aussi
        Deck deck1 = new Deck(); // À remplacer par le deck sauvegardé si besoin
        Deck deck2 = new Deck();
        bouclePartie(deck1, deck2);
    }

	/**
	 * Boucle principale de la partie (utilisée par les deux méthodes)
	 */
	private void bouclePartie(Deck deck1, Deck deck2) {
        Joueur joueurAdverse = (joueurActuel == joueur1) ? joueur2 : joueur1;
        Scanner scanner = new Scanner(System.in);

        while (!finPartie()) {
            System.out.println("C'est le tour numéro " + numeroTour + " : " + joueurActuel.getNom() + " joue.");
            System.out.println("Tapez 's' pour sauvegarder et quitter, ou appuyez sur Entrée pour continuer.");
            String choix = scanner.nextLine();
            if (choix.equalsIgnoreCase("s")) {
                System.out.print("Nom du fichier de sauvegarde : ");
                String nomFichier = scanner.nextLine();
                try {
                    GestionnaireSauvegarde.sauvegarderPartie(joueur1, joueur2, numeroTour, nomFichier);
                    System.out.println("Partie sauvegardée dans " + nomFichier + ". Fin de la partie.");
                } catch (IOException e) {
                    System.out.println("Erreur lors de la sauvegarde : " + e.getMessage());
                }
                return;
            }

            if (joueurActuel == joueur1) {
                joueurActuel.piocherCarte(deck1);
            } else {
                joueurActuel.piocherCarte(deck2);
            }

            Tour.jouerTour(joueurActuel, joueurAdverse);
            Heros herosJoueurActuelle = joueurActuel.getHeros();
            if (herosJoueurActuelle.getCoutMana() < 10) {
                herosJoueurActuelle.incrementerMana();
            }
            Joueur temp = joueurActuel;
            joueurActuel = joueurAdverse;
            joueurAdverse = temp;
            numeroTour++;
        }
        if (joueur1.getHeros().getPointDeVie() <= 0) {
            System.out.println(joueur2.getNom() + " a gagné la partie !");
        } else {
            System.out.println(joueur1.getNom() + " a gagné la partie !");
        }
    }
	
	public static void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenue dans HeartStri !");
        System.out.println("1 - Nouvelle partie");
        System.out.println("2 - Charger une partie");
        System.out.println("3 - Charger un deck");
        System.out.print("Votre choix : ");
        String choix = scanner.nextLine();

        if (choix.equals("1")) {
            System.out.print("Nom du joueur 1 : ");
            String nom1 = scanner.nextLine();
            System.out.print("Nom du joueur 2 : ");
            String nom2 = scanner.nextLine();
            Joueur joueur1 = new Joueur(nom1);
            Joueur joueur2 = new Joueur(nom2);
            Plateau plateau = new Plateau();
            Partie partie = new Partie(joueur1, joueur2, 1, joueur1, plateau);
            partie.demarrer();
        } else if (choix.equals("2")) {
            System.out.print("Nom du fichier de sauvegarde : ");
            String fichier = scanner.nextLine();
            // Ajoute le dossier si besoin
            String cheminFichier = "src/sauvegardes/" + fichier;
            try {
                Object[] etat = GestionnaireSauvegarde.chargerPartie(cheminFichier);
                Joueur joueur1 = (Joueur) etat[0];
                Joueur joueur2 = (Joueur) etat[1];
                int numeroTour = (int) etat[2];
                Plateau plateau = new Plateau();
                Partie partie = new Partie(joueur1, joueur2, numeroTour, joueur1, plateau);
                partie.reprendrePartie();
            } catch (Exception e) {
                System.out.println("Erreur lors du chargement : " + e.getMessage());
            }
        } else if (choix.equals("3")) {
            // Charger un deck
            System.out.print("Nom du fichier du deck : ");
            String fichierDeck = scanner.nextLine();
            try {
                Deck deck = GestionnaireSauvegarde.chargerDeck(fichierDeck);
                System.out.println("Deck chargé avec succès !");
                for (Carte carte : deck.getCartes()) {
                    System.out.println("- " + carte.getNom());
                }
            } catch (Exception e) {
                System.out.println("Erreur lors du chargement du deck : " + e.getMessage());
            }
        } else {
            System.out.println("Choix invalide.");
        }
    }
}

