/*Bank Deposit Using Simple Interest Program
 * Created By: Tyler Cromack 9:05am Class
 */

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class Feb5Homework 
{

	

	public static void main(String[] args) 
	{
		
		DecimalFormat f = new DecimalFormat("$###,###.##");
		
		//Variables
		
		double A,I,P,R,t;
		R = 0.0425;
		
		//Get Simple Interest
		
		
		String hold = JOptionPane.showInputDialog("Enter The Principal Amount");
		P = Double.parseDouble(hold);
		String hold1 = JOptionPane.showInputDialog("Enter The Total Years");
		t = Double.parseDouble(hold1);
		
		//Calculate Interest and Total Amount
		
		I = P*R*t;
		A = P + I;
		
		//Display Sum
		
		System.out.println("The deposit of " + f.format(P) + " for " + t + " years will produce a sum of " + f.format(I) + " Therefore The Total Amount will be " + f.format(A) );
		
	}

}
