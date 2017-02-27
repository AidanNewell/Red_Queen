package Yahtzee;

public class DifferentialComboChooser implements CombinationChooser{

	//These are the number of possible combinations meeting these requirements
	//ABCDE = 6
	private final int ABCDE = 6;
	//ABBCD = 60
	private final int ABBCD = 60;
	//ABBCC = 60
	private final int ABBCC = 60;
	//ABBBC = 60
	private final int ABBBC = 60;
	//AABBB = 30
	private final int AABBB = 30;
	//AAAAB = 30
	private final int AAAAB = 30;
	//AAAAA = 6
	private final int AAAAA = 6;
	
	
	private final int TOTAL_NUM = ABCDE + ABBCD + ABBCC + ABBBC + AABBB + AAAAB + AAAAA;
	
	public int chooseCombination(int[] dice, PlayerRecord record) {
		//First find out what pattern it is
		
		return 0;
	}

}
