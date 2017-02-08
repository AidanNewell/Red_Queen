package Yahtzee;

public class BetterDice implements DiceChooser{


	private double[][] transitionalMatrix;
	private AbstractYahtzeeCombination goal;
	
	public void reroll(int[] dice, int rollNumber, PlayerRecord record,
			boolean[] reroll){
		//This will give us the current arrangement of dice
		String currentAssortment = "A";
		int letterIndex=0;
		for(int x=1; x< dice.length;x++)
		{
			if(dice[x] != dice[x-1])
			{
				letterIndex++;
			}
			currentAssortment += "ABCDE".substring(letterIndex,letterIndex+1);
		}
		//Now we have the starting point in ABCDE notation
		//We can check score options for compatibility to this starting point
		//and choose a "goal" based on relative frequency, similarity, and value
		AbstractYahtzeeCombination[] remainingOptions = record.availableCombinations();
	}
	
	public static void main(String [] args)
	{
		DiceChooser test = new BetterDice();
		//AAAAB
		test.reroll(new int[]{4, 4,4,4,6},1,null,null);
	}
}