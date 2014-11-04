
/**
 * Write a description of class mergeTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Arrays;
import java.lang.Math;

public class mergeTest
{
private int[] a;
private int[]semi;
//private int[]temp2;
private int count = 0;
private int[][] split;
private int[][] temp;
private int[][] temp2;
private int[] diffa;

public mergeTest(int[] anArray)
{
    a = anArray;
    //temp = new int[a.length/8];
}
public void sort()
{
    split = new int[8][a.length / 8];
    temp = new int[4][a.length / 8 * 2];
    temp2 = new int[2][a.length / 8 * 4];
    int diff = a.length - a.length / 8 * 8;
    diffa = new int[diff];
    semi = new int[a.length / 8 * 8];
    //System.out.println(diff);
    for(int i = 0; i < 8; i++)
    {
        System.arraycopy(a, i * (a.length / 8), split[i], 0, a.length/8);
        InsertionSort d = new InsertionSort(split[i]);
        d.sortPlus();
        //System.out.println(Arrays.toString(split[i]));
    }
    System.arraycopy(a, a.length - diff, split[0], 0, diff);
    //System.out.println(diffa[0]);
    InsertionSort f = new InsertionSort(split[0]);
    f.sortPlus();
    //System.out.println(Arrays.toString(diffa));
    for(int i = 0; i < 4; i++)
    {
    temp[i] = merge(split[i * 2], split[i * 2 + 1]);
    }
    for(int i = 0; i < 2; i++)
    {
    temp2[i] = merge(temp[i * 2], temp[i * 2 + 1]);
    }
    semi = merge(temp2[0], temp2[1]);
    a = merge(semi, diffa);

}
private int[] merge(int[] array, int[]array2)
{
    //int ar = a.length/8;
    //int[] array = new int[ar];
    //int[] array2 = new int[ar];
    int[] both = new int[array.length + array2.length];
    int a1 = 0;
    int a2 = 0;
    //array = ArrayUtil.randomIntArray(ar, 100);
    //array2 = ArrayUtil.randomIntArray(ar, 100);
    //InsertionSort d = new InsertionSort(array);
    //InsertionSort s = new InsertionSort(array2);
    //System.out.println(Arrays.toString(array));
    //System.out.println(Arrays.toString(array2));
    //d.sortPlus();
    //s.sortPlus();
    //System.out.println(Arrays.toString(array));
    //System.out.println(Arrays.toString(array2));
    for(int i = 0; i < both.length; i++)
    {
        if(a1 == array.length)
        {
        both[i] = array2[a2];
        a2++;
        }else{
        if(a2 == array2.length)
        {
        both[i] = array[a1];
        a1++;
        }else{
            if(array[a1] < array2[a2])
            {
                both[i] = array[a1];
                a1++;
            }else{                
            if(array[a1] > array2[a2])
            {
                both[i] = array2[a2];
                a2++;
            }else{                
            if(array[a1] == array2[a2])
            {
                both[i] = array[a1];
                a1++;
            }
        }
        }
        }
    
    
}
}
    //System.out.println(Arrays.toString(both));
    return both;
}
    
}
/**if(a1 == ar && a2 != ar)
        {
            both[i] = array2[a2];
                a2++;
        }else{
        if(a2 == ar && a1 != ar)
        {
            both[i] = array[a1];
                a1++;
            }else{**/