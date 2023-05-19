package controleur;

import java.util.ArrayList;

public class ControlePrompt {
	
	private ArrayList<String> recupPrompt;
	
	private String saisis;
	/**
	 * 
	 * @param prompt
	 * @return Constructeur servant a stocker les saisis de l'utilisateur dans une liste
	 */
	public ControlePrompt(String prompt) {
		
			this.recupPrompt = new ArrayList<String>();
			this.saisis = prompt; 
			
			// Ajout de saisis de l'utilisateur dans la liste
			recupPrompt.add(saisis);
			System.out.println(recupPrompt.toString());
	}

	// GETTER et SETTER de la liste
	public ArrayList<String> getRecupPrompt() {
		return recupPrompt;
	}

	public void setRecupPrompt(ArrayList<String> recupPrompt) {
		this.recupPrompt = recupPrompt;
	}

	public void controleSaisi() {
		
		
		
	}
}
