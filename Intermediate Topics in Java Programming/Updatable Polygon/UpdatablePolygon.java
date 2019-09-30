/*
 * Name: Tyler Cromack
 * Course Number: CSC-112
 * Course Name: Intermediate Topics in Java
 * Problem Number: HW#8 Updatable Polygon 
 * Draws the Polygon
 */

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;

public class UpdatablePolygon extends BorderPane 
{
	private int sides = 3;

	private void paint() 
	{
		this.getChildren().clear();

		double radius = 225;
		double centerX = this.getWidth() / 2, centerY = this.getHeight() / 2;
		Text sideCount = new Text(sides + " Sided Polygon");
		BorderPane.setAlignment(sideCount, Pos.TOP_CENTER);
		Polygon polygon = new Polygon();
		polygon.setFill(Color.CORAL);
		polygon.setStroke(Color.BLACK);
		ObservableList<Double> list = polygon.getPoints();

		for (int i = 0; i < sides; i++) 
		{
			list.add(centerX + radius * Math.cos(2 * i * Math.PI / sides));
			list.add(centerY - radius * Math.sin(2 * i * Math.PI / sides));
		}

		polygon.setRotate(270);
		this.setCenter(polygon);
		this.setTop(sideCount);
	}

	public void add() 
	{
		sides++;
		paint();
	}

	public void subtract() 
	{
		if (sides > 3)
			sides--;
		paint();
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
