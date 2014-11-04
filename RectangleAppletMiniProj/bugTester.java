
import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.util.ArrayList;
import java.awt.geom.*;

/**
 * Class bugTester - write a description of the class here
 * 
 * @author (your name) 
 * @version (a version number)
 */
public class bugTester extends JApplet
{
    // instance variables - replace the example below with your own
    private int place = 1;
    private static Random gen = new Random();
    private ArrayList<bug>bList;
     /**
     * Called by the browser or applet viewer to inform this JApplet that it
     * has been loaded into the system. It is always called before the first 
     * time that the start method is called.
     */
    public void init()
    {
        place = 1;
        bList = new ArrayList<bug>();
        int count = 1;
        for(int i = 0; i < 9; i++)
        {
            int rand = gen.nextInt(3);
            if(rand == 0)
            {
            Flier f = new Flier(50, 45 * i + 30, count, Color.green);   
            bList.add(f);
        }
            if(rand == 1)
            {
                Crawler c = new Crawler(50, 45 * i + 30, count, Color.blue);
                bList.add(c);
            }
            if(rand == 2)
            {
                Hopper h = new Hopper(50, 45 * i + 30, count, Color.red);
                bList.add(h);
            }
            count++;
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
        for(int i = 0; i < 9; i++)
        {
            bList.get(i).draw(g2);
        }
        Line2D.Double finishLine = new Line2D.Double(490, 0, 490, 500);
       g2.setColor(Color.black);
       g2.drawString("Finish",450,10);
       g2.draw(finishLine);
        while(checkWinnerv1(490) == 0 && checkBroken() == -1)
       {
          //for(int i = 0; i < 40; i++)
          //{
               for(int i = 0; i < bList.size(); i++)
               {    
                   if(bList.get(i).right() > 490 && bList.get(i).place == -1)
                   {bList.get(i).place = place; place++; bList.get(i).disabled = true;
                   String place = "th";
                   int placenum = bList.get(i).place;
                   if(placenum == 1){place = "st";}
                   if(placenum == 2){place = "nd";}
                   if(placenum == 3){place = "rd";}
                   if(placenum != 0){ g2.drawString(placenum+place+" place.",bList.get(i).right() + 10,25 + (i * 45));} 
                   
                   }
                   else
                   {
                   bList.get(i).moveRight(g2);}
                   g2.setColor(Color.black);
                   g2.draw(finishLine);
                   if(bList.get(i).place == 0){g2.drawString("DEAD",10,43 + (i * 45));bList.get(i).dead(g2);}
               }              
               //vehicle.delay(DELAY);
         delay(7500);
        }
    }

    /**
     * Called by the browser or applet viewer to inform this JApplet that it
     * is being reclaimed and that it should destroy any resources that it
     * has allocated. The stop method will always be called before destroy. 
     */
     public int checkWinner(double x)
    {
        int tmp = -1;
        
        for(int i = 0; i < bList.size(); i++)
        {
            if(bList.get(i).right() > x)
            {
                tmp = i;
                //c[i].place = place;
                //place++;
                break;
            }
        }
        return tmp;
    }
    //This one
    public int checkWinnerv1(double x)
    {
        int tmp = 0;
        
        for(int i = 0; i < bList.size(); i++)
        {
            if(bList.get(i).place != -1)
            {
                tmp = 1;
                //c[i].place = place;
                //place++;
            }
            else
            {
                tmp = 0;
                break;
            }
        }
        return tmp;
    }
    public int checkBroken()
    {
        int tmp = -1;
        for(int i = 0; i < bList.size(); i++)
        {
            if(bList.get(i).disabled == true)
            {
                tmp = i;
            }
            else
            {
                tmp = -1;
                break;
            }
        }
        return tmp;
    }
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
