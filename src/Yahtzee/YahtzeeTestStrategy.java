package Yahtzee;

public class YahtzeeTestStrategy extends AbstractComputerYahtzeePlayer{

	private AbstractYahtzeeCombination[] availableCombinations;
	
	public String playerName()
	{
		return "CaptianSquigglySquid";
	}

	public void reroll(int[] dice, int rollNumber, PlayerRecord record,
			boolean[] reroll){
		for(int x=0; x<dice.length;x++)
		{
			System.out.print(dice[x]);
		}
		System.out.println();
		try{
			Thread.sleep(1000);
		}catch(Exception e){}
		for(int x=0; x<reroll.length;x++)
		{
			reroll[x] = true;
		}
	}

	public int chooseCombination(int[] dice, PlayerRecord record) {
		for(int x=0; x<dice.length;x++)
		{
			System.out.print(dice[x]);
		}
		System.out.println();
		try{
			Thread.sleep(1000);
		}catch(Exception e){}
		availableCombinations = record.availableCombinations();
		int maxScore=-1;
		int indexOfMaxScore=-1;
		for(int x=0; x<availableCombinations.length;x++)
		{
			int score = availableCombinations[x].score(dice);
			if(score > maxScore)
			{
				maxScore = score;
				indexOfMaxScore = x;
			}
		}
		System.out.println(maxScore);
		if(maxScore == 0)
		{
			if(availableCombinations[availableCombinations.length - 1].upperSection())
			{
				System.out.println(availableCombinations[0].name());
				try{
					Thread.sleep(1000);
				}catch(Exception e){}
				return 0;
			}
			else
			{
				System.out.println(availableCombinations[availableCombinations.length-1].name());
				try{
					Thread.sleep(1000);
				}catch(Exception e){}
				return availableCombinations.length - 1;
			}
		}
		else
		{
			System.out.println(availableCombinations[indexOfMaxScore].name());
			try{
				Thread.sleep(1000);
			}catch(Exception e){}
			return indexOfMaxScore;
		}
	}

	
	public void finalResults(int[] dice, PlayerRecord record) {
		System.out.println("FINAL SCORE: " + record.totalScore());
	}

	public String author() {
		return "Yahrtzee the pirate";
	}
	
	

}
