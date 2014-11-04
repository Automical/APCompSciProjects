public class fractionTest
{

   
    public static void main(String[] args)
    
    {
        //test the constructors
        Fraction f0=new Fraction();
        Fraction f1=new Fraction(4,5);
        Fraction f2=new Fraction(3,4);
        Fraction f3=new Fraction(f2);
 
        System.out.println("f0="+ f0);
        System.out.println("f1="+ f1);
        System.out.println("f2="+ f2);
        System.out.println("f3="+ f3);
        

                       
        //test Multiplication
        Fraction product= f1.multiply(f2);
        System.out.print(f1 + " * " + f2 + " = " + product.reduce());
        System.out.println();
       
        //test division
        Fraction quotient= f1.divide(f2);
        System.out.print(f1 + " / " + f2 + " = " + quotient.reduce());
        System.out.println();
        
        //test addition
        Fraction sum = f1.add(f2);
        System.out.print(f1 + " + " + f2 + " = " + sum.reduce());
        System.out.println();
        
        //test subtraction
        Fraction difference = f1.subtract(f2);
        System.out.print(f1 + " - " + f2 + " = " + difference.reduce());
        System.out.println();
        
        System.out.print("(" + f3 + ")" + "^ 3=");
        System.out.println(f3.expo(3));

        
    }
    
    
}
