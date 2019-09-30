/*
 * Name: Tyler Cromack
 * Course Number: CSC-112
 * Course Name: Intermediate Topics in Java
 * Problem Number: HW#6 Complex Numbers GUI2
 * The GUI2 Panel for the Complex Class
 */
 
import java.awt.Dimension;
import javax.swing.*;
 
public class ComplexPanel2 extends JPanel
{
    private JTextField txtReal = new JTextField(5);
    private JTextField txtImag = new JTextField(5);
    private JTextField txtComplex = new JTextField(10);
   
    public ComplexPanel2()
    {
        this.setPreferredSize(new Dimension(300, 70));
        this.add(new JLabel("Real:"));
        this.add(txtReal);
        this.add(Box.createHorizontalStrut(15)); // a spacer
        this.add(new JLabel("Imaginary:"));
        this.add(txtImag);
        this.add(new JLabel("Complex Number:"));
        this.add(txtComplex);
    }
 
    private static double getDoubleValue(JTextField component)
    {
        double retVal;
        try {
            retVal = Double.parseDouble(component.getText());
        } catch (Exception ex) {
            retVal = 0;
        }
        return retVal;
    }
   
    public double getReal()
    {
        return ComplexPanel2.getDoubleValue(txtReal);
    }
 
    public double getImag()
    {
        return ComplexPanel2.getDoubleValue(txtImag);
    }
 
    public String getRealText()
    {
        return txtReal.getText();
    }
   
    public String getImagText()
    {
        return txtImag.getText();
    }
 
    public String getComplex()
    {
        return txtComplex.getText();
    }
}