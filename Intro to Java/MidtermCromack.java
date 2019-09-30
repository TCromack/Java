/*increment by 25k,intrest by .25
 * = LoanAmount*(Rate/NumberOfPayments)/(1-(1+Rate/NumberOfPayments)* Math.pow(-NumberOfPayments, NumberOfYears);
 * Midterm Exam
 * By: Tyler Cromack
 * 
 */
import javax.swing.JOptionPane;

import java.text.DecimalFormat;
public class MidtermCromack 
{

	public static void main(String[] args) 
	{		double Rate;
	double NumberOfPayments = 12;
	double NumberOfYears = 20;
	double Rate1 = 3;
	double Payment;
	double loopPer;
	double endloopPer=4.51;
		String NumT,NumT2;
		int Num;
		int count;
		int loopval;
			DecimalFormat dollar = new DecimalFormat("$###,##0.00");	
			double endvalue = 250001;
			double LoanAmount, YearlyRate, MonthlyRate, Years, NumPayments,LoanPayments;
			double Temp1, Temp2, Temp3, Temp4, Temp5;
			//Get Loan Amount
			String LAText = JOptionPane.showInputDialog("Enter The Loan Amount");
			LoanAmount = Double.parseDouble(LAText);
			
			//Get Yearly Rate in percent
			do
				{NumT2 = JOptionPane.showInputDialog("Enter The Intrest Rate. \n Ex:4.5% Do not type the % sign.");
			YearlyRate = Double.parseDouble(NumT2);}
			while ((YearlyRate <1) || YearlyRate >16);
			//Get Number Of Years
			//String YearsText = JOptionPane.showInputDialog("Enter The Number Of Years");
			//Years = Double.parseDouble(YearsText);
			
			do
			{
				NumT = JOptionPane.showInputDialog("Please enter an amount of years greater than 0 and less than 41 ");
				Years = Integer.parseInt(NumT);
				}
			while ((Years < 0) || Years >41);
			if ((LoanAmount > 0)&&(YearlyRate >= 0)&&(Years > 0))
				for(count=1; count <= Years; count++)
			{
				// When all values are good
				MonthlyRate = YearlyRate/1200.00;
				NumPayments = Years * 12;
				
				//Calculate Variables
				Temp1 = 1 + MonthlyRate;
				Temp2 = Math.pow(Temp1, NumPayments);
				Temp3 = 1 / Temp2;
				Temp4 = 1 - Temp3;
				Temp5 = MonthlyRate / Temp4;
				LoanPayments = LoanAmount * Temp5;
				System.out.println("Your monthly payment is " + dollar.format(LoanPayments));	
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("Loan Amount"+"\tRate"+"\t3\t3.25\t3.5\t3.75\t4\t4.25\t4.5");
				System.out.println("-----------------------------------------------------------------------------");
				
				
				//Could not get the computer to do the below work for me kept getting Nan or $0.00
				for(loopval = 100000;loopval < endvalue;loopval += 25000)
					if (loopval <250001)
						
					{ System.out.println("" + dollar.format(loopval) + ("\t\t"));}//I tried to add this to it but it gave me errors.>+ dollar.format(loopval*(Rate1/NumberOfPayments)/(1-(1+Rate1/NumberOfPayments)* Math.pow(-NumberOfPayments, NumberOfYears))))
				for(loopPer=3;loopPer < endloopPer; loopPer =+ .25)
					if(loopPer>4.75)
					{}
					
						
				{
				
				}
					
			
		
		}

	








}}

