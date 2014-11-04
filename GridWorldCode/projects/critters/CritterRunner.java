package projects.critters;

/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 * @author Cay Horstmann
 */

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.gui.WorldFrame;
import java.awt.Color;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JFrame;
/**
 * This class runs a world that contains critters. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class CritterRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        //ActorWorld.setGrid(new BoundedGrid<T>(100, 100));
        world.add(new Location(4, 4), new RockDropper(Color.yellow));
        world.add(new Location(5, 8), new RockDropper(Color.blue));
        world.add(new Location(4, 5), new RockDropper(Color.red));
        world.add(new Location(4, 6), new RockDropper(Color.magenta));
        world.add(new Location(5, 9), new RockEater(Color.black));
        world.add(new Location(4, 9), new RockEater(Color.black));
        world.show();
    }
}