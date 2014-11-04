
import java.awt.Color;

import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;
import java.util.Random;

public class HardComp extends World<Piece>
{
   private DropGame game;
   private Color currentColor;
   private boolean gameOver;
   private Random gen = new Random();
   
   public static void main(String[] args)
   {
      HardComp world = new HardComp(7, 7);
      world.show();
   }
   
   public HardComp(int rows, int cols)
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
            setMessage("Congratulations--BALC won");
            for(Piece pce:game.getWinners())
            {
                pce.setColor(Color.yellow);
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
      
      Location compLoc = null;
      if (!gameOver) {
          flipTurn();
      
      if(compLoc == null)
      {
          for(int i = 0; i < 7; i++)
          {
          if(game.dropMatchesNeighbors(i, currentColor))
          compLoc = game.dropLocationForColumn(i);
          else
          if (compLoc == null){
          for(int z = 0; z < 7; z++)
      {
          if(game.dropMatchesNeighbors(z, Color.black))
          compLoc = game.dropLocationForColumn(z);
      }
      int in = 0;
      if(compLoc == null)
      {
      for(int z = 0; z < 7; z++)
      {
          if(game.Neighbors(z, currentColor) > game.Neighbors(in, currentColor))
          {
              in = z;
            }
        }
        if(game.Neighbors(in, currentColor) > 0)
        {
        compLoc = game.dropLocationForColumn(in);
    }
         if(compLoc == null)
          compLoc = game.dropLocationForColumn(gen.nextInt(7));
          }
        }
      }
    }
      if (compLoc == null)
         setMessage("Illegal drop location, try again");
      else
      {
         if (game.dropMatchesNeighbors(compLoc.getCol(), currentColor))
         {            
            setMessage("Congratulations--Red won");
            for(Piece pce:game.getWinners())
            {
                pce.setColor(Color.yellow);
            }
            gameOver = true;
         }
         if(gameOver == true)
         {
         getGrid().put(compLoc, new Piece(Color.yellow, compLoc));
        }else{
            getGrid().put(compLoc, new Piece(currentColor, compLoc));
        }
      }
      if (!gameOver) flipTurn();
    }
      return true;
   }     
}
