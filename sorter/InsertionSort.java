
/**
 * Write a description of class InsertionSort here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InsertionSort
{
    private int[] a;
     public InsertionSort(int[] anArray)
    {
        a = anArray;
    }
    public void sort()
    {
        swap(minimumPosition(0), 0);
        for(int i = 2; i < a.length; i++)
        {
            int z = i;
            while(a[z] < a[z-1])
            {
                swap(z, z-1);
                z--;
            }
        }
    }
    public void sortPlus()
    {
        swap(minimumPosition(0), 0);
        for(int i = 2; i < a.length; i++)
        {
            int n = a[i];
            int z = i - 1;
            while(n < a[z])
            {
                a[z+ 1] = a[z];
                z--;
            }
            a[z + 1] = n;
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
}
