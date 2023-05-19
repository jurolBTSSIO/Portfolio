package controleur;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import modele.Livre;

public class ControleImage {

	private static Path absolu;
	private static String srcAvatar;
	private static String srcIcon;
	private static String srcInventaire;
	private static String srcLivre;
	private static String srcPage;

	// GETTER pour la source de l'image des avatar
	public static String getSrcAvatar() {
		return srcAvatar;
	}
	// GETTER et SETTER pour la source de l'image des Icons
	public static String getSrcIcon() {
		return srcIcon;
	}

	public static String getSrcInventaire() {
		return srcInventaire;
	}

	// GETTER pour la source de l'image du Livre
	public static String getSrcLivre() {
		return srcLivre;
	}

	// GETTER pour la source de l'image de la Page
	public static String getSrcPage() {
		return srcPage;
	}

	private Path chemin;
	public ControleImage(Livre liv) {

		// Recuperation du chemin d'acces et son absolu
		this.chemin = Paths.get("src/Images/livre-img/");
		ControleImage.absolu = chemin.toAbsolutePath();

		// Path pour recuperer le chemin d'acces pour les images du Livre et la
		// Page
		ControleImage.srcLivre = ControleImage.absolu.toString() + "\\"
				+ liv.getIdLivre() + "\\";
		ControleImage.srcPage = ControleImage.absolu.toString() + "\\"
				+ liv.getIdLivre() + "\\pages\\";
		ControleImage.srcIcon = ControleImage.absolu.toString() + "\\icons\\";
		ControleImage.srcAvatar = ControleImage.absolu.toString()
				+ "\\avatar\\";
		ControleImage.srcInventaire = ControleImage.absolu.toString() + "\\"
				+ liv.getIdLivre() + "\\items\\";
		createFolder();
	}
	/**
	 * @return creation des repertoires pour les images de livre et pages
	 */
	public void createFolder() {

		// Instanciation et creation des repertoires pour les images du livre et
		// pages
		File folderLivre = new File(getSrcLivre());
		File folderPages = new File(getSrcPage());
		File folderInventaire = new File(getSrcInventaire());

		boolean mkdirLivre = folderLivre.mkdir();
		boolean mkdirPages = folderPages.mkdir();
		boolean mkdirInventaire = folderInventaire.mkdir();

		if (mkdirLivre == true && mkdirPages == true
				&& mkdirInventaire == true) {
			System.out.println("Le dossier a été créé.");
		}

		/*
		 * else { System.out.println("Le dossier existe déja."); }
		 */
	}

	/*
	 * public void imageChooser() {
	 *
	 * //Instanciation et filtration de FileChooser pour les images JFileChooser
	 * imageChooser = new JFileChooser(); FileNameExtensionFilter filter = new
	 * FileNameExtensionFilter( "Image files", ImageIO.getReaderFileSuffixes());
	 * imageChooser.setFileFilter(filter); int returnVal =
	 * imageChooser.showOpenDialog(new JPanel()); if(returnVal ==
	 * JFileChooser.APPROVE_OPTION) {
	 * System.out.println("Vous avez slectionné ce fichier: " +
	 * imageChooser.getSelectedFile().getName()); } }
	 */
}
