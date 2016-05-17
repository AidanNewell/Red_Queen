package client;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import cards.*;
import data.ImagePath;

public class HandPanel extends JPanel{

	private int index;
	
	private ArrayList<Card> cards;
	
	public HandPanel()
	{
		JButton leftArrow = null;
		JButton rightArrow = null;
		setLayout(null);
		try{
			Image buttonImg = ImagePath.LEFT_ARROW;
			leftArrow = new JButton(new ImageIcon(buttonImg));
			leftArrow.setOpaque(false);
			leftArrow.setContentAreaFilled(false);
			leftArrow.setFocusPainted(false);
			leftArrow.setBorderPainted(false);
			leftArrow.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					
				}
			});
		}catch(Exception e){e.printStackTrace(); System.exit(2);}
	}
}
