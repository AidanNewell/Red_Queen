package client;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
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
	private Player mainPlayer;
	
	public int gameState;
	
	private static final int DRAW_CARDS = 1, BUILD_ORG =2, PLAY_CARDS =3, DISCARD = 4;
	
	private int drawCardsRemaining;
	
	public static MouseImageBox MOUSE;
	
	private int screenWidth, screenHeight;
	private JPanel organismPanel;
	
	private ArrayList<OrganismPane> playerOrganisms;
	
	public GameScreen()
	{
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
		MOUSE.setCard(new MitochondriaCard());
		addMouseListener(this);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		setBackground(new Color(161,244,136));
	}

	public void mouseClicked(MouseEvent arg0)
	{
		System.out.println("AALALALA");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image cursorImage = MOUSE.getImage();
		if(cursorImage != null)
			setCursor(toolkit.createCustomCursor(cursorImage, new Point(getX(),getY()), "help"));
		else
			setCursor(Cursor.getDefaultCursor());
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

}