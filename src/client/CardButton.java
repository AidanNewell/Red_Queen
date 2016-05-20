package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import cards.BuilderCard;
import cards.Card;
import data.ImagePath;
import data.Organism;

public class CardButton extends JButton{
	
	private int organismX, organismY;
	
	private Card  c;
	
	private Organism referenceOrg;
	
	public CardButton(Organism o,Card c,ImageIcon i, int x, int y)
	{
		super(i);
		referenceOrg = o;
		this.c = c;
		organismX = x;
		organismY = y;
	}
	
	public int getOrganismX()
	{
		return organismX;
	}
	
	public int getOrganismY()
	{
		return organismY;
	}
	
	public Card getCard()
	{
		return c;
	}
	
	public void setupHandListener()
	{
		addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if(GameScreen.gameState != GameScreen.DRAW_CARDS && GameScreen.MOUSE.getCard() == null)
				{
					GameScreen.getPlayer().getHand().getHand().remove(c);
					GameScreen.MOUSE.setCard(c);
					GameScreen.revalidateHand();
				}
			}
		});
	}
	
	public void establishActivateableSlot()
	{
		addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if(GameScreen.MOUSE.getCard() == null && ! (((BuilderCard)c).active()))
				{
					BuilderCard b = (BuilderCard)c;
					b.setActive();
					switch(c.getSpecialType())
					{
					case 0:
						referenceOrg.modifyOrgATP(b.getATP() + b.getBufferATP());
						referenceOrg.modifyOrgTox(b.getToxin() + b.getBufferToxin());
						setIcon(new ImageIcon(ImagePath.CYTO_BACK));
						break;
					case 2:
						referenceOrg.modifyOrgATP(b.getATP() + b.getBufferATP());
						referenceOrg.modifyOrgTox(b.getToxin() + b.getBufferToxin());
						setIcon(new ImageIcon(ImagePath.PETRI_BACK));
						break;
					}
					GameScreen.updateResources();
					GameScreen.refreshOrganisms();
				}
			}
		});
	}
	
	public void establishFillableSlot()
	{
		addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if(GameScreen.gameState == GameScreen.BUILD_ORG && GameScreen.MOUSE.getCard()!= null && GameScreen.MOUSE.getCard().getSpecialType() != Card.ORGANISM_CARD)
				{
					if(GameScreen.MOUSE.getCard().getSpecialType() == Card.CYTOPLASM_CARD)
					{
						if(GameScreen.CytoValid())
						{
							GameScreen.cytoAdded();
							referenceOrg.addCard(organismX, organismY, (BuilderCard)GameScreen.MOUSE.getCard());
							GameScreen.MOUSE.setCardNull();
							GameScreen.revalidateOrganism();
							GameScreen.refreshOrganisms();
						}
						return;
					}
					BuilderCard b = (BuilderCard)GameScreen.MOUSE.getCard();
					if(GameScreen.getPlayer().getTotalATP() >= b.getCost())
					{
						referenceOrg.addCard(organismX, organismY, b);
						b.modifyOrganism(referenceOrg,organismX,organismY);
						GameScreen.MOUSE.setCardNull();
						GameScreen.revalidateOrganism();
						GameScreen.getPlayer().spendATP(b.getCost());
						GameScreen.updateResources();
					}
				}
				GameScreen.refreshOrganisms();
			}
		});
	}
	
}