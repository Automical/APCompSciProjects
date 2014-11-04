package projects.critters;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import java.util.ArrayList;
import info.gridworld.grid.Grid;
import java.awt.Color;

/**
 * Write a description of class RockDropper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RockDropper extends Critter
{
public RockDropper(Color c)
{
    setColor(c);
}
    public void makeMove(Location loc)
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location lo = getLocation();
        
        if (gr.isValid(loc))

        moveTo(loc);
        if(loc != lo)
        {
        Rock ro = new Rock(getColor());
        ro.putSelfInGrid(gr, lo);
    }

    }
}
