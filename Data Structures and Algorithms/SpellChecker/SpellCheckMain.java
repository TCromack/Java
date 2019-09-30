/*
 * Name: Tyler Cromack
 * Course Number: CSC-220
 * Course Name: Data Structures and Algorithms
 * Problem Number: HW#8 Spell Check
 * This program will find misspelled words in a text
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import linecounter.ScannerWithLineno;

public class SpellCheckMain {
	private static Dictionary dictionary = new Dictionary();
	private static ScannerWithLineno textInput;

	//***************************************************************************	
	public static void main(String args[]) 
	{
		final String TITLE = "Spell Check V2.0";
		final String CONTINUE_PROMPT = "\nDo this again? [y/N] ";
		System.out.println("Welcome to " + TITLE+"\n");
		
		System.out.println("Loading Dictonary........");
		dictionary.loadDictionary();
		Scanner sc = new Scanner(System.in);
		do 
		{
			process(sc, args);
		} 
		while (doThisAgain(sc, CONTINUE_PROMPT));
		sc.close();
		System.out.println("\nThank you for using " + TITLE);
	}

//***************************************************************************
	private static void process(Scanner sc, String args[]) 
	{

		System.out.println("Enter the directory of the file you wish to spell check:");
		try {
			textInput = new ScannerWithLineno(new File(sc.next()));
			int lines = 0;
			
			do 
			{
				System.out.println("Enter how many lines from the text you wish to spell check: ");
				lines = sc.nextInt();
			} 
			while (lines < 0);
			System.out.println("\n");
			
			while (textInput.hasNext()) 
			{
				String word = textInput.next();
				String line = textInput.getCurrentLine();
				
				if (!dictionary.lookUpWord(word)) 
				{
					line = line.replace(word, "*" + word + "*");
					System.out.println(textInput.getLineno() + ": " + line);
				}
				if (textInput.getLineno() > lines)
					break;
			}
			
		} 
		
		catch (FileNotFoundException ex) 
		{
			System.err.println("\nNo File by that name exists.\nCheck the spelling and directory carefully.");
		}
		
		sc.nextLine();
	}

//***************************************************************************

	private static boolean doThisAgain(Scanner sc, String prompt) 
	{
		System.out.print(prompt);
		String doOver = sc.nextLine();
		return doOver.equalsIgnoreCase("Y");
	}

//***************************************************************************

}