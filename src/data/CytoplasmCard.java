package data;

public class CytoplasmCard extends Card{
	
	public CytoplasmCard(){
		
		CardType = CYTOPLASM;
		
		int a = (int)(Math.random()*3);
		
		switch(a){
		
		case 0:
			ATP = 1;
			toxin = 1;
			resistance = 2;
			break;
		case 1:
			ATP = 2;
			toxin = 2;
			resistance = 2;
			break;
		case 2:
			ATP = 0;
			toxin = 0;
			resistance = 3;
			break;
		
		}
		
	}
	
	int getCardType() {
		
		return CYTOPLASM;
		
	}

	
	int getATP() {
		
		return ATP;
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
		
		return toxin;
	}

	
	void setToxin(int t) {
		
		toxin = t;
	}
	

}
