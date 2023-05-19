package controleur;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import modele.Livre;
import modele.Page;
import modele.Personnage;
import tool.DAOacces;
import vue.AppFrame;
import vue.PanelImg;
import vue.VueAjouterLivre;
import vue.VueEditeur;
import vue.VueLivre;
import vue.VueLivreJoueur;
import vue.VuePersonnage;

public class CtrlLivre {
	CtrlChoix ctrlChoice;
	Livre livre;
	ArrayList<Page> pages;
	ArrayList<Personnage> perso;
	ArrayList<Personnage> persos;

	String sql2;
	String src;
	private ArrayList<VuePersonnage> vuePersonnage;

	public CtrlLivre() {
		ctrlChoice = new CtrlChoix();
	}

	/*
	 * METHODE POUR AJOUTER UN LIVRE
	 */
	public void ajouterLivreBdd(String titreLivre) {
		DAOacces access = new DAOacces();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultat = null;
		AppFrame.livres.clear();
		String sql1 = "INSERT INTO livre (titreLivre, auteur) VALUES (?, ?);";
		String sql2 = "SELECT * from livre WHERE auteur = ?;";

		try {
			connection = access.getConnection();
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.setString(1, titreLivre);
			preparedStatement.setString(2, AppFrame.appFrame.user.getPseudo());
			preparedStatement.executeUpdate();

			preparedStatement = connection.prepareStatement(sql2);
			preparedStatement.setString(1, AppFrame.appFrame.user.getPseudo());
			resultat = preparedStatement.executeQuery();
			while (resultat.next()) {
				AppFrame.livres.add(new Livre(resultat.getInt("idLivre"),
						resultat.getString("titreLivre"),
						resultat.getString("auteur"),
						resultat.getString("genreLivre"),
						resultat.getString("couvertureLivre"), pages,
						AppFrame.appFrame.user));

				this.livre = new Livre(resultat.getInt("idLivre"),
						resultat.getString("titreLivre"),
						resultat.getString("auteur"),
						resultat.getString("genreLivre"),
						resultat.getString("couvertureLivre"), pages,
						AppFrame.appFrame.user);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		new ControleImage(livre).createFolder();

		AppFrame.appFrame.controlHost.removeAll();
		AppFrame.appFrame.controlHost.add(new VueLivre(AppFrame.livres));
		AppFrame.appFrame.controlHost.revalidate();
		AppFrame.appFrame.controlHost.repaint();
	}

	/*
	 * METHODE POUR EDITER UN LIVRE
	 */
	public void editerLivre(Livre livre) {
		DAOacces access = new DAOacces();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Statement statement = null;
		ResultSet resultat = null;
		livre.pages = new ArrayList<Page>();
		String sql = "SELECT * FROM page"
				+ " WHERE titreLivre = ? AND auteur = ?;";

		try {
			connection = access.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, livre.getTitreLivre());
			preparedStatement.setString(2, AppFrame.appFrame.user.getPseudo());
			resultat = preparedStatement.executeQuery();

			while (resultat.next()) {
				livre.pages.add(new Page(resultat.getInt("idPage"),
						resultat.getString("nomPage"),
						resultat.getString("imgFond"),
						resultat.getString("contenu"), livre.getTitreLivre(),
						AppFrame.appFrame.user));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		for (int i = 0; i < livre.pages.size(); i++) {

			String sql2 = "SELECT *" + " FROM successeur" + " WHERE nomPage = '"
					+ livre.pages.get(i).getNomPage() + "' AND titreLivre = '"
					+ livre.getTitreLivre() + "' AND auteur = '"
					+ AppFrame.appFrame.user.getPseudo() + "';";
			try {
				statement = connection.createStatement();
				ResultSet resultat2 = statement.executeQuery(sql2);

				while (resultat2.next()) {
					livre.pages.get(i).getPageSuccesseurs()
							.add(new Page(resultat2.getInt("idPage"),
									resultat2.getString("nomPageSuccesseur"),
									"", "", livre.getTitreLivre(),
									AppFrame.appFrame.user));
				}
			} catch (Exception e) {
				System.out.println(e);
			}

		}
		AppFrame.appFrame.controlHost.removeAll();
		/*
		 * INSTANCE DE LA VUE EDITEUR
		 */
		AppFrame.appFrame.controlHost.add(new VueEditeur(livre),
				BorderLayout.WEST);
		AppFrame.appFrame.controlHost.add(new PanelImg(), BorderLayout.CENTER);
		AppFrame.appFrame.controlHost.revalidate();
		AppFrame.appFrame.controlHost.repaint();
	}

	public void jouerLivre(Livre livre) {
		DAOacces access = new DAOacces();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Statement statement = null;
		ResultSet resultat = null;
		livre.pages = new ArrayList<Page>();
		String sql = "SELECT * FROM page WHERE titreLivre = ?;";

		System.out.println(livre.getIdLivre());
		try {
			connection = access.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, livre.getTitreLivre());
			resultat = preparedStatement.executeQuery();

			while (resultat.next()) {
				livre.pages.add(new Page(resultat.getInt("idPage"),
						resultat.getString("nomPage"),
						resultat.getString("imgFond"),
						resultat.getString("contenu"), livre.getTitreLivre(),
						AppFrame.appFrame.user));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		for (int i = 0; i < livre.pages.size(); i++) {
			String sqlSuccesseur = "SELECT nomPageSuccesseur"
					+ " FROM successeur" + " WHERE nomPage = '"
					+ livre.pages.get(i).getNomPage() + "' AND titreLivre = '"
					+ livre.getTitreLivre() + "';";
			try {
				statement = connection.createStatement();
				ResultSet resultat2 = statement.executeQuery(sqlSuccesseur);

				while (resultat2.next()) {
					livre.pages.get(i).getPageSuccesseurs()
							.add(new Page(resultat.getInt("idPage"),
									resultat2.getString("nomPageSuccesseur"),
									"", "", livre.getTitreLivre(),
									AppFrame.appFrame.user));
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			// access.close();
		}

		// RECUPERATION DES PERSONNAGES
		this.sql2 = "SELECT idPerso, credit, caract1, caract2, caract3, caract4, ptsVie, race, avatar, idLivre FROM personnage WHERE idLivre="
				+ livre.getIdLivre() + ";";
		this.perso = new ArrayList<Personnage>();

		try {

			statement = connection.createStatement();
			ResultSet rs2 = statement.executeQuery(sql2);

			while (rs2.next()) {

				// Ajoute les données provenant de BDD dans modele.Personnage
				perso.add(new Personnage(rs2.getInt("idPerso"),
						rs2.getInt("idLivre"), rs2.getInt("ptsVie"),
						rs2.getInt("credit"), rs2.getString("caract1"),
						rs2.getString("caract2"), rs2.getString("caract3"),
						rs2.getString("caract4"), rs2.getString("race"),
						rs2.getString("avatar")));
			}
			access.close();

		} catch (Exception e) {
			// TODO: handle exception
		}

		// Le cehmin d'acces à l'image du Livre
		new ControleImage(livre);
		this.src = ControleImage.getSrcLivre() + livre.getCouvertureLivre();

		this.persos = new ArrayList<Personnage>();
		this.vuePersonnage = new ArrayList<VuePersonnage>();

		for (int i = 0; i < perso.size(); i++) {
			this.persos.add(new Personnage(perso.get(i).getIdPerso(),
					perso.get(i).getIdLivre(), perso.get(i).getPointdeVie(),
					perso.get(i).getCredit(), perso.get(i).getCaract1(),
					perso.get(i).getCaract2(), perso.get(i).getCaract3(),
					perso.get(i).getCaract4(), perso.get(i).getRace(),
					perso.get(i).getImageAvatar()));

		}

		this.vuePersonnage.add(new VuePersonnage(persos));

		// if (livre.pages.size() > 0) {

		AppFrame.appFrame.controlHost.removeAll();
		AppFrame.appFrame.controlHost
				.add(new VueLivreJoueur(livre, this.vuePersonnage));
		AppFrame.appFrame.controlHost.repaint();
		AppFrame.appFrame.controlHost.revalidate();
		// new VueJeu(livre.pages, livre.pages.get(0));
		// }
	}

	public void nouveauLivre() {
		new VueAjouterLivre();
	}

	/*
	 * METHODE POUR SUPPRIMER UN LIVRE
	 */
	public void supprimerLivre(Livre livre) {
		DAOacces access = new DAOacces();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql1 = "DELETE FROM livre WHERE titreLivre = ?;";
		String sql2 = "DELETE FROM page WHERE titreLivre = ?;";
		String sql3 = "DELETE FROM successeur WHERE titreLivre = ?;";

		try {
			connection = access.getConnection();
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.setString(1, livre.getTitreLivre());
			preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement(sql2);
			preparedStatement.setString(1, livre.getTitreLivre());
			preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement(sql3);
			preparedStatement.setString(1, livre.getTitreLivre());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		access.close();
	}
}
