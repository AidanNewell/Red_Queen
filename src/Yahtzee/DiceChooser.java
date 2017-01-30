package Yahtzee;

interface DiceChooser {
	abstract public void reroll(int[] dice, int rollNumber, PlayerRecord record,
			boolean[] reroll);
}
