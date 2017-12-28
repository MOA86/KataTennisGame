package com.kata.tennis.beans;

public class Player {

	/**
	 * nom du jouer
	 */
	private String name;
	
	/**
	 * score du jour en temps reel
	 */
	private int score;
	
	/**
	 * statut du jour ( vainquer, perdant, égalité)
	 */
	private String statut;
	
	/**
	 * 
	 */
	private int game;
		
	/**
	 * 
	 */
	private int set;
	
	/**
	 * constructeur par default
	 */
	public Player(){
		super();
	}
	
	/**
	 * constructeur d'un jour avec un score à 0
	 * @param name
	 */
	public Player (String name){
		this.name = name;
		this.score = 0;
		this.game = 0;
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
		if(this.game < 7){
			this.game++;
		}
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Player [name=" + name + ", score=" + score + ", statut="
				+ statut + ", game=" + game + ", set=" + set + "]";
	}

	
	

	
}
