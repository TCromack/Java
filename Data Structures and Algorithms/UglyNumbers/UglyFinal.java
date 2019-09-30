/*
 * Name: Tyler Cromack 
 * Course Number: CSC-220  
 * Course Name: Data Structures
 * Problem Number: HW #1
 * 
 * This program will find Ugly numbers between values given by the User.
 */

package Chapter6;

import java.util.Scanner;
import silvestri.Library;

public class UglyFinal 
{
	
	public static void main(String args[]) 
	{
        final String TITLE = "UGLY NUMBER GENERATOR V1.0";
        final String CONTINUE_PROMPT = "Would you like to enter a new range of values? [y/N] ";
 
        System.out.println("Welcome to " + TITLE);
        Scanner sc = new Scanner(System.in);
        do 
        {
          process(sc);
        } 
        while (doThisAgain(sc, CONTINUE_PROMPT));
        sc.close();
        System.out.println("Thank you for using " + TITLE);
    }
 
    //*************************************************************
   
    private static boolean doThisAgain(Scanner sc, String prompt) 
    {
        System.out.print(prompt);
        String doOver = sc.nextLine();
        return doOver.equalsIgnoreCase("Y");
    }
 
    //*************************************************************
   
    private static void process(Scanner sc) 
    {
    	System.out.print("Enter a range of Numbers below that you wish to know are ugly. \n\n");
    	System.out.print("Enter lowest value: ");
        int low = sc.nextInt();
        System.out.print("Enter highest value: ");
        sc.nextLine();
        int high = sc.nextInt();
        printUglyNumbers(low, high);
        sc.nextLine(); 
    }
 
    //*************************************************************
    
    public static boolean isUgly(int number) 
    {
    	if (number <= 0) 
    	{
            return false;
        }
        while (number != 1) 
        {
            if (number % 2 == 0) 
            {
                number /= 2;
            } 
            
            else if (number % 3 == 0) 
            {
                number /= 3;
            } 
            
            else if (number % 5 == 0) 
            {
                number /= 5;
            } 
            else 
            {
            	return false;
            }       
        }
          return true;
    }
    
  //*************************************************************
   
    public static void printUglyNumbers(int low, int high) {
        System.out.printf("%5s |%6s\n", "Count", "Ugly");
        System.out.printf("%6s+%6s\n", Library.repeatString("-", 6), Library.repeatString("-", 6));
        int count = 0; // Count the number of ugly numbers
 
        for (int number = low; number <= high; number++) {
            if (isUgly(number)) {
                count++; // Increase count
                System.out.printf("%-5s |%6d\n", count, number);
            }
        }
    }

}
