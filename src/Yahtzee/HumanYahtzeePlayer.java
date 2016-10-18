package Yahtzee;

import java.util.Scanner;

public class HumanYahtzeePlayer implements YahtzeePlayer{

	
	private String playerName;
	private YahtzeePlayerFrame frame;
	
	HumanYahtzeePlayer()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Yahtzee!\n\nPlease enter your name:\n");
		playerName = scanner.next();
		scanner.close();
		frame = new YahtzeePlayerFrame();
		YahtzeeGame game = new YahtzeeGame();
		game.yahtzeeGame(this);
	}
	
	public String playerName()
	{
		return playerName;
	}

	
	public void reroll(int[] dice, int rollNumber, PlayerRecord record,
			boolean[] reroll) {
		frame.activateRerollButton(record, dice);
		while(!frame.rerollButtonClicked(reroll)){
			reroll = frame.getRerollArray();
		}
	}

	public int chooseCombination(int[] dice, PlayerRecord record) {
		frame.activateAvailableCombinations(record,dice);
		while(frame.combinationChosen()>=0)
			return frame.combinationChosen();
		return -1; 
	}

	public void finalResults(int[] dice, PlayerRecord record) {
		frame.activateNewGameButton(record,dice);
		while(!frame.newGameClicked());
	}
	
	public static void main(String [] args)
	{
		new HumanYahtzeePlayer();
	}

}
