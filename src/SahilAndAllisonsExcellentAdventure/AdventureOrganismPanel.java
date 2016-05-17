package SahilAndAllisonsExcellentAdventure;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;
public class AdventureOrganismPanel extends JPanel{
	private ArrayList<JButton> cardButtons = new ArrayList<JButton>();
	private ImageIcon test = new ImageIcon("assets/Cytoplasm.png");
	private int place = 0;
	AdventureOrganismPanel(){
		this.setLayout(new GridLayout(4,3));
		for(int col=0;col<3;col++){
			for(int row=0;row<4;row++){
				JButton card = new JButton("" + place);
				cardButtons.add(card);
				this.add(card);
				place++;
			}
		}
	}
}
