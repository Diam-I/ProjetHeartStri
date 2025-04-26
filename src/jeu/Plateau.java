package jeu;

import java.util.List;

import cartes.Serviteur;
import joueur.Joueur;

public class Plateau {
	/**
	 * Classe qui représente le plateau du jeu 
	 */
	private List <Serviteur> serviteursJ1 ; /* La liste des serviteurs du joueur 1 */
	private List <Serviteur> serviteursJ2 ; /* La liste des serviteurs du joueur 2 */

	/**
	 * Methode qui verifie si le serviteur est actif
	 * @param joueur
	 * @param serviteur
	 * @return true si le serviteur est actif, et donc est sur le plateau, et false sinon
	 */
	public boolean estActif (Joueur joueur, Serviteur serviteur) {
		if (joueur.getNom().equals("Joueur 1")) {
			return serviteursJ1.contains(serviteur);
		}
		return serviteursJ2.contains(serviteur);
	}
	

}
