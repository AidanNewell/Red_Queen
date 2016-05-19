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
import data.Player;
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
			leftArrow.setBounds(20,30,40,120);
			add(rightArrow);
			rightArrow.setBounds((int) screenDim.getWidth() - 60,30, 40 ,120);
		}catch(Exception e){e.printStackTrace(); System.exit(2);}
	}
	
	public void resetCardButtons()
	{
		cards = GameScreen.getPlayer().getHand().getHand();
		for(int x=0; x<cardButtons.length;x++)
		{
			try{
				remove(cardButtons[x]);
			}catch(Exception e){}
			Card current = null;
			try{
				current = cards.get(index+x);
			}catch(Exception e){}
			cardButtons[x] = null;
			if(current != null)
			{
				cardButtons[x] = new CardButton(null,current, new ImageIcon(current.getCardArt()),0,0);
				cardButtons[x].setOpaque(false);
				cardButtons[x].setContentAreaFilled(false);
				cardButtons[x].setBorderPainted(false);
				cardButtons[x].setFocusPainted(false);
				cardButtons[x].setupHandListener();
				(cardButtons[x]).setBounds(150 + (x*184),8,164,164);
				add(cardButtons[x]);
			}
		}
		revalidate();
		repaint();
		referenceScreen.updateCursor();
	}
}
