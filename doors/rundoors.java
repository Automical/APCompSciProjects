
/**
 * Write a description of class rundoors here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;


public class rundoors
{
    private static Random gen = new Random();
    
    private static int total = 10;
    private static int x;
    private static int y;
    static char one = ' ';
    static char two = one;
    static char three = one;
    
    public static void main(String[] args)
    {
        //char one = ' ';
        //char two = one;
        //char three = one;
        for(int i = 0; i < total; i++)
        {
        rundoors(one, two, three);
        }
        System.out.println("You have won " + x + " rounds out of " + total + " total rounds, or " + (double)x/(double)total * 100.00 + "%.");
        System.out.println("You swapped" + y + "times." v);
    }
    static void rundoors(char one, char two, char three)
    {
    int rand = gen.nextInt(3) + 1;
    
    if(rand == 1)
    {
        one = 'g';
        int rand2;
        rand2 = gen.nextInt(2) + 1;
        if(rand2 == 1)
        {
            two = 'm';
            three = 'k';
        }
        if(rand2 == 2)
        {
            three = 'm';
            two = 'k';
        }
    }
    if(rand == 2)
    {
        two = 'g';
        int rand2;
        rand2 = gen.nextInt(2) + 1;
        if(rand2 == 1)
        {
            one = 'm';
            three = 'k';
        }
        if(rand2 == 2)
        {
            three = 'm';
            one = 'k';
        }
    }
    if(rand == 3)
    {
        three = 'g';
        int rand2;
        rand2 = gen.nextInt(2) + 1;
        if(rand2 == 1)
        {
            one = 'm';
            two = 'k';
        }
        if(rand2 == 2)
        {
            two = 'm';
            one = 'k';
        }
    }
    
    System.out.println(one);
    System.out.println(two);
    System.out.println(three);
    int select = select();
    revealswitch(select, one, two, three);
   
}

static int select()
{
        int select = gen.nextInt(3) + 1;
        System.out.println("Selected: Door " + select);
        return select;
}


static void revealswitch(int select, char one, char two, char three)
    {
        if(select == 1)
        {
            if(one == 'm')
            {
                if(two == 'k')
                {
                    System.out.println("Reveal 2");
                    change(1, 3, one, two, three);
                }
                if(three == 'k')
                {
                    System.out.println("Reveal 3");
                    change(1, 2, one, two, three);
                }
            }else{
                if(two == 'm')
                {
                    System.out.println("Reveal 2");
                    change(1, 3, one, two, three);
                }
                if(three == 'm')
                {
                    System.out.println("Reveal 3");
                    change(1, 2, one, two, three);
                }
            }
            
                
    }
    if(select == 2)
        {
            if(two == 'm')
            {
                if(one == 'k')
                {
                    System.out.println("Reveal 1");
                    change(2, 3, one, two, three);
                }
                if(three == 'k')
                {
                    System.out.println("Reveal 3");
                    change(2, 1, one, two, three);
                }
            }else{
                if(one == 'm')
                {
                    System.out.println("Reveal 1");
                    change(2, 3, one, two, three);
                }
                if(three == 'm')
                {
                    System.out.println("Reveal 3");
                    change(2, 1, one, two, three);
                }
            }
            
                
    }
    if(select == 3)
        {
            if(three == 'm')
            {
                if(one == 'k')
                {
                    System.out.println("Reveal 1");
                    change(3, 2, one, two, three);
                }
                if(two == 'k')
                {
                    System.out.println("Reveal 2");
                    change(3, 1, one, two, three);
                }
            }else{
                if(one == 'm')
                {
                    System.out.println("Reveal 1");
                    change(3, 2, one, two, three);
                }
                if(two == 'm')
                {
                    System.out.println("Reveal 2");
                    change(3, 1, one, two, three);
                }
            }
            
                
    }
}

static void change(int pick, int change, char one, char two, char three)
{
    int sw = gen.nextInt(2);
    if(sw == 0)
    {
        System.out.println("Don't switch.");
        if(pick == 1)
        {
            if(one == 'g')
            {
                System.out.println("You win!");
                x++;
            }else{
                System.out.println("You lose.");
            }
        }
        if(pick == 2)
        {
            if(two == 'g')
            {
                System.out.println("You win!");
                x++;
            }else{
                System.out.println("You lose.");
            }
        }
        if(pick == 3)
        {
            if(three == 'g')
            {
                System.out.println("You win!");
                x++;
            }else{
                System.out.println("You lose.");
            }
        }
    }else{
        System.out.println("Switch door " + pick + " for door " + change + ".");
        if(change == 1)
        {
            if(one == 'g')
            {
                System.out.println("You win!");
                x++;
                y++;
            }else{
                System.out.println("You lose.");
            }
        }
        if(change == 2)
        {
            if(two == 'g')
            {
                System.out.println("You win!");
                x++;
                y++;
            }else{
                System.out.println("You lose.");
            }
        }
        if(change == 3)
        {
            if(three == 'g')
            {
                System.out.println("You win!");
                x++;
                y++;
            }else{
                System.out.println("You lose.");
            }
        }
    }
}
}
