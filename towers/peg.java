
/**
 * Write a description of class peg here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class peg
{
int x, y;
int h = 250;
int pegnum = 0;
//public static int status = 0;
    public peg(int rx, int ry, int pn)
    {
        x = rx;
        y = ry;
        pegnum = pn;
    }
    public void draw(Graphics2D g2)
    {
        //Graphics2D g2 = (Graphics2D)g;
        Rectangle r = new Rectangle(x, y, 10, h);
        g2.setColor(Color.blue);
        g2.draw(r);
    }
    public int pegnum()
    {
        return pegnum;
    }
    //public static int next()
    //{
    //    return status * 20;
    //}
}
