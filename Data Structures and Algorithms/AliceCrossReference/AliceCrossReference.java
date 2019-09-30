/*
 * Name: Tyler Cromack
 * Course Number: CSC-220
 * Course Name: Data Structures and Algorithms
 * Problem Number: HW#9 Alice Cross Reference
 * This program will find count how many of each word are
 * in a text along with what line to find them on
 */

package alice;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.Map.Entry;

public class AliceCrossReference 
{
	private static ScannerWithLineno textInput;
	private static Map<String, LinkedHashSet<Integer>> list = new TreeMap<>();
    private static Set<String> commonWords = new LinkedHashSet<String>();
    
//*******************************************************************************************
    public static void main(String args[]) 
    {
        final String TITLE = "Cross Reference V3.0";
        final String CONTINUE_PROMPT = "\nDo this again? [y/N] ";
 
        System.out.println("Welcome to " + TITLE);
        Scanner sc = new Scanner(System.in);
        do 
        {
            process(sc, args);
        } 
        while (doThisAgain(sc, CONTINUE_PROMPT));
        sc.close();
        System.out.println("\nThank you for using " + TITLE);
    }
    
//*******************************************************************************************
    private static void process(Scanner sc, String args[]) 
    {
        
        System.out.println("Enter the directory of the file you wish to Cross-Reference");
        try {
        	textInput = new ScannerWithLineno(new File(sc.next()));
            System.out.println("Would you like to ignore the 500 most commononly used words? [y/N]");
            if (sc.next().equalsIgnoreCase("y"))
                commonWords();
            else
                commonWords.clear();
            
            System.out.println("\nPlease Wait.........Larger texts take more time to process.....");
      
            while (textInput.hasNext()) 
            {
                String word = textInput.next().toLowerCase();
                Set<Integer> line = new LinkedHashSet<Integer>();
                if(!commonWords.contains(word))
                {
                	if (!list.containsKey(word))
                		list.put(word, (LinkedHashSet<Integer>) line);
                		list.get(word).add(textInput.getLineno());
                }
            }
            
            System.out.println("\nWords--Count--Lines\n----------------------------");
            
            for(Entry<String, LinkedHashSet<Integer>> entry : list.entrySet())
            {
            	String word = entry.getKey();
                LinkedHashSet<Integer> lines = entry.getValue();
                System.out.println(word + " (" + list.get(word).size() + ") " + ": " + lines);
            }   
 
        } catch (FileNotFoundException ex) 
        {
            System.err.println("\nNo File by that name exists.\nCheck the spelling and directory carefully.");
        }
        sc.nextLine();
    }
 
//*******************************************************************************************
    private static void commonWords() throws FileNotFoundException 
    {
    	try 
    	{
            URL file = new URL("http://cs.stcc.edu/~phillips/CommonWords.txt");
            Scanner cW = new Scanner(file.openStream());
            while(cW.hasNextLine())
            {
             commonWords.add(cW.nextLine());
            }
             cW.close();
        } 
    	catch (IOException badURL) 
        {
            System.err.println("This URL is not valid " + badURL);
        }
    }
  
//*******************************************************************************************
    private static boolean doThisAgain(Scanner sc, String prompt) 
    {
        System.out.print(prompt);
        String doOver = sc.nextLine();
        return doOver.equalsIgnoreCase("Y");
    }
}
