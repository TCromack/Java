/*
 * Name: Tyler Cromack
 * Course Number: CSC-112
 * Course Name: Intermediate Topics in Java
 * Problem Number: HW#12 IPLocation Phase2
 * IPLocation GUI With Lookup
 */
 
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.net.URLDecoder;
import java.sql.*;
 
public class IPLocationPhase2 extends Application
{
    private TextField ipTxt1;
    private TextField ipTxt2;
    private TextField ipTxt3;
    private TextField ipTxt4;
    private TextArea ipResult;
   
    private static final String DATABASE = "silvestri";
    private static final String USERNAME = "readonly";
    private static final String PASSWORD = "readonly";
     
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://cs.stcc.edu/" + DATABASE +
                            "?user=" + USERNAME + "&password=" + PASSWORD;
 
    @Override
    public void start(Stage primaryStage)
    {  
        BorderPane bPane = new BorderPane();
        bPane.setTop(getInput());
        bPane.setCenter(getOutput());
        Scene scene = new Scene(bPane, 450, 250);
        primaryStage.setTitle("IPLocationGUI");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
 
    private Button btnLocate()
    {
        Button btnLocate = new Button();
        btnLocate.setText("Locate");
        btnLocate.setOnAction(e -> run());
        return btnLocate;
    }
 
    private HBox getInput()
    {
        HBox input = new HBox();
        input.setSpacing(5);
        input.setPadding(new Insets(10, 15, 15, 10));
       
        Label iP = new Label("Enter IP Address : ");
        iP.setPadding(new Insets(3, 0, 0, 0));
        Label dot1 = new Label(" . ");
        dot1.setPadding(new Insets(10, 0, 0, 0));
        Label dot2 = new Label(" . ");
        dot2.setPadding(new Insets(10, 0, 0, 0));
        Label dot3 = new Label(" . ");
        dot3.setPadding(new Insets(10, 0, 0, 0));
       
        ipTxt1 = new TextField();
        ipTxt1.setMaxWidth(50);
        ipTxt2 = new TextField();
        ipTxt2.setMaxWidth(50);
        ipTxt3 = new TextField();
        ipTxt3.setMaxWidth(50);
        ipTxt4 = new TextField();
        ipTxt4.setMaxWidth(50);
 
        input.getChildren().addAll(iP, ipTxt1, dot1, ipTxt2, dot2, ipTxt3, dot3, ipTxt4, new Label("  "), btnLocate());
        input.setAlignment(Pos.TOP_RIGHT);
        return input;
    }
   
    private HBox getOutput()
    {
        ipResult = new TextArea();
        ipResult.setMaxWidth(440);
        ipResult.setEditable(false);
        HBox output = new HBox(ipResult);
        output.setPadding(new Insets(-5, 5, 10, 5));
        output.setAlignment(Pos.CENTER);
       
        return output;
    }
 
    private void run()
    {
        try
        {
            Class.forName(driver);
            System.out.println("Loaded driver");
       
            Connection conn = DriverManager.getConnection(url);
            System.out.println("Connected to database");
       
            Statement statement = conn.createStatement();
            String result = "";
           
            if (Integer.parseInt(ipTxt1.getText()) >= 0 && Integer.parseInt(ipTxt1.getText()) <= 255
                && Integer.parseInt(ipTxt2.getText()) >= 0 && Integer.parseInt(ipTxt2.getText()) <= 255
                && Integer.parseInt(ipTxt3.getText()) >= 0 && Integer.parseInt(ipTxt3.getText()) <= 255
                && Integer.parseInt(ipTxt4.getText()) >= 0 && Integer.parseInt(ipTxt4.getText()) <= 255)
            {
                String iP = ("IP : " + Integer.parseInt(ipTxt1.getText()) + "." + Integer.parseInt(ipTxt2.getText())
                + "." + Integer.parseInt(ipTxt3.getText()) + "." + Integer.parseInt(ipTxt4.getText()));
   
                ResultSet resultSet = statement.executeQuery("select CITY.name, C.name , lat, lng From ip4_" + Integer.parseInt(ipTxt1.getText())
                + " IP, cityByCountry CITY, countries C WHERE IP.country = C.ID AND IP.city = CITY.city AND b = "
                + Integer.parseInt(ipTxt2.getText()) + " AND c = " + Integer.parseInt(ipTxt3.getText()));
               
                while (resultSet.next())
                {
                      ipResult.setText(result = iP + "\n" + URLDecoder.decode(resultSet.getString("CITY.name") + " " + resultSet.getString("C.name")
                      + "\nLat: " + resultSet.getString("lat") + " " + "Lng: " + resultSet.getString("lng"), "UTF-8"));
                }
                 
                if (result.equals(""))
                {
                     result = iP + "\nIP Location Not Found";
                     ipResult.setText(result);
                }
            }
           
            else
            {
                ipResult.setText("IP values must be between 0 and 255!");
            }
           
            conn.close();
            System.out.println("Connection Closed");
        }
       
        catch (Exception e)
        {
            ipResult.setText("Invalid IP given " + e.getMessage());
        }
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}