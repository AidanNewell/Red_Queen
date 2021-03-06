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

public class GameCreationScreen extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public GameCreationScreen()
	{
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		JLabel title = null;
		try {
			Image titleImage = ImageIO.read(new File("assets/RedQueenTitle.png"));
			title = new JLabel(new ImageIcon(titleImage));
		} catch (Exception e){}
		title.setAlignmentX(CENTER_ALIGNMENT);
		add(title);
		add(Box.createRigidArea(new Dimension(0,50)));
		JButton game = null;
		try{
			Image gameImage = ImageIO.read(new File("assets/SinglePlayerButton.png"));
			game = new JButton(new ImageIcon(gameImage));
			game.setOpaque(false);
			game.setContentAreaFilled(false);
			game.setBorderPainted(false);
			game.setFocusPainted(false);
		}catch(Exception e){}
		game.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Client.setCard("GAME_SCREEN");
			}
		});
		game.setAlignmentX(CENTER_ALIGNMENT);
		add(game);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.fillRect(0, 0, getWidth(), getHeight());
	}

}
