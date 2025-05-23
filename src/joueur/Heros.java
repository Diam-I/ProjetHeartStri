package joueur;

import java.io.Serializable; 
import java.util.Scanner;

import cartes.Arme;

public class Heros implements Serializable { 
    private static final long serialVersionUID = 1L; 
	/**
	 * Classe qui decrit le heros 
	 */
	
	private String nom ; /* Le nom du heros */
	private String pouvoir ; /* Le pouvoir specifique a chaque heros */
	private Arme arme ; /* L'arme specifique a chaque heros */ /***** a modifier quand on va creer la classe arme ******/
	private int pointDeVie ; /* Les points de vie qu' a le heros */
	private int coutMana ; /* Le cout du manna qu'a le heros */
	
	
	/**
	 * Le constructeur de la classe Heros 
	 * @param nom
	 * @param pouvoir
	 * @param arme
	 * @param pointDeVie
	 * @param coutManna
	 */
	public Heros (String nom, String pouvoir, Arme arme, int pointDeVie , int coutMana) { /* Modifier le type d arme ici aussi */
		this.nom = nom ;
		this.pouvoir = pouvoir ;
		this.arme = arme ; 
		this.pointDeVie = pointDeVie ;
		this.coutMana = coutMana ;
		
	}
	
	public int getPointDeVie() {
		return pointDeVie;
	}
	
	public int getCoutMana() {
		return coutMana;
	}
	public String getNom() {
		return nom;
	}
	
	/**
	 * Methode qui permet d incremenet le cout du mana du heros a chaque tout tant qu elle n atteint pas les 10
	 */
	public void incrementerMana() {
		coutMana ++ ; 
	}
	
	public void recevoirDegat(int degat) {
		this.pointDeVie -= degat;
		if (this.pointDeVie <= 0) {
			System.out.println(this.nom + " est détruit !");
		}
	}
	
