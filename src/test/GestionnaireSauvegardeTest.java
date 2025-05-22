package test;

import cartes.Deck;
import jeu.GestionnaireSauvegarde;
import joueur.Joueur;

import java.io.File;

public class GestionnaireSauvegardeTest {
    public static void main(String[] args) throws Exception {
        // Test sauvegarderPartie et chargerPartie
        Joueur joueur1 = new Joueur("Alice");
        Joueur joueur2 = new Joueur("Bob");
        int numeroTour = 3;

        String fichier = "test_partie.sav";
        GestionnaireSauvegarde.sauvegarderPartie(joueur1, joueur2, numeroTour, fichier);

        Object[] etat = GestionnaireSauvegarde.chargerPartie(fichier);
        Joueur joueur1Charge = (Joueur) etat[0];
        Joueur joueur2Charge = (Joueur) etat[1];
        int numeroTourCharge = (int) etat[2];

        if (!joueur1.getNom().equals(joueur1Charge.getNom())) {
            System.out.println("Erreur: joueur1 non conforme");
        } else if (!joueur2.getNom().equals(joueur2Charge.getNom())) {
            System.out.println("Erreur: joueur2 non conforme");
        } else if (numeroTour != numeroTourCharge) {
            System.out.println("Erreur: numeroTour non conforme");
        } else {
            System.out.println("Test sauvegarder/charger partie réussi !");
        }
        new File(fichier).delete();

        // Test sauvegarderDeck et chargerDeck
        Deck deck = new Deck();
        deck.ajouterCarte(new cartes.Serviteur("Serv1", 2, 3, 4, "Pouvoir1"));
        deck.ajouterCarte(new cartes.Arme("Arme1", 3, 5, 2));
        deck.ajouterCarte(new cartes.Sort("Sort1", 1, "Effet1", 7));
        String fichierDeck = "test_deck.txt";
        GestionnaireSauvegarde.sauvegarderDeck(deck, fichierDeck);

        Deck deckCharge = GestionnaireSauvegarde.chargerDeck(fichierDeck);
        if (deckCharge.getCartes().size() != 3) {
            System.out.println("Erreur: nombre de cartes dans le deck chargé incorrect");
        } else if (!deckCharge.getCartes().get(0).getNom().equals("Serv1")) {
            System.out.println("Erreur: première carte du deck chargé incorrecte");
        } else if (!deckCharge.getCartes().get(1).getNom().equals("Arme1")) {
            System.out.println("Erreur: deuxième carte du deck chargé incorrecte");
        } else if (!deckCharge.getCartes().get(2).getNom().equals("Sort1")) {
            System.out.println("Erreur: troisième carte du deck chargé incorrecte");
        } else {
            System.out.println("Test sauvegarder/charger deck réussi !");
        }
        new File(fichierDeck).delete();
    }
}