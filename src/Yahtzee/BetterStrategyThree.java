package Yahtzee;

public class BetterStrategyThree extends SuperLabAssistantStrategy{
	
	BetterStrategyThree()
	{
		//82.8% acheivement threshold
		super(new IntelligentComboPicker(), new ModularDice());
		playername = "MegaStrat";
		author = "Hodor";
	}

}
