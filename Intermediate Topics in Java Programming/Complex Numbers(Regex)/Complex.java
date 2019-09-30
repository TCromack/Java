/*
 * Name: Tyler Cromack
 * Course Number: CSC-112
 * Course Name: Intermediate Topics in Java
 * Problem Number: HW#6 Complex Numbers
 * Drives the main ComplexNumberDriver.Java in order to test complex numbers given by the user
 */
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class Complex extends Number implements Comparable<Complex> {
 
    private double imag = 0;
    private double real = 0;
    public final static Complex ZERO = new Complex();
   
    /*** Constructors ***/
 
    public Complex() {
        this.real = 0;
        this.imag = 0;
    }
 
    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
 
    }
 
    public Complex(double real) {
        this.real = real;
        this.imag = 0;
    }
 
    public Complex(String str)
    {
        Complex c = strToComplex(str);
        this.real = c.real;
        this.imag = c.imag;
    }
 
    public static Complex strToComplex(String str)
    {
        str = str.trim().replaceAll("\\s+", "");
 
        String strRegex;
        double real;
        double imag;
        Pattern pattern;
        Matcher match;
 
        // Just Real Number
        strRegex = "^[+-]?(\\d+(\\.\\d*)?|\\.\\d+)$";
        pattern = Pattern.compile(strRegex);
        match = pattern.matcher(str);
        if (match.find())
        {
            real = Double.parseDouble(match.group());
            imag = 0;
            return new Complex(real, imag);
        }
 
        // Just imaginary with i at the end 3i
        strRegex = "^[+-]?(\\d+(\\.\\d*)?|\\.\\d+)i$";
        pattern = Pattern.compile(strRegex);
        match = pattern.matcher(str);
        if (match.find())
        {
            real = 0;
            imag = Double.parseDouble(match.group(1));
            return new Complex(real, imag);
        }
 
        // Just imaginary with i at the beginning i3
        strRegex = "^i[+-]?(\\d+(\\.\\d*)?|\\.\\d+)$";
        pattern = Pattern.compile(strRegex);
        match = pattern.matcher(str);
        if (match.find())
        {
            real = 0;
            imag = Double.parseDouble(match.group(1));
            return new Complex(real, imag);
        }
 
        // Just an i
        strRegex = "^([+-]?)1i$";
        pattern = Pattern.compile(strRegex);
        match = pattern.matcher(str);
        if (match.find())
        {
            real = 0;
            imag = Double.parseDouble(match.group(1));
            return new Complex(real, imag);
        }
 
        // Real and Imag Parts with "i" at the end i.e. 5 - 3i
        strRegex = "^([+-]?(\\d+(\\.\\d*)?|\\.\\d+))([+-](\\d+(\\.\\d*)?|\\.\\d+))i$";
        pattern = Pattern.compile(strRegex);
        match = pattern.matcher(str);
        if (match.find())
        {
            real = Double.parseDouble(match.group(1));
            imag = Double.parseDouble(match.group(4));
            return new Complex(real, imag);
        }
 
        // Real and Imag Parts with "i" at the beginning i.e. 5 - i3
        strRegex = "^([+-]?(\\d+(\\.\\d*)?|\\.\\d+))([+-]i(\\d+(\\.\\d*)?|\\.\\d+))$";
        pattern = Pattern.compile(strRegex);
        match = pattern.matcher(str);
        if (match.find())
        {
            real = Double.parseDouble(match.group(1));
            imag = Double.parseDouble(match.group(5));
            return new Complex(real, imag);
        }
        return new Complex(0, 0);
    }
     
    /*** Getters ***/
 
    public double getImag() {
        return this.imag;
    }
 
    public double getReal() {
        return this.real;
    }
 
    /*** Setters ***/
 
    public void setReal(double real) {
        this.real = real;
    }
 
    public void setImag(double imag) {
        this.imag = imag;
    }
 
    /*** Operations ***/
 
    public Complex add(Complex other) {
        // a+bi + c+di is (a+c)+(b+d)i
        return new Complex(this.real + other.real, this.imag + other.imag);
    }
 
    public Complex subtract(Complex other) {
        // a+bi - c+di is (a-c)+(b-d)i
        return add(other.negate());
    }
 
    public Complex multiply(Complex other) {
        // (a+bi) * (c+di) is (ac-bd)+(ad+bc)i
        double ac = this.real * other.real;
        double bd = this.imag * other.imag;
        double ad = this.real * other.imag;
        double bc = this.imag * other.real;
 
        return new Complex(ac - bd, ad + bc);
    }
 
    public Complex divide(Complex other) {
        // (a+bi) / (c+di) is (ac+bd)/(c^2+d^2) + (bc-ad)/(c^2+d^2)i
        double a = this.real;
        double b = this.imag;
        double c = other.real;
        double d = other.imag;
 
        double quotientReal = ((a * c) + (b * d)) / ((c * c) + (d * d));
        double quotientImag = ((b * c) - (a * d)) / ((c * c) + (d * d));
 
        return new Complex(quotientReal, quotientImag);
    }
 
    public double abs() {
        // |a + bi| is sqrt(a^2 + b^2)
        return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imag, 2));
    }
 
    public Complex conjugate() {
        // Complex conjugate of a+bi is a-bi
        return new Complex(this.real, -this.imag);
    }
 
    public double distance(Complex other) {
        // Distance between a+bi and c+di is sqrt((a-c)^2 + (b-d)^2)
        return Math.sqrt(Math.pow(this.real - other.real, 2) + Math.pow(this.imag - other.imag, 2));
    }
 
    public Complex negate() {
        // -(a+bi) is -a-bi
        return new Complex(-this.real, -this.imag);
    }
 
    /*** Comparisons ***/
 
    public boolean equals(Complex other) {
        /*
         * If A is the larger complex number and B is the smaller one, A and B
         * are approximately equal if the following is true: (|A| - |B|)/|A| <
         * 1E-6 (one millionth)
         */
        return this.distance(other) / (this.greaterThan(other) ? this.abs() : other.abs()) < 1E-6;
    }
 
    public boolean greaterThan(Complex other) {
        return this.abs() > other.abs();
    }
 
    public boolean lessThan(Complex other) {
        return this.abs() < other.abs();
    }
 
    public String toString() {
        String toString = "";
        if (this.imag == 0.0)
            toString += this.real;
        else if (this.real == 0.0)
            toString += this.imag + "i";
        else {
            toString += this.real;
            toString += this.imag < 0 ? " - " : " + ";
            toString += Math.abs(this.imag) + "i";
        }
        return toString;
    }
 
    // Round components to the specified number of decimal places
    public String getRoundedtoString(int decimalPlaces) {
        // Assume negative input should be changed to positive
        decimalPlaces = Math.abs(decimalPlaces);
 
        // Ensure that any number which rounds to 0 is displayed as positive 0
        double realPart = Math.abs(this.real) < Math.pow(10, -decimalPlaces) ? 0.0 : this.real;
        double imagPart = Math.abs(this.imag) < Math.pow(10, -decimalPlaces) ? 0.0 : this.imag;
 
        // Format numbers according to decimal places
        String format = "%." + decimalPlaces + "f";
        String toString = realPart < 0 ? "-" : "";
        toString += String.format(format, Math.abs(realPart));
        toString += imagPart < 0 ? " - " : " + ";
        return toString + String.format(format + "i", Math.abs(imagPart));
    }
 
    @Override
    public int compareTo(Complex other) {
        double diff = this.abs() - other.abs();
        if (diff > 0)
            return 1;
        if (diff == 0)
            return 0;
        return -1;
    }
 
    @Override
    public double doubleValue() {
        return this.abs();
    }
 
    @Override
    public float floatValue() {
        return (float)doubleValue();
    }
 
    @Override
    public int intValue() {
        return (int)doubleValue();
    }
 
    @Override
    public long longValue() {
        return (long)doubleValue();
    }
 
    public static void main(String args[]) {
        String testStrs[] = { "55", "-55", "-.34", "78.3i", "i78.3",
                "23.5    +      10.75i", "23.5 + i10.75", ".89-8i", "-i",
                "tony" };
 
        for (String str : testStrs) {
            Complex c = strToComplex(str);
            System.out.printf("%s => %s\n", str, c);
 
        }
    }
}