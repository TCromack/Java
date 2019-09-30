public class Triangle extends GeometricObject {
private double side1 = 1.0;
private double side2 = 1.0;
private double side3 = 1.0;
 
 
public Triangle(){
}
 
public Triangle(double s1, double s2, double s3)  {
    this.side1 = s1;
    this.side2 = s2;
    this.side3 = s3;
    isTriangle();
}
 
public Triangle(double s1, double s2, double s3, String color, boolean filled) {
    super(color, filled);
    this.side1 = s1;
    this.side2 = s2;
    this.side3 = s3;
  }
 
public boolean isTriangle() throws IllegalArgumentException{
    if (side1 <= 0 || side2 <= 0 || side3 <= 0)
    throw new IllegalArgumentException("A side cannot be zero or negative.");
    else if (side1+side2 <= side3 || side2+side3 <= side1 || side3+side1 <= side2)
    throw new IllegalArgumentException("Two added sides must be greater than the third side.");
    else return true;
}
 
public double getSide1() {
    return side1;
  }
 
public double getSide2() {
    return side2;
  }
 
public double getSide3() {
    return side3;
  }
 
public double getArea(){
    double s = (side1+side2+side3)/2;
    return (int)(Math.sqrt(s*(s-side1)*(s-side2)*(s-side3))*1000)/1000.0;
}
 
public double getPerimeter(){
    return side1+side2+side3;
}
 
public String toString(){
return "shape of color " + super.getColor() + " and filled: " + super.isFilled()
+ " was created on " + super.getDateCreated() + ". \n\nSide 1: " + getSide1() +
"\nSide 2: " + getSide2() + "\nSide 3: " + getSide3() + "\n\nArea: " + getArea()
+ "\nPerimeter: " + getPerimeter() + "\n";
    }
}
