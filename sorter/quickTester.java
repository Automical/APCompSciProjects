
/**
 * Write a description of class quickTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class quickTester
{
   public static void main(String[] args)
{
    int[] array = new int[10];
    array = ArrayUtil.randomIntArray(10, 100);
    quickSorter q = new quickSorter(array);
    q.print();
    q.sort(0, array.length - 1);
    q.print();
}
}
