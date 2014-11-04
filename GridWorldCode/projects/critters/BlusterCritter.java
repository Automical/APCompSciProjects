package projects.critters;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.util.ArrayList;
import info.gridworld.grid.Grid;
import java.awt.Color;

/**
 * Write a description of class BlusterCritter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlusterCritter extends Critter
{
private int s = 3;
private static final double DARKENING_FACTOR = 0.05;
private static final double BRIGHTENING_FACTOR = 0.20;

    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> a = new ArrayList<Actor>();
        for(int i = -2; i <= 2; i++)
        {
            for(int z = -2; z <= 2; z++)
            {
                Location l = new Location(getLocation().getRow() + i, getLocation().getCol() + z);
                if(getGrid().isValid(l))
                {
                    if(getGrid().get(l) != null)
                    {
                        a.add(getGrid().get(l));
                    }
                }
            }
        }
        return a;
    }
    public void processActors(ArrayList<Actor> actors)
    {
        if(actors.size() >= s){
            Color c = getColor();
            int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
            int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
            int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));
            setColor(new Color(red, green, blue));
        }else{
            Color c = getColor();
            int red = (int) ((255 - c.getRed()) * (BRIGHTENING_FACTOR) + c.getRed());
            int green = (int) ((255 - c.getGreen()) * (BRIGHTENING_FACTOR) + c.getGreen());
            int blue = (int) ((255 - c.getBlue()) * (BRIGHTENING_FACTOR) + c.getBlue());
            setColor(new Color(red, green, blue));
        }
    }
}
