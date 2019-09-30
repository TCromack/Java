/*
 * Name: Tyler Cromack
 * Course Number: CSC-112
 * Course Name: Intermediate Topics in Java
 * Problem Number: HW#8 Updatable Polygon 
 * Driver for the Updatable Polygon Class
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
 
public class UpdatablePolygonDriver extends Application 
{
    public void start(Stage primaryStage) 
    {
    	final double PANEWIDTH = 600;
		final double PANEHEIGHT = 600;
    	
        HBox hBox = new HBox();
        hBox.setSpacing(20);
        hBox.setAlignment(Pos.CENTER);
        Button btShrink = new Button("-");
        Button btEnlarge = new Button("+"); 
        hBox.getChildren().addAll(btShrink, btEnlarge);
        
        UpdatablePolygon updatePolygon = new UpdatablePolygon();
        btEnlarge.setOnAction(e -> updatePolygon.add());
        btShrink.setOnAction(e -> updatePolygon.subtract());
       
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(updatePolygon);
        borderPane.setBottom(hBox);
 
        Scene scene = new Scene(borderPane, PANEWIDTH, PANEHEIGHT);
        primaryStage.setTitle("Updatable Polygon"); 
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    public static void main (String[]args){
        launch(args);
    }
}
