
/**
 * Write a description of class emptyFrameViewer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.JFrame;
public class emptyFrameViewer
{
   public static void main(String[] args)
   {
       JFrame frame = new JFrame();
       frame.setSize(300,400);
       //frame.setTitle("Austin Is Cool also it's an empty frame!");
       frame.setTitle("2 Rectangles");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       RectangleComponent component = new RectangleComponent();
       frame.add(component);
       frame.setVisible(true);
   }
}
