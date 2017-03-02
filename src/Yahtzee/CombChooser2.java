package Yahtzee;

public class CombChooser2 implements CombinationChooser {
	private AbstractYahtzeeCombination[] availableCombinations;
	public int chooseCombination(int[] dice, PlayerRecord record)
	{
		availableCombinations = record.availableCombinations();
		int maxScore=0;
		int indexOfMaxScore=-1;
		int indexOfSecond = -1;
		int chanceScore = 0;
		for(int x=0; x<availableCombinations.length;x++)
		{
			int score = availableCombinations[x].score(dice);
			if(score > maxScore)
			{
				indexOfSecond = indexOfMaxScore;
				maxScore = score;
				indexOfMaxScore = x;
			}
			String name = availableCombinations[x].name();
			if(availableCombinations[x].name().equals("ChanceCombination")){
				chanceScore = score;
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
			if((chanceScore == maxScore && chanceScore<=22) && indexOfSecond!=-1) //only take chance if it's greater than 22
				return indexOfSecond;
			else
				return indexOfMaxScore;
		}
	}

}
