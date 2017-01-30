package Yahtzee;

public class YahtzeeTestStrategy extends YahtzeeComputerStrategy{

	YahtzeeTestStrategy()
	{
		super(new GreedyCombinationChooser(), new AllButYahtzeeDiceChooser());
		author = "Yahrtzee the pirate";
		playername = "Captain Squiggly Squid";
	}

}
