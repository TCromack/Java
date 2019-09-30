/*
 * Name: Tyler Cromack
 * Course Number: CSC-112
 * Course Name: Intermediate Topics in Java
 * Problem Number: HW#9 Set Clock Time and Animate
 * Animates and drives the ClockPane class
 */
 
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
 
public class DisplayClock extends Application
{
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {
        // Create a clock and a label
        ClockPane clock = new ClockPane();
 
        // Buttons
        HBox btnPane = new HBox();
        btnPane.setAlignment(Pos.CENTER);
        Button btnStart = new Button("Start");
        Button btnStop = new Button("Stop");
        Button btnPlayCurrent = new Button("Load Current Time & Start");
        Button btnCurrent = new Button("Just Load Current Time");
        Button btnResetClock = new Button("Reset Clock");
        btnPane.getChildren().addAll(btnStart, btnStop, btnPlayCurrent, btnCurrent, btnResetClock);
 
        // Text Clock
        HBox textClockPane = new HBox();
        textClockPane.setAlignment(Pos.CENTER);
        textClockPane.setPadding(new Insets(10, 10, 10, 10));
        TextField hourText = new TextField();
        hourText.setMaxSize(50, 0);
        TextField minText = new TextField();
        minText.setMaxSize(50, 0);
        TextField secText = new TextField();
        secText.setMaxSize(50, 0);
        textClockPane.getChildren().addAll(new Text("Hours : "), hourText, new Text(" Minutes : "), minText, new Text(" Seconds : "), secText);
 
        // updateClock eventHandler
        EventHandler<ActionEvent> eventHandler = e ->
        {
            clock.tick();
            updateClock(clock, hourText, minText, secText);
        };
 
        // Animate the Clock
        Timeline animate = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
        animate.setCycleCount(Timeline.INDEFINITE);
        animate.play();
 
        // Button Handlers
        btnStart.setOnAction(e -> animate.play());
        btnStop.setOnAction(e -> animate.pause());
 
        btnCurrent.setOnAction(e ->
        {
            animate.pause();
            clock.setCurrentTime();
            updateClock(clock, hourText, minText, secText);
        });
 
        btnPlayCurrent.setOnAction(e ->
        {
            animate.play();
            clock.setCurrentTime();
            updateClock(clock, hourText, minText, secText);
        });
 
        btnResetClock.setOnAction(e ->
        {
            animate.pause();
            clock.resetTime();
            updateClock(clock, hourText, minText, secText);
        });
 
        // Clear Text Fields when clicked on
        hourText.setOnMousePressed(e -> hourText.setText(""));
        minText.setOnMousePressed(e -> minText.setText(""));
        secText.setOnMousePressed(e -> secText.setText(""));
 
        // Set KeyEvent
        textClockPane.setOnKeyPressed(e ->
        {
            if (e.getCode() == KeyCode.ENTER)
            {
                try {
                    int hour = Integer.parseInt(hourText.getText());
                    int min = Integer.parseInt(minText.getText());
                    int sec = Integer.parseInt(secText.getText());
                    if (hour <= 12 && hour >= 0 && min <= 59 && min >= 0 && sec <= 59 && sec >= 0)
                    {
                        clock.setHour(hour);
                        clock.setMinute(min);
                        clock.setSecond(sec);
 
                    }
                    else
                    {
                        hourText.setText(" ");
                        textClockPane.fireEvent(e);
                    }
 
                    }
                    catch (Exception ex) {
                        hourText.setText("Invalid");
                        minText.setText("Input");
                        secText.setText("Given");
                        animate.pause();
                }
            }
        });
 
        // BorderPane
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(btnPane);
        borderPane.setCenter(clock);
        borderPane.setBottom(textClockPane);
 
        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 500, 500);
        primaryStage.setTitle("DisplayClock"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.setResizable(false);
        primaryStage.show(); // Display the stage
    }
 
    public void updateClock(ClockPane clock, TextField hourText, TextField minText, TextField secText)
    {
        clock.setHour(clock.getHour() % 12);
       
        if (!hourText.isFocused() && !minText.isFocused() && !secText.isFocused())
        {
            hourText.setText(Integer.toString(clock.getHour()));
            minText.setText(Integer.toString(clock.getMinute()));
            secText.setText(Integer.toString(clock.getSecond()));
        }
    }
 
    public static void main(String[] args) {
        launch(args);
    }
 
}