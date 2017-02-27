package Yahtzee;
public class Strategy2 extends YahtzeeComputerStrategy{
	Strategy2(){
		super(new CombChooser2(), new DiceChooser2());
		author = "Why";
		playername = "SEriuslY tho,";
	}

}
