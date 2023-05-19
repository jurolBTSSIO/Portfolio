package controleur;

import java.util.ArrayList;
import java.util.Random;

import modele.Page;
import vue.AppFrame;
import vue.VueGameplay;
import vue.VueInventaire;
import vue.VuePageJoueur;
import vue.VuePersonnage;

/**
 * CLASSE DE CONTROLLER DE GAMEPLAY PERMETTANT DE RETOURNER LE RESULTAT DU GAMEPLAY AVEC LA VALEUR OBTENUES PROVENANT DE VUEGAMEPLAY 
 * @author ISMA
 *
 */
public class ControleGameplay {
	
	private static String compteur="";
	
	private String result;
	
	/**
	 * 
	 * @param compteur COMPTEUR SERVANT DE CHARGER LES  
	 * @param v
	 * @param page
	 * @param vuePers
	 * @param vueInv
	 */
	public ControleGameplay(String compteur, VuePageJoueur v, Page page, VuePersonnage vuePers, ArrayList<VueInventaire> vueInv) {
		
		ControleGameplay.compteur = compteur;
		
		//System.out.println(v.getNomPage().getText()+v.getContenuPage().getText()+ v.getStringImage());
		
		// RETOURNE DE LE RESULTAT EN FORMAT STRING DU GAMEPLAY POUR AFFICHER DANS LA VUE GAMEPLAY
		this.result = gamePlay();
		
		// INSTANCIATION DE VUEPAGE ET LE CHARGER AVEC LES ARGUMENTS DU CONSTRUCTEUR ET LE RESULTAT
		VuePageJoueur vuePage = new VuePageJoueur(page, result, vuePers, vueInv);
		
		// INSTANCIATION DE VUEGAMEPLAY ET LE CHARGER AVEC LES ARGUMENTS DU CONSTRUCTEUR(STRING, VUEPAGE, VUEPERSONNAGE, ARRAYLIST DE VUEINVENTAIRE)
		// ET LE RESULTAT
    	VueGameplay vueGameplay = new VueGameplay(result, v, page, vuePers, vueInv);
    	

		// CHARGER LA VUE PAGE EN REAFFICHANT LA VUE GRACE A LA METHODE REMOVEALL
		AppFrame.appFrame.controlHost.removeAll();
		// AJOUT DE VUEGAMEPLAY DANS LE PANEL DE VUE PAGE
    	vuePage.add(vueGameplay);		
    	// AJOUT DE VUEPAGE AU CONTENEUR DU FRAME ET REPEINT PUIS REVALIDE
    	AppFrame.appFrame.controlHost.add(vuePage);
    	AppFrame.appFrame.controlHost.repaint();
    	AppFrame.appFrame.controlHost.revalidate();
		
		
	}
	
	/**
	 * 
	 * @param page
	 * @param v
	 * @param vuePerso
	 * @param vueInve
	 */
	/*public ControleGameplay(Page page, VuePage v, VuePersonnage vuePerso, ArrayList<VueInventaire> vueInve) {
		// TODO Auto-generated constructor stub
		
		this.result = gamePlay();
		VuePage vuePage = new VuePage(page, result, vuePerso, vueInve);
		
    	VueGameplay vueGameplay = new VueGameplay(result, v, page, vuePerso, vueInve);
    	

		
		App.app.container.removeAll();
		
    	vueGameplay.getIconPierre().setIcon(vueGameplay.getImagePierre_rouge());
    	vuePage.add(vueGameplay);
		
		App.app.container.add(vuePage);
		App.app.container.repaint();
		App.app.container.revalidate();
	}*/
	/**
	 * 
	 * @return LE RESULTAT DU JEU DE TYPE STRING PROVENANT DE LA METHODE ENNEMIGAMEPLAY EN SIGNALANT A L'UTILISATEUR GAGNE/PERDU/EGALITE
	 */
	public String gamePlay() {
		
		// LE CHOIX DE L'UTILISATEUR EST PIERRE
		if(compteur.equals("Pierre")) {
			return ennemiGameplay();
			//System.out.println("Pierre !");
		}
		
		// LE CHOIX DE L'UTILISATEUR EST FEUILLE
		if(compteur.equals("Feuille")) {
			return ennemiGameplay();
			//System.out.println("Feuille !");
		}
		
		// LE CHOIX DE L'UTILISATEUR CISEAUX
		if(compteur.equals("Ciseaux")) {
			//System.out.println("Ciseaux !");
			return ennemiGameplay();
			
		}
		// SINON ON RETOURNE UNE CHAINE VIDE
		return "";
	}

