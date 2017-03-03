package Yahtzee;

public class CombChooser3 implements CombinationChooser {

	private AbstractYahtzeeCombination[] availableCombinations;
	private AbstractYahtzeeCombination[] allCombos;
	public int chooseCombination(int[] dice, PlayerRecord record)
	{
		allCombos = AbstractYahtzeeCombination.allCombinations();
		availableCombinations = record.availableCombinations();
		int maxScore=0;
		int secondScore = 0;
		int indexOfMaxScore = -1;
		int indexOfSecond = -1;
		int[] scores = new int[13]; //0.1,1.2,2.3,3.4,4.5,5.6,6.3x,7.4x,8.full,9.small,10.large,11.yahtzee,12.chance 
		int[] indexes = new int[13];
		for(int i = 0;i<scores.length;i++){
			
		}
		for(int x=0; x<availableCombinations.length;x++)
		{
			int score = availableCombinations[x].score(dice);
			if(score > maxScore)
			{
				secondScore = maxScore;
				indexOfSecond = indexOfMaxScore;
				maxScore = score;
				indexOfMaxScore = x;
			}
			String name = availableCombinations[x].name();
			if(name.equals("ChanceCombination")){
				scores[12] = score;
				indexes[12] = x;
			}
			else if(name.equals("ThreeOfAKindCombination")){
				scores[6] = score;
				indexes[6] = x;
			}
			else if(name.equals("FourOfAKindCombination")){
				scores[7] = score;
				indexes[7] = x;
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
			if(((scores[12] == maxScore && scores[12]<=22) || //only take chance if it's greater than 22
					(scores[6] == maxScore && scores[6]<7 ) || 
					(scores[7] == maxScore && scores[7]<10)) && indexOfSecond!=-1 && secondScore!=0) 
				return indexOfSecond;
			else
				return indexOfMaxScore;
		}

	}
}
