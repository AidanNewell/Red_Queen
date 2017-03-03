package Yahtzee;

import java.io.File;

public class MainScoreboard {

	public static void main(String [] args)
	{
		Scorekeeper window = new Scorekeeper();
//		1) Used to set the type of game (YahtzeeGamePlayer for Yahtzee, BattleshipGame for Battleship)
		GamePlayer game = new YahtzeeGamePlayer();
		
//		2) Set up the strategy lists


		Strategy[] stratList = {new YahtzeeTestStrategy(),new GreedyYahtzeeStrategy(), new BetterStrategyOne(), new BetterStrategyTwo(), new BetterStrategyThree(), new BetterStrategyFour(), new BetterStrategyFive(), new Strategy11(), new Strategy12(), new Strategy21(), new Strategy22(), new Strategy23()};

		
		window.setStrategies(stratList);
//		3) Set the menu to be disenabled (Default value = false);
		window.setMenu(true);
//		4) Set the testing option to desired value (Default value = false);
		window.setTesting(false);
//		5) Set the display type: Scorekeeper.(average, max, min, recent, total)
		window.displayOption(Scorekeeper.average);		
//		6) Set display for ascending order (true, false)
		window.ascending(true);
//		7) Set the time for the program to run (seconds, true/false)	
		window.stoppingTime(1200, true);
//		8) Move slowly for the first few minutes.
		window.slowTime(5, true);
//		9) Set the score that determines when to stop (score, true/false)
		window.stoppingScore(50, false);
//		10) Set the font size
		window.setFont(30);
//		11) Set the refresh interval (seconds)
//		window.setInterval(1);		
//		12) Start up the window
		window.playGames(game);
//      13) Write to output file (change name in quotes for different files)
		window.outputScores(new File("output.txt"));
	}
}
