
/**
 * Write a description of class mergeSorter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Arrays;
import java.util.Random;
import java.awt.Graphics2D;
import java.awt.Color;

public class mergeSorter
{
    private int[] a;
    private int start;
        private Graphics2D g2;
    public mergeSorter(int[] anArray)
    {
        a = anArray;
    }
    public mergeSorter(int[] anArray, Graphics2D asdf, int s)
    {
        a = anArray;
        g2 = asdf;
        start = s;
    }
    public void sort()
    {
        if(a.length <= 1) return;
        int[] first = new int[a.length/2];
        int[] second = new int[a.length - first.length];
        System.arraycopy(a, 0, first, 0, first.length);
        System.arraycopy(a, first.length, second, 0, second.length);
        mergeSorter firstSorter = new mergeSorter(first);
        mergeSorter secondSorter = new mergeSorter(second);
        firstSorter.sort();
        secondSorter.sort();
        a = merge(first, second);
    }
    public void vsort()
    {
        if(a.length <= 1) return;
        int[] first = new int[a.length/2];
        int[] second = new int[a.length - first.length];
        System.arraycopy(a, 0, first, 0, first.length);
        System.arraycopy(a, first.length, second, 0, second.length);
        mergeSorter firstSorter = new mergeSorter(first, g2, start);
        mergeSorter secondSorter = new mergeSorter(second, g2, first.length + start);
        firstSorter.vsort();
        secondSorter.vsort();
        a = vmerge(first, second);
        delay(5000);
    }
    public void print()
    {
        System.out.println(Arrays.toString(a));
    }
    public void display()
    {
        for(int i = 0; i < a.length; i++)
        {
            block b = new block(i, 499-a[i], a[i], 3, Color.black);
            b.draw(g2);
        }
    }
    private int[] merge(int[] array, int[]array2)
{
    int a1 = 0;
    int a2 = 0;
    int i = 0;
    while (a1 < array.length && a2 < array2.length)
    {
        if(array[a1] < array2[a2])
        {
            a[i] = array[a1];
            a1++;
        }else{
            a[i] = array2[a2];
            a2++;
        }
        i++;
    }
    System.arraycopy(array, a1, a, i, array.length - a1);
    System.arraycopy(array2, a2, a, i, array2.length - a2);
return a;
}
private int[] vmerge(int[] array, int[]array2)
{
    int a1 = 0;
    int a2 = 0;
    int i = 0;
    while (a1 < array.length && a2 < array2.length)
    {
        if(array[a1] < array2[a2])
        {
            block b = new block(a1 + start, 0, 500, 3, Color.blue);
            b.draw(g2);
            a[i] = array[a1];
            a1++;
            block d = new block(i + start, 499-a[i], a[i], 3, Color.green);
            d.draw(g2);
        }else{
            block b = new block(a2 + array.length + start, 0, 500, 3, Color.blue);
            b.draw(g2);
            a[i] = array2[a2];
            a2++;
            block d = new block(i + start, 499-a[i], a[i], 3, Color.red);
            d.draw(g2);
        }
        i++;
    }
    /**for(int z = 0; z < array.length - a1 - 1; z++)
    {
            block b = new block(a1 + start, 0, 500, 3, Color.white);
            b.draw(g2);
            a[i] = array[a1];
            a1++;
            block d = new block(i + start, 499-a[i], a[i], 3, Color.red);
            d.draw(g2);
            i++;
    }
    for(int z = 0; z < array2.length - a2 - 1; z++)
    {
            block b = new block(a2 + start, 0, 500, 3, Color.white);
            b.draw(g2);
            a[i] = array2[a2];
            a2++;
            block d = new block(i + start, 499-a[i], a[i], 3, Color.red);
            d.draw(g2);
            i++;
    }**/
    System.arraycopy(array, a1, a, i, array.length - a1);
    System.arraycopy(array2, a2, a, i, array2.length - a2);
return a;


}
public static void delay(int count)
   {
       for(int i = 0; i < count; i++)
           for(int j = 0; j < count; j++);    
   }
}



