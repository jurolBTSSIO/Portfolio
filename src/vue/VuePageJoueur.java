package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.ControleImage;
import controleur.ControlePrompt;
import modele.Page;

public class VuePageJoueur extends JPanel implements ActionListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JLabel nomPage, contenuPage, imagePage, txtPage, txtContenu;
	private JTextField prompt;

	private String stringImage;

	/**
	 *
	 * @param nom
	 * @param descript
	 * @param image
	 * @return Constructeur de la vue pour la page
	 */
	public VuePageJoueur(Page pages, String gameplay, VuePersonnage vuePerso,
			ArrayList<VueInventaire> vueInventaire) {

		this.setLayout(null);
		this.setBounds(0, 0, AppFrame.appFrame.getLargeurecran(),
				AppFrame.appFrame.getHauteurecran());

		// Les valeurs obtenu a partir de la BDD placer dans des label
		this.nomPage = new JLabel(pages.getNomPage());
		this.contenuPage = new JLabel(pages.getDescriptionJoueur());

		this.stringImage = ControleImage.getSrcPage() + pages.getImgFond();
		this.imagePage = new JLabel(new ImageIcon(stringImage));

		// Affichage de description pour les labels de BDD
		this.txtPage = new JLabel("Nom Page: ");
		this.txtContenu = new JLabel("Contenu Page: ");

		// Affichage d'un textfield
		this.prompt = new JTextField();

		prompt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					new ControlePrompt(prompt.getText());
					prompt.setText("");
					// System.out.println(prompt.getText());
				}
			}

		});

		// Instanciation de la methode de FileChooser pour les images
		// new ControleImage().imageChooser();

		// Taille et la visiblite de l'image de la page
		imagePage.setSize(AppFrame.appFrame.getLargeurecran(),
				AppFrame.appFrame.getHauteurecran());

		// Taille du nom de page et sa description de ceci
		nomPage.setBounds(125, 100, 250, 70);
		txtPage.setBounds(50, 100, 250, 70);

		// Taille du contenu de la page et sa description de ceci
		contenuPage.setBounds(150, 125, 250, 70);
		txtContenu.setBounds(50, 125, 250, 70);

		// Taille du textfield pour les saisis de l'utilisateur
		prompt.setBounds(100, 200, 250, 70);

		this.add(new VueGameplay(gameplay, this, pages, vuePerso,
				vueInventaire));

		/*
		 * this.iconAvatar = new JLabel(); this.imageAvatar = new ImageIcon(new
		 * ImageIcon(ControleImage.getSrcAvatar()+"elfe.png").getImage().
		 * getScaledInstance(64, 64, Image.SCALE_DEFAULT));
		 * iconAvatar.setIcon(imageAvatar); iconAvatar.setBounds(365, 65, 64,
		 * 64); this.iconAvatar.addMouseListener(new MouseAdapter() {
		 *
		 * @Override public void mouseClicked(final MouseEvent mevt) {
		 *
		 * }
		 *
		 * });
		 */
		this.setVisible(true);
		// Ajout des contenu de la page au constructeur
		this.add(contenuPage);

		this.add(imagePage);

		this.add(nomPage);
		this.add(txtPage);
		this.add(txtContenu);
		this.add(prompt);

		this.add(vuePerso);

		for (int i = 0; i < vueInventaire.size(); i++) {
			this.add(vueInventaire.get(i));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
