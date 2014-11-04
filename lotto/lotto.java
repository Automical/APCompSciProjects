
/**
 * Write a description of class lotto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class lotto
{
    // instance variables - replace the example below with your own
    private int x;

    public static void main(String[] args)
    {
        hopper hop1 = new hopper(56);
        hopper hop2 = new hopper(46);
        for(int i = 0; i < 5; i ++)
        {
        System.out.println(hop1.pick());
        }
        System.out.println("Megaball: " + hop2.pick());
    }
}
