package modele;

import java.util.ArrayList;

public class Personnage {
	
	// Attributs calcul en fonction de la race
	private int idPerso;
	private int idLivre;
	
	// Attributs en fonction des caracteristique et de la race 
	private int pointdeVie;
	private int credit;
	
	// Attributs des caracteristiques du personnage
	private String caract1, caract2,caract3, caract4;
	
	// Attributs des races des personnages
	private String race;
	private String imageAvatar;
	
	// Attributs en fonction d'un evenement de l'histoire
	private int etat1, etat2, etat3;

	private ArrayList<Personnage> personnage;
	
	/**
	 * 
	 * @param c1
	 * @param c2
	 * @param c3
	 * @param c4
	 * @param race
	 * @param imageAvatar
	 * @param ptsVie
	 * @param credit
	 */
	public Personnage(int idPers, int idLiv, int ptsVie, int credt, String c1, String c2, String c3, String c4, String race, String imageAvatar) {
		this.personnage = new ArrayList<Personnage>();
		
		this.idPerso = idPers;
		this.idLivre = idLiv;
		
		this.pointdeVie = ptsVie;
		this.credit = credt;
		
		this.caract1 = c1;
		this.caract2 = c2;
		this.caract3 = c3;
		this.caract4 = c4;
		
		this.race = race;
		this.imageAvatar = imageAvatar;
		
	}
	
	// Accesseurs des attributs
	// Accesseurs de caracteristiques des perso 
	public String getCaract1() {
		return caract1;
	}
	public void setCaract1(String caract1) {
		this.caract1 = caract1;
	}

	public String getCaract2() {
		return caract2;
	}
	public void setCaract2(String caract2) {
		this.caract2 = caract2;
	}

	public String getCaract3() {
		return caract3;
	}
	public void setCaract3(String caract3) {
		this.caract3 = caract3;
	}

	public String getCaract4() {
		return caract4;
	}
	public void setCaract4(String caract4) {
		this.caract4 = caract4;
	}
	
	// Accesseurs de races des perso
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}	
		
	public String getImageAvatar() {
		return imageAvatar;
	}

	public void setImageAvatar(String imageAvatar) {
		this.imageAvatar = imageAvatar;
	}

	// Accesseurs d'attributs de la sante
	public int getPointdeVie() {
		return pointdeVie;
	}
	public void setPointdeVie(int pointdeVie) {
		this.pointdeVie = pointdeVie;
	}
	
	// Accesseurs d'attributs d'etat
	public int getEtat1() {
		return etat1;
	}

	public void setEtat1(int etat1) {
		this.etat1 = etat1;
	}

	public int getEtat2() {
		return etat2;
	}

	public void setEtat2(int etat2) {
		this.etat2 = etat2;
	}

	public int getEtat3() {
		return etat3;
	}

	public void setEtat3(int etat3) {
		this.etat3 = etat3;
	}
	
	//GETTER et SETTER idPErso
	public int getIdPerso() {
		return idPerso;
	}

	public void setIdPerso(int idPerso) {
		this.idPerso = idPerso;
	}
	
	public int getIdLivre() {
		return idLivre;
	}

	public void setIdLivre(int idLivre) {
		this.idLivre = idLivre;
	}
	
	

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public ArrayList<Personnage> getPersonnage() {
		return personnage;
	}

	public void setPersonnage(ArrayList<Personnage> personnage) {
		this.personnage = personnage;
	}

	@Override
	public String toString() {
		return "Personnage [idPerso=" + idPerso + ", idLivre=" + idLivre + ", pointdeVie=" + pointdeVie + ", credit="
				+ credit + ", caract1=" + caract1 + ", caract2=" + caract2 + ", caract3=" + caract3 + ", caract4="
				+ caract4 + ", race=" + race + ", imageAvatar=" + imageAvatar + ", etat1=" + etat1 + ", etat2=" + etat2
				+ ", etat3=" + etat3 + ", personnage=" + personnage + "]";
	}

	
	
}
