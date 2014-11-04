package projects.boxBug;
import info.gridworld.actor.Bug;

/**
 * Write a description of class DancingBug here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DancingBug extends Bug
{
private int count = 0;
private int turnCount = 0;
private int[] turns;

    public DancingBug(int[] t)
    {
        turns = t;
    }

    public void act()
    {
        if (turnCount == turns[count % turns.length])
        {
            super.act();
            turnCount = 0;
	count++;
        }
        else
        {
            turn();
	turnCount++;
        }
    }
}

