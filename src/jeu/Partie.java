package jeu;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

import cartes.Carte;
import cartes.Deck;
import cartes.Serviteur;
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
		/* Demander au joueur 1 de choisir son heros */
		Heros herosJoueur1 = Heros.choisirHeros();
		joueur1.setHeros(herosJoueur1); // Affecter le heros au joueur 1

		/* Demander au joueur 2 de choisir son heros */
		System.out.println("Joueur 2 c'est à vous !! ");	
		Heros herosJoueur2 = Heros.choisirHeros();
		joueur2.setHeros(herosJoueur2); // Affecter le heros au joueur 2
		/* Afficher les heros choisis par les deux joueurs */
		System.out.println("Joueur 1 : " + joueur1.getNom() + " a choisi le héros " + herosJoueur1.getNom());
		System.out.println("Joueur 2 : " + joueur2.getNom() + " a choisi le héros " + herosJoueur2.getNom());
		
		
		Deck deck1 = Deck.genererDeck();
		Deck deck2 = Deck.genererDeck(); // Créer un nouveau deck pour le joueur2
		
		/* Demander au joueur 1 de piocher 3 cartes de son deck */
		for (int i=0 ; i<3 ; i++) {
			joueur1.piocherCarte(deck1); // Piocher une carte du deck pour le joeur 1
		}		
		
		/* Demander au joueur 2 de piocher 4 cartes de son deck */
		for (int i=0 ; i<4 ; i++) {
			joueur2.piocherCarte(deck2); // Piocher une carte du deck pour le joeur 2
		}
		
		/* Initialiser le joueur actuel au joueur 1 */
		joueurActuel = joueur1 ;
		Joueur joueurAdverse = joueur2 ;
		/* Les 2 joueurs s affrontent tant qu'aucun heros n a un point de vie < 0 */ 
		while (!finPartie()) {
			System.out.println("C'est le tour numéro " + numeroTour + " : " + joueurActuel.getNom() + " joue.");
			//piocher une carte 
			if (joueurActuel == joueur1) {
				joueurActuel.piocherCarte(deck1);
			} else {
				joueurActuel.piocherCarte(deck2);
			}

			// Jouer un tour
        	Tour.jouerTour(joueurActuel, joueurAdverse);

			// Incrémenter le mana
			Heros herosJoueurActuelle = joueurActuel.getHeros() ;
			if (herosJoueurActuelle.getCoutMana() < 10) {
				herosJoueurActuelle.incrementerMana();
			}

			// Condition de blocage : plus de cartes en main, plus de serviteurs, deck vide
			boolean joueur1Bloque = deck1.estVide() && joueur1.getMain().isEmpty() && joueur1.getServiteurs().isEmpty();
			boolean joueur2Bloque = deck2.estVide() && joueur2.getMain().isEmpty() && joueur2.getServiteurs().isEmpty();
			if (joueur1Bloque && joueur2Bloque) {
				System.out.println("La partie est terminée, égalité !");
				return;
			}

			 // Condition de blocage : plus de serviteurs, deck vide, mais main non vide ET aucune carte jouable
			boolean joueur1PlusJouable = deck1.estVide() && joueur1.getServiteurs().isEmpty() && !peutJouerCarte(joueur1);
			boolean joueur2PlusJouable = deck2.estVide() && joueur2.getServiteurs().isEmpty() && !peutJouerCarte(joueur2);
			if (joueur1PlusJouable && joueur2PlusJouable) {
				System.out.println("La partie est terminée, égalité (plus aucune carte jouable) !");
				return;
			}

			// Passer au joueur suivant
			Joueur temp = joueurActuel;
			joueurActuel = joueurAdverse;
			joueurAdverse = temp;
			numeroTour++;
			
		}
		// Fin de la partie
		if (joueur1.getHeros().getPointDeVie() <= 0) {
			System.out.println(joueur2.getNom() + " a gagné la partie !");
		} else {
			System.out.println(joueur1.getNom() + " a gagné la partie !");
		}
	}

	private boolean peutJouerCarte(Joueur joueur) {
		int mana = joueur.getHeros().getCoutMana();
		for (Carte carte : joueur.getMain()) {
			if (carte.getCoutMana() <= mana) {
				return true;
			}
		}
		return false;
	}
}

