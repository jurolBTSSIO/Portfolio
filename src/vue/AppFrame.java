package vue;

import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

import modele.Livre;
import modele.Utilisateur;

public class AppFrame extends JFrame {
	public static AppFrame appFrame;
	static public Dimension dimension;
	public static ArrayList<Livre> livres = new ArrayList<Livre>();
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		// try {
		// UIManager.setLookAndFeel(new NimbusLookAndFeel());
		// } catch (UnsupportedLookAndFeelException e) {
		// e.printStackTrace();
		// }
		appFrame = new AppFrame();
		appFrame.controlHost.add(new VueAccueil());
		appFrame.setVisible(true);
	}

	public Container controlHost;
	private int largeurecran, hauteurecran;

	public Utilisateur user;

	public AppFrame() {
		super("");

		controlHost = getContentPane();
		this.setTitle("JDVELH");
		dimension = getToolkit().getScreenSize();
		this.setSize(dimension);

		this.largeurecran = dimension.width;
		this.hauteurecran = dimension.height;

		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setResizable(false);
		this.setFocusable(true);
		this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public int getHauteurecran() {
		return hauteurecran;
	}

	public int getLargeurecran() {
		return largeurecran;
	}
}
