package Yahtzee;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;


public class YahtzeePlayerFrame extends JFrame {
	private JPanel contentPane;
	private JPanel dicePane;
	private JPanel comboPane;
	private YahtzeeDiceButton[] diceButtons;
	private JButton reroll;
	private JButton newGame;
	private YahtzeeComboButton[] comboButtons;
	private AbstractYahtzeeCombination[] combos;
	private int numCombos;
	private JLabel upperScore;
	private JLabel lowerScore;
	private boolean rerollClicked;
	private boolean comboClicked;
	private String clickedComboString;
	private int comboInt;
	private boolean newGameClicked;
	
	YahtzeePlayerFrame(){
		numCombos = AbstractYahtzeeCombination.allCombinations().length;
		contentPane = new JPanel();
		dicePane = new JPanel();
		
		setDicePaneLayout(diceButtons);

		comboClicked = false;
		clickedComboString = "";
		comboButtons = new YahtzeeComboButton[numCombos];
		comboPane = new JPanel();
		setComboPaneLayout(comboPane,comboButtons);
		
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		contentPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		contentPane.add(comboPane);
		contentPane.add(dicePane);
		contentPane.add(Box.createRigidArea(new Dimension(10, 10)));
		
		rerollClicked = false;
		reroll = new JButton("Reroll");
		reroll.setAlignmentX(Component.CENTER_ALIGNMENT);
		reroll.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				rerollClicked = true;
			} 
		});
		contentPane.add(reroll);
		

		contentPane.add(Box.createRigidArea(new Dimension(10, 10)));
		newGame = new JButton("New Game");
		newGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		newGame.setEnabled(false);
		newGame.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				newGameClicked = true;
				
			} 
		});
		contentPane.add(newGame);

		setContentPane(contentPane);
		
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent we)
		    { 
		    	JFrame frame = new JFrame();
		    	JOptionPane option = new JOptionPane();
		        int x = option.showConfirmDialog(frame,"Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
		        if(x == JOptionPane.YES_OPTION)
		        {
		        	YahtzeePlayerFrame.close();
		        }
		    }
		});
		
	}
	private void setDicePaneLayout(JButton[] buttons){
		dicePane.setLayout(new BoxLayout(dicePane, BoxLayout.LINE_AXIS));
		diceButtons = new YahtzeeDiceButton[5];
		for(int i = 0; i<5; i++){
			diceButtons[i] = new YahtzeeDiceButton();
			diceButtons[i].setPreferredSize(new Dimension(100,100));
			dicePane.add(diceButtons[i]);
		}
	}
	private void setComboPaneLayout(JPanel pane,YahtzeeComboButton[] buttons){
		JPanel upperPane = new JPanel();
		upperPane.setLayout(new BoxLayout(upperPane, BoxLayout.PAGE_AXIS));
		upperPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		AbstractYahtzeeCombination [] combos = AbstractYahtzeeCombination.allCombinations();
		JLabel upper = new JLabel("Upper Section");
		upper.setAlignmentX(Component.CENTER_ALIGNMENT);
		upperPane.add(upper);
		for(int i = 0; i < 6; i++){
			String comboString = combos[i].name();
			YahtzeeComboButton comboButton = new YahtzeeComboButton(comboString);
			buttons[i] = comboButton;
			comboButton.setAlignmentX(Component.CENTER_ALIGNMENT);
			upperPane.add(comboButton);	
		}
		upperScore = new JLabel("Upper Score: 0");
		upperScore.setAlignmentX(Component.CENTER_ALIGNMENT);
		upperPane.add(upperScore);	
		
		JPanel lowerPane = new JPanel();
		lowerPane.setLayout(new BoxLayout(lowerPane, BoxLayout.PAGE_AXIS));
		lowerPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		JLabel lower = new JLabel("Lower Section");
		lower.setAlignmentX(Component.CENTER_ALIGNMENT);
		lowerPane.add(lower);
		for(int i = 6; i < combos.length; i++){
			String comboString = combos[i].name();
			YahtzeeComboButton comboButton = new YahtzeeComboButton(comboString);
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
		pane.add(Box.createRigidArea(new Dimension(40, 0)));
		pane.add(lowerPane);
		
	}
	private void repaint(PlayerRecord record, int[]dice){
		for(int i = 0; i<dice.length;i++){
			diceButtons[i].set(dice[i],false);
		}

		combos = record.availableCombinations();
		upperScore.setText("Score: " + record.upperSectionScore() + " Difference: " + record.upDown());
		lowerScore.setText("Score: " + record.lowerSectionScore() + " Total Score: " + record.totalScore());
	}
	
	public void activateRerollButton(PlayerRecord record, int[] dice){
		for(int x=0; x<comboButtons.length;x++)
		{
			comboButtons[x].disable();
		}
		repaint(record,dice);
		reroll.setEnabled(true);
		rerollClicked = false;
	}
	
	public void activateAvailableCombinations (PlayerRecord record, int[] dice){
		for(int x=0; x<comboButtons.length;x++)
		{
			if(!(comboButtons[x].isUsed()))
				comboButtons[x].enable();
		}
		repaint(record,dice);
		comboClicked = false;
	}
	
	public void activateNewGameButton (PlayerRecord record, int[] dice){
		repaint(record,dice);
		newGame.setEnabled(true);
		newGameClicked = false;
	}
	
	public boolean rerollButtonClicked(boolean[] reroll){
		if(rerollClicked){
			for(int i=0;i<reroll.length;i++){
				reroll[i] = diceButtons[i].isSelected();
			}
			return true;
		}
		else
			return false;
	}
	
	public int combinationChosen(){
		int index = -1; 
		YahtzeeComboButton selectedButton = new YahtzeeComboButton("");
		String clickedCombo;
		for(int x=0; x< comboButtons.length;x++){
			YahtzeeComboButton b = comboButtons[x];
			if(b.isSelected())
			{
				comboClicked = true;
				selectedButton = b;
				b.nullify();
				break;
			}
		}
		if(comboClicked){
			 clickedCombo = selectedButton.getName();
			 for(int i = 0; i<combos.length; i++){
				 if(clickedCombo.equals(combos[i].name()))
				 {
					 index = i;
					break;
				 }
			 }
		}
		return index;
	}
	public boolean[] getRerollArray(){
		boolean[] reroll = new boolean[5];
		for(int i=0; i<diceButtons.length; i++){
			reroll[i]=diceButtons[i].isSelected();
		}
		return reroll;
	}
	public boolean newGameClicked(){
		return newGameClicked;
	}
    public static void close()
    {
    	System.exit(0);
    }
    

}
