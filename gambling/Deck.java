
/**
 * Write a description of class Deck here.
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
import java.util.ArrayList;

public class Deck
{
private static Random gen = new Random();
ArrayList<Card> a = new ArrayList<Card>();
    public Deck()
    {
       
        for(int i = 1; i <= 4; i++)
        {
            for(int z = 1; z <= 13; z++)
            {
                a.add(new Card(i,z));
            }
        }
    }
    public void print()
    {
        for(int i = 0; i < a.size(); i++)
        {
            System.out.println(a.get(i).toString());
        }
    }
    public void pickACard()
    {
        System.out.println(a.get(gen.nextInt(a.size() - 1)).toString());
    }
    public Card returnCard()
    {
        return a.get(gen.nextInt(52));
    }
    public Card removeCard()
    {
        int select = gen.nextInt(a.size() - 1);
        Card c = a.get(select);
        a.remove(select);
        return c;
    }
    public void addCard(Card c)
    {
        a.add(c);
    }
    public void shuffle()
    {
        for(int i = 0; i < gen.nextInt(150) + 100; i++)
        {
            int select = gen.nextInt(a.size() - 1);
            Card c = a.get(select);
            a.remove(select);
            a.add(c);
        }
    }
            
}
