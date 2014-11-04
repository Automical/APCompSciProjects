
/**
 * Write a description of class HelloWorldDemo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HelloWorldDemo
{
    public static void main(String[] args)
    {
        int count = Integer.parseInt(args[0]);
        for(int i = 0; i < count; i++)
        System.out.println("Hello World!");    
        System.out.println("The strings you entered were: " + args[0] + ", " + args[1]);
    }
}
