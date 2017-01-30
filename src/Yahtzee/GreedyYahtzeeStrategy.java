package Yahtzee;

public class GreedyYahtzeeStrategy extends YahtzeeComputerStrategy{
	
	GreedyYahtzeeStrategy()
	{
		super(new GreedyCombinationChooser(),new MostCommonDiceChooser());
		author = "Ebenezer Scrooge";
		playername = "greed is g00d";
	}
}
