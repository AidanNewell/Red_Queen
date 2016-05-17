package client;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import data.ImagePath;

import cards.*;

public class HandPanel extends JPanel{

	private int index=0;
	
	private ArrayList<Card> cards;
	private CardButton[] cardButtons;
	
	private GameScreen referenceScreen;
	
	public HandPanel(GameScreen g)
	{
		referenceScreen = g;
		cards = new ArrayList<Card>();
		cardButtons = new CardButton[7];
		setOpaque(false);
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
					if(referenceScreen.gameState != GameScreen.DRAW_CARDS)
					{
						if(index > 0)
							index --;
						resetCardButtons();
					}
				}
			});
			buttonImg = ImagePath.RIGHT_ARROW;
			rightArrow = new JButton(new ImageIcon(buttonImg));
			rightArrow.setOpaque(false);
			rightArrow.setContentAreaFilled(false);
			rightArrow.setFocusPainted(false);
			rightArrow.setBorderPainted(false);
			rightArrow.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					if(referenceScreen.gameState != GameScreen.DRAW_CARDS)
					{
						if(cards.size() - index > 7)
							index++;
						resetCardButtons();
					}
				}
			});
			Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
			add(leftArrow);
			leftArrow.setBounds(20,0,40,120);
			add(rightArrow);
			rightArrow.setBounds((int) screenDim.getWidth() - 60,0, 40 ,120);
		}catch(Exception e){e.printStackTrace(); System.exit(2);}
	}
	
	private void resetCardButtons()
	{
		for(int x=0; x<cardButtons.length;x++)
		{
			Card current = cards.get(index+x);
			cardButtons[x] = new CardButton(current, new ImageIcon(current.getCardArt()),0,0);
		}
		revalidate();
		repaint();
	}
}
