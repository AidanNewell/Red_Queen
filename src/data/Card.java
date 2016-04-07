package data;

abstract class Card {

	protected int CardType;
	
	protected static final int ORGANISM = 1;
	protected static final int CYTOPLASM = 2;
	protected static final int PETRI_DISH = 3;
	
	abstract int getCardType();

	
}
