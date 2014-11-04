
/**
 * Write a description of class StringTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.lang.String;

public class StringTest
{
public static void main(String[] args)
{
    String s = "world";
    int n = 6;
    changer(s, n);
    System.out.println(s);
    System.out.println(n);
}
public static void changer(String x, int y)
{
x = x + "peace";
y = y * 2;
}
}
