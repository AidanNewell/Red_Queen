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
		if(rollNumber != 0){
			player.reroll(dice,rollNumber,recordCopy,none);
		}
		else{
			player.reroll(dice,rollNumber,recordCopy,all);
		}
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
		//make dice???
		int[] dice = new int[5];
		for(int i = 0; i<5; i++){
			dice[i] = (int)(Math.random()*6) + 1;
		}
		sortDice(dice);
		int comboLength;
		for(int i = 0; i<4; i++){
			playerRoll(player,record, dice, i);
			comboLength = record.availableCombinations().length;
			if(comboLength>0)
				playerChoose(player,record,dice,i);
			else
				player.finalResults(dice,record);
		}
	}
	public int yahtzeeGame(YahtzeePlayer player){
		PlayerRecord record = new PlayerRecord();
		for(int i = 0; i<13; i++){
			yahtzeeTurn(player,record);
		}
		return record.totalScore();
	}
}
