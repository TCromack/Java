/*
 * Name: Tyler Cromack
 * Course Number: CSC-112
 * Course Name: Intermediate Topics in Java
 * Problem Number: HW#10 Quadratic Equation
 * Quadratic Equation Client
 */
 
 
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
 
 
public class QuadraticClient extends Application
{
 
    //Setters
    private void setA()
    {
        this.a = Double.parseDouble(coeffA.getText());
    }
 
    private void setB()
    {
        this.b = Double.parseDouble(coeffB.getText());
    }
 
    private void setC()
    {
        this.c = Double.parseDouble(coeffC.getText());
    }
 
    //Getters
    private double getA()
    {
        return a;
    }
 
    private double getB()
{
        return b;
    }
 
    private double getC()
    {
        return c;
    }
   
    //Globals
    int status;
    double a;
    double b;
    double c;
   
    TextField coeffA = new TextField();
    TextField coeffB = new TextField();
    TextField coeffC = new TextField();
    TextField firstR = new TextField();
    TextField secondR = new TextField();
 
    public static void main(String[] args)
    {
        launch(args);
    }
 
    public void start(Stage primaryStage)
    {
        BorderPane bPane = new BorderPane();
        bPane.setTop(getInput());
        bPane.setCenter(btnCalc());
        bPane.setBottom(getOutput());
 
        Scene scene = new Scene(bPane, 500, 150);
 
        primaryStage.setTitle("Quadractic Client");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
 
    }
 
    // Set Input Box
    private HBox getInput()
    {
        HBox input = new HBox(15);
        input.setPadding(new Insets(10, 10, 10, 10));
        input.setSpacing(10);
        coeffA.setPromptText("Enter Coefficient A");
        coeffB.setPromptText("Enter Coefficient B");
        coeffC.setPromptText("Enter Coefficient C");
        ;
        input.getChildren().addAll(new Label("A"), coeffA, new Label("B"), coeffB, new Label("C"), coeffC);
        input.setAlignment(Pos.CENTER);
 
        return input;
    }
 
    // Set Calculate Button
    private Button btnCalc()
    {
        Button btnCalc = new Button();
        btnCalc.setText("Calculate");
        EventHandler<ActionEvent> clickedOn = e ->
        {
            status = 0;
            try
            {
                setA();
                setB();
                setC();
            } catch (Exception ex)
            {
                status = -1;
            }
            runClient();
        };
 
        btnCalc.setOnAction(clickedOn);
 
        return btnCalc;
    }
 
    // Set Output Box
    private HBox getOutput()
    {
        HBox output = new HBox();
        output.setPadding(new Insets(10, 10, 10, 10));
        output.setSpacing(25);
        firstR.setEditable(false);
        secondR.setEditable(false);
        output.getChildren().addAll(new Label("Root 1"), firstR, new Label("Root 2"), secondR);
        output.setAlignment(Pos.CENTER);
 
        return output;
    }
 
    // Connect to the server and run commands
    void runClient()
    {
 
        Socket client;
        DataOutputStream output;
        DataInputStream input;
 
        try
        {
            client = new Socket("cs.stcc.edu", 5004);
 
            input = new DataInputStream(client.getInputStream());
            output = new DataOutputStream(client.getOutputStream());
 
            output.writeDouble(getA());
            output.flush();
            output.writeDouble(getB());
            output.flush();
            output.writeDouble(getC());
            output.flush();
 
            if (status != -1)
            {
                status = input.readInt();
                if (status == 0)
                {
                    firstR.setText("Contains Complex Roots");
                    secondR.setText("Contains Complex Roots");
                }
                else if (status == 1)
                {
 
                    firstR.setText("" + input.readDouble());
                    secondR.setText("Contains Complex Roots");
                }
                else if (status == 2)
                {
 
                    firstR.setText("" + input.readDouble());
                    secondR.setText("" + input.readDouble());
                }
                else if (status == -1)
                {
                    firstR.setText("Coeff A cannot be zero");
                    secondR.setText("Cannot divide by zero");
                }
            }
            else
            {
                firstR.setText("Invalid Input");
                secondR.setText("Invalid Input");
            }
 
            try
            {
                input.close();
            }
            catch (Exception e)
            {
            }
 
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}