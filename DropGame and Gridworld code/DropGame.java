import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class DropGame
{
   private Grid<Piece> theGrid;
   private ArrayList<Piece> winners = new ArrayList<Piece>();

   // Precondition: 0 <= column < theGrid.getNumCols()
   // @return null if no empty locations in column;
   // otherwise, the empty location with the
   // largest row index within the specified column;

   public Location dropLocationForColumn(int column)
   {
      for (int r = theGrid.getNumRows() - 1; r >= 0; r--)
      {
         Location nextLoc = new Location(r, column);
         if (theGrid.get(nextLoc) == null)
         {
            return nextLoc;
         }
      }
      return null;
   }

   // Precondition: 0 <= column < theGrid.getNumCols()
   // @return true if dropping a piece of the given color into the
   // specified column matches color with three neighbors;
   // otherwise, false
   /**public boolean dropMatchesNeighbors(int column, Color pieceColor)
   {
      Location loc = dropLocationForColumn(column);
      if (loc == null)
      {
         return false;
      }

      ArrayList<Piece> neighbors = theGrid.getNeighbors(loc);
      int colorCount = 0;
      for (Piece nextNbr : neighbors)
      {
         if (nextNbr.getColor().equals(pieceColor))
         {
            colorCount++;
         }
      }

      return (colorCount >= 4);
   }**/

   public boolean dropMatchesNeighbors(int column, Color pieceColor)
   {
      Location loc = dropLocationForColumn(column);
      if (loc == null)
      {
         return false;
      }
      ArrayList<Piece> neighbors = theGrid.getNeighbors(loc);
      ArrayList<Piece> FRIENDS = new ArrayList<Piece>();
      int friendcount = 0;
      for (Piece nextNbr : neighbors)
      {
         if (nextNbr.getColor().equals(pieceColor))
         {
            FRIENDS.add(nextNbr);
         }
      }
      for(Piece fr:FRIENDS)
      {
          ArrayList<Piece> prelim = new ArrayList<Piece>();
          friendcount = 0;
          Location lo = fr.getLocation();
          int dir = loc.getDirectionToward(lo);
          int op = dir + 180;
          Location alo = lo.getAdjacentLocation(dir);
          Location aalo = alo.getAdjacentLocation(dir);
          Location olo = loc.getAdjacentLocation(op);
          Location oolo = olo.getAdjacentLocation(op);         
          if(theGrid.isValid(lo))
          {
              if(theGrid.get(lo) instanceof Piece){
          if(theGrid.get(lo).getColor().equals(pieceColor)) 
          {
              friendcount++;
              prelim.add(theGrid.get(lo));
          if(theGrid.isValid(alo))
          {
              if(theGrid.get(alo) instanceof Piece){
          if(theGrid.get(alo).getColor().equals(pieceColor)) {
          friendcount++;
          prelim.add(theGrid.get(alo));
          if(theGrid.isValid(aalo)){
              if(theGrid.get(aalo) instanceof Piece){
          if(theGrid.get(aalo).getColor().equals(pieceColor)){
          friendcount++;
          prelim.add(theGrid.get(aalo));
        }}}}}}}}}
        if(theGrid.isValid(olo))
          {
              if(theGrid.get(olo) instanceof Piece){
          if(theGrid.get(olo).getColor().equals(pieceColor)) 
          {
              friendcount++;
              prelim.add(theGrid.get(olo));
          if(theGrid.isValid(oolo))
          {
              if(theGrid.get(oolo) instanceof Piece){
          if(theGrid.get(oolo).getColor().equals(pieceColor)) {
          friendcount++;
          prelim.add(theGrid.get(oolo));
        }}}}}}
          
          if(friendcount >=3){ winners = prelim;
              //winners.add(theGrid.get(loc));
          return true;}

      }
      return false;
   }
   
    public int Neighbors(int column, Color pieceColor)
   {
      Location loc = dropLocationForColumn(column);
      if (loc == null)
      {
         return 0;
      }
      ArrayList<Piece> neighbors = theGrid.getNeighbors(loc);
      ArrayList<Piece> FRIENDS = new ArrayList<Piece>();
      int friendcount = 0;
      int rf = 0;
      for (Piece nextNbr : neighbors)
      {
         if (nextNbr.getColor().equals(pieceColor))
         {
            FRIENDS.add(nextNbr);
         }
      }
      for(Piece fr:FRIENDS)
      {
          ArrayList<Piece> prelim = new ArrayList<Piece>();
          friendcount = 0;
          Location lo = fr.getLocation();
          int dir = loc.getDirectionToward(lo);
          int op = dir + 180;
          Location alo = lo.getAdjacentLocation(dir);
          Location aalo = alo.getAdjacentLocation(dir);
          Location olo = loc.getAdjacentLocation(op);
          Location oolo = olo.getAdjacentLocation(op);         
          if(theGrid.isValid(lo))
          {
              if(theGrid.get(lo) instanceof Piece){
          if(theGrid.get(lo).getColor().equals(pieceColor)) 
          {
              friendcount++;
              prelim.add(theGrid.get(lo));
          if(theGrid.isValid(alo))
          {
              if(theGrid.get(alo) instanceof Piece){
          if(theGrid.get(alo).getColor().equals(pieceColor)) {
          friendcount++;
          prelim.add(theGrid.get(alo));
          if(theGrid.isValid(aalo)){
              if(theGrid.get(aalo) instanceof Piece){
          if(theGrid.get(aalo).getColor().equals(pieceColor)){
          friendcount++;
          prelim.add(theGrid.get(aalo));
        }}}}}}}}}
        if(theGrid.isValid(olo))
          {
              if(theGrid.get(olo) instanceof Piece){
          if(theGrid.get(olo).getColor().equals(pieceColor)) 
          {
              friendcount++;
              prelim.add(theGrid.get(olo));
          if(theGrid.isValid(oolo))
          {
              if(theGrid.get(oolo) instanceof Piece){
          if(theGrid.get(oolo).getColor().equals(pieceColor)) {
          friendcount++;
          prelim.add(theGrid.get(oolo));
        }}}}}}                    
        if(friendcount > rf) rf = friendcount;
      }
      return rf;
   }
   public int line(int column, Color pieceColor)
   {
      Location loc = dropLocationForColumn(column);
      int numNeighbors = 0;
      if (loc == null)
      {
         return 0;
      }
      ArrayList<Piece> neighbors = theGrid.getNeighbors(loc);
      ArrayList<Piece> FRIENDS = new ArrayList<Piece>();
      int friendcount = 0;
      for (Piece nextNbr : neighbors)
      {
         if (nextNbr.getColor().equals(pieceColor))
         {
            FRIENDS.add(nextNbr);
         }
      }
      for(Piece fr:FRIENDS)
      {
          ArrayList<Piece> prelim = new ArrayList<Piece>();
          friendcount = 0;
          Location lo = fr.getLocation();
          int dir = loc.getDirectionToward(lo);
          int op = dir + 180;
          Location alo = lo.getAdjacentLocation(dir);
          Location aalo = alo.getAdjacentLocation(dir);
          Location olo = loc.getAdjacentLocation(op);
          Location oolo = olo.getAdjacentLocation(op);         
          if(theGrid.isValid(lo))
          {
              if(theGrid.get(lo) instanceof Piece){
          if(theGrid.get(lo).getColor().equals(pieceColor)) 
          {
              friendcount++;
              prelim.add(theGrid.get(lo));
          if(theGrid.isValid(alo))
          {
              if(theGrid.get(alo) instanceof Piece){
          if(theGrid.get(alo).getColor().equals(pieceColor)) {
          friendcount++;
          prelim.add(theGrid.get(alo));
          if(theGrid.isValid(aalo)){
              if(theGrid.get(aalo) instanceof Piece){
          if(theGrid.get(aalo).getColor().equals(pieceColor)){
          friendcount++;
          prelim.add(theGrid.get(aalo));
        }}}}}}}}}
        if(theGrid.isValid(olo))
          {
              if(theGrid.get(olo) instanceof Piece){
          if(theGrid.get(olo).getColor().equals(pieceColor)) 
          {
              friendcount++;
              prelim.add(theGrid.get(olo));
          if(theGrid.isValid(oolo))
          {
              if(theGrid.get(oolo) instanceof Piece){
          if(theGrid.get(oolo).getColor().equals(pieceColor)) {
          friendcount++;
          prelim.add(theGrid.get(oolo));
        }}}}}}
          
          if(friendcount > numNeighbors){ 
              numNeighbors = friendcount;
      }
    }
      return numNeighbors;
   }

   
   public ArrayList<Piece> getWinners()
   {
       return winners;
    }
   // There may be fields, constructors, and methods that are not shown.

   public DropGame(Grid<Piece> gr)
   {
      theGrid = gr;
   }
}
