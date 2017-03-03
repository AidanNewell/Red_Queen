package Yahtzee;

public class BetterStrategyFive extends YahtzeeComputerStrategy{

	BetterStrategyFive()
	{
		super(new ExperimentalComboPicker(), new ModularDice());
		playername = "H";
		author = "M";
	}
}
