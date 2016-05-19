package client;

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
import cards.CardLoader;
import cards.OrganismStarter;
import data.Hand;
import data.ImagePath;
import data.Organism;

public class EnemyPane extends JPanel{

	private JButton up,down;
	
	private static final int SPACE_AVAILABLE = 600;
	
	private int index;
	private int masterIndex=0;
	private int AvailTox;
	
	private ArrayList<Organism> organisms;
	
	private Hand AIHand;
	
	private GameScreen referenceScreen;
	
	private int vertSpace, horizSpace;
	
	public EnemyPane(GameScreen g)
	{
		setOpaque(false);
		index =0;
		organisms = new ArrayList<Organism>();
		AIHand = new Hand();
		referenceScreen = g;
		setLayout(null);
		up=null;
		down=null;
		try{
			Image buttonImg = ImagePath.UP_ARROW;
			up = new JButton(new ImageIcon(buttonImg));
			up.setOpaque(false);
			up.setContentAreaFilled(false);
			up.setFocusPainted(false);
			up.setBorderPainted(false);
			up.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					if(referenceScreen.gameState != GameScreen.DRAW_CARDS && index !=0)
					{
						index--;
						displayOrgAt(index);
					}
				}
			});
			buttonImg = ImagePath.DOWN_ARROW;
			down = new JButton(new ImageIcon(buttonImg));
			down.setOpaque(false);
			down.setContentAreaFilled(false);
			down.setFocusPainted(false);
			down.setBorderPainted(false);
			down.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					if(referenceScreen.gameState != GameScreen.DRAW_CARDS && index < organisms.size() -1)
					{
						index++;
						displayOrgAt(index);
					}
				}
			});
			add(up);
			up.setBounds(180,0,240,40);
			add(down);
			down.setBounds(180,660,240,40);
		}catch(Exception e){}
	}
	
	
	
	private void displayOrgAt(int i)
	{
		removeAll();
		add(up);
		add(down);
		Organism current = organisms.get(i);
		vertSpace = SPACE_AVAILABLE / current.getHeight();
		horizSpace = SPACE_AVAILABLE / current.getWidth();
		for(int x=0; x<current.getHeight();x++)
		{
			for(int y=0; y<current.getWidth();y++)
			{
				JLabel displayLabel = null;
				BuilderCard b = current.getCardAt(x,y);
				if(b != null)
				{
					if(b.active())
					{
						if(b.getSpecialType() == Card.CYTOPLASM_CARD)
						{
							Image labelImg = ImagePath.CYTO_BACK.getScaledInstance(horizSpace,vertSpace,Image.SCALE_SMOOTH);
							displayLabel = new JLabel(new ImageIcon(labelImg));
							add(displayLabel);
							displayLabel.setBounds(y*horizSpace,x*vertSpace+60,horizSpace,vertSpace);
						}
						else
						{
							Image labelImg = ImagePath.PETRI_BACK.getScaledInstance(horizSpace,vertSpace,Image.SCALE_SMOOTH);
							displayLabel = new JLabel(new ImageIcon(labelImg));
							add(displayLabel);
							displayLabel.setBounds(y*horizSpace,x*vertSpace+60,horizSpace,vertSpace);
						}
					}
					else
					{
						Image labelImg = b.getCardArt().getScaledInstance(horizSpace, vertSpace, Image.SCALE_SMOOTH);
						displayLabel = new JLabel(new ImageIcon(labelImg));
						add(displayLabel);
						displayLabel.setBounds(y*horizSpace,x*vertSpace+60,horizSpace,vertSpace);
					}
				}
				else
				{
					Image labelImg = ImagePath.NULL_BUILD_SLOT;
					displayLabel = new JLabel(new ImageIcon(labelImg.getScaledInstance(horizSpace, vertSpace, Image.SCALE_SMOOTH)));
					add(displayLabel);
					displayLabel.setBounds(y*horizSpace,x*vertSpace+60,horizSpace,vertSpace);
				}
			}
		}
	}
	
	public void takeTurn()
	{
		boolean cytoPlayed = false;
		int AvailATP=0;
		AvailTox=0;
		for(int x=0; x<3; x++)
		{
			if(organisms.size() == 0 || allOrgsFull() && x==0)
			{
				AIHand.addCard(CardLoader.getOrganismCard());
			}
			else if(x==0)
			{
				AIHand.addCard(CardLoader.getPetriCard());
			}
			if(x==1)
			{
				AIHand.addCard(CardLoader.getCytoplasmCard());
			}
			if(x==2)
			{
				AIHand.addCard(CardLoader.getPetriCard());
			}
		}
		if(organisms.size() == 0 || allOrgsFull())
		{
			for(int x=0; x <AIHand.getHand().size(); x++)
			{
				if(AIHand.getHand().get(x).getSpecialType() == Card.ORGANISM_CARD)
				{
					organisms.add(new Organism(((OrganismStarter)AIHand.getHand().get(x)).getHW()));
					AIHand.getHand().remove(x);
					x--;
				}
			}
		}
		Organism construct = organisms.get(masterIndex);
		//Activate all tiles
		for(int x=0; x<construct.getHeight();x++)
		{
			for(int y=0; y<construct.getWidth(); y++)
			{
				BuilderCard b = construct.getCardAt(x,y);
				if(b!=null)
					b.activateCard();
				if(construct.isOccupied(x,y) && (b.getATP() + b.getBufferATP() > 0 || b.getToxin() + b.getBufferToxin() > 0) && !b.active())
				{
					b.setActive();
					AvailATP += (b.getATP() + b.getBufferATP());
					AvailTox += (b.getToxin() + b.getBufferToxin());
				}
			}
		}
		for(int x=0; x<AIHand.getHand().size();x++)
		{
			if(AIHand.getHand().get(x).getSpecialType() == Card.CYTOPLASM_CARD && !cytoPlayed && !construct.isFull())
			{
				int xPos=0, yPos=0;
				while(construct.isOccupied(xPos, yPos)){xPos = (int)(Math.random()*construct.getHeight()); yPos=(int)(Math.random()*construct.getWidth());}
				construct.addCard(xPos,yPos,(BuilderCard)AIHand.getHand().get(x));
				AIHand.getHand().remove(x);
				x--;
				cytoPlayed=true;
			}else if(AIHand.getHand().get(x).getSpecialType() == Card.PETRI_DISH_CARD && ((BuilderCard)AIHand.getHand().get(x)).getCost() <= AvailATP && !construct.isFull())
			{
				int xPos=0,yPos=0;
				while(construct.isOccupied(xPos, yPos)){xPos = (int)(Math.random()*construct.getHeight()); yPos=(int)(Math.random()*construct.getWidth());}
				construct.addCard(xPos, yPos, (BuilderCard)AIHand.getHand().get(x));
				AvailATP -= ((BuilderCard)AIHand.getHand().get(x)).getCost();
				AIHand.getHand().remove(x);
				x--;
			}
		}
		for(Organism o : organisms)
		{
			o.updateOrganism();
		}
	}
	
	public void displayUpdate()
	{
		displayOrgAt(index);
	}
	
	public int getToxin()
	{
		return AvailTox;
	}
	
	private boolean allOrgsFull()
	{
		for(Organism o : organisms)
		{
			if(!o.isFull())
				return false;
		}
		return true;
	}
	
	public void pruneOrg(int x)
	{
		int totalResistance =0;
		for(Organism o:organisms)
		{
			for(int i=0; i<o.getHeight();i++)
			{
				for(int j=0; j<o.getWidth();j++)
				{
					BuilderCard b = o.getCardAt(i, j);
					if(b != null)
						totalResistance+=b.getRes()+b.getBufferRes();
				}
			}
		}
		x-= totalResistance;
		if(x>=0)
		{
			System.out.println(x);
			for(int a=0; a<x;a++)
			{
				if(allOrgsDead())
				{
					System.out.println("YOU WIN, ALL ENEMY ORGANELLES KILLED!");
					System.exit(0);
				}
				Organism target = organisms.get((int)(Math.random()*organisms.size()));
				while(target.isEmpty()){target = organisms.get((int)(Math.random()*organisms.size()));}
				int targetX = (int)(Math.random()*target.getHeight());
				int targetY = (int)(Math.random()*target.getWidth());
				while(target.getCardAt(targetX, targetY) == null)
				{
					targetX = (int)(Math.random()*target.getHeight());
					targetY = (int)(Math.random()*target.getWidth());
				}
				target.killOrganelle(targetX,targetY);
			}
		}
	}
	
	public boolean allOrgsDead()
	{
		for(Organism o:organisms)
		{
			if(!o.isEmpty())
				return false;
		}
		return true;
	}
}
