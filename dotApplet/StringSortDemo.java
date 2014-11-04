
/**
 * Write a description of class StringSortDemo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StringSortDemo
{
    private ArrayList<String> myList;
    public void main(String[] args)
    {
        System.out.println("Enter strings.");
        Scanner myScanner = new Scanner(System.in);
        myList = new ArrayList<String>();
        String str = "  ";
        while(!str.equals("stop"))
        {
            str = myScanner.next();
            if(str.equals("stop"))break;
            myList.add(str);            
        }
        System.out.println("----------------------------------------------");
        for(int i = 0; i < myList.size(); i++)
        {
            System.out.println(myList.get(i));
        }
        System.out.println();
        Collections.sort(myList);
         for(int i = 0; i < myList.size(); i++)
        {
            System.out.println(myList.get(i));
        }
        System.out.println();
        Collections.sort(myList, new StringComparator());
         for(int i = 0; i < myList.size(); i++)
        {
            System.out.println(myList.get(i));
        }
    }
}
