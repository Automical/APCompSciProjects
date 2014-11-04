package projects.critters;


import java.awt.Color;

public class Piece
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
       if (color==Color.white) stringColor=new String("White");
       return stringColor;
    }

   // There may be fields, constructors, and methods that are not shown.
}