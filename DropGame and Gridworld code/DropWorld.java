
import java.awt.Color;

import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class DropWorld extends World<Piece>
{
   private DropGame game;
   private Color currentColor;
   private boolean gameOver;
   
   public static void main(String[] args)
   {
      DropWorld world = new DropWorld(7, 7);
      world.show();
   }
   
   public DropWorld(int rows, int cols)
   {
      super(new BoundedGrid<Piece>(rows, cols));
      game = new DropGame(getGrid());
      currentColor = Color.RED;
      flipTurn();
   }

   public void flipTurn()
   {
      if (currentColor.equals(Color.RED))
      {
         currentColor = Color.BLACK;
         setMessage("Black's turn");
      }
      else
      {
         currentColor = Color.RED;
         setMessage("Red's turn");
      }         
   }
   
   @Override
   public boolean locationClicked(Location loc)
   {
      if (gameOver) return false;
      Location dropLoc = game.dropLocationForColumn(loc.getCol());
      if (dropLoc == null) 
         setMessage("Illegal drop location, try again");
      else
      {
         if (game.dropMatchesNeighbors(loc.getCol(), currentColor))
         {
             if(currentColor == Color.red){
            setMessage("Congratulations--Red won");
            for(Piece pce:game.getWinners())
            {
                pce.setColor(Color.yellow);
            }
        }else{
            setMessage("Congratulations--BALC won");
            for(Piece pce:game.getWinners())
            {
                pce.setColor(Color.yellow);
            }
        }
            gameOver = true;
         }
         if(gameOver == true)
         {
         getGrid().put(dropLoc, new Piece(Color.yellow, dropLoc));
        }else{
            getGrid().put(dropLoc, new Piece(currentColor, dropLoc));
        }
      }
      if (!gameOver) flipTurn();
      return true;
   }     
}
