package Yahtzee;

public class GreedyCombinationChooser implements CombinationChooser{

	private AbstractYahtzeeCombination[] availableCombinations;
	
	public int chooseCombination(int[] dice, PlayerRecord record)
	{
		availableCombinations = record.availableCombinations();
		int maxScore=0;
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
		if(maxScore == 0)
		{
			if(availableCombinations[availableCombinations.length - 1].upperSection())
			{
				return 0;
			}
			else
			{
				return availableCombinations.length - 1;
			}
		}
		else
		{
			return indexOfMaxScore;
		}
	}
}
