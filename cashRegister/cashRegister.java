
/**
 * Write a description of class cashRegister here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class cashRegister
{
    // instance variables - replace the example below with your own
    private double total;
    private double receive;
    private double balance;
    private int sold;
    private int items;
    private int customers;

    /**
     * Constructor for objects of class cashRegister
     */
    public cashRegister()
    {
        // initialise instance variables
        balance = 0.0;
        total = 0.0;
        receive = 0.0;
        sold = 0;
        items = 0;
    }
    
    public cashRegister(double bal)
    {
        balance = bal;
        total = 0.0;
        receive = 0.0;
        sold = 0;
        items = 0;
    }
    
    public void purchase(double price)
    {
        total = total + price;
        sold++;
        items++;
    }

    public double getTotal()
    {
        return total;
    }
    
    public void payment(double payment)
    {
        receive = payment;
    }
    
    public double getChange()
    {
        customers++;
        items = 0;
        balance = balance - (receive - total) + receive;
        return receive - total;        
    }
    
    public int getSold()
    {
        return sold;
    }
    
    public double getBalance()
    {
        return balance;
    }
    
    public int getItems()
    {
        return items;
    }
    
    public void deposit(double add)
    {
        balance = add + balance;
    }
    
    public void reset()
    {
        balance = 0.0;
        total = 0.0;
        receive = 0.0;
        sold = 0;
        items = 0;
    }
    
    public void reset(double bal)
    {
        balance = bal;
        total = 0.0;
        receive = 0.0;
        sold = 0;
        items = 0;
    }
    
    public int getCustomers()
    {
        return customers;
    }
    
    public void cashOut(double withdraw)
    {
        balance = balance - withdraw;
    }
}
