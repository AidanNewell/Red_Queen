package cards;

public abstract class Card {

	protected int CardType;
	
	protected static final int BUILDER =0;
	protected static final int ACTION =1;
	
	public abstract int getCardType();

	
}
