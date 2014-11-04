
/**
 * Write a description of class Flyer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.*;
import java.awt.Color;
import java.util.Random;

public class Flier extends bug
{
private static final int MAXSPEED = 10;
private static Random generator = new Random();
private boolean disabled = false;
private int animation = 1;

    public Flier(int x, int y, int num)
    {
        super(x, y, num);
    }
     public Flier(int x, int y, int num, Color c)
    {
        super(x, y, num, c);
    }
    public void draw(Graphics2D g2)
    {

        if(animation % 16 >= 8)frame1(g2);
        if(animation % 16 <= 7)frame2(g2);
        //animation++;
    }
    private void frame1(Graphics2D g2)
    {
        super.sety(super.y() + 5);
        super.draw(g2);
        super.sety(super.y() - 5);
        Line2D.Double w1 = new Line2D.Double(x() - 15, y() - 5, x(), y() + 10);
        Line2D.Double w2 = new Line2D.Double(right(), y() + 10, right() + 15, y() - 5);
        g2.draw(w1);
        g2.draw(w2);
    }
    private void frame2(Graphics2D g2)
    {
        super.sety(super.y() - 5);
        super.draw(g2);
        super.sety(super.y() + 5);
        Line2D.Double w1 = new Line2D.Double(x() - 15, y() + 20, x(), y() + 10);
        Line2D.Double w2 = new Line2D.Double(right(), y() + 10, right() + 15, y() + 20);
        g2.draw(w1);
        g2.draw(w2);
    }
    public void erase(Graphics2D g2)
    {
        g2.setColor(Color.white);
        Line2D.Double w1 = new Line2D.Double(x() - 15, y() - 5, x(), y() + 10);
        Line2D.Double w2 = new Line2D.Double(right(), y() + 10, right() + 15, y() - 5);
        g2.draw(w1);
        g2.draw(w2);
        Line2D.Double w3 = new Line2D.Double(x() - 15, y() + 20, x(), y() + 10);
        Line2D.Double w4 = new Line2D.Double(right(), y() + 10, right() + 15, y() + 20);
        g2.draw(w3);
        g2.draw(w4);
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
        Line2D.Double w1 = new Line2D.Double(x() - 15, y() - 5, x(), y() + 10);
        Line2D.Double w2 = new Line2D.Double(right(), y() + 10, right() + 15, y() - 5);
        g2.draw(w1);
        g2.draw(w2);
        super.setColor(Color.black);
        super.draw(g2);
    }
}
