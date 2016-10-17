package Yahtzee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class YahtzeeComboButton extends JButton implements ActionListener{
	private boolean selected;
	private String name; 
	YahtzeeComboButton(String comboName){
		super();
		name = comboName;
		setText(comboName);
		addActionListener(this);
	}
	public String getName(){
		return name;
	}
	public boolean isSelected(){
		return selected;
	}
	public void actionPerformed(ActionEvent arg0) {
		if(selected)
			selected = false;
		else
			selected = true;
	}

}
