package SahilAndAllisonsExcellentAdventure;
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
		cyto.setIcon(new ImageIcon("assets/CytoplasmBack.png"));
		cyto.addActionListener(this);

		petri = new adventureCardButton(1);
		petri.setIcon(new ImageIcon("assets/PetriDishBack.png"));
		petri.addActionListener(this);

		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		this.add(cyto);
		this.add(petri);
		
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("HELLO");
		if(g.getGameState()==g.HUMAN_DRAW){
			Card drawnCard = null;
			if(e.getSource() == cyto){
				drawnCard = CardLoader.getCytoplasmCard();
				System.out.println("please");
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
