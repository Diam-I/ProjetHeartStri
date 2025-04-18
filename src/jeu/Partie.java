package jeu;

import java.util.Scanner;

import joueur.Heros;
import joueur.Joueur;

public class Partie {
	/**
	 * Classe qui represente une partie du jeu de HeartStone
	 */
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
	 * Methode qui permet de demmarer la partie et de laisser chacun des deux joueurs choisir leur deck et heros 
	 */
	public void demarrer() {
		System.out.println("Début de la partie !");
		
		/* Demander au joueur 1 de choisir son heros */
		Heros herosJoueur1 = choisirHeros();
		
		/* Demander au joueur 2 de choisir son heros */
		Heros herosJoueur2 = choisirHeros();

		/* Demander au joueur 1 de piocher 3 cartes de son deck */
		for (int i=0 ; i<3 ; i++) {
			joueur1.piocherCarte();
		}		
		
		/* Demander au joueur 2 de piocher 4 cartes de son deck */
		for (int i=0 ; i<4 ; i++) {
			joueur2.piocherCarte();
		}
		
		/* Initialiser le joueur actuel au joueur 1 */
		joueurActuel = joueur1 ;
		/* Les 2 joueurs s affrontent tant qu'aucun heros n a un point de vie < 0 */ 
		while (!finPartie()) {
			joueurActuel.jouerTour();
			/* Incrementer le nombre de mana du hero si il est < 10 */
			Heros herosJoueurActuelle = joueurActuel.getHeros() ;
			if (herosJoueurActuelle.getCoutMana() < 10) {
				herosJoueurActuelle.incrementerMana();
			}
			/* Passer à l autre joueur */
			if (joueurActuel == joueur1) {
				joueurActuel = joueur2; 
			}
			else {
				joueurActuel = joueur1 ;
			}
		}
		
	}
	
		
	
	/**
	 * Methode qui permet au joueur de choisir son heros en debut de partie
	 * @return le heros choisi par le joueur
	 */
	public Heros choisirHeros() {
		
		Scanner input = new Scanner(System.in);
		boolean herosValide = false ;
		Heros heros = null ;
		
		/* Demander au joueur de saisir le numéro corredpondant a son heros tant que son choix n'est pas valide */
		while (!herosValide) {
			System.out.println("Veuillez choisir un héros parmis la liste des héros possible : ");
			System.out.println("1- Chevalier de la mort\n2- Chasseur de démons\n3-Druide\n4- Chasseur\n5- Mage\n6- Paladin\n7- Prêtre\n8- Voleur\n9- Chaman\n10- Démoniste\n11- Guerrier");
			String numeroHeros = input.nextLine();
			switch (numeroHeros) {
			/* Pour la partie 2 on ne gère pas encore les armes, donc on met que les "" */
			case "1":
                heros = new Heros("Chevalier de la mort", "Explosion de glace", "", 30, 2);
                herosValide = true;
                break;
            case "2":
            	heros = new Heros("Chasseur de démons", "Frappe du chaos","", 30, 2);
            	herosValide = true;
                break;
            case "3":
            	heros = new Heros("Druide", "Croissance sauvage","", 30, 2);
            	herosValide = true;
                break;
            case "4":
            	heros = new Heros("Chasseur", "Tir précis","", 30, 2);
            	herosValide = true;
                break;
            case "5":
            	heros = new Heros("Mage", "Boule de feu","", 30, 2);
            	herosValide = true;
                break;
            case "6":
            	heros = new Heros("Paladin", "Renfort divin","", 30, 2);
            	herosValide = true;
                break;
            case "7":
            	heros = new Heros("Prêtre", "Soins sacrés","", 30, 2);
            	herosValide = true;
                break;
            case "8":
            	heros = new Heros("Voleur", "Attaque furtive","", 30, 2);
            	herosValide = true;
                break;
            case "9":
            	heros = new Heros("Chaman", "Totem de feu","", 30, 2);
            	herosValide = true;
                break;
            case "10":
            	heros = new Heros("Démoniste", "Lien démoniaque","", 30, 2);
            	herosValide = true;
                break;
            case "11":
            	heros = new Heros("Guerrier", "Armure +2","", 30, 2);
            	herosValide = true;
                break;
			}

		}
		return heros ;
		
	}
	
	
	/**
	 *  Methode qui determine si la partie est fini ou pas en fonction des points de vie des deux heros 
	 * @return true si la partie est fini, et false sinon
	 */
	public boolean finPartie () {
		Heros heros1 = joueur1.getHeros();
		Heros heros2 = joueur2.getHeros();
		
		/* Si un des heros a des points de vie <= 0, la partie est fini */
		if ((heros1.getPointDeVie() <= 0)||(heros2.getPointDeVie())<=0) {
			return true ;
		}
		return false ;
	}

}
