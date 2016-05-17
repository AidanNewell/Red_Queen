package SahilAndAllisonsExcellentAdventure;
import javax.swing.*;
import cards.Card;

public class adventureCardButton extends JButton{
	private int index;
	public adventureCardButton(int i){
		index = i;
	}
	public int getIndex(){
		return index;
	}
}
