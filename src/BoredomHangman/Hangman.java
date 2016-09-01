package BoredomHangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {

	public static void main(String [] args)
	{
		System.out.println("Welcome to Hangman! \nPlease select a difficulty: [E]asy, [M]edium, [H]ard");
		Scanner input = new Scanner(System.in);
		String difficulty = input.next();
		while("EMH".indexOf(difficulty.toUpperCase())== -1 && difficulty.length() > 1)
		{
			System.out.println("That's not a valid input! Stop trying to break the code.");
			difficulty = input.next();
		}
		int diff = "EMH".indexOf(difficulty.toUpperCase());
		diff++;
		String hidden = getHiddenString(diff);
		StringBuilder progress=new StringBuilder("");
		for(int x=0; x<hidden.length();x++)
		{
			if(("',;: ,.".indexOf(hidden.substring(x,x+1)) != -1))
			{
				progress.append(hidden.substring(x,x+1));
			}
			else
			{
				progress.append("_");
			}
		}
		String guessed="";
		while(!progress.equals(hidden))
		{
			System.out.println("Guess the Word/Phrase Whatever!");
			System.out.println(progress);
			System.out.println("Enter a letter to guess, or enter 'solve' to attempt a solution!");
			guessed = input.nextLine();
			while(!("abcdefghijklmnopqrstuvwxyz".indexOf(guessed) != -1 && guessed.length() == 1) || guessed.equals("solve"))
			{
				System.out.println("STOP TRYING TO BREAK THE PROGRAM AND GUESS AGAIN.");
				guessed = input.nextLine();
			}
			if(guessed.equals("solve"))
			{
				guessed = input.nextLine();
				if(!guessed.equals(hidden))
				{
					
				}
			}
			else
			{
				for(int x=0; x<hidden.length();x++)
				{
					if(guessed.equals(hidden.substring(x,x+1).toLowerCase()))
					{
						progress.setCharAt(x,hidden.charAt(x));
					}
				}
			}
		}
		System.out.println("CONGRATS, YOU WASTED TIME!!!");
	}
	
	public static String getHiddenString(int x)
	{
		ArrayList<String> strings = new ArrayList<String>();
		try {
			Scanner stringReader = new Scanner(new File("Answers"));
			String scanned = stringReader.nextLine();
			while(x >0)
			{
				if(scanned.equals("---"))
				{
					x--;
				}
				scanned = stringReader.nextLine();
			}
			while(stringReader.hasNext() && !scanned.equals("---"))
			{
				strings.add(scanned);
				scanned = stringReader.nextLine();
			}
			stringReader.close();
			return strings.get(((int)(Math.random()*strings.size())));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
