package Yahtzee;
public class Strategy22 extends YahtzeeComputerStrategy{
	Strategy22(){
		super(new CombChooser2(), new DiceChooser2());
		author = "Taylor Swift";
		playername = "2/2";
	}

}
