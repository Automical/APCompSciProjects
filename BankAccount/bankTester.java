
/**
 * Write a description of class bankTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class bankTester
{
 private static Random gen = new Random();
    public static void main(String[] args)
    {
        Bank bank = new Bank();
        for(int i = 0; i < 5; i++)
        {
            BankAccount b = new BankAccount((double)gen.nextInt(1000)/100.0);
            bank.addAccount(b);
    }
    bank.display();
    System.out.println();
    System.out.println(bank.getTotalBalance());
    System.out.println(bank.count(5.0));
    System.out.println(bank.find(4));
    System.out.println(bank.getMax());
}
}
