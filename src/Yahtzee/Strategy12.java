package Yahtzee;

public class Strategy12 extends SuperLabAssistantStrategy{
	Strategy12()
	{
		super(new CombChooser1(),new DiceChooser2());
		author = "December";
		playername = "1/2";
	}
}