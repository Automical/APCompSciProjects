package projects.CONNECTFOUR;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import java.util.ArrayList;
import info.gridworld.grid.Grid;
import java.awt.Color;

/**
 * Write a description of class CHIPS here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CHIP extends Critter
{
    private boolean stopped = false;
    private int color;
    public CHIP()
    {
        setColor(Color.red);
        color = 0;
        setDirection(180);
    }
    public CHIP(int n)
    {
        if(n == 0){
        setColor(Color.red);
        color = 0;
    }else{
        setColor(Color.black);
        color = 1;
    }
        setDirection(180);
    
    }
    public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> al = new ArrayList<Location>();
        int row, col;
        row = getLocation().getRow();
        col = getLocation().getCol();
        if(row < 6){
            row++;
        if(!(getGrid().get(new Location(row, col)) instanceof Actor))
        al.add(new Location(row, col));
    }
    if(al.isEmpty())stopped = true;
        return al;
    }
    public void processActors(ArrayList<Actor> actors)
    {
         ArrayList<Actor> al = new ArrayList<Actor>();
         for(Actor a: actors)
         {
             if(a instanceof CHIP)
             if(a.getColor() == getColor())
             al.add(a);
            }
    }
    public int returnColor()
    {
        return color;
    }
}
