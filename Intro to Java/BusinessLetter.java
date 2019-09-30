import javax.swing.JOptionPane;

/*
 * April 11th Part 2 Business Letter
 */
public class BusinessLetter 
{

	public static void main(String[] args) 
	{
	
		String name;
		String Firstname="";
		char c = Firstname.charAt(0);
		c=Character.toUpperCase(c);
		//Firstname.charAt(0) = c;
		String Lastname="";
		int lengthofname = 0;
		
		name=JOptionPane.showInputDialog("Enter Customer's first and last name ");
		while(lengthofname<name.length())
		{
			if(name.charAt(lengthofname)==' ')
			{
				Firstname=name.substring(0, lengthofname);
				Lastname=name.substring(lengthofname+1, name.length());
				lengthofname=name.length();
			}	
			lengthofname=lengthofname+1;
		}
			JOptionPane.showMessageDialog(null,
				"Dear "+Firstname+",\nI am glad we are on a first name basis now"+
				"\nbecasue I would like the oppourtunity to"+
				"\ntalk to you about an affordable insurance plan"+
				"\nfor your entire "+Lastname+ " family."+
				"\n\nPlease call One Family Insurance today"+
				"\nat 1-800-555-One1");
	}

}
