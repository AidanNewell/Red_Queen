package Yahtzee;

public class ModularComboChooser implements CombinationChooser{

	public int chooseCombination(int[] dice, PlayerRecord record) {
		//Sorta like greedy, but with percent deviation from the mean expected value
		//We'll use this array to state the average values it should aim for, and combinations with predefined values will have built-in bias
		AbstractYahtzeeCombination[] combinations = record.availableCombinations();
		return 0;
	}

}
