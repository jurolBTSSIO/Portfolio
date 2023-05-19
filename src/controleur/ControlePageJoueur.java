package controleur;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modele.Inventaire;
import modele.Page;
import modele.Personnage;
import tool.DAOacces;
import vue.AppFrame;
import vue.VueInventaire;
import vue.VuePageJoueur;
import vue.VuePersonnage;

/**
 * CLASS SERVANT DE CONTROLLER POUR CHARGER LE MODELE PAGE A PARTIR DE BDD ET AFFECTE LES VALEURS OBTENUES DANS LA VUE PAGE
 * @author ISMA
 *
 */

public class ControlePageJoueur {

	/**
	 * pages L'INSTANCIATION D'UNE ARRAYLIST DE TYPE PAGE
	 */
	private ArrayList<Page> pages = new ArrayList<Page>();
	
	/**
	 * inventaire L'INSTANCIATION D'UNE ARRAYLIST DE TYPE INVENTAIRE
	 */
	private ArrayList<Inventaire> inventaire = new ArrayList<Inventaire>();
	
	
	VuePageJoueur vuePage;
	VuePersonnage vuePersonnage;
	
	ArrayList<VueInventaire> vueInventaire;
	ArrayList<Inventaire> inventaires;
	
	ArrayList<Personnage> personnage;
	
	private String sql, sql2, sql3;
	
	String src;
	
	Statement statement = null;

	/**
	 * 
	 * @param idLivre IDENTIFIANT DU LIVRE DE TYPE INT 
	 * @param idPerso IDENTIFIANT DE PERSONNAGE DE TYPE INT
	 * @return CONSTRUCTEUR SERVANT DE CONTROLLER LES PAGES A PARTIR DE BDD EN PRENANT PARAMETRE L'ID DU LIVRE ET L'ID DU PERSONNAGE 
	 */
	public ControlePageJoueur(int idLivre, int idPerso) {
		
		DAOacces daoAccess = new DAOacces();
		

		Connection connection = null;

		this.sql = "SELECT idPage, nomPage, contenu, idLivre, imgFond, titreLivre FROM page WHERE idLivre="+idLivre+";";
		
		
		try {
			connection = daoAccess.getConnection();
			this.statement= connection.createStatement();
			ResultSet rsLogin = this.statement.executeQuery(sql);

			while(rsLogin.next())
			{	
				//CHARGE LE modele.Page A PARTIR DES VALEURS OBTENUES DE LA BDD AVEC LA LISTE DE pages
				pages.add(new Page(rsLogin.getInt("idPage"), rsLogin.getString("nomPage"), 
						rsLogin.getString("imgFond"), rsLogin.getString("contenu"), rsLogin.getString("titreLivre"),
						AppFrame.appFrame.user));
			 
			}
		}
		catch(SQLException e) 
		{
			
			System.err.println("Erreur de connexion");
			e.printStackTrace();// . . .
		}
		
		this.personnage = new ArrayList<Personnage>();
		
		// RECUPERTATION DES DONNEES DE BDD POUR CHARGER LE MODELE PERSONNAGE
				sql2 ="SELECT idPerso, credit, caract1, caract2, caract3, caract4, ptsVie, race, avatar, idLivre FROM personnage WHERE idPerso="+idPerso+";";
				
				try {
					ResultSet rs = this.statement.executeQuery(sql2);				
					while(rs.next()) {
						
						// Ajoute les données provenant de BDD dans modele.Personnage  
						this.personnage.add(new Personnage(rs.getInt("idPerso"),  rs.getInt("idLivre")  , rs.getInt("ptsVie"), rs.getInt("credit"), rs.getString("caract1"), rs.getString("caract2"), rs.getString("caract3"), rs.getString("caract4"), 
									rs.getString("race"), rs.getString("avatar")));
					
					// System.out.println(personnage);
					}
					//daoAccess.Close();

				} 
				catch (Exception e) {
					// TODO: handle exception
				}
				
				// RECUPERATION DES DONNEES DE BDD POUR CHARGER LE MODELE PERSONNAGE
				sql3 ="SELECT idItem, quantiteItem, nomItem, imageItem FROM inventaire WHERE idLivre="+idLivre+";";
				
				try {
					ResultSet rs = this.statement.executeQuery(sql3);				
					while(rs.next()) {
						
						// CHARGE LES DONNEES PROVENANT DE BDD DANS modele.Personnage  
						this.inventaire.add(new Inventaire(rs.getInt("idItem"), rs.getInt("quantiteItem"), rs.getString("nomItem"), rs.getString("imageItem")));
					
					 //System.out.println(inventaire);
					}
					daoAccess.close();

				} 
				catch (Exception e) {
					// TODO: handle exception
				}
			
		this.vuePersonnage =new VuePersonnage(personnage);
		
		this.vueInventaire = new ArrayList<VueInventaire>();
		this.inventaires = new ArrayList<Inventaire>();
		
		for (int i = 0; i < inventaire.size(); i++) {
			this.inventaires.add(new Inventaire(inventaire.get(i).getIdItem(), inventaire.get(i).getQuantite(), inventaire.get(i).getNomItem(), inventaire.get(i).getImageItem()));		
		}
		
		this.vueInventaire.add(new VueInventaire(inventaires, personnage));
		
		//LE CHEMIN D'ACCES A L'IMAGE DES PAGES
		this.src = ControleImage.getSrcPage()+this.getPages().get(0).getImgFond();
		
		Page pageR = new Page(pages.get(0).getNumeroPage(), pages.get(0).getNomPage(),
				pages.get(0).getImgFond(), pages.get(0).getContenu(),
				pages.get(0).getTitreLivre(), AppFrame.appFrame.user);
		
		this.vuePage = new VuePageJoueur(pageR, "", vuePersonnage, vueInventaire);
		
		
		// AJOUT DE LA VUEPAGE POUR LA PREMIERE PAGE DU LIVRE		
		AppFrame.appFrame.controlHost.removeAll();
		AppFrame.appFrame.controlHost.add(vuePage);
		AppFrame.appFrame.controlHost.repaint();
		AppFrame.appFrame.controlHost.revalidate();
			
	}
	/**
	 * 
	 * @return GETTER DE LA LISTE DES PAGES DE TYPE ARRAYLIST<PAGE>
	 */
	// GETTER et SETTER de la liste Pages
	public ArrayList<Page> getPages() {
		return pages;
	}
	/**
	 * 
	 * @param pages SETTER DE LA LISTE DES PAGES DE TYPE ARRAYLIST<PAGE>
	 */
	public void setPages(ArrayList<Page> pages) {
		this.pages = pages;
	}

