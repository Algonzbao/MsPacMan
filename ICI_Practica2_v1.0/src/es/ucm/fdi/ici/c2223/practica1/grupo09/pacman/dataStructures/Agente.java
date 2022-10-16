package es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.dataStructures;

import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.exceptions.InvalidMoveException;
import pacman.game.Constants.MOVE;

public class Agente {

	private MOVE lastMove;
	private Node actualNode;
	
	public MOVE getLastMove() {
		return this.lastMove;
	}
	public Node getNode() {
		return this.actualNode;
	}
	
	public Integer getDistanceToNextJuction() {
		Integer distance = null;
		try {
			distance = this.actualNode.getDistanceToNextJuction(this.lastMove);
		} catch (InvalidMoveException e) {
			System.out.println("------ INVALID_MOVE_EXCEPTION ------");
			e.printStackTrace();
			System.out.println("------ \\INVALID_MOVE_EXCEPTION ------");
		}
		return distance;
	}
	
	public Node getNextJuction() {
		Node nextJunction = null;
		try {
			nextJunction = this.actualNode.getNextJuction(this.lastMove);
		} catch (InvalidMoveException e) {
			System.out.println("------ INVALID_MOVE_EXCEPTION ------");
			e.printStackTrace();
			System.out.println("------ \\INVALID_MOVE_EXCEPTION ------");
		}
		return nextJunction;
	}
	
	public Way getWay() {
		Way way = null;
		if (this.actualNode instanceof Position) {
			try {
				way = ((Position) this.actualNode).getWay(this.lastMove);
			} catch (InvalidMoveException e) {
				System.out.println("------ INVALID_MOVE_EXCEPTION ------");
				e.printStackTrace();
				System.out.println("------ \\INVALID_MOVE_EXCEPTION ------");
			}
		}
		return way;
	}
}