	/**
	 * 
	 * @return LA METHODE PERMETTANT DE FAIRE UN ALEATOIRE PUIS RECUPERANT LE CHOIX DE L'UTILISATEUR ET EN RETOURNANT LE RESULTAT DU GAMEPLAY A LA METHODE GAMEPLAY
	 */
	public String ennemiGameplay() {
		
		// INSTANCIATION DE LA METHODE DE RANDOM DE CLASSE RANDOM PUIS PARCOURANT LA TAILLE DE RANDOM DE TYPE INT
		Random random = new Random();
		int upperbound = 3;
	    int int_random = random.nextInt(upperbound);

	    // RANDOM = 0 VEUT DIRE LE CHOIX DE L'ENNEMI EST PIERRE
	    if(int_random == 0 ) {
	    	if(ControleGameplay.compteur.equals("Pierre")) {
	    		
	    		//new VueGameplay("Egalité !");
	    		
	    		return "Egalité !";
	    	}
	    	if(ControleGameplay.compteur.equals("Feuille")) {
	    		
	    		//new VueGameplay("Gagné !");
	    		
	    		return "Gagné !";
	    	}
			if(ControleGameplay.compteur.equals("Ciseaux")) {
				
				//new VueGameplay("Perdu !");
				
				return "Perdu !";
			}

	    	System.out.println("Pierre ennemi");
	    }
	    
	 // RANDOM = 1 VEUT DIRE LE CHOIX DE L'ENNEMI EST FEUILLE
	    if(int_random == 1) {
	    	if(ControleGameplay.compteur.equals("Pierre")) {
	    		//new VueGameplay("Perdu !");
	    		return "Perdu !";
	    	}
	    	if(ControleGameplay.compteur.equals("Feuille")) {
	    		
	    		//new VueGameplay("Egalité !");
	    		
	    		return "Egalité !";
	    	}
			if(ControleGameplay.compteur.equals("Ciseaux")) {
				
				//new VueGameplay("Gagné !");
				
				return "Gagné !";
			}
	    	System.out.println("Feuille ennemi");
	    }
	    
	 // RANDOM = 2 VEUT DIRE LE CHOIX DE L'ENNEMI EST CISEAUX
	    if(int_random == 2) {
	    	if(ControleGameplay.compteur.equals("Pierre")) {
	    		
	    		//new VueGameplay("Gagné !");
	    		
	    		return "Gagné !";
	    	}
	    	if(ControleGameplay.compteur.equals("Feuille")) {
	    		
	    		//new VueGameplay("Perdu !");
	    		
	    		return "Perdu !";
	    	}
			if(ControleGameplay.compteur.equals("Ciseaux")) {
				
				//new VueGameplay("Egalité !");
				
				return "Egalité !";
			}
	    	System.out.println("Ciseaux ennemi");
	    }
	    return "";
		
	}
	
	/**
	 * 
	 * @return GETTER DU RESULTAT DE TYPE STRING
	 */
	public String getResult() {
		return result;
	}
	
	/**
	 * 
	 * @param result SETTER DU RESULTAT DU TYPE STRING
	 */
	public void setResult(String result) {
		this.result = result;
	}
	
	
}
