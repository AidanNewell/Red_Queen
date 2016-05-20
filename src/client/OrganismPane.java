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
import cards.Card;
import data.ImagePath;
import data.Organism;

public class OrganismPane extends JPanel{

	private ArrayList<Organism> organisms;
	
	private static final int SPACE_AVAILABLE = 600;
	private int vertSpace;
	private int horizSpace;
	
	private GameScreen referenceScreen;
	
	private int index;
	
	private JButton upArrow, downArrow, done;
	
	public OrganismPane(GameScreen g)
	{
		setLayout(null);
		setOpaque(false);
		referenceScreen = g;
		upArrow = null;
		downArrow = null;
		done=null;
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
						displayOrgAt(index);
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
						displayOrgAt(index);
					}
				}
			});
			buttonImg = ImagePath.DONE;
			done = new JButton(new ImageIcon(buttonImg));
			done.setOpaque(false);
			done.setContentAreaFilled(false);
			done.setFocusPainted(false);
			done.setBorderPainted(false);
			done.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					if(GameScreen.MOUSE.getCard() == null)
						referenceScreen.nextGameState();
				}
			});
			add(upArrow);
			upArrow.setBounds(180,0,240,40);
			add(downArrow);
			downArrow.setBounds(180,660,240,40);
			add(done);
			done.setBounds(480,640,120,60);
		}catch(Exception e){}
	}
	
	public void updateVars()
	{
		organisms = referenceScreen.getPlayer().getOrganisms();
		displayOrgAt(index);
	}
	
	private void displayOrgAt(int i)
	{
		removeAll();
		add(upArrow);
		add(downArrow);
		add(done);
		if(organisms.size() > 0)
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
						if(bCard.active()){
							if(bCard.getSpecialType() == Card.CYTOPLASM_CARD)
							{
								Image cardImg = ImagePath.CYTO_BACK.getScaledInstance(horizSpace,vertSpace,Image.SCALE_SMOOTH);
								button = new CardButton(construct,bCard, new ImageIcon(cardImg),x,y);
								button.setOpaque(false);
								button.setContentAreaFilled(false);
								button.setBorderPainted(false);
								button.setFocusPainted(false);
								button.establishActivateableSlot();
							}else{
								Image cardImg = ImagePath.PETRI_BACK.getScaledInstance(horizSpace,vertSpace,Image.SCALE_SMOOTH);
								button = new CardButton(construct,bCard, new ImageIcon(cardImg),x,y);
								button.setOpaque(false);
								button.setContentAreaFilled(false);
								button.setBorderPainted(false);
								button.setFocusPainted(false);
								button.establishActivateableSlot();
							}
						}else{
							try{
								Image cardImg = bCard.getCardArt().getScaledInstance(horizSpace, vertSpace, Image.SCALE_SMOOTH);
								button = new CardButton(construct,bCard, new ImageIcon(cardImg),x,y);
								button.setOpaque(false);
								button.setContentAreaFilled(false);
								button.setBorderPainted(false);
								button.setFocusPainted(false);
								button.establishActivateableSlot();
							}catch(Exception e){}
						}
					}
					else
					{
						try{
							Image cardImg = ImagePath.NULL_BUILD_SLOT.getScaledInstance(horizSpace, vertSpace, Image.SCALE_SMOOTH);
							button = new CardButton(construct,null, new ImageIcon(cardImg),x,y);
							button.setOpaque(false);
							button.setContentAreaFilled(false);
							button.setFocusPainted(false);
							button.setBorderPainted(false);
							button.establishFillableSlot();
						}catch(Exception e){}
					}
					add(button);
					button.setBounds(y*horizSpace,(x*vertSpace)+60,horizSpace,vertSpace);
				}
			}
		}
		revalidate();
		referenceScreen.updateCursor();
		//construct.updateOrganism();
	}
}
