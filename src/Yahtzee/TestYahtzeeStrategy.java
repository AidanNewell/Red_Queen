package Yahtzee;

public class TestYahtzeeStrategy extends YahtzeeComputerStrategy{
	TestYahtzeeStrategy()
	{
		super(new TestCombinationChooser(),new TestDiceChooser());
		author = "Allison";
		playername = "h8s writing strats >:(";
	}
}
