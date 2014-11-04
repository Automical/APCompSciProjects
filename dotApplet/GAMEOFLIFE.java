
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import java.awt.geom.*;

import java.applet.*;
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
public class GAMEOFLIFE extends JApplet implements ActionListener
{
    // instance variables - replace the example below with your own
    private static final int XMAX = 40;
    private static final int XMIN = 0;
    private static final int YMAX = 40;
    private static final int YMIN = 0;
    private int x;
    private final String ButtonText = "Next";
     MouseListener listener;
     ActionListener lis;
     int currentX=-5;
     int currentY=-5;
     int count = 0;
     //Graphics g;
//Graphics2D g2 = (Graphics2D)g;
private Dot d;
     boolean win = false;
     //squares[][] board;
        squares[][] board = new squares[40][40];
        int currentx = -5, currenty = -5;
        Graphics2D g2;
     TextField text = new TextField(20);   
int numClicks = 0;

     /**
     * Called by the browser or applet viewer to inform this JApplet that it
     * has been loaded into the system. It is always called before the first 
     * time that the start method is called.
     */
    public void init()
    {
        JRootPane rootPane = this.getRootPane();
        rootPane.putClientProperty("defeatSystemEventQueneCheck", Boolean.TRUE);
        listener = new MouseClickedListener();
        addMouseListener(listener);
        //lis = new ActionListener();
        for(int i = 0; i < 40; i++)
        {
            for(int z = 0; z < 40; z++)
            {
                board[i][z] = new squares(i,z);
            }
        }
        JPanel buttonPanel = new JPanel();
        Button b1 = new Button("Next Generation");
        buttonPanel.add(b1);
        buttonPanel.add(text);
        b1.addActionListener(this);
        Container contentHolder = getContentPane();
        contentHolder.add(buttonPanel, BorderLayout.SOUTH);
        
    }
    //public classActions
    public void actionPerformed(ActionEvent e)
    {
        Button source = (Button)e.getSource();
        if(source.getLabel() == "Next Generation"){
        board[1][1].colony();
        next();
        numClicks++;
                text.setText("Button Clicked " + numClicks + " times");
        
    }
        //String command = e.getActionCommand();
        //if(command.equals("Next Generation"));
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
        double yscale = (getHeight() - 21)/(YMAX-YMIN);
        g2.scale(xscale,yscale);
        //g2.translate(-XMIN, -YMAX);
        g2.setStroke(new BasicStroke(.05F));
        for(int i = 0; i < 40; i++)
        {
        for(int z = 0; z < 40; z++)
        {
            if(board[i][z].status() == true) board[i][z].colony(g2);
            else board[i][z].dead(g2);
        }        
    }
    g2.setColor(Color.black);
    for(int i = 0; i <= 40; i++)
        {
            Line2D.Double one = new Line2D.Double(i, 0,i,40);
            g2.draw(one);
        }
        for(int i = 0; i <= 40; i++)
        {
            Line2D.Double two = new Line2D.Double(0, i,40,i);
            g2.draw(two);
        }
        

   //g2.drawString(Integer.toString(currenty), 1, 1);
    }
    
    public void next()
    {
        for(int i = 0; i < 40; i++)
        {
        for(int z = 0; z < 40; z++)
        {
            //int intuh = neighbors(i,z);
            //if(intuh <= 1) board[i][z].dead();
            //if(intuh == 3) board[i][z].colony();
            //if(intuh >= 4) board[i][z].dead();
            if(board[i][z].status()) board[i][z].dead();
            else board[i][z].colony();
        }
    }
        repaint();
    }
   
    
    public int neighbors(int x, int y)
    {
        int index = -1;
        for(int ex = x-1; ex <= x+1; ex++){
            for(int why = y-1; why <= y+1; why++){
                if(isValid(ex, why));
                if(board[ex][why].status());
                index++;
            }
        }
        return index;
    }
   
    public boolean isValid(int x, int y)
    {
        if(x >= 0 && x < 40)
        if(y >= 0 && y < 40)
        return true;
        return false;
    }
    
    public class MouseClickedListener implements MouseListener
    {
        public void mousePressed(MouseEvent event)
        {
            currentx = (int)(event.getX() * (XMAX-XMIN)/(getWidth() - 1.0));
            currenty = (int)(event.getY() * (YMAX-YMIN)/(479));
            if(board[currentx][currenty].status() == false){
        board[currentx][currenty].colony();
    }else{
        board[currentx][currenty].dead();
    }
            repaint();
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
