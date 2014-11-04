
/**
 * Write a description of class bankL here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class bankL
{
    // instance variables - replace the example below with your own
    private static Random gen = new Random();
    private static ArrayList<BankAccount> bankList;

    public static void main(String[] args)
    {
        bankList = new ArrayList<BankAccount>();
        for(int i = 0; i < 5; i++)
        {
            BankAccount b = new BankAccount((double)gen.nextInt(1000)/100.0);
            bankList.add(b);
    }
    for(int i = 0; i < 5; i++)
    {
        System.out.println(bankList.get(i).getBalance());
    }
    Collections.sort(bankList);
    System.out.println("-------------------------------");
     for(int i = 0; i < 5; i++)
    {
        System.out.println(bankList.get(i).getBalance());
    }
}
}
