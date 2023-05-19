package vue;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleur.ControleGameplay;
import controleur.ControleImage;
import modele.Page;

public class VueGameplay extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private JLabel iconPierre, iconFeuille, iconCiseaux, resultat;

	private ImageIcon imagePierre, imagePierre_rouge, imageFeuille,
			imageCiseaux;

	private String strResultat;

	/**
	 * @return Constructeur qui sert d'afficher les boutons du GamePlay
	 */
	public VueGameplay(String strResult, VuePageJoueur v, Page page,
			VuePersonnage vuePers, ArrayList<VueInventaire> vueInv) {

		this.setLayout(null);
		this.setBounds(355, 450, 200, 250);

		this.setBackground(new Color(0, 0, 0, 0));

		// Specifications lié a l'image de Pierre
		this.iconPierre = new JLabel();
		iconPierre.setBounds(5, 5, 64, 64);

		this.imagePierre = new ImageIcon(
				new ImageIcon(ControleImage.getSrcIcon() + "pierre.png")
						.getImage()
						.getScaledInstance(64, 64, Image.SCALE_DEFAULT));;
		// this.imagePierre_rouge = new ImageIcon(new
		// ImageIcon(ControleImage.getSrcIcon()+"pierre_rouge.png").getImage().getScaledInstance(64,
		// 64, Image.SCALE_DEFAULT));

		iconPierre.setIcon(imagePierre);
		iconPierre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent mevt) {
				new ControleGameplay("Pierre", v, page, vuePers, vueInv);

			}

		});

		// Specifications lié a l'image de Feuille
		this.iconFeuille = new JLabel();
		iconFeuille.setBounds(20, 75, 64, 64);

		this.imageFeuille = new ImageIcon(
				new ImageIcon(ControleImage.getSrcIcon() + "feuille.png")
						.getImage()
						.getScaledInstance(64, 64, Image.SCALE_DEFAULT));
		iconFeuille.setIcon(imageFeuille);
		iconFeuille.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent mevt) {

				new ControleGameplay("Feuille", v, page, vuePers, vueInv);

			}
		});

		// Specifications lié a l'image de Ciseaux
		this.iconCiseaux = new JLabel();
		iconCiseaux.setBounds(35, 145, 64, 64);

		this.imageCiseaux = new ImageIcon(
				new ImageIcon(ControleImage.getSrcIcon() + "ciseaux.png")
						.getImage()
						.getScaledInstance(64, 64, Image.SCALE_DEFAULT));
		iconCiseaux.setIcon(imageCiseaux);
		iconCiseaux.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent mevt) {
				new ControleGameplay("Ciseaux", v, page, vuePers, vueInv);

			}
		});

		// Specifications lié au message du resultat
		this.strResultat = strResult;
		this.resultat = new JLabel(strResultat);
		resultat.setBounds(15, 195, 60, 60);
		resultat.setForeground(new Color(255, 0, 0, 255));
		resultat.setVisible(true);

		// Ajout des label image au panel
		this.add(iconPierre);
		this.add(iconFeuille);
		this.add(iconCiseaux);
		this.add(resultat);
	}

	public JLabel getIconCiseaux() {
		return iconCiseaux;
	}

	public JLabel getIconFeuille() {
		return iconFeuille;
	}

	public JLabel getIconPierre() {
		return iconPierre;
	}

	public ImageIcon getImagePierre_rouge() {
		return imagePierre_rouge;
	}

	public JLabel getResultat() {
		return resultat;
	}

	public void setIconCiseaux(JLabel iconCiseaux) {
		this.iconCiseaux = iconCiseaux;
	}

	public void setIconFeuille(JLabel iconFeuille) {
		this.iconFeuille = iconFeuille;
	}

	public void setIconPierre(JLabel iconPierre) {
		this.iconPierre = iconPierre;
	}

	public void setResultat(JLabel resultat) {
		this.resultat = resultat;
	}

}
