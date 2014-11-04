
/**
 * Write a description of class BankAccountTester here.
 * 
 * @author (Douglas Gliner 
 * @version v0.0.1a
 */
public class BankAccountTester
{
   public static void main(String[] args)
   {
       BankAccount b1 = new BankAccount(10);
       BankAccount b2 = new BankAccount(1000);
       
       System.out.println("b1 = $" + b1.getBalance());
       System.out.println("b2 = $" + b2.getBalance());
       
       
       //b1.withdraw(10);
       b2.transferTo(10, b1);
       System.out.println("Transfering $10 from b2 to b1 :D");
       System.out.println(b1);
       System.out.println(b2);
       
       b2.transferFrom(10, b1);
       System.out.println("Transfering $10 from b1 to b2 :D");
       System.out.println(b1);
       System.out.println(b2);
       
       
   }
}
