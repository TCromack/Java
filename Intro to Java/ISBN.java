/*
 * Isbn
 * Tyler Cromack
 * March 3 2016
 */
import java.util.Scanner;
public class ISBN 
{

	public static void main(String[] args) 
	{
		
		Scanner input = new Scanner(System.in);

        System.out.print("Enter the first 12 digits of an ISBN-13 as a string: ");
        String isbn = input.next();

        if (isbn.length() != 12) 
        {
            System.out.println(isbn + " is an invalid input.");
            System.exit(0);
        }

        int checkSum = 0;
        for (int j = 0; j < isbn.length(); j++) 
        {

            if ((j + 1) % 2 == 0) {
                checkSum +=  (isbn.charAt(j) - '0') * 3;

            } else 
            {
                checkSum  += isbn.charAt(j) - '0';
            }
        }
        checkSum %= 10;
        checkSum = 10 - checkSum;
        if (checkSum == 10) isbn += "0";
        else  isbn += checkSum;

        System.out.println("The ISBN-13 number is " + isbn);
	}
		

}
