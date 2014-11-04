
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.util.Collections;
import java.lang.Math;

/**
 * Class dotL - write a description of the class here
 * 
 * @author (your name) 
 * @version (a version number)
 */
public class dotL extends JApplet
{
    // instance variables - replace the example below with your own
    private int x;
    private ArrayList<Dot> dotList;
    private final static int DOTCOUNT = 500;

     /**
     * Called by the browser or applet viewer to inform this JApplet that it
     * has been loaded into the system. It is always called before the first 
     * time that the start method is called.
     */
    public void init()
    {
        dotList = new ArrayList<Dot>();
        for(int i = 0; i < DOTCOUNT; i++)
        {
            Dot d = new Dot();
            dotList.add(d);
        }
    }

    /**
     * Called by the browser or applet viewer to inform this JApplet that it 
     * should start its execution. It is called after the init method and 
     * each time the JApplet is revisited in a Web page. 
     */
    public void start()
    {
        // provide any code requred to run each time 
        // web page is visited
    }

    /** 
     * Called by the browser or applet viewer to inform this JApplet that
     * it should stop its execution. It is called when the Web page that
     * contains this JApplet has been replaced by another page, and also
     * just before the JApplet is to be destroyed. 
     */
    public void stop()
    {
        // provide any code that needs to be run when page
        // is replaced by another page or before JApplet is destroyed 
    }

    /**
     * Paint method for applet.
     * 
     * @param  g   the Graphics object for this applet
     */
    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        fixXs();
        drawDots(g2);
        Collections.sort(dotList);
        drawDots(g2);
        Collections.sort(dotList, new DotComparator());
        sweep(g2);
        drawCircle(g2);
        drawDots(g2);
        //iremoveDots(DOTCOUNT, g2);
    }
    public void fixXs()
    {
        for(int i = 0; i < dotList.size(); i++)
        {
            (dotList.get(i)).setx(i);
        }
    }
    public void drawDots(Graphics2D g2)
    {
        for(Dot d : dotList)
        {
            d.draw(g2);
        }
    }
    public void drawCircle(Graphics2D g2)
    {
        //int num = 0;
        //int count = 1;
        //for(int i = 0; i < 9; i++)
        //{
        //while(dotList.get(count).colorToNum() == dotList.get(count - 1).colorToNum());
        //{
        //    count++;
        //}
        int z = 0;
        for(Dot d : dotList)
        {
            d.setx(d.colorToNum() * Math.cos(z) * 15 + 250);
            d.sety(d.colorToNum() * Math.sin(z) * 15 + 250);
            d.draw(g2);
            z++;
        }
        for(int i = 0; i < 9; i++)
        {
            for(int c = 0; c < 360; c++)
            {
                for(int x = 0; x < 11; x++)
                {
                Dot d = new Dot(0,0,Color.white);
                d.setColor(d.pickAColor(i));
                d.setx((d.colorToNum() * 15 - x) * Math.cos(Math.toRadians(c)) + 250);
                d.sety((d.colorToNum() * 15 - x) * Math.sin(Math.toRadians(c)) + 250);
                d.draw(g2);
                
                }
            }
        }
            
        //num = count;
        //count++;
//}
    }
    public void removeDots(int num, Graphics2D g2)
    {
        for(int i = 0; i < num; i++)
        {
            sweep(g2);
            Dot d = dotList.remove(0);
            d.erase(g2);
            fixXs();
            drawDots(g2);
        }
    }
    public void sweep(Graphics2D g2)
    {
        for(int i = 0; i < dotList.size(); i++)
        {
            Dot d = dotList.get(i);
            d.erase(g2);
        }
    }
    public void iremoveDots(int num, Graphics2D g2)
    {
        for(int i = 0; i < num; i++)
        {
            Dot d = dotList.remove(0);
            d.erase(g2);
            for(int z = 0; z < dotList.size(); z++)
            {
            (dotList.get(z)).erase(g2);
            (dotList.get(z)).setx(z);
            (dotList.get(z)).draw(g2);
            }            
        }
    }
    /**
     * Called by the browser or applet viewer to inform this JApplet that it
     * is being reclaimed and that it should destroy any resources that it
     * has allocated. The stop method will always be called before destroy. 
     */
    public void destroy()
    {
        // provide code to be run when JApplet is about to be destroyed.
    }


    /**
     * Returns information about this applet. 
     * An applet should override this method to return a String containing 
     * information about the author, version, and copyright of the JApplet.
     *
     * @return a String representation of information about this JApplet
     */
    public String getAppletInfo()
    {
        // provide information about the applet
        return "Title:   \nAuthor:   \nA simple applet example description. ";
    }


    /**
     * Returns parameter information about this JApplet. 
     * Returns information about the parameters than are understood by this JApplet.
     * An applet should override this method to return an array of Strings 
     * describing these parameters. 
     * Each element of the array should be a set of three Strings containing 
     * the name, the type, and a description.
     *
     * @return a String[] representation of parameter information about this JApplet
     */
    public String[][] getParameterInfo()
    {
        // provide parameter information about the applet
        String paramInfo[][] = {
                 {"firstParameter",    "1-10",    "description of first parameter"},
                 {"status", "boolean", "description of second parameter"},
                 {"images",   "url",     "description of third parameter"}
        };
        return paramInfo;
    }
    public static void delay(int count)
   {
       for(int i = 0; i < count; i++)
           for(int j = 0; j < count; j++);    
   }
}
