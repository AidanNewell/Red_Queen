package Yahtzee;

public class GreedyDiceChooser implements DiceChooser{
	
	public void reroll(int[] dice, int rollNumber, PlayerRecord record,
			boolean[] reroll) {
		int[] diceNumbers = new int[6];
		for(int x=0; x<dice.length;x++)
		{
			diceNumbers[dice[x]-1]++;
		}
		//Always rerolls the minority dice
		int highestIndex=0;
		for(int x=0; x<diceNumbers.length;x++)
		{
			//This way if you have 3 sixes and 3 ones it'll keep the sixes ;)
			if(diceNumbers[x] >= diceNumbers[highestIndex])
				highestIndex=x;
		}
		for(int x=0; x<dice.length;x++)
		{
			if(dice[x] != highestIndex+1)
				reroll[x]=true;
			else
				reroll[x] = false;
		}
	}

}
