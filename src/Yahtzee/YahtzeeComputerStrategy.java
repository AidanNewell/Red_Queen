package Yahtzee;

public class YahtzeeComputerStrategy extends AbstractComputerYahtzeePlayer{

	private CombinationChooser comboPicker;
	private DiceChooser dicePicker;
	protected String author,playername;
	
	YahtzeeComputerStrategy(CombinationChooser cc, DiceChooser dc){
		comboPicker = cc;
		dicePicker = dc;
		
	}
	
	YahtzeeComputerStrategy(){}
	
	public void reroll(int[] dice, int rollNumber, PlayerRecord record,
			boolean[] reroll) {
		dicePicker.reroll(dice, rollNumber, record, reroll);
	}

	
	public int chooseCombination(int[] dice, PlayerRecord record) {
		return comboPicker.chooseCombination(dice,record);
	}

	
	public void finalResults(int[] dice, PlayerRecord record) {
		// TODO Auto-generated method stub
		
	}

	
	public String author(){return author;}
	
	public String playerName(){return playername;}

}
