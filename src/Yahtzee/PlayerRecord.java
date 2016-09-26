package Yahtzee;

public class PlayerRecord {

	private int lowerSectionScore;
	private int upperSectionScore;
	
	private AbstractYahtzeeCombination[] combinations;
	
	
	PlayerRecord()
	{
		lowerSectionScore=0;
		upperSectionScore=0;
		combinations = AbstractYahtzeeCombination.allCombinations();
	}
	
	PlayerRecord(PlayerRecord record)
	{
		lowerSectionScore = record.lowerSectionScore();
		upperSectionScore = record.upperSectionScore();
	}
	
	public int lowerSectionScore()
	{
		return lowerSectionScore;
	}
	
	public int upperSectionScore()
	{
		return upperSectionScore;
	}
	
	public AbstractYahtzeeCombination[] availableCombinations()
	{
		return null;
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
		int tripleUpper = 0;
		String[] upperNames = {"AcesCombination","TwosCombination","ThreesCombination",
				"FoursCombination","FivesCombination","SixesCombination"};
		boolean upperTaken = true;
		for(int x=0; x<upperNames.length;x++)
		{
			upperTaken=true;
			for(int y=0; y<combinations.length;y++)
			{
				if(combinations[y].name().equals(upperNames[x]))
					upperTaken=false;
					
			}
			if(upperTaken)
			{
				tripleUpper += 3 * (x+1);
			}
		}
		return upperSectionScore - tripleUpper;
	}
}
