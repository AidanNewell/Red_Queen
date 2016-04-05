package data;

abstract class Card {

	protected int CardType;
	
	protected static final int ORGANISM = 1;
	protected static final int CYTOPLASM = 2;
	protected static final int PETRI_DISH = 3;
	
	protected int ATP;
	protected int resistance;
	protected int toxin;
	
	abstract int getCardType();
	
	abstract int getATP();
	abstract void setATP(int a);
	
	abstract int getResistance();
	abstract int setResistance(int r);
	
	abstract int getToxin();
	abstract int setToxin(int t);
	
}
