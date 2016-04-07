package cards;

public class OrganismBodyCard extends OrganismCard{

	protected final static int DEFAULT_RESISTANCE = 2;
	
	public OrganismBodyCard(){
		super();
		
		ATP = 0;
		resistance = DEFAULT_RESISTANCE;
		toxin = 0;
		
	}
	
	int getATP() {
		
		return 0;
		
	}

	void setATP(int a) {
		
		ATP = a;
		
	}

	int getResistance() {
		
		return resistance;
		
	}

	void setResistance(int r) {
		
		resistance = r;
		
	}

	int getToxin() {
		
		return 0;
		
	}

	void setToxin(int t) {
		
		toxin = t;
		
	}

}
