
/**
 * Write a description of class coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Random;

public class coin
{
   private char state;
   Random gen = new Random();
   public coin()
   {
       int x = gen.nextInt(2);
       if (x == 0)
       {
       state = 'H';
    }else{
        state = 'T';
    }
}
    public coin(char c)
    {
        if (c == 'H')
        {
            state = 'H';
        }
        if (c == 'T')
        {
            state = 'T';
        }
    }
    public void setState(char c)
    {
        if (c == 'H')
        {
            state = 'H';
        }
        if (c == 'T')
        {
            state = 'T';
        }
    }
    public char getState()
    {
        return state;
    }
    public char flip()
    {
        int x = gen.nextInt(2);
       if (x == 0)
       {
       state = 'H';
       return state;
    }else{
        state = 'T';
        return state;
    }
}
}
