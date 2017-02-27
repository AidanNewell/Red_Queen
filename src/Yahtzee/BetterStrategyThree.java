package Yahtzee;

public class BetterStrategyThree extends YahtzeeComputerStrategy{
	
	BetterStrategyThree()
	{
		//82.8% acheivement threshold
		super(new ModularPercentYieldComboChooser(), new ModularDice());
		playername = "MegaStrat";
		author = "Hodor";
	}

}
