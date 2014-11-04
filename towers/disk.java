
/**
 * Write a description of class disk here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class disk
{
   int num;
   double l, w;
   int pegnum = -1;
   int status = 0;
   int x, y;
   public disk(int number)
   {
       num = number;
       l = 20;
       w = 15 * (num + 1);
       pegnum = 1;
       status = 5 - num;
       x = (int)((pegnum * 125 - 29) - (w/2 - 10));
       y =  350 - status * 20;
    }
    public void draw(Graphics2D g2)
    {
        Rectangle r = new Rectangle(x,y, (int)w, (int)l);
        g2.setColor(Color.blue);
        g2.fill(r);
        
    }
    public void move(Graphics2D g2, peg p1, peg p2)
    {
        double inc = (450 - y)/ 100;
        for(int i = 0; i < 100; i++)
        {
            erase(g2);
            y -= (int)inc;
            draw(g2);
            p1.draw(g2);
            delay(5000);
        }
        
        for(int i = 0; i < 100; i++)
        {
            erase(g2);
            y += (int)inc;
            draw(g2);
            p1.draw(g2);
            delay(5000);
        }
    }
    public void erase(Graphics2D g2)
    {
         Rectangle r = new Rectangle(x, y, (int)w, (int)l);
        g2.setColor(Color.white);
        g2.fill(r);
    }
        
    public static void delay(int count)
   {
       for(int i = 0; i < count; i++)
           for(int j = 0; j < count; j++);    
   }
}
