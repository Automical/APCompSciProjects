
/**
 * Write a description of class SelectionSort here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Random;
import java.awt.Graphics2D;
import java.awt.Color;

public class SelectionSort
{
    private int count;
    private int[] a;
    Random gen = new Random();
    private Graphics2D g2;
    public SelectionSort(int[] anArray)
    {
        a = anArray;
    }
    public SelectionSort(int[] anArray,Graphics2D asdf)
    {
        g2 = asdf;
        a = anArray;
    }
    public void randomize()
    {
        int z = 0;
        for(int i = 0; i < a.length; i++)
        {
            a[i] = z;
            z++;
        }
        for(int i = gen.nextInt(50) + 50; i > 0; i--)
        {
            int n = gen.nextInt(a.length);
            int t = gen.nextInt(a.length);
            swap(n, t);
        }
        
    }
    public void sort()
    {
        for (int i = 0; i < a.length; i++)
        {
            int min = minimumPosition(i);
            swap(i, min);
        }
    }
     public void vsort()
    {
        for (int i = 0; i < a.length; i++)
        {
            int min = minimumPosition(i);
            vswap(i, min);           
        }
        
        
    }
    public void display()
    {
        for(int i = 0; i < a.length; i++)
        {
            block b = new block(i, 499-a[i], a[i], 3, Color.black);
            b.draw(g2);
        }
    }
    private int minimumPosition(int start)
    {
        int z = start;
        for (int i = start + 1; i < a.length; i++)
        {
            if(a[i] < a[z])
            {
                z = i;
            }
        }
        return z;
    }
    private void swap(int num, int target)
    {
        int tmp = a[num];
        a[num] = a[target];
        a[target] = tmp;        
    }
    private void vswap(int num, int target)
    {
        block b1 = new block(num, 499-a[num], a[num], 3, Color.magenta);
        b1.draw(g2);
        block b2 = new block(target, 499-a[target], a[target], 3, Color.magenta);
        b2.draw(g2);
        delay(5000);
        b1.erase(g2);
        b2.erase(g2);
        int tmp = a[num];
        a[num] = a[target];
        a[target] = tmp;
        block b3 = new block(num, 499-a[num], a[num], 3, Color.blue);
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

/**Dot dot = new Dot(num, a[num], Color.magenta);
        dot.draw(g2);
        Dot dot2 = new Dot(target, a[target], Color.magenta);
        dot2.draw(g2);
        delay(5000);
        dot.erase(g2);
        dot2.erase(g2);
        int tmp = a[num];
        a[num] = a[target];
        a[target] = tmp;
        Dot dot3 = new Dot(num, a[num], Color.blue);
        dot3.draw(g2);
        Dot dot4 = new Dot(target, a[target], Color.magenta);
        dot4.draw(g2);**/
