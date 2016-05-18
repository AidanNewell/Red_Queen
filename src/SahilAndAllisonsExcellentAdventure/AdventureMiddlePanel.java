package SahilAndAllisonsExcellentAdventure;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import cards.*;

public class AdventureMiddlePanel extends JPanel{
	
	private AdventureGame g;
	private AdventureOrganismPanel p;
	private final int CYTOPLASM = 0;
	private final int ORGANELLE = 1;
	private adventureCardButton cyto;
	private adventureCardButton petri;
	
	public AdventureMiddlePanel(AdventureGame G, AdventureOrganismPanel P){
		
		g=G;
		p=P;
		
		cyto = new adventureCardButton(0);
		cyto.setIcon(new ImageIcon("assets/CytoplasmBack.png"));
		
		cyto.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				Card cytoCard = CardLoader.getCytoplasmCard();
				p.addCard(cytoCard);
			}
		});
		
		petri = new adventureCardButton(1);
		petri.setIcon(new ImageIcon("assets/PetriDishBack.png"));
		
		petri.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				Card petriCard = CardLoader.getPetriCard();
				p.addCard(petriCard);
			}
		});
		
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		this.add(cyto);
		this.add(petri);
	}
}
