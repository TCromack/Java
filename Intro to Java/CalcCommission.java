import java.text.DecimalFormat;
public class CalcCommission 
{

	public static void main(String[] args) 
	{	System.out.println("\t   (Base Salary Is $5000.00)");
		System.out.println("Sale\t\tCommission\tTotal Income");
		System.out.println("---------------------------------------------------");
		DecimalFormat dollar = new DecimalFormat("$#,##0.00");
		int loopval;
		int endvalue=16000;
	
		
		for(loopval = 2000;loopval < endvalue;loopval += 1000)
			if (loopval < 5001 && loopval > 1999)
				
		{
			System.out.println("" + dollar.format(loopval) + "\t"  + dollar.format((loopval * 0.08)) + "\t\t" + dollar.format((5000  + loopval * 0.08)));
		}
			else if (loopval >5001 && loopval <10001)
				
			{
				System.out.println("" + dollar.format(loopval) + "\t"  + dollar.format((loopval * 0.10 - 100)) + "\t\t" + dollar.format((5000 + loopval * 0.1 - 100)));
			}
				
			
			else
			{
				System.out.println("" + dollar.format(loopval) + "\t"  + dollar.format((loopval * 0.12 - 300)) + "\t" + dollar.format((5000+ loopval * 0.12 - 300)));
			}
				
	}

}
