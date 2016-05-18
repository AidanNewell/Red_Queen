package client;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cards.BuilderCard;
import data.ImagePath;
import data.Organism;

public class OrganismPane extends JPanel{

	private Organism organism;
	
	private static final int SPACE_AVAILABLE = 600;
	
	private GameScreen referenceScreen;
	
	private int index;
	
	public OrganismPane(Organism o)
	{
		setLayout(null);
		JButton upArrow = null;
		JButton downArrow = null;
		try{
			Image buttonImg = ImagePath.UP_ARROW;
			upArrow = new JButton(new ImageIcon(buttonImg));
			upArrow.setOpaque(false);;
			upArrow.setContentAreaFilled(false);
			upArrow.setFocusPainted(false);
			upArrow.setBorderPainted(false);
			upArrow.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					
				}
			});
			buttonImg = ImagePath.DOWN_ARROW;
			downArrow = new JButton(new ImageIcon(buttonImg));
			downArrow.setOpaque(false);
			downArrow.setContentAreaFilled(false);
			downArrow.setFocusPainted(false);
			downArrow.setBorderPainted(false);
			downArrow.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					
				}
			});
			add(upArrow);
			add(downArrow);
		}catch(Exception e){}
	}
}
