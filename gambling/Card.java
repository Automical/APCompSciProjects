
/**
 * Write a description of class Card here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.Random;
import java.lang.String;

public class Card
{
private static Random gen = new Random();
int suit;
int value;
    public Card()
    {
        suit = gen.nextInt(4) + 1;
        value = gen.nextInt(13) + 1;
    }
    public Card(int s, int v)
    {
        suit = s;
        value = v;
    }
    public int getSuit()
    {
        return suit;
    }
    public int getVal()
    {
        return value;
    }
    public String toString()
    {
        String s = new String();
        String v = new String();
        switch(suit){
            case 1: s = "Spades";
                        break;
            case 2: s = "Hearts";
                        break;
            case 3: s = "Clubs";
                        break;
            case 4: s = "Diamonds";
                        break;
            }
       switch(value){
           case 1: v = "Ace"; break;
           case 2: v = "Two"; break;
           case 3: v = "Three"; break;
           case 4: v = "Four"; break;
           case 5: v = "Five"; break;
           case 6: v = "Six"; break;
           case 7: v = "Seven"; break;
           case 8: v = "Eight"; break;
           case 9: v = "Nine"; break;
           case 10: v = "Ten"; break;
           case 11: v = "Jack"; break;
           case 12: v = "Queen"; break;
           case 13: v = "King"; break;
        }
           return v + " of " + s;
    }
    public int compareTo(Card c)
    {
        int XD = 0;
        if(value < c.getVal())return -1;
        if(value == c.getVal())return 0;
        if(value > c.getVal())return 1;
        return XD;
    }
    
}
