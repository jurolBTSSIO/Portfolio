package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleur.ControleImage;
import controleur.ControlePageJoueur;
import modele.Livre;

public class VueLivreJoueur extends JPanel implements ActionListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private JButton lance;

	private String srcLiv;
	private JLabel titreLivre, auteurLivre, genreLivre, txtTitre, txtAuteur,
			txtGenre, txtCouverture, couvertureLivre;

	/**
	 *
	 * @param couverture
	 * @param titre
	 * @param auteur
	 * @param genre
	 * @return Constructeur de la VueLivre permettant d'ajouter les variables
	 *         Swing au Panel
	 */
	public VueLivreJoueur(Livre liv, ArrayList<VuePersonnage> vuePersonnage) {

		// Taille et Layout du Panel
		this.setLayout(null);
		this.setBounds(0, 0, AppFrame.appFrame.getLargeurecran(),
				AppFrame.appFrame.getHauteurecran());

		// Instanciation des Label des Parametre du Constructeur
		this.titreLivre = new JLabel(liv.getTitreLivre());
		this.auteurLivre = new JLabel(liv.getAuteurLivre());
		this.genreLivre = new JLabel(liv.getGenreLivre());

		this.srcLiv = ControleImage.getSrcLivre() + liv.getCouvertureLivre();
		// this.srcAvatar = ControleImage.getSrcAvatar()+pers.getImageAvatar();

		this.couvertureLivre = new JLabel(new ImageIcon(srcLiv));

		// Instanciation des Labels pour la description des Labels de Parametres
		this.txtTitre = new JLabel("Titre: ");
		this.txtAuteur = new JLabel("Auteur: ");
		this.txtGenre = new JLabel("Genre: ");
		this.txtCouverture = new JLabel("Description: ");

		// Instanctiation du Button et son Action permettant un renvoi vers le
		// controlleur ControleLivre
		this.lance = new JButton("Demarrer le jeu");
		this.lance.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 0).selectedRadio());
				for (int i = 0; i < vuePersonnage.size(); i++) {
					new ControlePageJoueur(liv.getIdLivre(),
							vuePersonnage.get(i).selectedRadio());
					// vuePersonnage.get(i).getIconChoix().get(i).setVisible(false);
				}

			}

		});

		// Taille des Labels de Parametres
		titreLivre.setBounds(100, 50, 250, 70);
		auteurLivre.setBounds(100, 100, 250, 70);
		genreLivre.setBounds(100, 125, 250, 70);

		// Taille de la Couverture du Livre
		couvertureLivre.setSize(AppFrame.appFrame.getLargeurecran(),
				AppFrame.appFrame.getHauteurecran());
		couvertureLivre.setVisible(true);

		// Taille des Labels de Description
		txtTitre.setBounds(50, 50, 250, 70);
		txtAuteur.setBounds(50, 100, 250, 70);
		txtGenre.setBounds(50, 125, 250, 70);
		txtCouverture.setBounds(50, 150, 250, 70);

		// Taille du button
		lance.setBounds(75, 695, 200, 30);

		this.setVisible(true);

		// Ajout des variables Swing au Panel
		this.add(auteurLivre);
		this.add(titreLivre);
		this.add(genreLivre);
		this.add(couvertureLivre);
		this.add(txtAuteur);
		this.add(txtTitre);
		this.add(txtGenre);
		this.add(txtCouverture);
		this.add(lance);

		for (int i = 0; i < vuePersonnage.size(); i++) {
			this.add(vuePersonnage.get(i));
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}

}
