
/**
 * Write a description of class Dot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Dot implements Comparable<Dot>
{
   //TO-DO:
   //Gonna need a radius
   //Need color
   //location x, y
   
   //instance variables
   private double x;
   private double y;
   private int diameter;
   private Color myColor;
   private static Random gen = new Random();
   private static final int DIAMETER = 1;
   private int colorNumber = gen.nextInt(8);
   
   //constructors (always public)
   public Dot()
   {
        x = gen.nextInt(500) + 1;
        y = gen.nextInt(500) + 1;
        myColor = pickAColor();
        diameter = DIAMETER;
   }
   public Dot(int a, int b)
   {
        x = a;
        y = b;
        myColor = pickAColor();
        diameter = DIAMETER;
   }
   public Dot(double a, double b)
   {
        x = a;
        y = b;
        myColor = pickAColor();
        diameter = DIAMETER;
   }
   public Dot(int a, int b, Color c)
   {
        x = a;
        y = b;
        myColor = c;
        diameter = DIAMETER;
   }
   
   public Dot(int a, int b, int c)
   {
        x = a;
        y = b;
        myColor = pickAColor(c);
        diameter = DIAMETER;
   }
   
   public Dot(double a, double b, Color c)
   {
        x = a;
        y = b;
        myColor = c;
        diameter = DIAMETER;
   }

   public void draw(Graphics2D g2)
   {
       //I knew him so well :(.
       Ellipse2D.Double d;
       d = new Ellipse2D.Double(x,y,diameter,diameter);
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
    public int colorToNum()
    {
       
        
            if(myColor == Color.red) return 0;
            if(myColor == Color.blue) return 1;
            if(myColor == Color.pink) return 2;
            if(myColor == Color.black) return 3;
            if(myColor == Color.green) return 4;
            if(myColor == Color.cyan) return 5;
            if(myColor == Color.magenta) return 6;
            if(myColor == Color.gray) return 7;
            if(myColor == Color.darkGray) return 8;

        return 9;
    }
   public double getX()
   {
    return x;
   }
   
   public double getY()
   {
    return y;
   }
   
   public void setx(int num)
   {
       x = (double)num;
    }
    public void sety(int num)
   {
       y = (double)num;
    }
    public void setx(double num)
    {
        x = num;
    }
    public void sety(double num)
    {
        y = num;
    }
    public void setColor(Color c)
    {
        myColor = c;
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
   public int compareTo(Dot d)
   {
       if(y > d.getY()) return -1;
       if(y == d.getY()) return 0;
       return 1;

    }
}
