
/**
 * Write a description of class sortTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Arrays;

public class sortTester
{

    public static void main(String[] args)
    {
        int ar = 3000;
        StopWatch sw = new StopWatch();
        System.out.println("N \t  \t Select \t Insert \t InsertPlus \t Merge");
        System.out.println("- \t \t ------ \t ------ \t ---------- \t -----");
        for(int i = 0; i < 30; i ++)
        {
        sw.reset();
        int[] array = new int[ar];
        int[] array2 = new int[ar];
        int[] array3 = new int[ar];
        int[] array4 = new int[ar];
        array = ArrayUtil.randomIntArray(ar, 100);
        System.arraycopy(array, 0, array2, 0, array.length);
        System.arraycopy(array, 0, array3, 0, array.length);
        System.arraycopy(array, 0, array4, 0, array.length);
        SelectionSort d = new SelectionSort(array);
        InsertionSort s = new InsertionSort(array2);
        InsertionSort m = new InsertionSort(array3);
        mergeTest g = new mergeTest(array4);
        //InsertionSort t = new InsertionSort(array4);
        //s.randomize();
        // System.out.println(Arrays.toString(array));
        sw.start();
        s.sort();
        sw.stop();
         //System.out.println(Arrays.toString(array3));
        // System.out.println();
         System.out.print(ar + "\t \t");
         //for(int z = 0; z < sw.getTime()/15; z++)
         //{
         //    System.out.print(".");
         //}
         System.out.print(sw.getTime());
         //System.out.println();
        sw.reset();
        sw.start();
        d.sort();
        sw.stop();
        System.out.print("\t \t" + sw.getTime());
        sw.reset();
        sw.start();
        m.sortPlus();
        sw.stop();
        System.out.print("\t \t" + sw.getTime());
        //System.out.println(Arrays.toString(array3));
        sw.reset();
        sw.start();
        g.sort();
        sw.stop();
        System.out.println("\t \t" + sw.getTime());
         ar = ar + 1000;
        }
    }
}
