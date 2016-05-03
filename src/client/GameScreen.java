package client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import cards.Card;
import data.ImagePath;
import data.Player;


public class GameScreen extends JPanel implements MouseListener{

	
	public static final int DRAW_CARDS=0, BUILD_ORG=1, PLAY_CARDS=2, DISCARD =3;
			
	private int gameState = DRAW_CARDS;
	private static int screenWidth, screenHeight;
	
	private JButton left_button;
	private JButton right_button;
	
	private static Player mainPlayer;
	
	private static Rectangle Cyto_draw, Org_draw, Petri_draw;
	
	private static int playerCardDrawsRemaining=0;
	private static int cardYPlacement;
	
	private static final long serialVersionUID = 1L;
	public GameScreen()
	{
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		screenWidth = screen.width;
		screenHeight = screen.height;
		try{
			left_button = new JButton(new ImageIcon(ImageIO.read(new File("assets/Left_Arrow.png"))));
			right_button = new JButton(new ImageIcon(ImageIO.read(new File("assets/Right_Arrow.png"))));
		}catch(Exception e){e.printStackTrace();System.exit(1);}
		addMouseListener(this);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		//Background
		setBackground(new Color(117,212,116));
		
		//Paint hand
		int numCards = mainPlayer.getHand().getHand().size();
		int spacing = (screenWidth -100 )/ (numCards+1);
		if(numCards != 0)
		{
			for(int x=0; x<numCards; x++)
			{
				Card c = mainPlayer.getHand().getHand().get(x);
				g.drawImage(c.getCardArt(),50 + (x*spacing),cardYPlacement,null);
			}
		}
		
		//Paint overlay
			
		//Paint accessories
		switch(gameState)
		{
		case DRAW_CARDS:
			paintCardDraw(g);
			break;
		}
	}
	
	private void paintCardDraw(Graphics g)
	{
		g.setColor(new Color(0,0,0,0.4f));
		g.fillRect(0, 0, screenWidth, screenHeight);
		g.fillRect(0, screenHeight/2 - 90, screenWidth, 180);
		int spacing = (screenWidth - 600)/4;
		g.drawImage(ImagePath.CYTO_BACK, 300, screenHeight/2 - 70, null);
		g.drawImage(ImagePath.ORG_BACK, 300+(spacing), screenHeight/2 - 70, null);
		g.drawImage(ImagePath.PETRI_BACK, 300+(2*spacing), screenHeight/2 - 70, null);
	}
	
	public static void initData()
	{
		mainPlayer= Client.player;
		int spacing = (screenWidth - 600)/4;
		Cyto_draw = new Rectangle(300, screenHeight/2 - 70,ImagePath.CYTO_BACK.getWidth(null),ImagePath.CYTO_BACK.getHeight(null));
		Org_draw = new Rectangle(300 + spacing, screenHeight/2 -70, ImagePath.ORG_BACK.getWidth(null),ImagePath.ORG_BACK.getHeight(null));
		Petri_draw = new Rectangle(300 + (2*spacing),screenHeight/2- 70, ImagePath.PETRI_BACK.getWidth(null), ImagePath.PETRI_BACK.getHeight(null));
		playerCardDrawsRemaining = mainPlayer.getCardsToDraw();
		cardYPlacement = (15 * (screenHeight /16)) - ImagePath.CYTO_BACK.getHeight(null);
	}

	public void mouseClicked(MouseEvent arg0)
	{
		switch(gameState)
		{
		case DRAW_CARDS:
			Point clicked = arg0.getPoint();
			if(Cyto_draw.contains(clicked))
			{
				mainPlayer.drawCards(Card.CYTOPLASM_CARD);
				playerCardDrawsRemaining--;
			}
			if(Org_draw.contains(clicked))
			{
				mainPlayer.drawCards(Card.ORGANISM_CARD);
				playerCardDrawsRemaining--;
			}
			if(Petri_draw.contains(clicked))
			{
				mainPlayer.drawCards(Card.PETRI_DISH_CARD);
				playerCardDrawsRemaining--;
			}
			if(playerCardDrawsRemaining <= 0)
				nextGameState();
			break;
		case BUILD_ORG:
			break;
		case PLAY_CARDS:
			break;
		case DISCARD:
			break;
		}
	}
	
	private void nextGameState()
	{
		switch(gameState)
		{
		case DRAW_CARDS:
			gameState = BUILD_ORG;
			break;
		case BUILD_ORG:
			gameState = PLAY_CARDS;
			break;
		case PLAY_CARDS:
			gameState = DISCARD;
			break;
		case DISCARD:
			gameState = DRAW_CARDS;
			playerCardDrawsRemaining = mainPlayer.getCardsToDraw();
			break;
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}

}
