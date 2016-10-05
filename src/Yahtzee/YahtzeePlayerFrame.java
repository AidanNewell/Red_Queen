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
	private JButton[] diceButtons;
	
	YahtzeePlayerFrame(){
		contentPane = new JPanel();
		dicePane = new JPanel();
		diceButtons = new JButton[6];
		for(int i = 0; i<6; i++){
			diceButtons[i] = new JButton();
		}
		setDicePaneLayout(diceButtons);
		comboPane = new JPanel();
		setComboPaneLayout(comboPane);
		
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.LINE_AXIS));
		contentPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		contentPane.add(Box.createHorizontalGlue());
		contentPane.add(Box.createRigidArea(new Dimension(10, 0)));
		contentPane.add(comboPane);
		contentPane.add(dicePane);
		contentPane.setPreferredSize(new Dimension(500,500));

		setContentPane(contentPane);
		
		pack();
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	private void setDicePaneLayout(JButton[] buttons){
		dicePane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		setButton(buttons[0],c, 0, 0, 1);
		setButton(buttons[1],c, 1, 0, 2);
		setButton(buttons[2],c, 0, 1, 3);
		setButton(buttons[3],c, 1, 1, 4);
		setButton(buttons[4],c, 0, 2, 5);
		setButton(buttons[5],c, 1, 2, 6);
		
		JButton button = new JButton("Reroll");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 2; 
		dicePane.add(button, c);

	}
	private void setButton(final JButton b, GridBagConstraints c, int gridx, int gridy, int diceNum){
		Image img = null;
		Image img2 = null;
		try {
			switch (diceNum){
			case 1: 
				img = ImageIO.read(new File("YahtzeeDice/dice1Shade.png"));
				img2 = ImageIO.read(new File("YahtzeeDice/dice1.png"));
				break; 
			case 2: 
				img = ImageIO.read(new File("YahtzeeDice/dice2Shade.png"));
				img2 = ImageIO.read(new File("YahtzeeDice/dice2.png"));
				break; 
			case 3: 
				img = ImageIO.read(new File("YahtzeeDice/dice3Shade.png"));
				img2 = ImageIO.read(new File("YahtzeeDice/dice3.png"));
				break; 
			case 4: 
				img = ImageIO.read(new File("YahtzeeDice/dice4Shade.png"));
				img2 = ImageIO.read(new File("YahtzeeDice/dice4.png"));
				break; 
			case 5: 
				img = ImageIO.read(new File("YahtzeeDice/dice5Shade.png"));
				img2 = ImageIO.read(new File("YahtzeeDice/dice5.png"));
				break; 
			case 6: 
				img = ImageIO.read(new File("YahtzeeDice/dice6Shade.png"));
				img2 = ImageIO.read(new File("YahtzeeDice/dice6.png"));
				break; 
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image resizedShade = img.getScaledInstance(95,95,Image.SCALE_SMOOTH);
		Image resizedReg = img2.getScaledInstance(95,95,Image.SCALE_SMOOTH);
		final ImageIcon Shade = new ImageIcon(resizedShade);
		final ImageIcon Reg = new ImageIcon(resizedReg);
		b.setIcon(Shade);
		b.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				if(b.getIcon() == Shade){
					b.setIcon(Reg);
				}
				else{
					b.setIcon(Shade);	
				}
			} 
		});
		b.setPreferredSize(new Dimension(100,100));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = gridx;
		c.gridy = gridy;
		dicePane.add(b, c);
	}
	private void setComboPaneLayout(JPanel pane){
		pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));
		pane.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
		
		AbstractYahtzeeCombination [] combos = AbstractYahtzeeCombination.allCombinations();
		JLabel upper = new JLabel("Upper Section");
		upper.setAlignmentX(Component.CENTER_ALIGNMENT);
		pane.add(upper);
		for(int i = 0; i <combos.length; i++){
			String comboString = combos[i].name();
			JButton comboButton = new JButton(comboString);
			comboButton.setAlignmentX(Component.CENTER_ALIGNMENT);
			pane.add(comboButton);	
			if(i == 5){
				pane.add(Box.createRigidArea(new Dimension(0,50)));
				JLabel lower = new JLabel("Lower Section");
				lower.setAlignmentX(Component.CENTER_ALIGNMENT);
				pane.add(lower);
			}
		}
	}
	public void activateRerollButton(PlayerRecord record, int[] dice){

	}
	
	public void activateAvailableCombinations (PlayerRecord record, int[] dice){
		
	}
	
	public void activateNewGameButton (PlayerRecord record, int[] dice){
		
	}
	
//	public boolean rerollButtonClicked(boolean[] reroll){
//		
//	}
//	
//	public int combinationChosen(){
//		
//	}
//	
//	public boolean newGameClicked(){
//		
//	}

	public static void main (String args[]){
		new YahtzeePlayerFrame();
	}
}
