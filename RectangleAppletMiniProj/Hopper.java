
/**
 * Write a description of class Hopper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.*;
import java.awt.Color;
import java.util.Random;

public class Hopper extends bug
{
private static final int MAXSPEED = 10;
private static Random generator = new Random();
private boolean disabled = false;
private int animation = 1;
   public Hopper(int x, int y, int num)
    {
        super(x, y, num);
    }
     public Hopper(int x, int y, int num, Color c)
    {
        super(x, y, num, c);
    }
    public void draw(Graphics2D g2)
    {

        if(animation % 16 >= 8)frame1(g2);
        if(animation % 16 <= 7)frame2(g2);
    }
    private void frame1(Graphics2D g2)
    {

        super.draw(g2);
        Line2D.Double l1 = new Line2D.Double(x(), y() + 10, x(), y() + 20);
        Line2D.Double l2 = new Line2D.Double(x(), y() + 20, x() - 5, y() + 20);
        g2.draw(l1);
        g2.draw(l2);
        Line2D.Double r1 = new Line2D.Double(right(), y() + 10, right(), y() + 20);
        Line2D.Double r2 = new Line2D.Double(right(), y() + 20, right() + 5, y() + 20);
        g2.draw(r1);
        g2.draw(r2);
    }
    private void frame2(Graphics2D g2)
    {
  
        super.sety(super.y() - 10);
        super.draw(g2);
        super.sety(super.y() + 10);
        Line2D.Double l1 = new Line2D.Double(x(), y(), x(), y() + 20);
        Line2D.Double l2 = new Line2D.Double(x(), y() + 20, x() - 5, y() + 20);
        g2.draw(l1);
        g2.draw(l2);
        Line2D.Double r1 = new Line2D.Double(right(), y(), right(), y() + 20);
        Line2D.Double r2 = new Line2D.Double(right(), y() + 20, right() + 5, y() + 20);
        g2.draw(r1);
        g2.draw(r2);
        
    }
    public void erase(Graphics2D g2)
    {
        g2.setColor(Color.white);
        Line2D.Double l1 = new Line2D.Double(x(), y(), x(), y() + 20);
        Line2D.Double l2 = new Line2D.Double(x(), y() + 20, x() - 5, y() + 20);
        g2.draw(l1);
        g2.draw(l2);
        Line2D.Double r1 = new Line2D.Double(right(), y(), right(), y() + 20);
        Line2D.Double r2 = new Line2D.Double(right(), y() + 20, right() + 5, y() + 20);
        g2.draw(r1);
        g2.draw(r2);
        super.erase(g2);
    }
    public void moveRight(Graphics2D g2)
    {
        erase(g2);
             //x+=5;
              if(disabled != true)
              {
                  int deltax = generator.nextInt(MAXSPEED);
                  int breakdown = generator.nextInt(10);
                  if(deltax == MAXSPEED - 1 && breakdown == 9){disabled = true; place = 0;}
                  super.setx(x() + deltax);
                  animation++;
             }
             
             draw(g2);
    }
    public void dead(Graphics2D g2)
    {
        erase(g2);
        g2.setColor(Color.black);
        Line2D.Double l1 = new Line2D.Double(x(), y() + 10, x(), y() + 20);
        Line2D.Double l2 = new Line2D.Double(x(), y() + 20, x() - 5, y() + 20);
        g2.draw(l1);
        g2.draw(l2);
        Line2D.Double r1 = new Line2D.Double(right(), y() + 10, right(), y() + 20);
        Line2D.Double r2 = new Line2D.Double(right(), y() + 20, right() + 5, y() + 20);
        g2.draw(r1);
        g2.draw(r2);
        super.setColor(Color.black);
        super.draw(g2);
    }
}
