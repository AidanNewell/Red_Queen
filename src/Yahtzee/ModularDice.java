package Yahtzee;

public class ModularDice implements DiceChooser{


	public void reroll(int[] dice, int rollNumber, PlayerRecord record,
			boolean[] reroll) {
		AbstractYahtzeeCombination[] availableCombinations = record.availableCombinations();
		boolean greedyRoll = false;
		boolean[] upperEligibility = new boolean[6]; //Whether or not the upper section scoring is still available
		for( AbstractYahtzeeCombination combo : availableCombinations )
		{
			if(combo.upperSection())
				upperEligibility[Integer.parseInt(combo.description().substring(combo.description().length()-1))-1] = true;
			//If we still need these, aim for them
			if(combo.name() == "YahtzeeCombination" || combo.name() == "FourOfAKindCombination" || combo.name() == "ThreeOfAKindCombination")
				greedyRoll = true;
			//If we have a large or small straight, take it
			if((combo.name() == "LargeStraightCombination" && combo.score(dice) == 40) || (combo.name() == "SmallStraightCombination" && combo.score(dice) == 30))
			{
				//The array is already false, so we can just exit the method here
				return;
			}
			if(combo.name() == "FullHouseCombination" && combo.score(dice) == 25 && !greedyRoll)
				return;
		}
		int[] diceNumbers = new int[6];
		for(int x=0; x<dice.length;x++)
		{
			diceNumbers[dice[x]-1]++;
		}
		if(greedyRoll)
		{
			int highestIndex=0;
			for(int x=0; x<diceNumbers.length;x++)
			{
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
			return;
		}
		int highestScore =0;
		int numberToGoFor =0;
		for(int x=0; x<upperEligibility.length;x++)
		{
			if(upperEligibility[x] && diceNumbers[x] * (x+1) >= highestScore)
			{
				highestScore = diceNumbers[x] * (x+1);
				numberToGoFor = x+1;
			}
		}
		for(int x=0; x<reroll.length;x++)
		{
			if(dice[x] != numberToGoFor)
				reroll[x] = true;
		}
	}

}
