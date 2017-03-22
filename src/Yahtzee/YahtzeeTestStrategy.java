package Yahtzee;

public class YahtzeeTestStrategy extends SuperLabAssistantStrategy{

	YahtzeeTestStrategy()
	{
		super(new GreedyCombinationChooser(), new AllButYahtzeeDiceChooser());
		author = "Yahrtzee the pirate";
		playername = "Captain Squiggly Squid";
	}

}
