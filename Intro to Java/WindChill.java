/*Program will calculate Wind chill
 * By Tyler Cromack 
 * Feb 11 2016 Homework
 */
import java.text.DecimalFormat;

import javax.swing.JOptionPane;
public class WindChill 
{

	public static void main(String[] args) 
	{ 
	DecimalFormat f = new DecimalFormat("###,###.##");
		
	double Windspeed, Temperature, Windchill;
	
	//User Input
	String TemperatureText = JOptionPane.showInputDialog("Enter The Temperature (Fahrenheit): ");
	Temperature = Double.parseDouble(TemperatureText);
	
	String WindspeedText = JOptionPane.showInputDialog("Enter The Wind Speed (Mph): ");
	Windspeed = Double.parseDouble(WindspeedText);
	
	
	//Calculate Wind chill
	if (Windspeed >= 2 && Temperature >= -58 && Temperature <= 41)
	{ Windchill = 35.74 + 0.6215 * Temperature + (0.4275 * Temperature - 35.75) * Math.pow(Windspeed, 0.16);
		
		//Show user answer
	System.out.println("The Wind Chill is " + f.format(Windchill)) ;
	}
	else
	  {
		//Show when any of the values are not valid
		System.out.println("The value(s) you have entered are invalid." );
	  }
	}
	

}
