

public class Rectangle extends Shape {
  private double length;
  private double width;

  public Rectangle() {
  }

  public Rectangle(double width, double height) {
    this.width = width;
    this.length = height;
  }

  public Rectangle(double width, double height, String color, boolean filled) {
	super(color, filled);
    this.width = width;
    this.length = height;
  }

  /** Return width */
  public double getWidth() {
    return width;
  }

  /** Set a new width */
  public void setWidth(double width) {
    this.width = width;
  }

  /** Return height */
  public double getLength() {
    return length;
  }

  /** Set a new height */
  public void setHeight(double height) {
    this.length = height;
  }

  /** Return area */
  public double getArea() {
    return width * length;
  }

  /** Return perimeter */
  public double getPerimeter() {
    return 2 * (width + length);
  }
}
