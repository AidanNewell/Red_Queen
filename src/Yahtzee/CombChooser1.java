package Yahtzee;

public class CombChooser1 implements CombinationChooser{
	private AbstractYahtzeeCombination[] availableCombinations;
	public int chooseCombination(int[] dice, PlayerRecord record)
	{
		availableCombinations = record.availableCombinations();
		int maxScore=0;
		int indexOfMaxScore=-1;
		int indexOfSecond = -1;
		int[] indexOfScores = new int[13];
		int[] scores = new int[13]; //0.1,1.2,2.3,3.4,4.5,5.6,6.3x,7.4x,8.full,9.small,10.large,11.yahtzee,12.chance
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
			switch(name){
				case "ChanceCombination": 
					scores[12] = score;
					indexOfScores[12] = x;
					break;
				case "AcesCombination":
					scores[0] = score;
					indexOfScores[0] = x;
					break;
				case "FullHouseCombination": 
					scores[8] = score;
					indexOfScores[8] = x;
					break;
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
			if(scores[8] == 25)
				return indexOfScores[8];
			if((scores[12] == maxScore && scores[12]<=22) && indexOfSecond!=-1)
				return indexOfSecond;
			else
				return indexOfMaxScore;
		}
	}
}
