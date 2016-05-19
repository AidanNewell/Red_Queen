package SahilAndAllisonsExcellentAdventure;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import cards.*;

public class AdventureMiddlePanel extends JPanel implements ActionListener{

	private AdventureGame g;
	private final int CYTOPLASM = 0;
	private final int ORGANELLE = 1;
	private adventureCardButton cyto;
	private adventureCardButton petri;

	public AdventureMiddlePanel(AdventureGame G){

		g=G;

		cyto = new adventureCardButton(0);
		ImageIcon cytoArt = new ImageIcon("assets/CytoplasmBack.png");
		cyto.setIcon(cytoArt);
//		Image img = cytoArt.getImage();
//		Image newimg = img.getScaledInstance(114, 114,  java.awt.Image.SCALE_SMOOTH);
//		ImageIcon small = new ImageIcon(newimg);
//		cyto.setIcon(small);
		cyto.addActionListener(this);

		petri = new adventureCardButton(1);
		ImageIcon petriArt = new ImageIcon("assets/PetriDishBack.png");
//		Image img2 = petriArt.getImage();
//		Image newimg2 = img2.getScaledInstance(114, 114,  java.awt.Image.SCALE_SMOOTH);
//		ImageIcon small2 = new ImageIcon(newimg2);
		petri.setIcon(petriArt);
	//	petri.setIcon(small2);
		petri.addActionListener(this);

		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		this.add(cyto);
		this.add(petri);
		
	}

	public void actionPerformed(ActionEvent e) {
		if(g.getGameState()==g.HUMAN_DRAW){
			Card drawnCard = null;
			if(e.getSource() == cyto){
				drawnCard = CardLoader.getCytoplasmCard();
			}
			else if(e.getSource() == petri)
				drawnCard = CardLoader.getPetriCard();
			g.getPlayerPanel().addCard(drawnCard);
			g.getPlayerPanel().addDrawn();
			if(g.getPlayerPanel().getDrawn() == 2)
				g.nextPhase();
			g.getInfoPanel().updateLabels();
		}

	}
}
