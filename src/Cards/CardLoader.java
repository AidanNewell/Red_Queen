package Cards;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CardLoader {

	private ArrayList<String> organismStarter;
	private ArrayList<String> cytoplasmCard;
	private ArrayList<String> petriCard;	
	
	public CardLoader()
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
		} catch (Exception e){System.out.println("FATAL ERROR READING CARDS"); e.printStackTrace(); System.exit(1);}
	}
	
	public Card getOrganismCard()
	{
		try {
			return (Card) Class.forName(organismStarter.get((int)(Math.random()*organismStarter.size()))).newInstance();
		} catch (Exception e){e.printStackTrace();System.exit(1);}
		return null;
	}
	
	public Card getCytoplasmCard()
	{
		try{
			return (Card) Class.forName(cytoplasmCard.get((int)(Math.random()*cytoplasmCard.size()))).newInstance();
		}catch(Exception e){e.printStackTrace();System.exit(1);}
		return null;
	}
}
