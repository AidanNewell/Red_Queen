package Yahtzee;

public class MixAndMatchStrategy1 extends SuperLabAssistantStrategy{

	MixAndMatchStrategy1()
	{
		super(new ExperimentalComboPicker(), new DiceChooser3());
		playername = "Dumbledore the half-dead";
		author = "J.K. R-Dogs";
	}
}
