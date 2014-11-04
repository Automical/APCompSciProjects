
import java.awt.*;
import javax.swing.*;
import java.util.Random;

/**
 * Class finalProject - write a description of the class here
 * 
 * @author (your name) 
 * @version (a version number)
 */
public class finalProject extends JApplet
{
    // instance variables - replace the example below with your own
    private static final int AMOUNT = 500;
    private static final int DELAY = 3000;
    
    //For a C
    Dot[] d = new Dot[AMOUNT];
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
        // simple text displayed on applet
        //
        for(int i = 0; i < AMOUNT; i++)
        {
            d[i] = new Dot();
        }
        Graphics2D g2 = (Graphics2D)g;
        for(int i = 0; i < AMOUNT; i++)
        {
            d[i].draw(g2);
            delay(DELAY);
        }
        //For a C
        /*
        for(int i = 0; i < AMOUNT; i++)
        {
            d[i].erase(g2);
            delay(DELAY);
        }
        */
       
       //For a C+
       /*
       for(int i = AMOUNT - 1; i >= 0; i--)
       {
           d[i].erase(g2);
           delay(DELAY);
       }
       */
       
       //For a B
       /*
       for(int i = 0; i < AMOUNT; i++)
       {
           d[i].fall(g2);
       }  
       */
       //For a B+
       /*
       for(int i = 0; i < AMOUNT; i++)
       {
           d[i].fallPlus(g2);
       }
       */
       
       //For a A
       /*
       while(dotsLoc() == false)
       {
           for(int i = 0; i < AMOUNT; i++)
           {
               d[i].smallFall(g2);
           }
       }
       */
      
      //For an A+
      while(dotsLoc() == false)
      {
         
          for(int i = 0; i < AMOUNT; i++)
          {
              //d[i].smallFall(g2, (d[i].getY() / (497 - d[i].getY())));
              d[i].smallFall(g2, ((500 - d[i].getY())) / d[i].getY());
          }
      
    }
    
  }
    
    public boolean dotsLoc()
    {
        boolean allDone = false;
        for(int i = 0; i < AMOUNT; i++)
        {
           if(d[i].getY() < 497)
           {
               allDone = true;
           }
           else
           {
               allDone = false;
               break;
           }
        }
        return allDone;
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
