package com.kata.tennis.tennisGame;

import java.util.HashMap;
import java.util.Random;

import org.apache.log4j.Logger;

import com.kata.tennis.beans.Player;

/**
 * @author m.oumoula
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kata.tennis.TennisGame.IMatch#scorePoint()
	 */

	public Player scorePoint() {
		// Génération d’un entier aléatoire si paire point au joueur 1 sinon
		// point au jour 2
		Random rand = new Random();
		if (Math.abs(rand.nextInt()) % 2 == 1) {
			if (player1.getScore() < 3) {
				player1.addScore();
				player1.setStatut(scoreMap.get(player1.getScore()));

			} else {
				if (isDuce()) {
					player1.setScore(5);
					player1.setStatut(scoreMap.get(player1.getScore()));
					player2.setScore(4);
					player2.setStatut(scoreMap.get(player2.getScore()));
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
			logger.info(" Point : " + player1.getName() + " score :  "
					+ player1.getStatut() + " / " + player2.getName()
					+ " score :  " + player2.getStatut());
			return player1;
		} else {
			if (player2.getScore() < 3) {
				player2.addScore();
				player2.setStatut(scoreMap.get(player2.getScore()));
			} else {
				if (isDuce()) {
					player2.setScore(5);
					player2.setStatut(scoreMap.get(player2.getScore()));
					player1.setScore(4);
					player1.setStatut(scoreMap.get(player1.getScore()));
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
			logger.info(" Point : " + player1.getName() + " score :  "
					+ player1.getStatut() + " / " + player2.getName()
					+ " score :  " + player2.getStatut());
			return player2;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kata.tennis.TennisGame.IMatch#winGame()
	 */

	public Player winGame() {
		boolean statutGame = true;
		Player CurrentPlayer = null;
		while (statutGame) {
			CurrentPlayer = scorePoint();
			statutGame = !CurrentPlayer.getStatut().equals(scoreMap.get(6));
		}
		CurrentPlayer.addGame();
		logger.info("Game : " + CurrentPlayer.getName() + " statut : "
				+ CurrentPlayer.getStatut() + " game : "
				+ CurrentPlayer.getGame());
		initializeScore();
		return CurrentPlayer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kata.tennis.TennisGame.IMatch#isDuce()
	 */

	public boolean isDuce() {

		return (player1.getScore() == player2.getScore()) ? true : false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kata.tennis.TennisGame.IMatch#isAdvantage(com.kata.tennis.beans.Player
	 * )
	 */

	public boolean isAdvantage(Player player) {

		return (player.getScore() == 5) ? true : false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kata.tennis.TennisGame.IMatch#winSet()
	 */

	public Player winSet() {
		Player CurrentPlayer = null;
		boolean statutSet = true;
		while (statutSet) {
			CurrentPlayer = winGame();
			statutSet = !(CurrentPlayer.getGame() == 6) && !isTieBreak();

		}
		CurrentPlayer.addSet();
		// si tie break
		if (isTieBreak())
			CurrentPlayer = winTieBreak();
		logger.info("Set : " + CurrentPlayer.getName() + " statut : "
				+ CurrentPlayer.getStatut() + " game : "
				+ CurrentPlayer.getGame() + " set :" + CurrentPlayer.getSet());
		initializeGame();
		return CurrentPlayer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kata.tennis.TennisGame.IMatch#winMatch()
	 */

	public Player winMatch() {
		Player CurrentPlayer = null;
		boolean statutMatch = true;

		while (statutMatch) {
			CurrentPlayer = winSet();
			statutMatch = !(CurrentPlayer.getSet() == 3);

		}
		logger.info("Match winner : " + CurrentPlayer.getName());
		return CurrentPlayer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kata.tennis.tennisGame.IMatch#winTieBreak()
	 */
	public Player winTieBreak() {
		logger.info("Tie break rules : ");
		boolean endTieBreak = true;
		Player currentPlayer = null;
		while (endTieBreak) {
			Random rand = new Random();
			if (Math.abs(rand.nextInt()) % 2 == 1) {
				player1.addTieBreakScore();
				endTieBreak = !(Math.abs(player1.getTieBreakScore()
						- player2.getTieBreakScore()) == 2 && player1
						.getTieBreakScore() >= 7);
				currentPlayer = player1;
			} else {
				player2.addTieBreakScore();
				endTieBreak = !(Math.abs(player1.getTieBreakScore()
						- player2.getTieBreakScore()) == 2 && player2
						.getTieBreakScore() >= 7);
				currentPlayer = player2;
			}
		}
		currentPlayer.addGame();
		logger.info("Tie break winner : " + currentPlayer.getName()); 
		logger.info("Tie break score : " + player1.getName() + " score : "+player1.getTieBreakScore() );
		return currentPlayer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kata.tennis.tennisGame.IMatch#isTieBreak()
	 */
	public boolean isTieBreak() {

		return (player1.getGame() == 6 && player2.getGame() == 6) ? true
				: false;
	}

	/**
	 * 
	 */
	public void start() {
		winMatch();
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
		player1.setStatut("Zero");
		player2.setStatut("Zero");
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
