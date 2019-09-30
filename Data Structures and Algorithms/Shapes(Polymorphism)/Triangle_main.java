/*
 * Name: Tyler Cromack
 * Course Number: CSC-220
 * Course Name: Data Structures and Algorithms
 * Problem Number: HW#5 The Triangle Class (Polymorphism)
 * This program will determine whether the given values are a Triangle 
 * as well as determine its other properties from its Super class Shape.
 */



//************************************************************
public class Triangle extends Shape
{
private double side1 = 1.0;
private double side2 = 1.0;
private double side3 = 1.0;

//************************************************************
public Triangle( ) 
{

}

//************************************************************
public Triangle (double side1, double side2, double side3)
{
	this.side1=side1; 
	this.side2=side2; 
	this.side3=side3;
	triRule();
}

//************************************************************
public Triangle (double side1, double side2, double side3, String color, boolean filled)
{	
	super(color,filled);
	this.side1=side1; 
	this.side2=side2; 
	this.side3=side3;
	triRule();
}

//************************************************************
//Getters
public double getSide1( )  
{
	return side1;
}

public double getSide2( )  
{
	return side2;
}

public double getSide3( )  
{
	return side3;
}

//************************************************************
//Setters
public void setSide1 (double side1)  
{
	this.side1=side1;
}

public void setSide2 (double side2) 
{
	this.side2=side2;
}

public void setSide3 (double side3)  
{
	this.side3=side3;
}

//************************************************************
public double getPerimeter( ) 
{
	return this.side1+this.side2+this.side3;
}

//************************************************************
public double getArea( ) 
{
	double s = getPerimeter()/2;
    return Math.sqrt(s * (s - this.side1) * (s - this.side2) * (s - this.side3));
}

//************************************************************
public boolean triRule() throws IllegalArgumentException
{
    if (this.side1 <= 0 || this.side2 <= 0 || this.side3 <= 0) 
    throw new IllegalArgumentException("\nINVALID VALUE: A side must be a positive non zero number!");
    
    else if (this.side1 + this.side2 <= this.side3 || this.side1 + this.side3 <= this.side2 || this.side2 + side3 <= this.side1)
    throw new IllegalArgumentException("\nTRIANGLE INEQUALITY ERROR:\nThe sum of the lengths of any two sides must be greater than \nor equal to the length of the third side in order for the values to be a triangle.");
    
    else return true;
}

//************************************************************
public String toString( ) 
{
	return super.toString() + "\nSide 1 = " + side1 + "\nSide 2 = " + side2 + "\nSide 3 = " + side3;
}

//************************************************************
}


