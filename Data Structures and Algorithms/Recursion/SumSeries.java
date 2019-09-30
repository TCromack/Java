/*
 * Name: Tyler Cromack
 * Course Number: CSC-220
 * Course Name: Data Structures and Algorithms
 * Problem Number: HW#7 SumSeries
 * This program will use recursion to add the sum series of m(i) = i / (2i + 1)
 */

public class SumSeries 
{
    public static void main(String[] args) 
    {
    	System.out.println("Below is the Sum Series of m(i) = i / (2i + 1)");
    	System.out.println("-------------------------------");
    	
        for (int i = 1; i < 11; i++) 
        {
            System.out.println(sumSeries(i));
        }
    }

    public static double sumSeries(double d) 
    {
        if (d == 1)
        	return (d - 1.0) + d / (2.0 * d + 1.0);
        else
            return sumSeries(d - 1.0) + d / (2.0 * d + 1.0);
    }
}
