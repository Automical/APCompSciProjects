
/**
 * Write a description of class mergeTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class mergeTester
{
   public static void main(String[] args)
{
    int[] array = new int[10];
    array = ArrayUtil.randomIntArray(10, 100);
    mergeSorter m = new mergeSorter(array);
    m.print();
    m.sort();
    m.print();
}
}