	/**
	 * Methode qui permet au joueur de choisir son heros en debut de partie
	 * @return le heros choisi par le joueur
	 */
	public static Heros choisirHeros() {
		
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
                heros = new Heros("Chevalier de la mort", "Explosion de glace", null, 3, 2);
                herosValide = true;
                break;
            case "2":
            	heros = new Heros("Chasseur de démons", "Frappe du chaos",null, 3, 2);
            	herosValide = true;
                break;
            case "3":
            	heros = new Heros("Druide", "Croissance sauvage",null, 30, 2);
            	herosValide = true;
                break;
            case "4":
            	heros = new Heros("Chasseur", "Tir précis",null, 30, 2);
            	herosValide = true;
                break;
            case "5":
            	heros = new Heros("Mage", "Boule de feu",null, 30, 2);
            	herosValide = true;
                break;
            case "6":
            	heros = new Heros("Paladin", "Renfort divin",null, 30, 2);
            	herosValide = true;
                break;
            case "7":
            	heros = new Heros("Prêtre", "Soins sacrés",null, 30, 2);
            	herosValide = true;
                break;
            case "8":
            	heros = new Heros("Voleur", "Attaque furtive",null, 30, 2);
            	herosValide = true;
                break;
            case "9":
            	heros = new Heros("Chaman", "Totem de feu",null, 30, 2);
            	herosValide = true;
                break;
            case "10":
            	heros = new Heros("Démoniste", "Lien démoniaque",null, 30, 2);
            	herosValide = true;
                break;
            case "11":
            	heros = new Heros("Guerrier", "Armure +2",null, 30, 2);
            	herosValide = true;
                break;
			}

		}
		return heros ;
		
	}
	
	/**
	 * Methode qui permet d attribuer une arme a un joueur 
	 */
	public void equiperArme(Arme arme) {
	    if (this.arme != null) {
	        System.out.println("L'arme " + this.arme.getNom() + " est remplacée par " + arme.getNom() + ".");
	    } else {
	        System.out.println("Vous équipez l'arme " + arme.getNom() + ".");
	    }
	    this.arme = arme;
	    arme.jouer();
	}
	/**
	 * Methode qui permet d attaquer l adverssaire avec l arme 
	 */
	public void attaquer() {
		if (arme!=null) {
			arme.utiliser();
			if (arme.getDurabilite()<=0) {
				// Si la durabilite atteint le 0, elle est detruite //
				arme = null ;
			}
			
		}
	}

	public void attaquer(Heros cible) {
	    if (arme != null) {
	        cible.recevoirDegat(arme.getDegats());
	        arme.utiliser();
	        if (arme.getDurabilite() <= 0) {
	            arme = null;
	        }
	    } else {
	        System.out.println("Aucune arme équipée !");
	    }
	}

	public void attaquer(cartes.Serviteur cible) {
	    if (arme != null) {
	        cible.recevoirDegat(arme.getDegats());
	        arme.utiliser();
	        if (arme.getDurabilite() <= 0) {
	            arme = null;
	        }
	    } else {
	        System.out.println("Aucune arme équipée !");
	    }
	}
	
	public Arme getArme() {
	    return arme;
	}

	public void setArme(Arme arme) {
	    this.arme = arme;
	}

	public void soigner(int soin) {
	    this.pointDeVie += soin;
	    System.out.println(this.nom + " est soigné de " + soin + " points !");
	}

	public boolean utiliserPouvoir(Joueur lanceur, Joueur cible) {
	    // Vérifie le coût en mana
	    if (lanceur.getMana() < this.coutMana) {
	        System.out.println("Pas assez de mana pour utiliser le pouvoir héroïque !");
	        return false;
	    }
	    lanceur.utiliseMana(this.coutMana);

	    switch (this.nom) {
	        case "Chasseur":
	            cible.getHeros().recevoirDegat(2);
	            System.out.println("Pouvoir du Chasseur : inflige 2 dégâts au héros adverse !");
	            break;
	        case "Druide":
	            // Donne +1 attaque au héros ce tour (simplifié)
	            System.out.println("Pouvoir du Druide : gagne +1 attaque ce tour (effet à implémenter selon ta logique) !");
	            break;
	        case "Guerrier":
	            this.pointDeVie += 2;
	            System.out.println("Pouvoir du Guerrier : gagne 2 points d’armure !");
	            break;
	        case "Mage":
	            cible.getHeros().recevoirDegat(1);
	            System.out.println("Pouvoir du Mage : inflige 1 dégât au héros adverse !");
	            break;
	        case "Paladin":
	            cartes.Serviteur recrue = new cartes.Serviteur("Recrue de la Main d'Argent", 1, 1, 1, "");
	            lanceur.ajouterServiteur(recrue);
	            System.out.println("Pouvoir du Paladin : invoque une Recrue 1/1 !");
	            break;
	        case "Prêtre":
	            this.pointDeVie += 2;
	            System.out.println("Pouvoir du Prêtre : soigne 2 points de vie !");
	            break;
	        case "Voleur":
	            cartes.Arme dague = new cartes.Arme("Dague", 1, 1, 2);
	            this.equiperArme(dague);
	            System.out.println("Pouvoir du Voleur : équipe une dague 1/2 !");
	            break;
	        case "Chaman":
	            System.out.println("Pouvoir du Chaman : invoque un totem (à implémenter) !");
	            break;
	        case "Démoniste":
	            this.recevoirDegat(2);
	            // Pioche d'une carte à implémenter si tu veux
	            System.out.println("Pouvoir du Démoniste : pioche une carte et subit 2 dégâts (pioche non implémentée) !");
	            break;
	        case "Chasseur de démons":
	            System.out.println("Pouvoir du Chasseur de démons : +1 attaque ce tour (à implémenter) !");
	            break;
	        case "Chevalier de la mort":
	            System.out.println("Pouvoir du Chevalier de la mort : effet spécial à implémenter !");
	            break;
	        default:
	            System.out.println("Pouvoir spécial non implémenté pour ce héros.");
	            break;
	    }
	    return true;
	}

}
