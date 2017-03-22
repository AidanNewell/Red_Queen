package Yahtzee;

public class MixAndMatchStrategy4 extends SuperLabAssistantStrategy{
	
	
	MixAndMatchStrategy4()
	{
		super(new ExperimentalComboPicker(), new DiceChooser5());
		author = "Lemony Snicket";
		playername = "Vexingly Functional Dice";
	}

}
