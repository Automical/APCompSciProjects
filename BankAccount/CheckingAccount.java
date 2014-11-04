
/**
 * Write a description of class CheckingAccount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CheckingAccount extends BankAccount
{
    public static final double TRANSACTIONFEE = 2.00;
    private static final int FREE_TRANSACTIONS = 3;
    private int transactionCount;
    public CheckingAccount(double amt)
    {
        super(amt);
    }
    public void deposit(double amt)
    {
        transactionCount++;
        super.deposit(amt);
    }
     public void withdraw(double amt)
    {
        transactionCount++;
        super.withdraw(amt);
    }    
    public void deductFees()
    {
        if(transactionCount > FREE_TRANSACTIONS)
        {
            double fees = TRANSACTIONFEE * (transactionCount - FREE_TRANSACTIONS);
            super.withdraw(fees);
        }
        transactionCount = 0;
    }
}
