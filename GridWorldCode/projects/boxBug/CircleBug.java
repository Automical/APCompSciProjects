package projects.boxBug;
import info.gridworld.actor.Bug;


/**
 * Write a description of class moarTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CircleBug extends Bug
{
    private int steps;
    private int sideLength;
    public CircleBug(int length)
    {
        steps = 0;
        sideLength = length;
    }
    public void act()
    {
        if (steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        else
        {
            turn();
            steps = 0;
        }
    }
}

