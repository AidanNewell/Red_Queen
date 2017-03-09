package Yahtzee;

public class MixAndMatchStrategy3 extends YahtzeeComputerStrategy{
	
	MixAndMatchStrategy3()
	{
		super(new ExperimentalComboPicker(), new DiceChooser4());
		playername = "Bad Magic";
		author="Oogity-Boogity Hat";
	}

}
