package Yahtzee;

public class DiceChooser2 implements DiceChooser{

	@Override
	public void reroll(int[] dice, int rollNumber, PlayerRecord record,
			boolean[] reroll) {
		AbstractYahtzeeCombination[] available = record.availableCombinations();
		AbstractYahtzeeCombination[] all = AbstractYahtzeeCombination.allCombinations();
		boolean[] availability = new boolean[13];//0.1,1.2,2.3,3.4,4.5,5.6,6.3x,7.4x,8.full,9.small,10.large,11.yahtzee,12.chance 
		for(int i = 0;i<available.length;i++){
			for(int j = 0;j<all.length;j++){
				if(available[i].name().equals(all[j].name())){
					availability[j] = true;
				}
			}
		}
		
		int[] diceNumbers = new int[6];
		for(int x=0; x<dice.length;x++)
		{
			diceNumbers[dice[x]-1]++;
		}
		//Always rerolls the minority dice
		int highestAvailableIndex=0;
		for(int x=0; x<diceNumbers.length;x++)
		{
			//This way if you have 3 sixes and 3 ones it'll keep the sixes ;)
			if(diceNumbers[x] >= diceNumbers[highestAvailableIndex])
				highestAvailableIndex=x;
		}
		for(int x=0; x<dice.length;x++)
		{
			if(dice[x] != highestAvailableIndex+1)
				reroll[x]=true;
			else
				reroll[x] = false;
		}
		//but also don't reroll if you have things
		try{
			if((all[AbstractYahtzeeCombination.combinationIndex("YahtzeeCombination")].score(dice)==50 && availability[11])||
					(all[AbstractYahtzeeCombination.combinationIndex("FullHouseCombination")].score(dice)==25 && availability[8]) ||
					(all[AbstractYahtzeeCombination.combinationIndex("LargeStraightCombination")].score(dice)== 40 && availability[10])||
					(all[AbstractYahtzeeCombination.combinationIndex("SmallStraightCombination")].score(dice)== 30 && availability[9]))
			{
				for(int x=0; x<reroll.length;x++)
				{
					reroll[x]=false;
				}
			}
		}catch(Exception e){}
		
	}
}
