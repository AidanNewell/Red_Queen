package client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import data.ImagePath;


public class GameScreen extends JPanel{

	
	public static final int DRAW_CARDS=0, BUILD_ORG=1, PLAY_CARDS=2, DISCARD =3;
			
	private int gameState=DRAW_CARDS;
	private int screenWidth, screenHeight;
	
	private static final long serialVersionUID = 1L;
	public GameScreen()
	{
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		screenWidth = screen.width;
		screenHeight = screen.height;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		//Background
		setBackground(new Color(117,212,116));
		//Paint overlay
		g.drawImage(ImagePath.HUD_BANNER,0,0,null);
		g.drawImage(ImagePath.LEFT_ARROW, 0, screenHeight/8 + 30, null);
		g.drawImage(ImagePath.RIGHT_ARROW, 7*screenWidth/8, screenHeight/8 + 30, null);
		//Paint accessories
		//Paint hand
	}

}
