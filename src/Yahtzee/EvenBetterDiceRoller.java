package Yahtzee;

public class EvenBetterDiceRoller implements DiceChooser{

	public void reroll(int[] dice, int rollNumber, PlayerRecord record,
			boolean[] reroll) {
		AbstractYahtzeeCombination[] availableCombinations = record.availableCombinations();
		//In general, seems to roll to get the greatest number of similar dice (greed)
		boolean[] upperCombosRemaining = new boolean[6];
		for(AbstractYahtzeeCombination c : availableCombinations)
		{
			//Return immediately if we already have something good
			if((c.name().equals("YahtzeeCombination") && c.score(dice) == 50) || (c.name().equals("LargeStraightCombination") && c.score(dice) == 40) || (c.name().equals("SmallStraightCombination") && c.score(dice) == 30))
				return;
			if(c.upperSection())
				upperCombosRemaining[Integer.parseInt(c.description().substring(c.description().length()-1))-1] = true;
		}
		//Only roll for greed on upper section combos NOT taken, unless the current dice allow
		int[] diceNumbers = new int[6];
		int[] diceFrequency = new int[6];
		for(int x=0; x<dice.length;x++)
		{
			diceNumbers[dice[x]-1]++;
		}
		for(int x=0; x<diceFrequency.length;x++)
		{
			int maxDiceIndex = 0;
			for(int y=0; y<diceNumbers.length;y++)
			{
				if(diceNumbers[y] >= diceNumbers[maxDiceIndex] && !(diceNumbers[y] >= 10))
					maxDiceIndex = y;
			}
			diceFrequency[x] = maxDiceIndex+1;
			diceNumbers[maxDiceIndex]++;
			diceNumbers[maxDiceIndex] *= 20;
		}
		for(int x=0; x<diceNumbers.length;x++)
		{
			diceNumbers[x]/=20;
			diceNumbers[x]--;
		}
		for(int x=0; x<12; x++)
		{
			if(x==6)
				System.out.println("---------");
			if(x<6)
			{
				System.out.println(diceFrequency[x]);
			}
			else
			{
				System.out.println(diceNumbers[x-6]);
			}
		}
	}
	
	public static void main(String [] args)
	{
		EvenBetterDiceRoller r = new EvenBetterDiceRoller();
		r.reroll(new int[]{2,2,4,1,6},1,new PlayerRecord(),null);
	}
}
