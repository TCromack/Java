/*
 * Name: Tyler Cromack
 * Course Number: CSC-220  
 * Course Name: Data Structures
 * Problem Number: HW #2 One Dimensional Arrays
 *
 * This program will check if two Arrays are equal with values given by User.
 */

import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JOptionPane;

	//*************************************************************

public class ArrayChecker {

	public static void main(String[] args) 
	{
        final String TITLE = "ARRAY EQUIVALENCY TESTER V1.0";
        final String CONTINUE_PROMPT = "Would you like to enter a new set of array values? [y/N] " + "\n(If yes please re-click on Array Checker dialog box to enter new values) ";
 
        System.out.println("Welcome to " + TITLE + "\nPlease enter a set of values in the dialog box");
        Scanner sc = new Scanner(System.in);
        do 
        {
          isEquivalent(sc);
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
	
	public static int getNumbers(int [] arraylist1, int i)
	{
		String sizeT = JOptionPane.showInputDialog("Enter the number of values you would like to have in Array#"+i+"\n(The number of values must be less than 101)");
		int size = Integer.parseInt(sizeT);		
		
		for (int c=0; c < size; c++)
		{
			
		
		String NumT = JOptionPane.showInputDialog("Enter value#"+(c+1));
				int Num = Integer.parseInt(NumT);
				
				arraylist1[c] = Num;
		}
		
		
		return size;
		
		}
	
	//*************************************************************
	
	public static void isEquivalent(Scanner sc)
	{
		int[] Array1 = new int[100]; 
		int[] Array2 = new int[100];
		// Determine length of the Arrays
		int size1, size2;
		size1 = getNumbers(Array1,1);
		size2 = getNumbers(Array2,2);
		
		//Print User Input in Order given by User
		System.out.println("\nYou have Input the following values");
		System.out.println("\n------------Array 1------------");
		for (int c = 0; c < size1; c++)
			System.out.println(Array1[c]);
				System.out.println("\n------------Array 2------------");
		for (int c = 0; c < size2; c++)
			System.out.println(Array2[c]);
		System.out.println("\nARRAYS BELOW ARE SORTED IN ASCENDING ORDER");
		
	//*************************************************************
		
		//Sort and Print First Array Values in Ascending Order	
		System.out.println("\n------------Array 1------------");			
		int temp;
		boolean fixed=false;
		while(fixed==false)
		{
			fixed=true;
					
			for (int c = 0; c < size1-1; c++)
			{
				if(Array1[c]>Array1[c+1])
					{
						temp = Array1[c+1];
							
						Array1[c+1]=Array1[c];
							
						Array1[c]=temp;
						fixed=false;	
						}
					}
				}
			for (int c = 0; c < size1; c++)
						System.out.println(Array1[c]);
			
	//*************************************************************
			
		//Sort and Print Second Array Values in Ascending Order
			System.out.println("\n------------Array 2------------");
			int temp2;
			boolean fixed2=false;
			while(fixed2==false)
			{
				fixed2=true;
						
				for (int c = 0; c < size2-1; c++)
				{
					if(Array2[c]>Array2[c+1])
						{
							temp2 = Array2[c+1];
								
							Array2[c+1]=Array2[c];
								
							Array2[c]=temp2;
							fixed2=false;	
							}
						}
					}
				for (int c = 0; c < size2; c++)
							System.out.println(Array2[c]);	
				
				System.out.println("\nAre Array 1 and Array 2 equivalent?\n\nThe answer is: " + Arrays.equals(Array1,Array2));
	}
}
