package Yahtzee;

public class Strategy11 extends YahtzeeComputerStrategy{
	Strategy11()
	{
		super(new CombChooser1(),new DiceChooser1());
		author = "Lin";
		playername = "1/1";
	}
}
