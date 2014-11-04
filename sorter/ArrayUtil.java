
/**
 * Write a description of class ArrayUtil here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Random;

public class ArrayUtil
{
    private static Random gen = new Random();

   public static int[] randomIntArray(int length, int n)
   {
       int[] a = new int[length];
       for (int i = 0; i < length; i++)
       {
           a[i] = gen.nextInt(n);
        }
        return a;
    }
}
