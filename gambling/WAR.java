
/**
 * Write a description of class WAR here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.Random;
import java.lang.String;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import java.io.*;
import java.awt.event.*;
 import java.lang.*;

import javax.swing.JPanel;

public class WAR
{
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        Deck d = new Deck();
        d.shuffle();
        ArrayList<Card> a = new ArrayList<Card>();
        ArrayList<Card> b = new ArrayList<Card>();
        for(int i = 0; i < 26; i++)
        {
            a.add(d.removeCard());
        }
        for(int i = 0; i < 26; i++)
        {
            b.add(d.removeCard());
        }
        for(int i = 0; i < 10; i++)
        {
            run();
            sc.nextLine();
        }
        
        
    }
    public static void run()
    {
         
    }
    /*public static class keyPress implements KeyListener
    {
        public keyPress(){
        addKeyListener(this);
    }
        public void keyPressed(KeyEvent event)
        {
            run();
        }
        public void keyTyped(KeyEvent event){}
        public void keyReleased(KeyEvent event){}
    }*/
}
