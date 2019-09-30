

abstract public class TestShape {
  public static void main(String[] args) {
    Shape s1 = new Circle(1);
    System.out.println("A circle " + s1);
    System.out.println("The color is " + s1.getColor());
    System.out.println("The area is " + s1.getArea());
    System.out.println("The perimeter is " + s1.getPerimeter());
    Circle circle = (Circle)s1;
    System.out.println("The radius is " + circle.getRadius());
    System.out.println("The diameter is " + circle.getDiameter());
    
    Shape s2 = new Rectangle(2, 4);
    System.out.println("\nA rectangle " + s2);
    System.out.println("The color is " + s2.getColor());
    System.out.println("The area is " + s2.getArea());
    System.out.println("The perimeter is " + s2.getPerimeter());
    Rectangle rect = (Rectangle)s2;
    System.out.println("The length is " + rect.getLength());
    System.out.println("The diameter is " + rect.getWidth());
    
    Shape s3 = new Triangle(10, 8, 3);
    System.out.println("\nA triangle " + s3);
    System.out.println("The color is " + s3.getColor());
    System.out.println("The area is " + s3.getArea());
    System.out.println("The perimeter is " + s3.getPerimeter());
    Triangle tri = (Triangle)s3;
    System.out.println("Side 1 is " + tri.getSide1());
    System.out.println("Side 2 is " + tri.getSide2());
    System.out.println("Side 3 is " + tri.getSide3());
      
  }
}
