package vue;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import controleur.ControleImage;
import modele.Personnage;

public class VuePersonnage extends JPanel implements ActionListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<JLabel> caract1, caract2, caract3, caract4, race, ptsVie;
	private JLabel caracteristiques, pointsVie;

	int chx = 0;

	private ArrayList<JLabel> iconAvatars;

	private ArrayList<JRadioButton> iconChoix;
	private ArrayList<ImageIcon> imageAvatar;

	private ButtonGroup raceChoix;

	private ArrayList<String> strAvatars;

	int x, i, xI;

	public VuePersonnage(ArrayList<Personnage> pers) {

		this.setLayout(null);
		this.setBounds(5, 350, 345, 330);
		this.setBackground(new Color(0, 0, 0, 0));

		this.x = 100;
		this.xI = 95;

		this.caract1 = new ArrayList<JLabel>();
		this.caract2 = new ArrayList<JLabel>();
		this.caract3 = new ArrayList<JLabel>();
		this.caract4 = new ArrayList<JLabel>();

		this.iconAvatars = new ArrayList<JLabel>();
		this.strAvatars = new ArrayList<String>();
		this.imageAvatar = new ArrayList<ImageIcon>();

		this.race = new ArrayList<JLabel>();
		this.ptsVie = new ArrayList<JLabel>();

		this.iconChoix = new ArrayList<JRadioButton>();
		this.raceChoix = new ButtonGroup();

		for (i = 0; i < pers.size(); i++) {

			this.strAvatars.add(ControleImage.getSrcAvatar()
					+ pers.get(i).getImageAvatar());
			this.imageAvatar.add(
					new ImageIcon(new ImageIcon(strAvatars.get(i)).getImage()
							.getScaledInstance(64, 64, Image.SCALE_DEFAULT)));

			this.iconAvatars.add(new JLabel(imageAvatar.get(i)));
			this.iconAvatars.get(i).setBounds(xI, 0, 70, 65);

			this.add(iconAvatars.get(i));

			this.iconChoix.add(new JRadioButton());

			iconChoix.get(i).setActionCommand("" + i + "");

			this.iconChoix.get(i).setBounds(x - 22, 82, 20, 20);

			iconChoix.get(i).setBorderPainted(false);
			iconChoix.get(i).setContentAreaFilled(false);
			iconChoix.get(i).setFocusPainted(false);
			iconChoix.get(i).setOpaque(false);
			iconChoix.get(i).setBackground(null);

			iconChoix.get(i).addActionListener(this);

			this.add(iconChoix.get(i));
			raceChoix.add(iconChoix.get(i));

			this.race.add(new JLabel(pers.get(i).getRace()));
			this.race.get(i).setBounds(x, 80, 75, 20);
			this.add(race.get(i));

			this.caract1.add(new JLabel(pers.get(i).getCaract1()));
			this.caract1.get(i).setBounds(x, 110, 75, 15);
			// this.caract1.get(i).setVisible(false);
			this.add(caract1.get(i));

			this.caract2.add(new JLabel(pers.get(i).getCaract2()));
			this.caract2.get(i).setBounds(x, 135, 75, 15);
			// this.caract2.get(i).setVisible(false);
			this.add(caract2.get(i));

			this.caract3.add(new JLabel(pers.get(i).getCaract3()));
			this.caract3.get(i).setBounds(x, 160, 75, 15);
			// this.caract3.get(i).setVisible(false);
			this.add(caract3.get(i));

			this.caract4.add(new JLabel(pers.get(i).getCaract4()));
			this.caract4.get(i).setBounds(x, 185, 75, 15);
			// this.caract4.get(i).setVisible(false);
			this.add(caract4.get(i));

			this.ptsVie.add(
					new JLabel(Integer.toString(pers.get(i).getPointdeVie())));
			this.ptsVie.get(i).setBounds(x, 310, 40, 15);
			// this.ptsVie.get(i).setVisible(false);
			this.add(ptsVie.get(i));

			x += 80;
			xI += 75;
		}

		this.caracteristiques = new JLabel("Caracteristiques :");
		caracteristiques.setBounds(0, 110, 95, 15);
		this.add(caracteristiques);

		this.pointsVie = new JLabel("Points de Vie :");
		pointsVie.setBounds(0, 310, 95, 15);
		this.add(pointsVie);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		for (int i = 0; i < this.iconChoix.size(); i++) {
			if (e.getActionCommand().equals("" + i + "")) {

				selectedRadio();
				/*
				 * System.out.println("Le radio bouton sélectionné est: " +
				 * raceChoix.getSelection().getActionCommand());
				 */
			}
		}
	}

	public ArrayList<JRadioButton> getIconChoix() {
		return iconChoix;
	}

	public int selectedRadio() {
		this.chx = Integer.parseInt(raceChoix.getSelection().getActionCommand())
				+ 1;
		System.out.println(chx);
		return chx;
	}

}
