package Yahtzee;

public class Strategy23 extends YahtzeeComputerStrategy {
	Strategy23(){
		super(new CombChooser2(), new DiceChooser3());
		author = "Alphonse";
		playername = "2/3";
	}
}
