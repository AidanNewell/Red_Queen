package Yahtzee;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


public class YahtzeePlayerFrame extends JFrame {
	private JPanel contentPane;
	private JPanel dicePane;
	private JPanel comboPane;
	YahtzeePlayerFrame(){
		contentPane = new JPanel();
		dicePane = new JPanel();
		setDiceLayout();
		comboPane = new JPanel();
		
		contentPane.add(dicePane);
		this.setContentPane(contentPane);
		
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	private void setButton(GridBagConstraints c, int gridx, int gridy, int diceNum){
		final JButton button = new JButton();
		Image img = null;
		Image img2 = null;
		try {
			switch (diceNum){
			case 1: 
				img = ImageIO.read(new File("/dice1Shade.png"));
				img2 = ImageIO.read(new File("/dice1.png"));
				break; 
			case 2: 
				img = ImageIO.read(new File("/dice2Shade.png"));
				img2 = ImageIO.read(new File("/dice2.png"));
				break; 
			case 3: 
				img = ImageIO.read(new File("/dice3Shade.png"));
				img2 = ImageIO.read(new File("/dice3.png"));
				break; 
			case 4: 
				img = ImageIO.read(new File("/dice4Shade.png"));
				img2 = ImageIO.read(new File("/dice4.png"));
				break; 
			case 5: 
				img = ImageIO.read(new File("/dice5Shade.png"));
				img2 = ImageIO.read(new File("/dice5.png"));
				break; 
			case 6: 
				img = ImageIO.read(new File("/dice6Shade.png"));
				img2 = ImageIO.read(new File("/dice6.png"));
				break; 
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image resizedShade = img.getScaledInstance(95, 95,Image.SCALE_SMOOTH);
		Image resizedReg = img2.getScaledInstance(95,95,Image.SCALE_SMOOTH);
		final ImageIcon Shade = new ImageIcon(resizedShade);
		final ImageIcon Reg = new ImageIcon(resizedReg);
		button.setIcon(Shade);
		button.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				if(button.getIcon() == Shade){
					button.setIcon(Reg);
				}
				else{
					button.setIcon(Shade);	
				}
			} 
		});
		button.setPreferredSize(new Dimension(100,100));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = gridx;
		c.gridy = gridy;
		dicePane.add(button, c);
	}
	private void setDiceLayout(){
		dicePane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		setButton(c, 0, 0, 1);
		setButton(c, 1, 0, 2);
		setButton(c, 0, 1, 3);
		setButton(c, 1, 1, 4);
		setButton(c, 0, 2, 5);
		setButton(c, 1, 2, 6);

	}
	public static void main (String args[]){
		new YahtzeePlayerFrame();
	}
}
