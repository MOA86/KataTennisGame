package com.kata.tennis.beans;


/**
 * @author m.oumoula
 *
 */
public class Player {

	/**
	 * nom du joueur
	 */
	private String name;
	
	/**
	 * score du joueur en temps reel
	 */
	private int score;
	
	/**
	 * libelle du score du joueur ( )
	 */
	private String statut;
	
	/**
	 * jeux gagne 
	 */
	private int game;
		
	/**
	 * set gagne
	 */
	private int set;
	
	/**
	 * score tie break
	 */
	private int tieBreakScore;
	
	/**
	 * constructeur par default
	 */
	public Player(){
		super();
	}
	
	/**
	 * constructeur d'un joueur initialise
	 * @param name
	 */
	public Player (String name){
		this.name = name;
		this.score = 0;
		this.game = 0;
		this.tieBreakScore = 0;
		this.set = 0;
		this.statut = "Zero";
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return statut
	 */
	public String getStatut() {
		return statut;
	}

	/**
	 * @param statut
	 */
	public void setStatut(String statut) {
		this.statut = statut;
	}

	public void addScore(){
		this.score ++;
	}
	
	
	/**
	 * @return
	 */
	public int getGame() {
		return game;
	}

	/**
	 * @param game
	 */
	public void setGame(int game) {
		this.game = game;
	}

	/**
	 * 
	 */
	public void addGame(){
			this.game++;
	}
	
	/**
	 * @return
	 */
	public int getSet() {
		return set;
	}

	/**
	 * @param set
	 */
	public void setSet(int set) {
		this.set = set;
	}
	
	public void addSet(){
		this.set++;
	}

	/**
	 * @return
	 */
	public int getTieBreakScore() {
		return tieBreakScore;
	}

	/**
	 * @param tieBreakScore
	 */
	public void setTieBreakScore(int tieBreakScore) {
		this.tieBreakScore = tieBreakScore;
	}

	/**
	 * 
	 */
	public void addTieBreakScore(){
		this.tieBreakScore ++;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Player [name=" + name + ", score=" + score + ", statut="
				+ statut + ", game=" + game + ", set=" + set
				+ ", tieBreakScore=" + tieBreakScore + "]";
	}

	
	}
