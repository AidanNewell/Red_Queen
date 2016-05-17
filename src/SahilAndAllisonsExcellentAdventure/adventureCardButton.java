package SahilAndAllisonsExcellentAdventure;
import java.awt.Dimension;

import javax.swing.*;

import cards.Card;

public class adventureCardButton extends JButton{
	private int index;
	public adventureCardButton(int i){
		index = i;
		this.setPreferredSize(new Dimension(170,170));
	}
	public int getIndex(){
		return index;
	}
}
