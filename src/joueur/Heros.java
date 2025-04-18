package joueur;

public class Heros {
	/**
	 * Classe qui decrit le heros 
	 */
	
	private String nom ; /* Le nom du heros */
	private String pouvoir ; /* Le pouvoir specifique a chaque heros */
	private String arme ; /* L'arme specifique a chaque heros */ /***** a modifier quand on va creer la classe arme ******/
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
	public Heros (String nom, String pouvoir, String arme, int pointDeVie , int coutMana) { /* Modifier le type d arme ici aussi */
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

	/**
	 * Methode qui permet d incremenet le cout du mana du heros a chaque tout tant qu elle n atteint pas les 10
	 */
	public void incrementerMana() {
		coutMana ++ ; 
	}
	
	
	

}
