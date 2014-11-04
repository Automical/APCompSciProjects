package projects.critters;

import info.gridworld.actor.Actor;
import java.awt.Color;

public class Piece // extends Actor
{
   private Color color;

   public Piece(Color color)
   {
      this.color = color;
   }

   // returns color of this Piece
   public Color getColor()
   {
      return color;
   }
   
   public String toString()
   {   String stringColor= new String("No Color assigned yet");
       if (color==Color.black) stringColor=new String("Black");
       if (color==Color.red) stringColor=new String("Red");
       return stringColor;
    }

   // There may be fields, constructors, and methods that are not shown.
}