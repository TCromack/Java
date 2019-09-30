import javax.swing.JOptionPane;

/*
 * This program will approximate pi starting from 101 to 901 by 100
 * By:Tyler Cromack
 */
public class PiCalculator 
{

	public static void main(String[] args) 
	{	//User input response
		System.out.printf("Your value approximates to: "+"%-10.4f\n",ComputePiUser(0));
		System.out.println("If you entered a value listed below it would have returned the following.");
		//Regular Table
		System.out.println("i"+ "\tm(i)");
		System.out.println("---------------");
		  
		for (int i = 101; i <= 901; i+=100) 
		  {
		   System.out.printf("%-8d%-10.4f\n",i,ComputePi(i));
		  }
	}

	public static double ComputePi(int value) 
	{
		  double pi=0;
		  
		  for (int i = 1; i <= value; i++) 
		  {
		   pi += Math.pow(-1, i + 1) / (2 * i - 1);
		  }
		  return 4*pi;
	}
	
	public static double ComputePiUser(int valueUser)
	{
		
		String numT;
		do 
		{
			numT = JOptionPane.showInputDialog("Enter a value "+"\nThe Value must be greater than zero");
			valueUser = Integer.parseInt(numT);	
		}
		while (valueUser <=0); 
		
		double pi=0;
		  
		  for (int i = 1; i <= valueUser; i++) 
		  {
		   pi += Math.pow(-1, i + 1) / (2 * i - 1);
		  }
		  return 4*pi;
	}
}
