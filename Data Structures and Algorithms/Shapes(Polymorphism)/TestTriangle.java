public class TestTriangle	
{
public static void main (String [ ] args)	
{
Triangle Triangle = new Triangle(1,1.5,1);
System.out.println("The Triangle Sides are "  + Triangle.toString());	
System.out.println("The Triangle’s Area is "  + Triangle.getArea());
System.out.println("The Triangle’s Perimeter is " +  Triangle.getPerimeter());
System.out.println("The Triangle's Color is " + Triangle.getColor());
System.out.println("The Triangle is " + Triangle.isFilled());
}
}
