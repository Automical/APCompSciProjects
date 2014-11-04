
/**
 * Write a description of class Bank here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Bank
{
private ArrayList<BankAccount> Accounts;

    public Bank()
    {
        Accounts = new ArrayList<BankAccount>();
    }
    
    public void addAccount(BankAccount a)
    {
        Accounts.add(a);
    }
    
    public double getTotalBalance()
    {
        double total = 0;
        for(int i = 0; i < Accounts.size(); i++)
        {
            total += Accounts.get(i).getBalance();
        }
        return total;
    }
    
    public int count(double atLeast)
    {
        int count = 0;
        
        for(int i = 0; i < Accounts.size(); i++)
        {
            if(Accounts.get(i).getBalance() > atLeast)
            {
                count++;
            }
        }
        return count;
    }
    
    public BankAccount find(int accountNumber)
    {
        return Accounts.get(accountNumber - 1);
    }
    
    public BankAccount getMax()
    {
        int max = Accounts.size();
        BankAccount b = new BankAccount();
        Accounts.add(b);
        
        for(int i = 0; i < Accounts.size(); i++)
        {
            if(Accounts.get(i).getBalance() > Accounts.get(max).getBalance())
            {
                max = i;
            }
        }
        Accounts.remove(Accounts.size() - 1);
        return Accounts.get(max);
    }
    public void display()
    {
        for(int i = 0; i < Accounts.size(); i++)
        {
            System.out.println(Accounts.get(i));
        }
    }
    
}
