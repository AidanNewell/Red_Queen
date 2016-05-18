package client;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cards.BuilderCard;
import data.ImagePath;
import data.Organism;

public class OrganismPane extends JPanel{

	private ArrayList<Organism> organisms;
	
	private static final int SPACE_AVAILABLE = 600;
	private int vertSpace;
	private int horizSpace;
	
	private GameScreen referenceScreen;
	
	private int index;
	
	public OrganismPane(GameScreen g)
	{
		setLayout(null);
		setOpaque(false);
		referenceScreen = g;
		JButton upArrow = null;
		JButton downArrow = null;
		index =0;
		try{
			Image buttonImg = ImagePath.UP_ARROW;
			upArrow = new JButton(new ImageIcon(buttonImg));
			upArrow.setOpaque(false);;
			upArrow.setContentAreaFilled(false);
			upArrow.setFocusPainted(false);
			upArrow.setBorderPainted(false);
			upArrow.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					if(referenceScreen.gameState != GameScreen.DRAW_CARDS && index != 0)
					{
						index--;
					}
				}
			});
			buttonImg = ImagePath.DOWN_ARROW;
			downArrow = new JButton(new ImageIcon(buttonImg));
			downArrow.setOpaque(false);
			downArrow.setContentAreaFilled(false);
			downArrow.setFocusPainted(false);
			downArrow.setBorderPainted(false);
			downArrow.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					if(referenceScreen.gameState != GameScreen.DRAW_CARDS && index < organisms.size() -1)
					{
						index++;
					}
				}
			});
			add(upArrow);
			upArrow.setBounds(0,0,240,40);
			add(downArrow);
			downArrow.setBounds(0,0,240,40);
		}catch(Exception e){}
	}
	
	public void updateVars()
	{
		organisms = referenceScreen.getPlayer().getOrganisms();
		displayOrgAt(index);
	}
	
	private void displayOrgAt(int i)
	{
		Organism construct = organisms.get(i);
		vertSpace = SPACE_AVAILABLE / construct.getHeight();
		horizSpace = SPACE_AVAILABLE / construct.getWidth();
		for(int x=0; x<construct.getHeight();x++)
		{
			for(int y=0; y<construct.getWidth();y++)
			{
				CardButton button = null;
				BuilderCard bCard = construct.getCardAt(x,y);
				if(bCard != null)
				{
					try{
						Image cardImg = bCard.getCardArt();
						button = new CardButton(bCard, new ImageIcon(cardImg),x,y);
						button.setOpaque(false);
						button.setContentAreaFilled(false);
						button.setBorderPainted(false);
						button.setFocusPainted(false);
					}catch(Exception e){}
				}
				else
				{
					try{
						Image cardImg = ImagePath.NULL_BUILD_SLOT;
						button = new CardButton(null, new ImageIcon(cardImg),x,y);
						button.setOpaque(false);
						button.setContentAreaFilled(false);
						button.setFocusPainted(false);
						button.setBorderPainted(false);
					}catch(Exception e){}
				}
				add(button);
				button.setBounds(0,0,0,0);
			}
		}
	}
}
