package test;
import jeu.Partie;
import jeu.Plateau;
import joueur.Joueur;

public class Combat {
    public static void main(String[] args) {
        
        // Création des deux joueurs
        Joueur joueur1 = new Joueur("Joueur 1");
        Joueur joueur2 = new Joueur("Joueur 2");

        // Création du plateau
        Plateau plateau = new Plateau();

        // Création de la partie avec les joueurs, le plateau, et les paramètres initiaux
        Partie partie = new Partie(joueur1, joueur2, 1, joueur1, plateau);

        // Lancement de la partie
        partie.menuPrincipal();


    }
}
