/*
 * Name: Tyler Cromack
 * Course Number: CSC-220
 * Course Name: Data Structures and Algorithms
 * Problem Number: HW#6 Baby Names Application
 * Baby Analyzer will take the given Input and Output the most popular Baby names
 */

package babynames;
 
import java.io.*;
import java.util.*;
 
public class BabyAnalyzer
{
 
//************************************************************************************
    public static void main(String args[])
    { 
        final String TITLE = "Baby Name Application V 1.0";
        final String CONTINUE_PROMPT = "Do this again? [y/N] ";
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

//************************************************************************************
    public static void readBabyNames(int i, ArrayList<BabyName> boys, ArrayList<BabyName> girls) throws FileNotFoundException         
    {
        Scanner sc = new Scanner(new File("src/babynames/yob" + i + ".txt"));
        sc.useDelimiter("\\s*,\\s*|\\s+");
        while (sc.hasNextLine())
        {
            String name = sc.next();
            String gender = sc.next();
            int number = sc.nextInt();
            sc.nextLine();
           
            BabyName baby = new BabyName(name, gender, number);
            if (gender.equalsIgnoreCase("m"))
            {
                int index = 1;
                index = boys.indexOf(baby);
                if (index == -1)
                {
                    boys.add(baby);
                }
                else 
                {
                    boys.get(index).numberCount(number);
                }
            } 
            //Must be girl if not a boy
            else 
            {
                int index = 1;
                index = girls.indexOf(baby);
                if (index == -1)
                {
                    girls.add(baby);
                }
                else
                {
                    girls.get(index).numberCount(number);
                }
            }
        }
        sc.close();
    }
//************************************************************************************
    private static void process(Scanner sc, String args[])
    {
        ArrayList<BabyName> boys = new ArrayList<BabyName>();
        ArrayList<BabyName> girls = new ArrayList<BabyName>();

        int startYear;
        int endYear;
        int topNames;
        
        System.out.print("\nEnter a year starting between 1880 to 2015: ");
        startYear = sc.nextInt();
            if (startYear < 1880 || startYear > 2015)
            {
                throw new IllegalArgumentException("Attempted to enter a year outside of the allowed range ");
            }
               
        System.out.print("Enter a year from "+ startYear +" to 2015: ");
        endYear = sc.nextInt();
        	if (endYear < startYear || endYear > 2015)
        	{
        		throw new IllegalArgumentException("Attempted to enter a year outside of allowed range ");
        	}
 
        System.out.print("Enter a number for the top number of Boy's and Girl's Names: ");
        topNames = sc.nextInt();
        sc.nextLine();
//************************************************************************************
        //Check that top list integer is valid
        if (topNames <= 0)
        {
            throw new IllegalArgumentException("\nINVALID VALUE: Value must be a positive non zero integer!");
        }  

//************************************************************************************        
       //Read data for given user Inputs
        System.out.print("\nSearching for top " + topNames + " Boy's and Girl's Names between " + startYear + " and " + endYear +".....\n");
        for (int i = startYear; i <= endYear; i++)
        {
            try 
            {
                readBabyNames(i, boys, girls);
            } 
            catch (Exception badInput) 
            {
                System.out.println(badInput);
            }
 
        }
        Collections.sort(boys);
        Collections.sort(girls);
//************************************************************************************
       //Create top Boys Names
        if (topNames <= boys.size())
        {
            System.out.println("\nTop " + topNames + " Boy Names\n");
            for (int i = 0; i < topNames; i++)
            {
                System.out.println((i + 1) + ". " + boys.get(i));
            }
        }      
        else
            throw new IllegalArgumentException("Not enough names in the Boys list to create requested number of Name's in top list.");
        
//************************************************************************************  
        //Create top Girls Names
        if (topNames <= girls.size()) 
        {
            System.out.println("\nTop " + topNames + " Girl Names\n");
            for (int i = 0; i < topNames; i++)
            {
                System.out.println((i + 1) + ". " + girls.get(i));
            }
        } 
        else
            throw new IllegalArgumentException("Not enough names in the Girls list to create requested number of Name's in top list.");   
    }
 
//************************************************************************************
    private static boolean doThisAgain(Scanner sc, String prompt)
    {
        System.out.print(prompt);
        String doOver = sc.nextLine();
        return doOver.equalsIgnoreCase("Y");
    }
}