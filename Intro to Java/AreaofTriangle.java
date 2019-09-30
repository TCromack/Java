/* Calculate area of non right triangle
 * Tyler Cromack 
 * March 23 2016
 */

import javax.swing.JOptionPane;
public class AreaofTriangle 
{

	public static void main(String[] args) 
	{
		int s1,s2,s3;
		s1 = positive(1);
		s2 = positive(2);
		s3 = positive(3);
		boolean valid = isvalid(s1,s2,s3);
		if (valid == true)
		{
			double area = ComputeArea (s1,s2,s3);
			System.out.println("The area of the triangle is "+(int)(area*100)/100.00);
		}
		else
			System.out.println("You did not enter a valid triangle");
	}
	
	//method to compute area of the triangle
	public static double ComputeArea(int a, int b, int c)
	{
		double s = (a+b+c)/2.0;
		double ans = Math.sqrt(s*(s-a)*(s-b)*(s-c));
		return ans;
	}
	
	//Check that each side is less than the sum of the other two sides
	public static boolean isvalid(int S1,int S2,int S3)
	{
		if((S1 < S2 + S3) && (S2 < S1 + S3) && (S3 < S1 + S2))
			return true;
		else
			return false;
	}
	
	//method to validate that each side is a positive integer
	public static int positive(int c)
	{
		int num;
		String numT;
		do 
		{
			numT = JOptionPane.showInputDialog("Enter The Value For Side "+ c +"\nThe Value must be greater than zero");
			num = Integer.parseInt(numT);
			
		}
		while (num <=0);
		return num;
	}
}
