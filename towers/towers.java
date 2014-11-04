
/**
 * Write a description of class towers here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import javax.swing.JOptionPane;

public class towers
{

public static void Towers(int n, char frompeg, char topeg, char auxpeg)
{
    if (n == 1){
    towerTester.count++;
    System.out.println(towerTester.count + ". " + frompeg + " --> " + topeg);
}else{
        Towers(n-1, frompeg, auxpeg, topeg);
        Towers(n-1, auxpeg, topeg, frompeg);
        towerTester.count++;
        System.out.println(towerTester.count + ". " + frompeg + " --> " + topeg);
    }
}
public static void vTowers(int n)
{
    
    if (n == 1){
    towerTester.count++;
    System.out.println(towerTester.count + ". " + frompeg + " --> " + topeg);
}else{
        Towers(n-1, frompeg, auxpeg, topeg);
        Towers(n-1, auxpeg, topeg, frompeg);
        towerTester.count++;
        System.out.println(towerTester.count + ". " + frompeg + " --> " + topeg);
    }
}
}