package Yahtzee;

public class TestDiceChooser implements DiceChooser {
	
	public void reroll(int[] dice, int rollNumber, PlayerRecord record,
			boolean[] reroll) {
		int[] diceNumbers = new int[6];
		for(int x=0; x<dice.length;x++)
		{
			diceNumbers[dice[x]-1]++;
		}
		
				
		//Always rerolls the minority dice
		int highestIndex=0;
		int pairs = 0;
		int[] pairNumbers = new int[2];
		for(int x=0; x<diceNumbers.length;x++)
		{
			//This way if you have 3 sixes and 3 ones it'll keep the sixes ;)
			if(diceNumbers[x] >= diceNumbers[highestIndex] && isNumAvailable(record,x+1));
				highestIndex=x;
			if(diceNumbers[x] == 2){
				pairNumbers[pairs] = x + 1;
				pairs++;
			}
			
		}
		for(int x=0; x<dice.length;x++)
		{
			if(pairs == 2 && isAvailable(record,"FullHouseCombination") && rollNumber==2){
				if(dice[x] == pairNumbers[0]|| dice[x] == pairNumbers[1]){
					reroll[x] = false;
				}
				else
					reroll[x] = true;
			}
			else{
				if (dice[x] != highestIndex+1)
					reroll[x]=true;
				else
					reroll[x]=false;
			}
		}
		//but also don't reroll if you have things
		AbstractYahtzeeCombination[] all = AbstractYahtzeeCombination.allCombinations();
		try{
			if((all[AbstractYahtzeeCombination.combinationIndex("YahtzeeCombination")].score(dice)==50 && isAvailable(record,"YahtzeeCombination"))||
					(all[AbstractYahtzeeCombination.combinationIndex("FullHouseCombination")].score(dice)==25 && isAvailable(record,"FullHouseCombination")) ||
					(all[AbstractYahtzeeCombination.combinationIndex("LargeStraightCombination")].score(dice)== 40 && isAvailable(record,"LargeStraightCombination"))||
					(all[AbstractYahtzeeCombination.combinationIndex("SmallStraightCombination")].score(dice)== 30 && isAvailable(record,"SmallStraightCombination")))
			{
				for(int x=0; x<reroll.length;x++)
				{
					reroll[x]=false;
				}
			}
		}catch(Exception e){}

	}
	private boolean isAvailable(PlayerRecord record, String comboName){
		AbstractYahtzeeCombination[] combos = record.availableCombinations();
		for(int i = 0; i<combos.length; i++){
			if(combos[i].name().equals(comboName)){
				return true;
			}
		}
		return false;
	}
	private boolean isNumAvailable(PlayerRecord record, int diceNum){
		String comboName = "";
		switch(diceNum){
			case 1: comboName = "AcesCombination";
			break;
			case 2: comboName = "TwosCombination";
			break;
			case 3: comboName = "ThreesCombination";
			break;
			case 4: comboName = "FoursCombination";
			break;
			case 5: comboName = "FivesCombination";
		}
		AbstractYahtzeeCombination[] combos = record.availableCombinations();
		for(int i = 0; i<combos.length; i++){
			if(combos[i].name().equals(comboName) || combos[i].name().equals("ThreeOfAKindCombination") 
					|| combos[i].name().equals("FourOfAKindCombination")){
				return true;
			}
		}
		return false;
	}

}
