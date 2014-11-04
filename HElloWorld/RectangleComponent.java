
/**
 * Write a description of class RectangleComponent here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;

public class RectangleComponent extends JComponent
{
    public void paintComponent(Graphics g)
    {
        //Recover Graphics2D
        //Casting Graphics g to g2
        Graphics2D g2 = (Graphics2D) g;
        //                            x, y, w, h
        Rectangle box = new Rectangle(5,10,20,30);
        g2.draw(box);
        box.translate(15,25);
        g2.draw(box);
    }
}
