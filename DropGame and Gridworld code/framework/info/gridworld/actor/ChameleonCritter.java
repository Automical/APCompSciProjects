package framework.info.gridworld.actor;


/**
 * Write a description of class ChameleonCritter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


import info.gridworld.grid.Location;
import java.util.ArrayList;

public class ChameleonCritter extends Critter
{
   
public void processActors(ArrayList<Actor> actors)
{
    int n = actors.size();
    if ( n==0 ) return;
    int r = (int) (Math.random() * n);
    Actor other = actors.get(r);
    setColor(other.getColor());
}

public void makeMove(Location loc)
{
    setDirection(getLocation().getDirectionToward(loc));
    super.makeMove(loc);
}


   
}
