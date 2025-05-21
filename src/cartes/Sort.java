package cartes;

import joueur.Heros;

public class Sort extends Carte{
	private String effet ; 
	private int valeur ;
	public Sort(String nom, int coutMana, String effet, int valeur) {
		super(nom, coutMana);
		this.effet = effet; 
		this.valeur = valeur ;
	}
	public String getEffet () {
		return effet ;
	}
	public int getValeur () {
		return valeur; 
	}
	@Override
	public void jouer() {
		
	}
	@Override
	public void afficher() {
		
	}
	
	///
	 public void appliquerEffet(Heros cible) {
	        if (effet.equals("degat")) {
	            cible.recevoirDegat(valeur);
	        } else if (effet.equals("soin")) {
	            cible.soigner(valeur);
	        }
	    }

	    public void appliquerEffet(Serviteur cible) {
	        if (effet.equals("degat")) {
	            cible.recevoirDegat(valeur);
	        } else if (effet.equals("soin")) {
	            // Tu peux faire une méthode soigner dans Serviteur si tu veux
	            System.out.println(cible.getNom() + " est soigné de " + valeur + " points.");
	            // Remets de la vie ici (si tu limites à une valeur max)
	        } else if (effet.equals("boost")) {
	            System.out.println(cible.getNom() + " est boosté de " + valeur + " points d'attaque.");
	            // Crée un setAttaque() ou un modifierAttaque() dans Serviteur
	        }
	    }
		@Override
		public void utiliser() {
			// TODO Auto-generated method stub
			
		}
	    
	    
}
