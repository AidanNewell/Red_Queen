package Yahtzee;

public class Strategy21 extends SuperLabAssistantStrategy{
	Strategy21()
	{
		super(new CombChooser2(),new DiceChooser1());
		author = "Jack Black";
		playername = "2/1";
	}
}