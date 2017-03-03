package Yahtzee;

import java.util.ArrayList;
import java.util.Arrays;

public class ExperimentalComboPicker implements CombinationChooser{

	int[] totalScores = new int[] {5,5,8,11,11,13,18,17,1,1,1,1,19};
	double[] averageScores = new double[] {5,5,8,11,11,13,18,17,1,1,1,1,19};
	ArrayList<String> nullList;
	long turns = 2;
	
	//Tells the computer to take 0s occassionally
	public int chooseCombination(int[] dice, PlayerRecord record) {
		if(AbstractComputerYahtzeePlayer.reinitialize(record))
		{
			nullList = new ArrayList<String>(Arrays.asList("YahtzeeCombination","LargeStraightCombination","FourOfAKindCombination","AcesCombination","TwosCombination","SmallStraightCombination","ThreeOfAKindCombination","FullHouseCombination","ThreesCombination","FoursCombination","FivesCombination","SixesCombination","ChanceCombination"));
		}
		AbstractYahtzeeCombination[] combinations = record.availableCombinations();
		double highestYield = 0.2;
		int indexOfHighestYield =-1;
		int x=0;
		for(AbstractYahtzeeCombination combo : combinations)
		{
			if((double)combo.score(dice) / (double)averageScores[AbstractYahtzeeCombination.combinationIndex(combo.name())] >= highestYield)
			{
				highestYield = (double)combo.score(dice) / (double)averageScores[AbstractYahtzeeCombination.combinationIndex(combo.name())];
				indexOfHighestYield = x;
			}
			x++;
		}
		if(indexOfHighestYield == -1)
		{
			return record.choiceNumber(nullList.remove(0));
		}
		int rawIndex = AbstractYahtzeeCombination.combinationIndex(combinations[indexOfHighestYield].name());
		totalScores[rawIndex]+=combinations[indexOfHighestYield].score(dice);
		averageScores[rawIndex]= (double)totalScores[rawIndex]/(double)turns;
		if(combinations.length == 1)
		{
			turns++;
		}
		nullList.remove(combinations[indexOfHighestYield].name());
		return indexOfHighestYield;
	}

}
