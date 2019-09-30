/*
 * Name: Tyler Cromack
 * Course Number: CSC-220
 * Course Name: Data Structures and Algorithms
 * Problem Number: HW#8 Spell Check
 * Load and search the Dictionary
 */
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
 
public class Dictionary 
{
    MostRecentlyUsed<String> list = new MostRecentlyUsed<String>();
 
    public void loadDictionary() 
    {
        try {
            URL file = new URL("https://raw.githubusercontent.com/dwyl/english-words/master/words2.txt");
            Scanner sc = new Scanner(file.openStream());
            while (sc.hasNextLine()) 
            {
                list.add(sc.next());
                sc.nextLine();
            }
        } catch (IOException badURL) 
        {
            System.err.println("This URL is not valid " + badURL);
        }
    }
 
    public boolean lookUpWord(String word) 
    {
        if (list.contains(word))
            return true;
        else
        return false;
    }
 
}