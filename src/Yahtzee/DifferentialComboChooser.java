package Yahtzee;

public class DifferentialComboChooser implements CombinationChooser{

	//These are the number of possible combinations meeting these requirements
	//ABCDE = 6
	//ABBCD = 60
	//ABBCC = 60
	//ABBBC = 60
	//AABBB = 30
	//AAAAB = 30
	//AAAAA = 6
	private final int TOTAL_NUM = 252;
	
	public int chooseCombination(int[] dice, PlayerRecord record) {
		return 0;
	}

}
