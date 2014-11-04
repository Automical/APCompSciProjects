package projects.boxBug;
import info.gridworld.actor.Bug;

/**
 * Write a description of class SpiralBug here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpiralBug extends Bug
{
    private int steps;
    private int sideLength;
    public SpiralBug(int length)
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
            turn();
            steps = 0;
sideLength++;
	
        }
    }
}
