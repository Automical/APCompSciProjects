
/**
 * Write a description of class block here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import java.awt.Rectangle;

public class block
{
   

 private double x;
   private double y;
   private int length, width;
   private Color myColor;
   private static Random gen = new Random();
   private static final int DIAMETER = 5;
   private int colorNumber = gen.nextInt(8);

   
   public block(int a, int b,int l, int w, Color c)
   {
        x = a;
        y = b;
        myColor = c;
        length = l;
        width = w;
   }
   
   public block(int a, int b, int l, int w)
   {
        x = a;
        y = b;
        myColor = pickAColor();
        length = l;
        width = w;
   }
   
   public block(double a, double b, int l, int w, Color c)
   {
        x = a;
        y = b;
        myColor = c;
        length = l;
        width = w;
   }
   
   public void setColor(Color c)
   {
       myColor = c;
   }
   
   public void draw(Graphics2D g2)
   {
       //I knew him so well :(.
       Rectangle d = new Rectangle((int)x, (int)y, width, length);
       g2.setColor(myColor);
       g2.fill(d);
   }
   
   public void erase(Graphics2D g2)
   {
        Color tmpc = myColor;
        myColor = Color.white;
        draw(g2);
        myColor = tmpc;
   }
   
   public void teleport(Graphics2D g2, double a, double b)
   {
        erase(g2);
        x = a;
        y = b;
        draw(g2);
   }
   
   public void move1(Graphics2D g2, int endX, int endY)
   {
     double w = y;
     if(endY == 0)
     {
         for(double i = x; i <= endX; i++)
         {
            teleport(g2, i, 0);
         }
     }
     if(endX == 0)
     {
         for(double i = y; i <= endY; i++)
         {
            teleport(g2, 0, i);
         }
     }
     if(endX != 0 && endY != 0)
     {
         for(double i = x; i <= endX; i++)
         {
            teleport(g2, i, w);
            if(endY != w){w++;}
         }
     }
   }
   
   public void move(Graphics2D g2, double deltx, double delty)
   {
       erase(g2);
       x += deltx;
       y += delty;
       draw(g2);
   }
   
   public void slide(Graphics2D g2, double deltx, double delty, int count, int delay)
   {
       for(int i = 0; i < count; i++)
       {
           move(g2, deltx, delty);
           delay((delay * 2) / 3);
       }
   }
   
   public void slide(Graphics2D g2, double finalx, double finaly, int delay)
   {
        double deltx = finalx - x;
        double delty = finaly - y;
        double num = 1;
        double slope = (double)delty / (double)deltx;
        if(finalx < x){num = -1;}
        //g2.drawString("slope = " + slope, 100, 100);
        while(finalx != x && finaly != y)
        {
            move(g2, num, slope);    
            delay((delay * 2) / 3);
        }
   }
   
   public void fall(Graphics2D g2)
   {
       //x += deltx;
       while(y < 500)
       {
        y += 1;
        draw(g2);
        delay(700);
       }
   }
   
   public void fallPlus(Graphics2D g2)
   {
       //x += deltx;
       while(y < 497)
       {
        move(g2, 0, 1);
        delay(1000);
       }
       draw(g2);
   }
   
   public void smallFall(Graphics2D g2)
   {
     if(y < 497)
     {
        move(g2, 0, 1);  
     }
   }
   
   public void smallFall(Graphics2D g2, int delty)
   {
     if(delty + (int)y > 497){delty = (int)y - delty;}
     if(y < 497)
     {
        move(g2, 0, delty);  
     }
   }
   
   public void smallFall(Graphics2D g2, double delty)
   {
     //if(delty + y > 497){delty = y - delty;}
     if(y < 497)
     {
        move(g2, 0, delty);  
     }
   }
  
   
   public Color pickAColor()
    {
        int colorNumber = gen.nextInt(9);
        switch (colorNumber)
        {
            case 0: return Color.red;
            case 1: return Color.blue;
            case 2: return Color.pink;
            case 3: return Color.black;
            case 4: return Color.green;
            case 5: return Color.cyan;
            case 6: return Color.magenta;
            case 7: return Color.gray;
            case 8: return Color.darkGray;
        }
        return Color.black;
    }
    
    
    public static Color pickAColor(int colorNumber)
    {
       
        switch (colorNumber)
        {
            case 0: return Color.red;
            case 1: return Color.blue;
            case 2: return Color.pink;
            case 3: return Color.black;
            case 4: return Color.green;
            case 5: return Color.cyan;
            case 6: return Color.magenta;
            case 7: return Color.gray;
            case 8: return Color.darkGray;
        }
        return Color.black;
    }
    
   public double getX()
   {
    return x;
   }
   
   public double getY()
   {
    return y;
   }
   
   public int getColor()
   {
     return colorNumber;
   }
   public static void delay(int count)
   {
       for(int i = 0; i < count; i++)
           for(int j = 0; j < count; j++);    
   }


}
