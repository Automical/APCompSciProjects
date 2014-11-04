
/**
 * Write a description of class quickSorter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Random;
import java.awt.Graphics2D;
import java.awt.Color;
import java.util.Arrays;

public class quickSorter
{
   private int[] a;
   private Graphics2D g2;
   public quickSorter(int[] array)
   {
       a = array;
    }
    public quickSorter(int[] array, Graphics2D asdf)
    {
        a = array;
        g2 = asdf;
    }
    public void sort(int from, int to)
    {
        if(from >= to) return;
        int p = partition(from, to);
        sort(from, p);
        sort(p + 1, to);
    }
    public void vsort(int from, int to)
    {
        if(from >= to) return;
        int p = vpartition(from, to);
        vsort(from, p);
        vsort(p + 1, to);
    }
    private int partition(int from, int to)
    {
        int pivot = a[from];
        int i = from - 1;
        int j = to + 1;
        while(i < j)
        {
            i++;
            while(a[i] < pivot) i++;
            j--;
            while(a[j] > pivot) j--;
            if(i < j) swap(i, j);
        }
        return j;
    }
    private int vpartition(int from, int to)
    {
        int pivot = a[from];
        int i = from - 1;
        int j = to + 1;
        while(i < j)
        {
            i++;
            while(a[i] < pivot) i++;
            j--;
            while(a[j] > pivot) j--;
            if(i < j) vswap(i, j);
        }
        return j;
    }
    private void swap(int num, int target)
    {
        int tmp = a[num];
        a[num] = a[target];
        a[target] = tmp;        
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
    private void vswap(int num, int target)
    {
        block b1 = new block(num, 499-a[num], a[num], 3, Color.red);
        b1.draw(g2);
        block b2 = new block(target, 499-a[target], a[target], 3, Color.red);
        b2.draw(g2);
        delay(5000);
        b1.erase(g2);
        b2.erase(g2);
        int tmp = a[num];
        a[num] = a[target];
        a[target] = tmp;
        block b3 = new block(num, 499-a[num], a[num], 3, Color.magenta);
        b3.draw(g2);
        block b4 = new block(target, 499-a[target], a[target], 3, Color.magenta);
        b4.draw(g2);
        
    }
     public static void delay(int count)
   {
       for(int i = 0; i < count; i++)
           for(int j = 0; j < count; j++);    
   }
        
}
