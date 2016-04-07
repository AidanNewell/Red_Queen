package data;

abstract class OrganismCard extends Card{
	
	protected int resistance;
	
	protected int ATP;
	
	protected int toxin;
	
	public OrganismCard(){
		
		CardType = ORGANISM;
		
	}
	
	int getCardType() {
		
		return ORGANISM;
		
	}
	
	abstract int getATP();
	abstract void setATP(int a);
	abstract int getResistance();
	abstract void setResistance(int r);
	abstract int getToxin();
	abstract void setToxin(int t);

}
