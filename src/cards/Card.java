package cards;

public abstract class Card {

	protected int CardType;
	
	protected static final int ORGANISM = 1;
	protected static final int CYTOPLASM = 2;
	protected static final int PETRI_DISH = 3;
	protected static final int VIRUS = 4;
	
	abstract int getCardType();

	
}
