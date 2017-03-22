package Yahtzee;

public class GreedyYahtzeeStrategy extends SuperLabAssistantStrategy{
	
	GreedyYahtzeeStrategy()
	{
		super(new GreedyCombinationChooser(),new GreedyDiceChooser());
		author = "Ebenezer Scrooge";
		playername = "greed is g00d";
	}
}
