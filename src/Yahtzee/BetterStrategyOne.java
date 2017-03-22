package Yahtzee;

public class BetterStrategyOne extends SuperLabAssistantStrategy{

	BetterStrategyOne()
	{
		//76.4% acheivement threshold
		super(new GreedyCombinationChooser(), new ModularDice());
		author = "Pelican Mann";
		playername = "Strategy One";
	}
}
