package Yahtzee;

public class YahtzeePlayerEvaluator {

	
	public static double evaluatePlayer(YahtzeePlayer player, int games)
	{
		double totalScore=0;
		YahtzeeGame game = new YahtzeeGame();
		for(int x=0; x<games;x++)
		{
			totalScore = game.yahtzeeGame(player);
		}
		return (totalScore / games);
	}
}
