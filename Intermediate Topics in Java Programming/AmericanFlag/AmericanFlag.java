/*
 * Name: Tyler Cromack
 * Course Number: CSC-112
 * Course Name: Intermediate Topics in Java
 * Problem Number: HW#7 American Flag 
 * Draws the American Flag
 */
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class AmericanFlag extends Pane 
{
	private void paint() 
	{
		this.getChildren().clear();
		paintStripes();
		paintUnion();
		paintStars();
	}

	private void paintStripes() 
	{
		for (int i = 0; i < 7; i++) 
		{	
			Rectangle stripes = new Rectangle();
			stripes.setX(10);
			stripes.setWidth(getWidth() - 20);
			stripes.setHeight((getHeight() - 20) / 13.0);
			stripes.setY((getHeight() - 20) / 13.0 * (2 * i) + 10);
			stripes.setFill(Color.RED);
			this.getChildren().add(stripes);
		}
	}

	private void paintUnion() 
	{
		Rectangle union = new Rectangle();
		union.setX(10);
		union.setWidth(getWidth() / 2.2 - 20);
		union.setHeight((getHeight() - 20) * .53841);
		union.setY((10));
		union.setFill(Color.DARKBLUE);
		this.getChildren().add(union);
	}

	private void paintStars() 
	{
		for (int i = 0; i < 9; i++) 
		{
			double radius = Math.min(this.getHeight(), this.getWidth()) * 0.03;
			double centerY = (this.getHeight() / 6.5) * (0.3 * i + 0.65);
			int starCount = (i % 2 == 0) ? 6 : 5;
			
			for (int j = 0; j < starCount; j++) 
			{
				Polygon star = new Polygon();
				double centerX = (i % 2 == 0) ? ((this.getWidth() - 20) / 12) * (0.9 * j + 0.55) : ((this.getWidth() - 20) / 12) * (0.9 * j + 1);
				
				for (int k = 0; k < 5; k++) 
				{
					ObservableList<Double> list = star.getPoints();
					list.add(centerX + radius * Math.sin(6 * k * Math.toRadians(36)));
					list.add(centerY - radius * Math.cos(6 * k * Math.toRadians(36)));
				}
				
			star.setFill(Color.WHITE);
			this.getChildren().add(star);
			}
		}
	}

	@Override
	public void setWidth(double width) {
		super.setWidth(width);
		paint();
	}

	@Override
	public void setHeight(double height) {
		super.setHeight(height);
		paint();
	}
}