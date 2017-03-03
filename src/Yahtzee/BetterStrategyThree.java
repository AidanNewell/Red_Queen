package Yahtzee;

public class BetterStrategyThree extends YahtzeeComputerStrategy{
	
	BetterStrategyThree()
	{
		//82.8% acheivement threshold
		super(new IntelligentComboPicker(), new ModularDice());
		playername = "MegaStrat";
		author = "Hodor";
	}

}
