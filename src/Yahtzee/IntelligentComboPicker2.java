package Yahtzee;

public class IntelligentComboPicker2 implements CombinationChooser{

	int[] totalScores = new int[] {5,5,8,11,11,13,18,17,1,1,1,1,19};
	double[] averageScores = new double[] {5,5,8,11,11,13,18,17,1,1,1,1,19};
	long turns = 2;
	
	public int chooseCombination(int[] dice, PlayerRecord record) {
		AbstractYahtzeeCombination[] combinations = record.availableCombinations();
		double highestYield = -50;
		int indexOfHighestYield =-1;
		int x=0;
		for(AbstractYahtzeeCombination combo : combinations)
		{
			//Total difference instead of percentages
			if((double)combo.score(dice) - (double)averageScores[AbstractYahtzeeCombination.combinationIndex(combo.name())] >= highestYield)
			{
				highestYield = (double)combo.score(dice) - (double)averageScores[AbstractYahtzeeCombination.combinationIndex(combo.name())];
				indexOfHighestYield = x;
			}
			x++;
		}
		int rawIndex = AbstractYahtzeeCombination.combinationIndex(combinations[indexOfHighestYield].name());
		totalScores[rawIndex]+=combinations[indexOfHighestYield].score(dice);
		averageScores[rawIndex]= (double)totalScores[rawIndex]/(double)turns;
		if(combinations.length == 1)
		{
			turns++;
		}
		return indexOfHighestYield;
	}

}
