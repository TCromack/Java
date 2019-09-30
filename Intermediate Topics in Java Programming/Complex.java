/*
 * Name: Tyler Cromack
 * Course Number: CSC-112
 * Course Name: Intermediate Topics in Java
 * Problem Number: HW#3 Complex Numbers
 * Drives the main ComplexNumberDriver.Java in order to test complex numbers given by the user
 */
 
public class Complex
{
    private double real;
    private double imag;
 
    public Complex(double real, double imag)
    {
        this.real = real;
        this.imag = imag;
    }
   
    public Complex(double real)
    {
        this(real,0);
    }
   
    public Complex()
    {
        this(0,0);
    }
   
    public double getReal()
    {
        return real;
    }
 
    public double getImag()
    {
        return imag;
    }
 
    public Complex add(Complex c)
    {            
        double real = this.real + c.real;
        double imag = this.imag + c.imag;
        return new Complex(real, imag);
    }
     
    public Complex subtract(Complex c)
    {      
        return this.add(c.negate());
    }
     
    public Complex multiply(Complex c)
    {
        double real = this.real * c.real - this.imag * c.imag;
        double imag = this.real * c.imag + this.imag * c.real;
        return new Complex(real, imag);
    }
     
    public Complex divide(Complex c)
    {
        return this.multiply(c.reciprocal());
    }
     
    public double abs()
    {
        return Math.hypot(real, imag);
    }
     
    public Complex negate()
    {
        return new Complex(-this.real, -this.imag);
    }
 
    public Complex conjugate()
    {
        return new Complex(real, -imag);
    }
     
    public double distance(Complex c)
    {
        double real = this.getReal() - c.getReal();
        double imag = this.getImag() - c.getImag();
        return Math.sqrt(real * real + imag * imag);
    }
     
    public boolean equals(Complex c)
    {
        double check = (this.abs() > c.abs()) ? (this.abs() - c.abs()) : -(this.abs() - c.abs());
        if (check / this.abs() < 1E-6)
            return true;
        return false;
    }
     
    public boolean greaterThan(Complex c)
    {
        return (this.abs() > c.abs()) ? true : false;
    }
     
    public boolean lessThan(Complex c)
    {
        return !this.greaterThan(c);
    }
   
    public Complex reciprocal()
    {
        double rec = real * real + imag * imag;
        return new Complex(real / rec, -imag / rec);
    }
     
    public String toString()
    {
     if (real == 0)
         return imag + "i";
           
     if (imag == 0)
         return real + "";
           
     if (imag <  0)
         return real + " - " + (-imag) + "i";
           
     return real + " + " + imag + "i";
    }
}