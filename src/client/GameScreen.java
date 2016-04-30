package client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import cards.Card;
import data.ImagePath;
import data.Player;


public class GameScreen extends JPanel{

	
	public static final int DRAW_CARDS=0, BUILD_ORG=1, PLAY_CARDS=2, DISCARD =3;
			
	private int gameState=DRAW_CARDS;
	private int screenWidth, screenHeight;
	
	private JButton left_button;
	private JButton right_button;
	
	private static Player mainPlayer;
	
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
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		//Background
		setBackground(new Color(117,212,116));
		//Paint overlay
		g.drawImage(ImagePath.HUD_BANNER,0,0,null);
		//Paint accessories
		//Paint hand
		for( Card c : mainPlayer.getHand().getHand())
		{
			
		}
	}
	
	public static void initData()
	{
		mainPlayer= Client.player;
	}

}
