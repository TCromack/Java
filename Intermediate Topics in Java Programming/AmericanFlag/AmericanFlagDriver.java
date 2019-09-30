/*
 * Name: Tyler Cromack
 * Course Number: CSC-112
 * Course Name: Intermediate Topics in Java
 * Problem Number: HW#7 American Flag Driver
 * The Driver for the American Flag class
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AmericanFlagDriver extends Application {

	public void start(Stage primaryStage) throws Exception {

		final double PANEWIDTH = 570;
		final double PANEHEIGHT = 310;

		Scene scene = new Scene(new AmericanFlag(), PANEWIDTH, PANEHEIGHT);
		primaryStage.setTitle("American Flag");
		primaryStage.setScene(scene);
		primaryStage.setResizable(true);
		primaryStage.show();
	}

	public static void main(String args[]) {
		launch(args);
	}
}