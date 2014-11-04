
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
 * Class MouseClickApplet - write a description of the class here
 * 
 * @author (your name) 
 * @version (a version number)
 */
public class MouseClickDemo extends JApplet
{
    // instance variables - replace the example below with your own
    private static final int XMAX = 3;
    private static final int XMIN = 0;
    private static final int YMAX = 3;
    private static final int YMIN = 0;
    private int x;
     MouseListener listener;
     int currentX=-5;
     int currentY=-5;
     int count = 0;
     //Graphics g;
//Graphics2D g2 = (Graphics2D)g;
private Dot d;
     boolean win = false;
     //squares[][] board;
        squares[][] board = new squares[3][3];
        int currentx = -5, currenty = -5;

     /**
     * Called by the browser or applet viewer to inform this JApplet that it
     * has been loaded into the system. It is always called before the first 
     * time that the start method is called.
     */
    public void init()
    {
        JRootPane rootPane = this.getRootPane();
        rootPane.putClientProperty("defeatSystemEventQueneCheck", Boolean.TRUE);
        listener= new MouseClickedListener();
        addMouseListener(listener);
        for(int i = 0; i < 3; i++)
        {
            for(int z = 0; z < 3; z++)
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
        double xscale = (getWidth() - 1.0)/(XMAX-XMIN);
        double yscale = (getHeight() - 1.0)/(YMIN-YMAX);
        g2.scale(xscale,yscale);
        g2.translate(-XMIN, -YMAX);
        g2.setStroke(new BasicStroke(.05F));
        Line2D.Double one = new Line2D.Double(0, 1,3,1);
        Line2D.Double two = new Line2D.Double(0,2,3,2);
        Line2D.Double three = new Line2D.Double(1, 0,1,3);
        Line2D.Double four = new Line2D.Double(2,0,2,3);
        g2.draw(one);
        g2.draw(two);
        g2.draw(three);
        g2.draw(four);
        //Dot d = new Dot(currentX, currentY);
        //d.draw(g2);
         Font font = new Font("Arial", Font.PLAIN, 1);    
         g2.setFont(font);
         
        if(count % 2 == 1 && board[currentx][currenty].index == 0)
        {                      
           //g2.drawString(Integer.toString(board[currentx][currenty].index), currentx, currenty);
        board[currentx][currenty].drawo(g2);
        board[currentx][currenty].index = 1;
        count++;
        //g2.drawString(Integer.toString(board[currentx][currenty].index), currentx, currenty);  
    }else{
        //g2.drawString(Integer.toString(board[currentx][currenty].index), currentx, currenty);
        if(board[currentx][currenty].index == 0)
        {
        board[currentx][currenty].drawx(g2);
        board[currentx][currenty].index = 10;
        count++;
       // g2.drawString(Integer.toString(board[currentx][currenty].index), currentx, currenty);
    }
    
    }
    check(g2);
   //g2.drawString(Integer.toString(currenty), 1, 1);
    }
    
    public void check(Graphics2D g2)
    {
        if(board[0][0].index + board[0][1].index + board[0][2].index == 3)victory(g2, .5, .5, .5, 2.5, 0);
        if(board[1][0].index + board[1][1].index + board[1][2].index == 3)victory(g2, 1.5, .5, 1.5, 2.5, 0);
        if(board[2][0].index + board[2][1].index + board[2][2].index == 3)victory(g2, 2.5, .5, 2.5, 2.5, 0);
        if(board[0][0].index + board[1][0].index + board[2][0].index == 3)victory(g2, .5, .5, 2.5, .5, 0);
        if(board[0][1].index + board[1][1].index + board[2][1].index == 3)victory(g2, .5, 1.5, 2.5, 1.5, 0);
        if(board[0][2].index + board[1][2].index + board[2][2].index == 3)victory(g2, .5, 2.5, 2.5, 2.5, 0);
        if(board[0][0].index + board[1][1].index + board[2][2].index == 3)victory(g2, .5, .5, 2.5, 2.5, 0);
        if(board[0][2].index + board[1][1].index + board[2][0].index == 3)victory(g2, .5, 2.5, 2.5, .5, 0);
        if(board[0][0].index + board[0][1].index + board[0][2].index == 30)victory(g2, .5, .5, .5, 2.5, 1);
        if(board[1][0].index + board[1][1].index + board[1][2].index == 30)victory(g2, 1.5, .5, 1.5, 2.5, 1);
        if(board[2][0].index + board[2][1].index + board[2][2].index == 30)victory(g2, 2.5, .5, 2.5, 2.5, 1);
        if(board[0][0].index + board[1][0].index + board[2][0].index == 30)victory(g2, .5, .5, 2.5, .5, 1);
        if(board[0][1].index + board[1][1].index + board[2][1].index == 30)victory(g2, .5, 1.5, 2.5, 1.5, 1);
        if(board[0][2].index + board[1][2].index + board[2][2].index == 30)victory(g2, .5, 2.5, 2.5, 2.5, 1);
        if(board[0][0].index + board[1][1].index + board[2][2].index == 30)victory(g2, .5, .5, 2.5, 2.5, 1);
        if(board[0][2].index + board[1][1].index + board[2][0].index == 30)victory(g2, .5, 2.5, 2.5, .5, 1);
       
    }
    
    public void victory(Graphics2D g2, double s1x, double s1y, double s2x, double s2y, int winner)
    {
        win = true;
        Line2D.Double one = new Line2D.Double(s1x, s1y, s2x, s2y);
        g2.setColor(Color.red);
        g2.draw(one);
        
        //double xscale = (getWidth() - 1.0)/(XMAX-XMIN);
        //double yscale = (getHeight() - 1.0)/(YMAX - YMIN);
       // g2.translate(XMIN, YMAX);
        g2.scale(1,-1);
        //g2.translate(XMIN, YMAX);
        g2.setColor(Color.green);
        Font theFont = new Font("SansSerif",Font.PLAIN,20);
        theFont = theFont.deriveFont(.5f);
        g2.setFont(theFont);
        if(winner == 0)
        {
        g2.drawString("   O", 1, -2);
        }else{
        g2.drawString("   X", 1, -2);
        }
        g2.drawString("Wins", 1, -1);
    }
    

    
    public class MouseClickedListener implements MouseListener
    {
        public void mousePressed(MouseEvent event)
        {
            //currentX=(int)(event.getX());
            //currentY=(int)(event.getY());
            currentx = (int)(event.getX() * (XMAX - XMIN)/(getWidth() - 1.0) + XMIN);
            currenty = (int)(event.getY() * (YMIN - YMAX)/(getHeight() - 1.0) + YMAX);
            //board[currentx][currenty] = new squares(currentx,currenty);
            //board[x][y].drawo(x,y,g2);
            if(win == false)
            {
            repaint();
            }
            //d.draw(g2);
        }
        
        public void mouseClicked(MouseEvent event) {}
        public void mouseReleased(MouseEvent event) {}
        public void mouseEntered(MouseEvent event) {}
        public void mouseExited(MouseEvent event) {}
        
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


   // public String getAppletInfo()
   // {
        // provide information about the applet
       // return "Title:   \nAuthor:   \nA simple applet example description. ";
    //}


   
   /* public String[][] getParameterInfo()
    {
        // provide parameter information about the applet
        String paramInfo[][] = {
                 {"firstParameter",    "1-10",    "description of first parameter"},
                 {"status", "boolean", "description of second parameter"},
                 {"images",   "url",     "description of third parameter"}
        };
        return paramInfo;
    }*/
}
