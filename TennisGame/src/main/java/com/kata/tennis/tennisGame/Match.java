package com.kata.tennis.tennisGame;

import java.util.HashMap;
import java.util.Random;

import org.apache.log4j.Logger;

import com.kata.tennis.beans.Player;

/**
 * @author ETP7361
 *
 */
/**
 * @author ETP7361
 *
 */
public class Match implements IMatch {

	private static Logger logger = Logger.getLogger(Match.class);

	/**
	 * 
	 */
	private static HashMap<Integer, String> scoreMap = new HashMap<Integer, String>();
	static {
		scoreMap.put(1, "Fifteen");
		scoreMap.put(2, "Thirty");
		scoreMap.put(3, "Forty");
		scoreMap.put(4, "Deuce");
		scoreMap.put(5, "Adv");
		scoreMap.put(6, "Game");

	}
	/**
	 * 
	 */
	private Player player1;

	/**
	 * 
	 */
	private Player player2;

	/**
	 * constructeur par défault
	 */
	public Match() {
		super();
	}

	/**
	 * @param player1
	 * @param player2
	 */
	public Match(Player player1, Player player2) {

		this.player1 = player1;
		this.player2 = player2;

	}


	/* (non-Javadoc)
	 * @see com.kata.tennis.TennisGame.IMatch#scorePoint()
	 */
	@Override
	public Player scorePoint() {
		Random rand = new Random();
		if (Math.abs(rand.nextInt()) % 2 == 1) {
			if (player1.getScore() < 3) {
				player1.addScore();
				player1.setStatut(scoreMap.get(player1.getScore()));

			} else {
				if (isDuce()) {
					player1.addScore();
					player1.setStatut(scoreMap.get(player1.getScore()));
				} else if (isAdvantage(player2)) {
					player1.setScore(4);
					player1.setStatut(scoreMap.get(player1.getScore()));
					player2.setScore(4);
					player2.setStatut(scoreMap.get(player2.getScore()));
				} else {
					player1.setStatut(scoreMap.get(6));
					player1.setScore(6);
				}
			}
			logger.info(" Point :" + player1.toString());
			return player1;
		} else {
			if (player2.getScore() < 3) {
				player2.addScore();
				player2.setStatut(scoreMap.get(player2.getScore()));
			} else {
				if (isDuce()) {
					player2.addScore();
					player2.setStatut(scoreMap.get(player2.getScore()));
				} else if (isAdvantage(player1)) {
					player2.setScore(4);
					player2.setStatut(scoreMap.get(player2.getScore()));
					player1.setScore(4);
					player1.setStatut(scoreMap.get(player1.getScore()));
				} else {
					player2.setStatut(scoreMap.get(6));
					player2.setScore(6);
				}
			}
			logger.info(" Point :" + player2.toString());
			return player2;
		}

	}


	/* (non-Javadoc)
	 * @see com.kata.tennis.TennisGame.IMatch#winGame()
	 */
	@Override
	public Player winGame() {
		boolean statutGame = true;
		Player curruntPlayer = null;
		while (statutGame) {
			curruntPlayer = scorePoint();
			statutGame = !curruntPlayer.getStatut().equals(scoreMap.get(6));
		}
		curruntPlayer.addGame();
		logger.info("Game : " + curruntPlayer.toString());
		initializeScore();
		return curruntPlayer;
	}

	
	/* (non-Javadoc)
	 * @see com.kata.tennis.TennisGame.IMatch#isDuce()
	 */
	@Override
	public boolean isDuce() {

		return (player1.getScore() == player2.getScore()) ? true : false;
	}

	
	/* (non-Javadoc)
	 * @see com.kata.tennis.TennisGame.IMatch#isAdvantage(com.kata.tennis.beans.Player)
	 */
	@Override
	public boolean isAdvantage(Player player) {

		return (player.getScore() == 5) ? true : false;
	}

	
	/* (non-Javadoc)
	 * @see com.kata.tennis.TennisGame.IMatch#winSet()
	 */
	@Override
	public Player winSet() {
		Player curruntPlayer = null;
		boolean statutSet = true;
		while (statutSet) {
			curruntPlayer = winGame();
			statutSet = !(winGame().getGame() == 7);

		}
		curruntPlayer.addSet();
		logger.info("Set : " + curruntPlayer.toString());
		initializeGame();
		return curruntPlayer;
	}

	
	/* (non-Javadoc)
	 * @see com.kata.tennis.TennisGame.IMatch#winMatch()
	 */
	@Override
	public Player winMatch() {
		Player curruntPlayer = null;
		boolean statutMatch = true;

		while (statutMatch) {
			curruntPlayer = winSet();
			statutMatch =! (curruntPlayer.getSet() == 3);

		}

		return curruntPlayer;
	}


	/* (non-Javadoc)
	 * @see com.kata.tennis.TennisGame.IMatch#winTieBreak(com.kata.tennis.beans.Player, com.kata.tennis.beans.Player)
	 */
	@Override
	public Player winTieBreak(Player player1, Player player2) {
		// TODO Stub de la méthode généré automatiquement
		return null;
	}

	/**
	 * 
	 */
	private void initializeGame() {
		player1.setGame(0);
		player2.setGame(0);
	}

	/**
	 * 
	 */
	private void initializeScore() {
		player1.setScore(0);
		player2.setScore(0);
	}

	/**
	 * @return
	 */
	public Player getPlayer1() {
		return player1;
	}

	/**
	 * @param player1
	 */
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	/**
	 * @return
	 */
	public Player getPlayer2() {
		return player2;
	}

	/**
	 * @param player2
	 */
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

}
