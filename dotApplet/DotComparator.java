
/**
 * Write a description of class DotComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Comparator;

public class DotComparator implements Comparator<Dot>
{
    public int compare(Dot d1, Dot d2)
    {
        return d1.colorToNum() - d2.colorToNum();
    }
    
}
