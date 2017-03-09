package Yahtzee;

public class MixAndMatchStrategy2 extends YahtzeeComputerStrategy{
	
	MixAndMatchStrategy2()
	{
		super(new CombChooser2(), new ModularDice());
		playername = "King of Denmark";
		author = "Boss Tweed";
	}

}
