package com.kata.tennis.tennisGame;

import com.kata.tennis.beans.Player;


/**
 * @author m.oumoula
 *
 */
public interface IMatch {

	/**
	 * @return
	 *
	 */
	public Player scorePoint();
	
	/**
	 *  @return
	 */
	public Player winGame ();
	
	/**
	 *  @return
	 */
	public boolean isDuce ();
	
	/**
	 *  @return
	 */
	public boolean isAdvantage (Player player);
	
	/**
	 * @return
	 */
	public Player winSet();
	
	/**
	 * @return
	 */
	public Player winMatch ();
	
	/**
	 *  @return
	 */
	public Player winTieBreak ();
	
	/**
	 * @return
	 */
	public boolean isTieBreak();
}
