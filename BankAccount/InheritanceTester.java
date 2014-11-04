
/**
 * Write a description of class InheritanceTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InheritanceTester
{
public static void main(String[] args)
{
    SavingsAccount s1 = new SavingsAccount(.01, 100.00);
    System.out.println("s1 balance = " + s1.getBalance());
    s1.addInterest();
    System.out.println("adding Interest to s1");
    System.out.println("s1 balance = " + s1.getBalance());
    CheckingAccount s2 = new CheckingAccount(100.00);
    System.out.println("s2 balance = " + s2.getBalance());
    s2.deposit(10.0);
    s2.deposit(10.0);
    s2.deposit(10.0);
    s2.withdraw(30.0);
    s2.deductFees();
    System.out.println("s2 balance = " + s2.getBalance());
}
    
}
