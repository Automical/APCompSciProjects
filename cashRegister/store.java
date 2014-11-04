
/**
 * Write a description of class store here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class store
{
    private double monies;
    
    public store()
    {
        monies = 1000.0;
    }
    public store(double amt)
    {
        monies = amt;
    }
    public void deposit(cashRegister[] cashes)
    {
        for(int i = 0; i < cashes.length; i++)
        {
            cashes[i].deposit(100.0);
        }
        monies = monies - (cashes.length * 100.0);
    }
    public void cashIn(cashRegister[] cashes)
    {
        for(int i = 0; i < cashes.length; i++)
        {
            if(cashes[i].getBalance() >= 250)
            {
                monies = monies + cashes[i].getBalance()-100;
                cashes[i].cashOut(cashes[i].getBalance()-100);
            }
        }
    }
}
