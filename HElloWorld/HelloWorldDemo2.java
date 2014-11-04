
/**
 * Write a description of class HelloWorldDemo2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.JOptionPane;

public class HelloWorldDemo2
{
    public static void main(String[] args)
    {
        String name = JOptionPane.showInputDialog("Enter your name: ");
        String count = JOptionPane.showInputDialog("Enter a number: ");
        if(Integer.parseInt(count) < 1000)
        {
            for(int i = 0; i < Integer.parseInt(count); i++)
            System.out.println("Hello World, " + name + ".");
        }
        System.exit(0);
    }
}
