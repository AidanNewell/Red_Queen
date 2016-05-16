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
import data.Organism;

public class OrganismPane extends JPanel{

	private Organism organism;
	
	private static final int SPACE_AVAILABLE = 600;
	
	public OrganismPane(Organism o)
	{
		organism = o;
		int width = organism.getWidth();
		int height = organism.getHeight();
		setLayout(new GridLayout(height,width));
		int cardXSize = SPACE_AVAILABLE / width;
		int cardYSize = SPACE_AVAILABLE / height;
		for(int a=0; a<width;a++)
		{
			for(int b=0; b<height;b++)
			{
				BuilderCard current = organism.getCardAt(a,b);
				if(current != null)
				{
					JButton cardButton = null;
					try{
						Image buttonImage = current.getCardArt();
						cardButton = new CardButton(new ImageIcon(buttonImage),a,b);
						cardButton.setOpaque(false);
						cardButton.setContentAreaFilled(false);
						cardButton.setFocusPainted(false);
						cardButton.setBorderPainted(false);
						cardButton.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e)
							{
								organism.getCardAt(getX(), getY()).activateCard();
							}
						});
					}catch(Exception e){System.out.println("FATAL ERROR"); e.printStackTrace(); System.exit(Integer.MAX_VALUE);}
					add(cardButton);
				}
				else
				{
					this.add(new JLabel());
				}
			}
		}
	}
}
