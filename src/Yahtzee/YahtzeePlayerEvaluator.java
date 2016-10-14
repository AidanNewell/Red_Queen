package Yahtzee;

public class YahtzeePlayerEvaluator {

	
	public static double evaluatePlayer(YahtzeePlayer player, int games)
	{
		double totalScore=0;
		YahtzeeGame game = new YahtzeeGame();
		int quarter = games / 4, half = games /2, threeQuarter = (int)(games * 0.75);
		for(int x=0; x<games;x++)
		{
			if(x==quarter)
				System.out.println("25%");
			else if(x == half)
				System.out.println("50%");
			else if(x==threeQuarter)
				System.out.println("75%");
			totalScore += game.yahtzeeGame(player);
		}
		return (totalScore / games);
	}
}
