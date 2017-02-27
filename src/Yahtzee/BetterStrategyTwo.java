package Yahtzee;

public class BetterStrategyTwo extends YahtzeeComputerStrategy{
	
	BetterStrategyTwo()
	{
		super(new ModularPercentYieldComboChooser(), new GreedyDiceChooser());
		author = "Glissinda the Good Witch";
		playername = "badaboom";
	}

}
