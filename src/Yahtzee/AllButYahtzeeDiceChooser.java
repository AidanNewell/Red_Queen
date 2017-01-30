package Yahtzee;

public class AllButYahtzeeDiceChooser implements DiceChooser{

	public void reroll(int[] dice, int rollNumber, PlayerRecord record,
			boolean[] reroll) {
		if(AbstractYahtzeeCombination.allCombinations()[AbstractYahtzeeCombination.combinationIndex("YahtzeeCombination")].score(dice)==0)
		{
			for(int x=0; x<reroll.length;x++)
			{
				reroll[x]=true;
			}
		}
		
	}

}
