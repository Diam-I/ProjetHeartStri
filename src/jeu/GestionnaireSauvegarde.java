package jeu;

import java.io.*;
import java.util.List;
import cartes.Carte;
import cartes.Deck;
import joueur.Joueur;

public class GestionnaireSauvegarde {

    // Sauvegarder un deck dans un fichier texte
    public static void sauvegarderDeck(Deck deck, String nomFichier) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomFichier))) {
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

    // Charger un deck depuis un fichier texte
    public static Deck chargerDeck(String nomFichier) throws IOException {
        Deck deck = new Deck();
        try (BufferedReader reader = new BufferedReader(new FileReader(nomFichier))) {
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

    // Sauvegarder l’état d’une partie (exemple simplifié)
    public static void sauvegarderPartie(Joueur joueur1, Joueur joueur2, int numeroTour, String nomFichier) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomFichier))) {
            oos.writeObject(joueur1);
            oos.writeObject(joueur2);
            oos.writeInt(numeroTour);
        }
    }

    // Charger l’état d’une partie (exemple simplifié)
    public static Object[] chargerPartie(String nomFichier) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomFichier))) {
            Joueur joueur1 = (Joueur) ois.readObject();
            Joueur joueur2 = (Joueur) ois.readObject();
            int numeroTour = ois.readInt();
            return new Object[]{joueur1, joueur2, numeroTour};
        }
    }
}