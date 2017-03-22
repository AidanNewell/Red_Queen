package Yahtzee;

public interface YahtzeePlayer {
	
	public abstract void reroll(int [] dice, int rollNumber, PlayerRecord record, boolean[] reroll);
	
	public abstract int chooseCombination(int[] dice, PlayerRecord record);
	
	public abstract void finalResults(int [] dice, PlayerRecord record);
}
