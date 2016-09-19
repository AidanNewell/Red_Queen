package Yahtzee;

public class FullHouseCombination extends AbstractYahtzeeCombination{

	
	public int score(int[] dice) {
		if(dice[0] == dice[1] && dice[2]==dice[3] && dice[3]==dice[4] && (dice[1] != dice[2]))
		{
			return 35;
		}else if(dice[0]==dice[1] && dice[1]==dice[2] && dice[3]==dice[4] && (dice[2] != dice[3])){
			return 35;
		}else
			return 0;
	}

	
	public String name() {
		return "FullHouseCombination";
	}

	
	public String description() {
		return "Gives 35 points if three dice are the same value, and the remaining two dice are the same value, but different than that of the three";
	}

	
	public boolean upperSection() {
		return false;
	}

}
