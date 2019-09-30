/*
 * Name: Tyler Cromack
 * Course Number: CSC-112
 * Course Name: Intermediate Topics in Java
 * Problem Number: HW#6 Complex Numbers GUI3
 * The Driver for the Complex Class
 */
 
import javax.swing.JOptionPane;
 
public class ComplexGui3
{
     private final static String TITLE = "Complex Number Driver V3.0";
     private final static String CONTINUE_PROMPT = "Do this again?";
   
    private static Complex buildComplex (String prompt)
    {
        Complex complex = null;
        String strComplex = null;
            ComplexPanel2 cip = new ComplexPanel2();
            int result = JOptionPane.showConfirmDialog(null, cip, "Please Enter Values For " + prompt,
                    JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION)
        {
            if(cip.getRealText().trim().equals("")  && cip.getImagText().trim().equals(""))
            {  
                strComplex = cip.getComplex();
                complex = new Complex(strComplex);
            }
            else
            {
            double real = cip.getReal();
            double imag = cip.getImag();
            complex = new Complex(real, imag);
            }
        }
        else
        {
         System.exit(1);
        }
        return complex;
    }
   
    public static void process(String[] args)
    {
        Complex c1 = buildComplex("Complex 1");
        Complex c2 = buildComplex("Complex 2");
        Complex plus = c1.add(c2);
        Complex minus = c1.subtract(c2);
        Complex times = c1.multiply(c2);
        Complex quot = c1.divide(c2);
        String output = "";
        output += String.format("c1 = %s\n", c1);
        output += String.format("c2 = %s\n", c2);
        output += String.format("c1 + c2 = %s\n", plus);
        output += String.format("c1 - c2 = %s\n", minus);
        output += String.format("c1 * c2 = %s\n", times);
        output += String.format("c1 / c2 = %s\n", quot);
        output += String.format("-c1 = %s\n", c1.negate());
        output += String.format("-c2 = %s\n", c2.negate());
        output += String.format("Conj c1 = %s\n", c1.conjugate());
        output += String.format("Conj c2 = %s\n", c2.conjugate());
        output += String.format("|c1| = %.3f\n", c1.abs());
        output += String.format("|c2| = %.3f\n", c2.abs());
        output += String.format("Dist = %.3f\n", c1.distance(c2));
        output += String.format("==? = %b\n", c1.equals(c2));
        output += String.format(">? = %b\n", c1.greaterThan(c2));
        output += String.format("<? = %b\n", c1.lessThan(c2));
        JOptionPane.showMessageDialog(null, output, TITLE, JOptionPane.INFORMATION_MESSAGE, null);
    }
   
    private static boolean doThisAgain(String prompt)
    {
        int option = JOptionPane.showConfirmDialog(null, prompt, TITLE, JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        return option == JOptionPane.YES_OPTION;
    }
   
    public static void main(String args[])
    {
        do
        {
         process(args);
        } while (doThisAgain(CONTINUE_PROMPT));
    }  
}