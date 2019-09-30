/*
 * Name: Tyler Cromack
 * Course Number: CSC-112
 * Course Name: Intermediate Topics in Java
 * Problem Number: HW#10 Quadratic Equation
 * Quadratic Equation Server
 */
 
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
 
 
public class QuadraticServer
{
    DataOutputStream output;
    DataInputStream input;
 
    static void pStr(String p)
    {
        System.out.println(p);
    }
 
    public static void main(String[] args)
    {
        QuadraticServer q = new QuadraticServer();
        q.runServer();
    }
 
    void runServer()
    {
        ServerSocket server;
        Socket connection;
 
        try
        {
            pStr("Creating server socket 5004 ...");
            server = new ServerSocket(5004);
            pStr("Server Online!");
 
            while (true)
            {
                pStr("Wating for connection");
                connection = server.accept();
                pStr("Done");
 
                ThreadConnect t = new ThreadConnect(connection);
                t.start();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
 
    public class ThreadConnect extends Thread
    {
        Socket connection;
        DataOutputStream output;
        DataInputStream input;
 
        ThreadConnect(Socket x)
        {
            connection = x;
        }
 
        public void run()
        {
            try
            {
            pStr("");
            pStr("Communicating with " + connection.getInetAddress() + " " + connection.getPort());
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            pStr("Time: " + dateFormat.format(date));
           
            this.input = new DataInputStream(this.connection.getInputStream());
            this.output = new DataOutputStream(this.connection.getOutputStream());
           
                try
                {
                    double a, b, c;
                    a = input.readDouble();
                    b = input.readDouble();
                    c = input.readDouble();
 
                    double temp = Math.sqrt(b * b - 4 * a * c);
                    double root1 = (-b + temp) / (2 * a);
                    double root2 = (-b - temp) / (2 * a);
                   
                    // divide by zero
                    if(a == 0)
                    {
                        pStr("Divide by Zero");
                        output.writeInt(-1);
                        output.flush();
                    }
                    // two real roots
                    else if (temp > 0)
                    {
                        pStr("Client has two Reals");
                        output.writeInt(2);
                        output.writeDouble(root1);
                        output.writeDouble(root2);
                        output.flush();
                    }
                    // one real root
                    else if (temp == 0)
                    {
                        pStr("Client has one Real");
                        output.writeInt(1);
                        output.writeDouble(-b / (2 * a));
                        output.flush();
                    }
                    // no reals
                    else
                        pStr("Client has no Reals");
                        output.writeInt(0);
                        output.flush();
                }
               
                catch (Exception ex)
                {
                    pStr("Client Error");
                    output.writeInt(-1);
                    output.flush();
                }
                output.flush();
                input.close();
                output.close();
                connection.close();
            }
            catch (IOException e)
            {
                pStr(e.getMessage());
            }
            finally
            {
                try
                {
                    input.close();
                }
                catch (IOException e)
                {
                }
 
                try
                {
                    connection.close();
                }
                catch (IOException e)
                {
                }
            }
 
        }
    }
 
}