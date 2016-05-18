package SahilAndAllisonsExcellentAdventure;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import cards.*;

public class AdventureMiddlePanel extends JPanel{
	
	private AdventureGame g;
	private final int CYTOPLASM = 0;
	private final int ORGANELLE = 1;
	private adventureCardButton cyto;
	private adventureCardButton petri;
	
	public AdventureMiddlePanel(AdventureGame G){
		
		g=G;
		
		cyto = new adventureCardButton(0);
		cyto.setIcon(new ImageIcon("assets/CytoplasmBack.png"));
		
		cyto.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
				if(g.getGameState()==g.HUMAN_DRAW){
					Card cytoCard = CardLoader.getCytoplasmCard();
					g.getPlayerPanel().addCard(cytoCard);
					g.nextPhase();
				}
			}
		});
		
		petri = new adventureCardButton(1);
		petri.setIcon(new ImageIcon("assets/PetriDishBack.png"));
		
		petri.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
				if(g.getGameState()==g.HUMAN_DRAW){
					Card petriCard = CardLoader.getPetriCard();
					g.getPlayerPanel().addCard(petriCard);
					g.nextPhase();
				}
			}
		});
		
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		this.add(cyto);
		this.add(petri);
	}
}
