package Yahtzee;

public class BetterStrategyTwo extends SuperLabAssistantStrategy{
	
	BetterStrategyTwo()
	{
		super(new IntelligentComboPicker(), new GreedyDiceChooser());
		author = "Glissinda the Good Witch";
		playername = "badaboom";
	}

}
