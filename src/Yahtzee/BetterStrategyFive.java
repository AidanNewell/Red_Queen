package Yahtzee;

public class BetterStrategyFive extends YahtzeeComputerStrategy{

	BetterStrategyFive()
	{
		//84.4% acheivement threshold
		super(new ExperimentalComboPicker(), new ModularDice());
		playername = "Witch cat";
		author = "Hardcastle McCormick";
	}
}
