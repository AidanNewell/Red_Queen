package Yahtzee;

public class Strategy24 extends YahtzeeComputerStrategy {
	Strategy24(){
		super(new CombChooser2(), new DiceChooser4());
		author = "Hohenheim";
		playername = "2/4";
	}
}
