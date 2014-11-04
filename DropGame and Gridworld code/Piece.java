import java.awt.Color;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
public class Piece
{
   private Color color;
   private Location loc;
   
   public Piece(Color color)
   {
      this.color = color;
   }
   public Piece(Color color, Location lo)
   {
       loc = lo;
      this.color = color;
   }
   public void setColor(Color c)
   {
       color = c;
    }
   // returns color of this Piece
   public Color getColor()
   {
      return color;
   }

   public Location getLocation()
   {
       return loc;
    }
    public String toString()
    {
        return "";
    }
   // There may be fields, constructors, and methods that are not shown.
}
