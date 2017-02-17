package Yahtzee;

public class ModularComboChooser implements CombinationChooser{

	public int chooseCombination(int[] dice, PlayerRecord record) {
		//Sorta like greedy, but with percent deviation from the mean expected value
		//We'll use this array to state the average values it should aim for, and combinations with predefined values will have built-in bias
		int[] averageScores = new int[] {3,6,9,12,15,18,16,16,1,1,1,1,18}; //tweak these for different results!
		AbstractYahtzeeCombination[] combinations = record.availableCombinations();
		double highestYield = 0.0;
		int indexOfHighestYield =-1;
		for(AbstractYahtzeeCombination combo : combinations)
		{
			if(combo.score(dice) / )
		}
		return 0;
	}

}