	/**
	 * 
	 * @param id LA METHODE PRENANT L'ID DU LIVRE EN PARAMETRE DE TYPE INT
	 * @param vuePers AJOUTANT LA VUE PERSONNAGE DE TYPE VUEPERSONNAGE SUR LES PAGES
	 * @param vueInv AJOUTANT LA VUE INVENTAIRE DE TYPE ARRAYLIST<VUEINVENTAIRE> SUR LES PAGES 
	 * @return METHODE AFFICHANT LES PAGES DU LIVRE
	 */
	public void afficherPage(int id, VuePersonnage vuePers, ArrayList<VueInventaire> vueInv) {
		//Boucle pour les affichage de pages
		for (int i=0; i < this.getPages().size(); i++) {
			//Si id de la page -1 = au numero de la page alors on affiche les pages
			if ((id-1) == this.getPages().get(i).getNumeroPage())
			{
				Page pagess = new Page(pages.get(0).getNumeroPage(),
						pages.get(0).getNomPage(), pages.get(0).getImgFond(), 
						pages.get(0).getContenu(), pages.get(0).getTitreLivre(), 
						AppFrame.appFrame.user);
				this.vuePage = new VuePageJoueur(pagess ,"", vuePers, vueInv);
				/*System.out.println(this.getPages().get(i).getNomPage());
				System.out.println(this.getPages().get(i).getImgFond());
				System.out.println(this.getPages().get(i).getDescriptionJoueur());
		*/
				this.src =ControleImage.getSrcPage()+this.getPages().get(id).getImgFond();
			}
		}	
	}
}
