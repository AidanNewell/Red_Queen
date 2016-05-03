package cards;

import java.awt.Image;

public abstract class Card {

	protected int CardType;
	
	protected static final int BUILDER =0;
	protected static final int ACTION =1;
	
	public static final int CYTOPLASM_CARD=0, ORGANISM_CARD=1, PETRI_DISH_CARD=2;
	
	public abstract int getCardType();
	
	public abstract Image getCardArt();
	
}
