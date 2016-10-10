package Yahtzee;

import java.util.Arrays;

public class YahtzeeGame {
	public void sortDice (int[] dice){
		 Arrays.sort(dice);
	}
	public void playerRoll(YahtzeePlayer player, PlayerRecord record, int [] dice, int rollNumber){
		PlayerRecord recordCopy = new PlayerRecord(record);
		boolean[] all = {true,true,true,true,true};
		boolean[] none = new boolean[5];
		if(rollNumber == 0){
			player.reroll(dice,rollNumber,recordCopy,all);
		}
		else{
			player.reroll(dice,rollNumber,recordCopy,none);
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
			dice[x] = (int)(Math.random()*6);
		}
		sortDice(dice);
		for(int x=0; x<4;x++)
		{
			playerRoll(player, record, dice, x);
		}
		playerChoose(player, record, null, 3);
	}
	public int yahtzeeGame(YahtzeePlayer player){
		PlayerRecord record = new PlayerRecord();
		for(int i = 0; i<13; i++){
			yahtzeeTurn(player,record);
		}
		return record.totalScore();
	}
}
