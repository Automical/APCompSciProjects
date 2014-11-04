
/**
 * Write a description of class bug here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.*;
import java.awt.Color;
import java.util.Random;
//import java.awt.*;
//import javax.swing.*;

public abstract class bug
{
   
/**
 * Write a description of class vehicle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


    private static final int MAXSPEED = 10;
    private static final int WIDTH = 20;
    private static final int HEIGHT = 15;
    private int x;
    private int y;
    private int carNum;
    public boolean disabled = false;
    public int place = -1;    
    private static Random generator = new Random();
    private Color c;
    private int mySpeed;
    
    
    public bug(int myX, int myY, int myNum)
    {
        // initialise instance variables
        x = myX;
        y = myY;
        carNum = myNum;
        //c = Color.black;
        c = pickAColor();
    }
    public bug(int myX, int myY, int myNum, Color myColor)
    {
        x = myX;
        y = myY;
        carNum = myNum;
        c = myColor;
    }
    public void draw(Graphics2D g2)
    {      
        Ellipse2D.Double body = new Ellipse2D.Double(x, y, WIDTH, WIDTH);
        Ellipse2D.Double eyeL = new Ellipse2D.Double(x + 5, y + 6, 4, 4);
        Ellipse2D.Double eyeR = new Ellipse2D.Double(x + 11, y + 6, 4, 4);
        g2.setColor(c);
        g2.draw(body); 
        g2.fill(eyeL);
        g2.fill(eyeR);
        //g2.drawString(Integer.toString(carNum), x + (WIDTH / 2) - (WIDTH / 12), y + HEIGHT - (HEIGHT / 10));
    }
    public void erase(Graphics2D g2)
    {
        Color tempColor = c; //Storing the cars color in tempColor
        c = Color.white; //change the car's color to white
        draw(g2); //Draw the white car to make it 'erase'
        c = tempColor; //Set color back to the original color
    }
    public abstract void moveRight(Graphics2D g2);
    public abstract void dead(Graphics2D g2);
        
    
    public void moveLeft(Graphics2D g2)
    {
             erase(g2);
             //x+=5;
              if(disabled != true)
              {
                  int deltax = generator.nextInt(MAXSPEED);
                  int breakdown = generator.nextInt(10);
                  if(deltax == MAXSPEED - 1 && breakdown == 9){disabled = true; place = 0;}
                  x-=deltax;
             }
             draw(g2);
    }
    public int right()
    {
     return (x + WIDTH);   
     //return x; 
    }
    public int x()
    {
        return x;
    }
    public int y()
    {
        return y;
    }
    public void setx(int num)
    {
        x = num;
    }
    public void sety(int num)
    {
        y = num;
    }
    public Color getColor()
    {
        return c;
    }
    public void setColor(Color aColor)
    {
        c = aColor;
    }
    public Color pickAColor()
    {
        int colorNumber = generator.nextInt(8);
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
    public static void delay(int count)
    {
        for(int i = 0; i < count; i++)
            for(int j = 0; j < count; j++);    
    }
    //public abstract void breakDown(Graphics2D g2);
    




}
