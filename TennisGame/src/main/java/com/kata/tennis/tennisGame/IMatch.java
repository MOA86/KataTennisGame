package com.kata.tennis.tennisGame;

import com.kata.tennis.beans.Player;

/**
 * @author ETP7361
 *
 */
public interface IMatch {

	/**
	 *
	 *
	 */
	public Player scorePoint();
	
	/**
	 * 
	 * 
	 */
	public Player winGame ();
	
	/**
	 * @param player1
	 * @param Player2
	 */
	public boolean isDuce ();
	
	/**
	 * @param player1
	 * @param Player2
	 */
	public boolean isAdvantage (Player player);
	
	/**
	 * @return
	 */
	public Player winSet();
	
	/**
	 *
	 *
	 */
	public Player winMatch ();
	
	/**
	 * 
	 * 
	 */
	public Player winTieBreak (Player player1, Player player2);
}
