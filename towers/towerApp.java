
import java.awt.*;
import javax.swing.*;
import java.util.Stack;

/**
 * Class towerApp - write a description of the class here
 * 
 * @author (your name) 
 * @version (a version number)
 */
public class towerApp extends JApplet
{
    // instance variables - replace the example below with your own
    private int x;

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
        Stack s1 = new Stack();
        Stack s2 = new Stack();
        Stack s3 = new Stack();
         disk[] d = new disk[5];
         int pc1 = 0, pc2 = 0, pc3 = 0;
         Graphics2D g2 = (Graphics2D)g;     
         peg p1 = new peg(100, 100, 1);
         p1.draw(g2);
         peg p2 = new peg(225, 100, 2);
         p2.draw(g2);
         peg p3 = new peg(350, 100, 3);
         p3.draw(g2);
         Rectangle r = new Rectangle(25, 350, 400, 50);
         g2.setColor(Color.blue);
         g2.draw(r);
         g2.setColor(Color.red);
         for(int i = 4; i >= 0; i--)
         {
             d[i] = new disk(i);
             d[i].draw(g2);

             s1.push(d[i]);
         }
         d[0].move(g2, p1, p2);
        
         //disk d1 = new disk(1);
         //d1.draw(g2, 1, pc1);
         //pc1++;
         //disk d2 = new disk(2);
         //d2.draw(g2, 1, pc1);
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
