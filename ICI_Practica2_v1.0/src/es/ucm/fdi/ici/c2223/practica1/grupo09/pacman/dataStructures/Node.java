package es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.dataStructures;

import java.util.Map;
import java.util.Set;

import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.exceptions.InvalidMoveException;
import pacman.game.Constants.MOVE;

public abstract class Node {

	private Integer id;
	private Map<MOVE, Way> ways;
	
	public Way getWay(MOVE lastMove) throws InvalidMoveException {
		if (!ways.keySet().contains(lastMove))
			throw new InvalidMoveException();
		return ways.get(lastMove);
	}
	
	public abstract Integer getDistanceToNextJuction(MOVE lastMove) throws InvalidMoveException;
	
	public abstract Node getNextJuction(MOVE lastMove) throws InvalidMoveException;

	public int getId() {
		return id;
	}

	public Set<MOVE> getMoves() {
		return ways.keySet();
	}
}
