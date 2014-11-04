
/**
 * Write a description of class stat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.text.DecimalFormat;

public class stat
{
static Deck d;
static int count = 0;
static int correct = 0;
static final int TRIALS = 100000;
    public static void main(String args[])
    {
        d = new Deck();
        int correct = 0;
        for(int i = 0; i < TRIALS; i++)
        {
            if(AK() == true) correct++;
        }
        System.out.println("AK Probability = " + roundTwoDecimals(((double)correct/(double)TRIALS * 100)) + "%.");
        correct = 0;
        for(int i = 0; i < TRIALS; i++)
        {
            if(AA() == true) correct++;
        }
        System.out.println("AA Probability = " + roundTwoDecimals(((double)correct/(double)TRIALS * 100)) + "%.");
        correct = 0;
        for(int i = 0; i < TRIALS; i++)
        {
            if(AH() == true) correct++;
        }
        System.out.println("AH Probability = " + roundTwoDecimals(((double)correct/(double)TRIALS * 100)) + "%.");
        correct = 0;
    }
    public static boolean AK()
    {
        d.shuffle();
        Card c1 = d.removeCard();
        Card c2 = d.removeCard();
        d.addCard(c1);
        d.addCard(c2);
        if(c1.getVal() == 1 && c2.getVal() == 13) return true;
        if(c2.getVal() == 1 && c1.getVal() == 13) return true;
        return false;
    }
    public static boolean AA()
    {
        d.shuffle();
        Card c1 = d.removeCard();
        Card c2 = d.removeCard();
        d.addCard(c1);
        d.addCard(c2);
        if(c1.getVal() == 1 && c2.getVal() == 1) return true;
        return false;
    }
    public static boolean AH()
    {
        d.shuffle();
        Card c1 = d.removeCard();
        Card c2 = d.removeCard();
        d.addCard(c1);
        d.addCard(c2);
        if(c1.getVal() == 1 && c2.getSuit() == 2) return true;
        if(c2.getVal() == 1 && c1.getSuit() == 2) return true;
        return false;
    }
    public static double roundTwoDecimals(double d) 
    {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        return Double.valueOf(twoDForm.format(d));
    }
}
