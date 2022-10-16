package es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.dataStructures;

import pacman.game.Constants.MOVE;

public class GameTransition {
	
	private Integer time;
	private MOVE pacmanMove;
	
	public GameTransition(Integer time, MOVE pacmanMove) {
		this.time = time;
		this.pacmanMove = pacmanMove;
	}
	
	public Integer getTime() {
		return this.time;
	}
	public MOVE getPacmanMove() {
		return this.pacmanMove;
	}
}
