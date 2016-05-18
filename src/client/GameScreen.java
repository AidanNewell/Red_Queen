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
import javax.swing.JPanel;

import data.Player;

public class GameScreen extends JPanel implements MouseListener
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
	
	private ArrayList<OrganismPane> playerOrganisms;
	
	private Rectangle HandRectangle;
	
	public GameScreen()
	{
		drawPiles = new DrawPanel(this);
		handPanel = new HandPanel(this);
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
		drawPiles.setPreferredSize(new Dimension(screenWidth,screenHeight));
		add(drawPiles);
		drawPiles.setBounds(0,0,screenWidth,screenHeight-180);
		handPanel.setPreferredSize(new Dimension(screenWidth, 180));
		add(handPanel);
		HandRectangle = new Rectangle(0,screenHeight-180, screenWidth, 180);
		handPanel.setBounds(HandRectangle);
		addMouseListener(this);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		setBackground(new Color(161,244,136));
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
			break;
		case PLAY_CARDS:
			break;
		case DISCARD:
			drawPiles.cardsRemaining = mainPlayer.getCardsToDraw();
			gameState = DRAW_CARDS;
			add(drawPiles);
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
		if(MOUSE.getCard() != null && HandRectangle.contains(arg0.getPoint()))
		{
			mainPlayer.getHand().getHand().add(MOUSE.getCard());
			MOUSE.setCardNull();
			revalidateHand();
		}
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

}