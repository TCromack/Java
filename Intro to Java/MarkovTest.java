/*
 * By:Tyler Cromack
 * Markov Array Test and Sort.
 */
import java.util.Scanner;

public class MarkovTest 
{

	public static void main(String[] args) 
	{
		double[][] Matrix = inputMatrix(3,3);
		//See If Valid
		if(isTrue(Matrix))
			System.out.println("Valid Markov Matrix.");
		else
			System.out.println("This is not a Markov Matrix");
		SortRows(Matrix);
		SortCol(Matrix);
		
	}	
	
//---------------------- Sort By Rows --------------------------------------------------------------
	
	public static void SortRows(double[][] MatrixR)
	{   System.out.println("\nYour array sorted by row");
		for (int row = 0; row < MatrixR.length; row++){
			for(int column = 0; column < MatrixR[0].length; column++) {
				 for (int x = column + 1; x< MatrixR[0].length; x++){
				   if(MatrixR[row][x]<MatrixR[row][column])
					{
					double temp=MatrixR[row][column];
					MatrixR[row][column] = MatrixR[row][x];
					MatrixR[row][x]=temp;
					}
				}
			}
		 }
	//Print Sorted Rows
	for (int row = 0; row < MatrixR.length; row++){
		for (int column = 0; column < MatrixR[0].length; column++){
			System.out.print(MatrixR[row][column] + "  ");
			
			
		}
		System.out.println();
		}
	}
//--------------------------- Sort By Column ----------------------------------------------------------
	
	public static void SortCol(double[][] MatrixC)
	{	System.out.println("\nYour array sorted by columns");
		for (int row = 0; row < MatrixC.length; row++){
			for(int column = 0; column < MatrixC[0].length; column++) {
				 for (int columnTwo = column + 1; columnTwo< MatrixC[0].length; columnTwo++){
				   if(MatrixC[row][columnTwo]<MatrixC[row][column])
					{
					double temp=MatrixC[row][column];
					MatrixC[row][column] = MatrixC[row][columnTwo];
					MatrixC[row][columnTwo]=temp;
					}
				}
			}
		 }
	//Print Sorted Columns
	for (int column = 0; column < MatrixC.length; column++){
		for (int row = 0; row < MatrixC[0].length; row++){
			System.out.print(MatrixC[row][column] + "  ");
			
			
		}
		System.out.println();
		}
	}
	
//--------------------------- Get User Input ----------------------------------------------------------
	
	public static double[][] inputMatrix(int row, int column) 
	{
		Scanner input = new Scanner(System.in);
		double[][] matrix = new double[row][column];
		for (int i = 0; i < row; i++) 
		{
			System.out.printf("Enter Row %d: ", i + 1);
			for (int j = 0; j < column; j++)
				matrix[i][j] = input.nextDouble();
		}
		return matrix;
	}
	
//------------------------ Check If Valid -------------------------------------------------------------
	
	public static boolean isTrue(double[][] matrix)
	{
		for (int i = 0; i < matrix[0].length; i++) 
		{
			double sum = 0;
			for (int j = 0; j < matrix.length; j++)
				sum += matrix[j][i];
			if (sum != 1)
				return false;
		}
		return true;
	}
	
//--------------------------------------------------------------------------------------
	
}
