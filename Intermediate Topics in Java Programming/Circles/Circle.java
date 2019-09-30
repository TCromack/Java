/*
 * Name: Tyler Cromack
 * Course Number: CSC-112
 * Course Name: Intermediate Topics in Java
 * Problem Number: HW#1 Circle Class
 * Drives the main TestCircle.Java in order to test values given by the user
 */

public class Circle 
{
	private double x; 
	private double y; 
	private double radius;
	

	Circle() 
	{
		x = 0;
		y = 0;
		radius = 0;
		
	}

	Circle(double x, double y, double radius) 
	{
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public double getX() 
	{
		return x;
	}

	public double getY() 
	{
		return y;
	}

	public double getRadius() 
	{
		return radius;
	}

	public double getArea() 
	{
		return Math.PI * Math.pow(radius, 2);
	}
	
	public double getDistance(Circle c) 
	{
        double distance = Math.sqrt(Math.pow((c.x - this.x), 2) + Math.pow((c.y - this.y), 2));
        return distance;
    }

	public double getPerimeter() 
	{
		return 2 * Math.PI * radius;
	}
	
	public boolean contains(double x, double y) 
	{
		return Math.sqrt(Math.pow(x - this.x, 2) + 
			   Math.pow(y - this.y, 2)) < this.radius;
	}

	public boolean contains(Circle circle) 
	{
		return Math.sqrt(Math.pow(circle.getX() - this.x, 2) + 
			   Math.pow(circle.getY() - this.y, 2)) <= Math.abs(this.radius - circle.getRadius());
	}

	public boolean overlaps(Circle circle) 
	{
		return Math.sqrt(Math.pow(circle.getX() - this.x, 2) + 
			   Math.pow(circle.getY() - this.y, 2)) <= this.radius + circle.getRadius();
	}
	
	public String toString() 
	{
	    return String.format("\nArea = %.2f units\nPerimeter = %.2f units\nRadius = %.2f units\nCenter coordinates = (%.2f, %.2f)\n",
	    					 getArea(), getPerimeter(), getRadius(), getX(), getY());
    }
}