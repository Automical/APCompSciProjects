
/**
 * Write a description of class BankAccount here.
 * 
 * @author Douglas Gliner
 * @version v0.0.1a
 */
public class BankAccount implements Comparable<BankAccount>
{
  private double balance;
  private int accountNumber;
  private static int nextAccountNumber = 1;
  
  //Constructors
  
  public BankAccount() //null constructor
  {
      balance = 0;
      accountNumber = nextAccountNumber++;
  }
  public BankAccount(double amt)
  {
      balance = amt;
      accountNumber = nextAccountNumber++;
  }
  
  //Methods
  
  public void deposit(double amt)
  {
      balance += amt; //or balance = balance + amt;
  }
  public void withdraw(double amt)
  {
      if(amt <= balance) //make sure you only get less than what you acutally have!
      {
        balance -= amt; //or balance = balance - amt
      }
  }
  public void transferTo(double amt, BankAccount other)
  {
      if(amt <= balance)
      {
          withdraw(amt);
          other.deposit(amt);
      }
  }
  public void transferFrom(double amt, BankAccount other)
  {
      if(amt <= other.getBalance())
      {
          other.withdraw(amt);
          deposit(amt);
      }
  }
  public double getBalance()
  {
      return balance;
  }
  public String toString()
  {
      return "balance = $" + balance + " on account number: " + accountNumber + ".";
  }
  public int compareTo(BankAccount b)
  {
      return (int)(balance * 100.0 - b.balance * 100.0);
    }
}
