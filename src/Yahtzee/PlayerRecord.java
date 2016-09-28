package Yahtzee;


public class PlayerRecord {

	private int lowerSectionScore;
	private int upperSectionScore;
	
	private AbstractYahtzeeCombination[] combinations;
	
	private int[] combinationScores;
	
	
	PlayerRecord()
	{
		lowerSectionScore=0;
		upperSectionScore=0;
		System.arraycopy(AbstractYahtzeeCombination.allCombinations(),0,combinations,0,AbstractYahtzeeCombination.allCombinations().length);
		combinationScores = new int[combinations.length];
		for(int x=0; x<combinationScores.length;x++)
		{
			combinationScores[x] = -1;
		}
	}
	
	PlayerRecord(PlayerRecord record)
	{
		lowerSectionScore = record.lowerSectionScore();
		upperSectionScore = record.upperSectionScore();
		System.arraycopy(record.rawCombinations(), 0, combinations,0,record.rawCombinations().length);
		System.arraycopy(record.combinationScores(),0,combinationScores,0,record.combinationScores.length);
	}
	
	public int lowerSectionScore()
	{
		return lowerSectionScore;
	}
	
	public int upperSectionScore()
	{
		return upperSectionScore;
	}
	
	public int[] combinationScores()
	{
		return combinationScores;
	}
	
	public AbstractYahtzeeCombination[] rawCombinations()
	{
		return combinations;
	}
	
	public AbstractYahtzeeCombination[] availableCombinations()
	{
		int combinationsRemaining=0;
		for(int x=0; x<combinations.length;x++)
		{
			if(combinations[x] != null)
				combinationsRemaining++;
		}
		AbstractYahtzeeCombination[] availableCombinations = new AbstractYahtzeeCombination[combinationsRemaining];
		int index=0;
		for(int x=0; x<combinations.length;x++)
		{
			if(combinations[x] != null)
			{
				availableCombinations[index] = combinations[x];
				index++;
			}
		}
		return availableCombinations;
	}
	
	public void chooseCombination(int index, int score)
	{
		if(combinations[index].upperSection())
		{
			upperSectionScore+=score;
		}
		else
		{
			lowerSectionScore+=score;
		}
		combinationScores[index] = score;
		combinations[index] = null;
	}
	
	public int totalScore()
	{
		if(upperSectionScore >= 63 && combinations.length == 0)
		{
			return upperSectionScore + lowerSectionScore + 35;
		}
		else
			return upperSectionScore + lowerSectionScore;
	}
	
	public int upDown()
	{
		int possibleScore=0;
		String[] upperNames = {"AcesCombination","TwosCombination","ThreesCombination",
				"FoursCombination","FivesCombination","SixesCombination"};
		for(int x=0; x<upperNames.length;x++)
		{
			if(combinationScore(upperNames[x]) != -1)
			{
				possibleScore += (combinationScore(upperNames[x]) - (3*(x+1)));
			}
		}
		return possibleScore;
	}
	
	public int choiceNumber(String combinationName)
	{
		AbstractYahtzeeCombination[] availComb = availableCombinations();
		for(int x=0; x< availComb.length; x++)
		{
			if(availComb[x].name().equals(combinationName))
				return x;
		}
		return -1;
	}
	
	public int combinationScore(String combinationName)
	{
		int index = AbstractYahtzeeCombination.combinationIndex(combinationName);
		if(index == -1)
			return -1;
		else
			return combinationScores[index];
	}
}
