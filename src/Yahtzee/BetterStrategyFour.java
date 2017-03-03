package Yahtzee;

public class BetterStrategyFour extends YahtzeeComputerStrategy{

	
	BetterStrategyFour()
	{
		super(new IntelligentComboPicker2(), new ModularDice());
		playername = "Eyyyy";
		author = "Ringo";
	}
}
