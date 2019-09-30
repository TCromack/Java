import javax.swing.JOptionPane;

import java.text.DecimalFormat;
public class InternetPlans {

	public static void main(String[] args) {
		

		String packages = "Package A: For $29.99 per month 2GB of data is provided."
									+ " Additonal data is $10.00 per GB.\n "
										+"Package B: For $39.99 per month 4GB of data is provided."
											+ " Additonal data is $5.00 per GB. \n"
												+"Package C: For $49.99 per month unlimited data is provided.";

				String input1;
				String input2;
				String message1 = "Please enter the letter of your internet package";
				String message2 = "Please enter the data you have used this month";
				
				double a = 29.99;
				double b = 39.99;
				double c = 49.99;
				
				int data;
					
				String invalid = "Invalid Variable";
				
				char packages2;
				
				String total = "Your total is: $";
				
				DecimalFormat formatter = new DecimalFormat("#00.00");

				JOptionPane.showMessageDialog(null, packages);
				
				input1 = JOptionPane.showInputDialog(message1);
				packages2 = input1.charAt(0);
				
				input2 = JOptionPane.showInputDialog(message2); 
				data = Integer.parseInt(input2);
				
				switch(packages2)
					{
				case 'a':
				case 'A':
					if(data > 2 && data >1 && data <51);
					else 
					{
						JOptionPane.showMessageDialog(null,"Invalid");
					}
					{
						a += 10 * (data - 2);
					}
					JOptionPane.showMessageDialog(null, total + a);
					if(a>b)
					{
						System.out.println("If you switch to plan B, you will save $"+formatter.format(a-b));	
						}
						if(a>c)
						{
							System.out.println("If you switch to plan C, you will save $"+formatter.format(a-c));	
							}
							break;
					
				case 'b':
				case 'B':
					if(data > 3 && data >1 && data <51); 
					else 
					{
						JOptionPane.showMessageDialog(null,"Invalid");
					}
					{
						b += 5 * (data - 4);
					}
					
					JOptionPane.showMessageDialog(null, total + b);
					if(b>a)
					{System.out.println("If you switch to plan A, you will save $"+formatter.format(b-a));}
						if(b>c)
							{System.out.println("If you switch to plan C, you will save $"+formatter.format(b-c));} break;
					
				case 'c':
				case 'C':
					if(data >1 && data <51);
					else 
					{
						JOptionPane.showMessageDialog(null,"Invalid");
					}
					JOptionPane.showMessageDialog(null, total + c);
					if(c>a)
					{System.out.println("If you switch to plan A, you will save $"+formatter.format(c-a));}
						if(c>b)
							{System.out.println("If you switch to plan B, you will save $"+formatter.format(c-b));}
					break;
				
					default:
						JOptionPane.showMessageDialog(null, invalid);
						break;
		
				
					}
				System.exit(0);
						
						
			}

		}


	


