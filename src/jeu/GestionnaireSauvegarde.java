package jeu;

import java.io.*;
import cartes.Carte;
import cartes.Deck;
import joueur.Joueur;

/**
 * Classe utilitaire pour la sauvegarde et le chargement des decks et des parties.
 */
public class GestionnaireSauvegarde {

    /** Dossier où sont stockées les sauvegardes */
    private static final String DOSSIER_SAUVEGARDE = "src/sauvegardes/";

    /**
     * Retourne le chemin complet du fichier de sauvegarde.
     * @param nomFichier le nom du fichier
     * @return le chemin complet du fichier
     */
    private static String cheminComplet(String nomFichier) {
        if (nomFichier.startsWith(DOSSIER_SAUVEGARDE)) {
            return nomFichier;
        }
        return DOSSIER_SAUVEGARDE + nomFichier;
    }

    /**
     * Sauvegarde un deck dans un fichier texte.
     * @param deck le deck à sauvegarder
     * @param nomFichier le nom du fichier de sauvegarde
     * @throws IOException en cas d'erreur d'écriture
     */
    public static void sauvegarderDeck(Deck deck, String nomFichier) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(cheminComplet(nomFichier)))) {
            for (Carte carte : deck.getCartes()) {
                if (carte instanceof cartes.Serviteur) {
                    cartes.Serviteur s = (cartes.Serviteur) carte;
                    writer.write("Serviteur," + s.getNom() + "," + s.getCoutMana() + "," + s.getVie() + "," + s.getAttaque() + "," + s.getPouvoirSpecial());
                } else if (carte instanceof cartes.Arme) {
                    cartes.Arme a = (cartes.Arme) carte;
                    writer.write("Arme," + a.getNom() + "," + a.getCoutMana() + "," + a.getDegats() + "," + a.getDurabilite());
                } else if (carte instanceof cartes.Sort) {
                    cartes.Sort so = (cartes.Sort) carte;
                    writer.write("Sort," + so.getNom() + "," + so.getCoutMana() + "," + so.getEffet() + "," + so.getValeur());
                }
                writer.newLine();
            }
        }
    }

    /**
     * Charge un deck depuis un fichier texte.
     * @param nomFichier le nom du fichier à charger
     * @return le deck chargé
     * @throws IOException en cas d'erreur de lecture
     */
    public static Deck chargerDeck(String nomFichier) throws IOException {
        Deck deck = new Deck();
        try (BufferedReader reader = new BufferedReader(new FileReader(cheminComplet(nomFichier)))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                String[] parts = ligne.split(",");
                String type = parts[0];
                if (type.equals("Serviteur")) {
                    String nom = parts[1];
                    int coutMana = Integer.parseInt(parts[2]);
                    int vie = Integer.parseInt(parts[3]);
                    int attaque = Integer.parseInt(parts[4]);
                    String pouvoir = parts[5];
                    deck.ajouterCarte(new cartes.Serviteur(nom, coutMana, vie, attaque, pouvoir));
                } else if (type.equals("Arme")) {
                    String nom = parts[1];
                    int coutMana = Integer.parseInt(parts[2]);
                    int degats = Integer.parseInt(parts[3]);
                    int durabilite = Integer.parseInt(parts[4]);
                    deck.ajouterCarte(new cartes.Arme(nom, coutMana, degats, durabilite));
                } else if (type.equals("Sort")) {
                    String nom = parts[1];
                    int coutMana = Integer.parseInt(parts[2]);
                    String effet = parts[3];
                    int valeur = Integer.parseInt(parts[4]);
                    deck.ajouterCarte(new cartes.Sort(nom, coutMana, effet, valeur));
                }
            }
        }
        return deck;
    }

    /**
     * Sauvegarde l'état d'une partie (exemple simplifié).
     * @param joueur1 le premier joueur
     * @param joueur2 le second joueur
     * @param numeroTour le numéro du tour actuel
     * @param nomFichier le nom du fichier de sauvegarde
     * @throws IOException en cas d'erreur d'écriture
     */
    public static void sauvegarderPartie(Joueur joueur1, Joueur joueur2, int numeroTour, String nomFichier) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(cheminComplet(nomFichier)))) {
            oos.writeObject(joueur1);
            oos.writeObject(joueur2);
            oos.writeInt(numeroTour);
        }
    }

    /**
     * Charge l'état d'une partie (exemple simplifié).
     * @param nomFichier le nom du fichier à charger
     * @return un tableau contenant les deux joueurs et le numéro du tour
     * @throws IOException en cas d'erreur de lecture
     * @throws ClassNotFoundException si une classe n'est pas trouvée lors de la désérialisation
     */
    public static Object[] chargerPartie(String nomFichier) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(cheminComplet(nomFichier)))) {
            Joueur joueur1 = (Joueur) ois.readObject();
            Joueur joueur2 = (Joueur) ois.readObject();
            int numeroTour = ois.readInt();
            return new Object[]{joueur1, joueur2, numeroTour};
        }
    }
}