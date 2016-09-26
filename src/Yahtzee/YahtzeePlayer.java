package Yahtzee;

public interface YahtzeePlayer {

	
	public String playerName();
	
	public void reroll(int [] dice, int rollNumber, PlayerRecord record, boolean[] reroll);
	
	public int chooseCombination(int[] dice, PlayerRecord record);
	
	public void finalResults(int [] dice, PlayerRecord record);
}
