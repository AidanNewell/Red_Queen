package Yahtzee;

import java.util.Arrays;

public class YahtzeeGame {
	public void sortDice (int[] dice){
		 Arrays.sort(dice);
	}
	public void playerRoll(YahtzeePlayer player, PlayerRecord record, int [] dice, int rollNumber){
		PlayerRecord recordCopy = new PlayerRecord(record);
		boolean[] rollBoolean = new boolean[5];
		if(rollNumber == 0){
			for(int x=0; x<dice.length;x++)
				dice[x] =((int)(Math.random()*6)) + 1;
		}
		else{
			player.reroll(dice,rollNumber,recordCopy,rollBoolean);
			for(int x=0; x<dice.length;x++)
			{
				if(rollBoolean[x])
					dice[x] = ((int)(Math.random()*6)) + 1;
			}
		}
		sortDice(dice);
	}
	public void playerChoose(YahtzeePlayer player, PlayerRecord record, int [] dice, int rollNumber){
		PlayerRecord recordCopy = new PlayerRecord(record);
		int choice = player.chooseCombination(dice,recordCopy);
		int comboLength = recordCopy.availableCombinations().length;
		AbstractYahtzeeCombination combo;
		if(choice < 0)
			choice = 0; 
		if(choice > comboLength)
			choice = comboLength - 1; 
		combo = recordCopy.availableCombinations()[choice];
		record.chooseCombination(choice, combo.score(dice)); 
	}
	public void yahtzeeTurn(YahtzeePlayer player, PlayerRecord record){
		int[] dice = new int[5];
		for(int x=0; x<dice.length;x++)
		{
			dice[x] = ((int)(Math.random()*6)) + 1;
		}
		sortDice(dice);
		for(int x=0; x<3;x++)
		{
			playerRoll(player, record, dice, x);
		}
		playerChoose(player, record, dice, 3);
	}
	public int yahtzeeGame(YahtzeePlayer player){
		PlayerRecord record = new PlayerRecord();
		for(int i = 0; i<13; i++){
			yahtzeeTurn(player,record);
		}
		player.finalResults(null, record);
		return record.totalScore();
	}
}
