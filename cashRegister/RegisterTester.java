
/**
 * Write a description of class RegisterTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.JOptionPane;
import java.util.Random;
import java.util.Scanner;
import java.math.BigDecimal;



public class RegisterTester
{
    // instance variables - replace the example below with your own
private static final int CASHES = 10;
    public static void main(String[] args)
    {
        
        Random gen = new Random();
        Scanner in = new Scanner(System.in);
       // System.out.println("Hi.");
        cashRegister cash1 = new cashRegister();
        cashRegister cash2 = new cashRegister();
        cashRegister[] newCash = new cashRegister[10];
        for(int i = 0; i < CASHES; i ++)
        {
            newCash[i] = new cashRegister();
        }
        for(int y = 0; y < 10; y ++)
        {
        int w = gen.nextInt(10);
        int z = gen.nextInt(10) + 1;
        for(int i = 0; i < z; i++)
            {
                double x = gen.nextDouble() * 100 + 1;
                newCash[w].purchase(x);
                System.out.print(i + 1);
                System.out.println(". " + round(x, 2, BigDecimal.ROUND_HALF_UP));
            }
            double p = 0.0;
            System.out.println("Cash Register " + (w + 1) + ".");
            System.out.println("Total: " + round(newCash[w].getTotal(), 2, BigDecimal.ROUND_HALF_UP));
            p = Math.ceil(newCash[w].getTotal()/10) * 10;
            System.out.println("Payment: " + p);
            newCash[w].payment(p);
            System.out.println("Change: " + round(newCash[w].getChange(), 2, BigDecimal.ROUND_HALF_UP));
            System.out.println("Items Sold: " + newCash[w].getSold());
            System.out.println("Register Balance: " + round(newCash[w].getBalance(), 2, BigDecimal.ROUND_HALF_UP));
            System.out.println();
        }
        for(int i = 0; i < CASHES; i++)
        {
            System.out.println("Cash Register " + (i + 1) + " balance: " + round(newCash[i].getBalance(), 2, BigDecimal.ROUND_HALF_UP));
            System.out.println("Cash Register " + (i + 1) + " customers served: " + newCash[i].getCustomers());
            System.out.println();
        //double pay = in.nextDouble();
        //cash1.payment(pay);
        //cash.payment(Double.parseDouble(y));
        //System.out.println("Total: " + round(cash1.getTotal(), 2, BigDecimal.ROUND_HALF_UP));
        //System.out.println("Change: " + round(cash1.getChange(), 2, BigDecimal.ROUND_HALF_UP));
        //System.out.println("Items Sold: " + cash1.getSold());
        
    }

}
    public static double round(double unrounded, int precision, int roundingMode)
    {
    BigDecimal bd = new BigDecimal(unrounded);
    BigDecimal rounded = bd.setScale(precision, roundingMode);
    return rounded.doubleValue();
    }
    
}



/**if(w == 0)
        {
            for(int i = 0; i < z; i++)
            {
                double x = gen.nextDouble() * 100 + 1;
                cash1.purchase(x);
                System.out.print(i + 1);
                System.out.println(". " + round(x, 2, BigDecimal.ROUND_HALF_UP));
            }
            System.out.println("Cash Register 1.");
            System.out.println("Total: " + round(cash1.getTotal(), 2, BigDecimal.ROUND_HALF_UP));
            System.out.println("Enter payment: ");
            double pay = in.nextDouble();
            cash1.payment(pay);
            System.out.println("Change: " + round(cash1.getChange(), 2, BigDecimal.ROUND_HALF_UP));
            System.out.println("Items Sold: " + cash1.getSold());
            System.out.println("Register Balance: " + round(cash1.getBalance(), 2, BigDecimal.ROUND_HALF_UP));
        }else{
        for(int i = 0; i < z; i++)
            {
                double x = gen.nextDouble() * 100 + 1;
                cash2.purchase(x);
                System.out.print(i + 1);
                System.out.println(". " + round(x, 2, BigDecimal.ROUND_HALF_UP));
            }
            System.out.println("Cash Register 2.");
            System.out.println("Total: " + round(cash2.getTotal(), 2, BigDecimal.ROUND_HALF_UP));
            System.out.println("Enter payment: ");
            double pay = in.nextDouble();
            while(pay < cash2.getTotal())
            {
                System.out.println("Invalid payment");
                pay = in.nextDouble();
            }
            cash2.payment(pay);
            System.out.println("Change: " + round(cash2.getChange(), 2, BigDecimal.ROUND_HALF_UP));
            System.out.println("Items Sold: " + cash2.getSold());
            System.out.println("Register Balance: " + round(cash2.getBalance(), 2, BigDecimal.ROUND_HALF_UP));
        }**/
