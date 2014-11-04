
/**
 * Write a description of class squares here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import java.awt.geom.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class squares
{
public int index;
public boolean filled = false;
private int x, y;

    public squares(int ex, int why)
    {
        x = ex;
        y = why;
    }
    public void nothing(){}
    public boolean status()
    {
        return filled;
    }
    public void setStatus(boolean b)
    {
        filled = b;
    }
    public void drawo(Graphics2D g2)
    {
       g2.setStroke(new BasicStroke(.05F));
       Ellipse2D.Double d;
       d = new Ellipse2D.Double(x,y,1,1);
       g2.setColor(Color.black);
       g2.draw(d);
    }
    public void drawx(Graphics2D g2)
    {
        g2.setStroke(new BasicStroke(.05F));
        Point2D.Double w1 = new Point2D.Double(x, y);
        Point2D.Double w2 = new Point2D.Double(x + 1, y);
        Point2D.Double w3 = new Point2D.Double(x, y + 1);
        Point2D.Double w4 = new Point2D.Double(x + 1, y + 1);
        Line2D.Double one = new Line2D.Double(w1, w4);
        Line2D.Double two = new Line2D.Double(w2, w3);
        g2.draw(one);
        g2.draw(two);
    }
    public void colony(Graphics2D g2)
    {
       filled = true;
       g2.setStroke(new BasicStroke(.05F));
       Ellipse2D.Double d;
       d = new Ellipse2D.Double(x,y,1,1);
       g2.setColor(Color.black);
       g2.fill(d);
    }
     public void colony()
    {
       filled = true;
    }
    public void dead(Graphics2D g2)
    {
       filled = false;
       g2.setStroke(new BasicStroke(.05F));
       Ellipse2D.Double d;
       d = new Ellipse2D.Double(x,y,1,1);
       g2.setColor(Color.white);
       g2.fill(d);
    }
    public void dead()
    {
       filled = false;
       
    }
}
