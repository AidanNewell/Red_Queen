package Yahtzee;

public class CombChooser1 implements CombinationChooser{
	
	public int chooseCombination(int[] dice, PlayerRecord record) {
		AbstractYahtzeeCombination[] available = record.availableCombinations();
		int CurrentScore = 0;
		int maxScore = 0;
		int maxIndex = 0;
		int specialIndex = -1; 
		for(int i=0;i<available.length;i++){
			CurrentScore = available[i].score(dice);
			if(CurrentScore> maxScore){
				maxScore = available[i].score(dice);
				maxIndex = i;
			}
			if((available[i].name().equals("FullHouseCombination") || available[i].name().equals("SmallStraightCombination") 
				|| available[i].name().equals("LargeStraightCombination") || available[i].name().equals("YahtzeeCombination")) 
				&& CurrentScore > 0){
				specialIndex = i;
			}
		}
		if(maxScore == 0)
		{
			if(available[available.length - 1].upperSection())
			{
				return 0;
			}
			else
			{
				return available.length - 1;
			}
		}
		else
		{
			if(specialIndex != -1)
				return specialIndex;
			return maxIndex;
		}

	}
}
