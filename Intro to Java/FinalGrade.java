import javax.swing.JOptionPane;

/*This program will calculate the student grade in our java class
 * Tyler Cromack
 * Feb 10 2016
 */

import javax.swing.JOptionPane;
public class FinalGrade 
{

	public static void main(String[] args) 
	{
char Grade = ' ' ;
//Get Final exam score
String FinalText = JOptionPane.showInputDialog("Enter Final exam score ");
double Final = Double.parseDouble(FinalText);

//Get Midterm exam score
String MidText = JOptionPane.showInputDialog("Enter Midterm exam score ");
double Mid = Double.parseDouble(MidText);

//Get Final exam score
String HWText = JOptionPane.showInputDialog("Enter homework exam score ");
double HW = Double.parseDouble(FinalText);


if((Final >=100) &&(Final >=0) && (Mid >=100) &&(Mid >=0) && (HW >=100) && (HW >=0))
{
	//Calculate average
	double Avg = HW*0.40 + Mid*0.30 + Final*0.30;
		
		if(Avg >= 90)
			Grade = 'A';
		else
			if(Avg >= 80)
				Grade = 'B';
			else
				if(Avg >= 70)
					Grade = 'C';
				else
					if(Avg >= 60)
						Grade = 'D';
					else
						if(Avg >= 50)
							Grade = 'F';
}	
	else
		JOptionPane.showMessageDialog(null, "You have entered an Invalid value(s) ");
	
	//Print Grade
	if (Grade =='F')
		JOptionPane.showMessageDialog(null,"Sorry you did not pass the class. Good Luck next semester");
	else
		if(Grade != ' ')
			JOptionPane.showMessageDialog(null, "Congrats your grade for the class is "+ Grade);
	}}
	
	

