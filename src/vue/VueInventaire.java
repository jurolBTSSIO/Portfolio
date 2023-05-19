package vue;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleur.ControleImage;
import modele.Inventaire;
import modele.Personnage;

/**
 * CLASSE DE VUE INVENTAIRE AFFICHANT L'INTEFACE GRAPHIQUE DU MODEL DE
 * L'INVENTAIRE
 *
 * @author ISMA
 *
 */
public class VueInventaire extends JPanel implements ActionListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<JCheckBox> choixItem;
	// DECLARATION DES ATTRIBUTS SWING DE TYPE ARRAYLIST DE TYPE OBJETS
	ArrayList<JLabel> contImage, quantiteItem, nomItem;
	JLabel credit, txtCredit, txtInventaire, txtQuantite;

	int i, x;

	ArrayList<ImageIcon> image;

	ArrayList<String> strItem;

	public VueInventaire(ArrayList<Inventaire> inv,
			ArrayList<Personnage> perso) {

		this.setLayout(null);
		this.setBounds(1015, 55, 326, 660);
		this.setBackground(new Color(0, 0, 0, 50));

		this.contImage = new ArrayList<JLabel>();
		this.image = new ArrayList<ImageIcon>();

		this.quantiteItem = new ArrayList<JLabel>();
		this.nomItem = new ArrayList<JLabel>();
		this.choixItem = new ArrayList<JCheckBox>();

		this.strItem = new ArrayList<String>();

		this.credit = new JLabel(Integer.toString(perso.get(0).getCredit()));

		this.add(credit);

		this.txtCredit = new JLabel("Credit: ");

		this.add(txtCredit);

		this.txtInventaire = new JLabel("Inventaire");
		txtInventaire.setBounds(5, 5, 75, 50);
		this.add(txtInventaire);

		this.txtQuantite = new JLabel("Quantité:");

		this.add(txtQuantite);

		this.x = 5;

		for (i = 0; i < inv.size(); i++) {
			// AJOUT DES IMAGES ITEM DANS UN JLABEL CONTIMAGE

			this.strItem.add(ControleImage.getSrcInventaire()
					+ inv.get(i).getImageItem());
			System.out.println(strItem);
			this.image
					.add(new ImageIcon(new ImageIcon(strItem.get(i)).getImage()
							.getScaledInstance(64, 64, Image.SCALE_DEFAULT)));

			this.contImage.add(new JLabel(image.get(i)));
			contImage.get(i).setBounds(x, 75, 64, 64);
			this.add(contImage.get(i));

			// AJOUT DES NOMS ITEM DANS UN JLABEL NOMITEM
			this.nomItem.add(new JLabel(inv.get(i).getNomItem()));
			nomItem.get(i).setBounds(x + 20, 150, 50, 20);
			this.add(nomItem.get(i));

			// AJOUT DES CHECKBOX POUR SELECTIONNER LES ITEMS
			this.choixItem.add(new JCheckBox());
			choixItem.get(i).setBounds(x, 150, 20, 20);

			choixItem.get(i).setBorderPainted(false);
			choixItem.get(i).setContentAreaFilled(false);
			choixItem.get(i).setFocusPainted(false);
			choixItem.get(i).setOpaque(false);
			choixItem.get(i).setBackground(null);

			this.add(choixItem.get(i));

			// AJOUT DES QUANTITES ITEM DANS UN JLABEL QUANTITEITEM
			this.quantiteItem.add(
					new JLabel(Integer.toString(inv.get(i).getQuantite())));
			quantiteItem.get(i).setBounds(x + 55, 175, 30, 20);
			this.add(quantiteItem.get(i));

			credit.setBounds(x + 40, 620, 30, 20);
			txtCredit.setBounds(x, 620, 40, 20);
			txtQuantite.setBounds(x, 175, 60, 20);

			x += 75;
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
