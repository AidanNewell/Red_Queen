package client;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MainMenu()
	{
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		JLabel title = null;
		try {
			Image titleImage = ImageIO.read(new File("assets/RedQueenTitle.png"));
			title = new JLabel(new ImageIcon(titleImage));
		} catch (Exception e){}
		title.setAlignmentX(CENTER_ALIGNMENT);
		add(title);
		JButton game = null;
		try{
			Image gameImage = ImageIO.read(new File("assets/NewGameButton.png"));
			game = new JButton(new ImageIcon(gameImage));
			game.setOpaque(false);
			game.setContentAreaFilled(false);
			game.setBorderPainted(false);
			game.setFocusPainted(false);
		}catch(Exception e){}
		game.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Client.setCard("GAME_CREATION");
			}
		});
		game.setAlignmentX(CENTER_ALIGNMENT);
		add(Box.createRigidArea(new Dimension(0,50)));
		add(game);
		add(Box.createRigidArea(new Dimension(0,20)));
		JButton quit = null;
		try{
			Image quitImage = ImageIO.read(new File("assets/QuitButton.png"));
			quit = new JButton(new ImageIcon(quitImage));
			quit.setOpaque(false);
			quit.setContentAreaFilled(false);
			quit.setBorderPainted(false);
			quit.setFocusPainted(false);
		}catch(Exception e){}
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Client.quitGame();
			}
		});
		quit.setAlignmentX(CENTER_ALIGNMENT);
		add(quit);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.fillRect(0,0,getWidth(),getHeight());
	}
}
