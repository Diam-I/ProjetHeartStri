package jeu;

import java.util.List;
import java.util.Scanner;

import cartes.Carte;
import cartes.Serviteur;
import joueur.Joueur;

public class Tour {

	/**
	 * Methode qui permet de jouer un tour
	 * @param joueurActuel : le joueur qui joue le tour
	 * @param joueurAdverse : le joueur adverse
	 */
	public static void jouerTour(Joueur joueurActuel, Joueur joueurAdverse) {
		// Le joueur active une des cartes qu il a dans les mains en la posant sur le plateau //
		// Si le joueur a encore des cartes en main //
		if (!joueurActuel.getMain().isEmpty()) {
			List<Carte> main = joueurActuel.getMain();
			Scanner scanner = new Scanner(System.in);
			boolean carteJouee = false;
			while (!carteJouee) {
				System.out.println("Vous avez " + joueurActuel.getMana() + " mana.");
				System.out.println("Voici les cartes que vous avez encore en main : ");
				for (int i = 0; i < main.size(); i++) {
					int indice = i + 1;
					System.out.println("-" + indice + " " + main.get(i).getNom() + " (Mana : " + main.get(i).getCoutMana() + ")");
				}
				boolean auMoinsUneJouable = false;
				for (Carte c : main) {
					if (c.getCoutMana() <= joueurActuel.getMana()) {
						auMoinsUneJouable = true;
						break;
					}
				}
				if (!auMoinsUneJouable) {
					System.out.println("Vous n'avez pas assez de mana pour jouer une carte ce tour. Vous passez automatiquement.");
					break;
				}
				System.out.println("Veuillez choisir une carte à activer (0 pour passer) : ");
				int choixCarte = scanner.nextInt();
				if (choixCarte == 0) {
					break; // Le joueur passe
				}
				Carte carteChoisie = joueurActuel.getMain().get(choixCarte - 1);

				// Vérification du mana
				if (carteChoisie.getCoutMana() > joueurActuel.getMana()) {
					System.out.println("Vous n'avez pas assez de mana pour activer cette carte ! Choisissez-en une autre.");
				} else {
					joueurActuel.utiliseMana(carteChoisie.getCoutMana());

					if (carteChoisie instanceof cartes.Serviteur) {
						joueurActuel.ajouterServiteur((cartes.Serviteur) carteChoisie);
						System.out.println("Le serviteur " + carteChoisie.getNom() + " a été ajouté à la liste des serviteurs de " + joueurActuel.getNom() + ".");
					} else if (carteChoisie instanceof cartes.Arme) {
						joueurActuel.getHeros().equiperArme((cartes.Arme) carteChoisie);
						System.out.println("Le héros " + joueurActuel.getNom() + " équipe l'arme " + carteChoisie.getNom() + ".");
					} else if (carteChoisie instanceof cartes.Sort) {
						cartes.Sort sort = (cartes.Sort) carteChoisie;
						if (sort.getEffet().equalsIgnoreCase("degat")) {
							joueurAdverse.getHeros().recevoirDegat(sort.getValeur());
							System.out.println("Le sort inflige " + sort.getValeur() + " dégâts au héros adverse !");
						} else if (sort.getEffet().equalsIgnoreCase("soin")) {
							joueurActuel.getHeros().soigner(sort.getValeur());
							System.out.println("Le sort soigne votre héros de " + sort.getValeur() + " points !");
						}
					}
					joueurActuel.retirerCarteMain(carteChoisie);
					carteJouee = true;
				}
			}
		} else {
			System.out.println("Vous n'avez aucune carte en main !");
		}
		
		// Le joueur veut attaquer //
		// Le joueur n a pas de serviteur invoques sur le plateau //
		if (joueurActuel.getServiteurs().isEmpty()) {
	        
			System.out.println(joueurActuel.getNom() + " n'a pas de serviteurs invoqués et ne peut pas attaquer !");
	    } else { 
	    	// Le joueur a des serviteur invoques sur le plateau //
			// Vérifier si le joueur peut attaquer le héros adverse
			
			if (joueurAdverse.getServiteurs().isEmpty()) {
				System.out.println(joueurActuel.getNom() + " attaque le héros adverse !");
				Serviteur serviteur = (Serviteur) joueurActuel.getServiteurs().get(0); // Exemple : premier serviteur
	
				serviteur.attaquer(joueurAdverse.getHeros());
			} else {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Choisissez le serviteur qui attaque :");
				List<Serviteur> serviteursActuels = joueurActuel.getServiteurs();
				for (int i = 0; i < serviteursActuels.size(); i++) {
					System.out.println((i + 1) + " - " + serviteursActuels.get(i));
				}
				int choixAttaquant = scanner.nextInt() - 1;
				Serviteur attaquant = (Serviteur) serviteursActuels.get(choixAttaquant);

				// Choix de la cible
				System.out.println("Choisissez la cible :");
				System.out.println("0 - Attaquer le héros adverse (" + joueurAdverse.getHeros().getNom() + ")");
				List<Serviteur> serviteursAdverses = joueurAdverse.getServiteurs();
				for (int i = 0; i < serviteursAdverses.size(); i++) {
					System.out.println((i + 1) + " - " + serviteursAdverses.get(i));
				}
				int choixCible = scanner.nextInt();
				if (choixCible == 0) {
					attaquant.attaquer(joueurAdverse.getHeros());
				} else {
					Serviteur cible = serviteursAdverses.get(choixCible - 1);
					attaquant.attaquer(cible);
					if (cible.getVie() <= 0) {
						joueurAdverse.retirerServiteur(cible);
					}
				}
			}
	    }
		
		// Nouvelle phase : Utilisation du pouvoir héroïque //
		Scanner scanner = new Scanner(System.in);
		System.out.println("Voulez-vous utiliser le pouvoir héroïque ? (o/n)");
		String reponse = scanner.nextLine();
		if (reponse.equalsIgnoreCase("o")) {
		    
			joueurActuel.getHeros().utiliserPouvoir(joueurActuel, joueurAdverse);
		}
	}
}
