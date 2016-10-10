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
	}
	
	public String playerName()
	{
		return playerName;
	}

	
	public void reroll(int[] dice, int rollNumber, PlayerRecord record,
			boolean[] reroll) {
		frame.activateRerollButton(record, dice);
		while(!frame.rerollButtonClicked(reroll)){}
		for(int x=0; x<dice.length;x++)
		{
			if(reroll[x])
				dice[x] = (int)(Math.random() * 6);
		}
	}

	@Override
	public int chooseCombination(int[] dice, PlayerRecord record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void finalResults(int[] dice, PlayerRecord record) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String [] args)
	{
		new HumanYahtzeePlayer();
	}

}
