package client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cards.Card;
import data.ImagePath;

public class DrawPanel extends JPanel{

	public int cardsRemaining;
	public JLabel remainingCardCount;
	
	private GameScreen referenceScreen;
	Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
	int screenWidth = (int) screenDim.getWidth();
	int screenHeight = (int) screenDim.getHeight();
	
	public DrawPanel(GameScreen g)
	{
		referenceScreen = g;
		setOpaque(false);
		JButton CytoStack = null;
		JButton OrgStack = null;
		JButton PetriStack = null;
		try{
			Image buttonImg = ImagePath.CYTO_BACK;
			CytoStack = new JButton(new ImageIcon(buttonImg));
			CytoStack.setOpaque(false);
			CytoStack.setContentAreaFilled(false);
			CytoStack.setFocusPainted(false);
			CytoStack.setBorderPainted(false);
			CytoStack.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					GameScreen.getPlayer().drawCards(Card.CYTOPLASM_CARD);
					cardsRemaining--;
					revalidate();
					referenceScreen.nextGameState();
				}
			});
			buttonImg = ImagePath.ORG_BACK;
			OrgStack = new JButton(new ImageIcon(buttonImg));
			OrgStack.setOpaque(false);
			OrgStack.setContentAreaFilled(false);
			OrgStack.setFocusPainted(false);
			OrgStack.setBorderPainted(false);
			OrgStack.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					GameScreen.getPlayer().drawCards(Card.ORGANISM_CARD);
					cardsRemaining--;
					revalidate();
					referenceScreen.nextGameState();
				}
			});
			buttonImg = ImagePath.PETRI_BACK;
			PetriStack = new JButton(new ImageIcon(buttonImg));
			PetriStack.setOpaque(false);
			PetriStack.setContentAreaFilled(false);
			PetriStack.setFocusPainted(false);
			PetriStack.setBorderPainted(false);
			PetriStack.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					GameScreen.getPlayer().drawCards(Card.PETRI_DISH_CARD);
					cardsRemaining--;
					revalidate();
					referenceScreen.nextGameState();
				}
			});
			remainingCardCount = new JLabel("Remaining: " + cardsRemaining);
			setLayout(null);
			add(CytoStack);
			CytoStack.setBounds(screenWidth/5 - 60, screenHeight/2 - 60, 120,120);
			add(OrgStack);
			OrgStack.setBounds( 2 * screenWidth/5 - 60, screenHeight/2 - 60, 120,120);
			add(PetriStack);
			PetriStack.setBounds(3*(screenWidth/5) - 60, screenHeight/2 - 60, 120,120);
			add(remainingCardCount);
			remainingCardCount.setBounds(4*screenWidth/5,screenHeight/2,120,120);
		}catch(Exception e){System.out.println("FATAL ERROR"); e.printStackTrace(); System.exit(2);}
		repaint();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(new Color(100,100,100));
		g.fillRect( 0,screenHeight/2-80, screenWidth, 160);
	}
	
	public void updateLabelText(int x)
	{
		remainingCardCount.setText("Remaining: " + x);
	}
}
