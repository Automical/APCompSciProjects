package projects.critters;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import java.util.ArrayList;
import info.gridworld.grid.Grid;
import java.awt.Color;

/**
 * Write a description of class RockEater here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RockEater extends Critter
{
public RockEater(Color c)
{
setColor(c);
}
    public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> a = getGrid().getOccupiedLocations();
        ArrayList<Location> keep = new ArrayList<Location>();
        for(Location loc: a)
        {
            if(getGrid().get(loc) instanceof Rock)
            keep.add(loc);
        }
        return keep;
    }
}
