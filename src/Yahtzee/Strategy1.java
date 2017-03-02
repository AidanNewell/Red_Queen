package Yahtzee;

public class Strategy1 extends YahtzeeComputerStrategy{
	Strategy1()
	{
		super(new CombChooser1(),new DiceChooser1());
		author = "Allison";
		playername = "h8s writing strats >:(";
	}
}
