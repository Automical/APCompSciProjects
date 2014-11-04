
/**
 * Write a description of class StringComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Collections;
import java.util.Comparator;
import java.lang.String;

public class StringComparator implements Comparator<String>
{
    public int compare(String s1, String s2)
    {
        return s1.length() - s2.length();
    }
}
