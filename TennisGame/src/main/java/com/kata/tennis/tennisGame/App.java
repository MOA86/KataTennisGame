package com.kata.tennis.tennisGame;

import com.kata.tennis.beans.Player;

/**
 * @author m.oumoula
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	new Match(new Player("Federer"), new Player("Nadal")).start();
           
    }
}
