/*
 * This program will sort arrays.
 * By:Tyler Cromack
 */
//---------------------------------------------------------------------------------------------------
import javax.swing.JOptionPane;

public class ArrayMerge 
{

	public static void main(String[] args) 
	{	
		int[] Array1 = new int[50]; 
		int[] Array2 = new int[50];
		int[] Numbers = new int[100];
		int size1, size2;
		size1 = GetNumbers(Array1,1);
		size2 = GetNumbers(Array2,2);
		
		//Combine Arrays
		for (int c = 0; c < size1; c++)
			Numbers[c] = Array1[c];
		for (int c = 0; c < size2;c++)
			Numbers[c+size1] = Array2[c];
		
		//Print all arrays
		
				System.out.println("------------Array 1------------");
			for (int c = 0; c < size1; c++)
				System.out.println(Array1[c]);
					System.out.println("------------Array 2------------");
			for (int c = 0; c < size2; c++)
				System.out.println(Array2[c]);
					System.out.println("------------Sorted------------");	
		//Sort array values in order		
		int temp;
		boolean fixed=false;
		while(fixed==false)
		{
			fixed=true;
					
			for (int c = 0; c < (size1+size2)-1; c++)
			{
				if(Numbers[c]>Numbers[c+1])
					{
						temp = Numbers[c+1];
							
						Numbers[c+1]=Numbers[c];
							
						Numbers[c]=temp;
						fixed=false;	
						}
					}
				}
			for (int c = 0; c < size1+size2; c++)
						System.out.println(Numbers[c]);
	}
//---------------------------------------------------------------------------------------------------------
//Loading Arrays
	public static int GetNumbers(int [] arraylist1, int i)
	{
		String sizeT = JOptionPane.showInputDialog("Enter the number of values you would like to have in Array#"+i+"\n(The number of values must be less than 51)");
		int size = Integer.parseInt(sizeT);		
		
		for (int c=0; c < size; c++)
		{
			
		
		String NumT = JOptionPane.showInputDialog("Enter value#"+(c+1));
				int Num = Integer.parseInt(NumT);
				
				arraylist1[c] = Num;
		}
		
		
		return size;
		
		}
//----------------------------------------------------------------------------------------------------------	
	
}
