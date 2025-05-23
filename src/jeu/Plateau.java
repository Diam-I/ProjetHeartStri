package jeu;

import java.io.Serializable; 
import java.util.List;

import cartes.Serviteur;
import joueur.Joueur;

/**
 * Classe qui représente le plateau du jeu.
 */
public class Plateau implements Serializable { 
    private static final long serialVersionUID = 1L; 

	/** Liste des serviteurs du joueur 1 */
	private List<Serviteur> serviteursJ1;
	/** Liste des serviteurs du joueur 2 */
	private List<Serviteur> serviteursJ2;

	/**
	 * Vérifie si le serviteur est actif (présent sur le plateau pour le joueur donné).
	 * @param joueur le joueur concerné
	 * @param serviteur le serviteur à vérifier
	 * @return true si le serviteur est actif (sur le plateau), false sinon
	 */
	public boolean estActif(Joueur joueur, Serviteur serviteur) {
		if (joueur.getNom().equals("Joueur 1")) {
			return serviteursJ1.contains(serviteur);
		}
		return serviteursJ2.contains(serviteur);
	}
}
