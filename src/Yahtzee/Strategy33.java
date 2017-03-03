package Yahtzee;

public class Strategy33 extends YahtzeeComputerStrategy {
	Strategy33(){
		super(new CombChooser3(), new DiceChooser3());
		author = "Hohenheim";
		playername = "3/3";
	}
}
