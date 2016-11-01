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
		String input = playerName.toLowerCase();
		//TODO: Get rid of this lol
		if(input.equals("no") || input.equals("your name") || input.equals("lol") || input.equals("me"))
		{
			System.err.println("FATAL ERROR: USER THINKS THEY'RE FUNNY BUT THEY'RE NOT\nKILLING PROGRAM");
			System.exit(0);
		}
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
		while(!frame.rerollButtonClicked(reroll)){}
		reroll = (frame.getRerollArray());
	}

	public int chooseCombination(int[] dice, PlayerRecord record) {
		frame.activateAvailableCombinations(record,dice);
		int chosenCombination = frame.combinationChosen();
		while(!(chosenCombination>=0))
		{
			chosenCombination = frame.combinationChosen();
		}
		return chosenCombination;
	}

	public void finalResults(int[] dice, PlayerRecord record) {
		frame.activateNewGameButton(record,dice);
		while(!frame.newGameClicked()){}
		newGame();
	}
	
	public static void main(String [] args)
	{
		new HumanYahtzeePlayer();
	}
	
	private void newGame()
	{
		YahtzeeGame game = new YahtzeeGame();
		game.yahtzeeGame(this);
	}

}
