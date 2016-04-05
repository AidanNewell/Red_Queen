package data;

public class OrganismCard extends Card{
	
	private int maxSize;
	
	private int resistance;
	
	public OrganismCard(int ms, int res){
		
		maxSize = ms;
		
		resistance = res;
		
	}
	
	public int getMaxSize(){
		
		return maxSize;
		
	}
	
	public int getResistance(){
		
		return resistance;
		
	}

}
