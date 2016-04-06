package data;

public class OrganismCard extends Card{
	
	private int maxSize;
	
	private int resistance;
	
	public OrganismCard(int ms, int res){
		
		maxSize = ms;
		
		resistance = res;
		
		CardType = ORGANISM;
		
	}
	
	public int getMaxSize(){
		
		return maxSize;
		
	}

	int getCardType() {
		
		return ORGANISM;
		
	}
	
	int getATP() {
		
		return 0;
	}

	void setATP(int a) {
		
		
	}
	
	int getResistance(){
		
		return resistance;
		
	}

	void setResistance(int r) {
		
		resistance = r;
	}

	int getToxin() {
		
		return 0;
	}

	void setToxin(int t) {
		
		
	}

}
