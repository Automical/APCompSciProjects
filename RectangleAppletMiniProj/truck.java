
/**
 * Write a description of class truck here.
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

public class truck extends vehicle
{
    public truck(int x, int y, int num, Color myC)
    {
        super(x, y, num, myC);
    }
    public void draw(Graphics2D g2)
    {
        super.draw(g2);
        Rectangle body = new Rectangle(super.right(), y()- 20, 15, 35);
        Ellipse2D.Double wheel = new Ellipse2D.Double(super.right() + 1, y() + 15, 12, 12);
        g2.draw(body);
        g2.draw(wheel);
    }
    public int right()
    {
        return super.right() + 15;
    }
    public void breakDown(Graphics2D g2)
    {
    }
}
