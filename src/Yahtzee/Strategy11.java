package Yahtzee;

public class Strategy11 extends SuperLabAssistantStrategy{
	Strategy11()
	{
		super(new CombChooser1(),new DiceChooser1());
		author = "Ling";
		playername = "Yossarian";
	}
}
