
/**
 * Write a description of class coinTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.math.BigDecimal;

public class coinTester
{
public static final int COINS = 10;
public static final int TRIALS = 10;
   public static void main (String[] args)
   {
       trial(10);
       trial(100);
       trial(1000);
        
    }
    public static int run(int coins)
    {
       coin c = new coin();
       int h = 0;
       int t = 0;
       char ch;
       for(int i = 0; i < coins; i++)
       {
           ch = c.flip();
           if (ch == 'H')h++;
           if (ch == 'T')t++;
           //System.out.println(ch);
        }
        if(h * 10/ COINS == 5 && t * 10/ COINS == 5)
        {
            return 1;
        }
        return 0;
        
    }
    public static void trial(int coins)
    {
    int count = 0;
       for (int z = 0; z < TRIALS; z++)
       {
           if(run(coins) == 1)
           {
               count++;
            }
           
        }
        System.out.println("Probability of getting 50-50 in 10 Trials of " + coins + ":"+ round(count * 100/TRIALS, 2, BigDecimal.ROUND_HALF_UP) + "%.");
        count = 0;
        for (int z = 0; z < TRIALS * 10; z++)
       {
           if(run(coins) == 1)
           {
               count++;
            }
           
        }
        System.out.println("Probability of getting 50-50 in 100 Trials " + coins + ":" + round(count * 100/(TRIALS * 10), 2, BigDecimal.ROUND_HALF_UP) + "%.");
        count = 0;
        for (int z = 0; z < TRIALS * 100; z++)
       {
           if(run(coins) == 1)
           {
               count++;
            }
           
        }
        System.out.println("Probability of getting 50-50 in 1000 Trials " + coins + ":"+ round(count * 100/(TRIALS * 100), 2, BigDecimal.ROUND_HALF_UP) + "%.");
        
    }

    public static double round(double unrounded, int precision, int roundingMode)
    {
    BigDecimal bd = new BigDecimal(unrounded);
    BigDecimal rounded = bd.setScale(precision, roundingMode);
    return rounded.doubleValue();
    }
}
//System.out.println("Heads: " + h + ", " + round(h * 100/(h + t), 2, BigDecimal.ROUND_HALF_UP) + "%.");
        //System.out.println("Tails: " + t + ", " + round(t * 100/(h + t), 2, BigDecimal.ROUND_HALF_UP) + "%.");