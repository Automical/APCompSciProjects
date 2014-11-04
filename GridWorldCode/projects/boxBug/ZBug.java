package projects.boxBug;
import info.gridworld.actor.Bug;

/**
 * Write a description of class ZBug here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ZBug extends Bug
{
    private int steps;
private int sideLength;
public int count = 0;
 
    public ZBug(int length)
    {
        steps = 0;
        sideLength = length;
        setDirection(90);
    }
    public void act()
    {
        if (steps < sideLength && canMove() && count < 3)
        {
            move();
            steps++;
        }
        else
        {
if(canMove())
{
    if(count == 0)
    {
            setDirection(225);
            steps = 0;
            count++;
        }else{
        if(count == 1)
        {
            setDirection(90);
            steps = 0;
            count++;
        }else{
        if(count == 2)
        {
            count = 3;
        }
    }
        }
    }
}
}
}