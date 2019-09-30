/*
 * Name: Tyler Cromack
 * Course Number: CSC-220
 * Course Name: Data Structures and Algorithms
 * Problem Number: HW#3 Star Data Analyzer
 * This program will find probable locations of stars based on input of light intensity
 */
import java.io.*;
import java.util.*; 

public class StarGrid 
{

//********************************************************************************
	  
			public static void main(String args[]) throws FileNotFoundException 
			{
				int count = 1;
				
				final String TITLE = "Star Analyzer v1.0";
				final String CONTINUE_PROMPT = "";
				
				
				
				System.out.println("Welcome to " + TITLE + "\n");
				Scanner sc = new Scanner(new File("StarData.txt"));
				
				do 
				{
					process(sc,count);
					count++;
				} 
				
				while (doThisAgain(sc, CONTINUE_PROMPT));
				sc.close();
			}
		    
//********************************************************************************
			   
		    private static boolean doThisAgain(Scanner sc, String prompt) 
		    {
		        System.out.print(prompt);
		        String doOver = sc.nextLine();
		        return doOver.equalsIgnoreCase("Y");
		    }
		   
//********************************************************************************		   
			
			public static void process(Scanner sc, int count)
			{
				
			int [][]starData = inputStarData(sc);
			outputStarGrid(analyzeStarData(starData),count);
			System.out.println();
			
			}
		
//********************************************************************************
		
		    static int[][] inputStarData(Scanner sc)
		    {

		    	int row = sc.nextInt();
		    	int col = sc.nextInt();
		    	int [][]stardata = new int[row][col];
		    	
		    	int i;
		    	int j;
		    	
		    	for(i = 0; i < row; i++)
		    	{
		    		for(j = 0; j < col; j++)
		    			 stardata[i][j] = sc.nextInt();
		    	}
		    	sc.nextLine();
		    		return stardata;
		    }
		   
		    
//********************************************************************************
		    
		    public static int getSum(int starSum[][], int row, int col){
		    	
		     int sum = starSum[row - 1][col - 1] + starSum[row - 1][col] + starSum[row - 1][col + 1]
		    	 	 + starSum[row][col-1] + starSum[row][col] + starSum[row][col+1]
	    		     + starSum[row+1][col-1] + starSum[row+1][col] + starSum[row+1][col+1];
		    		
		    return sum;
		    }
		    
//********************************************************************************		    
		  
		    static char[][] analyzeStarData(int starData[][])
		    {
		    	char [][]grid = new char[starData.length][starData[0].length];
		    	int i;
		    	int j;
		    	
		    	
		    	for (i = 0; i < starData.length; i++)
		    	{
		    		for (j = 0; j < starData[0].length; j++)
		    		{
		    
		    	if(i!=0 && j!=0 && i!=starData.length-1 && j!=starData[0].length-1)
		    	{
		    		
		    			    if ((getSum(starData, i, j)/5) > 6.0)
		    			    	grid[i][j] = '*';
		    			    
		    				else 
		    					grid[i][j] = ' ';
		    			    
		    	} 
		    		else grid[i][j] = ' ';
		    		}	
		    	}
		    	return grid;
		    }
		    
		    
//********************************************************************************
		    
		    static void cellOutline(char grid[][])
		    {
		    	 System.out.print("+");
			    	
		    	 for (int i = 0; i < grid[0].length; i++)
			    		System.out.print("---+");
			    
		    	 System.out.println();
		    }

//********************************************************************************
		    
		    static void outputStarGrid(char grid[][],int count)
		    {
		    	System.out.println("Array "+count);
		    	
		    	cellOutline(grid);
		    	
		    	for(int i = 0; i < grid.length; i++)
		    	{
		    		System.out.print("| ");
		    		
		    	for(int j = 0; j < grid[0].length; j++)
		    		System.out.print(grid[i][j]+" | ");
		    		System.out.println();
		    	
		    		cellOutline(grid);
		    	}
		    }

//********************************************************************************		    

}
