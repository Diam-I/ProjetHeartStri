package test;
import cartes.*;
import java.util.ArrayList;
import java.util.Random;

public class Combat {
	/*
	 * Classe Combat
	 * 
	 * Cette classe permet de simuler un combat entre deux serviteurs
	 * sélectionnés aléatoirement dans un deck de cartes.
	 * 
	 * Elle utilise les méthodes de la classe Serviteur pour effectuer les attaques
	 * et affiche le résultat du duel jusqu’à ce que l’un des deux soit vaincu.
	 * 
	 * Auteur : [Ton Nom]
	 * Date : [Date actuelle]
	 */
    public static void main(String[] args) {
    	
        // Création d'une liste de serviteurs
        ArrayList<Serviteur> deck = new ArrayList<>();
        // Ajout de serviteurs avec leur nom, coût de mana, points d'attaque, points de vie et capacité spéciale
        deck.add(new Serviteur("Ragnaros", 8, 8, 8, "Aucun"));
        deck.add(new Serviteur("Sylvanas Coursevent", 6, 5, 5, "Vol de vie"));
        deck.add(new Serviteur("Tirion Fordring", 8, 6, 6, "Provocation"));
        deck.add(new Serviteur("Ysera", 9, 12, 4, "Rêve"));
        deck.add(new Serviteur("Le Champion Envahi", 5, 6, 6, "Charge"));
        
        // Sélection aléatoire de deux serviteurs différents depuis le deck
        Random random = new Random();
        Serviteur serviteur1 = deck.get(random.nextInt(deck.size()));
        Serviteur serviteur2 = deck.get(random.nextInt(deck.size()));

        // Verification que les deux serviteurs sont différents
        while (serviteur1 == serviteur2) {
            serviteur2 = deck.get(random.nextInt(deck.size()));
        }
       //Affichage des serviteurs choisis         
        System.out.println("Serviteur 1 sélectionné : " + serviteur1);
        System.out.println("Serviteur 2 sélectionné : " + serviteur2);
        //Combat entre les deux serviteurs jusqu'à ce que l'un d'eux meure
        while (serviteur1.getVie() > 0 && serviteur2.getVie() > 0) {
            serviteur1.attaquer(serviteur2);
            if (serviteur2.getVie() > 0) {
                serviteur2.attaquer(serviteur1);
            }
        }
        //Affichage du vainqueur 
        if (serviteur1.getVie() > 0) {
            System.out.println(serviteur1.getNom() + " a gagné le combat !");
        } else {
            System.out.println(serviteur2.getNom() + " a gagné le combat !");
        }
    }
}
