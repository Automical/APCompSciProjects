
/**
 * Write a description of class fraction here.
 * 
 * @author Mr. Schu
 * @version alpha
 */

import java.lang.Math;

public class Fraction
{
    // instance variables 
    private int numerator;
    private int denominator;

    /**
     * Constructor for objects of class fraction
     */
    
    //null constructor
    public Fraction()
    {
        numerator = 1;
        denominator = 1;
       
    }
    
    //constructor that recieves a numerator and denominator
    public Fraction(int n,int d)
    {
        // initialise instance variables
        numerator = n;
        denominator = d;
       
    }
    
    //copy constructor
    public Fraction(Fraction f)
    {
        numerator = f.numerator;
        denominator = f.denominator;
       
    }
    
    
    /**
     * methods 
     */
    
    //multiplies the given fraction by thefraction argument f and returns the product as a
    //fraction
    public Fraction multiply(Fraction f)
    {
        Fraction n = new Fraction(numerator * f.numerator, denominator * f.denominator);
        return n;
    }
    
    //returns a new fraction that is the reciprocal of the fraction object
   private Fraction recip()
        {
            Fraction n = new Fraction(denominator, numerator);
            return n;
        }
    
    
     //divides the given fraction by the fraction argument f and returns the product as a
    //fraction
    public Fraction divide(Fraction f)
        {
            return multiply(f.recip());
        }
    
    //converts the fraction to a string and returns that string
    public String toString()
    {
       return numerator + "/" + denominator;
    }
    
    //returns the gcf between the two arguments  
    private static int gcf(int N, int D)
        {
        int R;
        N=Math.abs(N);
        D=Math.abs(D);
        
        do
        {
        R = N % D;
        N=D;
        D=R;
        }
        while ( R != 0);
        return N;
        }
        
    
    //returns a reduced version of the fraction object
    public Fraction reduce()
        {
        
         Fraction n = new Fraction(numerator / gcf(numerator, denominator), denominator /gcf(numerator, denominator));
         return n;
        }
        
   // returns the sum of the fraction object and the fraction argument f     
   public Fraction add(Fraction f)
    {
        /**int one = 1;
        int two = 1;
        while (one * denominator != two * f.denominator)
        {
            if (one * denominator < two *f.denominator)
            {
                one = one + 1;
            }else{
                two = two + 1;
            }
        }**/
        Fraction n = new Fraction((numerator * f.denominator) + (f.numerator * denominator), denominator * f.denominator);
        
        return n.reduce();
    }
    
    
    //returns the negation of the fraction object
    private Fraction negate()
        {
            Fraction n = new Fraction(numerator * -1, denominator);
            return n;
        }
        
   
   //returns the difference between the fraction object and the fraction argument f
   public Fraction subtract(Fraction f)
        {
            return add(f.negate());
        }
        
   public Fraction expo (int pow)
   {
       Fraction n = new Fraction((int)java.lang.Math.pow(numerator, pow), (int)java.lang.Math.pow(denominator,pow));
       return n.reduce();
    }
        
    
    }
