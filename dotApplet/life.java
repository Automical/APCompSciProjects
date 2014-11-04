
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import java.awt.geom.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JPanel;

/**
 * Class life - write a description of the class here
 * 
 * @author (your name) 
 * @version (a version number)
 */
public class life extends JApplet
{
    // instance variables - replace the example below with your own
    private int x;
    squares[][] board = new squares[50][50];

     /**
     * Called by the browser or applet viewer to inform this JApplet that it
     * has been loaded into the system. It is always called before the first 
     * time that the start method is called.
     */
    public void init()
    {
        JRootPane rootPane = this.getRootPane();    
        rootPane.putClientProperty("defeatSystemEventQueueCheck", Boolean.TRUE);
        for(int i = 0; i < 50; i++)
        {
            for(int z = 0; z < 50; z++)
            {
                board[i][z] = new squares(i,z);
            }
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
        for(int i = 0; i < 500; i += 10)
        {
            Line2D.Double one = new Line2D.Double(i, 0,i,500);
            g2.draw(one);
        }
        for(int i = 0; i < 500; i += 10)
        {
            Line2D.Double one = new Line2D.Double(0, i,500,i);
            g2.draw(one);
        }
        board[25][25].colony(g2);
        board[26][20].colony(g2);
    }
    
    public void run(Graphics2D g2)
    {
         for(int i = 0; i < 50; i++)
        {
            for(int z = 0; z < 50; z++)
            {
                liveordie(i, z);
            }
        }
        
        reprint(g2);
    }
    public void liveordie(int x, int y)
    {
        if(board[x][y].filled = true)
        {
            if(check(x,y) <= 1 || check(x,y) >=4)
            {
                board[x][y].filled = false;
            }
        }
        if(board[x][y].filled = false)
        {
            if(check(x,x) == 3)
            {
                board[x][y].filled = true;
            }
        }
    }
    public int check(int x, int y)
    {
        int count = 0;
        if(x - 1 >= 0)
        {
            if(board[x-1][y-1].filled == true)count++;
            if(board[x-1][y].filled == true)count++;
            if(board[x-1][y+1].filled == true)count++;
        }
        if(x + 1 <= 499)
        {
            if(board[x+1][y-1].filled == true)count++;
            if(board[x+1][y-1].filled == true)count++;
            if(board[x+1][y-1].filled == true)count++;
        }
        if(y - 1 >= 0)
        {
            if(board[x][y+1].filled == true)count++;
        }
        if(y + 1 <= 499)
        {
            if(board[x][y-1].filled == true)count++;
        }
        return count;
    }
    public void reprint(Graphics2D g2)
    {
        for(int i = 0; i < 50; i++)
        {
            for(int z = 0; z < 50; z++)
            {
                board[i][z].colony(g2);
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
}
