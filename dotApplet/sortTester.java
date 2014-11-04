
/**
 * Write a description of class sortTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Random;
import java.awt.*;
public class sortTester
{
    // instance variables - replace the example below with your own
    private static Random gen = new Random();
    public static void main(String[] args)
    {
        
        int[] a = new int[100];
        for(int i = 0; i < a.length; i++)
        {
            a[i] = gen.nextInt(500);
        }
        
        for(int i = 0; i < a.length; i++)
        {
            if(i != a.length){System.out.print(a[i] + ", ");}else{System.out.print(a[i]);}
        }
        System.out.println();
        System.out.println("sorted data");
        bubbleSort(a);
        for(int i = 0; i < a.length - 1; i++)
        {
            if(i != a.length){System.out.print(a[i] + ", ");}else{System.out.print(a[i]);}
        }
       
    }//end of main
    
    public static void bubbleSort(int[] a)
    {
        boolean sorted;
        do{
                sorted = true;
                for(int i = 0; i < a.length - 1;i++)
                {
                   if(a[i] > a[i+1])
                   {
                       swap(a, i, i + 1);
                       sorted = false;
                   }
                }
        }while(!sorted);
    
    }
    
    public static void bubbleSort(int[] a, Graphics2D g2)
    {
        boolean sorted;
        do{
                sorted = true;
                for(int i = 0; i < a.length - 1;i++)
                {
                   if(a[i] > a[i+1])
                   {
                       swap(a, i, i + 1, g2);
                       sorted = false;
                   }
                }
        }while(!sorted);
    
    }
    
    public static void colorSort(Dot[] d, Graphics2D g2)
    {
        int[] c = new int[d.length];
        for(int i = 0; i < c.length - 1; i++)
        {
            c[i] = d[i].getColor();
        }
        
        boolean sorted;
        do{
                sorted = true;
                for(int i = 0; i < d.length - 1;i++)
                {
                   if(c[i] > c[i+1])
                   {
                       swap3(c, i, i + 1, g2);
                       sorted = false;
                   }
                }
        }while(!sorted);
    
    }
    
    public static void swap(int[] a, int i, int j)
    {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    
    public static void swap(int[] a, int i, int j, Graphics2D g2)
    { 
        Dot d1 = new Dot(i, a[i], Color.black);
        Dot d2 = new Dot(j, a[j], Color.blue);
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
        d1.teleport(g2, i,a[i]);
        d2.teleport(g2, j,a[j]);
    }
    
    
    public static void swap3(int[] a, int i, int j, Graphics2D g2)
    { 
        Dot d1 = new Dot(a[i], i, Dot.pickAColor(a[i]));
        Dot d2 = new Dot(a[j], j, Dot.pickAColor(a[j]));
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
        d1.teleport(g2, a[i],i);
        d2.teleport(g2, d2.getColor() * gen.nextInt(100),j);
    }
    /*
    public static void swap2(int[] c, int i, int j, Graphics2D g2)
    {
        Dot d1 = new Dot(i, a[i], Color.black);
        Dot d2 = new Dot(j, a[j], Color.blue);
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
        d1.teleport(g2, i,a[i]);
        d2.teleport(g2, j,a[j]);
    }
   */
   public static void colorSwap(Dot[] d, int[] c, double i, double j, Graphics2D g2)
    { 
        double x1 = d[(int)i].getX();
        double x2 = d[(int)j].getX();
        Dot d1 = new Dot(x1, i, Dot.pickAColor(c[(int)i]));
        Dot d2 = new Dot(x2, j, Dot.pickAColor(c[(int)j]));
        double tmp = x1;
        x1 = x2;
        x2 = tmp;
        d1.teleport(g2, x1,i);
        d2.teleport(g2, x2,i);
    }
       
}//end of sortTester
