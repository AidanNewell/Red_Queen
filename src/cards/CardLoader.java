package cards;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CardLoader {

	private static ArrayList<String> organismStarter;
	private static ArrayList<String> cytoplasmCard;
	private static ArrayList<String> petriCard;	
	
	public static void init()
	{
		organismStarter = new ArrayList<String>();
		cytoplasmCard = new ArrayList<String>();
		petriCard = new ArrayList<String>();
		try {
			Scanner fileReader = new Scanner(new File("assets/CardList"));
			String inputString = fileReader.next();
			while(!inputString.equals("STARTERS")){inputString = fileReader.next();}
			inputString = fileReader.next();
			while(!inputString.equals("CYTOPLASM")){organismStarter.add(inputString);inputString=fileReader.next();}
			inputString = fileReader.next();
			while(!inputString.equals("PETRI")){cytoplasmCard.add(inputString);inputString=fileReader.next();}
			while(fileReader.hasNext()){inputString = fileReader.next();petriCard.add(inputString);}
			fileReader.close();
		} catch (Exception e){System.out.println("FATAL ERROR READING CARD LIST"); e.printStackTrace(); System.exit(1);}
	}
	
	public static Card getOrganismCard()
	{
		try {
			return (Card) (Class.forName("cards."+organismStarter.get((int)(Math.random()*organismStarter.size())))).newInstance();
		} catch (Exception e){e.printStackTrace();System.exit(1);}
		return null;
	}
	
	public static Card getCytoplasmCard()
	{
		try{
			return (Card) Class.forName("cards."+cytoplasmCard.get((int)(Math.random()*cytoplasmCard.size()))).newInstance();
		}catch(Exception e){e.printStackTrace();System.exit(1);}
		return null;
	}
	
	public static Card getPetriCard()
	{
		try{
			return (Card) Class.forName("cards."+petriCard.get((int)(Math.random()*petriCard.size()))).newInstance();
		}catch(Exception e){e.printStackTrace();System.exit(1);}
		return null;
	}
}
