package es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.dataStructures;

import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.exceptions.InvalidMoveException;
import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.exceptions.NodeIsNotInWayException;
import pacman.game.Constants.MOVE;

public class Position extends Node {

	private Edge edge;
	
	public Edge getEdge() {
		return this.edge;
	}
	
	@Override
	public Integer getDistanceToNextJuction(MOVE lastMove) throws InvalidMoveException {
		Way way = getWay(lastMove);
		if (way == null)
			throw new InvalidMoveException();
		Integer distance = null;
		try {
			distance = way.distanceNodeToEnd(this);
		} catch (NodeIsNotInWayException e) {
			System.out.println("------ NODE_IS_NOT_IN_WAY_EXCEPTION ------");
			e.printStackTrace();
			System.out.println("------ \\NODE_IS_NOT_IN_WAY_EXCEPTION ------");
		}
		return distance;
	}
	
	@Override
	public Node getNextJuction(MOVE lastMove) throws InvalidMoveException {
		Way way = getWay(lastMove);
		if (way == null)
			throw new InvalidMoveException();
		Node junction = way.getEndNode();
		return junction;
	}
}
