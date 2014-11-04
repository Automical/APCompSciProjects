
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

/**
 * Class carRace - write a description of the class here
 * 
 * @author (your name) 
 * @version (a version number)
 */
public class carRace extends JApplet
{
    // instance variables - replace the example below with your own
    private int x;
    private static final int DELAY = 10000;
    private int place = 1;
    //private static final int AMOUNT = 10;
    Car[] c = new Car[10];
     /**
     * Called by the browser or applet viewer to inform this JApplet that it
     * has been loaded into the system. It is always called before the first 
     * time that the start method is called.
     */
    public void init()
    {
        // this is a workaround for a security conflict with some browsers
        // including some versions of Netscape & Internet Explorer which do 
        // not allow access to the AWT system event queue which JApplets do 
        // on startup to check access. May not be necessary with your browser. 
        JRootPane rootPane = this.getRootPane();    
        rootPane.putClientProperty("defeatSystemEventQueueCheck", Boolean.TRUE);
    
        // provide any initialisation necessary for your JApplet
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
       Graphics2D g2 = (Graphics2D) g;
       
       for(int i = 0; i < c.length; i++)
       {
           c[i] = new Car(10,30 + (i * 40),i + 1);
           c[i].draw(g2);
       }
       //Car c1 = new Car(10, 30, Color.blue);
       //Car c2 = new Car(10, 70, Color.black);
       
       //**ONLY MODIFY THE X OF POINT S FOR THE FINISH LINE LOCATON!!**
       Point2D.Double s = new Point2D.Double(490, 0);
       //**ONLY MODIFY THE X OF POINT S FOR THE FINISH LINE LOCATON!!**
       
       Point2D.Double e = new Point2D.Double(s.x, 500);
       Line2D.Double finishLine = new Line2D.Double(s, e);
       g2.setColor(Color.black);
       g2.drawString("Finish",450,10);
       g2.draw(finishLine);
       //c1.draw(g2);
       //c2.draw(g2);
       while(checkWinnerv1(s.x) == 0 && checkBroken() == -1)
       {
          //for(int i = 0; i < 40; i++)
          //{
               for(int i = 0; i < c.length; i++)
               {    
                   if(c[i].right() > s.x && c[i].place == -1)
                   {c[i].place = place; place++; c[i].disabled = true;
                   String place = "th";
                   int placenum = c[i].place;
                   if(placenum == 1){place = "st";}
                   if(placenum == 2){place = "nd";}
                   if(placenum == 3){place = "rd";}
                   if(placenum != 0){ g2.drawString(placenum+place+" place.",c[i].right() + 10,30 + (i * 40));} 
                   
                   }
                   else
                   {c[i].moveRight(g2);}
                   g2.setColor(Color.black);
                   g2.draw(finishLine);
                   if(c[i].place == 0){g2.drawString("DNF",10,43 + (i * 40));}
               }
               
          //}
               Car.delay(DELAY);
          /* 
          for(int j = 0; j < 40; j++)
          {
                c1.moveLeft(g2);
                c2.moveLeft(g2);
                Car.delay(DELAY);
          }*/
        }
        /*
       g2.setColor(Color.black);
       for(int i = 0; i <= c.length; i++)
       {
           String place = "th";
           int placenum = c[i].place;
           if(placenum == 1){place = "st";}
           if(placenum == 2){place = "nd";}
           if(placenum == 3){place = "rd";}
           //if(placenum == 0){g2.drawString((i + 1)+" didnt finish the race!",10,30 + (i * 40));}
           //else
           //{
                //g2.drawString((i + 1)+" came in "+placenum+place+" place.",10,30 + (i * 40));
                if(placenum != 0)
                {
                    g2.drawString(placenum+place+" place.",c[i].right() + 10,30 + (i * 40));
                } 
                else
                {
                    g2.drawString("DNF",10,43 + (i * 40));
                }
           //}
       }
       */
       //g2.drawString("The winner is car number " + (checkWinner(s.x) + 1) + "!", 150, 10);
       
    }
    public int checkWinner(double x)
    {
        int tmp = -1;
        
        for(int i = 0; i < c.length; i++)
        {
            if(c[i].right() > x)
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
        
        for(int i = 0; i < c.length; i++)
        {
            if(c[i].place != -1)
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
        for(int i = 0; i < c.length; i++)
        {
            if(c[i].disabled == true)
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
