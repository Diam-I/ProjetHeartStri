package jeu;

import java.util.List;
import java.util.Scanner;

import cartes.Arme;
import cartes.Carte;
import cartes.Serviteur;
import cartes.Sort;
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
			System.out.println("Voici les cartes que vous avez encore en main : \n");
			for (int i=0 ; i<main.size();i++) {
				int indice = i+1;
				System.out.println("-" + indice + " " + main.get(i).getNom() + " ;\n");
			}
			System.err.println("Veuillez choisir une carte que vous voulez activer (mettre sur le plateau) : \n");
			Scanner scanner = new Scanner(System.in);
			int choix = scanner.nextInt();
			
			// Vérifier que le choix est valide //
			if (choix >= 0 && choix<=main.size()) {
				// Vérifier que la carte est un serviteur //
				Carte carte = main.get(choix-1);
				if (carte instanceof Serviteur) {
					Serviteur serviteurPlace = (Serviteur) carte;
					joueurActuel.ajouteServiteur(serviteurPlace,choix-1);
				}
				// Si la carte est une arme //
				else if (carte instanceof Arme){
					// Equiper le joueur avec cette arme //
					joueurActuel.getHeros().equiperArme((Arme) carte);
				}
				else if (carte instanceof Sort) {
					Sort sort = (Sort) carte ; 
					if (sort.getEffet().equals("soin")) {
						// Le joueur doit choisir quel serviteur soigner //
						System.out.println("Choisissez un serviteur à soigner :");
						List<Serviteur> serviteurs = joueurActuel.getServiteurs();
						for (int i = 0; i < serviteurs.size(); i++) {
						    System.out.println((i + 1) + " - " + serviteurs.get(i).getNom() + " (" + serviteurs.get(i).getVie() + " Points de Vie)");
						}
						int serviteur  = scanner.nextInt();
						scanner.nextLine(); 

						if (serviteur >= 1 && serviteur <= serviteurs.size()) {
						    Serviteur cible = serviteurs.get(serviteur - 1);
						    cible.soigner(3); 
						    System.out.println(cible.getNom() + " a été soigné !");
						} else {
						    System.out.println("Choix invalide.");
						}
					}
					else if (sort.getEffet().equals("degat")) {
						// Le joueur doit choisir quel serviteur attaquer //
						System.out.println("Choisissez une cible pour le sort de dégâts :");
						System.out.println("Héros adverse (" + joueurAdverse.getHeros().getPointDeVie() + " Points de Vie)");

						List<Serviteur> serviteursAdverses = joueurAdverse.getServiteurs();
						for (int i = 0; i < serviteursAdverses.size(); i++) {
						    Serviteur serviteur = serviteursAdverses.get(i);
						    System.out.println((i + 1) + " - " + serviteur.getNom() + " (" + serviteur.getVie() + " Points de Vie)");
						}

						int serviteur_cible = scanner.nextInt();
						scanner.nextLine(); 
						if (serviteur_cible == 0) {
						    joueurAdverse.getHeros().recevoirDegat(3);
						    System.out.println("Le héros adverse a subi 3 dégâts !"); ///// On doit le modifier plus tard !!!!!!!!!!!!!!!!!
						} else if (serviteur_cible >= 1 && serviteur_cible <= serviteursAdverses.size()) {
						    Serviteur cible = serviteursAdverses.get(serviteur_cible - 1);
						    cible.recevoirDegat(3); /////////////
						    System.out.println(cible.getNom() + " a subi 3 dégâts !"); /////////////////
						} else {
						    System.out.println("Choix invalide.");
						}

					}
					else if (sort.getEffet().equals("boost")) {
						// Le joueur doit choisir un serviteur a booster //
						List<Serviteur> serviteurs = joueurActuel.getServiteurs();
						if (serviteurs.isEmpty()) {
						    System.out.println("Aucun serviteur à booster.");
						} else {
						    System.out.println("Choisissez un serviteur à booster :");
						    for (int i = 0; i < serviteurs.size(); i++) {
						        Serviteur s = serviteurs.get(i);
						        System.out.println((i + 1) + " - " + s.getNom() + " (Attaque : " + s.getAttaque() + ", Points de Vie : " + s.getVie() + ")");
						    }

						    int serviteur_booster = scanner.nextInt();
						    scanner.nextLine(); 

						    if (serviteur_booster >= 1 && serviteur_booster <= serviteurs.size()) {
						        Serviteur cible = serviteurs.get(serviteur_booster - 1);
						        cible.setAttaque(cible.getAttaque() + 2); ///// A modifier !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
						        cible.recevoirDegat(-2); //// A modifier !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
						        System.out.println(cible.getNom() + " a été boosté (+2 Attaque, +2 PV)."); //// A modifier !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
						    } else {
						        System.out.println("Choix invalide.");
						    }
						}

					 }
					joueurActuel.getMain().remove(carte); // Retirer la carte de la main après utilisation
				}
				
			}
			else {
				System.out.println("Le choix de la carte est invalide !");
			}
		}
		// Si le joueur n'a plus de carte en main //
		else {
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
				Serviteur serviteur = joueurActuel.getServiteurs().get(0); // Exemple : premier serviteur
	
				serviteur.attaquer(joueurAdverse.getHeros());
			} else {
	
				System.out.println(joueurActuel.getNom() + " attaque un serviteur adverse !");
				Serviteur serviteur = joueurActuel.getServiteurs().get(0); // Exemple : premier serviteur
				Serviteur cible = joueurAdverse.getServiteurs().get(0); // Exemple : premier serviteur adverse
				serviteur.attaquer(cible);
		
				// Si le serviteur adverse est détruit, le retirer
				if (cible.getVie() <= 0) {
					joueurAdverse.retirerServiteur(cible);
				}
			}
	    }
	}
}
