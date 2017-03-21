package Yahtzee;

public class MixAndMatchStrategy4 extends YahtzeeComputerStrategy{
	
	
	MixAndMatchStrategy4()
	{
		super(new ExperimentalComboPicker(), new DiceChooser5());
		author = "Lemony Snicket";
		playername = "Vexingly Functional Dice";
	}

}
