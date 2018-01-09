package com.kata.tennis.tennisGame;

import com.kata.tennis.beans.Player;
import com.kata.tennis.tennisGame.IMatch;
import com.kata.tennis.tennisGame.Match;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



/**
 * Unit test for simple App.
 */
public class AppTest {
    
	/**
	 * 
	 */
	public Player player1;
	
	/**
	 * 
	 */
	public Player player2;
	
	/**
	 * 
	 */
	public IMatch match;
	
	
	/**
	 * 
	 */
	@Before
	public void initializePlayer (){
		
		player1 = new Player("Federer");
		player2 = new Player("Nadal");
		match   = new Match(player1,player2);
	}
	
	@After
	public void endMatch(){
		
	}
	

	/**
	 * 
	 */
	@Test
	public void testScorePoint(){
		player1.setScore(0);
		player2.setScore(0);
		match.scorePoint();
		player1.setScore(3);
		player2.setScore(3);
		match.scorePoint();
		player1.setScore(4);
		player2.setScore(5);
		match.scorePoint();
				
	}
	
	/**
	 * 
	 */
	@Test
	public void testWinGame(){
		
		match.winGame();
	}
	
	 /**
	 * 
	 */
	@Test
	 public void testSet(){
		 match.winSet();
	 }
	
	/**
	 * 
	 */
	@Test
	public void testWinMatch(){
		match.winMatch();
		
	}
		
	/**
	 * 
	 */
	@Test
	public void testwinTieBreak(){
		player1.setGame(6);
		player2.setGame(6);
		match.winTieBreak();
	}
	
	/**
	 * 
	 */
	@Test
	public void isAdvantage(){
		match.isAdvantage(player1);
	}
	
	/**
	 * 
	 */
	@Test
	public void isDuce(){
		match.isDuce();
	}
	
}
 
