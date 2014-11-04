
import java.awt.*;
import javax.swing.*;

/**
 * Class appletDemo2012 - write a description of the class here
 * 
 * @author (your name) 
 * @version (a version number)
 */
public class rectangleAppletMiniProj extends JApplet
{
    // instance variables - replace the example below with your own
    private int i;
    private int z;
    private static final int DELAY = 4000;

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
        i = 0;
        z = 0;
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
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.blue);
        Rectangle r1 = new Rectangle(0,0,100,100);
        g2.draw(r1);
        //g.drawRect(0,0,100,100);
        g2.setColor(Color.magenta);
        Rectangle r2 = new Rectangle(0,400,100,100);
        g2.draw(r2);
        //g.drawRect(0,400,100,100);
        g2.setColor(Color.black);
        Rectangle r3 = new Rectangle(400,0,100,100);
        g2.draw(r3);
        //g.drawRect(400,0,100,100);
        g2.setColor(Color.red);
        Rectangle r4 = new Rectangle(400,400,100,100);
        g2.draw(r4);
       // g.drawRect(400,400,100,100);
      for(int count = 0; count < 1; count++)
      {
            for(i = 0; i <= 80; i++)
            {
               g2.setColor(Color.blue);
               //g.drawRect(i,0,100,100);
               r1.translate(5,0);
               g2.draw(r1);
               g2.setColor(Color.magenta);
              // g.drawRect(i,400,100,100);
               r2.translate(5,0);
               g2.draw(r2);
               g2.setColor(Color.red);
               //g.drawRect(400 - i, 400, 100, 100);
               r3.translate(-5,0);
               g2.draw(r3);
               g2.setColor(Color.black);
               //g.drawRect(400 - i, 0, 100, 100);
               r4.translate(-5,0);
               g2.draw(r4);
               pause(DELAY);
               g2.setColor(Color.white);
               g2.draw(r1);
               g2.draw(r2);
               g2.draw(r3);
               g2.draw(r4);
               //g.drawRect(i,0,100,100);
               //g.drawRect(i,400,100,100);
               //g.drawRect(400 - i, 400, 100, 100);
               //g.drawRect(400 - i, 0, 100, 100);
            }
            
            
            for(z = 0; z <= 40; z++)
            {
               g2.setColor(Color.blue);
               r1.translate(-5,5);
               g2.draw(r1);
               //g.drawRect((i - z) - 2,z + 7,100,100);
               g2.setColor(Color.magenta);
               r2.translate(-5,-5);
               g2.draw(r2);
               //g.drawRect((i - z) - 5,405 - z,105,105);
               g2.setColor(Color.red);
               r3.translate(5,5);
               g2.draw(r3);
               //g.drawRect(412 - i + z, 410 - z, 95, 95);
               g2.setColor(Color.black);
               r4.translate(5,-5);
               g2.draw(r4);
               //g.drawRect(400 - i + z, z, 115, 115);
               pause(DELAY);
               if(z != 40)
               {
               g2.setColor(Color.white);
               g2.draw(r1);
               g2.draw(r2);
               g2.draw(r3);
               g2.draw(r4);
               //g.drawRect((i - z) - 2,z + 7,100,100);
               //g.drawRect((i - z) - 5,405 - z,105,105);
               //g.drawRect(412 - i + z, 410 - z, 95, 95);
               //g.drawRect(400 - i + z, z, 115, 115);
              }
            }
            pause(100000);
    
            for(z = 200; z >= 0; z--)
            {
               g.setColor(Color.blue);
               g.drawRect((i - z) - 2,z + 7,100,100);
               g.setColor(Color.magenta);
               g.drawRect((i - z) - 5,405 - z,105,105);
               g.setColor(Color.red);
               g.drawRect(412 - i + z, 410 - z, 95, 95);
               g.setColor(Color.black);
               g.drawRect(400 - i + z, z, 115, 115);
               pause(DELAY);
               g.setColor(Color.white);
               g.drawRect((i - z) - 2,z + 7,100,100);
               g.drawRect((i - z) - 5,405 - z,105,105);
               g.drawRect(412 - i + z, 410 - z, 95, 95);
               g.drawRect(400 - i + z, z, 115, 115);
            }
          g.setColor(Color.white);
          g.drawRect((i - z) - 2,z + 7,100,100);
          g.drawRect((i - z) - 5,405 - z,105,105);
          g.drawRect(412 - i + z, 410 - z, 95, 95);
          g.drawRect(400 - i + z, z, 115, 115);
          g.setColor(Color.magenta);
          g.drawRect(400,400,100,100);
          g.setColor(Color.blue);
          g.drawRect(400,0,100,100);
          g.setColor(Color.red);
          g.drawRect(0,400,100,100);
          g.setColor(Color.black);
          g.drawRect(0,0,100,100);
          for(i = 0; i <= 400; i+=5)
            {
               g.setColor(Color.black);
               g.drawRect(i,0,100,100);
               g.setColor(Color.red);
               g.drawRect(i,400,100,100);
               g.setColor(Color.magenta);
               g.drawRect(400 - i, 400, 100, 100);
               g.setColor(Color.blue);
               g.drawRect(400 - i, 0, 100, 100);
               pause(DELAY);
               g.setColor(Color.white);
               g.drawRect(i,0,100,100);
               g.drawRect(i,400,100,100);
               g.drawRect(400 - i, 400, 100, 100);
               g.drawRect(400 - i, 0, 100, 100);
            }
     }
     g.setColor(Color.blue);
     g.drawRect(0,0,100,100);
     g.setColor(Color.magenta);
     g.drawRect(0,400,100,100);
     g.setColor(Color.black);
     g.drawRect(400,0,100,100);
     g.setColor(Color.red);
     g.drawRect(400,400,100,100);
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
    
    public void pause(int d)
    {
        for(int i = 0; i < d; i++)
            for(int j = 0; j < d; j++);
    }
}
