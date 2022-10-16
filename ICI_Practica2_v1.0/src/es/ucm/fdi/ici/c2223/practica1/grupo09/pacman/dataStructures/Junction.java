package es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.dataStructures;

import pacman.game.Constants.MOVE;

public class Junction extends Node {

	@Override
	public Integer getDistanceToNextJuction(MOVE lastMove) {
		return 0;
	}
	
	@Override
	public Node getNextJuction(MOVE lastMove) {
		return this;
	}
}
