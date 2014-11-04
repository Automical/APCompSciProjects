
/**
 * Write a description of class factorial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class recursive
{

    public int fact(int n)
    {
        if(n == 1) return 1;
        return n * fact(n - 1);
    }
    public int fib(int n)
    {
        if(n == 1 || n == 2) return 1;
        return fib(n - 1) + fib(n-2);
    }
}
