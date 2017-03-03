package Yahtzee;

public class BetterStrategyTwo extends YahtzeeComputerStrategy{
	
	BetterStrategyTwo()
	{
		super(new IntelligentComboPicker(), new GreedyDiceChooser());
		author = "Glissinda the Good Witch";
		playername = "badaboom";
	}

}
