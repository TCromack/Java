/*
 * Name: Tyler Cromack
 * Course Number: CSC-112
 * Course Name: Intermediate Topics in Java
 * Problem Number: HW#1 Circle Class
 * This program creates and tests Circles based on user input 
 */
import java.util.Scanner;
 
public class TestCircle 
{    
    public static void main(String args[]) 
    {
        final String TITLE = "Test Circle V1.0";
        final String CONTINUE_PROMPT = "\nDo this again? [y/N] ";
       
        System.out.println("Welcome to " + TITLE);
        Scanner sc = new Scanner(System.in);
        do 
        {
            process(sc);
        } 
        while (doThisAgain(sc, CONTINUE_PROMPT));
        sc.close();
        System.out.println("Thank you for using " + TITLE);
    }

//*******************************************************************************************
    
    private static void process(Scanner sc) 
    {
        final String CENTER = "Enter the center coordinates (X, Y) and Radius for ";
        Circle c1 = createCircles(sc, CENTER + "Circle 1:");
        Circle c2 = createCircles(sc, CENTER + "Circle 2:");
        printCircles(c1, c2, sc);
    }

//******************************************************************************************* 
    
    private static void printCircles(Circle c1, Circle c2, Scanner sc) 
    {
        System.out.println("Circle 1:" + c1);
        System.out.println("Circle 2:" + c2);
        System.out.printf("Distance between Circle 1 center to Circle 2 center: %.2f units\n", c1.getDistance(c2));
        System.out.printf("\nCircle 1 contains Circle 2: %b\nCircle 2 contains Circle 1: %b\n\n"
                          + "Circle 1 overlaps Circle 2: %b\nCircle 2 overlaps Circle 1: %b\n\n",
                          c1.contains(c2), c2.contains(c1), c1.overlaps(c2), c2.overlaps(c1));
        arbitraryPoint(c1, c2, sc);
    }

//******************************************************************************************* 
      
    private static Circle createCircles(Scanner sc, String prompt) 
    {
        double x, y, radius;
        Circle circle;
        System.out.println(prompt);
        System.out.print("X:");
        x = sc.nextDouble();
        System.out.print("Y:");
        y = sc.nextDouble();
       
        do 
        {
            System.out.print("Radius:");
            radius = sc.nextDouble();
            System.out.println();
            sc.nextLine();
            if(radius <= 0)
               System.err.println("Error: Bad radius value. Please enter a radius with a postive non-zero integer.");
        } 
        while(radius <= 0);
        circle = new Circle(x, y, radius);
        return circle;
       
    }

//******************************************************************************************* 
      
    private static void arbitraryPoint(Circle c1, Circle c2, Scanner sc) 
    {
        System.out.println("Please enter an arbitrary point (pX, pY) to check if its location is in Circle 1 or 2:");
        System.out.print("Enter pX:");
        double pX = sc.nextDouble();
        System.out.print("Enter pY:");
        double pY = sc.nextDouble();
        sc.nextLine();
        System.out.printf("\nArbitrary point located in Circle 1: %b\nArbitrary point located in Circle 2: %b\n",
                          c1.contains(pX, pY), c2.contains(pX, pY));
    }

//******************************************************************************************* 
      
    private static boolean doThisAgain(Scanner sc, String prompt) 
    {
        System.out.print(prompt);
        String doOver = sc.nextLine();
        return doOver.equalsIgnoreCase("Y");
    }
}