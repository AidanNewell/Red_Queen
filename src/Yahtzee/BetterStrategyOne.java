package Yahtzee;

public class BetterStrategyOne extends YahtzeeComputerStrategy{

	BetterStrategyOne()
	{
		//76.4% acheivement
		super(new GreedyCombinationChooser(), new ModularDice());
		author = "Pelican Mann";
		playername = "Strategy One";
	}
}
