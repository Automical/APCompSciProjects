
/**
 * Write a description of class convertible here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.*;
import java.awt.Color;
import java.util.Random;

public class convertible extends vehicle
{
    public convertible(int x, int y, int num, Color myC)
    {
        super(x, y, num, myC);
    }
    public void draw(Graphics2D g2)
    {
        super.draw(g2);
        Line2D.Double roof1 = new Line2D.Double(right() - 22, y() - 12, right() - 10, y());
        
        g2.draw(roof1);
        //g2.draw(roof2);
        //g2.draw(roof3);
    }
    public void breakDown(Graphics2D g2)
    {
    }
}
