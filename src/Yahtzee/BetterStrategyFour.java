package Yahtzee;

public class BetterStrategyFour extends SuperLabAssistantStrategy{

	
	BetterStrategyFour()
	{
		super(new IntelligentComboPicker2(), new ModularDice());
		playername = "Eyyyy";
		author = "Ringo";
	}
}
