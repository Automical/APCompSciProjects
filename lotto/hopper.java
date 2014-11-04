
/**
 * Write a description of class hopper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Random;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Font;


public class hopper
{
    // instance variables - replace the example below with your own
    private int number;
    private int count;
    Random gen = new Random();
    int[] ballNumber;
    /**
     * Constructor for objects of class hopper
     */
    public hopper()
    {
       number = gen.nextInt(10) + 1;
       count = number - 1;
       ballNumber = new int[number];
       for(int i = 0; i < number; i++)
       {
           ballNumber[i] = i + 1;
        }
    }
    
    public hopper(int num)
    {
        number = num;
        count = number - 1;
        ballNumber = new int[number];
        for(int i = 0; i < number; i++)
       {
           ballNumber[i] = i + 1;
        }
    }
    
    public int pick()
    {
        int rand;
        if(count > 0)
        {
        rand = gen.nextInt(count);
    }else{
        rand = 0;
    }
        int select = ballNumber[rand];
        swap(rand, count);
        count--;
        return select;
    
    }
    
    public void pickD(int ball, Dot[] d, Graphics2D g2)
    {
      
        int rand;
        if(count > 0)
        {
        rand = gen.nextInt(count);
    }else{
        rand = 0;
    }
        int select = ballNumber[rand];
        swap(rand, count);
        count--;
        draw(select, ball, g2);
        d[rand].setColor(Color.green);
        d[rand].drawB(rand, g2);
        delay(50000);
        d[rand].erase(g2);
     
}
    public void draw(int select,int ball, Graphics2D g2)
    {
       Font font = new Font("Arial", Font.PLAIN, 75);
       g2.setFont(font);
       Ellipse2D.Double d;
       if(ball < 5)
       {
       d = new Ellipse2D.Double(ball * 100,1,100,100);
       g2.setColor(Color.blue);
       g2.draw(d);
       g2.drawString("" + select, ball * 100 + 10,75);
    }else{
        d = new Ellipse2D.Double(1,200,100,100);
       g2.setColor(Color.red);
       g2.draw(d);
       g2.drawString("" + select, 10,275);
    }
    }
    
    public void swap(int num, int target)
    {
        int temp = ballNumber[target];
        ballNumber[target] = ballNumber[num];
        ballNumber[num] = temp;
    }
    public static void delay(int count)
   {
       for(int i = 0; i < count; i++)
           for(int j = 0; j < count; j++);    
   }
}
