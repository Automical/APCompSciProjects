
/**
 * Write a description of class SavingsAccount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SavingsAccount extends BankAccount
{
    private double interestRate;
    //superhero MAXXUSS
    public SavingsAccount(double rate)
    {
        super();
        interestRate = rate;
    }
     public SavingsAccount(double rate, double balance)
    {
        super(balance);
        interestRate = rate;
        
    }
    public void addInterest()
    {
        double interest = getBalance() * interestRate;
        deposit(interest);
    }
    
}
