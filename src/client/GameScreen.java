package client;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;

import cards.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;

import data.Organism;
import data.Player;

public class GameScreen extends JLayeredPane implements MouseListener
{
	private static Player mainPlayer;
	
	public static final int DRAW_CARDS = 1, BUILD_ORG =2, PLAY_CARDS =3, DISCARD = 4;
	
	public static int gameState = DRAW_CARDS;
	
	private static int drawCardsRemaining;
	
	public static MouseImageBox MOUSE;
	
	private int screenWidth, screenHeight;
	private OrganismPane organismPanel;
	private static DrawPanel drawPiles;
	private static HandPanel handPanel;
	private static OrganismPane focusedOrganism;
	private static resourcePane resources;
	private static EnemyPane AI;
	private Rectangle HandRectangle;
	private Rectangle OrganismRectangle;
	
	private static int CytoAvailable;
	
	public GameScreen()
	{
		drawPiles = new DrawPanel(this);
		handPanel = new HandPanel(this);
		focusedOrganism = new OrganismPane(this);
		AI = new EnemyPane(this);
		resources = new resourcePane();
		CytoAvailable = 1;
		MOUSE = new MouseImageBox();
		Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
		screenWidth = (int) screenDim.getWidth();
		screenHeight = (int) screenDim.getHeight();
		setLayout(null);
		JButton quitButton = null;
		try{
			Image quitImage = ImageIO.read(new File("assets/X.png"));
			quitButton = new JButton(new ImageIcon(quitImage));
			quitButton.setOpaque(false);
			quitButton.setContentAreaFilled(false);
			quitButton.setBorderPainted(false);
			quitButton.setFocusPainted(false);
		}catch(Exception e){}
		add(quitButton);
		quitButton.setBounds(screenWidth - 50, 0, 50, 50);
		quitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				Client.quitGame();
			}
		});
		handPanel.setPreferredSize(new Dimension(screenWidth, 180));
		add(handPanel);
		HandRectangle = new Rectangle(0,screenHeight-180, screenWidth, 180);
		OrganismRectangle = new Rectangle(100,100,600,600);
		handPanel.setBounds(HandRectangle);
		add(focusedOrganism);
		focusedOrganism.setBounds(0,0,600,700);
		add(resources);
		resources.setBounds(screenWidth/2 -30,screenHeight/2,60,120);
		drawPiles.setPreferredSize(new Dimension(screenWidth,screenHeight));
		add(AI);
		AI.setBounds(900,0,600,700);
		add(drawPiles);
		moveToFront(drawPiles);
		drawPiles.setBounds(0,0,screenWidth,screenHeight-180);
		addMouseListener(this);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(new Color(161,244,136));
		g.fillRect(0, 0, getWidth(), getHeight());
	}
	
	public void nextGameState()
	{
		switch(gameState)
		{
		case DRAW_CARDS:
			if(drawPiles.cardsRemaining <= 0)
			{
				gameState = BUILD_ORG;
				remove(drawPiles);
				revalidate();
				repaint();
			}
			drawPiles.updateLabelText(drawPiles.cardsRemaining);
			handPanel.resetCardButtons();
			break;
		case BUILD_ORG:
			gameState = DISCARD;
			nextGameState();
			break;
		case PLAY_CARDS:
			break;
		case DISCARD:
			drawPiles.cardsRemaining = mainPlayer.getCardsToDraw();
			AI.takeTurn();
			gameState = DRAW_CARDS;
			add(drawPiles);
			drawPiles.cardsRemaining = mainPlayer.getCardsToDraw();
			moveToFront(drawPiles);
			CytoAvailable = mainPlayer.getCytoToPlay();
			mainPlayer.pruneOrg(AI.getToxin() - mainPlayer.getTotalRes());
			AI.pruneOrg(mainPlayer.getTotalToxin());
			mainPlayer.awakenAll();
			mainPlayer.resetBuffers();
			focusedOrganism.updateVars();
			AI.displayUpdate();
			updateResources();
			revalidate();
			repaint();
			break;
		}
	}

	public void updateCursor()
	{
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image cursorImage = MOUSE.getImage();
		if(cursorImage != null)
			setCursor(toolkit.createCustomCursor(cursorImage, new Point(getX(),getY()), "help"));
		else
			setCursor(Cursor.getDefaultCursor());
	}
	public void mouseClicked(MouseEvent arg0)
	{
		Point clicked = arg0.getPoint();
		Card cardHeld = MOUSE.getCard();
		if(cardHeld!= null)
		{
			if(HandRectangle.contains(clicked))
			{
				mainPlayer.getHand().getHand().add(MOUSE.getCard());
				MOUSE.setCardNull();
				revalidateHand();
				return;
			}
			if(cardHeld.getSpecialType() == Card.ORGANISM_CARD && gameState == BUILD_ORG && OrganismRectangle.contains(clicked))
			{
				mainPlayer.newOrganism(new Organism(((OrganismStarter)cardHeld).getHW()));
				MOUSE.setCardNull();
				revalidateOrganism();
			}
		}
		updateCursor();
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static Player getPlayer()
	{
		return mainPlayer;
	}
	
	public static void init()
	{
		mainPlayer = new Player();
		drawCardsRemaining = mainPlayer.getCardsToDraw();
		drawPiles.cardsRemaining = drawCardsRemaining;
		drawPiles.updateLabelText(drawPiles.cardsRemaining);
	}
	
	public static void revalidateHand()
	{
		handPanel.resetCardButtons();
	}
	
	public static void revalidateOrganism()
	{
		focusedOrganism.updateVars();
	}
	
	public static void addOrganism(Organism o)
	{
		mainPlayer.newOrganism(o);
	}
	
	public static boolean CytoValid()
	{
		if(CytoAvailable > 0)
			return true;
		return false;
	}
	
	public static void cytoAdded()
	{
		CytoAvailable--;
	}
	
	public static void updateResources()
	{
		resources.updateATP(mainPlayer.getTotalATP());
		resources.updateTox(mainPlayer.getTotalToxin());
	}
	
	public static void refreshOrganisms()
	{
		mainPlayer.refreshOrgs();
	}

}