package Yahtzee;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;


public class YahtzeePlayerFrame extends JFrame {
	private JPanel contentPane;
	private JPanel dicePane;
	private JPanel comboPane;
	private JButton[] diceButtons;
	private JButton reroll;
	private int[] dice; //TEST?
	private ImageIcon[] icons;
	private ImageIcon[] shadedIcons;
	private JButton[] comboButtons;
	private YahtzeeGame game = new YahtzeeGame();
	private int numCombos;
	private JLabel upperScore;
	private JLabel lowerScore;
	
	YahtzeePlayerFrame(){
		numCombos = AbstractYahtzeeCombination.allCombinations().length;
		contentPane = new JPanel();
		dicePane = new JPanel();

		icons = new ImageIcon[6];
		shadedIcons = new ImageIcon[6];
		setDicePaneLayout(diceButtons,icons,shadedIcons);

		
		dice = new int[5];
		
		comboButtons = new JButton[numCombos];
		comboPane = new JPanel();
		setComboPaneLayout(comboPane,comboButtons);
		
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		contentPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		contentPane.add(Box.createHorizontalGlue());
		contentPane.add(Box.createRigidArea(new Dimension(10, 0)));
		contentPane.add(comboPane);
		contentPane.add(dicePane);
		//contentPane.setPreferredSize(new Dimension(500,500));

		setContentPane(contentPane);
		
		pack();
		setVisible(true);
		//setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	private void setDicePaneLayout(JButton[] buttons, final ImageIcon[] regular, final ImageIcon[] shaded){
		dicePane.setLayout(new BoxLayout(dicePane, BoxLayout.LINE_AXIS));
		diceButtons = new JButton[5];
		for(int i = 0; i<5; i++){
			diceButtons[i] = new JButton();
			diceButtons[i].setPreferredSize(new Dimension(100,100));
			diceButtons[i].addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) { 
					
				} 
			});
			
			dicePane.add(diceButtons[i]);
		}
		
		Image img = null;
		Image img2 = null;
		for(int i = 1; i<7; i++){
			try {
				switch (i){
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
			} catch (IOException a) {
				a.printStackTrace();
			}
			Image resizedShade = img.getScaledInstance(95,95,Image.SCALE_SMOOTH);
			Image resizedReg = img2.getScaledInstance(95,95,Image.SCALE_SMOOTH);
			final ImageIcon Shade = new ImageIcon(resizedShade);
			final ImageIcon Reg = new ImageIcon(resizedReg);
			regular[i-1] = Reg;
			shaded[i-1] = Shade;
		}
		
		reroll = new JButton("Reroll");
		reroll.setPreferredSize(new Dimension(100,100));
		reroll.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				for(int i = 0; i<5; i++){
					dice[i] = (int)(Math.random()*6);
					diceButtons[i].setIcon(shaded[dice[i]]);
				}
			} 
		});
		dicePane.add(reroll);

	}
	private void setComboPaneLayout(JPanel pane,JButton[] buttons){
		JPanel upperPane = new JPanel();
		JPanel lowerPane = new JPanel();
		upperPane.setLayout(new BoxLayout(upperPane, BoxLayout.PAGE_AXIS));
		upperPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		lowerPane.setLayout(new BoxLayout(lowerPane, BoxLayout.PAGE_AXIS));
		lowerPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		AbstractYahtzeeCombination [] combos = AbstractYahtzeeCombination.allCombinations();
		JLabel upper = new JLabel("Upper Section");
		upper.setAlignmentX(Component.CENTER_ALIGNMENT);
		upperPane.add(upper);
		for(int i = 0; i < 6; i++){
			String comboString = combos[i].name();
			JButton comboButton = new JButton(comboString);
			buttons[i] = comboButton;
			comboButton.setAlignmentX(Component.CENTER_ALIGNMENT);
			upperPane.add(comboButton);	
		}
		upperScore = new JLabel("Upper Score: 0");
		upperScore.setAlignmentX(Component.CENTER_ALIGNMENT);
		upperPane.add(upperScore);	
		JLabel lower = new JLabel("Lower Section");
		lower.setAlignmentX(Component.CENTER_ALIGNMENT);
		lowerPane.add(lower);
		for(int i = 6; i < combos.length; i++){
			String comboString = combos[i].name();
			JButton comboButton = new JButton(comboString);
			buttons[i] = comboButton;
			comboButton.setAlignmentX(Component.CENTER_ALIGNMENT);
			lowerPane.add(comboButton);	
		}
		lowerScore = new JLabel("Lower Score: 0");
		lowerScore.setAlignmentX(Component.CENTER_ALIGNMENT);
		lowerPane.add(lowerScore);
		pane.setLayout(new BoxLayout(pane,BoxLayout.LINE_AXIS));
		upperPane.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
		pane.add(upperPane);
		pane.add(lowerPane);
		
	}
	public void activateRerollButton(PlayerRecord record, int[] dice){
		for(int i = 0; i<dice.length;i++){
			diceButtons[i].setIcon(shadedIcons[dice[i]]);
		}

		AbstractYahtzeeCombination[] combos = record.availableCombinations();
		
		ArrayList <String> comboNames = new ArrayList<String>();
		for(int i = 0; i<combos.length; i++){
			comboNames.add(combos[i].name());
		}
		for(int i = 0; i<comboButtons.length; i++){
			comboButtons[i].setEnabled(false);
		}
		for(int i =0;i<comboButtons.length;i++)
		{
			if(comboNames.contains(comboButtons[i].getText()));
				setEnabled(true);
		}
		reroll.setEnabled(true);
		upperScore.setText("Score: " + record.upperSectionScore() + " Difference: " + record.upDown());
		lowerScore.setText("Score: " + record.lowerSectionScore() + " Total Score: " + record.totalScore());
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
