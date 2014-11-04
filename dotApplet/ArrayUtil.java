
import java.util.Random;
// this class contains utility methods for array manipulation
public class ArrayUtil
{
    /*
     * Creates an array filled with random values
     * param length the length of the array
     * param n the number of posible random values
     * return an array filled with length values between 1 and n-1
     */
     public static int[] randomIntArray(int length, int n)
     {
        int[] a = new int[length];
        Random generator = new Random();
        
        for(int i=0;i<length;i++)
            a[i]=generator.nextInt(n);
            
        return a;
     } 
     
      /* prints all elements in an array
      * param a the array to print
      */
     public static void print(int[] a)
     {
        for(int i=0; i< a.length; i++)
        {
            System.out.print(a[i] + ",");
            if ((i+1) % 25 ==0 ) System.out.println();
        }
        System.out.println();
     }

         
     
}// end of ArrayUtil class
