package Yahtzee;

public class CombChooser2 implements CombinationChooser {

	public int chooseCombination(int[] dice, PlayerRecord record) {
		AbstractYahtzeeCombination[] available = record.availableCombinations();
		for(int i=0;i<available.length;i++){
			
		}
	}

}
