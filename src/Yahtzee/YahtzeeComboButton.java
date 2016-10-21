package Yahtzee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class YahtzeeComboButton extends JButton implements ActionListener{
	private boolean selected,buttonEnabled,used;
	private String name; 
	YahtzeeComboButton(String comboName){
		super();
		name = comboName;
		setText(comboName);
		selected = false;
		buttonEnabled = true;
		addActionListener(this);
	}
	public String getName(){
		return name;
	}
	
	public boolean isSelected(){
		return selected;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if(buttonEnabled)
		{
			selected=true;
			used = true;
		}
	}
	
	public void nullify()
	{
		selected = false;
		removeActionListener(this);
		setEnabled(false);
	}
	
	public boolean isUsed()
	{
		return used;
	}
	
	public void enable()
	{
		buttonEnabled = true;
	}
	
	public void disable()
	{
		buttonEnabled = false;
	}

}
