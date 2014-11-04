
/**
 * Write a description of class towerTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import javax.swing.JOptionPane;

public class towerTester
{
public static int count = 0;
   public static void main(String[] args)
   {
       String input = JOptionPane.showInputDialog("Enter n: ");
       int n = Integer.parseInt(input);
       System.out.println("Frompeg: " + 'A' + " Topeg: " + 'B' + " Auxpeg: " + 'C');
       towers.Towers(n, 'A', 'B', 'C');
       System.out.println(count + " moves.");
   }
}
