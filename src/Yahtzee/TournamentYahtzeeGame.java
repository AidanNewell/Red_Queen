package Yahtzee;

public class TournamentYahtzeeGame
{

	public double playGame(Strategy player)
	{
		double score=0;
		boolean notBroken = true;
		try{
			score = YahtzeePlayerEvaluator.evaluatePlayer((AbstractComputerYahtzeePlayer)player,1);
		}catch(Exception e)
		{
			System.err.println("The Strategy has encountered a very bad problem. Here is a handy stack trace so you can fix it:\n\n");
			e.printStackTrace();
			notBroken = false;
		}
		if(notBroken)
		{
			return score;
		}
		return -1;
	}

	public static void main(String [] args)
	{
		TournamentYahtzeeGame tester = new TournamentYahtzeeGame();
		System.out.println(tester.playGame(new YahtzeeTestStrategy()));
	}
}
